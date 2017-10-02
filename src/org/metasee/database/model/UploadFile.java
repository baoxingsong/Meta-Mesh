package org.metasee.database.model;

import java.util.HashSet;
import java.util.Set;

public class UploadFile {
	private int id;
	private String fileName;
	private UploadProject uploadProject;
	private int songChecked;
	private int complete;
	private String comment;
	private Set<ParallelMetaResult> parallelMetaResults=new HashSet<ParallelMetaResult>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public UploadProject getUploadProject() {
		return uploadProject;
	}
	public void setUploadProject(UploadProject uploadProject) {
		this.uploadProject = uploadProject;
	}
	public int getSongChecked() {
		return songChecked;
	}
	public void setSongChecked(int songChecked) {
		this.songChecked = songChecked;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Set<ParallelMetaResult> getParallelMetaResults() {
		return parallelMetaResults;
	}
	public void setParallelMetaResults(Set<ParallelMetaResult> parallelMetaResults) {
		this.parallelMetaResults = parallelMetaResults;
	}
	
}