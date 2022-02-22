package com.BankingSystem;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //URL PERMITIDAS POR TODOS LOS USUARIOS
        http.authorizeRequests().antMatchers("/index","/home","/","/css/**","/image/**").permitAll()

        .antMatchers("SBS/customers").hasAnyRole("USER")
        .antMatchers("/crearcuenta").hasAnyRole("ADMIN")
        .antMatchers("SBS/SendMoney").hasAnyRole("ADMIN")
        .antMatchers("/SBS/customer/transferMoney/{id}").hasAnyRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().permitAll()
        .and()
        .logout().permitAll();
        
    }

    @Autowired
    public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(passEncoder)
        .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")

        //SELECT * FROM alumnos WHERE  Nombres = 'Raul' SELECT u.username, r.rol FROM roles r INNER JOIN users u ON r.user id=u.id WHERE u.username=?;
        .authoritiesByUsernameQuery("SELECT u.username, r.rol FROM roles r INNER JOIN users u ON r.user_id=u.id WHERE u.username=?");

       
                                    
                                    
    }
    
}
