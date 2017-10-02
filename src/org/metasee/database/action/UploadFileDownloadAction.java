package org.metasee.database.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.model.UploadFile;
import org.metasee.database.service.impl.UploadFileManagerImpl;

import com.opensymphony.xwork2.ActionContext;

public class UploadFileDownloadAction extends SuperClass {
	private int uploadFileId;
	private PermissionAction permissionAction = new PermissionAction();
	private UploadFile uploadFile = new UploadFile();
	private int workShopId;
	private String fileName;
	public String execute()throws Exception{
		Map attibutes = ActionContext.getContext().getSession();
		Integer tempId=(Integer)attibutes.get("userid");
		if(null == tempId || 0 == tempId){
			return LOGIN;
		}
		uploadFile = (new UploadFileManagerImpl()).getUploadFileById(uploadFileId);
		fileName = uploadFile.getFileName();
		workShopId = uploadFile.getUploadProject().getWorkShop().getId();
		if(permissionAction.ifCouldAccess(uploadFile.getUploadProject().getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			return "not permit";
		}
		return SUCCESS;
	}
	public InputStream getTargetFile() throws Exception 
	{	
		String inputFilePath = GlobalConstant.uploadDir + uploadFile.getUploadProject().getWorkShop().getOwner().getUserName() + File.separator + uploadFile.getUploadProject().getRandomFileName() + File.separator + uploadFile.getFileName();
		return new FileInputStream(inputFilePath);
	}
	public int getUploadFileId() {
		return uploadFileId;
	}
	public void setUploadFileId(int uploadFileId) {
		this.uploadFileId = uploadFileId;
	}
	public PermissionAction getPermissionAction() {
		return permissionAction;
	}
	public void setPermissionAction(PermissionAction permissionAction) {
		this.permissionAction = permissionAction;
	}
	public UploadFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public int getWorkShopId() {
		return workShopId;
	}
	public void setWorkShopId(int workShopId) {
		this.workShopId = workShopId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
