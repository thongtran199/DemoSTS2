package com.sgu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sgu.constant.SessionAttribute;
import com.sgu.entity.User;

public class CustomerLogin implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;

	    HttpSession session = httpRequest.getSession();
	    User user = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
	   
	    if (user==null) {
	        httpResponse.sendRedirect("login");
	    } else {
	        chain.doFilter(request, response);
	    }
		
	}

	
}
