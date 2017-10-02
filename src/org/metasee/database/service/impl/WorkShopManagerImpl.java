package org.metasee.database.service.impl;

import org.metasee.database.dao.WorkShopDao;
import org.metasee.database.dao.impl.WorkShopDaoImpl;
import org.metasee.database.model.WorkShop;
import org.metasee.database.service.WorkShopManager;

public class WorkShopManagerImpl implements WorkShopManager {
	WorkShopDao workShopDao = new WorkShopDaoImpl();
	@Override
	public void save(WorkShop workShop) throws Exception {
		workShopDao.save(workShop);
	}

	@Override
	public WorkShop getWorkShopById(int id) throws Exception {
		return workShopDao.getWorkShopById(id);
	}

	@Override
	public boolean checkWorkShopNameAndUser(String name, int userId)
			throws Exception {
		return workShopDao.checkWorkShopNameAndUser(name, userId);
	}

	@Override
	public void deleteById(int id) throws Exception {
		workShopDao.deleteById(id);
	}

	@Override
	public void update(WorkShop workShop) throws Exception {
		workShopDao.update(workShop);
	}

	@Override
	public WorkShop getWorkShopByNamAndUserName(String name, String userName)
			throws Exception {
		return workShopDao.getWorkShopByNamAndUserName(name, userName);
	}

}
