package org.metasee.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.Document;
import org.metasee.database.model.News;

public interface DocumentDao {
	public void save(Document document);
	public Page getDocuments(int page, int recordPerPage);
	public Document getDocumentById(int id);
	public boolean checkDocumentWithTitle(Document document);
	public void deleteById(int id);
	public void update(Document document);
}
