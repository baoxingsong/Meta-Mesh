<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<jsp:include page="WEB-INF/pages/commontemplate/metainformation.jsp" />

</head>
  
<body>

<div id="wrapper">
    <div id="maincontent-wrapper">
    <jsp:include page="WEB-INF/pages/commontemplate/header.jsp" />

        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
                        <div id="main">
<div>There are some error happened, you could go to the <a href="index">home page</a>.</div>
<div>Or you could send email to the administrator: <a href="mailto:songbaoxing@hotmail.com">songbaoxing@hotmail.com</a>.</div>
	<s:property value="exception.message" />
	<s:property value="message" />

                            <div class="clear"><br></div>
                        </div>     <!--end main -->
                    </div><!-- endmain-wrapper -->
                     
                </div><!-- end wrapper-3 -->
            </div><!-- end wrapper-content -->
            
            <jsp:include page="WEB-INF/pages/commontemplate/footer.jsp" />
                    </div><!-- end wrapper-2 -->
    </div><!--end maincontent-wrapper-->
  <br/><br/>
</div><!-- end wrapper -->
</body></html>