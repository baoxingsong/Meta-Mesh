<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><s:property value="user.username" />，欢迎您登录老许的博客(http://www.blog.csdn.net/lenotang)</h1>

<br>登陆用户名：<s:property value="#session.username"/>  
<br>登陆密  码：<s:property value="#session.password"/>  
</body>
</html>