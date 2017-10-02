<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
<base href="<%=basePath%>">
<jsp:include page="../../commontemplate/metainformation.jsp" />

<style type="text/css">
body {
	font-family: Verdana, helvetica, arial, sans-serif;
	font-size: 68.75%;
	background: #fff;
	color: #333;
}
#download-builder  {font-size:10px; padding:10px 0 20px 30px;}
#download_zip {cursor: pointer; margin: 15px 0 0; width: 80px; text-align: center; font-size: 1.1em; -moz-border-radius: 6px; -webkit-border-radius: 6px; background: #222 0 50% repeat-x; color: #eee; border: 2px solid #aaa; font-weight: bold; padding: .4em 0;}
#download_zip:hover { background: #111; color: #fff;}
.focus{
	border:1px solid #00f;
	background: #ccf;
}
.centitle{
width:85%;
background:#5a666c;
color:#bcae79;
font-size:12px;
height:20px;
padding-left:10px;
line-height:20px;
}
.songtitle{
font-size:16px;
font-weight: bolder;
}
</style>


</head>
  
<body id="project" class="col-float3 rightcol-layout" >
<div id="wrapper">
    <div id="maincontent-wrapper">
    <jsp:include page="../../commontemplate/header.jsp" />

        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
						<div id="main">
                        <h4>Hello, <s:property value="user.userName"/>, welcome to <s:property value="ApplicationTitle"/> Work Center.</h4>
                        <span style="width:100%; text-align:left; float:left">More help information can be found in <a href="document_content?id=16" target="_blank" style="font-size:16px; font-weight:bold;">Document</a>.</span>
                        <span style="color:#f00;weight:folder"><br /><s:property value="message"/><br /> </span>
                        <p class="songtitle">Work Shop</p>
                        <p>To start analysis, please enter a Work Shop.</p>
                        <div class="centitle">The Work Shop you created:</div>
                        <s:if test="user.workShops.size>0">
                         <ol>
	                        <s:iterator value="user.workShops">
	                        		<li><a href="getWorkShop?id=<s:property value="id"/>"><s:property value="name"/></a></li>
	                        </s:iterator>
	                     </ol>
                        </s:if><s:else>
                        	<div>You have not create any Work Shop yet!</div>
                        </s:else>
                        <div><a href="addWorkShopInput">create new Work Shop</a></div>
                      <hr />
                       <p class="songtitle">Work Group</p>
                        <p>Choose a Work Group to manage it or view shared Work Shops.</p>
                      <div class="centitle">The Work Group you created:</div>
                        <s:if test="user.workGroups.size>0">
                         <ol>
	                        <s:iterator value="user.workGroups">
	                        		<li><a href="getWorkGroup?id=<s:property value="id"/>"><s:property value="name"/></a></li>
	                        </s:iterator>
	                     </ol>
                        </s:if><s:else>
                        	<div>You have not create any Work Group yet!</div>
                        </s:else>
                        <div><a href="addWorkGroupInput">create new Work Group</a></div>
						<hr />
						<div class="centitle">The Work Group you joined:</div>
                        <s:if test="user.workGroupMembers.size>0">
                         <ol>
	                        <s:iterator value="user.workGroupMembers">
	                        		<li><a href="getWorkGroup?id=<s:property value="workGroup.id"/>"><s:property value="workGroup.name"/></a> created by <s:property value="workGroup.owner.userName"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img title="What can I do?" width="10px" src="skin/images/song/seperator.png"/> <a href="signout?id=<s:property value="id"/>">sign out</a> this Work Group <s:if test="state==1">You are invitated to join this Work Group, you could <a href="acceptInvite?id=<s:property value="id"/>">accept</a> this invitation.</s:if><s:if test="state==2">You have applied to this Work Group, and waiting for be approved.</s:if></li>
	                        </s:iterator>
	                     </ol>
                        </s:if><s:else>
                        	<div>You have not join any Work Group yet!</div>
                        </s:else>
                        <div>You could apply <a href="applyJoinWorkGroupInput">join some Work Groups</a>, if you know the name of this Work Group and username of the creator.</div>
						<hr />
						<div class="centitle">Your message:</div>
						<div style="color:#ff0000">
						<ol>
							<s:iterator value="user.workGroupMembers">
	                        		<s:if test="state==1"><li>Your are invited to join<a href="getWorkGroup?id=<s:property value="workGroup.id"/>"><s:property value="workGroup.name"/></a> created by <s:property value="workGroup.owner.userName"/> You could <a href="acceptInvite?id=<s:property value="id"/>">accept</a> or <a href="signout?id=<s:property value="id"/>">decline</a></li></s:if>
	                        </s:iterator>
	                        <s:iterator value="user.workGroups">
	                        	<s:iterator value="workGroupMembers">
	                        		<s:if test="state==2"><li><s:property value="user.userName"/> are applying to join Work Group <a href="getWorkGroup?id=<s:property value="workGroup.id"/>"><s:property value="workGroup.name"/></a> created by you. You could <a href="acceptApplication?id=<s:property value="id"/>">accept</a> or <a href="deleteWorkGroupMember?id=<s:property value="id"/>">decline</a></li></s:if>
	                        	</s:iterator>	
	                        </s:iterator>
						</ol>
						</div>
                            <div class="clear"><br></div>
                        </div>     <!--end main -->
                    </div><!-- endmain-wrapper -->
                    <jsp:include page="../../commontemplate/rightcolumn.jsp" />
                </div><!-- end wrapper-3 -->
            </div><!-- end wrapper-content -->
            
            <jsp:include page="../../commontemplate/footer.jsp" />
                    </div><!-- end wrapper-2 -->
    </div><!--end maincontent-wrapper-->
  <br/><br/>
</div><!-- end wrapper -->



</body></html>