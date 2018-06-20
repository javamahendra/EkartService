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

import com.app.model.Customer;
import com.app.model.Item;
import com.app.model.Location;
import com.app.service.ICustomerService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.CommonUtil;
import com.app.util.CustomerUtil;
import com.app.util.LocationUtil;
import com.app.validator.CustomerValidator;

/**
 * @author krishnareddy
 *
 */
@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;

	@Autowired
	private LocationUtil locUtil;

	@Autowired
	private CustomerUtil custUtil;

	@Autowired
	private ServletContext context;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CodecUtil codecUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	CustomerValidator validator;

	// 1.Customer Reg Page
	@RequestMapping(value = "/custReg")
	public String showRegistration(ModelMap map) {
		List<Location> loc = locUtil.getAllLocations();
		map.addAttribute("locUtilObj", loc);
		return "CustomerRegistration";
	}

	// 2.save Customer
	@RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer cust,
			ModelMap map) {
		String msg="";
//		custid validation
		if(validator.isIdExist(cust.getCustId()))
		{
			
			msg="customer already registered withn id :"+cust.getCustId();
			map.addAttribute("msg", msg);
		}
//		custEmail validation
		else if(validator.isEmailExist(cust.getCustEmail()))
		{
			msg="customer Email already registered withn Emailid :"+cust.getCustEmail();
			map.addAttribute("msg", msg);
		}
//		saving cust obj
			else
			{

				cust.setPassword(codecUtil.doEncode(codeUtil.getPwd()));
				cust.setAccTock(codecUtil.doEncode(codeUtil.getToken()));
				int custId = service.saveCustomer(cust);
				String body="your userName-"+cust.getCustEmail()+
						" your password-"+codecUtil.doDecode(cust.getPassword())+
						" your AccesToken-"+codecUtil.doDecode(cust.getAccTock());
//			sending email
				commonUtil.sendEmail(cust.getCustEmail(),"Registered Successfully",body);
				 msg = "Customer Details Stored with Id :" + custId;
				map.addAttribute("msg", msg);
			}
		
		
		
		return "CustomerRegistration";
	}

	// 3. display Customer Data
	@RequestMapping("viewCustomerData")
	public String getCustomerdata(ModelMap map) {
		List<Customer> custObj = service.getAllCustomers();
		Collections.sort(custObj);
		map.addAttribute("custObj", custObj);
		return "CustomerData";
	}

	// 4.delete customer
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("custId") int custId) {
		service.deleteCustomer(custId);
		return "redirect:viewCustomerData";
	}

	// 5.edit customer
	@RequestMapping(value = "/editCustomer")
	public String getCustomer(@RequestParam("custId") int custId, ModelMap map) {
		List<Location> locListObj = locUtil.getAllLocations();
		map.addAttribute("locListObj", locListObj);
		Customer cust = service.getCustomerById(custId);
		map.addAttribute("custObj", cust);
		return "CustomerDataEdit";
	}

	// 6.update Customer
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer") Customer cust) {
		service.updateCustomer(cust);

		return "redirect:viewCustomerData";
	}

	// 7. customer Excel Export
	@RequestMapping("/customerExcel")
	public String custExcelExport(ModelMap map) {
		List<Customer> custListObj = custUtil.getAllCustomers();
		map.addAttribute("custListObj", custListObj);
		return "customerExcel";
	}

	// 8. cust Pdf Export
	@RequestMapping("/customerPdf")
	public String custPdflExport(ModelMap map) {
		List<Customer> custListObj = custUtil.getAllCustomers();
		map.addAttribute("custListObj", custListObj);
		return "customerPdf";
	}

	// 9. Chart Generators
	@RequestMapping("/customerChart")
	public String custChart() {
		List<Object[]> ob = service.getCustomerLocationsByCountWise();
		String path = context.getRealPath("/");
		custUtil.generateBarchart(path, ob);
		custUtil.generatePieChart(path, ob);

		return "customerReport";
	}
//	10 ajax id call
	
	@RequestMapping("/checkCustId")
	public @ResponseBody String isIdExist(@RequestParam("cId")int custId)
	{
		String msg="";
	if(validator.isIdExist(custId))
	{
		msg="already registered with id :"+custId;
	}
	return msg;
	}
//	11 ajax email check
	@RequestMapping("/checkCustEmail")
	public @ResponseBody String isIdExist(@RequestParam("cEmail")String custEmail)
	{
		String msg="";
		
	if(validator.isEmailExist(custEmail))
	{
		msg="already registered with id :"+custEmail;
	}
	return msg;
	}
//	12 get items based on customer id
	@RequestMapping("/showItems")
	public String showItems(@RequestParam("custId")int custId,ModelMap map){
		List<Item> listItemObj=service.getItemByCustId(custId);
		map.addAttribute("listItemObj",listItemObj);
		return "ItemData";
	}
	@RequestMapping("/showTranxs")
	public String showTransactions(@RequestParam("custId")int custId,ModelMap map){
		List<Item> listTxObj=service.getTransactionByCustId(custId);
		map.addAttribute("listTxObj",listTxObj);
		return "TransactionData";
	}
}
