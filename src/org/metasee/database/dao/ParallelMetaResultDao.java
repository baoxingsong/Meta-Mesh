package org.metasee.database.dao;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.ParallelMetaResult;

public interface ParallelMetaResultDao {
	public void removeById(int parallelMetaResultId);
	public ParallelMetaResult getParallelMetaResultById(int parallelMetaResultId);
	public void updateCommentById(int parallelMetaResultId, String comment);
	public void addParallelMetaResult(ParallelMetaResult parallelMetaResult);
	public Page getParallelMetaResultsByUploadFileId(int uploadFileId);
	public String checkExists(ParallelMetaResult parallelMetaResult);
}