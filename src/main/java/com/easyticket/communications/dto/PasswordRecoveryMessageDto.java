package com.easyticket.communications.dto;

import lombok.Getter;

@Getter
public class PasswordRecoveryMessageDto {
	
	private String recipient;
	private String text;
	private String subject;
	
}
