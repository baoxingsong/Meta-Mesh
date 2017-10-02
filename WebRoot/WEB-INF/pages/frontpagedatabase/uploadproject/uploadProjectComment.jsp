<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<base href="<%=basePath%>">
<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-store, must-revalidate">
</head>
<body>

<strong><a style="color:#f00" href="projectcommentupdate?uploadProjectId=<s:property value="uploadProject.id" />" target="_blank">EDIT IT</a></strong>
<p style="width:80px">
<s:property value="uploadProject.comment" escape="false"/>
</p>
</body></html>