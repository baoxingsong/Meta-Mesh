package org.metasee.database.action;

import java.util.Map;

import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkGroupMember;
import org.metasee.database.model.WorkShop;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.impl.UserManagerImpl;

import com.opensymphony.xwork2.ActionContext;

public class PermissionAction extends SuperClass {
	public String OWNER = "owner";
	public String MEMBER = "member";
	public String UNAUTHORIZATION = "unauthorization";
	private User user;
	private UserManager userManager = new UserManagerImpl();
	Map attibutes = ActionContext.getContext().getSession();
	public boolean ifLoginEd(){
		Map attibutes = ActionContext.getContext().getSession();
		if( null == attibutes.get("username") || ((String)attibutes.get("username")).equals("") ){
			return false;
		}
		return true;
	}
	
	public String ifCouldAccess(WorkShop workShop) throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		user = userManager.getUserByUserId(tempId);
		if(workShop.getOwner().getId() == tempId){
			return OWNER;
		}
		for(WorkGroup workGroup : workShop.getWorkGroups()){
			for(WorkGroupMember workGroupMember : workGroup.getWorkGroupMembers()){
				if(workGroupMember.getUser().getId() == tempId){
					return MEMBER;
				}
			}
		}
		return UNAUTHORIZATION;
	}
	public String ifCouldAccess(WorkGroup workGroup) throws Exception {
		Integer tempId=(Integer)attibutes.get("userid");
		user = userManager.getUserByUserId(tempId);
		if(workGroup.getOwner().getId() == tempId){
			return OWNER;
		}
		for(WorkGroupMember workGroupMember : workGroup.getWorkGroupMembers()){
			if(workGroupMember.getUser().getId() == tempId && (workGroupMember.getState() == workGroupMember.BEAMEMBER)){
				return MEMBER;
			}
		}
		return UNAUTHORIZATION;
	}

	public String getOWNER() {
		return OWNER;
	}

	public void setOWNER(String oWNER) {
		OWNER = oWNER;
	}

	public String getMEMBER() {
		return MEMBER;
	}

	public void setMEMBER(String mEMBER) {
		MEMBER = mEMBER;
	}

	public String getUNAUTHORIZATION() {
		return UNAUTHORIZATION;
	}

	public void setUNAUTHORIZATION(String uNAUTHORIZATION) {
		UNAUTHORIZATION = uNAUTHORIZATION;
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

	
}
