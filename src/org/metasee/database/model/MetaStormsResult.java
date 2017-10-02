package org.metasee.database.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MetaStormsResult {
	private int id;
	private Date createTime;
	private int songChecked;
	private int complete;
	private int error;
	
	private String comment;
	
	private ParallelMetaResult parallelMetaResult=new ParallelMetaResult();
	
	private String database;
	private int hitNumber;
	private String exhaustiveSearch;
	private String assignGroupNumber;
	
	private Set<MetaStormMatch> metaStormMatch=new HashSet<MetaStormMatch>();
	
	private String displayTableInformation;
	
	private String toStringName;
	public String getToStringName() {
		return this.toString();
	}

	public void setToStringName(String toStringName) {
		this.toStringName = toStringName;
	}
	
	
	public MetaStormsResult(Date createTime, int songChecked, int complete,
			ParallelMetaResult parallelMetaResult, String database,
			int hitNumber, String exhaustiveSearch, String assignGroupNumber) {
		super();
		this.createTime = createTime;
		this.songChecked = songChecked;
		this.complete = complete;
		this.parallelMetaResult = parallelMetaResult;
		this.database = database;
		this.hitNumber = hitNumber;
		this.exhaustiveSearch = exhaustiveSearch;
		this.assignGroupNumber = assignGroupNumber;
	}
	
	public MetaStormsResult() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getSongChecked() {
		return songChecked;
	}
	public void setSongChecked(int songChecked) {
		this.songChecked = songChecked;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public ParallelMetaResult getParallelMetaResult() {
		return parallelMetaResult;
	}
	public void setParallelMetaResult(ParallelMetaResult parallelMetaResult) {
		this.parallelMetaResult = parallelMetaResult;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
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
	public String getAssignGroupNumber() {
		return assignGroupNumber;
	}
	public void setAssignGroupNumber(String assignGroupNumber) {
		this.assignGroupNumber = assignGroupNumber;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((assignGroupNumber == null) ? 0 : assignGroupNumber
						.hashCode());
		result = prime * result
				+ ((database == null) ? 0 : database.hashCode());
		result = prime * result + error;
		result = prime
				* result
				+ ((exhaustiveSearch == null) ? 0 : exhaustiveSearch.hashCode());
		result = prime * result + hitNumber;
		result = prime
				* result
				+ ((parallelMetaResult == null) ? 0 : parallelMetaResult
						.hashCode());
		result = prime * result + songChecked;
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
		MetaStormsResult other = (MetaStormsResult) obj;
		if (assignGroupNumber == null) {
			if (other.assignGroupNumber != null)
				return false;
		} else if (!assignGroupNumber.equals(other.assignGroupNumber))
			return false;
		if (database == null) {
			if (other.database != null)
				return false;
		} else if (!database.equals(other.database))
			return false;
		if (error != other.error)
			return false;
		if (exhaustiveSearch == null) {
			if (other.exhaustiveSearch != null)
				return false;
		} else if (!exhaustiveSearch.equals(other.exhaustiveSearch))
			return false;
		if (hitNumber != other.hitNumber)
			return false;
		if (parallelMetaResult == null) {
			if (other.parallelMetaResult != null)
				return false;
		} else if (!parallelMetaResult.equals(other.parallelMetaResult))
			return false;
		if (songChecked != other.songChecked)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  "database=" + database + ", hitNumber=" + hitNumber
				+ ", exhaustiveSearch=" + exhaustiveSearch
				+ ", assignGroupNumber=" + assignGroupNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<MetaStormMatch> getMetaStormMatch() {
		return metaStormMatch;
	}

	public void setMetaStormMatch(Set<MetaStormMatch> metaStormMatch) {
		this.metaStormMatch = metaStormMatch;
	}

	public String getDisplayTableInformation() {
		return displayTableInformation;
	}

	public void setDisplayTableInformation(String displayTableInformation) {
		this.displayTableInformation = displayTableInformation;
	}
	
	
}