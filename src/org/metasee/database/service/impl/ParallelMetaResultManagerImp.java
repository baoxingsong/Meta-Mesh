package org.metasee.database.service.impl;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.ParallelMetaResultDao;
import org.metasee.database.dao.impl.ParallelMetaResultDaoImpl;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.service.ParallelMetaResultManager;

public class ParallelMetaResultManagerImp implements ParallelMetaResultManager {
	
	ParallelMetaResultDao parallelMetaResultDao=new ParallelMetaResultDaoImpl(); 
	
	@Override
	public void removeById(int parallelMetaResultId) throws Exception {
		parallelMetaResultDao.removeById(parallelMetaResultId);

	}

	@Override
	public ParallelMetaResult getParallelMetaResultById(int parallelMetaResultId)
			throws Exception {
		return parallelMetaResultDao.getParallelMetaResultById(parallelMetaResultId);
	}

	@Override
	public void updateCommentById(int parallelMetaResultId, String comment)
			throws Exception {
		parallelMetaResultDao.updateCommentById(parallelMetaResultId, comment);
	}

	@Override
	public void addParallelMetaResult(ParallelMetaResult parallelMetaResult)
			throws Exception {
		parallelMetaResultDao.addParallelMetaResult(parallelMetaResult);
	}

	@Override
	public Page getParallelMetaResultsByUploadFileId(int uploadFileId)
			throws Exception {
		return parallelMetaResultDao.getParallelMetaResultsByUploadFileId(uploadFileId);
	}
	@Override
	public String checkExists(ParallelMetaResult parallelMetaResult)
			throws Exception {
		return parallelMetaResultDao.checkExists(parallelMetaResult);
	}
	public ParallelMetaResultDao getParallelMetaResultDao() {
		return parallelMetaResultDao;
	}

	public void setParallelMetaResultDao(ParallelMetaResultDao parallelMetaResultDao) {
		this.parallelMetaResultDao = parallelMetaResultDao;
	}

	
	
	
}
