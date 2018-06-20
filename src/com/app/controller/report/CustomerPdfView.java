package com.app.controller.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {
		PdfPTable table=new PdfPTable(7);
		table.addCell("CustId");
		table.addCell("custName");
		table.addCell("custEmail");
		table.addCell("custAddress");
		table.addCell("custType");
		table.addCell("custLocation");
		table.addCell("custLocationType");
		List<Customer> list=(List<Customer>)map.get("custListObj");
		for(Customer l:list)
		{
			table.addCell(Integer.toString(l.getCustId()));
			table.addCell(l.getCustName());
			table.addCell(l.getCustEmail());
			table.addCell(l.getCustAddr());
			table.addCell(l.getCustType());
			table.addCell(l.getLoc().getLocName());
			table.addCell(l.getLoc().getLocType());
			
		}
		Paragraph p=new Paragraph();
		document.add(p);
		document.add(table);
		document.addTitle("CustomerDetails");
		
	}
}
