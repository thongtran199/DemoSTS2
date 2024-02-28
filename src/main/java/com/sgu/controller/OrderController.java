package com.sgu.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.FetchProfile.Item;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.sgu.constant.SessionAttribute;
import com.sgu.dto.CartProductDTO;
import com.sgu.entity.Cart;
import com.sgu.entity.CartDetail;
import com.sgu.entity.Order;
import com.sgu.entity.OrderDetail;
import com.sgu.entity.Product;
import com.sgu.entity.User;
import com.sgu.service.CartDetailService;
import com.sgu.service.CartService;
import com.sgu.service.EmailService;
import com.sgu.service.OrderDetailService;
import com.sgu.service.OrderService;
import com.sgu.service.ProductService;
import com.sgu.service.UserService;
import com.sgu.service.impl.CartDetailServiceImpl;
import com.sgu.service.impl.CartServiceImpl;
import com.sgu.service.impl.EmailServiceImpl;
import com.sgu.service.impl.OrderDetailServiceImpl;
import com.sgu.service.impl.OrderServiceImpl;
import com.sgu.service.impl.ProductServiceImpl;
import com.sgu.service.impl.UserSeviceImpl;

@WebServlet(urlPatterns = { "/checkout", "/placeanorder","/xacnhandonhang" })
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = -3099937756187406011L;
	private UserService userService = new UserSeviceImpl();
	private EmailService mailService = new EmailServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	
	private CartService cartService = new CartServiceImpl();
	private CartDetailService cartDetailService = new CartDetailServiceImpl();
	private ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathString = req.getServletPath();
		switch (pathString) {
		case "/checkout":
			doGetCheckout(req, resp);
			break;
		case "/xacnhandonhang":
			doGetXacNhanDonHang(req, resp);
			break;
		default:
			break;
		}
	}

	private void doGetXacNhanDonHang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		if(idString!=null && !idString.isEmpty())
		{
			Integer idInteger= Integer.valueOf(idString);
			HttpSession session = req.getSession();
			User currentUser = (User)session.getAttribute(SessionAttribute.CURRENT_USER);
			if(currentUser != null)
			{
				Order order = orderService.findById(idInteger);
				if(order.getUser().getUserID() != currentUser.getUserID())
				{
						RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/404Page.jsp");
						requestDispatcher.forward(req, resp);
				}
				else {
					order.setStatus(4);
					Order confirmedOrder = orderService.update(order);
					if(confirmedOrder != null)
					{
						req.setAttribute("orderId", order.getOrderID());
						RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/static/confirmOrder.jsp");
						requestDispatcher.forward(req, resp);
					}
				}

					
			}
		}
		
		
		
	}

	private void doGetCheckout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jsonData = req.getParameter("data");
		List<CartProductDTO> cartProductDTOs = new ArrayList<CartProductDTO>();
		if (jsonData != null && !jsonData.isEmpty()) {
			List<Map<String, String>> dataList = new Gson().fromJson(jsonData, List.class);

			for (Map<String, String> item : dataList) {
				Integer id = Integer.parseInt(item.get("id"));
				Integer quantity = Integer.parseInt(item.get("quantity"));
				System.out.print(id);
				System.out.println(quantity);
				Product product = productService.findById(id);
				CartProductDTO cartProductDTO = new CartProductDTO(product);
				cartProductDTO.setQuantity(quantity);
				cartProductDTO.updateTotal();
				System.out.print(cartProductDTO.toString());
				cartProductDTOs.add(cartProductDTO);
			}
		}
		req.setAttribute("cartProductDTOs", cartProductDTOs);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/checkout.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathString = req.getServletPath();

		switch (pathString) {
		case "/placeanorder":
			doPostPlaceAnOrder(req, resp);
			break;
		default:
			break;
		}
	}

	private void doPostPlaceAnOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		User currentUser = (User)session.getAttribute(SessionAttribute.CURRENT_USER);
		
		resp.setContentType("application/json");


		BufferedReader reader = req.getReader();
		StringBuilder requestData = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
		    requestData.append(line);
		}
		reader.close();

		JsonObject json = new JsonParser().parse(requestData.toString()).getAsJsonObject(); 

		JsonArray productList = json.getAsJsonArray("productList");
		if(!productList.isEmpty())
		{
			StringBuilder msg1 = new StringBuilder();
			Order order = new Order();
			order.setUser(userService.findById(currentUser.getUserID()));
			order.setStatus(0);
			order.setIsActive(Boolean.TRUE);
			order.setOrderDate(new Timestamp(System.currentTimeMillis()));
			
			Order new_Order = orderService.create(order);
			
			Integer totalOrder = 0;
			for (int i = 0; i < productList.size(); i++) {
			    JsonElement productElement = productList.get(i);
			    if (productElement.isJsonObject()) {
			        JsonObject product = productElement.getAsJsonObject();
			        Integer id = product.get("id").getAsInt();
			        Integer price = product.get("price").getAsInt();
			        Integer total = product.get("total").getAsInt();
			        Integer quantity = product.get("quantity").getAsInt();
			        
			        totalOrder = totalOrder + total;
			        
			        OrderDetail orderDetail = new OrderDetail();
			        orderDetail.setProduct(productService.findById(id));
			        orderDetail.setQuantity(quantity);
			        orderDetail.setUnitPrice(Float.valueOf(price));
			        orderDetail.setOrder(new_Order);
			        
			        orderDetailService.create(orderDetail);
			        msg1.append("\n");
			        msg1.append(orderDetail.toStringMail());
			        
			    }
			}
			new_Order.setTotal(Float.valueOf(totalOrder));
			new_Order.setPaymentDate(null);
			Order updatedOrder = orderService.update(new_Order);
			if(updatedOrder!=null)
			{
				StringBuilder msg = new StringBuilder();
				msg.append("Thông báo từ PoR27.Shop, Bạn đã đặt hàng thành công\n Đơn hàng gồm\n");
				msg.append(msg1);
				msg.append("\nVui lòng xác nhận đơn hàng bằng cách ấn vào link bên dưới\n");
				msg.append("http://localhost:8080/DemoSTS/xacnhandonhang?id="+order.getOrderID());
			
				mailService.sendMail(getServletContext(), currentUser, msg.toString());
				resp.setStatus(204);
				resp.getWriter().write("Dữ liệu đã được xử lý thành công, vui lòng kiểm tra email");
			}
			else {
				resp.setStatus(400);
				resp.getWriter().write("Có data nhưng không biết lỗi gì");
			}


		}
		else {
			resp.setStatus(400);
			resp.getWriter().write("Không có data");
		}

	}

}
