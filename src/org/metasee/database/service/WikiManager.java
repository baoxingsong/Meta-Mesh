package org.metasee.database.service;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.News;
import org.metasee.database.model.Wiki;

public interface WikiManager {
	public abstract void add(Wiki wiki) throws Exception;
	public Page getWikis(int page, int recordPerPage);
	public abstract Wiki getWikiByKeyWord(String keyWord);
	public abstract Wiki getWikiById(int id);
	public abstract boolean checkWikiWithKeyWord(Wiki wiki) throws Exception;
	public abstract void deleteById(int id) throws Exception;
	public abstract void update(Wiki wiki)  throws Exception;
}
