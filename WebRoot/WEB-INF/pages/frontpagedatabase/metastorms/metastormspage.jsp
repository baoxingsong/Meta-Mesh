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
<jsp:include page="../../commontemplate/metainformation.jsp" />


</head>
  
<body id="project" class="col-float3 rightcol-layout" >



<div id="wrapper">
    <div id="maincontent-wrapper">
    <jsp:include page="../../commontemplate/header.jsp" />

        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
						
                        <div id="main">
                        
<div><s:property value="metaStormsResult.id" /></div>
<div><s:property value="metaStormsResult.toStringName" /></div>
<div><s:property value="metaStormsResult.displayTableInformation" escape="false"/></div>

<s:if test="metaStormsResult.metaStormMatch.size>0">
<table style="width:700px; margin-left:20px;" border="1" align="center" cellspacing="1" cellpadding="3">
	<tr><td>Nower.</td><td>Similarity</td><td>Sample Group</td><td>Sample path</td></tr>
	<s:iterator value="metaStormsResult.metaStormMatch">
	<tr>
		<td><s:property value="match"/></td>
		<td><s:property value="similarity"/></td>
		<td><s:property value="sampleGroup"/></td>
		<td><s:property value="samplePath"/></td>
	</tr>	
	</s:iterator>
</table>
</s:if>
                            <div class="clear"><br></div>
                        </div>     <!--end main -->
                    </div><!-- endmain-wrapper -->
             
                     <jsp:include page="../../commontemplate/rightcolumn.jsp" />
                     
                </div><!-- end wrapper-3 -->
            </div><!-- end wrapper-content -->
            
            <jsp:include page="../../commontemplate/footer.jsp" />
                    </div><!-- end wrapper-2 -->
    </div><!--end maincontent-wrapper-->
  <br/><br/>
</div><!-- end wrapper -->


</body></html>