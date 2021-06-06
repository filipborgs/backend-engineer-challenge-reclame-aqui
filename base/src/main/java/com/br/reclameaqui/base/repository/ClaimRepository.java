package com.br.reclameaqui.base.repository;

import com.br.reclameaqui.base.model.Claim;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaimRepository extends MongoRepository<Claim, String>{
    
}
