package org.metasee.database.dao;

import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;

public interface WorkGroupDao {
	public void save(WorkGroup workGroup);
	public WorkGroup getWorkGroupById(int id);
	public boolean checkWorkGroupNameAndUser(String name, int userId);
	public void deleteById(int id);
	public void update(WorkGroup workGroup);
	public WorkGroup getWorkGroupNameAndUser(String name, User user);
}
