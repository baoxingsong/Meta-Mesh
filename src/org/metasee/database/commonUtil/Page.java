package org.metasee.database.commonUtil;

import java.util.List;


public class Page {
	private int totalCount;
	private List list;
	
	public Page() {
	}
	public Page(int totalCount, List list) {
		this.totalCount = totalCount;
		this.list = list;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
	
}
