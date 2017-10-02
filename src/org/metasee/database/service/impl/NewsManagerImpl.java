package org.metasee.database.service.impl;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.impl.NewsDaoImpl;
import org.metasee.database.model.News;
import org.metasee.database.service.NewsManager;

public class NewsManagerImpl implements NewsManager {
	private NewsDaoImpl newsDao = new NewsDaoImpl();
	
	@Override
	public void add( News news) throws Exception {
		newsDao.save(news);
	}

	@Override
	public Page getNewss(int page, int recordPerPage) {
		return this.newsDao.getNewss(page, recordPerPage);
	}

	@Override
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return this.newsDao.getNewById(id);
	}

	@Override
	public boolean checkNewsWithTitle(News news)
			throws Exception {
		return newsDao.checkNewsWithTitle(news);
	}
	
	@Override
	public void update(News news){
		newsDao.update(news);
	}
	
	@Override
	public void deleteById(int id) throws Exception {
		newsDao.deleteById(id);
	}
	
	public NewsDaoImpl getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDaoImpl newsDao) {
		this.newsDao = newsDao;
	}

}
