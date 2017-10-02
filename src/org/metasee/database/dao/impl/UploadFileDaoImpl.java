package org.metasee.database.dao.impl;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.commonUtil.DeleteFile;
import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.dao.UploadFileDao;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.model.UploadFile;
import org.metasee.database.model.UploadProject;
import org.metasee.database.service.impl.ParallelMetaResultManagerImp;
import org.metasee.database.util.HibernateUtil;

public class UploadFileDaoImpl implements UploadFileDao {

	@Override
	public void removeUploadFileById(int uploadFileId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<UploadFile> uploadFiles=(List<UploadFile>)s.createQuery("from UploadFile uploadFile where uploadFile.id =" + uploadFileId + "and uploadFile.songChecked=1").list();
		s.getTransaction().commit();
		
		if(uploadFiles.size()>0){
			UploadFile uploadFile=uploadFiles.get(0);
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			List<ParallelMetaResult> parallelMetaResults = (List<ParallelMetaResult>)s.createQuery("from ParallelMetaResult parallelMetaResult where parallelMetaResult.uploadFile.id =" + uploadFileId).list(); 
			s.getTransaction().commit();
			
			ParallelMetaResultManagerImp parallelMetaResultManager = new ParallelMetaResultManagerImp();
			for(ParallelMetaResult parallelMetaResult : parallelMetaResults){
				try {
					parallelMetaResultManager.removeById(parallelMetaResult.getId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				String path = GlobalConstant.uploadDir + uploadFile.getUploadProject().getWorkShop().getOwner().getUserName() + File.separator + uploadFile.getUploadProject().getRandomFileName() + File.separator + uploadFile.getFileName();
				DeleteFile deleteFile = new DeleteFile(path);
				deleteFile.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.delete(uploadFile);
			s.getTransaction().commit();
		}
	}
	
	@Override
	public UploadFile getUploadFileById(int uploadFileId) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<UploadFile> uploadFiles=(List<UploadFile>)s.createQuery("from UploadFile uploadFile where uploadFile.id =" + uploadFileId + "and uploadFile.songChecked=1").list();
		s.getTransaction().commit();
		
		if(uploadFiles.size()>0){
			UploadFile getedUploadfile=uploadFiles.get(0);
			
			sf = HibernateUtil.getSessionFactory();
			s=sf.getCurrentSession();
			s.beginTransaction();
			List<ParallelMetaResult> itParallelMetaResults=(List<ParallelMetaResult>)s.createQuery("from ParallelMetaResult parallelMetaResult where parallelMetaResult.uploadFile.id='"+getedUploadfile.getId()+"' and parallelMetaResult.songChecked = 1").list();
			s.getTransaction().commit();
			
			Set<ParallelMetaResult> itParallelMetaResultHash=new HashSet<ParallelMetaResult>();
			itParallelMetaResultHash.addAll(itParallelMetaResults);
			getedUploadfile.setParallelMetaResults(itParallelMetaResultHash);
			return getedUploadfile;
		}
		return null;
	}
	
	@Override
	public void updateCommentById(int uploadFiletId, String comment){
		UploadFile preUpdateCommentUploadFile=this.getUploadFileById(uploadFiletId);
		if(null != preUpdateCommentUploadFile){
			preUpdateCommentUploadFile.setComment(comment);
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.update(preUpdateCommentUploadFile);
			s.getTransaction().commit();
		}
	}

	@Override
	public void saveUploadFile(UploadFile uploadFile) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(uploadFile);
		s.getTransaction().commit();
	
	}	
}
