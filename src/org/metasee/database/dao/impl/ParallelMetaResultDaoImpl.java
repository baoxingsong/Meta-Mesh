package org.metasee.database.dao.impl;


import java.io.File;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.service.impl.MetaStormsResultManagerImp;
import org.metasee.database.util.HibernateUtil;

import org.metasee.database.commonUtil.DeleteFile;
import org.metasee.database.commonUtil.Page;
import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.commonUtil.runCommand.ParallelMetaRunCommand;
import org.metasee.database.dao.ParallelMetaResultDao;
import org.metasee.database.model.MetaStormsResult;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.model.UploadFile;

public class ParallelMetaResultDaoImpl implements ParallelMetaResultDao {
	@Override
	public void removeById(int parallelMetaResultId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<ParallelMetaResult> parallelMetaResults=(List<ParallelMetaResult>)s.createQuery("from ParallelMetaResult parallelMetaResult where parallelMetaResult.id =" + parallelMetaResultId + "and parallelMetaResult.songChecked=1").list();
		s.getTransaction().commit();
		
		if(parallelMetaResults.size()>0){
			ParallelMetaResult parallelMetaResult = parallelMetaResults.get(0);
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			List<MetaStormsResult> metaStormsResults=(List<MetaStormsResult>)s.createQuery("from MetaStormsResult metaStormsResult where metaStormsResult.parallelMetaResult.id =" + parallelMetaResultId).list();
			s.getTransaction().commit();
			
			MetaStormsResultManagerImp metaStormsResultManager = new MetaStormsResultManagerImp();
			for (MetaStormsResult metaStormsResult : metaStormsResults){
				try {
					metaStormsResultManager.removeById(metaStormsResult.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				String path = GlobalConstant.uploadDir + parallelMetaResult.getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName() + File.separator + parallelMetaResult.getUploadFile().getUploadProject().getRandomFileName() + File.separator + parallelMetaResult.getFoldername();
				DeleteFile deleteFile = new DeleteFile(path);
				deleteFile.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.delete(parallelMetaResult);
			s.getTransaction().commit();
		}
	}

	@Override
	public ParallelMetaResult getParallelMetaResultById(int parallelMetaResultId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<ParallelMetaResult> parallelMetaResults=(List<ParallelMetaResult>)s.createQuery("from ParallelMetaResult parallelMetaResult where parallelMetaResult.id =" + parallelMetaResultId + "and parallelMetaResult.songChecked=1").list();
		s.getTransaction().commit();
		
		if(parallelMetaResults.size()>0){
			ParallelMetaResult parallelMetaResult=parallelMetaResults.get(0);
			return parallelMetaResult;
		}
		return null;
	}

	@Override
	public void updateCommentById(int parallelMetaResultId, String comment) {
		ParallelMetaResult parallelMetaResult=this.getParallelMetaResultById(parallelMetaResultId);
		if(null != parallelMetaResult){
			parallelMetaResult.setComment(comment);
			
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.update(parallelMetaResult);
			s.getTransaction().commit();
		}
	}

	@Override
	public void addParallelMetaResult(ParallelMetaResult parallelMetaResult) {
		
		if(null != parallelMetaResult){
			parallelMetaResult.setSongChecked(1);
			parallelMetaResult.setCreateTime(new Date());
			parallelMetaResult.setStart(0);
			parallelMetaResult.setError(0);
			parallelMetaResult.setComplete(0);
			
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.save(parallelMetaResult);
			s.getTransaction().commit();
			/*
			try {
				ParallelMetaRunCommand runCommand=new ParallelMetaRunCommand();
				runCommand.setParallelMetaResult(parallelMetaResult);
				runCommand.start();
			} catch (Exception e) {
				s = sf.getCurrentSession();
				s.beginTransaction();
				parallelMetaResult.setError(1);
				s.update(parallelMetaResult);
				s.getTransaction().commit();
				e.printStackTrace();
			}
			*/
		}		
	}

	@Override
	public Page getParallelMetaResultsByUploadFileId(int uploadFileId) {
		
		return null;
	}

	@Override
	public String checkExists(ParallelMetaResult pResult) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<ParallelMetaResult> parallelMetaResults=(List<ParallelMetaResult>)s.createQuery("from ParallelMetaResult parallelMetaResult where parallelMetaResult.songChecked=1 and parallelMetaResult.error=0 and parallelMetaResult.uploadFile.id="+pResult.getUploadFile().getId()+"and parallelMetaResult.type='"+pResult.getType()+"' and parallelMetaResult.format='"+pResult.getFormat()+"' and parallelMetaResult.length='"+pResult.getLength()+"' and parallelMetaResult.database='"+pResult.getDatabase()+"' and parallelMetaResult.domainsample='"+pResult.getDomainsample()+"' and parallelMetaResult.evalue='"+pResult.getEvalue()+"' and parallelMetaResult.phylogeneticanalysis='"+pResult.getPhylogeneticanalysis()+"'").list();
		s.getTransaction().commit();
		
		if(parallelMetaResults.size()>0){
			return "exists";
		}
		return null;
	}
}
