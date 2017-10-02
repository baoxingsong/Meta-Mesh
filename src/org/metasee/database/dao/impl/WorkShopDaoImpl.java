package org.metasee.database.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.dao.WorkShopDao;
import org.metasee.database.model.WorkShop;
import org.metasee.database.util.HibernateUtil;

public class WorkShopDaoImpl implements WorkShopDao {

	@Override
	public void save(WorkShop workShop) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(workShop);
		s.getTransaction().commit();
	}

	@Override
	public WorkShop getWorkShopById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkShop> workShops=(List<WorkShop>)s.createQuery("from WorkShop workShop where workShop.id="+id).list();
		s.getTransaction().commit();
		
		if(workShops.size()>0){
			WorkShop workShop = workShops.get(0);
			return workShop;
		}
		return null;
	}

	@Override
	public boolean checkWorkShopNameAndUser(String name, int userId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkShop> workShops=(List<WorkShop>)s.createQuery("from WorkShop workShop where workShop.name='"+name +"' and workShop.owner.id=" + userId).list();
		s.getTransaction().commit();
		
		if(workShops.size()>0){
			return true;
		}
		return false;
	}
	
	@Override
	public WorkShop getWorkShopByNamAndUserName(String name, String userName) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkShop> workShops=(List<WorkShop>)s.createQuery("from WorkShop workShop where workShop.name='"+name +"' and workShop.owner.userName='" + userName+"'").list();
		s.getTransaction().commit();
		
		if(workShops.size()>0){
			WorkShop workShop = workShops.get(0);
			return workShop;
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkShop> workShops=(List<WorkShop>)s.createQuery("from WorkShop workShop where workShop.id="+id).list();
		s.getTransaction().commit();
		
		if(workShops.size()>0){
			WorkShop workShop = workShops.get(0);
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.delete(workShop);
			s.getTransaction().commit();
		}
	}

	@Override
	public void update(WorkShop workShop) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(workShop);
		s.getTransaction().commit();
	}

}
