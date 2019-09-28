package com.revature.charity.controller;

import com.revature.charity.model.FundRequest;
import com.revature.charity.service.FundRequestService;
import com.revature.charity.service.FundRequestServiceImpl;

public class UpdateFundRequestController {
	
	public String updateFundRequest(FundRequest fundRequest)
	{
		FundRequestService fundService = new FundRequestServiceImpl();
		
		 Boolean isFundUpdated = fundService.updateFundRequest(fundRequest);
		 
		 String json = null;
		 
		 if(isFundUpdated)
		 {
			 json = "{\"isFundUpdated\":\""+isFundUpdated+"\"}";
		 } else {
			 json = "{\"isFundUpdated\":\""+isFundUpdated+"\"}";
		 }
		return json;
	}

}
