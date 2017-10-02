package org.metasee.database.service.impl;

import org.metasee.database.dao.impl.UserDaoImpl;
import org.metasee.database.model.User;
import org.metasee.database.service.UserManager;

public class UserManagerImpl implements UserManager {
	private UserDaoImpl userDao = new UserDaoImpl();
	
	@Override
	public void add(User user) throws Exception {
		userDao.save(user);
	}

	@Override
	public String check(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.check(user);
	}

	@Override
	public String changePassWord(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.changePassWord(user);
	}

	@Override
	public String activeUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.activeUser(user);
	}

	@Override
	public String chekcUserWithUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return userDao.checkUserWithUserName(userName);
	}

	@Override
	public String chekcMailBoxWithUserName(String mailbox) {
		return userDao.checkMailBoxWithUserName(mailbox);
	}

	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserName(username);
	}

	@Override
	public User getUserByUserId(int userid) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserId(userid);
	}
	
	@Override
	public User getUserByMailBox(String mailbox) {
		return userDao.getUserByMailBox(mailbox);
	}
	
}
