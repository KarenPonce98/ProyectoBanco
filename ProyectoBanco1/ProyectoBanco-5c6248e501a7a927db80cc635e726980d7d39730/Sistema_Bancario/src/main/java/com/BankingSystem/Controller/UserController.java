package com.BankingSystem.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.BankingSystem.Models.Titular;
import com.BankingSystem.Models.Transaction;
import com.BankingSystem.Models.User;
import com.BankingSystem.Repository.ITitular;
import com.BankingSystem.Repository.TransectionRepository;
import com.BankingSystem.Repository.UserRepository;
import com.BankingSystem.ServiceInterface.ITitularService;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;
	ITitular titular;
	private ITitularService service;

	@Autowired
	TransectionRepository transactionRepo;
	
	@GetMapping({"/home","/index","/"})
	public String Home() {
		return "Index";
	}

	@GetMapping("/crearcuenta")
	public String crearcuenta() {
		return "Form";
	}
	
	// Get List of All Coustomers.
	@GetMapping(value = "SBS/customers")
	public String getTitular(Model model) {
		model.addAttribute("allUser", service.listar());
		return "Customers";
	}

	//Send Money Form Model.
		@GetMapping("SBS/SendMoney")
		public String sendMoneyFrm(Model model) {
			Transaction transection = new Transaction();
			model.addAttribute("trns", transection);
			return "sendMoney";
		}
		
	
//Get Coustomer By ID and Forward to Send Money Page.
	@GetMapping("/SBS/customer/transferMoney/{id}")
	public String getUserById(@PathVariable(value = "id") int id, Model model) {
		Optional<User> optional = userRepo.findById(id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
			model.addAttribute("userById", user);
			
		} else {
			throw new RuntimeException("Customer not found for this Id No:" + id);
		}
		
		return "transferMoney";
	}

	
	
//Send Money By ID Method.
	@RequestMapping(path = "/send",method = RequestMethod.POST)
	public String send(@RequestParam("senderActNo")String senderActNo,@RequestParam("recipientActNo") String recipientActNo,@RequestParam("amount") double amount ,Model model, RedirectAttributes redirectAttributes) {
    
    double amt = amount;
    Optional<User> userSender = userRepo.findByaccountNumber(senderActNo);
    Optional<User> userReceiver = userRepo.findByaccountNumber(recipientActNo);
    if(userSender.isPresent() && userReceiver.isPresent()) {
    	 Transaction trans = new Transaction();
    	    trans.setAmount(amt);
    	    trans.setSendTo(recipientActNo);
    	    trans.setSendBy(senderActNo);
    	    if(sendMoneyHelper(userSender.get(),userReceiver.get(),amt,trans)) {
    	           redirectAttributes.addFlashAttribute("message", "Transfer Success.");
    	           redirectAttributes.addFlashAttribute("alertClass", "alert-success");
    	    }else {
    	    	redirectAttributes.addFlashAttribute("message", "Transfer failed please check the amount.");
    	        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
    	    }
    }else {
    	redirectAttributes.addFlashAttribute("message","Please check the account number & amount.");
    	redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
    	
    }
   
    return "redirect:SBS/customer/transferMoney/"+userSender.get().getId();
    
	}

	//helper Method
	public boolean sendMoneyHelper(User senderAct,User recipientAct,double amount,Transaction trans) {
		boolean flag = false;
		   
		    if(senderAct.getBalance() > amount && amount > 0.0 && senderAct.getAccountNumber() != recipientAct.getAccountNumber() ) {
		    	trans.setStatus("Success");
		    	trans.setSendOn(new Date());
		    	transactionRepo.save(trans);
		    	double addRecivedAmt = recipientAct.getBalance();
		    	addRecivedAmt  = addRecivedAmt + amount;
		    	recipientAct.setBalance(addRecivedAmt);
		    	userRepo.save(recipientAct);
		    	
		    	double subAmt = senderAct.getBalance();
		    	subAmt = subAmt - amount;
		    	senderAct.setBalance(subAmt);
		    	userRepo.save(senderAct);
		    	flag = true;
		    	
		    	
		    }else {
		    	//System.out.println("Low Balance of this account"+userSender.getUserName());
		    	trans.setStatus("failed");
		    	trans.setSendOn(new Date());
		    	transactionRepo.save(trans);
		    	flag = false;
		    }
		
		return flag;
	}

	//Add Sended Money Details to database.
	@PostMapping("/transfer")
	public String transfer(@ModelAttribute Transaction trans,Model model,RedirectAttributes redirectAttributes) {
	    double amount = trans.getAmount();
	    
	    Optional<User> userSender = userRepo.findByaccountNumber(trans.getSendBy());
	    Optional<User> userReceiver = userRepo.findByaccountNumber(trans.getSendTo());
	    if(userSender.isPresent() && userReceiver.isPresent()) {
	    	 if(sendMoneyHelper(userSender.get(),userReceiver.get(),amount,trans)) {
	 	    	redirectAttributes.addFlashAttribute("message", "Transfer Success.");
	 	        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	 	    }else {
	 	    	redirectAttributes.addFlashAttribute("message", "Transfer failed please check the amount.");
	 	        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	 	    }
	    }else {
	    	redirectAttributes.addFlashAttribute("message","Please check the account number.");
	    	redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	    }
	   
	    
	    return "redirect:/SBS/SendMoney";
		
	}
	
//List of transections.
	@GetMapping("SBS/transactions")
	public String getTransections(Model model) {
		List<Transaction> trns = transactionRepo.findAll();
		model.addAttribute("trns",trns);
		return "Transactions";
	}

}
