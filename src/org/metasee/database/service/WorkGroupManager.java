package org.metasee.database.service;

import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;

public interface WorkGroupManager {
	public void save(WorkGroup workGroup) throws Exception;
	public WorkGroup getWorkGroupById(int id) throws Exception;
	public boolean checkWorkGroupNameAndUser(String name, int userId) throws Exception;
	public void deleteById(int id) throws Exception;
	public void update(WorkGroup workGroup) throws Exception;
	public WorkGroup getWorkGroupNameAndUser(String name, User user) throws Exception;
}
