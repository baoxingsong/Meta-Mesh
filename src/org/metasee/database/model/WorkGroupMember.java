package org.metasee.database.model;

public class WorkGroupMember {
	public static final int INVITATION = 1;
	public static final int APPLICATION = 2;
	public static final int BEAMEMBER = 3;
	
	private int id;
	private User user;
	private WorkGroup workGroup;
	private int state;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public WorkGroup getWorkGroup() {
		return workGroup;
	}
	public void setWorkGroup(WorkGroup workGroup) {
		this.workGroup = workGroup;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
