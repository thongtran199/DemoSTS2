package com.sgu.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialJavaObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgu.constant.SessionAttribute;
import com.sgu.dto.ByDayDTO;
import com.sgu.dto.ByMonthDTO;
import com.sgu.dto.Top10ProductDTO;
import com.sgu.dto.Top5CustomerDTO;
import com.sgu.dto.Top5SellerDTO;
import com.sgu.entity.Category;
import com.sgu.entity.Order;
import com.sgu.entity.Product;
import com.sgu.entity.Supplier;
import com.sgu.entity.User;
import com.sgu.service.CategoryService;
import com.sgu.service.OrderService;
import com.sgu.service.ProductService;
import com.sgu.service.StatsService;
import com.sgu.service.SupplierService;
import com.sgu.service.impl.CategoryServiceImpl;
import com.sgu.service.impl.OrderServiceImpl;
import com.sgu.service.impl.ProductServiceImpl;
import com.sgu.service.impl.StatsServiceImpl;
import com.sgu.service.impl.SupplierServiceImpl;

import javassist.expr.NewArray;


@WebServlet(urlPatterns = { "/adstats" })
public class StatsController extends HttpServlet {

	private static final long serialVersionUID = 4831006733887366260L;

	private ProductService productService = new ProductServiceImpl();
	private SupplierService supplierService = new SupplierServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	private StatsService statsService = new StatsServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");


			switch (actionParam) {
			case "top5customers":
				doGetTop5Customers(req, resp);
				break;
				
			case "top5sellers":
				doGetTop5Sellers(req, resp);
				break;
			case "top10products":
				doGetTop10Products( req, resp);
				break;
			case "bytime":
				doGetByTime( req, resp);
				break;
			case "print":
				doGetPrint( req, resp);
				break;
			default:
				break;
			}
		


	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");

			switch (actionParam) {
			case "bytimeday":
				doPostByDay(req, resp);
				break;
			case "bytimemonth":
				doPostByMonth(req, resp);
				break;
			default:
				break;
			}
		
	}
	private void doGetTop5Customers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Top5CustomerDTO> top5CustomerDTOs = statsService.findTop5CustomerDTO();
		req.setAttribute("customers", top5CustomerDTOs);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/stats/top5customers.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetTop5Sellers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Top5SellerDTO> top5SellerDTOs = statsService.findTop5SellerDTO();
		req.setAttribute("sellers", top5SellerDTOs);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/stats/top5sellers.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetTop10Products(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Top10ProductDTO> top10ProductDTOs = statsService.findTop10ProductDTO();
		req.setAttribute("products", top10ProductDTOs);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/stats/top10products.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetByTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/stats/bytime.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetPrint(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.print("DA VAOOOOOOOOOOOOOO");
		Integer day, month, year;
		if(req.getParameter("day") == null || req.getParameter("month")==null || req.getParameter("year") == null)
	    {
	        LocalDate currentDate = LocalDate.now();
	        
	        // Tách ngày, tháng và năm ra
	        day = currentDate.getDayOfMonth();
	        month = currentDate.getMonthValue();
	        year = currentDate.getYear();
	        
	        System.out.println("Ngày: " + day);
	        System.out.println("Tháng: " + month);
	        System.out.println("Năm: " + year);
	    }
	    else {
			day = Integer.parseInt(req.getParameter("day")); // Sử dụng req.getParameter để lấy tham số từ yêu cầu
		    month = Integer.parseInt(req.getParameter("month"));
		    year = Integer.parseInt(req.getParameter("year"));
		    System.out.print(day);
		    System.out.print(month);
		    System.out.print(year);
		}

	    List<Order> orders = orderService.findByDate(year, month, day);
	    req.setAttribute("orders", orders);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/stats/print.jsp");
		requestDispatcher.forward(req, resp);
	}

	private void doPostByMonth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		List<ByMonthDTO> byMonthDTOs = statsService.findByMonthDTO();
		List<String> labels = new ArrayList<>();
		List<Float> data = new ArrayList<>();

		for (ByMonthDTO dto : byMonthDTOs) {
		    labels.add(dto.getMonth());
		    data.add(dto.getRevenue());
		}

		Map<String, Object> chartData = new HashMap<>();
		chartData.put("labels", labels);
		chartData.put("data", data);

		ObjectMapper mapper = new ObjectMapper();
		String dataResponse = mapper.writeValueAsString(chartData);

		resp.setStatus(200);
		out.print(dataResponse);
		out.flush();
		
	}
	private void doPostByDay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		List<ByDayDTO> byDayDTOs = statsService.findByDayDTO();
		List<String> labels = new ArrayList<>();
		List<Float> data = new ArrayList<>();

		for (ByDayDTO dto : byDayDTOs) {
		    labels.add(dto.getDayOfWeek());
		    data.add(dto.getRevenue());
		}

		Map<String, Object> chartData = new HashMap<>();
		chartData.put("labels", labels);
		chartData.put("data", data);

		ObjectMapper mapper = new ObjectMapper();
		String dataResponse = mapper.writeValueAsString(chartData);

		resp.setStatus(200);
		out.print(dataResponse);
		out.flush();
		
	}
	

}
