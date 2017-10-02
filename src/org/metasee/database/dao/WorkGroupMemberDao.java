package org.metasee.database.dao;

import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkGroupMember;

public interface WorkGroupMemberDao {
	public void save(WorkGroupMember workGroupMember);
	public void deleteById(int id);
	public WorkGroupMember getByid(int id);
	public WorkGroupMember getByUserAndWorkGroup(User user, WorkGroup workGroup);
	public void updateWorkGroupMember(WorkGroupMember workGroupMember);
}
