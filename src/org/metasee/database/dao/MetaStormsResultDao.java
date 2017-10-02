package org.metasee.database.dao;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.MetaStormsResult;

public interface MetaStormsResultDao {
	public void removeById(int metaStormsResultId);
	public MetaStormsResult getMetaStormsResultById(int metaStormsResultId);
	public void updateCommentById(int metaStormsResultId, String comment);
	public void addMetaStormsResult(MetaStormsResult metaStormsResult);
	public Page getMetaStormsResultsByParallelMetaResultId(int parallelMetaResultId);
}