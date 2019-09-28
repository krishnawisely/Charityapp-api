package com.revature.charity.controller;

import java.time.LocalDate;

import com.google.gson.JsonObject;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Donor;
import com.revature.charity.service.DonorService;
import com.revature.charity.service.DonorServiceImpl;
import com.revature.charity.util.Logger;

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
			json = "{\"err_msg\":\"" + result + "\"}";
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", errorMessage);
			json = jsonObj.toString();
		}
		return json;
	}

	public static void main(String args[]) {
		DonorRegisterController obj = new DonorRegisterController();
		Donor donor = new Donor();
		donor.setEmail("krishna@gmail.com");
		donor.setPassword("mypass");
		LocalDate date = LocalDate.parse("1997-06-05");
		donor.setDate(date);
		donor.setGender("male");
		String json = obj.donorRegister(donor);
		Logger.debug(json);
	}
}
