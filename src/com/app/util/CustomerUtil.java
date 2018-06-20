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

import com.app.model.Customer;
import com.app.service.ICustomerService;

@Component
public class CustomerUtil {
	@Autowired
private ICustomerService service;

	public List<Customer> getAllCustomers()
	{
		return service.getAllCustomers();
	}
	
	public void generatePieChart(String path,List<Object[]> ob)
	{
		
		DefaultPieDataset dataset=new DefaultPieDataset();
		
		for(Object[] obj:ob)
		{
			dataset.setValue(obj[0].toString(), new Double(obj[1].toString()));
		}
		JFreeChart chart =ChartFactory.createPieChart3D("Customer Report", dataset, true, true, false);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/customerAReport.jpg"), chart, 400, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void generateBarchart(String path,List<Object[]> ob)
	{
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
		for(Object[] obj:ob)
		{
			dataset.setValue(new Double(obj[1].toString()),obj[0].toString(),"");
		}
		JFreeChart chart=ChartFactory.createBarChart3D("Customer Report", "Location Name", "location Count", dataset);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/customerBReport.jpg"), chart, 400, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
