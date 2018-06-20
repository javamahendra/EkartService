package com.app.controller;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Location;
import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.CommonUtil;
import com.app.util.LocationUtil;
import com.app.util.VendorUtil;
import com.app.validator.VendorValidator;

@Controller
public class VendorController {
	@Autowired
	private IVendorService serv;
	
	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private LocationUtil locUtil;

	@Autowired
	private ServletContext context;
	@Autowired
	private VendorUtil venUtil;
	
	@Autowired
	private VendorValidator validator;

	// 1.display the vendor reg page
	@RequestMapping("/venReg")
	public String showPage(ModelMap map) {
		List<Location> locListObj = locUtil.getAllLocations();
		map.addAttribute("locListObj", locListObj);
		return "VendorRegistration";
	}

	// 2.insert vendor
	@RequestMapping(value = "/insertVendor", method = RequestMethod.POST)
	public String insertVendor(@ModelAttribute("vendor") Vendor ven,
			ModelMap map,@RequestParam("fObj") CommonsMultipartFile file) {
		String msg="";
		
		String errNameMsg=validator.venNameExist(ven.getVenName());
		String errEmailMsg=validator.venEmailExist(ven.getVenMail());
		String errIdMsg=validator.venIdExist(ven.getVenId());
		if("".equals(errIdMsg))
		{
			if("".equals(errNameMsg))
			{
				if("".equals(errEmailMsg))
				{
					int venId = serv.saveVendor(ven);
					commonUtil.sendEmail(ven.getVenMail(),"welcome to vendor","your id:"+venId, file);
					msg = "Vendor Registred with id :" + venId;
					map.addAttribute("msg", msg);
				}
				else
				{
					map.addAttribute("msg", errEmailMsg);
				}
			}
			else
			{
				map.addAttribute("msg", errNameMsg);

			}
		}
		else
		{
			map.addAttribute("msg", errIdMsg);

		}
		
		 
		
		return "VendorRegistration";
	}

	// 3.display data
	@RequestMapping("/viewVendorData")
	public String getVendorData(ModelMap map) {

		List<Vendor> venListObj = serv.getAllVendors();
		Collections.sort(venListObj);
		map.addAttribute("venListObj", venListObj);
		return "VendorData";
	}

	// 4.delete vendor
	@RequestMapping("/deleteVen")
	public String deleteVendor(@RequestParam("venId") int venId) {
		serv.deleteVendor(venId);

		return "redirect:viewVendorData";
	}

	// 5.edit data
	@RequestMapping("/editVen")
	public String getVendor(@RequestParam("venId") int venId, ModelMap map) {
		List<Location> locListObj = locUtil.getAllLocations();
		map.addAttribute("locListObj", locListObj);
		Vendor ven = serv.getVendorById(venId);
		map.addAttribute("venObj", ven);

		return "VendorDataEdit";
	}

	// 6.update vendor
	@RequestMapping(value = "/updateVendor", method = RequestMethod.POST)
	public String updateVendor(@ModelAttribute("vendor") Vendor ven) {

		serv.updateVendor(ven);

		return "redirect:viewVendorData";
	}

	// 7. excel Export
	@RequestMapping("/vendorExcel")
	public String vendorExcelExport(ModelMap map) {
		List<Vendor> ven = serv.getAllVendors();
		map.addAttribute("venListObj", ven);

		return "vendorExcel";
	}

	// 7. excel Export
	@RequestMapping("/vendorPdf")
	public String vendorPdfExport(ModelMap map) {
		List<Vendor> ven = serv.getAllVendors();
		map.addAttribute("venListObj", ven);

		return "vendorPdf";
	}

	// 8. chart report
	@RequestMapping("/vendorChart")
	public String showReport(ModelMap map) {

		String path=context.getRealPath("/");
		List<Object[]> list=venUtil.getAllVensByCount();
		
		venUtil.generatePieChart(path, list);
		venUtil.generateBarChart(path, list);
		
		return "VendorReport";
	}
//	9. id validation using ajax.
	@RequestMapping("/checkvId")
	public @ResponseBody String checkId(@RequestParam("vId")int venId)
	{
		String msg1="";
	Vendor ven=	serv.getVendorById(venId);
	if(ven!=null)
	{
		msg1="Vendor already Registered with id: "+venId;
	}
	else
	{
		msg1="carry-on";
	}
		return msg1;
	}
//ajax	email validation
	
	@RequestMapping("/checkvEmail")
	public @ResponseBody String checkEmail(@RequestParam("vEmail")String venEmail)
	{
		String msg2="";
	List<Vendor> venListObj=serv.getAllVendors();
	for(Vendor ven:venListObj)
	{
	if(ven.getVenMail().equals(venEmail))
	{
		msg2="Vendor already Registered with Email: "+venEmail;
	}
	System.out.println(ven.getVenMail());
	System.out.println(venEmail);
	System.out.println(ven.getVenMail().equals(venEmail));
	}
		return msg2;
	}
	
}
