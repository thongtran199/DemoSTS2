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
import com.sgu.entity.Category;
import com.sgu.entity.Supplier;
import com.sgu.entity.User;
import com.sgu.service.SupplierService;
import com.sgu.service.impl.SupplierServiceImpl;


@WebServlet(urlPatterns = { "/adsupplier" })
public class SupplierController extends HttpServlet {

	private static final long serialVersionUID = 4831006733887366260L;

	private SupplierService supplierService = new SupplierServiceImpl();
	
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
				break;
			default:
				break;
			}
		}


	}
	private void doGetView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Supplier> suppliers = supplierService.findAll();
		req.setAttribute("suppliers", suppliers);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/supplier/view.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/supplier/create.jsp");
		requestDispatcher.forward(req, resp);
	}
	private void doGetEdit(Integer id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Supplier supplier = supplierService.findById(id);
		req.setAttribute("supplier", supplier);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/supplier/edit.jsp");
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


		String address = req.getParameter("address");
		String companyName = req.getParameter("companyName");
		String contactEmail = req.getParameter("contactEmail");
		String contactFax = req.getParameter("contactFax");
		String contactNumber = req.getParameter("contactNumber");
		String contactPerson = req.getParameter("contactPerson");
		String country = req.getParameter("country");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String zipcode = req.getParameter("zipcode");
		Integer supplierID = Integer.parseInt(req.getParameter("supplierID")) ;
		
		Supplier supplier = supplierService.findById(supplierID);
		
		supplier.setAddress(address);
		supplier.setCompanyName(companyName);
		supplier.setContactEmail(contactEmail);
		supplier.setContactFax(contactFax);
		supplier.setContactNumber(contactNumber);
		supplier.setContactPerson(contactPerson);
		supplier.setCountry(country);
		supplier.setCity(city);
		supplier.setState(state);
		supplier.setZipcode(zipcode);
		
		
	
		Supplier e = supplierService.update(supplier);
		if(e != null)
		{
		resp.sendRedirect("adsupplier");	
		}else {
		
		}
	}
	private void doPostCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VAO DO POST CREATE");


		String address = req.getParameter("address");
		String companyName = req.getParameter("companyName");
		String contactEmail = req.getParameter("contactEmail");
		String contactFax = req.getParameter("contactFax");
		String contactNumber = req.getParameter("contactNumber");
		String contactPerson = req.getParameter("contactPerson");
		String country = req.getParameter("country");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String zipcode = req.getParameter("zipcode");

		
		Supplier supplier = new Supplier();
		
		supplier.setAddress(address);
		supplier.setCompanyName(companyName);
		supplier.setContactEmail(contactEmail);
		supplier.setContactFax(contactFax);
		supplier.setContactNumber(contactNumber);
		supplier.setContactPerson(contactPerson);
		supplier.setCountry(country);
		supplier.setCity(city);
		supplier.setState(state);
		supplier.setZipcode(zipcode);

		
	
		Supplier e = supplierService.create(supplier);
		if(e != null)
		{
		resp.sendRedirect("adsupplier");	
		}else {
		
		}
	}
	

}
