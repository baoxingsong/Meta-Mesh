package org.metasee.database.service;


import java.util.List;

import org.metasee.database.model.UploadFile;
import org.metasee.database.model.UploadProject;;

public interface UploadFileManager {
	public abstract void removeUploadFileById(int uploadFileId) throws Exception;
	public abstract UploadFile getUploadFileById(int uploadFileId) throws Exception;
	public abstract void updateCommentById(int uploadFiletId, String comment) throws Exception;
	public abstract void saveUploadFile(UploadFile uploadFile) throws Exception;
}
