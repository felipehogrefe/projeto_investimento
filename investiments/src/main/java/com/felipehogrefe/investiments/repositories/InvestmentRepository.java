package com.felipehogrefe.investiments.repositories;

import com.felipehogrefe.investiments.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
}
