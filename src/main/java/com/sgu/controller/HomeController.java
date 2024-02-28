package com.sgu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.sgu.constant.SessionAttribute;
import com.sgu.entity.User;


@WebServlet(urlPatterns = { "/index", "/about","/blog","/contact" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 4831006733887366260L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathString = req.getServletPath();
		String href= "";
		switch (pathString) {
		case "/index":
			href="/views/user/index.jsp";
			break;
		case "/blog":
			href="/views/user/static/blog.jsp";
			break;
		case "/about":
			href="/views/user/static/about.jsp";
			break;
		case "/contact":
			href="/views/user/static/contact.jsp";
			break;
		default:
			break;
		}
		req.getRequestDispatcher(href).forward(req, resp);

	}

}
