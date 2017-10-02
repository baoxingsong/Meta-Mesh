package org.metasee.database.service.impl;

import org.metasee.database.dao.impl.WorkGroupMemberDaoImpl;
import org.metasee.database.dao.WorkGroupMemberDao;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkGroupMember;
import org.metasee.database.service.WorkGroupMemberManager;

public class WorkGroupMemberManagerImpl implements WorkGroupMemberManager {
	WorkGroupMemberDao workGroupMemberDao = new WorkGroupMemberDaoImpl();
	@Override
	public void save(WorkGroupMember workGroupMember) throws Exception {
		workGroupMemberDao.save(workGroupMember);
	}

	@Override
	public void deleteById(int id) throws Exception {
		workGroupMemberDao.deleteById(id);
	}

	@Override
	public WorkGroupMember getByid(int id) throws Exception {
		return workGroupMemberDao.getByid(id);
	}

	@Override
	public WorkGroupMember getByUserAndWorkGroup(User user, WorkGroup workGroup)
			throws Exception {
		return workGroupMemberDao.getByUserAndWorkGroup(user, workGroup);
	}

	@Override
	public void updateWorkGroupMember(WorkGroupMember workGroupMember)
			throws Exception {
		workGroupMemberDao.updateWorkGroupMember(workGroupMember);
	}
}
