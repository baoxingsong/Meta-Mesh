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
<jsp:include page="../../../commontemplate/metainformation.jsp" />
<script type="text/javascript" src="skin/js/metaseeUtil.js"></script>
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
</style>
<script type="text/javascript">
	$(function(){
		$(":input").focus(function(){
			$(this).addClass("focus");
		}).blur(function(){
			$(this).removeClass("focus");
		})
	})
</script>
</head>

<body id="project" class="col-float3 rightcol-layout" >
<div id="wrapper">
    <div id="maincontent-wrapper">
    <jsp:include page="../../../commontemplate/header.jsp" />

        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
						
                        <div id="main">
                        <h4>Work Group <em><s:property value="workGroup.name"/></em>, created by <em><s:property value="workGroup.owner.userName"/></em></h4>
                        <span style="width:100%; text-align:left; float:left">More help information can be found in <a href="document_content?id=16" target="_blank" style="font-size:16px; font-weight:bold;">Document</a>.</span>
                        <br />
                        <span style="color:#f00;weight:folder"><s:property value="message"/> </span>
                        <br />
                        
                        
                        <div class="centitle">Work Group Member:</div>
                        <br />
                        <s:if test="workGroup.workGroupMembers.size>0">
                        	<ol>
                        	<s:iterator value="workGroup.workGroupMembers">
                        	<li><s:property value="user.userName"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img title="What can I do?" width="10px" src="skin/images/song/seperator.png"/>&nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteWorkGroupMember?id=<s:property value="id"/>">delete</a> <s:if test="state==1">&nbsp;&nbsp;&nbsp;&nbsp;(Invitation send, but not been accepted yet.)</s:if><s:elseif test="state==2">&nbsp;&nbsp;&nbsp;&nbsp;This member is under application, you could <a href="acceptApplication?id=<s:property value="id"/>">accept</a> this application.</s:elseif></li>
                        	</s:iterator>
                        	</ol>
                        </s:if>
                        <s:else>
                        	<div>There is still no member in this Work Group.</div>
                        	<div>You could invite group members, if your know other's username and email.</div>
                        </s:else>  
                        
                        <br />
                        <div class="centitle">Shared Work Shops:</div>
                        <s:if test="workGroup.workShops.size>0">
                        	<ol>
                        	<s:iterator value="workGroup.workShops">
                        	<li>Work Shop <a href="getWorkShop?id=<s:property value="id"/>"><em><s:property value="name"/></em></a>, created by <em><s:property value="owner.userName"/></em></li>
                        	</s:iterator>
                        	</ol>                       
                        </s:if>
                        <s:else>
                        	<div>There is still no member share any Work Shops in this Work Group.</div>
                        </s:else>
                        <p>&nbsp;</p>
                        
      <s:form action="workGroupInvite" method="post" validate="true">
      <s:if test="null != inveiteMessage && ''!=inveiteMessage"><span style="color:#f00;weight:folder"><s:property value="inveiteMessage"/></span></s:if>
       <div class="centitle">Invite some user to join this Work Group:</div>
       <table border="0" space="0" padding="0" margain="0">
         <s:textfield name="username" label="Username" />
         <s:textfield name="mailbox" label="Email"/>
         <tr>
			<td>CheckCode:</td>
			<td><img id="imgRandom" src="user/imginput" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:metaseechangeImage();">refresh check code</a></td>
		</tr>
   		 <s:textfield name="checkcode" label="Please input the check code"/>
   		<input type="hidden" name="workGroupId" value="<s:property value="id"/>" id="workGroupId" />
   	  <tr>
      <div id="download-builder">
      <td align="center"><input type="submit" id="download_zip" value="Invite"></td>
      <td align="center"><input type="reset" id="download_zip" value="Reset"></td></div>
   </tr>
   </table>
</s:form>
                       
                            <div class="clear"><br></div>
                        </div>     <!--end main -->
                    </div><!-- endmain-wrapper -->  
                      <jsp:include page="../../../commontemplate/rightcolumn.jsp" />
                </div><!-- end wrapper-3 -->
            </div><!-- end wrapper-content -->
            
            <jsp:include page="../../../commontemplate/footer.jsp" />
                    </div><!-- end wrapper-2 -->
    </div><!--end maincontent-wrapper-->
  <br/><br/>
</div><!-- end wrapper -->
</body></html>