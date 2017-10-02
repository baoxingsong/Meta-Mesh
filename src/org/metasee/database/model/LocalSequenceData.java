package org.metasee.database.model;

public class LocalSequenceData {
	private int id;
	private String localAddress;
	private MetaData metaData;
	
	
	public LocalSequenceData() {

	}
	public LocalSequenceData(String localAddress) {
		this.localAddress = localAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}
	public MetaData getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	@Override
	public String toString() {
		return localAddress;
	}
	
	
	
	
}
