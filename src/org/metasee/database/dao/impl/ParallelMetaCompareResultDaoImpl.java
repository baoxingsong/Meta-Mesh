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
import org.metasee.database.commonUtil.runCommand.ParallelMetaCompareRunCommand;
import org.metasee.database.dao.ParallelMetaCompareResultDao;
import org.metasee.database.model.ParallelMetaCompareResult;

public class ParallelMetaCompareResultDaoImpl implements ParallelMetaCompareResultDao {
	@Override
	public void removeById(int parallelMetaCompareResultId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<ParallelMetaCompareResult> parallelMetaCompareResults=(List<ParallelMetaCompareResult>)s.createQuery("from ParallelMetaCompareResult parallelMetaCompareResult where parallelMetaCompareResult.id =" + parallelMetaCompareResultId + "and parallelMetaCompareResult.songChecked=1").list();
		s.getTransaction().commit();
		
		if(parallelMetaCompareResults.size()>0){
			ParallelMetaCompareResult parallelMetaCompareResult=parallelMetaCompareResults.get(0);
			try {
				String path = GlobalConstant.uploadDir + parallelMetaCompareResult.getWorkShop().getOwner().getUserName() + File.separator + GlobalConstant.PARALLELMETACOMPARE + File.separator + parallelMetaCompareResult.getId() + File.separator;
				DeleteFile deleteFile = new DeleteFile(path);
				deleteFile.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			parallelMetaCompareResult.setSongChecked(0);
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.update(parallelMetaCompareResult);
			s.getTransaction().commit();
		}
	}

	@Override
	public ParallelMetaCompareResult getParallelMetaCompareResultById(int parallelMetaCompareResultId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<ParallelMetaCompareResult> parallelMetaCompareResults=(List<ParallelMetaCompareResult>)s.createQuery("from ParallelMetaCompareResult parallelMetaCompareResult where parallelMetaCompareResult.id =" + parallelMetaCompareResultId + "and parallelMetaCompareResult.songChecked=1").list();
		s.getTransaction().commit();
		
		if(parallelMetaCompareResults.size()>0){
			ParallelMetaCompareResult parallelMetaCompareResult=parallelMetaCompareResults.get(0);
			return parallelMetaCompareResult;
		}
		return null;
	}

	@Override
	public void updateCommentById(int parallelMetaCompareResultId, String comment) {
		ParallelMetaCompareResult parallelMetaCompareResult=this.getParallelMetaCompareResultById(parallelMetaCompareResultId);
		if(null != parallelMetaCompareResult){
			parallelMetaCompareResult.setComment(comment);
			
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.update(parallelMetaCompareResult);
			s.getTransaction().commit();
		}
	}

	@Override
	public void addParallelMetaCompareResult(ParallelMetaCompareResult parallelMetaCompareResult) {
		if(null != parallelMetaCompareResult){
			parallelMetaCompareResult.setSongChecked(1);
			parallelMetaCompareResult.setError(0);
			parallelMetaCompareResult.setCreateTime(new Date());
			
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.save(parallelMetaCompareResult);
			s.getTransaction().commit();
			
			try {
				ParallelMetaCompareRunCommand parallelMetaCompareRunCommand = new ParallelMetaCompareRunCommand();
				parallelMetaCompareRunCommand.setParallelMetaCompareResult(parallelMetaCompareResult);
				parallelMetaCompareRunCommand.start();
				
				parallelMetaCompareResult.setComplete(1);
				
				sf=HibernateUtil.getSessionFactory();
				s=sf.getCurrentSession();
				s.beginTransaction();
				s.update(parallelMetaCompareResult);
				s.getTransaction().commit();
				
			} catch (Exception e) {
				parallelMetaCompareResult.setError(1);
				
				sf=HibernateUtil.getSessionFactory();
				s=sf.getCurrentSession();
				s.beginTransaction();
				s.update(parallelMetaCompareResult);
				s.getTransaction().commit();
				
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Page getParallelMetaCompareResultByUserId(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}
}
