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
                        <h4>File page Of <s:property value="uploadFIle.fileName" />, ID: <s:property value="uploadFIle.id" /></h4>
                  
                        
                        <br />
                        
                     	

											<s:if test="uploadFIle.parallelMetaResults.size>0">
										
                        					<s:iterator value="uploadFIle.parallelMetaResults">
                        						<li><s:if test="error==1"><span style="color:#f00">ERROR</span>&nbsp;&nbsp;&nbsp;</s:if><s:elseif test="complete==0">We are doing it!&nbsp;&nbsp;&nbsp;</s:elseif><s:property value="toStringName" /><s:else>&nbsp;&nbsp;&nbsp;&nbsp; <a href="getparallelresult?parallelMetaResultId=<s:property value="id" />">View</a> &nbsp;&nbsp;&nbsp;<A href="newmetastorms?parallelMetaResultId=<s:property value="id"/>">Analysis with Meta-Storms</a></s:else>&nbsp;&nbsp;&nbsp;<a href="javascript:confirmDeleteParallelMetaResult('<s:property value="id" />','<s:property value="toStringName" />');">remove</a></li>
                        					</s:iterator>
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