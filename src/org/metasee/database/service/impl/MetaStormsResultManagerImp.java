package org.metasee.database.service.impl;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.MetaStormsResultDao;
import org.metasee.database.dao.impl.MetaStormsResultDaoImpl;
import org.metasee.database.model.MetaStormsResult;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.service.MetaStormsResultManager;




public class MetaStormsResultManagerImp implements MetaStormsResultManager {
	
	MetaStormsResultDao metaStormsResultDao=new MetaStormsResultDaoImpl();
	
	@Override
	public void removeById(int metaStormsResultId) throws Exception {
		metaStormsResultDao.removeById(metaStormsResultId);
	}

	@Override
	public MetaStormsResult getMetaStormsResultById(int metaStormsResultId)
			throws Exception {
		// TODO Auto-generated method stub
		return metaStormsResultDao.getMetaStormsResultById(metaStormsResultId);
	}

	@Override
	public void updateCommentById(int metaStormsResultId, String comment)
			throws Exception {
		metaStormsResultDao.updateCommentById(metaStormsResultId, comment);
		
	}

	@Override
	public void addMetaStormsResult(MetaStormsResult metaStormsResult)
			throws Exception {
		metaStormsResultDao.addMetaStormsResult(metaStormsResult);
		
	}

	@Override
	public Page getMetaStormsResultsByParallelMetaResultId(int parallelMetaResultId)
			throws Exception {
		metaStormsResultDao.getMetaStormsResultsByParallelMetaResultId(parallelMetaResultId);
		return null;
	}

	
	
}
