package com.app.controller.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Vendor;

public class VendorExcelView extends AbstractExcelView{
@Override
protected void buildExcelDocument(Map<String, Object> map,
		HSSFWorkbook book, HttpServletRequest arg2, HttpServletResponse arg3)
		throws Exception {
	
	HSSFSheet sheet=book.createSheet("Vendor Sheet");
	List<Vendor> list=(List<Vendor>)map.get("venListObj");
	setHeaders(sheet);
	setBody(sheet,list);
}
public void setHeaders(HSSFSheet sheet)
{
	HSSFRow row=sheet.createRow(0);
	row.createCell(0).setCellValue("VendorId");
	row.createCell(1).setCellValue("VendorName");
	row.createCell(2).setCellValue("VendorMail");
	row.createCell(3).setCellValue("VendorMobile");
	row.createCell(4).setCellValue("VendorLocation");
	row.createCell(5).setCellValue("VendorLocationType");
	
}
public void setBody(HSSFSheet sheet,List<Vendor> list)
{
	int rowId=1;
	for(Vendor v:list)
	{
	HSSFRow row=sheet.createRow(rowId++);
	row.createCell(0).setCellValue(v.getVenId());
	row.createCell(1).setCellValue(v.getVenName());
	row.createCell(2).setCellValue(v.getVenMail());
	row.createCell(3).setCellValue(v.getMobile());
	row.createCell(4).setCellValue(v.getLoc().getLocName());
	row.createCell(5).setCellValue(v.getLoc().getLocType());
	}
}
}
