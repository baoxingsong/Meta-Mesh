package org.metasee.database.service.impl;

import org.metasee.database.commonUtil.Page;
import org.metasee.database.dao.MetaStormsCompareResultDao;
import org.metasee.database.dao.impl.MetaStormsCompareResultDaoImpl;
import org.metasee.database.model.MetaStormsCompareResult;
import org.metasee.database.service.MetaStormsCompareResultManager;

public class MetaStormsCompareResultManagerImpl implements
		MetaStormsCompareResultManager {
	MetaStormsCompareResultDao metaStormsCompareResultDao = new MetaStormsCompareResultDaoImpl();
	@Override
	public void removeById(int id) throws Exception {
		// TODO Auto-generated method stub
		metaStormsCompareResultDao.removeById(id);
	}

	@Override
	public MetaStormsCompareResult getMetaStormsCompareResultById(int id)
			throws Exception {
		// TODO Auto-generated method stub
		return metaStormsCompareResultDao.getMetaStormsCompareResultById(id);
	}

	@Override
	public void updateCommentById(int id, String comment) throws Exception {
		// TODO Auto-generated method stub
		metaStormsCompareResultDao.updateCommentById(id, comment);
	}

	@Override
	public void addMetaStormsCompareResult(
			MetaStormsCompareResult metaStormsCompareResult) throws Exception {
		// TODO Auto-generated method stub
		metaStormsCompareResultDao.addMetaStormsCompareResult(metaStormsCompareResult);
	}

	@Override
	public Page getMetaStormsCompareResultByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return metaStormsCompareResultDao.getMetaStormsCompareResultByUserId(userId);
	}

}
