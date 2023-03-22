package com.example.restservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/jpa")
public interface UserRepository extends JpaRepository<User, Integer> {
}
