package org.metasee.database.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.dao.WorkGroupMemberDao;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkGroupMember;
import org.metasee.database.util.HibernateUtil;

public class WorkGroupMemberDaoImpl implements WorkGroupMemberDao {
	
	@Override
	public WorkGroupMember getByid(int id){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkGroupMember> workGroupMembers=(List<WorkGroupMember>)s.createQuery("from WorkGroupMember workGroupMember where workGroupMember.id="+id).list();
		s.getTransaction().commit();
		
		if(workGroupMembers.size()>0){
			return workGroupMembers.get(0);
		}
		return null;
	}
	@Override
	public void save(WorkGroupMember workGroupMember) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(workGroupMember);
		s.getTransaction().commit();
	}

	@Override
	public void deleteById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkGroupMember> workGroupMembers=(List<WorkGroupMember>)s.createQuery("from WorkGroupMember workGroupMember where workGroupMember.id="+id).list();
		s.getTransaction().commit();
		
		if(workGroupMembers.size()>0){
			WorkGroupMember workGroupMember = workGroupMembers.get(0);
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.delete(workGroupMember);
			s.getTransaction().commit();
		}
	}
	@Override
	public WorkGroupMember getByUserAndWorkGroup(User user, WorkGroup workGroup) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<WorkGroupMember> workGroupMembers=(List<WorkGroupMember>)s.createQuery("from WorkGroupMember workGroupMember where workGroupMember.user.id="+user.getId()+" and workGroupMember.workGroup.id="+workGroup.getId()).list();
		s.getTransaction().commit();
		
		if(workGroupMembers.size()>0){
			return workGroupMembers.get(0);
		}
		return null;
	}
	@Override
	public void updateWorkGroupMember(WorkGroupMember workGroupMember) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(workGroupMember);
		s.getTransaction().commit();
	}
}
