package com.revature.charity.controller;

import com.google.gson.JsonObject;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Donor;
import com.revature.charity.service.DonorService;
import com.revature.charity.service.DonorServiceImpl;

public class DonorRegisterController {
	public String donorRegister(Donor donor) {
		Boolean result = false;
		String errorMessage = null;
		DonorService service = new DonorServiceImpl();
		try {
			result = service.donorRegister(donor);
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
		}

		String json = null;

		if (result) {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("isStatus", result);
			json = jsonObj.toString();
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", errorMessage);
			json = jsonObj.toString();
		}
		return json;
	}

	
}
