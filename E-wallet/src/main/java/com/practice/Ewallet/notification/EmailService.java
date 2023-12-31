package com.practice.Ewallet.notification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    SimpleMailMessage simpleMailMessage;

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = {"email"}, groupId = "test123")
    public void send(String req) throws JsonProcessingException {
        EmailRequest email = objectMapper.readValue(req,EmailRequest.class);
        simpleMailMessage.setText(email.getMessage());
        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setSubject("Transaction Report");
        simpleMailMessage.setFrom("mukesh.lncts.cse@gmail.com");
        javaMailSender.send(simpleMailMessage);
    }

}
