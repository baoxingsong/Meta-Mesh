package org.metasee.database.dao;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.MetaStormsCompareResult;


public interface MetaStormsCompareResultDao {
	public void removeById(int id);
	public MetaStormsCompareResult getMetaStormsCompareResultById(int id);
	public void updateCommentById(int id, String comment);
	public void addMetaStormsCompareResult(MetaStormsCompareResult metaStormsCompareResult);
	public Page getMetaStormsCompareResultByUserId(int userId);
}