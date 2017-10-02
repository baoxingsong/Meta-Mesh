package org.metasee.database.service;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.News;

public interface NewsManager {
	public abstract void add(News news) throws Exception;
	public Page getNewss(int page, int recordPerPage);
	public abstract News getNewsById(int id);
	public abstract boolean checkNewsWithTitle(News news) throws Exception;
	public abstract void deleteById(int id) throws Exception;
	public abstract void update(News news)  throws Exception;
}
