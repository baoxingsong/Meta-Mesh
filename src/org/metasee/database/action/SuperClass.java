package org.metasee.database.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.model.Document;
import org.metasee.database.model.News;
import org.metasee.database.service.DocumentManager;
import org.metasee.database.service.NewsManager;
import org.metasee.database.service.impl.DocumentManagerImpl;
import org.metasee.database.service.impl.NewsManagerImpl;
public class SuperClass  extends ActionSupport{
	String webPageTitle = GlobalConstant.webTitle;
	String pleaseLogin = "Pleaes Log in";
	String noSuchUser = "Cannot find current user, please Log in!";
	String accessNotPermitted = "You are not permitted to access this data.";
	public final String ApplicationTitle="Meta-Mesh";
	private NewsManager newsManager = new NewsManagerImpl();
	private DocumentManager documentManager = new DocumentManagerImpl();
	private List<News> rightNewss=new ArrayList<News>();
	private List<Document> rightDocuments=new ArrayList<Document>();
	
	public String getWebPageTitle() {
		return webPageTitle;
	}
	public void setWebPageTitle(String webPageTitle) {
		this.webPageTitle = this.webPageTitle + " -- " + webPageTitle;
	}
	public String getPleaseLogin() {
		return pleaseLogin;
	}
	public void setPleaseLogin(String pleaseLogin) {
		this.pleaseLogin = pleaseLogin;
	}
	public String getNoSuchUser() {
		return noSuchUser;
	}
	public void setNoSuchUser(String noSuchUser) {
		this.noSuchUser = noSuchUser;
	}
	public String getAccessNotPermitted() {
		return accessNotPermitted;
	}
	public void setAccessNotPermitted(String accessNotPermitted) {
		this.accessNotPermitted = accessNotPermitted;
	}
	public NewsManager getNewsManager() {
		return newsManager;
	}
	public void setNewsManager(NewsManager newsManager) {
		this.newsManager = newsManager;
	}
	public List<News> getRightNewss() {
		this.rightNewss=(List <News>)this.newsManager.getNewss(1, 5).getList();
		return rightNewss;
	}
	public void setRightNewss(List<News> rightNewss) {
		this.rightNewss = rightNewss;
	}
	public DocumentManager getDocumentManager() {
		return documentManager;
	}
	public void setDocumentManager(DocumentManager documentManager) {
		this.documentManager = documentManager;
	}
	public List<Document> getRightDocuments() {
		this.rightDocuments=(List <Document>)this.documentManager.getDocuments(1, 5).getList();
		return rightDocuments;
	}
	public void setRightDocuments(List<Document> rightDocuments) {
		this.rightDocuments = rightDocuments;
	}
	public String getApplicationTitle() {
		return ApplicationTitle;
	}
	
	
	
}
