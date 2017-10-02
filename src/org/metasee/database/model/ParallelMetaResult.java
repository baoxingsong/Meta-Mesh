package org.metasee.database.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ParallelMetaResult {
	private int id;
	private Date createTime;
	private int songChecked;
	private int complete;
	private int start;
	private int error;
	private UploadFile uploadFile;
	private String type;
	private String format;
	private String length;
	private String database;
	private String evalue;
	private String phylogeneticanalysis;
	private String domainsample;
	private String comment;
	private String name;
	private Set<MetaStormsResult> metaStormsResults=new HashSet<MetaStormsResult>();
	private Set<ParallelMetaCompareResult> parallelMetaCompareResults=new HashSet<ParallelMetaCompareResult>();
	private Set<MetaStormsCompareResult> metaStormsCompareResults = new HashSet<MetaStormsCompareResult>();
	private String toStringName;
	private String foldername;
	
	
	public String getFoldername() {
		return "parallelmeta" + this.getUploadFile().getFileName() + type + format + length + database + evalue + phylogeneticanalysis;
	}

	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}

	@Override
	public String toString() {
		return "type=" + type + ", format="
				+ format + ", length=" + length + ", database=" + database
				+ ", evalue=" + evalue + ", phylogeneticanalysis="
				+ phylogeneticanalysis;
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
	public UploadFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getEvalue() {
		return evalue;
	}
	public void setEvalue(String evalue) {
		this.evalue = evalue;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPhylogeneticanalysis() {
		return phylogeneticanalysis;
	}

	public void setPhylogeneticanalysis(String phylogeneticanalysis) {
		this.phylogeneticanalysis = phylogeneticanalysis;
	}

	public Set<MetaStormsResult> getMetaStormsResults() {
		return metaStormsResults;
	}

	public void setMetaStormsResults(Set<MetaStormsResult> metaStormsResults) {
		this.metaStormsResults = metaStormsResults;
	}

	public Set<ParallelMetaCompareResult> getParallelMetaCompareResults() {
		return parallelMetaCompareResults;
	}

	public void setParallelMetaCompareResults(
			Set<ParallelMetaCompareResult> parallelMetaCompareResults) {
		this.parallelMetaCompareResults = parallelMetaCompareResults;
	}

	public String getToStringName() {
		return this.toString();
	}

	public void setToStringName(String toStringName) {
		this.toStringName = toStringName;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getDomainsample() {
		return domainsample;
	}

	public void setDomainsample(String domainsample) {
		this.domainsample = domainsample;
	}

	public Set<MetaStormsCompareResult> getMetaStormsCompareResults() {
		return metaStormsCompareResults;
	}

	public void setMetaStormsCompareResults(
			Set<MetaStormsCompareResult> metaStormsCompareResults) {
		this.metaStormsCompareResults = metaStormsCompareResults;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	
	
}