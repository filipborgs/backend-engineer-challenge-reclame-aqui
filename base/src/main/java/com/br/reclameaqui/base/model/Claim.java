package com.br.reclameaqui.base.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Document(collection = "claim")
public class Claim {

    @Id
    private String id;
    @NotNull(message = "O título deve ser inserido")
    private String title;
    private Date createdAt;
    @NotNull(message = "A descrição deve ser inserida")
    private String description;
    @NotNull(message = "O Endereço é obrigatório")
    @Valid
    private Address address;
    @NotNull(message = "O consumidor é obrigatório")
    @Valid
    private Consumer consumer;
    @NotNull(message = "A empresa é obrigatório")
    @Valid
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
