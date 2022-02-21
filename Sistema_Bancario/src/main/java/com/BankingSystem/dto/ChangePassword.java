package com.BankingSystem.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Luiis
 */
public class ChangePassword {

    @NotNull
    private Long id;
    @NotBlank(message = "La contraseña actual no debe estar en blanco")
    private String currentPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @NotBlank(message = "La nueva contraseña no debe estar en blanco")
    private String newPassword;

    @NotBlank(message = "Confirmar contraseña no debe estar en blanco")
    private String confirmPassword;

    public ChangePassword() {
    }

    public ChangePassword(Long id) {
        this.id = id;
    }

}
