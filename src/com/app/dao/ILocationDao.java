package com.app.dao;

import java.util.List;

import com.app.model.Location;

public interface ILocationDao {
public int saveLocation(Location loc);
public List<Location> getAllLoc();
public void deleteLocById(int locId);
public Location getLocationById(int locId);
public void updateLocation(Location loc);
public List<Object[]> getLocationTypeWiseCount();
public boolean isLocationNameExit(String locName);
public boolean isLocationContainVendor(int locId);

}
