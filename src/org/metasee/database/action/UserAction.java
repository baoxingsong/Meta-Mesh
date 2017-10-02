package org.metasee.database.action;


import java.io.File;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.mail.EmailException;
import org.metasee.database.commonUtil.constant.GlobalConstant;
import org.metasee.database.commonUtil.mail.ActiveMailUtil;
import org.metasee.database.model.User;
import org.metasee.database.model.WorkGroup;
import org.metasee.database.model.WorkGroupMember;
import org.metasee.database.model.WorkShop;
import org.metasee.database.service.UserManager;
import org.metasee.database.service.WorkGroupManager;
import org.metasee.database.service.WorkGroupMemberManager;
import org.metasee.database.service.WorkShopManager;
import org.metasee.database.service.impl.UserManagerImpl;
import org.metasee.database.service.impl.WorkGroupManagerImpl;
import org.metasee.database.service.impl.WorkGroupMemberManagerImpl;
import org.metasee.database.service.impl.WorkShopManagerImpl;

import com.opensymphony.xwork2.ActionContext;

public class UserAction extends SuperClass{
	private static final long serialVersionUID = 1L;
	User user;
	private String username;
	private String password1;
	private String password2;
	private String mailbox;
	private String newPassword;
	private String randomString;
	private String checkcode;
	private int id;
	private UserManager userManager = new UserManagerImpl();
	private PermissionAction permissionAction = new PermissionAction();
	private String workShopProject;
	private String randomFilename;
	private String message;

	Map attibutes = ActionContext.getContext().getSession();
	
	private String sourceurl="user";
	
	@Override
	public String execute() throws Exception {
		if(permissionAction.ifLoginEd()){
			return "logedon";
		}
		return SUCCESS;
	}
	
	private void createUser(){
		user=new User();
		user.setMailBox(mailbox);
		user.setPassWord(password1);
		user.setUserName(username);
		user.setNewPassword(newPassword);
		user.setRandomString(randomString);
	}
	
	public void loginInCreatCookie(){
		attibutes.put("userid", user.getId());
		attibutes.put("username", user.getUserName());  
   	}
	
	public void loginOutDestroyCookie(){
		attibutes.remove("username"); 
		attibutes.remove("userid");
   }
	
	public String register() throws Exception{
		if(permissionAction.ifLoginEd()){
			return "logedon";
		}
		if(! ((String)attibutes.get("rand")).equalsIgnoreCase(checkcode)){
			setMessage("Wrong check code, please try again.");
			attibutes.remove("rand");
			return INPUT;
		}else if(userManager.chekcUserWithUserName(username).equals("exists")){
			setMessage("This use name have existed");
			return INPUT;
		}else if(userManager.chekcMailBoxWithUserName(mailbox).equals("exists")){
			setMessage("This mailbox have existed");
			return INPUT;
		}
		attibutes.remove("rand");
		randomString=UUID.randomUUID().toString();
		this.createUser();
		this.user.setHomedir(GlobalConstant.uploadDir + user.getUserName());
		userManager.add(user);
		this.creatDefaultWorkShop();
		this.joinPublicWorkGroup();
		attibutes.put("unactivedusername", user.getUserName());
		attibutes.put("unactivedmailbox", user.getMailBox());
		this.sendActiveEmail();
		return SUCCESS;
	}
	
	
	private void joinPublicWorkGroup() throws Exception{
		WorkGroupMember workGroupMember = new WorkGroupMember();
		workGroupMember.setUser(user);
		WorkGroupManager workGroupManager = new WorkGroupManagerImpl();
		WorkGroup workGroup = workGroupManager.getWorkGroupById(1);
		workGroupMember.setWorkGroup(workGroup);
		workGroupMember.setState(workGroupMember.BEAMEMBER);
		WorkGroupMemberManager workGroupMemberManager = new WorkGroupMemberManagerImpl();
		workGroupMemberManager.save(workGroupMember);
	}
	
