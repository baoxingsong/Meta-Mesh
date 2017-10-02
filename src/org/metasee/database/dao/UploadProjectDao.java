package org.metasee.database.dao;

import java.util.List;

import org.metasee.database.model.UploadProject;;
public interface UploadProjectDao {
	public void save(UploadProject uploadProject);
	public List<UploadProject> getUploadProjectsByUserId(int userId);
	public void removeUploadProjectById(int uploadProjectId);
	public UploadProject getUploadProjectById(int uploadProjectId);
	public void updateCommentById(int uploadProjectId, String comment);
	public UploadProject getUploadProjectByRandomFileName(String randomFileName);
}
