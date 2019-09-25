package com.revature.charity.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Donor;
import com.revature.charity.service.DonorService;
import com.revature.charity.service.DonorServiceImpl;
import com.revature.charity.util.Logger;

public class DonorLoginController {
	public String donorLogin(Donor donor) {
		DonorService service = new DonorServiceImpl();
		Donor donorObj = null;
		String errorMsg = null;

		try {
			donorObj = service.donorSignin(donor);
		} catch (ServiceException e) {
			errorMsg = e.getMessage();
		}

		String json = null;
		Gson gson = new Gson();

		if (donorObj != null) {
			json = gson.toJson(donorObj);
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", errorMsg);
			json = jsonObj.toString();
		}
		return json;
	}

	public static void main(String[] args) {
		DonorLoginController loginController = new DonorLoginController();
		Donor donor = new Donor();
		donor.setEmail("krishna@gmail.com");
		donor.setPassword("mypass1");
		String json = loginController.donorLogin(donor);
		Logger.debug(json);
	}
}
