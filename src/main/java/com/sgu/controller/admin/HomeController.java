package com.sgu.controller.admin;

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
import com.sgu.service.UserService;
import com.sgu.service.impl.UserSeviceImpl;


@WebServlet(urlPatterns = { "/addashboard", "/adlogin","/adlogout" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 4831006733887366260L;
	private UserService userService = new UserSeviceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pathString = req.getServletPath();
		HttpSession session = req.getSession();
		switch (pathString) {
		case "/addashboard":
			doGetDashboard(req, resp);
			break;
		case "/adlogin":
			doGetLogin(req, resp);
			break;
		case "/adlogout":
			doGetLogout(session, req, resp);
			break;

		default:
			break;
		}
		

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pathString = req.getServletPath();
		switch (pathString) {
		case "/adlogin":
			doPostLogin(session,req, resp);
			break;
		default:
			break;
		}
	}
	private void doGetDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/dashboard.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/login.jsp");
		requestDispatcher.forward(req, resp);
	}

	private void doGetLogout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		session.removeAttribute(SessionAttribute.CURRENT_ADMIN);
		resp.sendRedirect("adlogin");
	}
	private void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = userService.login(username, password);
		if(user != null && user.getRole()== 0 || user.getRole() == 1)
		{
			session.setAttribute(SessionAttribute.CURRENT_ADMIN, user);
			resp.sendRedirect("addashboard");
		}else {
			resp.sendRedirect("adlogin");
		}
	}


}
