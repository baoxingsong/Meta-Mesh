package org.metasee.database.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParallelMetaCompareResult {
	private int id;
	private Date createTime;
	private int songChecked;
	private int complete;
	private int error;
	private String comment;
	
	private Set<ParallelMetaResult> parallelMetaResults=new HashSet<ParallelMetaResult>();
	
	private WorkShop workShop;
	
	private String frontFaceName;
	
	
	public String getFrontFaceName() {
		List<Integer>idList = null;
		idList = new ArrayList<Integer>();
		for (ParallelMetaResult parallelMetaResult : parallelMetaResults){
			idList.add(parallelMetaResult.getId());
		}
		Collections.sort(idList);
		return idList.toString();
	}

	public void setFrontFaceName(String frontFaceName) {
		this.frontFaceName = frontFaceName;
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

	public Set<ParallelMetaResult> getParallelMetaResults() {
		return parallelMetaResults;
	}

	public void setParallelMetaResults(Set<ParallelMetaResult> parallelMetaResults) {
		this.parallelMetaResults = parallelMetaResults;
	}

	public ParallelMetaCompareResult() {
		super();
	}

	public ParallelMetaCompareResult(Set<ParallelMetaResult> parallelMetaResults) {
		super();
		this.parallelMetaResults = parallelMetaResults;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((parallelMetaResults == null) ? 0 : parallelMetaResults
						.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "ParallelMetaCompareResult [parallelMetaResults="
				+ parallelMetaResults + "]";
	}
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public WorkShop getWorkShop() {
		return workShop;
	}

	public void setWorkShop(WorkShop workShop) {
		this.workShop = workShop;
	}
}