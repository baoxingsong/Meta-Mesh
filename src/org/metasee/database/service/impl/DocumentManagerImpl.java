package org.metasee.database.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.impl.DocumentDaoImpl;
import org.metasee.database.dao.DocumentDao;
import org.metasee.database.model.Document;
import org.metasee.database.model.News;
import org.metasee.database.service.DocumentManager;

public class DocumentManagerImpl implements DocumentManager {
	private DocumentDaoImpl documentDao = new DocumentDaoImpl();
	
	@Override
	public void add( Document document) throws Exception {
		documentDao.save(document);
	}

	@Override
	public Page getDocuments(int page, int recordPerPage) {
		return this.documentDao.getDocuments(page, recordPerPage);
	}

	@Override
	public Document getDocumentById(int id) {
		// TODO Auto-generated method stub
		return this.documentDao.getDocumentById(id);
		//System.out.println("sdfsd");
		//System.out.println(id);
		//return null;
	}

	@Override
	public boolean checkDocumentWithTitle(Document document)
			throws Exception {
		return documentDao.checkDocumentWithTitle(document);
	}
	@Override
	public void update(Document document){
		documentDao.update(document);
	}
	
	@Override
	public void deleteById(int id) throws Exception {
		documentDao.deleteById(id);
	}
}
