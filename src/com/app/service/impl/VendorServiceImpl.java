package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	private IVendorDao dao;

	@Override
	public int saveVendor(Vendor ven) {
		// TODO Auto-generated method stub
		return dao.saveVendor(ven);
	}

	@Override
	public void deleteVendor(int venId) {
		// TODO Auto-generated method stub
		dao.deleteVendor(venId);
	}

	@Override
	public void updateVendor(Vendor ven) {
		// TODO Auto-generated method stub
		dao.updateVendor(ven);
	}

	@Override
	public Vendor getVendorById(int venId) {
		// TODO Auto-generated method stub
		return dao.getVendorById(venId);
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return dao.getAllVendors();
	}

	@Override
	public List<Object[]> getVendorLocationByCount() {
		return dao.getVendorLocationByCount();
	}

	@Override
	public boolean isVenEmailExist(String venEmail) {
		
		return dao.isVenEmailExist(venEmail);		
	}

	@Override
	public boolean isVenNameExist(String venName) {
		
		return dao.isVenNameExist(venName);
	}
}
