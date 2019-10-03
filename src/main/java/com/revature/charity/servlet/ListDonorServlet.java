package com.revature.charity.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.controller.ListDonorController;

/**
 * Servlet implementation class ListDonorServlet
 */
public class ListDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDonorController listDonorControl = new ListDonorController();
		String json = null;
		json = listDonorControl.listDonor();
		
		PrintWriter out = response.getWriter();
		out.write(json);
	}

}
