package com.nab.mayco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nab.mayco.model.Mail;

@Service
public class MailServiceImpl implements MailService {


  @Autowired
  public JavaMailSender emailSender;

  @Override
  public boolean send(Mail mailObject) {
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(mailObject.getTo());
      message.setSubject(mailObject.getSubject());
      message.setText(mailObject.getText());
      emailSender.send(message);
      return true;
    } catch (MailException exception) {
      exception.printStackTrace();
      return false;
    }
  }
}
