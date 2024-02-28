package com.sgu.controller.admin;

import java.io.File;
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
import javax.servlet.http.Part;

import com.sgu.constant.SessionAttribute;
import com.sgu.entity.Category;
import com.sgu.entity.Product;
import com.sgu.entity.User;
import com.sgu.service.CategoryService;
import com.sgu.service.impl.CategoryServiceImpl;


@WebServlet(urlPatterns = { "/adcategory" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 4831006733887366260L;

	private CategoryService categoryService = new CategoryServiceImpl();
	
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
		List<Category> categories = categoryService.findAll();
		req.setAttribute("categories", categories);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/category/view.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetDelete(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		Category category = categoryService.delete(id);
		
		if(category != null)
		{
		resp.setStatus(204);	
		}else {
			resp.setStatus(400);	
		}
	}
	private void doGetCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/category/create.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetEdit(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = categoryService.findById(id);
		req.setAttribute("category", category);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/category/edit.jsp");
		requestDispatcher.forward(req, resp);
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
	private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VAO DO POST EDIT");

		req.setCharacterEncoding("UTF-8");
		String categoryName = req.getParameter("categoryName");
		Integer categoryID = Integer.parseInt( req.getParameter("categoryID"));
		

		Category category = categoryService.findById(categoryID);
		category.setCategoryName(categoryName);
		
	
	    
		Category e = categoryService.update(category);
		if(e != null)
		{
		resp.sendRedirect("adcategory");	
		}else {
		
		}
	}
	private void doPostCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VAO DO POST CREATE");

		String categoryName = req.getParameter("categoryName");
		System.out.print(categoryName);

		
		Category category = new Category();
		
		category.setCategoryName(categoryName);

	
	    
		
		Category e = categoryService.create(category);
		if(e != null)
		{
		resp.sendRedirect("adcategory");	
		}else {
		
		}
	}

}
