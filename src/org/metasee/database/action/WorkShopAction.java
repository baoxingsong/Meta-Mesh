package org.metasee.database.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkGroupMember;
import org.metasee.database.model.WorkShop;
import org.metasee.database.service.WorkGroupManager;
import org.metasee.database.service.WorkShopManager;
import org.metasee.database.service.impl.UserManagerImpl;
import org.metasee.database.service.impl.WorkGroupManagerImpl;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.impl.WorkShopManagerImpl;
import org.metasee.database.util.HibernateUtil;

import com.opensymphony.xwork2.ActionContext;

public class WorkShopAction extends SuperClass {
	private String name;
	private int id;
	private WorkShop workShop;
	private WorkShopManager workShopManager = new WorkShopManagerImpl();
	private WorkGroupManager workGroupManager = new WorkGroupManagerImpl();
	private PermissionAction permissionAction = new PermissionAction();
	private User user;
	private UserManager userManager = new UserManagerImpl();
	Map attibutes = ActionContext.getContext().getSession();
	private List<WorkGroup> shareedByWorkGroups = new ArrayList<WorkGroup>();
	private List<WorkGroup> unShareedByWorkGroups = new ArrayList<WorkGroup>();
	private String message;
	private List<Integer> workgroupids;
	
	public String addWorkShopInput(){
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		return SUCCESS;
	}
	public String addWorkShop() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		Integer tempId=(Integer)attibutes.get("userid");
		user = userManager.getUserByUserId(tempId);
		workShop = new WorkShop();
		workShop.setName(name);
		workShop.setOwner(user);
		workShopManager.save(workShop);
		return SUCCESS;
	}
	public String getWorkShopById() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		this.workShop = workShopManager.getWorkShopById(id);
		this.findSharedWorkGroups();
		return permissionAction.ifCouldAccess(this.workShop);
	}	
	private void findSharedWorkGroups() {
		for(WorkGroup eachWorkGroup : workShop.getOwner().getWorkGroups()){
			if(workShop.getWorkGroups().contains(eachWorkGroup)){
				shareedByWorkGroups.add(eachWorkGroup);
			}else{
				unShareedByWorkGroups.add(eachWorkGroup);
			}
		}
		for(WorkGroupMember eachWorkGroupMember : workShop.getOwner().getWorkGroupMembers()){
			if(eachWorkGroupMember.getState() == eachWorkGroupMember.BEAMEMBER){
				if(workShop.getWorkGroups().contains(eachWorkGroupMember.getWorkGroup())){
					shareedByWorkGroups.add(eachWorkGroupMember.getWorkGroup());
				}else{
					unShareedByWorkGroups.add(eachWorkGroupMember.getWorkGroup());
				}			
			}
		}		
	}
	
	public String shareWorkShop() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		this.workShop = workShopManager.getWorkShopById(id);
		this.findSharedWorkGroups();
		if(! permissionAction.ifCouldAccess(this.workShop).equals(permissionAction.OWNER)){
			setMessage("Your are not the owner of this Work Shop, and can not share it!");
			return permissionAction.ifCouldAccess(this.workShop);
		}
		for(int i : workgroupids){
			workShop.getWorkGroups().add(workGroupManager.getWorkGroupById(i));
		}
		workShopManager.update(workShop);
		return SUCCESS;
	}
	
	public String unShareWorkShop() throws Exception{
		if(!permissionAction.ifLoginEd()){
			return LOGIN;
		}
		this.workShop = workShopManager.getWorkShopById(id);
		this.findSharedWorkGroups();
		if(! permissionAction.ifCouldAccess(this.workShop).equals(permissionAction.OWNER)){
			setMessage("Your are not the owner of this Work Shop, and can not share it!");
			return permissionAction.ifCouldAccess(this.workShop);
		}
		for(int i : workgroupids){
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.getCurrentSession();
			s.beginTransaction();
			List<WorkGroup> workGroups=(List<WorkGroup>)s.createQuery("from WorkGroup workGroup where workGroup.id="+i).list();
			WorkGroup workGroupi = new WorkGroup();
			if(workGroups.size()>0){
				workGroupi = workGroups.get(0);
			}
			List<WorkShop> workShops=(List<WorkShop>)s.createQuery("from WorkShop workShop where workShop.id="+id).list();
			WorkShop workShopi =  new WorkShop();
			if(workShops.size()>0){
				workShopi = workShops.get(0);
			}
			workShopi.getWorkGroups().remove(workGroupi);
			workGroupi.getWorkShops().remove(workShopi);
			s.update(workShopi);
			s.update(workGroupi);
			s.getTransaction().commit();
		}
		return SUCCESS;
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
	public void setWorkShop(WorkShop workShop) {
		this.workShop = workShop;
	}
	public WorkShopManager getWorkShopManager() {
		return workShopManager;
	}
	public void setWorkShopManager(WorkShopManager workShopManager) {
		this.workShopManager = workShopManager;
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
	public WorkShop getWorkShop() {
		return workShop;
	}
	public List<WorkGroup> getShareedByWorkGroups() {
		return shareedByWorkGroups;
	}
	public void setShareedByWorkGroups(List<WorkGroup> shareedByWorkGroups) {
		this.shareedByWorkGroups = shareedByWorkGroups;
	}
	public List<WorkGroup> getUnShareedByWorkGroups() {
		return unShareedByWorkGroups;
	}
	public void setUnShareedByWorkGroups(List<WorkGroup> unShareedByWorkGroups) {
		this.unShareedByWorkGroups = unShareedByWorkGroups;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Integer> getWorkgroupids() {
		return workgroupids;
	}
	public void setWorkgroupids(List<Integer> workgroupids) {
		this.workgroupids = workgroupids;
	}
}
