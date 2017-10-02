package org.metasee.database.dao;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.ParallelMetaCompareResult;

public interface ParallelMetaCompareResultDao {
	public void removeById(int parallelMetaCompareResultId);
	public ParallelMetaCompareResult getParallelMetaCompareResultById(int parallelMetaCompareResultId);
	public void updateCommentById(int parallelMetaCompareResultId, String comment);
	public void addParallelMetaCompareResult(ParallelMetaCompareResult parallelMetaCompareResult);
	public Page getParallelMetaCompareResultByUserId(int UserId);
}