package com.easyticket.communications.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
	
	private String username;
	private String passwordRecoveryToken;
	
}
