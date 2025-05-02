package com.jsp.ecommerce1.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.jsp.ecommerce1.dto.OrderStatus;
import com.jsp.ecommerce1.dto.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Double totalAmount;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentStatus paymentStatus;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OrderStatus orderStatus;
	@CreationTimestamp
	private LocalDateTime creationTime;

	@ManyToOne
	private Customer customer;
}
