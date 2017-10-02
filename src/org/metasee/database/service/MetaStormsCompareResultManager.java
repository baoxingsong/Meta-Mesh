package org.metasee.database.service;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.MetaStormsCompareResult;

public interface MetaStormsCompareResultManager {
	public void removeById(int id) throws Exception;
	public MetaStormsCompareResult getMetaStormsCompareResultById(int id) throws Exception;
	public void updateCommentById(int id, String comment) throws Exception;
	public void addMetaStormsCompareResult(MetaStormsCompareResult metaStormsCompareResult) throws Exception;
	public Page getMetaStormsCompareResultByUserId(int userId) throws Exception;
}
