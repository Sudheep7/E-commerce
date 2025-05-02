package com.jsp.ecommerce1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerce1.entity.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

	boolean existsByEmail(String email);

}
