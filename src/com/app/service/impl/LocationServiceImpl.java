package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;
@Service
public class LocationServiceImpl implements ILocationService{

	@Autowired
	private ILocationDao dao;
	public int saveLocation(Location loc) {
		return dao.saveLocation(loc);
	}
	@Override
	public List<Location> getAllLocs() {
		
		return dao.getAllLoc();
	}
@Override
	public void deleteLocById(int locId) {
	
		dao.deleteLocById(locId);
	}
@Override
public Location getLocationById(int locId) {
	// TODO Auto-generated method stub
	return dao.getLocationById(locId);
}
@Override
public void updateLocation(Location loc) {

	dao.updateLocation(loc);
	
}	

@Override
public List<Object[]> getLocationTypeWiseCount() {
	
	return dao.getLocationTypeWiseCount();
}
@Override
public boolean isLocationNameExit(String locName) {
	
	return dao.isLocationNameExit(locName);
}
@Override
public boolean isLocationContainVendor(int locId) {
	
	return dao.isLocationContainVendor(locId);
}
}
