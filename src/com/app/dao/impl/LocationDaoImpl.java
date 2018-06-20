package com.app.dao.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.model.Vendor;

@Repository
public class LocationDaoImpl implements ILocationDao {

	@Autowired
	private HibernateTemplate ht;
	public int saveLocation(Location loc) {
		
		return (Integer)ht.save(loc);

	}
	@Override
	public List<Location> getAllLoc() {
		
		return ht.loadAll(Location.class);
	}

	@Override
	public void deleteLocById(int locId) {
		ht.delete(new Location(locId));
		
	}
	@Override
	public Location getLocationById(int locId) {
		
		return ht.get(Location.class, locId);
	}
	
	public void updateLocation(Location loc) {
		
		ht.update(loc);
		
	}
	@Override
	public List<Object[]> getLocationTypeWiseCount() {
		String hql=" select locType,count(locType) from "
				+Location.class.getName()+" group by "
				+" locType ";
		
		return ht.find(hql);
	}
	@Override
	public boolean isLocationNameExit(String locName) {
		
		boolean flag=false;
		String hql="from "+Location.class.getName()+" where locName=?";
		List<Location> list= ht.find(hql,locName);
		if(list!=null&&list.size()>0)
		{
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean isLocationContainVendor(int locId) {
		boolean flag=false;
		String hql="from "+Vendor.class.getName()+" v join v.loc as l where v.loc.locId=?";
		List<Vendor> list=ht.find(hql,locId);
		if(list!=null&&list.size()>0)
		{
			flag=true;
		}
		
		return flag;
	}
}
