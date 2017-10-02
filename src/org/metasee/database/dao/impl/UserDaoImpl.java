package org.metasee.database.dao.impl;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.dao.UserDao;

import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.model.UploadFile;
import org.metasee.database.model.UploadProject;
import org.metasee.database.model.User;
import org.metasee.database.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		user.setSongChecked(0);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(user);
		s.getTransaction().commit();
	}

	@Override
	public String check(User user) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<User> users=(List<User>)s.createQuery("from User user where user.userName='"+user.getUserName()+"'").list();
		s.getTransaction().commit();
		
		if(users.size()>0){
			User existsuser=users.get(0);
			if(user.getPassWord().equals(existsuser.getPassWord())){
				if(1==existsuser.getSongChecked()){
					return "sucess";
				}else{
					return "unactived user";
				}
			}else{
				return "wrong password";
			}
		}
		return "no such user";
	}
	
	

	@Override
	public String changePassWord(User user) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<User> users=(List<User>)s.createQuery("from User user where user.userName='"+user.getUserName()+"'").list();
		s.getTransaction().commit();
		
		if(users.size()>0){
			User existsuser=users.get(0);
			
				if(1==existsuser.getSongChecked()){
					existsuser.setPassWord(user.getNewPassword());
					
					sf=HibernateUtil.getSessionFactory();
					s=sf.getCurrentSession();
					s.beginTransaction();
					s.update(existsuser);
					s.getTransaction().commit();
					return "sucess";
				}else{
					return "unactived user";
				}
			
		}
		return "no such user";
	}

	@Override
	public String activeUser(User user) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<User> users=(List<User>)s.createQuery("from User user where user.userName='"+user.getUserName()+"'").list();
		s.getTransaction().commit();
		
		if(users.size()>0){
			User existsuser=users.get(0);
			if(user.getRandomString().equals(existsuser.getRandomString())){
				if(0==existsuser.getSongChecked()){
					existsuser.setSongChecked(1);
					existsuser.setHomedir(GlobalConstant.uploadDir + user.getUserName());
					
					sf=HibernateUtil.getSessionFactory();
					s=sf.getCurrentSession();
					s.beginTransaction();
					s.update(existsuser);
					s.getTransaction().commit();
					
					return "sucess";
				}else{
					return "user had benn actived, please do not active it again!";
				}
			}else{
				return "wrong RandomString";
			}
		}
		return "No such user, Please regist first!";
	}

	@Override
	public String checkUserWithUserName(String userName) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<User> users=(List<User>)s.createQuery("from User user where user.userName='"+userName+"'").list();
		s.getTransaction().commit();
		
		if(users.size()>0){
			return "exists";
		}
		return "none";
	}
	@Override
	public String checkMailBoxWithUserName(String mailbox) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<User> users=(List<User>)s.createQuery("from User user where user.mailBox='"+mailbox+"'").list();
		s.getTransaction().commit();
		
		if(users.size()>0){
			return "exists";
		}
		return "none";
	}

	@Override
	public User getUserByUserName(String username) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<User> users=(List<User>)s.createQuery("from User user where user.userName='"+username+"'").list();
		s.getTransaction().commit();
		
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}
	
	@Override
	public User getUserByMailBox(String mailbox) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<User> users=(List<User>)s.createQuery("from User user where user.mailBox='"+mailbox+"'").list();
		s.getTransaction().commit();
		
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}
	
	@Override
	public User getUserByUserId(int userid){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<User> users=(List<User>)s.createQuery("from User user where user.id='"+userid+"'").list();
		s.getTransaction().commit();
		
		if(users.size()>0){
			User getedUser = users.get(0);
			/*
			Iterator<UploadProject> iterator=getedUser.get.getUploadProjects().iterator();
			Set<UploadProject> uploadProjectsSet=new HashSet<UploadProject>();
			while(iterator.hasNext()){
				UploadProject itUploadProject=iterator.next();
				if(1==itUploadProject.getSongChecked()){
					uploadProjectsSet.add(itUploadProject);
					s=sf.getCurrentSession();
					s.beginTransaction();
					List<UploadFile> itUploadFiles=(List<UploadFile>)s.createQuery("from UploadFile uploadFile where uploadFile.uploadProject.id='"+itUploadProject.getId()+"' and uploadFile.songChecked = 1").list();
					Set<UploadFile> itUploadFileHash=new HashSet<UploadFile>();
					itUploadFileHash.addAll(itUploadFiles);
					itUploadProject.setUploadFiles(itUploadFileHash);
					s.getTransaction().commit();
					
					Iterator<UploadFile> fileIt=itUploadFileHash.iterator();
					while(fileIt.hasNext()){
						UploadFile itNextuploadFile=fileIt.next();
						s=sf.getCurrentSession();
						s.beginTransaction();
						List<ParallelMetaResult> itParallelMetaResults=(List<ParallelMetaResult>)s.createQuery("from ParallelMetaResult parallelMetaResult where parallelMetaResult.uploadFile.id='"+itNextuploadFile.getId()+"' and parallelMetaResult.songChecked = 1").list();
						s.getTransaction().commit();
						Set<ParallelMetaResult> itParallelMetaResultHash=new HashSet<ParallelMetaResult>();
						itParallelMetaResultHash.addAll(itParallelMetaResults);
						itNextuploadFile.setParallelMetaResults(itParallelMetaResultHash);
					}
					
				}
				
			}
			getedUser.setUploadProjects(uploadProjectsSet);
			*/
			return getedUser;
		}
		return null;
	}
	
}
