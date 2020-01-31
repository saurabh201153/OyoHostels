package com.oyohostels.oyohostels.domain;

import javax.validation.constraints.Email;

public class Login {
    @Email
    private String email;
    private String password;

    public Login(@Email String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Login() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
