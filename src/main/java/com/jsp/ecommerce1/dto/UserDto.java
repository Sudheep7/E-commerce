package com.jsp.ecommerce1.dto;



import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	@Size(min=5,max=15,message="* Name Should be 5~15 characters")
	private String name;
	
	@NotEmpty(message="Email is required")
	@Email(message="check email format")
	private String email;
	
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",message = "* Password should contain atleast 8 charecter, one uppercase, one lowercase, one number and one special charecter")
	private String password;
	
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",message = "* Password should contain atleast 8 charecter, one uppercase, one lowercase, one number and one special charecter")
	private String confirmPassword;
	
	@AssertTrue(message="*Check the rems and condition to processed furthuer")
	private boolean terms;
}
