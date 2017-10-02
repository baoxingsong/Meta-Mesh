package org.metasee.database.action;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.model.Document;
import org.metasee.database.model.News;
import org.metasee.database.service.DocumentManager;
import org.metasee.database.service.impl.DocumentManagerImpl;
import org.metasee.database.commonUtil.Page;

import com.opensymphony.xwork2.ActionSupport;

public class DocumentAction extends SuperClass{

	private static final long serialVersionUID = 1L;

	Document document;
	private int id;

	private List<Document> documents=new ArrayList<Document>();
	
	private String title;
	private String content;

	int page=1;

	int recordPerPage=20;
	
	int totalCount;
	
	private DocumentManager documentManager = new DocumentManagerImpl();
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String add()throws Exception{
		Document document=new Document();
		document.setTitle(title);
		document.setContent(content);
		if (documentManager.checkDocumentWithTitle(document)){
			return "failexists";
		}
		this.setWebPageTitle("add document");
		documentManager.add(document);
		return SUCCESS;
	}
	
	public String list()throws Exception{
		this.documents=(List <Document>)this.documentManager.getDocuments(page, recordPerPage).getList();
		this.totalCount=this.documentManager.getDocuments(page, recordPerPage).getTotalCount();
		this.setWebPageTitle("Document");
		return SUCCESS;
	}
	
	public String content()throws Exception{
		this.document=this.documentManager.getDocumentById(id);
		this.setWebPageTitle("document " + this.document.getTitle());
		return SUCCESS;
	}
	
	public String deleteById() throws Exception{
		documentManager.deleteById(id);
		this.setWebPageTitle("document delete");
		return SUCCESS;
	}
	
	public String updateinput()throws Exception{
		this.document=this.documentManager.getDocumentById(id);
		this.setWebPageTitle("document edit");
		return SUCCESS;
	}
	
	public String update()throws Exception{
		Document document=new Document();
		document.setTitle(title);
		document.setContent(content);
		document.setId(id);
		this.setWebPageTitle("document edit");
		documentManager.update(document);
		return SUCCESS;
	}
	
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public DocumentManager getDocumentManager() {
		return documentManager;
	}
	public void setDocumentManager(DocumentManager documentManager) {
		this.documentManager = documentManager;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
