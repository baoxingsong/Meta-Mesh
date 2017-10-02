package org.metasee.database.action;

import java.util.ArrayList;
import java.util.List;

import org.metasee.database.model.MetaData;
import org.metasee.database.model.MetaDataSourcecodeOfOriginalPage;
import org.metasee.database.model.MetaDatainformationSourcecode;
import org.metasee.database.model.News;
import org.metasee.database.service.MetaDataManager;
import org.metasee.database.service.impl.MetaDataManagerImpl;
import org.metasee.database.commonUtil.Page;

import com.opensymphony.xwork2.ActionSupport;

public class DatabaseAction extends SuperClass{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> localsequencedata;
	
	/**
	 * for detail information page
	 * */	
	MetaData metaData;
	private List<MetaData> metaDatas=new ArrayList<MetaData>();
	private int id;
	/**
	 * keyword for reseach
	 * */
	private String keyword;
	/**
	 * page for paging, page is the current page number
	 * */
	int page=1;
	/**
	 * recordPerPage for paging, every page has recordPerPage records
	 * */
	int recordPerPage=20;
	/**
	 * totalCount for paging, there would be totalCount records qualified
	 * */
	int totalCount;
	private String projectName;
	private String description;
	private String databaseSource;
	private String sourceURL;
	private String sourceId;
	private String metaDiscription;
	private String contactInformation;
	private String sequenceingPlatform;
	private String databaseSourceURL;
	private String sourcecodeOfOriginalPage;
	private String metaDiscriptionSourceCode;
	private String acc;
	private MetaDataManager metaDataManager = new MetaDataManagerImpl();
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String add()throws Exception{
		MetaData metaData=new MetaData();
		metaData.setProjectName(projectName);
		metaData.setDescription(description);
		metaData.setDatabaseSource(databaseSource);
		metaData.setSourceURL(sourceURL);
		metaData.setSourceId(sourceId);
		metaData.setMetaDiscription(metaDiscription);
		metaData.setContactInformation(contactInformation);
		metaData.setSequenceingPlatform(sequenceingPlatform);
		metaData.setDatabaseSourceURL(databaseSourceURL);
		metaData.setSourcecodeOfOriginalPage(new MetaDataSourcecodeOfOriginalPage(sourcecodeOfOriginalPage));
		metaData.setMetaDiscriptionSourceCode(new MetaDatainformationSourcecode(metaDiscriptionSourceCode));
		this.setWebPageTitle("metagenomic project add");
		if (metaDataManager.checkMetaDataWithProjectNameAndSourceURL(metaData)){
			return "failexists";
		}
		metaDataManager.add(metaData,localsequencedata);
		return SUCCESS;
	}
	
	public String list()throws Exception{
		this.setWebPageTitle("metagenomic sample browse");
		this.metaDatas=(List <MetaData>)this.metaDataManager.getMetaDatas(page, recordPerPage).getList();
		this.totalCount=this.metaDataManager.getMetaDatas(page, recordPerPage).getTotalCount();
		return SUCCESS;
	}
	
	public String metadatadetailinformation()throws Exception{
		String idString=this.id + "";
		if("".equals(idString) || "0".equals(idString) || null==idString){
			this.metaData=this.metaDataManager.getMetaDataByAcc(acc);
		}else{
			this.metaData=this.metaDataManager.getMetaDataById(id);
		}
		this.setWebPageTitle("metagenomic project detail information");
		return SUCCESS;
	}
	
	public String search()throws Exception{
		this.metaDatas=(List<MetaData>)this.metaDataManager.getMetaDataSearch(keyword,page, recordPerPage).getList();
		this.totalCount=this.metaDataManager.getMetaDataSearch(keyword, page, recordPerPage).getTotalCount();
		this.setWebPageTitle("search result " + getKeyword());
		return SUCCESS;
	}
	
	public String deleteById() throws Exception{
		metaDataManager.deleteById(id);
		this.setWebPageTitle("detele project " + getId());
		return SUCCESS;
	}
	
	public String update() throws Exception{
		MetaData metaData=new MetaData();
		metaData.setProjectName(projectName);
		metaData.setDescription(description);
		metaData.setDatabaseSource(databaseSource);
		metaData.setSourceURL(sourceURL);
		metaData.setSourceId(sourceId);
		metaData.setMetaDiscription(metaDiscription);
		metaData.setContactInformation(contactInformation);
		metaData.setSequenceingPlatform(sequenceingPlatform);
		metaData.setDatabaseSourceURL(databaseSourceURL);
		metaData.setId(id);
		metaDataManager.update(metaData);
		this.setWebPageTitle("modify metagehnomnic project information");
		return SUCCESS;
	}
	
	public String updateinput()throws Exception{
		this.metaData=this.metaDataManager.getMetaDataById(id);
		this.setWebPageTitle("modify metagehnomnic project information");
		return SUCCESS;
	}
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public MetaDataManager getUm() {
		return metaDataManager;
	}
	public void setUm(MetaDataManager metaDataManager) {
		this.metaDataManager = metaDataManager;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDatabaseSource() {
		return databaseSource;
	}
	public void setDatabaseSource(String databaseSource) {
		this.databaseSource = databaseSource;
	}
	public String getSourceURL() {
		return sourceURL;
	}
	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getMetaDiscription() {
		return metaDiscription;
	}
	public void setMetaDiscription(String metaDiscription) {
		this.metaDiscription = metaDiscription;
	}
	public String getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
	public String getSequenceingPlatform() {
		return sequenceingPlatform;
	}
	public void setSequenceingPlatform(String sequenceingPlatform) {
		this.sequenceingPlatform = sequenceingPlatform;
	}
	public String getDatabaseSourceURL() {
		return databaseSourceURL;
	}
	public void setDatabaseSourceURL(String databaseSourceURL) {
		this.databaseSourceURL = databaseSourceURL;
	}
	public String getSourcecodeOfOriginalPage() {
		return sourcecodeOfOriginalPage;
	}
	public void setSourcecodeOfOriginalPage(String sourcecodeOfOriginalPage) {
		this.sourcecodeOfOriginalPage = sourcecodeOfOriginalPage;
	}
	public String getMetaDiscriptionSourceCode() {
		return metaDiscriptionSourceCode;
	}
	public void setMetaDiscriptionSourceCode(String metaDiscriptionSourceCode) {
		this.metaDiscriptionSourceCode = metaDiscriptionSourceCode;
	}
	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
	}
	public void setMetaDataManager(MetaDataManager metaDataManager) {
		this.metaDataManager = metaDataManager;
	}
	public List<MetaData> getMetaDatas() {
		return metaDatas;
	}
	public void setMetaDatas(List<MetaData> metaDatas) {
		this.metaDatas = metaDatas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MetaData getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public ArrayList<String> getLocalsequencedata() {
		return localsequencedata;
	}
	public void setLocalsequencedata(ArrayList<String> localsequencedata) {
		this.localsequencedata = localsequencedata;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
}