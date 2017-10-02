package org.metasee.database.service.impl;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.ParallelMetaCompareResultDao;
import org.metasee.database.dao.impl.ParallelMetaCompareResultDaoImpl;

import org.metasee.database.model.ParallelMetaCompareResult;
import org.metasee.database.service.ParallelMetaCompareResultManager;;

public class ParallelMetaCompareResultManagerImpl implements ParallelMetaCompareResultManager {
	
	ParallelMetaCompareResultDao parallelMetaCompareResultDao=new ParallelMetaCompareResultDaoImpl();
	
	@Override
	public void removeById(int parallelMetaCompareResultId) throws Exception {
		parallelMetaCompareResultDao.removeById(parallelMetaCompareResultId);
		
	}

	@Override
	public ParallelMetaCompareResult getParallelMetaCompareResultById(
			int parallelMetaCompareResultId) throws Exception {
		return parallelMetaCompareResultDao.getParallelMetaCompareResultById(parallelMetaCompareResultId);
	}

	@Override
	public void updateCommentById(int parallelMetaCompareResultId,
			String comment) throws Exception {
		parallelMetaCompareResultDao.updateCommentById(parallelMetaCompareResultId, comment);
	}

	@Override
	public void addParallelMetaCompareResult(
			ParallelMetaCompareResult parallelMetaCompareResult)
			throws Exception {
		parallelMetaCompareResultDao.addParallelMetaCompareResult(parallelMetaCompareResult);
	}

	@Override
	public Page getParallelMetaCompareResultsByUserId(int UserId)
			throws Exception {
		parallelMetaCompareResultDao.getParallelMetaCompareResultByUserId(UserId);
		return null;
	}
}
