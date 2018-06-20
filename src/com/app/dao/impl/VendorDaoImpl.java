package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {

	@Autowired
	private HibernateTemplate ht;

	public int saveVendor(Vendor ven) {

		return (Integer) ht.save(ven);
	}

	public void deleteVendor(int venId) {

		ht.delete(new Vendor(venId));
	}

	public void updateVendor(Vendor ven) {
		ht.update(ven);

	}

	public Vendor getVendorById(int venId) {

		return ht.get(Vendor.class, venId);
	}

	public List<Vendor> getAllVendors() {

		return ht.loadAll(Vendor.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getVendorLocationByCount() {
		String hql=" select loc.locName,count(loc.locName) from "
				+Vendor.class.getName()+" group by loc.locName ";

		return ht.find(hql);
	}

	@Override
	public boolean isVenEmailExist(String venEmail) {
		boolean flag=false;
		String hql="from "+Vendor.class.getName()+" where venMail=?";
	@SuppressWarnings("unchecked")
	List<Vendor> list=	ht.find(hql,venEmail);
	if(list!=null&&list.size()>0)
	{
		flag=true;
	}
		return flag;
	}

	@Override
	public boolean isVenNameExist(String venName) {
		boolean flag=false;
		String hql="from "+Vendor.class.getName()+" where venName=?";
	@SuppressWarnings("unchecked")
	List<Vendor> list=	ht.find(hql,venName);
	if(list!=null&&list.size()>0)
	{
		flag=true;
	}
		return flag;
	}
}
