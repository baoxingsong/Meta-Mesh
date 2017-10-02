package org.metasee.database.model;

public class MetaDataSourcecodeOfOriginalPage {
	private int id;
	private String sourcecodeOfOriginalPage;
	private MetaData metaData;
	
	public MetaDataSourcecodeOfOriginalPage(int id, String sourcecodeOfOriginalPage) {
		this.id = id;
		this.sourcecodeOfOriginalPage = sourcecodeOfOriginalPage;
	}
	
	public MetaDataSourcecodeOfOriginalPage(String sourcecodeOfOriginalPage) {
		this.sourcecodeOfOriginalPage = sourcecodeOfOriginalPage;
	}
	
	public MetaDataSourcecodeOfOriginalPage() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSourcecodeOfOriginalPage() {
		return sourcecodeOfOriginalPage;
	}

	public void setSourcecodeOfOriginalPage(String sourcecodeOfOriginalPage) {
		this.sourcecodeOfOriginalPage = sourcecodeOfOriginalPage;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	
}