	public String reSendActiveEmail() throws Exception{
		if(permissionAction.ifLoginEd()){
			return "logedon";
		}
		if(! ((String)attibutes.get("rand")).equalsIgnoreCase(checkcode)){
			setMessage("Wrong check code, please try again.");
			attibutes.remove("rand");
			return INPUT;
		}else if(userManager.chekcMailBoxWithUserName(mailbox).equals("none")){
			setMessage(mailbox + " does not exist, please check it.");
			return INPUT;
		}
		this.user = userManager.getUserByMailBox(mailbox);
		if(user.getSongChecked() == 1){
			return "activited";
		}
		this.sendActiveEmail();
		return SUCCESS;
	}
	
	public String findPassword() throws Exception{
		if(permissionAction.ifLoginEd()){
			return "logedon";
		}
		if(! ((String)attibutes.get("rand")).equalsIgnoreCase(checkcode)){
			setMessage("Wrong check code, please try again.");
			attibutes.remove("rand");
			return INPUT;
		}else if(userManager.chekcMailBoxWithUserName(mailbox).equals("none")){
			setMessage(mailbox + " does not exist, please check it.");
			return INPUT;
		}
		this.user = userManager.getUserByMailBox(mailbox);
		this.sendFindPasswordEmail();
		return SUCCESS;
	}
	
	private void sendFindPasswordEmail() throws EmailException {
		ActiveMailUtil activeMailUtil=new ActiveMailUtil();
		activeMailUtil.setTargetEmail(user.getMailBox());
		activeMailUtil.setSubject("Find your " + GlobalConstant.webTitle + " account back");
		StringBuffer mainMessageBuffer = new StringBuffer();
		//String mailMessage="USERNAME: " + user.getUserName() + "<BR />PASSWORD:" + user.getPassWord();
		mainMessageBuffer.append("<p>Dear user, your Meta-Mesh account information is:</p>");
		mainMessageBuffer.append("<p>USERNAME: " + user.getUserName() + "</p>");
		mainMessageBuffer.append("<p>PASSWORD: " + user.getPassWord() + "</p>");
		mainMessageBuffer.append("<p>We recommend to login and reset your password for your account safety and security.</p>");
		mainMessageBuffer.append("<p>This is an automatic message sent by Meta-Mesh system, please do not reply this email. Any problem please contact to songbx@qibebt.ac.cn</p>");
		activeMailUtil.setMessage(mainMessageBuffer.toString());
		activeMailUtil.run();
	}

