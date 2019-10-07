package com.revature.charity.controller;

import com.google.gson.JsonObject;
import com.revature.charity.model.Transaction;
import com.revature.charity.service.TransactionService;
import com.revature.charity.service.TransactionServiceImpl;

public class TransactionController {
	
	public String transaction(Transaction transactionObj)
	{
		TransactionService service = new TransactionServiceImpl();
	
			Boolean status = service.transaction(transactionObj);
			String json = null;
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("status", status);
			json = jsonObj.toString();
		
		return json;
	}

}
