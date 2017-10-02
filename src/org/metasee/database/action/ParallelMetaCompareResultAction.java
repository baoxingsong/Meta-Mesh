package org.metasee.database.action;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.metasee.database.model.ParallelMetaCompareResult;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkShop;
import org.metasee.database.service.ParallelMetaCompareResultManager;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.impl.ParallelMetaCompareResultManagerImpl;
import org.metasee.database.service.impl.ParallelMetaResultManagerImp;
import org.metasee.database.service.impl.UserManagerImpl;
import org.metasee.database.service.impl.WorkShopManagerImpl;
import org.metasee.database.service.ParallelMetaResultManager;

import org.metasee.database.commonUtil.constant.GlobalConstant;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ParallelMetaCompareResultAction extends SuperClass{
	private static final long serialVersionUID = 1L;
	private int parallelMetaCompareResultId;
	private int complete;
	private String comment;
	
	private String message;
	private int workShopId;
	private int[] parallelMetaResultIds;

	private String checkcode;
	private ParallelMetaCompareResult parallelMetaCompareResult=new ParallelMetaCompareResult();
	private ParallelMetaCompareResultManager parallelMetaCompareResultManager=new ParallelMetaCompareResultManagerImpl();
	private ParallelMetaResultManager parallelMetaResultManager=new ParallelMetaResultManagerImp();
	Map attibutes = ActionContext.getContext().getSession();
	private PermissionAction permissionAction = new PermissionAction();
	private String resultAddress;
	public ParallelMetaResultManager getParallelMetaResultManager() {
		return parallelMetaResultManager;
	}

	public void setParallelMetaResultManager(
			ParallelMetaResultManager parallelMetaResultManager) {
		this.parallelMetaResultManager = parallelMetaResultManager;
	}

	public String getResultAddress() {
		return resultAddress;
	}

	public void setResultAddress(String resultAddress) {
		this.resultAddress = resultAddress;
	}

	public String addParallelMetaCompareResult() throws Exception{
		/*
		if(! ((String)attibutes.get("rand")).equalsIgnoreCase(checkcode)){
			setMessage("Wrong check code! Please check it.");
			attibutes.remove("rand");
			System.out.println(message);
			return INPUT;
		}
		attibutes.remove("rand");
		*/
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		UserManager userManager=new UserManagerImpl();
		User tempUser=userManager.getUserByUserId(tempId);
		if(null == tempUser){
			setMessage("Cannot find current user, please Log in!");
			return LOGIN;
		}
		WorkShop workShop = (new WorkShopManagerImpl()).getWorkShopById(workShopId);
		System.out.println("workShop workShop " + workShop.getId() + workShop.getName());
		parallelMetaCompareResult.setWorkShop(workShop);
		for(int parallelMetaResultIdList:parallelMetaResultIds){
			parallelMetaCompareResult.getParallelMetaResults().add(parallelMetaResultManager.getParallelMetaResultById(parallelMetaResultIdList));
		}
		System.out.println("workShop workShop " + workShop.getId() + workShop.getName());
		parallelMetaCompareResultManager.addParallelMetaCompareResult(parallelMetaCompareResult);
		return SUCCESS;
	}

	
	public String removeParallelMetaCompareResult() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.parallelMetaCompareResult=parallelMetaCompareResultManager.getParallelMetaCompareResultById(parallelMetaCompareResultId);
		if(null == parallelMetaCompareResult){
			return SUCCESS;
		}
		if(tempId != this.parallelMetaCompareResult.getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		parallelMetaCompareResultManager.removeById(parallelMetaCompareResultId);
		return SUCCESS;
	}
	
	public String getParallelMetaCompareResultById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.parallelMetaCompareResult=parallelMetaCompareResultManager.getParallelMetaCompareResultById(parallelMetaCompareResultId);
		if(permissionAction.ifCouldAccess(parallelMetaCompareResult.getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		
		this.setResultAddress("upload"+File.separator+parallelMetaCompareResult.getWorkShop().getOwner().getUserName()+File.separator+GlobalConstant.PARALLELMETACOMPARE+File.separator+parallelMetaCompareResult.getId()+File.separator+"taxonomy.html");
		return SUCCESS;
	}
	
	public String updateCommentById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null == tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.parallelMetaCompareResult=parallelMetaCompareResultManager.getParallelMetaCompareResultById(parallelMetaCompareResultId);
		if(tempId != this.parallelMetaCompareResult.getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		parallelMetaCompareResultManager.updateCommentById(parallelMetaCompareResultId, comment);
		return SUCCESS;
	}
	
	private String sampleURL;
	public String getParallelMetaCompareResultViewById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.parallelMetaCompareResult=parallelMetaCompareResultManager.getParallelMetaCompareResultById(parallelMetaCompareResultId);
		
		if(permissionAction.ifCouldAccess(parallelMetaCompareResult.getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		this.setSampleURL(GlobalConstant.uploadDir+this.parallelMetaCompareResult.getWorkShop().getOwner().getUserName()+File.separator+ GlobalConstant.PARALLELMETACOMPARE+File.separator+this.parallelMetaCompareResult.getId()+File.separator+"taxonomy.html");
		readViewSource(sampleURL);
		return SUCCESS;
	}
	private String viewSource;
	private void readViewSource(String sampleURL2) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(sampleURL2)));
        	String line;
        	StringBuffer sb = new StringBuffer();
        	while((line=br.readLine())!=null){
        		sb.append(line);
        	}
        	this.setViewSource(sb.toString());        	
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public int getParallelMetaCompareResultId() {
		return parallelMetaCompareResultId;
	}


	public void setParallelMetaCompareResultId(int parallelMetaCompareResultId) {
		this.parallelMetaCompareResultId = parallelMetaCompareResultId;
	}


	public int getComplete() {
		return complete;
	}


	public void setComplete(int complete) {
		this.complete = complete;
	}


	public int[] getParallelMetaResultIds() {
		return parallelMetaResultIds;
	}


	public void setParallelMetaResultIds(int[] parallelMetaResultIds) {
		this.parallelMetaResultIds = parallelMetaResultIds;
	}


	public String getCheckcode() {
		return checkcode;
	}


	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}


	public ParallelMetaCompareResult getParallelMetaCompareResult() {
		return parallelMetaCompareResult;
	}


	public void setParallelMetaCompareResult(
			ParallelMetaCompareResult parallelMetaCompareResult) {
		this.parallelMetaCompareResult = parallelMetaCompareResult;
	}


	public ParallelMetaCompareResultManager getParallelMetaCompareResultManager() {
		return parallelMetaCompareResultManager;
	}


	public void setParallelMetaCompareResultManager(
			ParallelMetaCompareResultManager parallelMetaCompareResultManager) {
		this.parallelMetaCompareResultManager = parallelMetaCompareResultManager;
	}


	public Map getAttibutes() {
		return attibutes;
	}


	public void setAttibutes(Map attibutes) {
		this.attibutes = attibutes;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
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

	public String getSampleURL() {
		return sampleURL;
	}

	public void setSampleURL(String sampleURL) {
		this.sampleURL = sampleURL;
	}

	public String getViewSource() {
		return viewSource;
	}

	public void setViewSource(String viewSource) {
		this.viewSource = viewSource;
	}
	
}
