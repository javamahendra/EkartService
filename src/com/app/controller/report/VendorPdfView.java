package com.app.controller.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView {
@Override
protected void buildPdfDocument(Map<String, Object> map, Document document,
		PdfWriter arg2, HttpServletRequest arg3, HttpServletResponse arg4)
		throws Exception {
	PdfPTable table=new PdfPTable(7);
	table.addCell("VendorId");
	table.addCell("VendorName");
	table.addCell("VendorMail");
	table.addCell("VendorMobile");
	table.addCell("VendorAddress");
	table.addCell("VendorLocation");
	table.addCell("VendorLocationType");
	@SuppressWarnings("unchecked")
	List<Vendor> ven=(List<Vendor>)map.get("venListObj");
	for(Vendor l:ven)
	{
		table.addCell(Integer.toString(l.getVenId()));
		table.addCell(l.getVenName());
		table.addCell(l.getVenMail());
		table.addCell(l.getMobile());
		table.addCell(l.getAddress());
		table.addCell(l.getLoc().getLocName());
		table.addCell(l.getLoc().getLocType());
	}
	Paragraph p=new Paragraph();
	document.add(p);
	document.add(table);
	
	
}
}
