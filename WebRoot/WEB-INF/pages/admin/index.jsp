<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  <a href="admin/news_add">news_add</a><br>
  <a href="admin/news_list">news_admin</a><br>
  <a href="admin/document_add">document_add</a><br>
  <a href="admin/document_list">document_admin</a><br>
  <a href="admin/wiki_add">wiki_add</a><br>
  <a href="admin/wiki_list">wiki_admin</a><br>
  <a href="admin/database_add">database_add</a><br>
  <a href="admin/database_list">database_admin</a>
  </body>
</html>
