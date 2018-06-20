package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {
	
	@Autowired
	private IDocumentDao dao;

	
	public void saveDocument(Document doc) {
	dao.saveDocument(doc);

	}

	
	public List<Object[]> getFileIdAndNames() {
		
		return dao.getFileIdAndNames();
	}

	
	public Document getDocById(int docId) {
		
		return dao.getDocById(docId);
	}

}
