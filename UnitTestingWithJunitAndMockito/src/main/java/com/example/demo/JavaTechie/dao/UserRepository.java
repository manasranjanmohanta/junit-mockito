package com.example.demo.JavaTechie.dao;

import com.example.demo.JavaTechie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User AS u WHERE u.address =: address")
    List<User> findByAddress(String address);
}
