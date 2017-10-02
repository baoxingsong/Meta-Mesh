package org.metasee.database.action;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.model.News;
import org.metasee.database.service.NewsManager;
import org.metasee.database.service.impl.NewsManagerImpl;
import org.metasee.database.commonUtil.Page;

import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends SuperClass{

	private static final long serialVersionUID = 1L;

	News news;
	private int id;

	private List<News> newss=new ArrayList<News>();
	
	private String title;
	private String content;
	private String bstract;

	int page=1;

	int recordPerPage=20;
	
	int totalCount;
	
	private NewsManager newsManager = new NewsManagerImpl();
	
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String add()throws Exception{
		News news=new News();
		news.setTitle(title);
		news.setContent(content);
		news.setAbstract(bstract);
		
		if (newsManager.checkNewsWithTitle(news)){
			return "failexists";
		}
		newsManager.add(news);
		this.setWebPageTitle("add news");
		return SUCCESS;
	}
	
	public String deleteById() throws Exception{
		newsManager.deleteById(id);
		this.setWebPageTitle("delete news");
		return SUCCESS;
	}
	
	public String list()throws Exception{
		this.newss=(List <News>)this.newsManager.getNewss(page, recordPerPage).getList();
		this.totalCount=this.newsManager.getNewss(page, recordPerPage).getTotalCount();
		this.setWebPageTitle("News");
		return SUCCESS;
	}
	
	public String content()throws Exception{
		this.news=this.newsManager.getNewsById(id);
		this.setWebPageTitle("News " + this.news.getTitle());
		return SUCCESS;
	}
	
	public String updateinput()throws Exception{
		this.news=this.newsManager.getNewsById(id);
		this.setWebPageTitle("News edit");
		return SUCCESS;
	}
	
	public String update()throws Exception{
		News news=new News();
		news.setTitle(title);
		news.setContent(content);
		news.setAbstract(bstract);
		news.setId(id);
		newsManager.update(news);
		this.setWebPageTitle("News edit");
		return SUCCESS;
	}
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public NewsManager getNewsManager() {
		return newsManager;
	}

	public void setNewsManager(NewsManager newsManager) {
		this.newsManager = newsManager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<News> getNewss() {
		return newss;
	}

	public void setNewss(List<News> newss) {
		this.newss = newss;
	}

	public String getBstract() {
		return bstract;
	}

	public void setBstract(String bstract) {
		this.bstract = bstract;
	}
	
}
