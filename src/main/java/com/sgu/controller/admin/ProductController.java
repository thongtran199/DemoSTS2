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

import com.sgu.constant.SessionAttribute;
import com.sgu.entity.Category;
import com.sgu.entity.Product;
import com.sgu.entity.Supplier;
import com.sgu.entity.User;
import com.sgu.service.CategoryService;
import com.sgu.service.ProductService;
import com.sgu.service.SupplierService;
import com.sgu.service.impl.CategoryServiceImpl;
import com.sgu.service.impl.ProductServiceImpl;
import com.sgu.service.impl.SupplierServiceImpl;

import javassist.expr.NewArray;

@MultipartConfig
@WebServlet(urlPatterns = { "/adproduct" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 4831006733887366260L;

	private ProductService productService = new ProductServiceImpl();
	private SupplierService supplierService = new SupplierServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	
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
				
			case "create":
				doGetCreate(req, resp);
				break;
			case "edit":
				id = Integer.parseInt(req.getParameter("id"));
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
	private void doGetView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = productService.findAll();
		req.setAttribute("products", products);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/product/view.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Supplier> suppliers = supplierService.findAll();
		List<Category> categories = categoryService.findAll();
		req.setAttribute("categories", categories);
		req.setAttribute("suppliers", suppliers);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/product/create.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetEdit(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = productService.findById(id);
		List<Supplier> suppliers = supplierService.findAll();
		List<Category> categories = categoryService.findAll();
		for(int i = 0; i <categories.size() -1 ;i++)
		{
			System.out.print(categories.get(i).toString());
		}
		req.setAttribute("product", product);
		req.setAttribute("categories", categories);
		req.setAttribute("suppliers", suppliers);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/product/edit.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetDelete(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		Product removedProduct = productService.delete(id);
		
		if(removedProduct != null)
		{
		resp.setStatus(204);	
		}else {
			resp.setStatus(400);	
		}
	}
	
	
	private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VAO DO POST EDIT");
		resp.setContentType("application/json");
		req.setCharacterEncoding("UTF-8");
		String productName = req.getParameter("productName");
		Float unitPrice = Float.parseFloat(req.getParameter("unitPrice")); 
		Integer quantity = Integer.parseInt( req.getParameter("quantity"));
		Integer categoryID = Integer.parseInt(req.getParameter("categoryID")) ;
		String color = req.getParameter("color");
		String describe = req.getParameter("describe");
		Integer supplierID = Integer.parseInt(req.getParameter("supplierID")) ;
		Integer productID = Integer.parseInt(req.getParameter("productID")) ;
		
		System.out.println(productName);
		Product product = productService.findById(productID);
		
		
		product.setCategory(categoryService.findById(categoryID));
		product.setColor(color);
		product.setSupplier(supplierService.findById(supplierID));
		product.setProductName(productName);
		product.setUnitPrice(unitPrice);
		product.setQuantity(quantity);
		product.setDescription(describe);
		
		Part imagePart = req.getPart("image");
	    if (imagePart != null) {
	    	
			File dir = new File("D:\\Downloads\\Spring Tool Suite 4\\Project\\DemoSTS2\\src\\main\\webapp\\files\\product");
			if(!dir.exists()) {
				dir.mkdirs();
			}
			System.out.println(dir.getAbsolutePath());
			
			String imageName = imagePart.getSubmittedFileName();
			File photoFile = new File(dir,imageName);
			imagePart.write(photoFile.getAbsolutePath());
			
	       
	        if (imageName != null && !imageName.isEmpty()) {

	            product.setImage(imageName);
	        }
	    }
	    else {
	    	product.setImage("default.png");
		}
	    
		Product productReturn = productService.update(product);
		if(productReturn != null)
		{
		resp.setStatus(204);	
		}else {
			resp.setStatus(400);	
		}
	}
	private void doPostCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VAO DO POST CREATE");
		resp.setContentType("application/json");
		String productName = req.getParameter("productName");
		Float unitPrice = Float.parseFloat(req.getParameter("unitPrice")); 
		Integer quantity = Integer.parseInt( req.getParameter("quantity"));
		Integer categoryID = Integer.parseInt(req.getParameter("categoryID")) ;
		String color = req.getParameter("color");
		String oldavt = req.getParameter("oldavt");
		String describe = req.getParameter("describe");
		Integer supplierID = Integer.parseInt(req.getParameter("supplierID")) ;

		
		Product product = new Product();
		
		product.setCategory(categoryService.findById(categoryID));
		product.setColor(color);
		product.setSupplier(supplierService.findById(supplierID));
		product.setProductName(productName);
		product.setUnitPrice(unitPrice);
		product.setQuantity(quantity);
		product.setDescription(describe);
		
		
	    Part imagePart = req.getPart("image");
	    if (imagePart != null) {
	    	
			File dir = new File("D:\\Downloads\\Spring Tool Suite 4\\Project\\DemoSTS2\\src\\main\\webapp\\files\\product");
			if(!dir.exists()) {
				dir.mkdirs();
			}
			System.out.println(dir.getAbsolutePath());
			
			String imageName = imagePart.getSubmittedFileName();
			File photoFile = new File(dir,imageName);
			imagePart.write(photoFile.getAbsolutePath());
			
	       
	        if (imageName != null && !imageName.isEmpty()) {

	            product.setImage(imageName);
	        }
	    }
	    else {
	    	product.setImage(oldavt);
		}
	    
		
		Product productReturn = productService.create(product);
		if(productReturn != null)
		{
		resp.setStatus(204);	
		}else {
			resp.setStatus(400);	
		}
	}
	

}
