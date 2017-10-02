package org.metasee.database.model;

public class MetaDatainformationSourcecode {
	private int id;
	private String metadatainformationsourcecode;
	private MetaData metaData;
	
	public MetaDatainformationSourcecode(int id, String metadatainformationsourcecode) {
		this.id = id;
		this.metadatainformationsourcecode = metadatainformationsourcecode;
	}
	
	public MetaDatainformationSourcecode(String metadatainformationsourcecode) {
		this.metadatainformationsourcecode = metadatainformationsourcecode;
	}
	
	public MetaDatainformationSourcecode() {
		
	}

	public MetaDatainformationSourcecode(int id,
			String metadatainformationsourcecode, MetaData metaData) {
	
		this.id = id;
		this.metadatainformationsourcecode = metadatainformationsourcecode;
		this.metaData = metaData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMetadatainformationsourcecode() {
		return metadatainformationsourcecode;
	}

	public void setMetadatainformationsourcecode(
			String metadatainformationsourcecode) {
		this.metadatainformationsourcecode = metadatainformationsourcecode;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	

	
}
