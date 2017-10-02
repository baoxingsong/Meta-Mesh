package org.metasee.database.dao.impl;


import java.io.File;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.util.HibernateUtil;

import org.metasee.database.commonUtil.DeleteFile;
import org.metasee.database.commonUtil.Page;
import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.commonUtil.runCommand.MetaStormsCompareRunCommand;
import org.metasee.database.commonUtil.runCommand.ParallelMetaCompareRunCommand;
import org.metasee.database.dao.MetaStormsCompareResultDao;
import org.metasee.database.dao.ParallelMetaCompareResultDao;
import org.metasee.database.model.MetaStormsCompareResult;
import org.metasee.database.model.ParallelMetaCompareResult;

public class MetaStormsCompareResultDaoImpl implements MetaStormsCompareResultDao {
	@Override
	public void removeById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<MetaStormsCompareResult> metaStormsCompareResults=(List<MetaStormsCompareResult>)s.createQuery("from MetaStormsCompareResult metaStormsCompareResult where metaStormsCompareResult.id =" + id + "and metaStormsCompareResult.songChecked=1").list();
		s.getTransaction().commit();
		
		if(metaStormsCompareResults.size()>0){
			MetaStormsCompareResult metaStormsCompareResult=metaStormsCompareResults.get(0);
			try {
				String path = GlobalConstant.uploadDir + metaStormsCompareResult.getWorkShop().getOwner().getUserName() + File.separator + GlobalConstant.METASTORMSCOMPARE + File.separator + metaStormsCompareResult.getId() + File.separator;
				DeleteFile deleteFile = new DeleteFile(path);
				deleteFile.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			metaStormsCompareResult.setSongChecked(0);
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.update(metaStormsCompareResult);
			s.getTransaction().commit();
		}
	}

	@Override
	public MetaStormsCompareResult getMetaStormsCompareResultById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<MetaStormsCompareResult> metaStormsCompareResults=(List<MetaStormsCompareResult>)s.createQuery("from MetaStormsCompareResult metaStormsCompareResult where metaStormsCompareResult.id =" + id + "and metaStormsCompareResult.songChecked=1").list();
		s.getTransaction().commit();
		
		if(metaStormsCompareResults.size()>0){
			MetaStormsCompareResult metaStormsCompareResult=metaStormsCompareResults.get(0);
			return metaStormsCompareResult;
		}
		return null;
	}

	@Override
	public void updateCommentById(int id, String comment) {
		MetaStormsCompareResult metaStormsCompareResult=this.getMetaStormsCompareResultById(id);
		if(null != metaStormsCompareResult){
			metaStormsCompareResult.setComment(comment);
			
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.update(metaStormsCompareResult);
			s.getTransaction().commit();
		}
	}

	@Override
	public void addMetaStormsCompareResult(MetaStormsCompareResult metaStormsCompareResult) {
		if(null != metaStormsCompareResult){
			metaStormsCompareResult.setSongChecked(1);
			metaStormsCompareResult.setError(0);
			metaStormsCompareResult.setCreateTime(new Date());
			
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.save(metaStormsCompareResult);
			s.getTransaction().commit();
			
			try {
				MetaStormsCompareRunCommand metaStormsCompareRunCommand = new MetaStormsCompareRunCommand();
				metaStormsCompareRunCommand.setMetaStormsCompareResult(metaStormsCompareResult);
				metaStormsCompareRunCommand.start();
				
				metaStormsCompareResult.setComplete(1);
				
				sf=HibernateUtil.getSessionFactory();
				s=sf.getCurrentSession();
				s.beginTransaction();
				s.update(metaStormsCompareResult);
				s.getTransaction().commit();
			} catch (Exception e) {
				metaStormsCompareResult.setError(1);
				
				sf=HibernateUtil.getSessionFactory();
				s=sf.getCurrentSession();
				s.beginTransaction();
				s.update(metaStormsCompareResult);
				s.getTransaction().commit();
				
				e.printStackTrace();
			}
		}
	}
	
	//private boolean ifContains(){
		
		//return false;
	//}

	@Override
	public Page getMetaStormsCompareResultByUserId(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}
}
