package org.metasee.database.action;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.model.UploadFile;
import org.metasee.database.model.User;
import org.metasee.database.service.ParallelMetaResultManager;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.impl.ParallelMetaResultManagerImp;
import org.metasee.database.service.impl.UploadFileManagerImpl;
import org.metasee.database.service.impl.UserManagerImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ParallelMetaResultAction extends SuperClass{
	private static final long serialVersionUID = 1L;
	private int parallelMetaResultId;
	private int complete;
	private String viewSource;
	private UploadFile uploadFile;
	private int uploadFileId;
	private String type;
	private String format;
	private String length;
	private String database;
	private String evalue;
	private String phylogeneticanalysis;
	private String domainsample;
	private String comment;
	private String name;
	private String message;
	private PermissionAction permissionAction = new PermissionAction();
	
	private String checkcode;
	private ParallelMetaResult parallelMetaResult=new ParallelMetaResult();
	private ParallelMetaResultManager parallelMetaResultManager=new ParallelMetaResultManagerImp();
	
	Map attibutes = ActionContext.getContext().getSession();
	
	public String addParallelMetaResult() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please log in!");
			return LOGIN;
		}
		UserManager userManager=new UserManagerImpl();
		User tempUser=userManager.getUserByUserId(tempId);
		if(null == tempUser){
			setMessage("Cannot find current user, please log in!");
			return LOGIN;
		}
		
		attibutes.remove("rand");
		parallelMetaResult.setComplete(0);
		parallelMetaResult.setComment(comment);
		UploadFileAction uploadFileAction=new UploadFileAction();
		UploadFile uploadFile=new UploadFile();
		uploadFile=new UploadFileManagerImpl().getUploadFileById(uploadFileId);
		parallelMetaResult.setUploadFile(uploadFile);
		parallelMetaResult.setType(type);
		parallelMetaResult.setFormat(format);
		parallelMetaResult.setLength(length);
		parallelMetaResult.setDatabase(database);
		parallelMetaResult.setEvalue(evalue);
		parallelMetaResult.setPhylogeneticanalysis(phylogeneticanalysis);
		parallelMetaResult.setName(name);
		parallelMetaResult.setDomainsample(domainsample);
		String checkExistsReturn=parallelMetaResultManager.checkExists(parallelMetaResult);
		if(null!=checkExistsReturn && checkExistsReturn.equals("exists")){
			setMessage("This Parallel-Meta result has existed");
			return "exists";
		}
		parallelMetaResultManager.addParallelMetaResult(parallelMetaResult);
		this.parallelMetaResultId = this.parallelMetaResult.getId();
		return SUCCESS;
	}
	
	public String removeParallelMetaResult() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.parallelMetaResult=parallelMetaResultManager.getParallelMetaResultById(parallelMetaResultId);
		if(tempId != this.parallelMetaResult.getUploadFile().getUploadProject().getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		parallelMetaResultManager.removeById(parallelMetaResultId);
		return SUCCESS;
	}
	
	public String getParallelMetaResultById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.parallelMetaResult=parallelMetaResultManager.getParallelMetaResultById(parallelMetaResultId);
		
		if(permissionAction.ifCouldAccess(parallelMetaResult.getUploadFile().getUploadProject().getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		this.parallelMetaResultId=parallelMetaResult.getId();
		return SUCCESS;
	}
	
	private String sampleURL;
	public String getSampleViewById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.parallelMetaResult=parallelMetaResultManager.getParallelMetaResultById(parallelMetaResultId);

		if(permissionAction.ifCouldAccess(parallelMetaResult.getUploadFile().getUploadProject().getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		this.setSampleURL(GlobalConstant.uploadDir+this.parallelMetaResult.getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName()+File.separator+this.parallelMetaResult.getUploadFile().getUploadProject().getRandomFileName()+File.separator+parallelMetaResult.getFoldername()+File.separator+"taxonomy.html");
		readViewSource(sampleURL);
		return SUCCESS;
	}
	
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

	public String updateCommentById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null == tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.parallelMetaResult=parallelMetaResultManager.getParallelMetaResultById(parallelMetaResultId);
		if(tempId != this.parallelMetaResult.getUploadFile().getUploadProject().getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		parallelMetaResultManager.updateCommentById(uploadFileId, comment);
		return SUCCESS;
	}
	
	
	public int getParallelMetaResultId() {
		return parallelMetaResultId;
	}

	public void setParallelMetaResultId(int parallelMetaResultId) {
		this.parallelMetaResultId = parallelMetaResultId;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public UploadFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getEvalue() {
		return evalue;
	}

	public void setEvalue(String evalue) {
		this.evalue = evalue;
	}

	

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public ParallelMetaResult getParallelMetaResult() {
		return parallelMetaResult;
	}

	public void setParallelMetaResult(ParallelMetaResult parallelMetaResult) {
		this.parallelMetaResult = parallelMetaResult;
	}

	public ParallelMetaResultManager getParallelMetaResultManager() {
		return parallelMetaResultManager;
	}

	public void setParallelMetaResultManager(
			ParallelMetaResultManager parallelMetaResultManager) {
		this.parallelMetaResultManager = parallelMetaResultManager;
	}

	public int getUploadFileId() {
		return uploadFileId;
	}

	public void setUploadFileId(int uploadFileId) {
		this.uploadFileId = uploadFileId;
	}

	public String getPhylogeneticanalysis() {
		return phylogeneticanalysis;
	}

	public void setPhylogeneticanalysis(String phylogeneticanalysis) {
		this.phylogeneticanalysis = phylogeneticanalysis;
	}

	public String getDomainsample() {
		return domainsample;
	}

	public void setDomainsample(String domainsample) {
		this.domainsample = domainsample;
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

	public PermissionAction getPermissionAction() {
		return permissionAction;
	}

	public void setPermissionAction(PermissionAction permissionAction) {
		this.permissionAction = permissionAction;
	}
	
}
