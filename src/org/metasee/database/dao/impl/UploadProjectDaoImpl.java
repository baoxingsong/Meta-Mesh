package org.metasee.database.dao.impl;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.commonUtil.DeleteFile;
import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.dao.UploadProjectDao;
import org.metasee.database.model.UploadFile;
import org.metasee.database.model.UploadProject;
import org.metasee.database.service.impl.UploadFileManagerImpl;
import org.metasee.database.util.HibernateUtil;

public class UploadProjectDaoImpl implements UploadProjectDao {

	@Override
	public void save(UploadProject uploadProject) {
		
		uploadProject.setSongChecked(1);
		uploadProject.setCreateTime(new Date());
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(uploadProject);
		s.getTransaction().commit();
		
		Iterator<UploadFile> iterator=uploadProject.getUploadFiles().iterator();
		while(iterator.hasNext()){
			UploadFile uploadfile=iterator.next();
			uploadfile.setSongChecked(1);
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.save(uploadfile);
			s.getTransaction().commit();
		}
	}

	@Override
	public List<UploadProject> getUploadProjectsByUserId(int userId) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<UploadProject> uploadProjects=(List<UploadProject>)s.createQuery("from UploadProject uploadProject where uploadProject.user.id =" + userId + "and uploadProject.songChecked=1").list();
		s.getTransaction().commit();
		
		return uploadProjects;
	}

	@Override
	public void removeUploadProjectById(int uploadProjectId) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();		
		List<UploadProject> uploadProjects=(List<UploadProject>)s.createQuery("from UploadProject uploadProject where uploadProject.id =" + uploadProjectId + "and uploadProject.songChecked=1").list();
		s.getTransaction().commit();
		
		if(uploadProjects.size()>0){
			UploadProject uploadProject=uploadProjects.get(0);
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			List<UploadFile> uploadFiles=(List<UploadFile>)s.createQuery("from UploadFile uploadFile where uploadFile.uploadProject.id =" + uploadProjectId + "and uploadFile.songChecked=1").list();
			s.getTransaction().commit();
			
			UploadFileManagerImpl uploadFileManager = new UploadFileManagerImpl();
			for (UploadFile forUploadFile : uploadFiles){
				try {
					uploadFileManager.removeUploadFileById(forUploadFile.getId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				String path = GlobalConstant.uploadDir + uploadProject.getWorkShop().getOwner().getUserName() + File.separator + uploadProject.getRandomFileName();
				DeleteFile deleteFile = new DeleteFile(path);
				deleteFile.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sf = HibernateUtil.getSessionFactory();
			s = sf.getCurrentSession();
			s.beginTransaction();
			s.delete(uploadProject);
			s.getTransaction().commit();
		}
	}
	
	@Override
	public UploadProject getUploadProjectById(int uploadProjectId){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<UploadProject> uploadProjects = (List<UploadProject>)s.createQuery("from UploadProject uploadProject where uploadProject.id =" + uploadProjectId + " and uploadProject.songChecked=1").list();
		s.getTransaction().commit();
		
		if(uploadProjects.size()>0){
			return uploadProjects.get(0);
		}
		return null;
	}
	
	@Override
	public UploadProject getUploadProjectByRandomFileName(String randomFileName){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		List<UploadProject> uploadProjects = (List<UploadProject>)s.createQuery("from UploadProject uploadProject where uploadProject.randomFileName ='" + randomFileName + "' and uploadProject.songChecked=1").list();
		s.getTransaction().commit();
		
		if(uploadProjects.size()>0){
			return uploadProjects.get(0);
		}
		return null;
	}
	
	@Override
	public void updateCommentById(int uploadProjectId, String comment){
		UploadProject preUpdateCommentUploadProject=this.getUploadProjectById(uploadProjectId);
		if(null != preUpdateCommentUploadProject){
			preUpdateCommentUploadProject.setComment(comment);
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s=sf.getCurrentSession();
			s.beginTransaction();
			s.update(preUpdateCommentUploadProject);
			s.getTransaction().commit();
			
		}
	}
	
}
