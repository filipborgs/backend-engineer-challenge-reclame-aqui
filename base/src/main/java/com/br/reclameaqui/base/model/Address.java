package com.br.reclameaqui.base.model;

import javax.validation.constraints.NotNull;

public class Address {

    private String street;
    @NotNull(message = "Uma cidade deve ser informada")
    private String city;
    private String cep;
    @NotNull(message = "Um estado deve ser informado")
    private String uf;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf.toUpperCase();
    }

}
