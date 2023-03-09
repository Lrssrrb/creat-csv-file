package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
  
  
@RestController
public class Controller {

  @Autowired
  HttpServletResponse httpServletResponse;
  
  @GetMapping
  public void genrateCsv() {
	try {	
		  httpServletResponse.setContentType("text/csv");
		  httpServletResponse.setHeader("Content-Disposition", "attachment; filename=customersFileName.csv");
		  CsvBeanWriter csvBeanWriter = new CsvBeanWriter(httpServletResponse.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		  String[] HTMLHeadingElement = {"ONE","TWO","THREE"};
		  String[] classPro = {"one","two","three"};

		  csvBeanWriter.writeHeader(HTMLHeadingElement);

		  ClassCsv zegoOtpRequest = new ClassCsv("1","2L","jkb");

		  csvBeanWriter.write(zegoOtpRequest, classPro);
		  csvBeanWriter.close();

	} catch (IOException e) {
	  	e.printStackTrace();
	}
}
