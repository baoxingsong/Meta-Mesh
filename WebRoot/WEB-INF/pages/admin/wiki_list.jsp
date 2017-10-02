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

<table width="100%">

  	<s:iterator value="wikis" status="st">
    	<tr <s:if test="#st.odd">style="background-color:#eeeeee"</s:if>>
    	<td><a href="wiki_content?keyWord=<s:property value="keyWord"/>"><s:property value="keyWord"/></a></td>
    	<td><a href="admin/wiki_delete?id=<s:property value="id"/>">delete</a></td>
    	<td><a href="admin/wiki_updateinput?id=<s:property value="id"/>">update</a></td>
    	</tr>
    </s:iterator>
</table>
<br/>
<s:if test="totalCount*(page-1)>0">
<a href="wiki_list?page=<s:property value="page-1"/>"><s:text name="list_search_page_lastpage"/></a>
</s:if>
&nbsp;&nbsp;
<s:text name="list_search_page_currentpage"/><s:property value="page"/>&nbsp;&nbsp;
<s:if test="recordPerPage*page<totalCount">
<a href="wiki_list?page=<s:property value="page+1"/>"><s:text name="list_search_page_nextpage"/></a>
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