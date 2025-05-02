package com.jsp.ecommerce1.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.jsp.ecommerce1.dto.UserDto;

import jakarta.servlet.http.HttpSession;


public interface AdminService {

	String register(UserDto userDto, Model model);

	String register(UserDto userDto, BindingResult result, HttpSession session);

	String sumbitOtp(int otp, HttpSession session);

}
