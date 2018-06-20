package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocationValidator {
	@Autowired
	private ILocationService service;

	public String LocationExit(String locName)
	{
		String msg="";
		if(service.isLocationNameExit(locName))
		{
			msg="' "+locName+" ' already Exist";
		}
		return msg;
	}
	public String isLocationExistInVendor(int locId)
	{
		String msg="";
		if(service.isLocationContainVendor(locId))
		{
			msg="Location Registered In Vendor";
		}
		return msg;
	}
	
	public String locIdExiat(int locId)
	{
		String msg="";
		Location loc=service.getLocationById(locId);
		if(loc!=null)
		{
			msg="Location already Registered with Id :"+locId;
		}
		return msg;
	}
}
