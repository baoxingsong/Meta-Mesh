package org.metasee.database.action;

import org.metasee.database.service.MetaDataSampleManager;
import org.metasee.database.service.impl.MetaDataSampleManagerImpl;
import org.metasee.database.model.MetaDataSample;


public class SampleViewAction extends SuperClass{
	private int id;
	private MetaDataSampleManager metaDataSampleManager = new MetaDataSampleManagerImpl();
	private String sourceDatabase;
	private String sourceAcc;
	private String sourceId;
	private MetaDataSample metaDataSample;
	private String sourceCode;
	
	private void getSample() throws Exception {
		metaDataSample = metaDataSampleManager.getMetaDataSampleById(id);
		this.sourceDatabase = metaDataSample.getDatabase_source();
		this.sourceAcc = metaDataSample.getMetagenome();
		this.sourceId = metaDataSample.getMetaData().getSourceId();
	}
	


	public String view() throws Exception{
		this.getSample();
		GetURLSourceCode uRLSourceCode = new GetURLSourceCode();
		String URL = "http://ftp.database.metasee.org/" + sourceDatabase + "/" + sourceId + "/" + sourceAcc + "/parallel-meta/taxonomy.html";
		System.out.println(URL);
		uRLSourceCode.setSourceURL(URL);
		uRLSourceCode.javaGetSourceCode();
		sourceCode = uRLSourceCode.getSourceCode();
		return SUCCESS;
	}
	
	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MetaDataSampleManager getMetaDataSampleManager() {
		return metaDataSampleManager;
	}
	public void setMetaDataSampleManager(MetaDataSampleManager metaDataSampleManager) {
		this.metaDataSampleManager = metaDataSampleManager;
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

	public MetaDataSample getMetaDataSample() {
		return metaDataSample;
	}

	public void setMetaDataSample(MetaDataSample metaDataSample) {
		this.metaDataSample = metaDataSample;
	}
}
