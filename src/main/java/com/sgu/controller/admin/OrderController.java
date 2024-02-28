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
import com.sgu.entity.Order;
import com.sgu.entity.OrderDetail;
import com.sgu.entity.Product;
import com.sgu.entity.User;
import com.sgu.service.OrderDetailService;
import com.sgu.service.OrderService;
import com.sgu.service.UserService;
import com.sgu.service.impl.OrderDetailServiceImpl;
import com.sgu.service.impl.OrderServiceImpl;
import com.sgu.service.impl.UserSeviceImpl;


@WebServlet(urlPatterns = { "/adorder" })
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 4831006733887366260L;

	private OrderService orderService = new OrderServiceImpl();
	private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	private UserService userService = new UserSeviceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");

		Integer id;
		if(actionParam == null)
		{
			doGetView(req, resp);
		}
		else {
			switch (actionParam) {
			case "view":
				doGetView(req, resp);
				break;
			case "viewDetail":
				id = Integer.parseInt(req.getParameter("id")); 
				doGetViewDetail(id, req, resp);
				break;
			case "create":
				doGetCreate(req, resp);
				break;
			case "edit":
				id = Integer.parseInt(req.getParameter("id"));
				doGetEdit(id, req, resp);
				break;
				
			case "delete":
				break;
			default:
				break;
			}
		}


	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String actionParam = req.getParameter("action");



			switch (actionParam) {

			case "updateStatus":

				doPostUpdateStatus(session, req, resp);
				break;
			default:
				break;
			}
		


	}
	private void doPostUpdateStatus( HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		System.out.println("VAO DO POST EDIT");
		resp.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_ADMIN);
		User seller = userService.findById(currentUser.getUserID());
		Integer id =  Integer.parseInt(req.getParameter("orderID")); 
		Integer status =  Integer.parseInt(req.getParameter("status")); 
		Order order = orderService.findById(id);
		order.setStatus(status);
		order.setSeller(seller);
		Order e = orderService.update(order);
		
		
		if(e != null)
		{
		resp.setStatus(204);	
		}else {
			resp.setStatus(400);	
		}
	}
	
	private void doGetView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Order> orders = orderService.findAll();
		req.setAttribute("orders", orders);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/order/view.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetViewDetail(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Order order = orderService.findById(id);
		List<OrderDetail> orderDetails = orderDetailService.findByOrderId(id);
		req.setAttribute("order", order);
		req.setAttribute("orderDetails", orderDetails);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/order/viewDetail.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/order/create.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetEdit(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Order order = orderService.findById(id);
		req.setAttribute("order", order);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/order/edit.jsp");
		requestDispatcher.forward(req, resp);
	}

}
