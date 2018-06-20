package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
public class DocumentController {

	@Autowired
	private IDocumentService service;
	//1.show Upload page with data
	 @RequestMapping("/showDocs")
	 public String showPage(ModelMap map){
	  List<Object[]> list=service.
	                    getFileIdAndNames();
	  map.addAttribute("docsData", list);
	  return "Documents";
	 }
	 //2.doUpload
	 @RequestMapping(value="/insertDoc",method=RequestMethod.POST)
	 public String saveDoc(@RequestParam("fid")int fileId, @RequestParam("fileObj") CommonsMultipartFile cmfile){

	  if(cmfile!=null){
	   Document doc=new Document();
	   //convert UI data to model obj
	   doc.setFileId(fileId);
	   doc.setFileName(cmfile.
	               getOriginalFilename());
	   doc.setFileData(cmfile.getBytes());
		//save model Obj using service
	    service.saveDocument(doc);
	  }
	  return "redirect:showDocs";
	}
	//3.doDownload
	@RequestMapping("/downloadFile")
	public void downloadData(
	    @RequestParam("fileId")int docId,
	      HttpServletResponse res){
	 //get Document obj by id
	 Document doc=service.getDocById(docId);
	 //add "Download header"
	 res.addHeader("Content-Disposition",
	      "attachment;filename="
	             +doc.getFileName());
	 //copy data to output stream
	  try {
	    FileCopyUtils.copy(
	             doc.getFileData(), 
		     res.getOutputStream() );
	  } catch (IOException e) {}
	}
}
