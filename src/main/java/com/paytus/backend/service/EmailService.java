package com.paytus.backend.service;

import com.paytus.backend.dto.FaqDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender emailSender;

    public void sendSimpleMessage(FaqDTO faqDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("paytusintern@gmail.com");
        message.setTo(faqDto.getFaqarea());
        message.setSubject(faqDto.getFaqname());
        message.setText(faqDto.getFaqtext());
        message.setSentDate(faqDto.getFaqdate());
        emailSender.send(message);
    }
}