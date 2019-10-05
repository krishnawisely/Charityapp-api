package com.revature.charity.controller;

import com.google.gson.JsonObject;
import com.revature.charity.model.FundRequest;
import com.revature.charity.service.FundRequestService;
import com.revature.charity.service.FundRequestServiceImpl;

public class UpdateFundRequestController {
	
	public String updateFundRequest(FundRequest fundRequest)
	{
		FundRequestService fundService = new FundRequestServiceImpl();
		
		 Boolean isFundUpdated = fundService.updateFundRequest(fundRequest);
		 
		 String json = null;
		 JsonObject jsonObj = new JsonObject();
		 if(isFundUpdated)
		 {
//			 json = "{\"isFundUpdated\":\""+isFundUpdated+"\"}";
			 jsonObj.addProperty("isFundUpdated", isFundUpdated);
			 json = jsonObj.toString();
		 } else {
//			 json = "{\"isFundUpdated\":\""+isFundUpdated+"\"}";
			 jsonObj.addProperty("isFundUpdated", isFundUpdated);
			 json = jsonObj.toString();
		 }
		return json;
	}

}
