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

<link rel="stylesheet" href="skin/css/jquery.treeview.css" />

<script src="skin/js/jquery.treeview.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="http://craigsworks.com/projects/qtip2/packages/latest/jquery.qtip.min.css" />
<!--JavaScript - Might want to move these to the footer of the page to prevent blocking-->
<script type="text/javascript" src="http://craigsworks.com/projects/qtip2/packages/latest/jquery.qtip.min.js"></script>
<script type="text/javascript">
function newwindowsnoaddress(address){
	var width=document.width +"px";
	var height=document.height +"px";
	window.open (address,'newwindow','height='+height+',width='+width+',top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no') 
}
</script>


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


<table width="650px;" border="1" cellspacing="1" cellpadding="1" style="text-align:center">
 <tr>
    <td>File has been analyzed</td>
    <td style=" width:132px; overflow:hidden">Download</td>
    <td style=" width:132px; overflow:hidden">Sample View</td>
 </tr>
 <tr>
    <td style="word-break:break-all; padding:2px;"><a href="uploadfiledownload?uploadFileId=<s:property value="parallelMetaResult.uploadFile.id"/>"><s:property value="parallelMetaResult.uploadFile.fileName"/></a></td>
    <td><a href="parallelmetadownload?id=<s:property value="parallelMetaResult.id"/>"><img src="skin/img/tar.jpg" style="max-width:130px; width: expression(this.width &gt; 130 ? 130: true);" alt="TAR" title="download this result"/></a></td>
    <td><a onclick="newwindowsnoaddress('parallelmetasampleview?parallelMetaResultId=<s:property value="parallelMetaResult.id"/>')"><img src="skin/img/cvm.jpg" style="max-width:130px; width: expression(this.width &gt; 130 ? 130: true);" alt="meta-viewer" title="view this result by Krona"/></a></td>
 </tr>
 </table>
<p>&nbsp;&nbsp;</p>

<s:if test="parallelMetaResult.metaStormsResults.size>0">
<h3>Meta-Storms result(s)</h3>
<ul>
<s:iterator value="parallelMetaResult.metaStormsResults">
	<li><a href="getmetastormresult?metaStormsResultId=<s:property value="id" />"><s:property value="toStringName" /></a></li>
</s:iterator>
</ul>
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