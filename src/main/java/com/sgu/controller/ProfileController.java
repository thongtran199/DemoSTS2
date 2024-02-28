package com.sgu.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sgu.constant.SessionAttribute;




import com.sgu.entity.User;


import com.sgu.service.UserService;


import com.sgu.service.impl.UserSeviceImpl;



@MultipartConfig
@WebServlet(urlPatterns = { "/profile" })
public class ProfileController extends HttpServlet {

	private static final long serialVersionUID = -3099937756187406011L;
	private UserService userService = new UserSeviceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathString = req.getServletPath();
		HttpSession session = req.getSession();
		switch (pathString) {
		case "/profile":
			doGetProfile(session, req, resp);
			break;
		default:
			break;
		}
	}

	private void doGetProfile(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		req.setAttribute("user", currentUser);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/profile.jsp");
		requestDispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pathString = req.getServletPath();
		switch (pathString) {
		case "/profile":
			doPostUpdateProfile(session,req, resp);
			break;
		default:
			break;
		}
	}

	private void doPostUpdateProfile(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String oldavt = req.getParameter("oldavt");
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");

		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);

		// Check if the "image" part is present
		Part photo = req.getPart("image");
		if (photo != null) {
			System.out.print("------------------------------++++++++++++++++++++++------------------------");
		    String submittedFileName = Paths.get(photo.getSubmittedFileName()).getFileName().toString();
		    if(submittedFileName.isEmpty())
		    {
		    	currentUser.setImage(oldavt);
		    }
		    else {
		    	currentUser.setImage(submittedFileName);
			}
		    
		}
		else {
			System.out.print("------------------------------XXXXXXXXXXXXXXXXXXXXXX------------------------");
			
		}

		// Update the "fullName" and "email"
		currentUser.setEmail(email);
		currentUser.setFullName(fullName);
		
		User updatedUser = userService.update(currentUser);
		session.setAttribute(SessionAttribute.CURRENT_USER, updatedUser);

		resp.sendRedirect("profile"); // Assuming "profile" is the URL for the user's profile page.


	}


}
