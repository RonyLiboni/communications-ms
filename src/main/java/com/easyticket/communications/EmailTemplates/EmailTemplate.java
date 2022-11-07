package com.easyticket.communications.EmailTemplates;

import lombok.Getter;

@Getter
public enum EmailTemplate {
	
	NEW_RECOVERY_TOKEN("\n You asked to change your password in Spring Security JWT Token service!",
					  "Hi, you have asked to change your password. \n "
					+ "Please send a PUT request to http://localhost:8080/security-ms/all/v1/user/forgotMyPassword/ . \n "
					+ "You have to send the token and the new password in a request body. "
					+ "The token will expire in 30 minutes: \n "
					+ "Token: %s "
					+"\n This e-mail is from the app you are testing. \n"
					+ "https://github.com/RonyLiboni/spring-security-using-token-jwt-without-WebSecurityConfigurerAdapter.git");

	private final String body;
	private final String subject;
	
	EmailTemplate (String subject , String body) {
		this.body = body;
		this.subject = subject;
	}
	
}
