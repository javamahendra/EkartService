package com.app.controller.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Location;

public class LocationExcelView extends AbstractExcelView{
@Override
protected void buildExcelDocument(Map<String, Object> map,
		HSSFWorkbook book, HttpServletRequest arg2, HttpServletResponse arg3)
		throws Exception {
	// TODO Auto-generated method stub
	HSSFSheet sheet=book.createSheet("Location DataS");
	@SuppressWarnings("unchecked")
	List<Location> loc=(List<Location>)map.get("locListObj");
	setHeaders(sheet);
	setRows(sheet,loc);
}
public void setHeaders(HSSFSheet sheet)
{
	HSSFRow row=sheet.createRow(0);
	row.createCell(0).setCellValue("Locations Id");
	row.createCell(1).setCellValue("Location Name");
	row.createCell(2).setCellValue("Location Type");
	row.createCell(3).setCellValue("ShippingTypes");
	row.createCell(4).setCellValue("PinCode");
	row.createCell(5).setCellValue("ProcessingCode");
	
}
public void setRows(HSSFSheet sheet,List<Location> list)
{
	int rowid=1;
	for(Location loc:list)
	{
		HSSFRow row=sheet.createRow(rowid++);
		row.createCell(0).setCellValue(loc.getLocId());
		row.createCell(1).setCellValue(loc.getLocName());
		row.createCell(2).setCellValue(loc.getLocType());
		row.createCell(3).setCellValue(loc.getShippingTypes());
		row.createCell(4).setCellValue(loc.getPinCode());
		row.createCell(5).setCellValue(loc.getProcesspCode());
	}
}
}
