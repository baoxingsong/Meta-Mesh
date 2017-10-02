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
<jsp:include page="../commontemplate/metainformation.jsp" />
<style type="text/css">
#download-builder  {font-size:10px; padding:10px 0 20px 30px;}
#download_zip {cursor: pointer; margin: 15px 0 0; width: 200px; text-align: center; font-size: 1.1em; -moz-border-radius: 6px; -webkit-border-radius: 6px; background: #222 0 50% repeat-x; color: #eee; border: 2px solid #aaa; font-weight: bold; padding: .4em 0;}
#download_zip:hover { background: #111; color: #fff;}
.focus{
	border:1px solid #00f;
	background: #ccf;
}
</style>

<script type="text/javascript">
	$(function(){
		$(":input").focus(function(){
			$(this).addClass("focus");
		}).blur(function(){
			$(this).removeClass("focus");
		})
	})
</script>
</head>
  
<body id="project" class="col-float3 rightcol-layout" >

<div id="wrapper">
    <div id="maincontent-wrapper">
    <jsp:include page="../commontemplate/header.jsp" />

        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
                        <div id="main">

<form method="post" action="metadata_search_result">
	KeyWord:<input type="text" style="width:480px;" name="keyword">
	&nbsp;<input type="submit" id="download_zip" value="Project filter by keywords">
</form>

<s:if test="metaData.projectName!=null"><h3><s:property value="metaData.projectName" /></h3></s:if>
 
 <table width="95%" borderColor="#aaa" cellSpacing="1px" cellPadding="3px"  border="1px">
 <tr><td>ID</td><td><s:property value="metaData.id" /></td></tr>
 <s:if test="metaData.projectName!=null"><tr><td><s:text name="detail_page_project"/></td><td><s:property value="metaData.projectName" /></td></tr></s:if>
 <s:if test="metaData.description!=null"><tr><td><s:text name="detail_page_discription"/></td><td><s:property value="metaData.description"  escape="false" /></td></tr></s:if>
 <s:if test="metaData.databaseSource!=null"><tr><td><s:text name="detail_page_databaseSource"/></td><td><a href="<s:property value="metaData.databaseSourceURL" />" targer="_blank"><s:property value="metaData.databaseSource" /></a></td></tr></s:if>
 <!--<s:if test="metaData.sourceId!=null"><tr><td><s:text name="detail_page_sourceid"/></td><td><a href="<s:property value="metaData.sourceURL" />" targer="_blank"><s:property value="metaData.sourceId" /></a></td></tr></s:if>-->
 <s:if test="metaData.sourceId!=null"><tr><td><s:text name="detail_page_sourceid"/></td><td><s:property value="metaData.sourceId" /></td></tr></s:if>
 <s:if test="metaData.sourceURL!=null"><tr><td>PROVENANCE TRACING</td><td><a href="<s:property value="metaData.sourceURL" />" targer="_blank"><s:property value="metaData.sourceURL" /></a></td></tr></s:if>
 <s:if test="metaData.createTime!=null"><tr><td><s:text name="detail_page_creat_time"/></td><td><s:property value="%{getText('global.datetime',{metaData.createTime})}"/></td></tr></s:if>
 <!--<s:if test="metaData.sequenceingPlatform!=null"><tr><td><s:text name="detail_page_sequencingplatform"/></td><td><s:property value="metaData.sequenceingPlatform" /></td></tr></s:if>-->
 <s:if test="metaData.contactInformation!=null"><tr><td><s:text name="detail_page_contactInformation"/></td><td><s:property value="metaData.contactInformation" escape="false"/></td></tr></s:if>
 <!--<s:if test="metaData.metaDiscription!=null"><tr><td><s:text name="detail_page_metaDiscription"/></td><td><s:property value="metaData.metaDiscription"  escape="false"/></td></tr></s:if>-->
 </table>
<br />
 
 <s:if test="metaData.metaDataSample.size>0">
 <b>Metagenome Sample</b>
 <td> <table width="95%" borderColor="#aaa" cellSpacing="1px" cellPadding="1px"  border="1px">
 <tr><td>Sample ACC</td><td>Detail Information</td><td>Download</td><td>View</td><td>Search</td></tr>
<s:iterator value="metaData.metaDataSample">
<tr>
<td  align="center" valigh="middle"><a href="metasample/?acc=<s:property value="database_source" />_<s:property value="metagenome" />" target="_blank"><s:property value="database_source" />_<s:property value="metagenome" /></a></td>
<td width="88px" align="center" valign="middle"><a href="metasample/?id=<s:property value="id" />" target="_blank"><img src="skin/images/song/detail.png"/></a></td>
<td width="88px" align="center" valign="middle"><a href="ftp://ftp.database.metasee.org/<s:property value="database_source" />/<s:property value="metaData.sourceId"/>/<s:property value="metagenome"/>/" target="_blank"><img src="skin/images/song/download.png"/></a></td>
<td width="88px" align="center" valign="middle"><a href="sampleview?id=<s:property value="id" />" target="_blank"><img src="skin/images/song/view.png"/></a></td>
<td width="88px" align="center" valign="middle"><a href="sampleMetormsinput?id=<s:property value="id" />" target="_blank"><img src="skin/images/song/search.png"/></a></td>
</tr> 
</s:iterator>
 
 </table>
 </s:if>
 
  
                              <div class="clear"><br></div>
                        </div><!-- end main -->
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
 