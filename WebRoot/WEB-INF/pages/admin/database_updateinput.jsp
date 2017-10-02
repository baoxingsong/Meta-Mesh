<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
      <form method="post" action="admin/database_update">
      	projectName:<input type="text" size="100" value="<s:property value="metaData.projectName"/>" name="projectName"><br><br>
      	description:<textarea name="description" cols="100" rows="8"><s:property value="metaData.description"/></textarea><br><br>
    	databaseSource:<input type="text" size="100" value="<s:property value="metaData.databaseSource"/>" name="databaseSource"><br>
    	sourceURL:<input type="text" size="100" name="sourceURL" value="<s:property value="metaData.sourceURL"/>"><br>
    	sourceId:<input type="text" size="100" name="sourceId" value="<s:property value="metaData.sourceId"/>"><br>
    	metaDiscription:<input type="text" size="100" value="<s:property value="metaData.metaDiscription"/>" name="metaDiscription"><br>
    	contactInformation:<textarea name="contactInformation" cols="100" rows="8"><s:property value="metaData.contactInformation"/></textarea><br><br>
    	sequenceingPlatform:<input type="text" size="100" value="<s:property value="metaData.sequenceingPlatform"/>" name="sequenceingPlatform"><br>
    	databaseSourceURL:<input type="text" size="100" value="<s:property value="metaData.databaseSourceURL"/>" name="databaseSourceURL"><br>
    	<s:token></s:token>
    	<input type="text" name="id" style="display:none" value="<s:property value="metaData.id"/>">
    	<input type="submit" value="submit"/>

<br />    	
<s:if test="metaData.metaDataSample.size>0">
 <td> <table width="95%" borderColor="#aaa" cellSpacing="1px" cellPadding="1px"  border="1px">
 
<s:iterator value="metaData.metaDataSample">
<tr>
<td><s:property value="database_source" />_<s:property value="metagenome" /></a></td>
<td><a href="admin/metasample_delete?id=<s:property value="id" />">delete</a></td>
<td><a href="admin/metasample_update?id=<s:property value="id" />">update</a></td>
</tr> 
</s:iterator>
</table>
</s:if>
 
    </form>
  </body>
</html>
