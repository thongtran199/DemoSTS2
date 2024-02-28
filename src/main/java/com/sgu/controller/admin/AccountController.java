package com.sgu.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.sgu.constant.SessionAttribute;
import com.sgu.entity.Product;
import com.sgu.entity.User;
import com.sgu.service.UserService;
import com.sgu.service.impl.UserSeviceImpl;

@MultipartConfig
@WebServlet(urlPatterns = { "/adaccount" })
public class AccountController extends HttpServlet {

	private static final long serialVersionUID = 4831006733887366260L;

	private UserService userService = new UserSeviceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");

		if(actionParam == null)
		{
			doGetView(req, resp);
		}
		else {
			switch (actionParam) {
			case "view":
				doGetView(req, resp);
				break;
				
			case "create":
				doGetCreate(req, resp);
				break;
			case "edit":
				Integer id = Integer.parseInt(req.getParameter("id"));
				doGetEdit(id, req, resp);
				break;
			case "delete":
				id = Integer.parseInt(req.getParameter("id"));
				doGetDelete(id, req, resp);
				break;
			default:
				break;
			}
		}


	}
	private void doGetView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = userService.findAll();
		req.setAttribute("users", users);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/account/view.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/account/create.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetEdit(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = userService.findById(id);
		req.setAttribute("user", user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/account/edit.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetDelete(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		User e = userService.delete(id); 
		
		if(e != null)
		{
		resp.setStatus(204);	
		}else {
			resp.setStatus(400);	
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");

		if(actionParam == null)
		{
			doGetView(req, resp);
		}
		else {
			switch (actionParam) {
			case "create":
				doPostCreate(req, resp);
				break;
			case "edit":
				doPostEdit(req, resp);
				break;
			default:
				break;
			}
		}
	}
	private void doPostCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("VAO DO POST CREATE");
	    resp.setCharacterEncoding("UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    resp.setContentType("application/json; charset=UTF-8");

	    
	    String fullName = req.getParameter("fullName");
	    String email = req.getParameter("email");
	    String userName = req.getParameter("userName");
	    String password = req.getParameter("password");
	    Integer role = Integer.parseInt(req.getParameter("role"));
	    String shipCity = req.getParameter("shipCity");
	    String shipState = req.getParameter("shipState");
	    String shipAddress = req.getParameter("shipAddress");
	    String telNumber = req.getParameter("telNumber");

	    User user = new User();
	    user.setFullName(fullName);
	    user.setUserName(userName);
	    user.setPassword(password);
	    user.setEmail(email);
	    user.setTelNumber(telNumber);
	    user.setShipAddress(shipAddress);
	    user.setShipCity(shipCity);
	    user.setShipState(shipState);
	    user.setRole(role);
	    


	    Part imagePart = req.getPart("image");
	    if (imagePart != null) {
	    	
			File dir = new File("D:\\Downloads\\Spring Tool Suite 4\\Project\\DemoSTS2\\src\\main\\webapp\\files\\imageuser");
			if(!dir.exists()) {
				dir.mkdirs();
			}
			System.out.println(dir.getAbsolutePath());
			
			String imageName = imagePart.getSubmittedFileName();
			File photoFile = new File(dir,imageName);
			imagePart.write(photoFile.getAbsolutePath());
			
	       
	        if (imageName != null && !imageName.isEmpty()) {

	            user.setImage(imageName);
	        }
	    }
	    else {
	    	user.setImage("default.png");
		}

	    User e = userService.create(user);
	    if (e != null) {
	        resp.setStatus(204);
	    } else {
	        resp.setStatus(400);
	    }
	}

	private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VAO DO POST EDIT");
	    resp.setCharacterEncoding("UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    resp.setContentType("application/json; charset=UTF-8");
		
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		Integer role = Integer.parseInt( req.getParameter("role"));
		String shipCity = req.getParameter("shipCity");
		String shipState = req.getParameter("shipState");
		String shipAddress = req.getParameter("shipAddress");
		String telNumber = req.getParameter("telNumber");
		String oldavt = req.getParameter("oldavt");
		Integer userID = Integer.parseInt( req.getParameter("userID"));
		
		User user = userService.findById(userID);
		
		Part imagePart = req.getPart("image");
	    if (imagePart != null) {
	    	
			File dir = new File("D:\\Downloads\\Spring Tool Suite 4\\Project\\DemoSTS2\\src\\main\\webapp\\files\\imageuser");
			if(!dir.exists()) {
				dir.mkdirs();
			}
			System.out.println(dir.getAbsolutePath());
			
			String imageName = imagePart.getSubmittedFileName();
			File photoFile = new File(dir,imageName);
			imagePart.write(photoFile.getAbsolutePath());
			
	       
	        if (imageName != null && !imageName.isEmpty()) {

	            user.setImage(imageName);
	        }
	    }
	    else {
	    	user.setImage(oldavt);
		}

		
		user.setFullName(fullName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setTelNumber(telNumber);
		user.setShipAddress(shipAddress);
		user.setShipCity(shipCity);
		user.setShipState(shipState);
		user.setRole(role);
		
		User e = userService.update(user);
		if(e!= null)
		{
		resp.setStatus(204);	
		}else {
			resp.setStatus(400);	
		}
	}
}
