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
    @NotNull(message = "O t�tulo deve ser inserido")
    private String title;
    @NotNull(message = "O nome deve ser inserido")
    private String person;
    private Date createdAt;
    @NotNull(message = "A descriç�o deve ser inserida")
    private String description;
    @NotNull(message = "O Endereço � obrigat�rio")
    @Valid
    private Address address;

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

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
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
