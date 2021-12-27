package com.felipehogrefe.investiments.repositories;

import com.felipehogrefe.investiments.entities.Share;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<Share, Long> {
}
