package com.felipehogrefe.investiments.resources;

import com.felipehogrefe.investiments.entities.Investment;
import com.felipehogrefe.investiments.repositories.InvestmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/investments")
public class InvestmentResource {
    private static Logger logger = LoggerFactory.getLogger(InvestmentResource.class);

    @Autowired
    private InvestmentRepository investmentRepository;

    @GetMapping
    public ResponseEntity<List<Investment>> findAll(){
        return ResponseEntity.ok(investmentRepository.findAll());
    }
}
