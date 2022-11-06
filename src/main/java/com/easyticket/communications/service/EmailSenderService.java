package com.easyticket.communications.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import com.easyticket.communications.dto.PasswordRecoveryMessageDto;
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
	public void newRecoveryTokenCreated(@Payload PasswordRecoveryMessageDto passwordRecoveryMessageDto) {
		sendEmail(passwordRecoveryMessageDto.getRecipient(),
				  passwordRecoveryMessageDto.getText(),
				  passwordRecoveryMessageDto.getSubject());
	}
}
