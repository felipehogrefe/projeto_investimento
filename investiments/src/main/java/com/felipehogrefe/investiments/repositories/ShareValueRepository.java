package com.felipehogrefe.investiments.repositories;

import com.felipehogrefe.investiments.entities.ShareValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ShareValueRepository extends JpaRepository<ShareValue, Long> {

    ShareValue getByDate(Date date);
}
