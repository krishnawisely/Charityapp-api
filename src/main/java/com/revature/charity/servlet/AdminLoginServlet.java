package com.revature.charity.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.controller.AdminLoginController;
import com.revature.charity.model.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Admin admin = new Admin();
		AdminLoginController loginController = new AdminLoginController();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		admin.setEmail(email);
		admin.setPassword(password);
		String json = loginController.adminLogin(admin);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
