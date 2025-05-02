package com.jsp.ecommerce1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerce1.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	boolean existsByEmail(String email);

}
