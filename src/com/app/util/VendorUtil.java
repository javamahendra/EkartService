package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Vendor;
import com.app.service.IVendorService;

@Component
public class VendorUtil {

	@Autowired
	private IVendorService service;

	public List<Vendor> getAllVendors() {
		return service.getAllVendors();
	}
	public List<Object[]> getAllVensByCount()
	{
		return service.getVendorLocationByCount();
	}

	public void generatePieChart(String path, List<Object[]> list) {
		// converting list to datasSet

		DefaultPieDataset dataset = new DefaultPieDataset();
		// converting list object to dataSet
		for (Object[] li : list) {
			dataset.setValue(li[0].toString(), new Double(li[1].toString()));

			// dataSet to jfree obj
			JFreeChart chart = ChartFactory.createPieChart("Vendor Report",
					dataset, true, true, false);

			// jfree obj to image
			try {
				ChartUtilities.saveChartAsJPEG(
						new File(path + "/venARept.jpg"), chart, 400, 300);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void generateBarChart(String path, List<Object[]> list) {
		// converting list to dataSet
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Object[] ob : list) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), "");
		}
		// creating jfree obj
		JFreeChart chart = ChartFactory.createBarChart("vendor report",
				"Location name", "location Count", dataset);

		// jfree to image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/venBRept.jpg"),
					chart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
