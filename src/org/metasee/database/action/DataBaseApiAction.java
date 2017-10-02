package org.metasee.database.action;

import org.dom4j.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.metasee.database.model.MetaData;
import org.metasee.database.model.MetaDataSample;
import org.metasee.database.service.MetaDataManager;
import org.metasee.database.service.MetaDataSampleManager;
import org.metasee.database.service.impl.MetaDataManagerImpl;
import org.metasee.database.service.impl.MetaDataSampleManagerImpl;

public class DataBaseApiAction extends SuperClass {
	String xmlResult;
	StringBuffer xmlResultStringBuffer;
	private List<MetaData> metaDatas=new ArrayList<MetaData>();
	private MetaData metaData;
	private MetaDataManager metaDataManager = new MetaDataManagerImpl();
	private MetaDataSampleManager metaDataSampleManager = new MetaDataSampleManagerImpl();
	private String keyword;
	private int[] projectId;
	private int[] sampleId;
	private String[] acc; 
	
	public String projectSearch()throws Exception{
		this.metaDatas=(List<MetaData>)this.metaDataManager.apiGetMetaDataSearch(keyword).getList();
		this.makeProjectXml();
		return SUCCESS;
	}
	
	public String projectList()throws Exception{
		this.metaDatas=(List<MetaData>)this.metaDataManager.apiGetMetaDataList().getList();
		this.makeProjectXml();
		return SUCCESS;
	}
	
	public String projects()throws Exception{
		metaDatas=new ArrayList<MetaData>();
		for(int i : projectId){
			this.metaData = this.metaDataManager.getMetaDataById(i);
			metaDatas.add(metaData);
		}
		this.makeProjectXml();
		return SUCCESS;
	}
	
	public String samplesByAcc()throws Exception{
		xmlResultStringBuffer = new StringBuffer();
		xmlResultStringBuffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<metamesh>\n");
		for(String accs : acc){
			
			Pattern pattern = Pattern.compile("(\\S+?)_(\\S+)");
			Matcher matcher = pattern.matcher(accs);
			String database_source;
			String metagenome;
			if(matcher.find()){
				MetaDataSample metaDataSample = metaDataSampleManager.getMetaDataSampleByAcc(accs);
				database_source=matcher.group(1);
				metagenome=matcher.group(2);
				xmlResultStringBuffer.append(this.sampelXML(database_source, metagenome, metaDataSample.getMetaData().getSourceId(), metaDataSample.getId()));
			}
		}
		xmlResultStringBuffer.append("</metamesh>\n");
		xmlResult = xmlResultStringBuffer.toString();
		return SUCCESS;
	}
	
	public String samplesById()throws Exception{
		xmlResultStringBuffer = new StringBuffer();
		xmlResultStringBuffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<metamesh>\n");
		for(int i : sampleId){
			MetaDataSample metaDataSample = metaDataSampleManager.getMetaDataSampleById(i);
			xmlResultStringBuffer.append(this.sampelXML(metaDataSample.getDatabase_source(), metaDataSample.getMetagenome(), metaDataSample.getMetaData().getSourceId(), metaDataSample.getId()));
		}
		xmlResultStringBuffer.append("</metamesh>\n");
		xmlResult = xmlResultStringBuffer.toString();
		return SUCCESS;
	}
	
	private String sampelXML(String database_source, String metagenome, String metadataId, Integer sampleId){
		GetURLSourceCode getURLSourceCode = new GetURLSourceCode();
		System.out.println("http://ftp.database.metasee.org/" + database_source + "/" + metadataId + "/" + metagenome + ".xml");
		getURLSourceCode.setSourceURL("http://ftp.database.metasee.org/" + database_source + "/" + metadataId + "/" + metagenome + ".xml");
		getURLSourceCode.javaGetSourceCode();
		String uRLsourceCode = getURLSourceCode.getSourceCode();
		uRLsourceCode = uRLsourceCode.replaceAll("<metamesh>\n", "");
		uRLsourceCode = uRLsourceCode.replaceAll("</metamesh>\n", "");
		uRLsourceCode = uRLsourceCode.replaceAll("<\\?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"\\?>\n", "");
		uRLsourceCode = "<Sample>\n" + "<MetaMeshAcc>" + database_source + "_" + metagenome + "</MetaMeshAcc>" + "\t<SampleId>" + sampleId + "</SampleId>\n" + uRLsourceCode + "</Sample>\n";
		return uRLsourceCode;
	}

	private void makeProjectXml() {
		Document document = org.dom4j.DocumentHelper.createDocument();
		org.dom4j.Element rootRequestElement = document.addElement("MetagenomeProjects");
		if(metaDatas.size()>0){
			for(MetaData i : metaDatas){
				Element projectElement = rootRequestElement.addElement("MetagenomeProject");
				
				Element projectID = projectElement.addElement("ProjectID");
				projectID.addText(i.getId().toString());
				
				Element projectName = projectElement.addElement("ProjectName");
				projectName.addText(i.getProjectName());
				
				Element projectDiscription = projectElement.addElement("ProjectDiscription");
				projectDiscription.addText(i.getDescription());
				
				if(i.getMetaDataSample().size()>0){
					Element SamplesElement = projectElement.addElement("MetagenomeSamples");
					for(MetaDataSample j : i.getMetaDataSample()){
						Element SampleElement = SamplesElement.addElement("MetagenomeSample");
						
						Element SampleID = SampleElement.addElement("SampleID");
						SampleID.addText(j.getId().toString());
						
						Element SampleAcc = SampleElement.addElement("SampleAcc");
						SampleAcc.addText(j.getDatabase_source() + "_" + j.getMetagenome());
					}
				}
			}
		}
		this.xmlResult = document.asXML();
		System.out.println("document.toString();document.toString();document.toString();" + xmlResult);		
	}

	public String getXmlResult() {
		return xmlResult;
	}
	public void setXmlResult(String xmlResult) {
		this.xmlResult = xmlResult;
	}


	public StringBuffer getXmlResultStringBuffer() {
		return xmlResultStringBuffer;
	}


	public void setXmlResultStringBuffer(StringBuffer xmlResultStringBuffer) {
		this.xmlResultStringBuffer = xmlResultStringBuffer;
	}


	public List<MetaData> getMetaDatas() {
		return metaDatas;
	}


	public void setMetaDatas(List<MetaData> metaDatas) {
		this.metaDatas = metaDatas;
	}


	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
	}


	public void setMetaDataManager(MetaDataManager metaDataManager) {
		this.metaDataManager = metaDataManager;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	public int[] getProjectId() {
		return projectId;
	}

	public void setProjectId(int[] projectId) {
		this.projectId = projectId;
	}

	public MetaDataSampleManager getMetaDataSampleManager() {
		return metaDataSampleManager;
	}

	public void setMetaDataSampleManager(MetaDataSampleManager metaDataSampleManager) {
		this.metaDataSampleManager = metaDataSampleManager;
	}

	public int[] getSampleId() {
		return sampleId;
	}

	public void setSampleId(int[] sampleId) {
		this.sampleId = sampleId;
	}

	public String[] getAcc() {
		return acc;
	}

	public void setAcc(String[] acc) {
		this.acc = acc;
	}
}
