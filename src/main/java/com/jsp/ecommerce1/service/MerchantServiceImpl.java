package com.jsp.ecommerce1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.jsp.ecommerce1.dto.UserDto;
import com.jsp.ecommerce1.repository.AdminRepository;
import com.jsp.ecommerce1.repository.CustomerRepository;
import com.jsp.ecommerce1.repository.MerchantRepository;

@Service

public class MerchantServiceImpl implements MerchantService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MerchantRepository merchantRepository;


	@Override
	public String register(UserDto userDto, Model model) {
		model.addAttribute("UserDto", userDto);
		return "merchant-register.html";
	}

	@Override
	public String register(UserDto userDto, BindingResult result) {
		if(!userDto.getConfirmPassword().equals(userDto.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "error.confrimPassword", "* Password and Confirm password not matching");
		}
		
		if(adminRepository.existsByEmail(userDto.getEmail()) || customerRepository.existsByEmail(userDto.getEmail()) || merchantRepository.existsByEmail(userDto.getEmail())) {
			result.rejectValue("email", "error.email", "*Email Already Exists");
		}
		
		if(result.hasErrors()) {
			return "merchant-register.html";
		}
		
		return "redirect:/";

  }
}
