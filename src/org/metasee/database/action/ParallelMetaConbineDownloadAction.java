package org.metasee.database.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.model.ParallelMetaCompareResult;
import org.metasee.database.service.impl.ParallelMetaCompareResultManagerImpl;

import com.opensymphony.xwork2.ActionContext;

public class ParallelMetaConbineDownloadAction extends SuperClass {
	private int id;
	private String message;
	ParallelMetaCompareResult parallelMetaCompareResult;
	private PermissionAction permissionAction = new PermissionAction();
	public String execute()throws Exception{
		Map attibutes = ActionContext.getContext().getSession();
		Integer tempId=(Integer)attibutes.get("userid");
		if(null == tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		parallelMetaCompareResult = (new ParallelMetaCompareResultManagerImpl()).getParallelMetaCompareResultById(id);

		if(permissionAction.ifCouldAccess(parallelMetaCompareResult.getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		return SUCCESS;
	}
	public InputStream getTargetFile() throws Exception 
	{	
		String inputFilePath = GlobalConstant.uploadDir + parallelMetaCompareResult.getWorkShop().getOwner().getUserName() + File.separator + GlobalConstant.PARALLELMETACOMPARE + File.separator + id + File.separator + "combine.zip";
		return new FileInputStream(inputFilePath);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
