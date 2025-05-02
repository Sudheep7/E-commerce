package com.jsp.ecommerce1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerce1.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	boolean existsByEmail(String email);

}
