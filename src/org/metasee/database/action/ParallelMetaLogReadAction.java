package org.metasee.database.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.metasee.database.commonUtil.constant.*;
import org.metasee.database.model.ParallelMetaResult;
import org.metasee.database.service.ParallelMetaResultManager;
import org.metasee.database.service.impl.ParallelMetaResultManagerImp;

import com.opensymphony.xwork2.ActionContext;

public class ParallelMetaLogReadAction extends SuperClass {
	private String fileName;
	private BufferedReader br;
	private String source = "";
	private String projectName;
	private String parallelName;
	private String userName;
	private ParallelMetaResult parallelMetaResult;
	private ParallelMetaResultManager parallelMetaResultManager=new ParallelMetaResultManagerImp();
	private String id;
	private PermissionAction permissionAction = new PermissionAction();
	private void read(){
		try {
			String line;
			StringBuffer sb = new StringBuffer();
			br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			while((line=br.readLine())!=null){
				sb.append(line);
				sb.append("\n\r");
			}
			source = sb.toString();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			source = "This task is queuing and waitting for running.";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getSourceCode() throws Exception, Exception{
		if(permissionAction.ifLoginEd()){
		}else{
			return LOGIN;
		}
		parallelMetaResult = parallelMetaResultManager.getParallelMetaResultById(Integer.parseInt(id));
		Map attibutes = ActionContext.getContext().getSession();
		Integer tempId=(Integer)attibutes.get("userid");

		if(permissionAction.ifCouldAccess(parallelMetaResult.getUploadFile().getUploadProject().getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			return "not permit";
		}
		this.setFileName(GlobalConstant.uploadDir + parallelMetaResult.getUploadFile().getUploadProject().getWorkShop().getOwner().getUserName() + File.separator +  parallelMetaResult.getUploadFile().getUploadProject().getRandomFileName() + File.separator +  parallelMetaResult.getFoldername() + File.separator + "log");
		this.read();
		return SUCCESS;
	}
	
	public static void main(String[] args) throws Exception{
		ParallelMetaLogReadAction parallelMetaLogReadAction = new ParallelMetaLogReadAction();
		parallelMetaLogReadAction.setId("30");
		parallelMetaLogReadAction.getSourceCode();
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		
		this.fileName = fileName;
	}
	public BufferedReader getBr() {
		return br;
	}
	public void setBr(BufferedReader br) {
		this.br = br;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getParallelName() {
		return parallelName;
	}
	public void setParallelName(String parallelName) {
		this.parallelName = parallelName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
