package org.metasee.database.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.dao.WorkGroupDao;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkShop;
import org.metasee.database.util.HibernateUtil;

public class WorkGroupDaoImpl implements WorkGroupDao {

	@Override
	public void save(WorkGroup workGroup) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(workGroup);
		s.getTransaction().commit();
	}

	@Override
	public WorkGroup getWorkGroupById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkGroup> workGroups=(List<WorkGroup>)s.createQuery("from WorkGroup workGroup where workGroup.id="+id).list();
		s.getTransaction().commit();
		
		if(workGroups.size()>0){
			WorkGroup workGroup = workGroups.get(0);
			Set<WorkShop> wss = workGroup.getWorkShops();
			workGroup.setWorkShops(wss);
			return workGroup;
		}
		return null;
	}

	@Override
	public boolean checkWorkGroupNameAndUser(String name, int userId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkGroup> workGroups=(List<WorkGroup>)s.createQuery("from WorkGroup workGroup where workGroup.name='"+name +"' and workGroup.owner.id=" + userId).list();
		s.getTransaction().commit();
		
		if(workGroups.size()>0){
			return true;
		}
		return false;
	}
	@Override
	public WorkGroup getWorkGroupNameAndUser(String name, User user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkGroup> workGroups=(List<WorkGroup>)s.createQuery("from WorkGroup workGroup where workGroup.name='"+name +"' and workGroup.owner.id=" + user.getId()).list();
		s.getTransaction().commit();
		
		if(workGroups.size()>0){
			return workGroups.get(0);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkGroup> workGroups=(List<WorkGroup>)s.createQuery("from WorkGroup workGroup where workGroup.id="+id).list();
		s.getTransaction().commit();
		
		if(workGroups.size()>0){
			WorkGroup workGroup = workGroups.get(0);
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.delete(workGroup);
			s.getTransaction().commit();
		}
	}

	@Override
	public void update(WorkGroup workGroup) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(workGroup);
		s.getTransaction().commit();
	}

}
