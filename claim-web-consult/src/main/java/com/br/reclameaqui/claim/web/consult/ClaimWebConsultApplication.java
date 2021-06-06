package com.br.reclameaqui.claim.web.consult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.br.reclameaqui")
@EnableMongoRepositories(basePackages = "com.br.reclameaqui")
@EntityScan(basePackages = "com.br.reclameaqui")
public class ClaimWebConsultApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClaimWebConsultApplication.class, args);
    }

}