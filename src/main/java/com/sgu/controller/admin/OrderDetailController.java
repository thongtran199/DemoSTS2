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
import com.sgu.entity.Order;
import com.sgu.entity.OrderDetail;
import com.sgu.entity.Product;
import com.sgu.service.OrderDetailService;
import com.sgu.service.OrderService;
import com.sgu.service.ProductService;
import com.sgu.service.impl.OrderDetailServiceImpl;
import com.sgu.service.impl.OrderServiceImpl;
import com.sgu.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = { "/adorderdetail" })
public class OrderDetailController extends HttpServlet {

	private static final long serialVersionUID = 4831006733887366260L;

	private OrderService orderService = new OrderServiceImpl();
	private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");

		Integer id;

			switch (actionParam) {
			case "edit":
				id = Integer.parseInt(req.getParameter("id")) ;
				doGetEdit(id,req, resp);
				break;
			default:
				break;
			}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");



			switch (actionParam) {
			case "edit":
				doPostEdit(req, resp);
				break;
			default:
				break;
			}
	}

	private void doGetEdit(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderDetail orderDetail = orderDetailService.findById(id); 
		List<Product> products = productService.findAll();
		req.setAttribute("products", products);
		req.setAttribute("orderDetail", orderDetail);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/orderdetail/edit.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VAO DO POST EDIT");
		resp.setContentType("application/json");
		
		Integer orderDetailID = Integer.parseInt(req.getParameter("orderDetailID"));
		Integer productID = Integer.parseInt(req.getParameter("productID"));
		Integer quanity = Integer.parseInt(req.getParameter("quantity"));
		Float unitPrice = Float.parseFloat(req.getParameter("unitPrice"));
		
		OrderDetail orderDetail = orderDetailService.findById(orderDetailID);
		Product updatedproduct = productService.findById(productID);
		
		Float originalTotal = orderDetail.getUnitPrice() * orderDetail.getQuantity();
		Order order = orderDetail.getOrder();
		order.setTotal(order.getTotal() - originalTotal);
		
		
		orderDetail.setProduct(updatedproduct);
		orderDetail.setQuantity(quanity);
		orderDetail.setUnitPrice(unitPrice);
		
		Float updatedTotal = orderDetail.getUnitPrice() * orderDetail.getQuantity();
		order.setTotal(order.getTotal() + updatedTotal);
		
		
		OrderDetail e = orderDetailService.update(orderDetail);
		
		if(e != null)
		{
		resp.setStatus(204);	
		}else {
			resp.setStatus(400);	
		}

	}

}
