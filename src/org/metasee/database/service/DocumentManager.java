package org.metasee.database.service;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.Document;
import org.metasee.database.model.News;

public interface DocumentManager {
	public abstract void add(Document document) throws Exception;
	public abstract Page getDocuments(int page, int recordPerPage);
	public abstract Document getDocumentById(int id);
	public abstract boolean checkDocumentWithTitle(Document document) throws Exception;
	public abstract void deleteById(int id) throws Exception;
	public abstract void update(Document document)  throws Exception;
}
