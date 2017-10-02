package org.metasee.database.service.impl;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.impl.WikiDaoImpl;
import org.metasee.database.model.Document;
import org.metasee.database.model.Wiki;
import org.metasee.database.service.WikiManager;

public class WikiManagerImpl implements WikiManager {
	private WikiDaoImpl wikiDao = new WikiDaoImpl();
	
	@Override
	public void add( Wiki wiki) throws Exception {
		wikiDao.save(wiki);
	}

	@Override
	public Wiki getWikiByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		return this.wikiDao.getWikiByKeyword(keyWord);
	}
	@Override
	public Wiki getWikiById(int id) {
		// TODO Auto-generated method stub
		return this.wikiDao.getWikiById(id);
	}

	@Override
	public boolean checkWikiWithKeyWord(Wiki wiki)
			throws Exception {
		return wikiDao.checkWikiWithKeyword(wiki);
	}

	@Override
	public Page getWikis(int page, int recordPerPage) {
		return this.wikiDao.getWikis(page, recordPerPage);
	}
	@Override
	public void update(Wiki wiki){
		wikiDao.update(wiki);
	}
	
	@Override
	public void deleteById(int id) throws Exception {
		wikiDao.deleteById(id);
	}
}