<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<base href="<%=basePath%>">
</head>
<body>
<p style="width:80px">
<h5>Update comment</h5>
<strong>ID: <s:property value="uploadFIle.id" /></strong><br />
<strong>NAME: <s:property value="uploadFIle.fileName" /></strong><br />
<br /><br /><br />
<form method="post" action="filecommentupdateaction">

<textarea name="comment" cols="100" rows="8"><s:property value="uploadFIle.comment" /></textarea>
<input type="hidden" name="uploadFileId" value="<s:property value="uploadFIle.id" />"/>
<input type="submit" value="submit"/>
</form>
</p>
</body></html>