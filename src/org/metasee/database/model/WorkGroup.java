package org.metasee.database.model;

import java.util.HashSet;
import java.util.Set;

public class WorkGroup {
	private int id;
	private String name;
	private User owner;
	private Set<WorkGroupMember> workGroupMembers;
	private Set<WorkShop> workShops = new HashSet<WorkShop>();

	public Set<WorkGroupMember> getWorkGroupMembers() {
		return workGroupMembers;
	}

	public void setWorkGroupMembers(Set<WorkGroupMember> workGroupMembers) {
		this.workGroupMembers = workGroupMembers;
	}

	public Set<WorkShop> getWorkShops() {
		return workShops;
	}

	public void setWorkShops(Set<WorkShop> workShops) {
		this.workShops = workShops;
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
		
}
