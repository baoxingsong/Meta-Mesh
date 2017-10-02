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
<span style="width:100%; text-align:left; float:left">More help information can be found in <a href="document_content?id=18" target="_blank" style="font-size:16px; font-weight:bold;">Document</a>.</span>
<form method="post" action="metadata_search_result">
	KeyWord:<input type="text" style="width:480px;" name="keyword">
	&nbsp;<input type="submit" id="download_zip" value="Project filter by keywords">
</form>
    
<table width="100%">
<tr><td>ID</td><td><s:text name="list_search_page_project"/></td><td><s:text name="inputtime"/></td></tr>
  	<s:iterator value="metaDatas" status="st">
    	<tr <s:if test="#st.odd">style="background-color:#eeeeee"</s:if>>
    	<td><a href="metadata/?id=<s:property value="id"/>"><s:property value="id"/></a></td>
    	<td><a href="metadata/?id=<s:property value="id"/>"><s:property value="projectName"/></a></td>
    	<td><s:property value="%{getText('global.date',{createTime})}"/></td>
    	</tr>
    </s:iterator>
</table>
<br/>
<s:if test="totalCount*(page-1)>0">
<a href="metadata_list?page=<s:property value="page-1"/>"><s:text name="list_search_page_lastpage"/></a>
</s:if>
&nbsp;&nbsp;
<s:text name="list_search_page_currentpage"/><s:property value="page"/>&nbsp;&nbsp;
<s:if test="recordPerPage*page<totalCount">
<a href="metadata_list?page=<s:property value="page+1"/>"><s:text name="list_search_page_nextpage"/></a>
</s:if>
&nbsp;&nbsp;
<s:text name="list_search_page_totalrecord"><s:param><s:property value="totalCount"/></s:param></s:text>
&nbsp;&nbsp;
<s:text name="list_search_page_recordperpage"><s:param> <s:property value="recordPerPage"/></s:param></s:text>
<br />
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