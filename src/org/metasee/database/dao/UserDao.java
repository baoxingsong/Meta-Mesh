package org.metasee.database.dao;


import org.metasee.database.model.User;
public interface UserDao {
	public void save(User user);
	public String checkUserWithUserName(String userName);
	public String check(User user);
	public String changePassWord(User user);
	public String activeUser(User user);
	public String checkMailBoxWithUserName(String mailbox);
	public User getUserByUserName(String username);
	public User getUserByUserId(int userid);
	public User getUserByMailBox(String mailbox);
}