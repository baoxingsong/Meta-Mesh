package org.metasee.database.action;

import java.util.Map;

import org.metasee.database.model.UploadFile;
import org.metasee.database.service.UploadFileManager;
import org.metasee.database.service.impl.UploadFileManagerImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadFileAction extends SuperClass{
	private static final long serialVersionUID = 1L;
	private UploadFileManager uploadFileManager=new UploadFileManagerImpl();
	private int uploadFileId;
	String message;
	String comment;
	Map attibutes = ActionContext.getContext().getSession();
	UploadFile uploadFIle=new UploadFile();
	String smapleViewPath;
	PermissionAction permissionAction = new PermissionAction();
	public String removeUploadFileById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		this.uploadFIle=uploadFileManager.getUploadFileById(uploadFileId);
		if(null == tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		if(tempId != this.uploadFIle.getUploadProject().getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		uploadFileManager.removeUploadFileById(uploadFileId);
		return SUCCESS;
	}
	
	public String updateCommentById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null == tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.uploadFIle=uploadFileManager.getUploadFileById(uploadFileId);
		if(tempId != this.uploadFIle.getUploadProject().getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		uploadFileManager.updateCommentById(uploadFileId, comment);
		return SUCCESS;
	}
	
	public String getUploadFileById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0==tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.uploadFIle=uploadFileManager.getUploadFileById(uploadFileId);
		if(permissionAction.ifCouldAccess(uploadFIle.getUploadProject().getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		return SUCCESS;
	}
	
	public String sampleView() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0==tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.uploadFIle=uploadFileManager.getUploadFileById(uploadFileId);
		if(permissionAction.ifCouldAccess(uploadFIle.getUploadProject().getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		return SUCCESS;
	}

	public UploadFileManager getUploadFileManager() {
		return uploadFileManager;
	}

	public void setUploadFileManager(UploadFileManager uploadFileManager) {
		this.uploadFileManager = uploadFileManager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getUploadFileId() {
		return uploadFileId;
	}

	public void setUploadFileId(int uploadFileId) {
		this.uploadFileId = uploadFileId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map getAttibutes() {
		return attibutes;
	}

	public void setAttibutes(Map attibutes) {
		this.attibutes = attibutes;
	}

	public UploadFile getUploadFIle() {
		return uploadFIle;
	}

	public void setUploadFIle(UploadFile uploadFIle) {
		this.uploadFIle = uploadFIle;
	}

	public String getSmapleViewPath() {
		return smapleViewPath;
	}

	public void setSmapleViewPath(String smapleViewPath) {
		this.smapleViewPath = smapleViewPath;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
