package org.metasee.database.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MetaData {
	private static final long serialVersionUID = 48L;

	private Integer id;
	
	private String projectName;
	
	private String description;
	
	private String databaseSource;
	
	private String sourceURL;
	
	private String sourceId;
	
	private String metaDiscription;
	
	private String contactInformation;
	
	private String sequenceingPlatform;
	
	private String databaseSourceURL;
	
	private Date createTime;
	
	private MetaDataSourcecodeOfOriginalPage sourcecodeOfOriginalPage;
	
	private MetaDatainformationSourcecode metaDiscriptionSourceCode;
	
	private Set<LocalSequenceData> localSequenceData=new HashSet<LocalSequenceData>();
	
	private Set<MetaDataSample> metaDataSample=new HashSet<MetaDataSample>();
	
	private int songChecked;
	
	public  MetaData(){
		
	}

	public MetaData(Integer id, String projectName, String description,
			String databaseSource, String sourceURL, String sourceId,
			String metaDiscription, String contactInformation,
			String sequenceingPlatform, String databaseSourceURL,
			MetaDataSourcecodeOfOriginalPage sourcecodeOfOriginalPage,
			MetaDatainformationSourcecode metaDiscriptionSourceCode) {
		this.id = id;
		this.projectName = projectName;
		this.description = description;
		this.databaseSource = databaseSource;
		this.sourceURL = sourceURL;
		this.sourceId = sourceId;
		this.metaDiscription = metaDiscription;
		this.contactInformation = contactInformation;
		this.sequenceingPlatform = sequenceingPlatform;
		this.databaseSourceURL = databaseSourceURL;
		this.sourcecodeOfOriginalPage = sourcecodeOfOriginalPage;
		this.metaDiscriptionSourceCode = metaDiscriptionSourceCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public MetaDataSourcecodeOfOriginalPage getSourcecodeOfOriginalPage() {
		return sourcecodeOfOriginalPage;
	}

	public void setSourcecodeOfOriginalPage(
			MetaDataSourcecodeOfOriginalPage sourcecodeOfOriginalPage) {
		this.sourcecodeOfOriginalPage = sourcecodeOfOriginalPage;
	}

	public MetaDatainformationSourcecode getMetaDiscriptionSourceCode() {
		return metaDiscriptionSourceCode;
	}

	public void setMetaDiscriptionSourceCode(
			MetaDatainformationSourcecode metaDiscriptionSourceCode) {
		this.metaDiscriptionSourceCode = metaDiscriptionSourceCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<LocalSequenceData> getLocalSequenceData() {
		return localSequenceData;
	}

	public void setLocalSequenceData(Set<LocalSequenceData> localSequenceData) {
		this.localSequenceData = localSequenceData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result
				+ ((sourceURL == null) ? 0 : sourceURL.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetaData other = (MetaData) obj;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (sourceURL == null) {
			if (other.sourceURL != null)
				return false;
		} else if (!sourceURL.equals(other.sourceURL))
			return false;
		return true;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set<MetaDataSample> getMetaDataSample() {
		return metaDataSample;
	}

	public void setMetaDataSample(Set<MetaDataSample> metaDataSample) {
		this.metaDataSample = metaDataSample;
	}

	public int getSongChecked() {
		return songChecked;
	}

	public void setSongChecked(int songChecked) {
		this.songChecked = songChecked;
	}
}
