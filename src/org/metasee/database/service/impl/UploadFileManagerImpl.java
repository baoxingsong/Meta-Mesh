package org.metasee.database.service.impl;

import java.util.List;

import org.metasee.database.dao.impl.UploadFileDaoImpl;
import org.metasee.database.model.UploadFile;
import org.metasee.database.service.UploadFileManager;

public class UploadFileManagerImpl implements UploadFileManager {
	private UploadFileDaoImpl uploadFileDao = new UploadFileDaoImpl();
	
	@Override
	public void removeUploadFileById(int uploadFileId) throws Exception {
		uploadFileDao.removeUploadFileById(uploadFileId);
	}

	@Override
	public UploadFile getUploadFileById(int uploadFileId) {
		return uploadFileDao.getUploadFileById(uploadFileId);
	}

	@Override
	public void updateCommentById(int uploadFiletId, String comment)
			throws Exception {
		uploadFileDao.updateCommentById(uploadFiletId, comment);
		
	}

	@Override
	public void saveUploadFile(UploadFile uploadFile) throws Exception {
		// TODO Auto-generated method stub
		uploadFileDao.saveUploadFile(uploadFile);
	}
}