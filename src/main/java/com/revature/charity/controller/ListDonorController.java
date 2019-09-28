package com.revature.charity.controller;

import java.util.List;

import com.google.gson.Gson;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Donor;
import com.revature.charity.service.DonorService;
import com.revature.charity.service.DonorServiceImpl;
import com.revature.charity.util.Logger;

public class ListDonorController {
	public String listDonor()
	{
		DonorService donorService = new DonorServiceImpl();
		List<Donor> donorList = null;
		String errorMessage = null;
		try {
			donorList = donorService.donorList();
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
			Logger.error(e.getMessage());
		}
		//Prepare for json object
		String json = null;
		Gson gson = new Gson();
		if(errorMessage != null)
		{
			json = errorMessage;
		} else {
			json = gson.toJson(donorList);
		}
		return json;
	}
}
