<%@ page contentType="image/jpeg" import="org.metasee.database.commonUtil.img.*" %>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");

response.setDateHeader("Expires", 0);
//RandImgCreater rc = new RandImgCreater(response);
RandImgCreater rc = new RandImgCreater(response,4);
//rc.setBgColor(100,100,100);
String rand = rc.createRandImage();
session.setAttribute("rand",rand);
out.clear();
out=pageContext.pushBody();
%>