<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<% String randomFilename=UUID.randomUUID().toString(); %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
<base href="<%=basePath%>">
<jsp:include page="../commontemplate/metainformation.jsp" />


<style type="text/css">
#fileQueue {
	width: 400px;
	height: 300px;
	overflow: auto;
	border: 1px solid #E5E5E5;
	margin-bottom: 10px;
}
</style>

<link href="skin/css/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="skin/js/uploadify/swfobject.js"></script>
<script type="text/javascript"	src="skin/js/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="skin/js/jquery.chained.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){$("#series").chained("#mark");});
	var workShop = "";
	var project = "";
	var workShopProject = "";
	function selectChange(){
		workShop = $("#mark").val();
		project = $("#series").val();
		workShopProject = workShop + "___" + project;
		var url = "uploadInnerFrame?randomFilename=<%=randomFilename%>&workShopProject="+workShopProject;
		$("#inneruploadiframe").attr("src", url);
		
	}
</script>
</head>
<body id="project" class="col-float3 rightcol-layout">

<div id="wrapper" >
    <div id="maincontent-wrapper">
    <jsp:include page="../commontemplate/header.jsp" />
        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
                        <div id="main">
	<span style="color:#f00"><s:property value="message"/></span>
	<br />
		
<div>
<h1>Data upload</h1>
<p>For large data uploading, please use the <a href="article_content?keyWord=Meta-Mesh%20Data%20Manager">Meta-Mesh Data Manager</a>.</p>
<p>Please follow 3 steps: </p>

<p><strong>1. Please select the workshop you want to upload to.</strong></p>

<p><select id="mark">
<s:if test="user.workShops.size>0">
	<s:iterator value="user.workShops">
	<option value="<s:property value="name"/>"><s:property value="name"/></option>
	</s:iterator>
</s:if>
</select></p>
<p><strong>2. Please select the project of the workshop, or create a new project.</strong></p> 
<p><select id="series" onchange="selectChange()">
  <option value="">New Project</option>
  <s:iterator value="user.workShops">
  <s:iterator value="uploadProjects">
		<option value="<s:property value="randomFileName"/>" class="<s:property value="name" />"><s:property value="randomFileName"/></option>
  	</s:iterator>
  </s:iterator>
</select></p>
</div>
<p><strong>3. Please select file you want to upload.</strong></p> 
<p><strong>Make sure the data is metagenomic shotgun or 16S/18S targeted sequence in FASTA or FASTQ format.</strong></p> 
<p><strong>Please do not upload a file whose filename contains blank space.</strong></p>
<iframe id="inneruploadiframe" name="inneruploadiframe" src="uploadInnerFrame" height="300px" width="650px" scrolling="no" frameborder="0"></iframe>
<p><strong>4. After the uploading is done, you could upload another data or goto <a href="user">Work Center</a> to analysis these data.</strong></p> 
<div>
<p>NOTICE:</p>
<ol>
<li>PLease select the Work Shop and Project you want to upload your data to. Name of the new Project will be automatically assigned by the system.</li>
<li>Please make sure the data is metagenomic shotgun or 16S/18S targeted sequence in FASTA or FASTQ format.</li>
<li>For large data uploading, <a href="article_content?keyWord=Meta-Mesh%20Data%20Manager">Meta-Mesh Data Manager</a> is highly recommended.</li>
<li>Please do not upload a file whose filename contains blank space.</li>
</ol>
</div>
				</div><!-- endmain -->
					 </div><!-- endmain-wrapper -->
                     <jsp:include page="../commontemplate/rightcolumn.jsp" />
                     
                </div><!-- end wrapper-3 -->
            </div><!-- end wrapper-content -->
            
            <jsp:include page="../commontemplate/footer.jsp" />
                    </div><!-- end wrapper-2 -->
    </div><!--end maincontent-wrapper-->
  <br/><br/>
</div><!-- end wrapper -->
</body></html>
