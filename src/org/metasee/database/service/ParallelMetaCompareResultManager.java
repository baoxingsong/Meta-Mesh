package org.metasee.database.service;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.ParallelMetaCompareResult;

public interface ParallelMetaCompareResultManager {
	public abstract void removeById(int parallelMetaCompareResultId) throws Exception;
	public abstract ParallelMetaCompareResult getParallelMetaCompareResultById(int parallelMetaCompareResultId) throws Exception;
	public abstract void updateCommentById(int parallelMetaCompareResultId, String comment) throws Exception;
	public abstract void addParallelMetaCompareResult(ParallelMetaCompareResult parallelMetaCompareResult) throws Exception;
	public abstract Page getParallelMetaCompareResultsByUserId(int uploadFileId) throws Exception;
}
