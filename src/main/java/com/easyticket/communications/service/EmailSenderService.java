package com.easyticket.communications.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.easyticket.communications.EmailTemplates.EmailTemplate;
import com.easyticket.communications.dto.UserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailSenderService {
	
	private final JavaMailSender emailSender;
	
	public void sendEmail(String destinatario, String text, String subject) {
		SimpleMailMessage message= new SimpleMailMessage();
		message.setTo(destinatario);
		message.setText(text);
		message.setSubject(subject);
		
		emailSender.send(message);
	}
	
	@RabbitListener(queues = "communication.password-recovery-token")
	public void newRecoveryTokenCreated(@Payload UserDto messageToBeSent) {
		sendEmail(messageToBeSent.getUsername(),
				  String.format(EmailTemplate.NEW_RECOVERY_TOKEN.getBody(), messageToBeSent.getPasswordRecoveryToken()),
				  EmailTemplate.NEW_RECOVERY_TOKEN.getSubject());
	}
	
	
}
