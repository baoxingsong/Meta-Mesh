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
      <form method="post" action="admin/database_add_action">
      	projectName:<input type="text" size="100" name="projectName"><br><br>
      	description:<textarea name="description" cols="100" rows="8"></textarea><br><br>
    	databaseSource:<input type="text" size="100" name="databaseSource"><br>
    	sourceURL:<input type="text" size="100" name="sourceURL"><br>
    	sourceId:<input type="text" size="100" name="sourceId"><br>
    	metaDiscription:<input type="text" size="100" name="metaDiscription"><br>
    	contactInformation:<textarea name="contactInformation" cols="100" rows="8"></textarea><br><br>
    	sequenceingPlatform:<input type="text" size="100" name="sequenceingPlatform"><br>
    	databaseSourceURL:<input type="text" size="100" name="databaseSourceURL"><br>
    	sourcecodeOfOriginalPage:<textarea name="sourcecodeOfOriginalPage" cols="100" rows="8"></textarea><br>
    	metaDiscriptionSourceCode:<textarea name="metaDiscriptionSourceCode" cols="100" rows="8"></textarea><br>
    	localsequencedata:<input type="text" size="100" name="localsequencedata"><br>
    	localsequencedata:<input type="text" size="100" name="localsequencedata"><br>
    	<s:token></s:token>
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
