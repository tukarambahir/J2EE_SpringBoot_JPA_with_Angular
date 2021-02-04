package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.SendEmail;

@RestController
@CrossOrigin
@RequestMapping("/email")
public class EmailController {

@Autowired
private JavaMailSender sender;

@PostMapping("/sendMail")
public ResponseEntity<?> processForm(@RequestBody SendEmail em,BindingResult res)
{
System.out.println(em.getDestEmail()+" "+em.getMessage());

SimpleMailMessage mesg=new SimpleMailMessage();
mesg.setTo(em.getDestEmail());
mesg.setSubject(em.getSubject());
mesg.setText(em.getMessage());
sender.send(mesg);
return new ResponseEntity<>(em, HttpStatus.OK);
}

} 
