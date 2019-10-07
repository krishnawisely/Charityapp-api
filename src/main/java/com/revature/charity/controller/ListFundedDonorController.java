package com.revature.charity.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Donor;
import com.revature.charity.service.DonorService;
import com.revature.charity.service.DonorServiceImpl;

public class ListFundedDonorController {

	public String listFundedDonors()
	{
	
		
			List<Donor> listDonor = null;
			String errorMessage = null;
			DonorService donorServiceObj = new DonorServiceImpl();
			try {
			listDonor = donorServiceObj.listFundedDonor();
			} catch (ServiceException e) {
				errorMessage = e.getMessage();
			}
			String json = null;
			if(listDonor != null)
			{
				Gson gson = new Gson();
				json = gson.toJson(listDonor);
			} else {
				JsonObject jsonObj = new JsonObject();
				jsonObj.addProperty("ERROR_MESSAGE", errorMessage);
			}
		
			return json;
	}
	
}
