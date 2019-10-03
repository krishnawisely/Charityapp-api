package com.revature.charity.controller;

import com.revature.charity.model.Transaction;
import com.revature.charity.service.TransactionService;
import com.revature.charity.service.TransactionServiceImpl;

public class TransactionController {
	
	public String transaction(Transaction transactionObj)
	{
		TransactionService service = new TransactionServiceImpl();
	
			Boolean status = service.transaction(transactionObj);
			String json = "{\"status\"" +":"+ "\"" + status + "\"}";
		
		return json;
	}

}
