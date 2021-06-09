package com.br.reclameaqui.base.model;

import javax.validation.constraints.NotNull;

public class Company {
    @NotNull(message = "O nome deve ser inserido")
    private String name;
    private String category;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