	private void sendActiveEmail() throws EmailException{
		ActiveMailUtil activeMailUtil=new ActiveMailUtil();
		activeMailUtil.setTargetEmail(user.getMailBox());
		activeMailUtil.setSubject("Active your " + GlobalConstant.webTitle + " account");
		String mailMessage=(String)attibutes.get("currentUrl")+"user/active?username="+user.getUserName()+"&randomString="+user.getRandomString();
		String linkMailMessage = "<a href=\""+mailMessage+"\">"+mailMessage+"</a>";
		StringBuffer mainMessageBuffer = new StringBuffer();
		mainMessageBuffer.append("<p>Thank you for the registration in Meta-Mesh. To active your account, please click the following link:</p>");
		mainMessageBuffer.append("<p>" + linkMailMessage + "</p>");
		mainMessageBuffer.append("<p>If the page cannot be automatically redirected, please paste this URL:" + mailMessage + " into your browser.</p>");
		mainMessageBuffer.append("<p>This is an automatic message sent by Meta-Mesh system, please do not reply this email. Any problem please contact to songbx@qibebt.ac.cn.</p>");
		activeMailUtil.setMessage(mainMessageBuffer.toString());
		activeMailUtil.run();
	}
	
	
	public String changePassWord() throws Exception{
		if(permissionAction.ifLoginEd()){
			
		}else{
			return LOGIN;
		}
		
		if(! ((String)attibutes.get("rand")).equalsIgnoreCase(checkcode)){
			setMessage("Wrong check code, please try again.");
			attibutes.remove("rand");
			return INPUT;
		}
		attibutes.remove("rand");		
		this.setUsername((String)attibutes.get("username"));
		this.user = userManager.getUserByUserName(username);
		if(!user.getMailBox().equals(mailbox)){
			setMessage("Wrong Email address, please chek it!");
			return INPUT;
		}
		this.createUser();
		user.setNewPassword(password1);
		setMessage(userManager.changePassWord(user));
		if(message.equals("sucess")){
			this.loginOutDestroyCookie();
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public  String activeUser() throws Exception{
		if(permissionAction.ifLoginEd()){
			return "logedon";
		}
		this.createUser();
		this.loginOutDestroyCookie();
		setMessage(userManager.activeUser(user));
		this.creatWorkShopDir();
		if(message.equals("sucess")){
			this.setMessage("Active sucess, please login!");
			return SUCCESS;
		}else{
			System.out.println("message");
			return ERROR;
		}
	}
	
	private void creatWorkShopDir(){
		File dir=new File(GlobalConstant.uploadDir + user.getUserName());
        if(!dir.exists()){  
            dir.mkdirs();  
       } 
	}
	private void creatDefaultWorkShop() throws Exception{
		WorkShop workShop = new WorkShop();
		workShop.setName("Default");
		workShop.setOwner(user);
		WorkShopManager workShopManager = new WorkShopManagerImpl();
		workShopManager.save(workShop);
	}
	
	public String input() throws Exception{
		if(permissionAction.ifLoginEd()){
			return "logedon";
		}
		return SUCCESS;
	}
	public String uploadInput() throws Exception{
		if(permissionAction.ifLoginEd()){
			Integer tempId=(Integer)attibutes.get("userid");
			user = userManager.getUserByUserId(tempId);
			return "logedon";
		}
		return SUCCESS;
	}
	
	public String login() throws Exception{
		if(permissionAction.ifLoginEd()){
			return "logedon";
		}
		if(null == sourceurl || "".equals(sourceurl)){
			this.sourceurl="user";
		}
		if(attibutes.containsKey("userid") && attibutes.containsKey("username")){
			return "logedon";
		}
		if(! ((String)attibutes.get("rand")).equalsIgnoreCase(checkcode)){
			setMessage("Wrong check code, please try again.");
			attibutes.remove("rand");
			return LOGIN;
		}else if(username.isEmpty()){
			setMessage("user name is empty");
			return LOGIN;
		}else if(password1.isEmpty()){
			setMessage("password is empty");
			return LOGIN;
		}
		attibutes.remove("rand");
		this.createUser();
		setMessage(userManager.check(user));
		if(message.equals("sucess")){
			user=userManager.getUserByUserName(username);
			this.loginInCreatCookie();
			return SUCCESS;
		}else{
			return LOGIN;
		}
	}
	
	public String logout(){
		this.loginOutDestroyCookie();
		return SUCCESS;
	}
	
	public String getUserByUserId() throws Exception{
		Integer tempId=(Integer)attibutes.get("userid");
		if(null==tempId || 0 == tempId){
			setMessage("Please Login!");
			return INPUT;
		}
		User tempUser=userManager.getUserByUserId(tempId);
		if(null == tempUser){
			setMessage("Cannot find current user, please Login!");
			return INPUT;
		}
		setWebPageTitle("User Center");
		this.user=tempUser;
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRandomString() {
		return randomString;
	}

	public void setRandomString(String randomString) {
		this.randomString = randomString;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getSourceurl() {
		return sourceurl;
	}

	public void setSourceurl(String sourceurl) {
		this.sourceurl = sourceurl;
	}

	public PermissionAction getPermissionAction() {
		return permissionAction;
	}

	public void setPermissionAction(PermissionAction permissionAction) {
		this.permissionAction = permissionAction;
	}

	public String getWorkShopProject() {
		return workShopProject;
	}

	public void setWorkShopProject(String workShopProject) {
		this.workShopProject = workShopProject;
	}

	public String getRandomFilename() {
		return randomFilename;
	}

	public void setRandomFilename(String randomFilename) {
		this.randomFilename = randomFilename;
	}

}
