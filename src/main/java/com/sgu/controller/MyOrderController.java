package com.sgu.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sgu.constant.SessionAttribute;


import com.sgu.entity.Order;
import com.sgu.entity.OrderDetail;

import com.sgu.entity.User;

import com.sgu.service.OrderDetailService;
import com.sgu.service.OrderService;
import com.sgu.service.UserService;

import com.sgu.service.impl.OrderDetailServiceImpl;
import com.sgu.service.impl.OrderServiceImpl;
import com.sgu.service.impl.UserSeviceImpl;

@WebServlet(urlPatterns = { "/myorder","/myorderdetail" })
public class MyOrderController extends HttpServlet {

	private static final long serialVersionUID = -3099937756187406011L;
	private UserService userService = new UserSeviceImpl();
	private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathString = req.getServletPath();
		HttpSession session = req.getSession();
		switch (pathString) {

		case "/myorder":
			doGetMyOrder(session, req, resp);
			break;
		case "/myorderdetail":
			doGetOrderDetail( req, resp);
			break;

		default:
			break;
		}
	}

	private void doGetMyOrder(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		req.setAttribute("currentUser", currentUser);
		List<Order> orders = orderService.findByUserId(currentUser.getUserID());
		req.setAttribute("orders", orders);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/myorder.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id")) ;
		List<OrderDetail> orderDetails = orderDetailService.findByOrderId(id);
		req.setAttribute("orderDetails", orderDetails);
		req.setAttribute("orderID", id);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/orderViewDetail.jsp");
		requestDispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pathString = req.getServletPath();
		switch (pathString) {
		case "/updateProfile":
			doPostUpdateProfile(session,req, resp);
			break;
		default:
			break;
		}
	}

	private void doPostUpdateProfile(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("application/json");
		String currentPass = req.getParameter("currentPass");
		String newPass = req.getParameter("newPass");
		String verifyPass = req.getParameter("verifyPass");

		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		System.out.println("chuan bi vao if");
		if (currentUser.getPassword().equals(currentPass)) {
		    if (newPass.equals(verifyPass)) {
		        currentUser.setPassword(newPass);
		        User updatedUser = userService.update(currentUser);
		        if (updatedUser != null) {
		            session.setAttribute(SessionAttribute.CURRENT_USER, updatedUser);
		            resp.setStatus(204); 
		        } else {
		        	System.out.println("ELSE 3");
		            resp.setStatus(500); 
		            resp.getWriter().write("{\"error\": \"Failed to update user.\"}");
		        }
		    } else {
		    	System.out.println("ELSE 2");
		        resp.setStatus(400); 
		        resp.getWriter().write("{\"error\": \"New passwords do not match.\"}");
		    }
		} else {
			System.out.println("ELSE 1");
		    resp.setStatus(400); 
		    resp.getWriter().write("{\"error\": \"Current password is incorrect.\"}");
		}
	}
}
