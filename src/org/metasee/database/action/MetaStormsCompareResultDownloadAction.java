package org.metasee.database.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.model.MetaStormsCompareResult;
import org.metasee.database.service.impl.MetaStormsCompareResultManagerImpl;

import com.opensymphony.xwork2.ActionContext;

public class MetaStormsCompareResultDownloadAction extends SuperClass {
	private int id;
	private String message;
	MetaStormsCompareResult metaStormsCompareResult;
	PermissionAction permissionAction = new PermissionAction();
	public String execute()throws Exception{
		if((new PermissionAction()).ifLoginEd()){
			
		}else{
			return LOGIN;
		}
		Map attibutes = ActionContext.getContext().getSession();
		Integer tempId=(Integer)attibutes.get("userid");
		metaStormsCompareResult = (new MetaStormsCompareResultManagerImpl()).getMetaStormsCompareResultById(id);
		if(permissionAction.ifCouldAccess(metaStormsCompareResult.getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			return "not permit";
		}
		return SUCCESS;
	}
	public InputStream getTargetFile() throws Exception 
	{	
		
		String inputFilePath = GlobalConstant.uploadDir + metaStormsCompareResult.getWorkShop().getOwner().getUserName() + File.separator + GlobalConstant.METASTORMSCOMPARE + File.separator + id + File.separator + "compare.zip";
		System.out.println(inputFilePath + inputFilePath);
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
