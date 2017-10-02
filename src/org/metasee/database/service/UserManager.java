package org.metasee.database.service;


import org.metasee.database.model.User;

public interface UserManager {
	public abstract void add(User user) throws Exception;
	public abstract String check(User user) throws Exception;
	public abstract String changePassWord(User user) throws Exception;
	public abstract String activeUser(User user) throws Exception;
	public abstract String chekcUserWithUserName(String userName) throws Exception;
	public abstract String chekcMailBoxWithUserName(String mailbox) throws Exception;
	public abstract User getUserByUserName(String username) throws Exception;
	public abstract User getUserByUserId(int userid) throws Exception;
	public abstract User getUserByMailBox(String mailbox) throws Exception;
}
