package org.metasee.database.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.metasee.database.model.UploadFile;
import org.metasee.database.model.UploadProject;
import org.metasee.database.model.User;
import org.metasee.database.service.UploadProjectManager;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.impl.UploadProjectManagerImpl;
import org.metasee.database.service.impl.UserManagerImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadProjectAction extends SuperClass{
	private static final long serialVersionUID = 1L;
	UploadProject uploadProject=new UploadProject();
	String uploadProjectName;
	List<UploadProject> uploadProjectsList=new ArrayList<UploadProject>();
	Set<UploadFile> uploadFiles=new HashSet<UploadFile>();
	Set<String> uploadFileNames=new HashSet<String>();
	String rawUploadFiles;
	int uploadProjectId;
	String message;
	private int workShopId;
	private PermissionAction permissionAction = new PermissionAction();
	String comment;
	
	Map attibutes = ActionContext.getContext().getSession();
	private String checkcode;
	UploadProjectManager uploadProjectManager=new UploadProjectManagerImpl();
	
	public String getUploadProjectsByUserId() throws Exception{
		this.uploadProjectsList=uploadProjectManager.getUploadProjectsByUserId(1);
		return SUCCESS;
	}
	
	public String removeUploadProjectById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.uploadProject=uploadProjectManager.getUploadProjectById(uploadProjectId);
		workShopId = uploadProject.getWorkShop().getId();
		System.out.println("workShopId workShopId " + workShopId);
		if(tempId != this.uploadProject.getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		uploadProjectManager.removeUploadProjectById(uploadProjectId);
		return SUCCESS;
	}
	
	public String updateCommentById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.uploadProject=uploadProjectManager.getUploadProjectById(uploadProjectId);
		workShopId = uploadProject.getWorkShop().getId();
		System.out.println("workShopId workShopId " + workShopId);
		if(tempId != this.uploadProject.getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		uploadProjectManager.updateCommentById(uploadProjectId, comment);
		return SUCCESS;
	}
	
	public String getUploadProjectById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.uploadProject=uploadProjectManager.getUploadProjectById(uploadProjectId);
		if(permissionAction.ifCouldAccess(uploadProject.getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		
		return SUCCESS;
	}
	public UploadProject getUploadProject() {
		return uploadProject;
	}

	public void setUploadProject(UploadProject uploadProject) {
		this.uploadProject = uploadProject;
	}

	public String getUploadProjectName() {
		return uploadProjectName;
	}

	public void setUploadProjectName(String uploadProjectName) {
		this.uploadProjectName = uploadProjectName;
	}

	public Set<UploadFile> getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(Set<UploadFile> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	public Set<String> getUploadFileNames() {
		return uploadFileNames;
	}

	public void setUploadFileNames(Set<String> uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

	public String getRawUploadFiles() {
		return rawUploadFiles;
	}

	public void setRawUploadFiles(String rawUploadFiles) {
		this.rawUploadFiles = rawUploadFiles;
	}

	public int getUploadProjectId() {
		return uploadProjectId;
	}

	public void setUploadProjectId(int uploadProjectId) {
		this.uploadProjectId = uploadProjectId;
	}

	public UploadProjectManager getUploadProjectManager() {
		return uploadProjectManager;
	}

	public void setUploadProjectManager(UploadProjectManager uploadProjectManager) {
		this.uploadProjectManager = uploadProjectManager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<UploadProject> getUploadProjectsList() {
		return uploadProjectsList;
	}

	public void setUploadProjectsList(List<UploadProject> uploadProjectsList) {
		this.uploadProjectsList = uploadProjectsList;
	}
	public Map getAttibutes() {
		return attibutes;
	}

	public void setAttibutes(Map attibutes) {
		this.attibutes = attibutes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getWorkShopId() {
		return workShopId;
	}

	public void setWorkShopId(int workShopId) {
		this.workShopId = workShopId;
	}

	public PermissionAction getPermissionAction() {
		return permissionAction;
	}

	public void setPermissionAction(PermissionAction permissionAction) {
		this.permissionAction = permissionAction;
	}
	
	
}
