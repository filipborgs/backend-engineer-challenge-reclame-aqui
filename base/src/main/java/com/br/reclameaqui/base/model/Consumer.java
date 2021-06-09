package com.br.reclameaqui.base.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Consumer {
    @NotNull(message = "O nome deve ser inserido")
    private String name;
    @Email(message = "Email inválido")
    private String email;

    public Consumer() {
    }

    public Consumer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
