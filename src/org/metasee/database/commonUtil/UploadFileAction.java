package org.metasee.database.commonUtil;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.metasee.database.commonUtil.constant.*;
import org.metasee.database.model.UploadFile;
import org.metasee.database.model.UploadProject;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkShop;
import org.metasee.database.service.UploadFileManager;
import org.metasee.database.service.UploadProjectManager;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.WorkShopManager;
import org.metasee.database.service.impl.UploadFileManagerImpl;
import org.metasee.database.service.impl.UploadProjectManagerImpl;
import org.metasee.database.service.impl.UserManagerImpl;
import org.metasee.database.service.impl.WorkShopManagerImpl;
public class UploadFileAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private File fileInput;
	UploadFile uploadFIle=new UploadFile();
	private String  fileInputFileName;
	private String savePath;
	private String webROOT;
	private String userName;
	private String userPath;
	private String workShopName;
	private String projectName;
	
	private User user;
	private UserManager userManager = new UserManagerImpl();
	private UploadProject uploadProject = new UploadProject();
	private UploadFileManager uploadFileManager=new UploadFileManagerImpl();
	private UploadProjectManager uploadProjectManager=new UploadProjectManagerImpl();
	private WorkShop workShop = new WorkShop();
	private WorkShopManager workShopManager = new WorkShopManagerImpl();
	@SuppressWarnings("rawtypes")
	Map attibutes = ActionContext.getContext().getSession();
	
	public String execute() throws Exception {
		String newFileName = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String[] argus=this.getSavePath().split("___");
		System.out.println(this.getSavePath());
		this.setSavePath(argus[0]);
		System.out.println("savePath: " + savePath);
		this.setUserName(argus[1]);
		System.out.println("userName: " + userName);
		workShopName = argus[2];
		System.out.println("workShopName: " + workShopName);
		if(argus.length>3){
			projectName = argus[3];
			System.out.println("projectName: " + projectName);
		}
		workShop = workShopManager.getWorkShopByNamAndUserName(workShopName, userName);
		System.out.println("workShop " + workShop + "workShop.getName()" + workShop.getName());
		this.setUserPath(GlobalConstant.uploadDir+userName+File.separator);		
		File file = new File(userPath);
		if (!file.exists()) {
			file.mkdir();
		}
		if(null == projectName || "" == projectName){
		}else{
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
			savePath = projectName;
		}
		uploadProject.setRandomFileName(savePath);
		this.setSavePath(userPath+savePath+File.separator);
		file = new File(savePath);
		if (!file.exists()) {
			file.mkdir();
			uploadProject.setWorkShop(workShop);
			uploadProjectManager.add(uploadProject);
		}else{
			System.out.println("bbbbbbbbbbbbbbbbbb");
			uploadProject = uploadProjectManager.getUploadProjectByRandomFileName(projectName);
			System.out.println("cccccccccccccccccccc");
			System.out.println(uploadProject.getRandomFileName());
		}		
		System.out.println("000000000000");
		newFileName = this.getFileInputFileName();
		System.out.println("1111111111");
		file = new File(savePath + File.separator + newFileName);
		System.out.println("00022222222222222");
		uploadFIle.setFileName(newFileName);
		System.out.println("11122222222222222");
		uploadFIle.setUploadProject(uploadProject);
		System.out.println("22222222222222");
		uploadFIle.setSongChecked(1);
		System.out.println("33322222222222222");
		uploadFIle.setComplete(1);
		System.out.println("44422222222222222");
		uploadFileManager.saveUploadFile(uploadFIle);
		System.out.println("55522222222222222");
		fileInput.renameTo(file);
		System.out.println("3333333333333");
		Runtime r=Runtime.getRuntime();
		String changeTo777 = "chmod 777 " + file.getAbsolutePath();
		System.out.println("changeTo777: " + changeTo777);
		Process p=r.exec(changeTo777); 
		System.out.println("finalpath" + file.getAbsolutePath());
		response.getWriter().print("<font color='red'>Hello world!</font>");
		return null;
	}
	public File getFileInput() {
		return fileInput;
	}
	public void setFileInput(File fileInput) {
		this.fileInput = fileInput;
	}
	public String getFileInputFileName() {
		return fileInputFileName;
	}
	public void setFileInputFileName(String fileInputFileName) {
		this.fileInputFileName = fileInputFileName;
	}
	public String getSavePath() {
		return this.savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getWebROOT() {
		return webROOT;
	}
	public void setWebROOT(String webROOT) {
		this.webROOT = webROOT;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPath() {
		return userPath;
	}
	public void setUserPath(String userPath) {
		this.userPath = userPath;
	}
	public UploadFile getUploadFIle() {
		return uploadFIle;
	}
	public void setUploadFIle(UploadFile uploadFIle) {
		this.uploadFIle = uploadFIle;
	}
	public String getWorkShopName() {
		return workShopName;
	}
	public void setWorkShopName(String workShopName) {
		this.workShopName = workShopName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public UploadProject getUploadProject() {
		return uploadProject;
	}
	public void setUploadProject(UploadProject uploadProject) {
		this.uploadProject = uploadProject;
	}
	public UploadFileManager getUploadFileManager() {
		return uploadFileManager;
	}
	public void setUploadFileManager(UploadFileManager uploadFileManager) {
		this.uploadFileManager = uploadFileManager;
	}
	public UploadProjectManager getUploadProjectManager() {
		return uploadProjectManager;
	}
	public void setUploadProjectManager(UploadProjectManager uploadProjectManager) {
		this.uploadProjectManager = uploadProjectManager;
	}
	public WorkShop getWorkShop() {
		return workShop;
	}
	public void setWorkShop(WorkShop workShop) {
		this.workShop = workShop;
	}
	public WorkShopManager getWorkShopManager() {
		return workShopManager;
	}
	public void setWorkShopManager(WorkShopManager workShopManager) {
		this.workShopManager = workShopManager;
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
}
