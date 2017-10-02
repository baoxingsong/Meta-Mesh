package org.metasee.database.model;

public class GoogleMapMetaDataSample {
	private Integer id;
	private Double longitude;
	private Double latitude;
	private String metagenome;
	private String database_source;
	private Integer project_id;
	private int songChecked;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getMetagenome() {
		return metagenome;
	}
	public void setMetagenome(String metagenome) {
		this.metagenome = metagenome;
	}
	public String getDatabase_source() {
		return database_source;
	}
	public void setDatabase_source(String database_source) {
		this.database_source = database_source;
	}
	public Integer getProject_id() {
		return project_id;
	}
	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}
	public int getSongChecked() {
		return songChecked;
	}
	public void setSongChecked(int songChecked) {
		this.songChecked = songChecked;
	}
}
