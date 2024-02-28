package com.sgu.service;

import javax.servlet.ServletContext;

import com.sgu.entity.User;

public interface EmailService {
void sendMail(ServletContext context, User recipient, String type);
}
