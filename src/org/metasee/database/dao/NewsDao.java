package org.metasee.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.News;

public interface NewsDao {
	public void save(News news);
	public Page getNewss(int page, int recordPerPage);
	public News getNewById(int id);
	public boolean checkNewsWithTitle(News news);
	public void deleteById(int id);
	public void update(News news);
}
