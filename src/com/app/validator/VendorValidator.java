package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Vendor;
import com.app.service.IVendorService;
@Component
public class VendorValidator {

	@Autowired
	private IVendorService service;
	
	public String venEmailExist(String venMail)
	{
		String msg="";
		if(service.isVenEmailExist(venMail))
		{
			msg="Email Already Exist :"+venMail;
		}
		return msg;
	}
	public String venNameExist(String venName)
	{
		String msg="";
		if(service.isVenNameExist(venName))
		{
			msg="VendorName Already Exist :"+venName;
		}
		return msg;
	}
	public String venIdExist(int venId)
	{
		String msg="";
		Vendor ven=service.getVendorById(venId);
		if(ven!=null)
		{
			msg="Vendor Id Already Exist with :"+venId;
		}
		return msg;
	}
}
