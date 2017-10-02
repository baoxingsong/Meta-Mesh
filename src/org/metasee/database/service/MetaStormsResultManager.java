package org.metasee.database.service;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.MetaStormsResult;

public interface MetaStormsResultManager {
	public abstract void removeById(int metaStormsResultId) throws Exception;
	public abstract MetaStormsResult getMetaStormsResultById(int metaStormsResultId) throws Exception;
	public abstract void updateCommentById(int metaStormsResultId, String comment) throws Exception;
	public abstract void addMetaStormsResult(MetaStormsResult metaStormsResult) throws Exception;
	public abstract Page getMetaStormsResultsByParallelMetaResultId(int parallelMetaResultId) throws Exception;
}
