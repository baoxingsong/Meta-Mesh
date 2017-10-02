package org.metasee.database.model;

import java.util.Set;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private String mailBox;
	private int songChecked;
	private Set<WorkGroupMember> workGroupMembers;
	private Set<WorkShop> workShops;
	private Set<WorkGroup> workGroups;
	private String homedir;
	
	private String newPassword;

	private String randomString;
	public int getId() {
		return id;
	}
	public String getRandomString() {
		return randomString;
	}
	public void setRandomString(String randomString) {
		this.randomString = randomString;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getMailBox() {
		return mailBox;
	}
	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}
	public int getSongChecked() {
		return songChecked;
	}
	public void setSongChecked(int songChecked) {
		this.songChecked = songChecked;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getHomedir() {
		return homedir;
	}
	public void setHomedir(String homedir) {
		this.homedir = homedir;
	}
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
	public Set<WorkGroup> getWorkGroups() {
		return workGroups;
	}
	public void setWorkGroups(Set<WorkGroup> workGroups) {
		this.workGroups = workGroups;
	}
}
