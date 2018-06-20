

package com.app.controller;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;
import com.app.validator.LocationValidator;
@Controller
public class LocationController {
	
	@Autowired
	private ServletContext context;
	@Autowired
	private LocationUtil util;
	@Autowired
	private ILocationService serv;
	
	@Autowired
	private LocationValidator validator;
	@RequestMapping("/LocReg")	
	public String showViewName()
	{
		return "LocationRegister";
	}
	@RequestMapping(value="/InsertLoc",method=RequestMethod.POST)
	public String shwMsg(@ModelAttribute("location")Location loc,ModelMap map)
	{

		String errMsg=validator.LocationExit(loc.getLocName());
		String idErrMsg=validator.locIdExiat(loc.getLocId());
		if("".equals(idErrMsg))
		{
		if("".equals(errMsg))
		{
		
			loc.setD(Calendar.getInstance().getTime());
		
		
		int locId=serv.saveLocation(loc);
		String msg="location inserted with id:"+locId;
		map.addAttribute("msg", msg);
		}
		else
		{
			map.addAttribute("msg",errMsg);
		}
		}
		else
		{
			map.addAttribute("msg",idErrMsg);
		}

		return "LocationRegister";
	
	}
	@RequestMapping("/ShowLocs")
	public String showAllLocs(ModelMap map)
	{


		List<Location> listObj=serv.getAllLocs();
		if(listObj!=null&&listObj.size()>=1)
		{
		Collections.sort(listObj);
		map.addAttribute("listObj",listObj);
		}

		return "LocationData";
	}

	@RequestMapping("/DeleteLoc")
	public String deleteLoc(@RequestParam("locId")int locId,ModelMap map)
	
	{
		String errMsg=validator.isLocationExistInVendor(locId);
		if("".equals(errMsg))
		{
			serv.deleteLocById(locId);
		}
	
	
		return "redirect:ShowLocs";
	}

	@RequestMapping(value="/UpdateLoc",method=RequestMethod.POST)
	public String UpdateLoc(@ModelAttribute("location")Location loc)
	
	{
		serv.updateLocation(loc);
		return "redirect:ShowLocs";
	}
	@RequestMapping("/EditLoc")
	public String getLoc(@RequestParam("locId")int locId,ModelMap map)
	
	{
		Location loc=serv.getLocationById(locId);
		map.addAttribute("locObj",loc);
		
		return "LocationDataEdit";
	}
//	7. Excel Export
	@RequestMapping("/locExcel")
	public String excelExport(ModelMap map)
	{
		List<Location> locListObj=serv.getAllLocs();
		map.addAttribute("locListObj",locListObj);
		return "LocationExcel";
	}
//	8. PDF Export
	@RequestMapping("/locPdf")
	public String pdflExport(ModelMap map)
	{
		List<Location> locListObj=serv.getAllLocs();
		map.addAttribute("locListObj",locListObj);
		return "LocationPdf";
	}

//	10 PieChart
	@RequestMapping("/viewLocReport")
	public String generateChart()
	{
		List<Object[]> ob=serv.getLocationTypeWiseCount();
		String path=context.getRealPath("/");
		util.generatePie(path, ob);
		util.generateBar(path, ob);
		return "locationReport";
	}
//	11. id validation on server using ajax
	@RequestMapping("/checkId")
//	ResponseBody will convert view name to msg to ajax
//lId is the locId mentioned in ajax data.
	public @ResponseBody String chechId(@RequestParam("lId")int locId)
	{
		Location loc=serv.getLocationById(locId);
		String msg="";
//		it is true when id already exist.
		if(loc!=null)
		{
			msg="Location already Registered with:"+locId;
		}
//		else 
//		{
//			msg="carry-on";
//		}
		return msg;
	}
	
}

