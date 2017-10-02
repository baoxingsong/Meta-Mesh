package org.metasee.database.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.metasee.database.commonUtil.constant.*;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.service.ParallelMetaResultManager;
import org.metasee.database.service.impl.ParallelMetaResultManagerImp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ParallelReaultDownloadAction extends ActionSupport {
	private int id;
	private String uuid;
	private String userName;
	private String folderName;
	private PermissionAction permissionAction = new PermissionAction();
	ParallelMetaResultManager parallelMetaResultManager=new ParallelMetaResultManagerImp();
	private ParallelMetaResult parallelMetaResult;
	private String message;
	public String execute()throws Exception{
		Map attibutes = ActionContext.getContext().getSession();
		Integer tempId=(Integer)attibutes.get("userid");
		if(null == tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		parallelMetaResult = parallelMetaResultManager.getParallelMetaResultById(id);
		if(permissionAction.ifCouldAccess(parallelMetaResult.getUploadFile().getUploadProject().getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		return SUCCESS;
	}
	public InputStream getTargetFile() throws Exception 
	{
		uuid = parallelMetaResult.getUploadFile().getUploadProject().getRandomFileName();
		userName = parallelMetaResult.getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName();
		folderName = parallelMetaResult.getFoldername();
		String inputFilePath = GlobalConstant.uploadDir + userName + File.separator + uuid + File.separator + folderName + File.separator + "parallelMeta.zip";
		return new FileInputStream(inputFilePath);
	}

	
	public void setId(int id) {
		this.id = id;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFolderName() {
		return folderName;
	}


	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}


	public ParallelMetaResult getParallelMetaResult() {
		return parallelMetaResult;
	}


	public void setParallelMetaResult(ParallelMetaResult parallelMetaResult) {
		this.parallelMetaResult = parallelMetaResult;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getId() {
		return id;
	}
}
