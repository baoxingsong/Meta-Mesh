package org.metasee.database.action;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.model.Document;
import org.metasee.database.model.Wiki;
import org.metasee.database.service.WikiManager;
import org.metasee.database.service.impl.WikiManagerImpl;
import org.metasee.database.commonUtil.Page;

import com.opensymphony.xwork2.ActionSupport;

public class WikiAction extends SuperClass{

	private static final long serialVersionUID = 1L;

	Wiki wiki;
	private int id;

	private List<Wiki> wikis=new ArrayList<Wiki>();
	
	private String keyWord;
	private String content;

	int page=1;

	int recordPerPage=20;
	
	int totalCount;
	
	private WikiManager wikiManager = new WikiManagerImpl();
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String add()throws Exception{
		Wiki wiki=new Wiki();
		wiki.setKeyWord(keyWord);
		wiki.setContent(content);
	
		if (wikiManager.checkWikiWithKeyWord(wiki)){
			return "failexists";
		}
		wikiManager.add(wiki);
		return SUCCESS;
	}
	
	public String list()throws Exception{
		this.wikis=(List <Wiki>)this.wikiManager.getWikis(page, recordPerPage).getList();
		this.totalCount=this.wikiManager.getWikis(page, recordPerPage).getTotalCount();
		//this.wikiManager.getWikis(page, recordPerPage).getList();
		return SUCCESS;
	}
	
	public String content()throws Exception{
		this.wiki=this.wikiManager.getWikiByKeyWord(keyWord);
		return SUCCESS;
	}
	
	public String deleteById() throws Exception{
		wikiManager.deleteById(id);
		System.out.println("sdfsdafads"+id);
		return SUCCESS;
	}
	
	public String updateinput()throws Exception{
		this.wiki=this.wikiManager.getWikiById(id);
		return SUCCESS;
	}
	
	public String update()throws Exception{
		Wiki wiki=new Wiki();
		wiki.setKeyWord(keyWord);
		wiki.setContent(content);
		wiki.setId(id);
		System.out.println(id);
		wikiManager.update(wiki);
		return SUCCESS;
	}
	
	public Wiki getWiki() {
		return wiki;
	}

	public void setWiki(Wiki wiki) {
		this.wiki = wiki;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Wiki> getWikis() {
		return wikis;
	}

	public void setWikis(List<Wiki> wikis) {
		this.wikis = wikis;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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

	public WikiManager getWikiManager() {
		return wikiManager;
	}

	public void setWikiManager(WikiManager wikiManager) {
		this.wikiManager = wikiManager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
