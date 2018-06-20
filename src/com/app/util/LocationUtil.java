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

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocationUtil {
	@Autowired
	private ILocationService service;

	public List<Location> getAllLocations() {
		return service.getAllLocs();
	}

	public void generatePie(String path, List<Object[]> data) {
		if (data != null) {
			DefaultPieDataset dataSet = new DefaultPieDataset();
			for (Object[] ob : data) {
				dataSet.setValue(ob[0].toString(), new Double(ob[1].toString()));

			}

			JFreeChart chart = ChartFactory.createPieChart3D("Location Report",
					dataSet, true, true, false);

			try {
				ChartUtilities.saveChartAsJPEG(new File(path
						+ "/reportAloc.jpg"), chart, 400, 300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void generateBar(String path, List<Object[]> ob) {
		if (ob != null) {
			DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

			for (Object[] obj : ob) {
				dataSet.setValue(new Double(obj[1].toString()),
						obj[0].toString(), "");
			}
			JFreeChart chart = ChartFactory.createBarChart3D("Location Report",
					" Location Type", "Location Count", dataSet);
			try {
				ChartUtilities.saveChartAsJPEG(new File(path
						+ "/reportBloc.jpg"), chart, 400, 300);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
