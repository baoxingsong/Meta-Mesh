package org.metasee.database.dao;

import org.metasee.database.model.UploadFile;

public interface UploadFileDao {
	public void removeUploadFileById(int uploadFileId);
	public UploadFile getUploadFileById(int uploadFileId);
	public void saveUploadFile(UploadFile uploadFile);
	public void updateCommentById(int uploadFiletId, String comment);
}
