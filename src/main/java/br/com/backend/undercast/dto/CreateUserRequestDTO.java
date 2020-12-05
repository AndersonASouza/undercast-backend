package br.com.backend.undercast.dto;

import br.com.backend.undercast.model.User;

import javax.validation.constraints.NotNull;

public class CreateUserRequestDTO {

    @NotNull
    String email;

    @NotNull
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
