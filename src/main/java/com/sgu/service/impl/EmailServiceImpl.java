package com.sgu.service.impl;

import javax.servlet.ServletContext;

import com.sgu.entity.User;
import com.sgu.service.EmailService;
import com.sgu.util.SendEmailUtil;

public class EmailServiceImpl implements EmailService{

	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to Thong Tran Shop";
	private static final String EMAIL_FORGOT_PASSWORD = "Thong Tran Shop - New password";
	private static final String EMAIL_CONFIRM_ORDER = "Thong Tran Shop - Confirm Order";
	@Override
	public void sendMail(ServletContext context, User recipient, String type) {
        String host = context.getInitParameter("host");
        String port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");
	try {
		String content = null;
		String subject = null;
		switch (type) {
		case "welcome":
			subject = EMAIL_WELCOME_SUBJECT;
			content = "Xin chào, " + recipient.getFullName() +", cảm ơn vì đã đăng ký dịch vụ của chúng tui, iu !";
			break;
		case "forgot":
			subject = EMAIL_FORGOT_PASSWORD;
			content = "Xin chào, " + recipient.getFullName() +", mật khẩu của bạn là: "+ recipient.getPassword();
			break;
		default:
			subject = EMAIL_CONFIRM_ORDER;
			content = type;
			break;
		}
		SendEmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	

}
