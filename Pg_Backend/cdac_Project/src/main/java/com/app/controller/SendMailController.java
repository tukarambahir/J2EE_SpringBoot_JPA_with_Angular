package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Email;

@RestController
@CrossOrigin
@RequestMapping("/email")

public class SendMailController {
	@Autowired
	private JavaMailSender sender;
	@PostConstruct
	public void init()
	{
		System.out.println("in init "+sender);
	}
	
	@GetMapping("/send_mail")
	public String showForm(Email e)
	{
	System.out.println("show form");
		return "/email/send_mail";
	}
	@PostMapping("/send_mail")
	public String processForm(@RequestBody Email em,BindingResult res)
	{
		System.out.println(em.getDestEmail()+"  "+em.getMessage());
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(em.getDestEmail());
		
		mesg.setSubject(em.getSubject());
		mesg.setText(em.getMessage());
		System.out.println(mesg.getText());
		sender.send(mesg);
		return "/email/sent-mail";
	}

}
