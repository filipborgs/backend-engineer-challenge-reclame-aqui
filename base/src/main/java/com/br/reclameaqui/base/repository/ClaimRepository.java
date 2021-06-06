package com.br.reclameaqui.base.repository;

import com.br.reclameaqui.base.model.Claim;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClaimRepository extends MongoRepository<Claim, String> {
    @Query("{'address.uf': '?0'}")
    public List<Claim> findByUf(String uf);
}
