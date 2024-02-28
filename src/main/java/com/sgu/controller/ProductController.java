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
import com.sgu.entity.Cart;
import com.sgu.entity.CartDetail;
import com.sgu.entity.Product;
import com.sgu.entity.User;
import com.sgu.service.CartDetailService;
import com.sgu.service.CartService;
import com.sgu.service.ProductService;
import com.sgu.service.impl.CartDetailServiceImpl;
import com.sgu.service.impl.CartServiceImpl;
import com.sgu.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/product" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 6777660204520996542L;
	private static final int MAX_OF_SIZE = 8;
	private ProductService productService = new ProductServiceImpl();
	private CartService cartService = new CartServiceImpl();
	private CartDetailService cartDetailService = new CartDetailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String actionParam = req.getParameter("action");
		Integer id;

		switch (actionParam) {
		case "view":
			String categoryParam = req.getParameter("category");
			doGetProduct(req, resp, categoryParam);
			break;
		case "search":
			doGetProductSearch(req, resp);
			break;
		case "viewDetail":
			id = Integer.parseInt(req.getParameter("id"));
			doGetProductDetail(req, resp, id);
			break;
		default:
			break;
		}
	}

	private void doGetProduct(HttpServletRequest req, HttpServletResponse resp, String category)
			throws ServletException, IOException {

		Integer caInteger;
		List<Product> countproducts = new ArrayList<Product>();
		if (category == null || "all".equals(category) || "".equals(category)) {
			caInteger = 0;
			countproducts = productService.findAll();
		} else {
			caInteger = Integer.parseInt(category);
			countproducts = productService.findByCategory(caInteger);
		}

		int maxPage = (int) Math.ceil(countproducts.size() / (double) MAX_OF_SIZE);
		req.setAttribute("maxPage", Integer.valueOf(maxPage));
		req.setAttribute("category", category);
		List<Product> products;
		String pageNumber = req.getParameter("page");
		if(caInteger == 0)
		{
			if (pageNumber == null) {
				products = productService.findAll(1, MAX_OF_SIZE);
				req.setAttribute("currentPage", 1);
			} else {
				products = productService.findAll(Integer.valueOf(pageNumber), MAX_OF_SIZE);
				req.setAttribute("currentPage", Integer.valueOf(pageNumber));
			}
		}
		else {
			if (pageNumber == null) {
				products = productService.findByCategory(caInteger, 1, MAX_OF_SIZE);
				req.setAttribute("currentPage", 1);
			} else {
				products = productService.findByCategory(caInteger, Integer.valueOf(pageNumber), MAX_OF_SIZE);
				req.setAttribute("currentPage", Integer.valueOf(pageNumber));
			}
		}
		req.setAttribute("products", products);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/product.jsp");
		requestDispatcher.forward(req, resp);
	}

	private void doGetProductDetail(HttpServletRequest req, HttpServletResponse resp, Integer id)
			throws ServletException, IOException {

		Product product = productService.findById(id);
		if (product != null) {
			req.setAttribute("product", product);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/productDetail.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/404Page.jsp");
			requestDispatcher.forward(req, resp);
		}

	}
	private void doGetProductSearch(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Float priceBegin = 0f;
		Float priceEnd = 0f;
		String name="", color="";
		
		if(req.getParameter("priceBegin")!= null && req.getParameter("priceBegin") != "")
		{
			priceBegin = Float.parseFloat(req.getParameter("priceBegin"));
		}
		if(req.getParameter("priceEnd")!= null && req.getParameter("priceEnd") != "")
		{
			priceEnd = Float.parseFloat(req.getParameter("priceEnd"));
		}
		if(req.getParameter("color")!= null && req.getParameter("color") != "")
		{
			color = req.getParameter("color");
		}
		if(req.getParameter("productName")!= null && req.getParameter("productName") != "")
		{
			name = req.getParameter("productName");
		}
		System.out.println("DA DEN DAYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		List<Product> products = productService.findByNameColorPrice(name, color, priceBegin, priceEnd);
		String header = "Kết quả tìm kiếm";
		req.setAttribute("header", header);
		req.setAttribute("name", name);
		req.setAttribute("priceBegin", priceBegin);
		req.setAttribute("products", products);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/productSearch.jsp");
		requestDispatcher.forward(req, resp);
	}

	private void doPostRemoveFromCart(HttpSession session, HttpServletRequest req, HttpServletResponse resp, Integer id)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		if (currentUser != null) {
			Cart cart = cartService.findByUserId(currentUser.getUserID());

			CartDetail cartDetail = cartDetailService.findByCartIdAndProductID(cart.getCartID(), id);
			CartDetail removedCartDetail = cartDetailService.delete(cartDetail.getCartDetailID());

			if (removedCartDetail != null) {
				resp.setStatus(204);
				resp.getWriter().write("{\"error\": \"Remove successfully.\"}");
			} else {
				resp.setStatus(401);
				resp.getWriter().write("{\"error\": \"Remove khong thanh cong.\"}");
			}

		} else {
			resp.setStatus(401);
			resp.getWriter().write("{\"error\": \"Chua dang nhap.\"}");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String actionParam = req.getParameter("action");
		Integer id;

		switch (actionParam) {
		case "addToCart":
			id = Integer.parseInt(req.getParameter("id"));
			Integer quantity = Integer.parseInt(req.getParameter("quantity"));
			System.out.print(id);
			System.out.print(quantity);
			doPostAddToCart(session, req, resp, id, quantity);
			break;
		case "removeFromCart":
			id = Integer.parseInt(req.getParameter("id"));
			doPostRemoveFromCart(session, req, resp, id);
			break;
		default:
			break;
		}

	}

	private void doPostAddToCart(HttpSession session, HttpServletRequest req, HttpServletResponse resp, Integer id,
			Integer quantity) throws ServletException, IOException {

		resp.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		if (currentUser != null) {
			CartDetail cartDetail = new CartDetail();
			Cart cart = cartService.findByUserId(currentUser.getUserID());

			Product product = productService.findById(id);
			CartDetail existCartDetail = cartDetailService.findByCartIdAndProductID(cart.getCartID(), id);
			if (existCartDetail != null) {
				resp.setStatus(401);
				resp.getWriter().write("{\"error\": \"San pham da ton tai.\"}");
			} else {

				cartDetail.setProduct(product);
				cartDetail.setCart(cart);
				cartDetail.setQuantity(quantity);
				cartDetail.setUnitPrice(product.getUnitPrice());
				CartDetail new_CartDetail = cartDetailService.create(cartDetail);
				if (new_CartDetail != null) {
					resp.setStatus(204);
					resp.getWriter().write("{\"error\": \"Add successfully.\"}");
				} else {
					resp.setStatus(401);
					resp.getWriter().write("{\"error\": \"Add khong thanh cong.\"}");
				}

			}

		} else {
			resp.setStatus(401);
			resp.getWriter().write("{\"error\": \"Chua dang nhap.\"}");
		}
	}

}
