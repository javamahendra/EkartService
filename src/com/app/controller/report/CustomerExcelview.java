package com.app.controller.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Customer;

public class CustomerExcelview extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
		HSSFSheet sheet=book.createSheet("Customer Details");
		List<Customer> cust=(List<Customer>)map.get("custListObj");
		setHeaders(sheet);
		setBody(sheet,cust);
		
	}
	
	public void setHeaders(HSSFSheet sheet)
	{
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("CustomerId");
		row.createCell(1).setCellValue("CustomerName");
		row.createCell(2).setCellValue("CustomerEmail");
		row.createCell(3).setCellValue("CustomerAddress");
		row.createCell(4).setCellValue("CustomerPassword");
		row.createCell(5).setCellValue("CustomerToken");
		
	}
	public void setBody(HSSFSheet sheet,List<Customer> list)
	{
		int rowId=1;
		for(Customer cus:list)
		{
		HSSFRow row=sheet.createRow(rowId++);
		row.createCell(0).setCellValue(Integer.toString(cus.getCustId()));
		row.createCell(1).setCellValue(cus.getCustName());
		row.createCell(2).setCellValue(cus.getCustEmail());
		row.createCell(3).setCellValue(cus.getCustAddr());
		row.createCell(4).setCellValue(cus.getPassword());
		row.createCell(5).setCellValue(cus.getAccTock());
		}
		
	}
}
