<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
      <form method="post" action="admin/document_update">
      	title:<input type="text" size="100" name="title" value="<s:property value="document.title"/>"><br><br>
       	content:<textarea name="content" cols="100" rows="8"><s:property value="document.content"/></textarea><br><br>
       	<s:token></s:token>
       	<input type="text" name="id" style="display:none" value="<s:property value="document.id"/>">
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
