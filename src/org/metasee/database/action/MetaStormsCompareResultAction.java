package org.metasee.database.action;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.metasee.database.model.MetaStormsCompareResult;
import org.metasee.database.model.ParallelMetaCompareResult;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkShop;
import org.metasee.database.service.MetaStormsCompareResultManager;
import org.metasee.database.service.ParallelMetaCompareResultManager;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.impl.MetaStormsCompareResultManagerImpl;
import org.metasee.database.service.impl.ParallelMetaCompareResultManagerImpl;
import org.metasee.database.service.impl.ParallelMetaResultManagerImp;
import org.metasee.database.service.impl.UserManagerImpl;
import org.metasee.database.service.impl.WorkShopManagerImpl;
import org.metasee.database.service.ParallelMetaResultManager;

import org.metasee.database.commonUtil.constant.GlobalConstant;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MetaStormsCompareResultAction extends SuperClass{
	private static final long serialVersionUID = 1L;
	private int id;
	private int complete;
	private String comment;
	
	private String message;
	
	private int[] parallelMetaResultIds;

	private String checkcode;
	private MetaStormsCompareResult metaStormsCompareResult=new MetaStormsCompareResult();
	private MetaStormsCompareResultManager metaStormsCompareResultManager=new MetaStormsCompareResultManagerImpl();
	private ParallelMetaResultManager parallelMetaResultManager=new ParallelMetaResultManagerImp();
	Map attibutes = ActionContext.getContext().getSession();
	private String resultAddress;
	private String displayInformation;
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
	PermissionAction permissionAction = new PermissionAction();
	private int workShopId;
	public String addMetaStormsCompareResult() throws Exception{
		/*
		if(! ((String)attibutes.get("rand")).equalsIgnoreCase(checkcode)){
			setMessage("Wrong check code! Please check it.");
			attibutes.remove("rand");
			System.out.println(message);
			return INPUT;
		}
		attibutes.remove("rand");
		*/
		if(permissionAction.ifLoginEd()){
		}else{
			setMessage("Please Log in!");
			return LOGIN;
		}
		System.out.println("00000000000000000000");
		Integer tempId=(Integer)attibutes.get("userid");
		System.out.println("111111111111111111");
		UserManager userManager=new UserManagerImpl();
		System.out.println("222222222222222222");
		User tempUser=userManager.getUserByUserId(tempId);
		System.out.println("333333333333333333");
		if(null == tempUser){
			setMessage("Cannot find current user, please Log in!");
			return LOGIN;
		}
		System.out.println("4444444444444444444");
		System.out.println("workShop workShop " + workShopId + " " + workShopId);
		WorkShop workShop = (new WorkShopManagerImpl()).getWorkShopById(workShopId);
		System.out.println("workShop workShop " + workShop.getId() + workShop.getName());
		System.out.println("5555555555555555555");
		metaStormsCompareResult.setWorkShop(workShop);
		System.out.println("66666666666666666666");
		for(int parallelMetaResultIdList:parallelMetaResultIds){
			System.out.println("666666666666666" + parallelMetaResultIdList);
			metaStormsCompareResult.getParallelMetaResults().add(parallelMetaResultManager.getParallelMetaResultById(parallelMetaResultIdList));
		}
		System.out.println("7777777777777777777");
		metaStormsCompareResultManager.addMetaStormsCompareResult(metaStormsCompareResult);
		return SUCCESS;
	}

	
	public String removeMetaStormsCompareResult() throws Exception{
		if(permissionAction.ifLoginEd()){
		}else{
			setMessage("Please Log in!");
			return LOGIN;
		}
		Integer tempId=(Integer)attibutes.get("userid");
		this.metaStormsCompareResult=metaStormsCompareResultManager.getMetaStormsCompareResultById(id);
		if(null == metaStormsCompareResult){
			return SUCCESS;
		}
		if(tempId != this.metaStormsCompareResult.getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		metaStormsCompareResultManager.removeById(id);
		return SUCCESS;
	}
	
	public String getMetaStormsCompareResultById() throws Exception{
		if(permissionAction.ifLoginEd()){
		}else{
			setMessage("Please Log in!");
			return LOGIN;
		}
		Integer tempId=(Integer)attibutes.get("userid");
		this.metaStormsCompareResult = metaStormsCompareResultManager.getMetaStormsCompareResultById(id);
		if(permissionAction.ifCouldAccess(metaStormsCompareResult.getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		return SUCCESS;
	}
	public String viewMetaStormsCompareResultById() throws Exception{
		if(permissionAction.ifLoginEd()){
		}else{
			setMessage("Please Log in!");
			return LOGIN;
		}
		Integer tempId=(Integer)attibutes.get("userid");
		this.metaStormsCompareResult = metaStormsCompareResultManager.getMetaStormsCompareResultById(id);
		if(permissionAction.ifCouldAccess(metaStormsCompareResult.getWorkShop()).equals(permissionAction.UNAUTHORIZATION)){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		StringBuffer displayInformationStringBuffer = new StringBuffer();
		String outpath = GlobalConstant.uploadDir + metaStormsCompareResult.getWorkShop().getOwner().getUserName() + File.separator + GlobalConstant.METASTORMSCOMPARE + File.separator + metaStormsCompareResult.getId() + File.separator;
		displayInformationStringBuffer.append(this.metastormsCompareReportToHtml(outpath));
		displayInformation=displayInformationStringBuffer.toString();
		return SUCCESS;
	}
	private String metastormsCompareReportToHtml(String path) throws Exception{
		StringBuffer toBeHtmlStringBuffer = new StringBuffer();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path + "list.text")));
		String line;
		int lineCount= 0;
		List<ParallelMetaPath> parallelMetaPaths = new ArrayList<ParallelMetaPath>();
		while ((line = br.readLine()) != null) {
			if(!"".equals(line) && !" ".equals(line) && !"	".equals(line)){
				lineCount ++;
				parallelMetaPaths.add(new ParallelMetaPath(line,lineCount));
			}
		}
		
		br=new BufferedReader(new InputStreamReader(new FileInputStream(path + "metastormscompare.txt")));
		lineCount= 0;
		List<CompareScoreArray> compareScoreArrays = new ArrayList<CompareScoreArray>();
		while ((line = br.readLine()) != null) {
			if(!"".equals(line) && !" ".equals(line) && !"	".equals(line)){
				lineCount ++;
				compareScoreArrays.add(new CompareScoreArray(line));
			}
		}
		toBeHtmlStringBuffer.append("<h5>Legend:</h5>");
		for(ParallelMetaPath p : parallelMetaPaths){
			toBeHtmlStringBuffer.append("<div>" + p.getName() + "</div>");
		}
		toBeHtmlStringBuffer.append("<div>&nbsp;</div><h5>Score:</h5>");
		
		for(int i=0;i<compareScoreArrays.size();i++){
			for(int j=i;j<compareScoreArrays.size();j++){
				toBeHtmlStringBuffer.append("<div><strong>" + (i+1) + " " + (j+1) + ":</strong> " + compareScoreArrays.get(i).getScores().get(j) + "</div>");
			}
		}
		
		return toBeHtmlStringBuffer.toString();
	}
	private class ParallelMetaPath{
		private String name;
		private String path;
		private int number;
		public ParallelMetaPath(String path, int number){
			this.path = path;
			this.number = number;
		}
		public int getNumber(){
			return this.number;
		}
		public String getName() {
			name = path.replaceAll("/home/songbaoxing/Workspaces/MyEclipse/Mesh/WebRoot/upload/username/", "");
			name = name.replaceAll("/classification.txt", "");
			name = name.replaceAll("/"," >> ");
			return "<strong>" + number + ":</strong> " + name;
		}
	}
	private class CompareScoreArray{
		private String scoreLine;
		public CompareScoreArray(String scoreLin){
			this.scoreLine = scoreLin;
		}
		public List<Double> getScores(){
			List<Double> scores = new ArrayList<Double>();
			String[] scoresStrings = scoreLine.split("	");
			for(String s : scoresStrings){
				if(null!=s && !"".equals(s) && !" ".equals(s) && !"	".equals(s)){
					scores.add(Double.parseDouble(s));
				}
			}
			return scores;
		}
	}
	
	public String updateCommentById() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null == tempId || 0 == tempId){
			setMessage("Please Log in!");
			return LOGIN;
		}
		this.metaStormsCompareResult=metaStormsCompareResultManager.getMetaStormsCompareResultById(id);
		if(tempId != this.metaStormsCompareResult.getWorkShop().getOwner().getId()){
			setMessage("You are not permitted to access this data.");
			return "not permit";
		}
		metaStormsCompareResultManager.updateCommentById(id, comment);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public MetaStormsCompareResult getMetaStormsCompareResult() {
		return metaStormsCompareResult;
	}

	public void setMetaStormsCompareResult(
			MetaStormsCompareResult metaStormsCompareResult) {
		this.metaStormsCompareResult = metaStormsCompareResult;
	}

	public MetaStormsCompareResultManager getMetaStormsCompareResultManager() {
		return metaStormsCompareResultManager;
	}

	public void setMetaStormsCompareResultManager(
			MetaStormsCompareResultManager metaStormsCompareResultManager) {
		this.metaStormsCompareResultManager = metaStormsCompareResultManager;
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

	public String getDisplayInformation() {
		return displayInformation;
	}

	public void setDisplayInformation(String displayInformation) {
		this.displayInformation = displayInformation;
	}

	public PermissionAction getPermissionAction() {
		return permissionAction;
	}

	public void setPermissionAction(PermissionAction permissionAction) {
		this.permissionAction = permissionAction;
	}

	public int getWorkShopId() {
		return workShopId;
	}

	public void setWorkShopId(int workShopId) {
		this.workShopId = workShopId;
	}

}
