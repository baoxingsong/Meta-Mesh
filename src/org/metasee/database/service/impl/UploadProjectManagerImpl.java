package org.metasee.database.service.impl;

import java.util.List;

import org.metasee.database.dao.impl.UploadProjectDaoImpl;
import org.metasee.database.model.UploadProject;
import org.metasee.database.service.UploadProjectManager;

public class UploadProjectManagerImpl implements UploadProjectManager {
	private UploadProjectDaoImpl uploadProjectDao = new UploadProjectDaoImpl();
	
	@Override
	public void add(UploadProject uploadProject) throws Exception {
		uploadProjectDao.save(uploadProject);
	}

	@Override
	public List<UploadProject> getUploadProjectsByUserId(int userId)
			throws Exception {
		return uploadProjectDao.getUploadProjectsByUserId(userId);
	}

	@Override
	public void removeUploadProjectById(int uploadProjectId) throws Exception {
		uploadProjectDao.removeUploadProjectById(uploadProjectId);
	}

	@Override
	public UploadProject getUploadProjectById(int uploadProjectId) throws Exception {
		return uploadProjectDao.getUploadProjectById(uploadProjectId);
		
	}

	@Override
	public void updateCommentById(int uploadProjectId, String comment)
			throws Exception {
		uploadProjectDao.updateCommentById(uploadProjectId, comment);
		
	}

	@Override
	public UploadProject getUploadProjectByRandomFileName(String randomFileName)
			throws Exception {
		// TODO Auto-generated method stub
		return uploadProjectDao.getUploadProjectByRandomFileName(randomFileName);
	}
}