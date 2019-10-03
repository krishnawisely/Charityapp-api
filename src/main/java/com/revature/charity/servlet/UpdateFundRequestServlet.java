package com.revature.charity.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.controller.UpdateFundRequestController;
import com.revature.charity.model.FundRequest;

/**
 * Servlet implementation class UpdateFundRequestServlet
 */
public class UpdateFundRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateFundRequestController updateFundControl = new UpdateFundRequestController();
		FundRequest fundRequest = new FundRequest();
		
		String requestId = request.getParameter("id");
		String requestType = request.getParameter("requestType");
		String description = request.getParameter("description");
		String amount = request.getParameter("amount");
		String expireDate = request.getParameter("expireDate");
		
		Integer id = Integer.parseInt(requestId);
		Double fundAmount = Double.parseDouble(amount);
		LocalDate date = LocalDate.parse(expireDate);
		
		fundRequest.setId(id);
		fundRequest.setRequestType(requestType);
		fundRequest.setDescription(description);
		fundRequest.setAmount(fundAmount);
		fundRequest.setExpireDate(date);
		String json = updateFundControl.updateFundRequest(fundRequest);
		
		PrintWriter out = response.getWriter();
		out.write(json);
	}

	

}
