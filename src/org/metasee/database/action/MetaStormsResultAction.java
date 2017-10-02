package org.metasee.database.action;


import java.util.Map;

import org.metasee.database.commonUtil.ReadMetastomeResult;
import org.metasee.database.model.MetaStormsResult;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.model.UploadFile;
import org.metasee.database.model.User;
import org.metasee.database.service.MetaStormsResultManager;
import org.metasee.database.service.ParallelMetaResultManager;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.impl.MetaStormsResultManagerImp;
import org.metasee.database.service.impl.ParallelMetaResultManagerImp;
import org.metasee.database.service.impl.UploadFileManagerImpl;
import org.metasee.database.service.impl.UserManagerImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MetaStormsResultAction extends SuperClass{
	private static final long serialVersionUID = 1L;
	private int metaStormsResultId;
	private int complete;

	private String message;
	private String checkcode;
	
	private String comment;
	private String database;
	private int hitNumber;
	private String exhaustiveSearch;
	private String assignGroupNumber;
	
	MetaStormsResult metaStormsResult=new MetaStormsResult();
	MetaStormsResultManager metaStormsResultManager=new MetaStormsResultManagerImp();
	
	Map attibutes = ActionContext.getContext().getSession();
	PermissionAction permissionAction = new PermissionAction();
	private int parallelMetaResultId;
	
	public String addMetaStormsResult() throws Exception{
		
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage(this.pleaseLogin);
			return LOGIN;
		}
		UserManager userManager=new UserManagerImpl();
		User tempUser=userManager.getUserByUserId(tempId);
		if(null == tempUser){
			setMessage(this.noSuchUser);
			return LOGIN;
		}
		
		this.metaStormsResult.setComplete(0);
		this.metaStormsResult.setError(0);
		
		ParallelMetaResultAction parallelMetaResultAction=new ParallelMetaResultAction();
		ParallelMetaResult parallelMetaResult=new ParallelMetaResult();
		
		parallelMetaResult=new ParallelMetaResultManagerImp().getParallelMetaResultById(parallelMetaResultId);
		this.metaStormsResult.setParallelMetaResult(parallelMetaResult);
		
		this.metaStormsResult.setComment(comment);
		this.metaStormsResult.setDatabase(database);
		this.metaStormsResult.setHitNumber(hitNumber);
		this.metaStormsResult.setExhaustiveSearch(exhaustiveSearch);
		this.metaStormsResult.setAssignGroupNumber(assignGroupNumber);
		
		metaStormsResultManager.addMetaStormsResult(this.metaStormsResult);
		this.setWebPageTitle("search similar samples, META-Storms analysis");
		return SUCCESS;
	}
	
	public String removeParallelMetaResult() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage(this.pleaseLogin);
			return LOGIN;
		}
		this.metaStormsResult=metaStormsResultManager.getMetaStormsResultById(metaStormsResultId);
		if(tempId != this.metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getWorkShop().getOwner().getId()){
			setMessage(this.accessNotPermitted);
			return "not permit";
		}
		metaStormsResultManager.removeById(metaStormsResultId);
		this.setWebPageTitle("META-Storms analysis result");
		return SUCCESS;
	}
	
	public String getMetaStormsResultById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId ){
			setMessage(this.pleaseLogin);
			return LOGIN;
		}
		this.metaStormsResult=metaStormsResultManager.getMetaStormsResultById(metaStormsResultId);
		if(permissionAction.ifCouldAccess(metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage(this.accessNotPermitted);
			return "not permit";
		}
		
		ReadMetastomeResult readMetastomeResult = new ReadMetastomeResult();
		readMetastomeResult.setMetaStormsResult(metaStormsResult);
		readMetastomeResult.readDisplayTableInformation();
		this.setWebPageTitle("similar samples search (META-Storms analysis) result");
		return SUCCESS;
	}
	
	public String updateCommentById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null == tempId || 0 == tempId){
			setMessage(this.pleaseLogin);
			return LOGIN;
		}
		this.metaStormsResult=metaStormsResultManager.getMetaStormsResultById(metaStormsResultId);
		if(tempId != this.metaStormsResult.getParallelMetaResult().getUploadFile().getUploadProject().getWorkShop().getOwner().getId()){
			setMessage(this.accessNotPermitted);
			return "not permit";
		}
		metaStormsResultManager.updateCommentById(metaStormsResultId, comment);
		this.setWebPageTitle("similar samples search (META-Storms analysis) result note edit)");
		return SUCCESS;
	}

	public int getMetaStormsResultId() {
		return metaStormsResultId;
	}

	public void setMetaStormsResultId(int metaStormsResultId) {
		this.metaStormsResultId = metaStormsResultId;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
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

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public int getHitNumber() {
		return hitNumber;
	}

	public void setHitNumber(int hitNumber) {
		this.hitNumber = hitNumber;
	}

	public String getExhaustiveSearch() {
		return exhaustiveSearch;
	}

	public void setExhaustiveSearch(String exhaustiveSearch) {
		this.exhaustiveSearch = exhaustiveSearch;
	}

	public String getAssignGroupNumber() {
		return assignGroupNumber;
	}

	public void setAssignGroupNumber(String assignGroupNumber) {
		this.assignGroupNumber = assignGroupNumber;
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

	public MetaStormsResult getMetaStormsResult() {
		return metaStormsResult;
	}

	public void setMetaStormsResult(MetaStormsResult metaStormsResult) {
		this.metaStormsResult = metaStormsResult;
	}

	public int getParallelMetaResultId() {
		return parallelMetaResultId;
	}

	public void setParallelMetaResultId(int parallelMetaResultId) {
		this.parallelMetaResultId = parallelMetaResultId;
	}
	
}
