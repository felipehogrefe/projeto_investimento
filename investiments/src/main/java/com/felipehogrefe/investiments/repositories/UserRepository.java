package com.felipehogrefe.investiments.repositories;

import com.felipehogrefe.investiments.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
