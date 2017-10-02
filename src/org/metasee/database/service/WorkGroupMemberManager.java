package org.metasee.database.service;

import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkGroupMember;

public interface WorkGroupMemberManager {
	public void save(WorkGroupMember workGroupMember) throws Exception;
	public void deleteById(int id) throws Exception;
	public WorkGroupMember getByid(int id) throws Exception;
	public WorkGroupMember getByUserAndWorkGroup(User user, WorkGroup workGroup) throws Exception;
	public void updateWorkGroupMember(WorkGroupMember workGroupMember) throws Exception;
}
