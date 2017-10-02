package org.metasee.database.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.commonUtil.runCommand.SampleMetaStormsRunCommand;
import org.metasee.database.model.MetaDataSample;
import org.metasee.database.service.MetaDataSampleManager;
import org.metasee.database.service.impl.MetaDataSampleManagerImpl;

public class SampleMetaStormsAction extends SuperClass {
	private String uuid;
	String readContent;
	public String getReadContent() {
		return readContent;
	}

	public void setReadContent(String readContent) {
		this.readContent = readContent;
	}

	private int id;
	private String displayInformation;
	
	public String getDisplayInformation() {
		return displayInformation;
	}

	public void setDisplayInformation(String displayInformation) {
		this.displayInformation = displayInformation;
	}

	//private String database;
	private int hitNumber;
	private String exhaustiveSearch;
	private String database;
	
	private boolean ifDone;
	private String querySample;
	
	public String getQuerySample() {
		return querySample;
	}

	public void setQuerySample(String querySample) {
		this.querySample = querySample;
	}

	public boolean isIfDone() {
		return ifDone;
	}

	public void setIfDone(boolean ifDone) {
		this.ifDone = ifDone;
	}

	private String sourceDatabase;
	private String sourceAcc;
	private String sourceId;
	
	private MetaDataSampleManager metaDataSampleManager = new MetaDataSampleManagerImpl();	
	
	private void getSample() throws Exception {
		MetaDataSample metaDataSample = metaDataSampleManager.getMetaDataSampleById(id);
		this.sourceDatabase = metaDataSample.getDatabase_source();
		this.sourceAcc = metaDataSample.getMetagenome();
		this.sourceId = metaDataSample.getMetaData().getSourceId();
	}
	
	public String runMetaStorms() throws Exception{
		this.getSample();
		SampleMetaStormsRunCommand sampleMetaStormsRunCommand = new SampleMetaStormsRunCommand(this);
		sampleMetaStormsRunCommand.start();
		return SUCCESS;
	}
	
	public String getSmapleMetaStormsResult() throws Exception{
		ifDone = false;
		this.getSample();
		querySample = sourceDatabase + "_" + sourceAcc;
		String fileName = GlobalConstant.sampleMetaStormsTemp + uuid + File.separator + GlobalConstant.METASTORMS;
		File file=new File(fileName);
		FileReader in = null;
		StringBuffer stringbuffer= new StringBuffer();
		try {
			in = new FileReader(file);
			BufferedReader inTwo=new BufferedReader(in);
			StringBuffer stringbuffermatch= new StringBuffer();
			String s=null;
			
			Pattern idp=Pattern.compile("Match (\\d+)");
			Pattern metaidp=Pattern.compile("Sample path: .*?/([_\\.\\w]+)/([_\\.\\w]+)/([\\._\\w-]+)/parallel-meta$");
			Pattern scorep=Pattern.compile("Similarity: (.+)");
			Pattern runedCommand=Pattern.compile("metaStomrsCommand: .*?/parallelmetaresult/([_\\.\\w]+)/([_\\.\\w]+)/([_\\.\\w]+)/parallel-meta/classification.txt");
			
			while((s=inTwo.readLine())!=null){
				Matcher idm =idp.matcher(s);
				Matcher metaidm=metaidp.matcher(s);
				Matcher scorem=scorep.matcher(s);
				Matcher runedCommandm=runedCommand.matcher(s);
				byte bb[]=s.getBytes();
				if(idm.find()){
					stringbuffermatch.append("<td>"+idm.group(1)+"</td>");
				}
				if(scorem.find()){
					stringbuffermatch.append("<td>"+scorem.group(1)+"</td>");
				}
				if(metaidm.find()){
					String metaMeshAcc = metaidm.group(1) + "_" + metaidm.group(3);
					stringbuffermatch.append("<td><a href=\"metasample/?acc=" + metaMeshAcc + "\" target=\"_blank\">" + metaMeshAcc + "</a></td>");
					stringbuffer.append("<tr>"+stringbuffermatch+"</tr>");
					stringbuffermatch=new StringBuffer();
				}
				if(runedCommandm.find()){
					ifDone = true;
					querySample = runedCommandm.group(1) + "_" + runedCommandm.group(3);
				}
			}
		} catch (FileNotFoundException e) {
			
		}catch(IOException e){
			
		}
		readContent=new String("<table style=\"width:700px; margin-left:20px;\" border=\"1\" align=\"center\" cellspacing=\"1\" cellpadding=\"3\"><tr><td>No.</td><td>Score</td><td>ACC</td></tr>"+stringbuffer+"</table>");
		if(readContent.equals("<table style=\"width:700px; margin-left:20px;\" border=\"1\" align=\"center\" cellspacing=\"1\" cellpadding=\"3\"><tr><td>No.</td><td>Score</td><td>ACC</td></tr></table>")){
			readContent=new String("<h3>Sorry, no similar record was found.</h3>");
		}
		return SUCCESS;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getSourceDatabase() {
		return sourceDatabase;
	}

	public void setSourceDatabase(String sourceDatabase) {
		this.sourceDatabase = sourceDatabase;
	}

	public String getSourceAcc() {
		return sourceAcc;
	}

	public void setSourceAcc(String sourceAcc) {
		this.sourceAcc = sourceAcc;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public MetaDataSampleManager getMetaDataSampleManager() {
		return metaDataSampleManager;
	}

	public void setMetaDataSampleManager(MetaDataSampleManager metaDataSampleManager) {
		this.metaDataSampleManager = metaDataSampleManager;
	}
}
