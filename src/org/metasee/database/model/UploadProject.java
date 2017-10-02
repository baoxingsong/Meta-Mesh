package org.metasee.database.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UploadProject {
	private int id;
	private String randomFileName;
	private Set<UploadFile> uploadFiles=new HashSet<UploadFile>();
	private Date createTime;
	private WorkShop workShop;

	private int songChecked;
	private String comment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRandomFileName() {
		return randomFileName;
	}
	public void setRandomFileName(String randomFileName) {
		this.randomFileName = randomFileName;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Set<UploadFile> getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(Set<UploadFile> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public UploadProject() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((randomFileName == null) ? 0 : randomFileName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UploadProject other = (UploadProject) obj;
		if (randomFileName == null) {
			if (other.randomFileName != null)
				return false;
		} else if (!randomFileName.equals(other.randomFileName))
			return false;
		return true;
	}
	
	public int getSongChecked() {
		return songChecked;
	}
	public void setSongChecked(int songChecked) {
		this.songChecked = songChecked;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public WorkShop getWorkShop() {
		return workShop;
	}
	public void setWorkShop(WorkShop workShop) {
		this.workShop = workShop;
	}
	
}
