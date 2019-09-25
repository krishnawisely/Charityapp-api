package com.revature.charity.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.controller.DonorLoginController;
import com.revature.charity.model.Donor;

/**
 * Servlet implementation class DonorServlet
 */
//@WebServlet("DonorLoginServlet")
public class DonorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Donor donor = new Donor();
		DonorLoginController loginController = new DonorLoginController();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		donor.setEmail(email);
		donor.setPassword(password);

		String json = loginController.donorLogin(donor);

		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
