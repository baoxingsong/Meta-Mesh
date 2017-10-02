package org.metasee.database.service;


import java.util.List;

import org.metasee.database.model.UploadProject;;

public interface UploadProjectManager {
	public abstract void add(UploadProject uploadProject) throws Exception;
	public abstract List<UploadProject> getUploadProjectsByUserId(int userId) throws Exception;
	public abstract void removeUploadProjectById(int uploadProjectId) throws Exception;
	public abstract UploadProject getUploadProjectById(int uploadProjectId) throws Exception;
	public abstract void updateCommentById(int uploadProjectId, String comment) throws Exception;
	public UploadProject getUploadProjectByRandomFileName(String randomFileName) throws Exception;
}
