package com.revature.charity.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.controller.ListFundedDonorController;

/**
 * Servlet implementation class ListFundedDonorServlet
 */
public class ListFundedDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListFundedDonorController donorControllerObj = new ListFundedDonorController();
		String json = null;
		json = donorControllerObj.listFundedDonors();
		
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}
