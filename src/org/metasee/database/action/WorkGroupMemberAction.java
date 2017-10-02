package org.metasee.database.action;

import java.util.Map;

import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkGroupMember;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.WorkGroupMemberManager;
import org.metasee.database.service.WorkGroupManager;
import org.metasee.database.service.impl.UserManagerImpl;
import org.metasee.database.service.impl.WorkGroupManagerImpl;
import org.metasee.database.service.impl.WorkGroupMemberManagerImpl;

import com.opensymphony.xwork2.ActionContext;

public class WorkGroupMemberAction extends SuperClass {
	private int id;
	private WorkGroupMemberManager workGroupMemberManager = new WorkGroupMemberManagerImpl();
	private WorkGroupMember workGroupMember;
	private WorkGroup workGroup;
	private WorkGroupManager workGroupManager = new WorkGroupManagerImpl(); 
	private UserManager userManager = new UserManagerImpl();
	private PermissionAction permissionAction = new PermissionAction();
	private String message;
	private int workGroupId;
	private String username;
	private String name;
	private String mailbox;
	private String inveiteMessage;
	private String checkcode;
	Map attibutes = ActionContext.getContext().getSession();
	
	public String deleteWorkGroupMember() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		workGroupMember = workGroupMemberManager.getByid(id);
		workGroup = workGroupMember.getWorkGroup();
		workGroupId = workGroup.getId();
		if(! permissionAction.ifCouldAccess(this.workGroup).equals(permissionAction.OWNER)){
			setMessage("Your are not the owner of this Work Shop, and can not delete members!");
			return permissionAction.ifCouldAccess(this.workGroup);
		}
		workGroupMemberManager.deleteById(id);
		return SUCCESS;
	}
	
	public String workGroupInvite() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		if(! ((String)attibutes.get("rand")).equalsIgnoreCase(checkcode)){
			setMessage("Wrong check code, please try again.");
			setInveiteMessage("Wrong check code, please try again.");
			attibutes.remove("rand");
			return INPUT;
		}
		workGroup = workGroupManager.getWorkGroupById(workGroupId);
		if(! permissionAction.ifCouldAccess(this.workGroup).equals(permissionAction.OWNER)){
			setMessage("Your are not the owner of this Work Group and can not invite members!");
			setInveiteMessage("Your are not the owner of this Work Group and can not invite members!");
			return permissionAction.ifCouldAccess(this.workGroup);
		}
		User user = (new UserManagerImpl()).getUserByUserName(username);
		if(null == user){
			setInveiteMessage("We can not find a user with your input infotmation, please check it!");
			return NONE;
		}
		if(!(user.getMailBox().equals(mailbox))){
			setInveiteMessage("We can not find a user with your input infotmation, please check it!");
			return NONE;
		}
		workGroupMember = workGroupMemberManager.getByUserAndWorkGroup(user, workGroup);
		if(null!=workGroupMember){
			setInveiteMessage("There has such a member in this Work Group.");
			return "exist";
		}
		if(workGroup.getOwner().getId() == user.getId()){
			setInveiteMessage("You are the owner of this Work Group and cannot invite yourself to join this work group.");
			return "exist";
		}
		workGroupMember = new WorkGroupMember();
		workGroupMember.setUser(user);
		workGroupMember.setWorkGroup(workGroup);
		workGroupMember.setState(workGroupMember.INVITATION);
		workGroupMemberManager.save(workGroupMember);
		setInveiteMessage("Invitation success.");
		return SUCCESS;
	}
	public String applyJoinWorkGroupInput(){
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		return SUCCESS;
	}
	public String applyJoinWorkGroup() throws Exception{
		if(! ((String)attibutes.get("rand")).equalsIgnoreCase(checkcode)){
			setMessage("Wrong check code, please try again.");
			attibutes.remove("rand");
			return INPUT;
		}
		User user = userManager.getUserByUserName(username);
		if(null == user){
			setMessage("Don't exists such a Work Group, please check it.");
			return INPUT;
		}
		workGroup = workGroupManager.getWorkGroupNameAndUser(name, user);
		if(null == workGroup){
			setMessage("Don't exists such a Work Group, please check it.");
			return INPUT;
		}
		user = userManager.getUserByUserName((String)attibutes.get("username"));
		if(null == workGroup){
			setMessage("There are something wrong, please try again.");
			return INPUT;
		}
		workGroupMember = workGroupMemberManager.getByUserAndWorkGroup(user, workGroup);
		if(null!=workGroupMember){
			setMessage("You are already a member of this group, please check it.");
			return INPUT;
		}
		if(user.getUserName().equals(workGroup.getOwner().getUserName())){
			setMessage("You are already a member of this group, please check it.");
			return INPUT;
		}
		workGroupMember = new WorkGroupMember();
		workGroupMember.setUser(user);
		workGroupMember.setWorkGroup(workGroup);
		workGroupMember.setState(workGroupMember.APPLICATION);
		workGroupMemberManager.save(workGroupMember);
		setMessage("Application Success");
		return SUCCESS;
	}
	
	
	public String acceptApplication() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		workGroupMember = workGroupMemberManager.getByid(id);
		workGroup = workGroupMember.getWorkGroup();
		workGroupId = workGroup.getId();
		if(! permissionAction.ifCouldAccess(this.workGroup).equals(permissionAction.OWNER)){
			setMessage("Your are not the owner of this Work Shop, and could not approve applications!");
			return permissionAction.ifCouldAccess(this.workGroup);
		}
		workGroupMember.setState(workGroupMember.BEAMEMBER);
		workGroupMemberManager.updateWorkGroupMember(workGroupMember);		
		return SUCCESS;
	}
	public String acceptInvite() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		workGroupMember = workGroupMemberManager.getByid(id);
		if(null == workGroupMember){
			return NONE;
		}
		if(workGroupMember.getState() != workGroupMember.INVITATION){
			return "already";
		}
		Integer tempId=(Integer)attibutes.get("userid");
		if(tempId != workGroupMember.getUser().getId()){
			return INPUT;
		}
		workGroupMember.setState(workGroupMember.BEAMEMBER);
		workGroupMemberManager.updateWorkGroupMember(workGroupMember);		
		return SUCCESS;
	}
	public String signout() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		workGroupMember = workGroupMemberManager.getByid(id);
		if(null == workGroupMember){
			return NONE;
		}
		Integer tempId=(Integer)attibutes.get("userid");
		if(tempId != workGroupMember.getUser().getId()){
			return INPUT;
		}
		workGroupMemberManager.deleteById(id);		
		return SUCCESS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public WorkGroupMember getWorkGroupMember() {
		return workGroupMember;
	}

	public void setWorkGroupMember(WorkGroupMember workGroupMember) {
		this.workGroupMember = workGroupMember;
	}

	public WorkGroup getWorkGroup() {
		return workGroup;
	}

	public void setWorkGroup(WorkGroup workGroup) {
		this.workGroup = workGroup;
	}

	public PermissionAction getPermissionAction() {
		return permissionAction;
	}

	public void setPermissionAction(PermissionAction permissionAction) {
		this.permissionAction = permissionAction;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public WorkGroupMemberManager getWorkGroupMemberManager() {
		return workGroupMemberManager;
	}

	public void setWorkGroupMemberManager(
			WorkGroupMemberManager workGroupMemberManager) {
		this.workGroupMemberManager = workGroupMemberManager;
	}

	public int getWorkGroupId() {
		return workGroupId;
	}

	public void setWorkGroupId(int workGroupId) {
		this.workGroupId = workGroupId;
	}

	public WorkGroupManager getWorkGroupManager() {
		return workGroupManager;
	}

	public void setWorkGroupManager(WorkGroupManager workGroupManager) {
		this.workGroupManager = workGroupManager;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getInveiteMessage() {
		return inveiteMessage;
	}

	public void setInveiteMessage(String inveiteMessage) {
		this.inveiteMessage = inveiteMessage;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public Map getAttibutes() {
		return attibutes;
	}

	public void setAttibutes(Map attibutes) {
		this.attibutes = attibutes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
