package org.metasee.database.service;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.model.ParallelMetaResult;

public interface ParallelMetaResultManager {
	public abstract void removeById(int parallelMetaResultId) throws Exception;
	public abstract ParallelMetaResult getParallelMetaResultById(int parallelMetaResultId) throws Exception;
	public abstract void updateCommentById(int parallelMetaResultId, String comment) throws Exception;
	public abstract void addParallelMetaResult(ParallelMetaResult parallelMetaResult) throws Exception;
	public abstract Page getParallelMetaResultsByUploadFileId(int uploadFileId) throws Exception;
	public abstract String checkExists(ParallelMetaResult parallelMetaResult)throws Exception;
}
