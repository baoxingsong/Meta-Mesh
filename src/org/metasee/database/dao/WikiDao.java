package org.metasee.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.News;
import org.metasee.database.model.Wiki;

public interface WikiDao {
	public void save(Wiki wiki);
	public Page getWikis(int page, int recordPerPage);
	public Wiki getWikiByKeyword(String keyword);
	public boolean checkWikiWithKeyword(Wiki wiki);
	public void deleteById(int id);
	public void update(Wiki wiki);
	public Wiki getWikiById(int id);
}
