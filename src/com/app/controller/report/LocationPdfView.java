package com.app.controller.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocationPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {
		@SuppressWarnings("unchecked")
		List<Location> loc=(List<Location>)map.get("locListObj");
		PdfPTable table=new PdfPTable(3);
		table.addCell("LocationId");
		table.addCell("LocationName");
		table.addCell("LocationType");
		for(Location l:loc)
		{
			table.addCell(Integer.toString(l.getLocId()));
			table.addCell(l.getLocName());
			table.addCell(l.getLocType());
		}
		Paragraph p=new Paragraph();
		document.add(table);
		document.add(p);
		document.addTitle("LocationData");
		
	}

}
