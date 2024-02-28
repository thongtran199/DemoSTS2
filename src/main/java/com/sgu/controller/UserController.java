package com.sgu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.FetchProfile.Item;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sgu.constant.SessionAttribute;
import com.sgu.dto.CartProductDTO;
import com.sgu.entity.Cart;
import com.sgu.entity.CartDetail;
import com.sgu.entity.Product;
import com.sgu.entity.User;
import com.sgu.service.CartDetailService;
import com.sgu.service.CartService;
import com.sgu.service.EmailService;
import com.sgu.service.UserService;
import com.sgu.service.impl.CartDetailServiceImpl;
import com.sgu.service.impl.CartServiceImpl;
import com.sgu.service.impl.EmailServiceImpl;
import com.sgu.service.impl.UserSeviceImpl;

@WebServlet(urlPatterns = { "/login", "/logout", "/register", "/forgotPass","/changePass","/cart" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = -3099937756187406011L;
	private UserService userService = new UserSeviceImpl();
	private EmailService mailService = new EmailServiceImpl();
	private CartService cartService = new CartServiceImpl();
	private CartDetailService cartDetailService = new CartDetailServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathString = req.getServletPath();
		HttpSession session = req.getSession();
		switch (pathString) {
		case "/login":
			doGetLogin(req, resp);
			break;
		case "/register":
			doGetRegister(req, resp);
			break;
		case "/logout":
			doGetLogout(session,req, resp);
			break;
		case "/forgotPass":
			doGetForgotPass(req, resp);
			break;
		case "/cart":
			doGetCart(session, req, resp);
			break;
		case "/changePass":
			doGetChangePass(req, resp);
			break;
		default:
			break;
		}
	}
	private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/login.jsp");
		requestDispatcher.forward(req, resp);
	}

	private void doGetRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/register.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetLogout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		session.removeAttribute(SessionAttribute.CURRENT_USER);
		resp.sendRedirect("index");
	}
	private void doGetForgotPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/forgotPass.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetCart(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(session!=null)
		{
			User currentUser = (User) session.getAttribute("currentUser");
			if(currentUser!=null)
			{
				
				Cart cart  = cartService.findByUserId(currentUser.getUserID());
				List<CartDetail> cartDetails = cartDetailService.findByCartId(cart.getCartID());
				List<CartProductDTO> cartProductDTOs = new ArrayList<CartProductDTO>();
				for (CartDetail cartDetail : cartDetails) {
					Product product = cartDetail.getProduct();
					CartProductDTO cartProductDTO = new CartProductDTO(product);
					cartProductDTO.setQuantity(cartDetail.getQuantity());
					cartProductDTO.updateTotal();
					cartProductDTOs.add(cartProductDTO);
				}
				req.setAttribute("cartProductDTOs", cartProductDTOs);	
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/cart.jsp");
				requestDispatcher.forward(req, resp);
			}
			else {
				System.out.print("Không có user");
			}
			
		}else {
			System.out.print("Không Có session");
		
		}

	}
	private void doGetChangePass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/changePass.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pathString = req.getServletPath();
		switch (pathString) {
		case "/login":
			doPostLogin(session,req, resp);
			break;
		case "/register":
			doPostRegister(session,req, resp);
			break;
		case "/forgotPass":
			doPostForgotPass(req, resp);
			break;
		case "/changePass":
			doPostChangePass(session, req, resp);
			break;
		default:
			break;
		}
	}

	private void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = userService.login(username, password);
		if(user != null)
		{
			session.setAttribute(SessionAttribute.CURRENT_USER, user);
			resp.sendRedirect("index");
		}else {
			resp.sendRedirect("login");
		}
	}

	private void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String telnumber = req.getParameter("telnumber");
		String fullname = req.getParameter("fullname");
		String shipcity = req.getParameter("shipcity");
		String shipstate = req.getParameter("shipstate");
		String shipaddress = req.getParameter("shipaddress");
		
		User user = userService.register(username, password, email, telnumber, 2, fullname, shipaddress, shipcity, shipstate);
		Cart cart = new Cart();

		if(user != null)
		{	

			cart.setQuantity(0);
			cart.setUser(user);
			Cart savedCart = cartService.create(cart);
			if(savedCart != null)
			{
				mailService.sendMail(getServletContext(), user, "welcome");
				session.setAttribute(SessionAttribute.CURRENT_USER, user);
				resp.sendRedirect("index");
			}
			else {
				resp.sendRedirect("register");
			}
		}else {
			resp.sendRedirect("register");
		}
	}
	private void doPostForgotPass(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("application/json");
		String email = req.getParameter("email");
		User userWithNewPass = userService.resetPassword(email);
		if(userWithNewPass != null)
		{	
			mailService.sendMail(getServletContext(), userWithNewPass, "forgot");
			resp.setStatus(204);

		}else {
			resp.setStatus(400);
		}
	}
	private void doPostChangePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String currentPass = req.getParameter("currentPass");
		String newPass = req.getParameter("newPass");
		String verifyPass = req.getParameter("verifyPass");

		System.out.println(newPass);
		System.out.println(verifyPass);
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);

		if (currentUser.getPassword().equals(currentPass)) {
		    if (newPass.equals(verifyPass)) {
		        currentUser.setPassword(newPass);
		        User updatedUser = userService.update(currentUser);
		        if (updatedUser != null) {
		            session.setAttribute(SessionAttribute.CURRENT_USER, updatedUser);
		    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/index.jsp");
		    		requestDispatcher.forward(req, resp);

		        } else {
		        	System.out.println("ELSE 3");
		    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/changePass.jsp");
		    		requestDispatcher.forward(req, resp);

		        }
		    } else {
		    	System.out.println("ELSE 2");
	    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/changePass.jsp");
	    		requestDispatcher.forward(req, resp);
		    }
		} else {
			System.out.println("ELSE 1");
    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/changePass.jsp");
    		requestDispatcher.forward(req, resp);
		}

	}
}
