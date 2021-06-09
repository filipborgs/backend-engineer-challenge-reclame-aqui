package com.br.reclameaqui.claim.web.consult.service;

import com.br.reclameaqui.base.exception.NotFoundException;
import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.base.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimConsultService implements ClaimConsultServiceInterface {

    @Autowired
    private ClaimRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Criteria criteria;

    @Override
    public List<Claim> all() {
        return repository.findAll();
    }

    @Override
    public Claim findById(String id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Reclamação"));
    }

    @Override
    public List<Claim> findByUf(String uf) {
        if (uf == null || uf.length() != 2)
            return new ArrayList<>();
        return repository.findByUf(uf.toUpperCase());
    }

    @Override
    public List<Claim> findByConsumer(String idUser) {
        return repository.findByIdConsumer(idUser);
    }

    @Override
    public ClaimConsultService search(String search) {
        search = search == null ? "" : search;
        criteria = Criteria.where("title").regex(search, "i");
        return this;
    }

    @Override
    public ClaimConsultService addCompany(String company) {
        if (company != null)
            criteria.and("company.name").is(company);
        return this;
    }

    @Override
    public ClaimConsultService addUf(String uf) {
        if (uf != null && uf.length() == 2)
            criteria.and("address.uf").is(uf.toUpperCase());
        return this;
    }

    @Override
    public ClaimConsultService addCity(String city) {
        if (city != null)
            criteria.and("address.city").is(city);
        return this;
    }

    @Override
    public ClaimConsultService addStreet(String street) {
        if (street != null)
            criteria.and("address.street").is(street);
        return this;
    }

    @Override
    public ClaimConsultService addConsumer(String consumer) {
        if (consumer != null)
            criteria.and("consumer.name").is(consumer);
        return this;
    }

    @Override
    public List<Claim> makeSearch() {
        Query q = new Query();
        q.addCriteria(this.criteria);
        return mongoTemplate.find(q, Claim.class);
    }

}
