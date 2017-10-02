package org.metasee.database.action;

import java.util.Map;

import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkShop;
import org.metasee.database.service.WorkGroupManager;
import org.metasee.database.service.WorkShopManager;
import org.metasee.database.service.impl.UserManagerImpl;
import org.metasee.database.service.impl.WorkGroupManagerImpl;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.impl.WorkShopManagerImpl;

import com.opensymphony.xwork2.ActionContext;

public class WorkGroupAction extends SuperClass {
	private String name;
	private int id;
	private WorkGroup workGroup;
	private WorkGroupManager workGroupManager = new WorkGroupManagerImpl();
	private PermissionAction permissionAction = new PermissionAction();
	private User user;
	private String inveiteMessage;
	private String message;
	private UserManager userManager = new UserManagerImpl();
	Map attibutes = ActionContext.getContext().getSession();
	
	public String addWorkGroupInput(){
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		return SUCCESS;
	}
	public String addWorkGroup() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		Integer tempId=(Integer)attibutes.get("userid");
		user = userManager.getUserByUserId(tempId);
		workGroup = new WorkGroup();
		workGroup.setName(name);
		workGroup.setOwner(user);
		workGroupManager.save(workGroup);
		return SUCCESS;
	}
	public String getWorkGroupById() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		this.workGroup = workGroupManager.getWorkGroupById(id);
		return permissionAction.ifCouldAccess(this.workGroup);
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public WorkGroup getWorkGroup() {
		return workGroup;
	}
	public void setWorkGroup(WorkGroup workGroup) {
		this.workGroup = workGroup;
	}
	public WorkGroupManager getWorkGroupManager() {
		return workGroupManager;
	}
	public void setWorkGroupManager(WorkGroupManager workGroupManager) {
		this.workGroupManager = workGroupManager;
	}
	public PermissionAction getPermissionAction() {
		return permissionAction;
	}
	public void setPermissionAction(PermissionAction permissionAction) {
		this.permissionAction = permissionAction;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public Map getAttibutes() {
		return attibutes;
	}
	public void setAttibutes(Map attibutes) {
		this.attibutes = attibutes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getInveiteMessage() {
		return inveiteMessage;
	}
	public void setInveiteMessage(String inveiteMessage) {
		this.inveiteMessage = inveiteMessage;
	}	
}
