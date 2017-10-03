package com.nab.mayco.service;

import com.nab.mayco.model.Mail;

public interface MailService {

  // send Simple Message
  public boolean send(Mail mailObject);
}
