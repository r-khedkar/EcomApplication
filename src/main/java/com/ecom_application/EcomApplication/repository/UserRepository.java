package com.ecom_application.EcomApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom_application.EcomApplication.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
