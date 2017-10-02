package org.metasee.database.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkShop {
	private int id;
	private String name;
	private User owner;
	private Set<WorkGroup> workGroups = new HashSet<WorkGroup>();
	private Set<UploadProject> uploadProjects;
	private Set<ParallelMetaCompareResult> parallelMetaCompareResults;
	private Set<MetaStormsCompareResult> metaStormsCompareResults;
	private List<Integer> workgroupids;
	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Set<WorkGroup> getWorkGroups() {
		return workGroups;
	}
	public void setWorkGroups(Set<WorkGroup> workGroups) {
		this.workGroups = workGroups;
	}
	public Set<UploadProject> getUploadProjects() {
		return uploadProjects;
	}
	public void setUploadProjects(Set<UploadProject> uploadProjects) {
		this.uploadProjects = uploadProjects;
	}
	public Set<ParallelMetaCompareResult> getParallelMetaCompareResults() {
		return parallelMetaCompareResults;
	}
	public void setParallelMetaCompareResults(
			Set<ParallelMetaCompareResult> parallelMetaCompareResults) {
		this.parallelMetaCompareResults = parallelMetaCompareResults;
	}
	public Set<MetaStormsCompareResult> getMetaStormsCompareResults() {
		return metaStormsCompareResults;
	}
	public void setMetaStormsCompareResults(
			Set<MetaStormsCompareResult> metaStormsCompareResults) {
		this.metaStormsCompareResults = metaStormsCompareResults;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getWorkgroupids() {
		return workgroupids;
	}
	public void setWorkgroupids(List<Integer> workgroupids) {
		this.workgroupids = workgroupids;
	}
	
}
