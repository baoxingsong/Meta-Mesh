package org.metasee.database.service.impl;

import org.metasee.database.dao.WorkGroupDao;
import org.metasee.database.dao.impl.WorkGroupDaoImpl;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.service.WorkGroupManager;

public class WorkGroupManagerImpl implements WorkGroupManager {
	WorkGroupDao workGroupDao = new WorkGroupDaoImpl();
	@Override
	public void save(WorkGroup workGroup) throws Exception {
		workGroupDao.save(workGroup);
	}

	@Override
	public WorkGroup getWorkGroupById(int id) throws Exception {
		return workGroupDao.getWorkGroupById(id);
	}

	@Override
	public boolean checkWorkGroupNameAndUser(String name, int userId)
			throws Exception {
		return workGroupDao.checkWorkGroupNameAndUser(name, userId);
	}

	@Override
	public void deleteById(int id) throws Exception {
		workGroupDao.deleteById(id);
	}

	@Override
	public void update(WorkGroup workGroup) throws Exception {
		workGroupDao.update(workGroup);
	}

	@Override
	public WorkGroup getWorkGroupNameAndUser(String name, User user)
			throws Exception {
		return workGroupDao.getWorkGroupNameAndUser(name, user);
	}
}
