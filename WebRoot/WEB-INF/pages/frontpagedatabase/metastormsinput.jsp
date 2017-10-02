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


Parallel-META Result ID:<s:property value="id" /><br />
<br />
<form action="sampleMetormsnew" method="post" name="uploard_file" target="_self">

<a title="?" href="document_content?id=5" target="_blank">Database Index Name</a>:&nbsp;
<select name="database" id="database">
<option value="DB-all-group" SELECTED>All Group</option>
<option value="0">Organismal Metagenomes</option>
<option value="1">Ecological Metagenomes</option>
</select>
<br />
</p>
<p>
<a title="?" href="document_content?id=5" target="_blank">Hit Number</a>:&nbsp;
<select name="hitNumber" id="hitNumber">
<option value="1" >1</option>
<option value="2" >2</option>
<option value="3" >3</option>
<option value="4" >4</option>
<option value="5"  SELECTED>5</option>
<option value="6" >6</option>
<option value="7" >7</option>
<option value="8" >8</option>
<option value="9" >9</option>
<option value="10" >10</option>
</select>
<br />
</p>

<p>
<a title="?" href="document_content?id=5" target="_blank">Exhaustive Search</a>:&nbsp;
<select name="exhaustiveSearch" id="exhaustiveSearch">
<option value="n"  SELECTED>NO</option>
<option value="y" >YES</option>
</select>
<br />
</p>



<input type="hidden" name="parallelMetaResultId" id="parallelMetaResultId" value="<s:property value="parallelMetaResult.id" />" />
<input type="hidden" name="id" id="id" value="<s:property value="id" />" />
<br />
<input type="hidden" name="uuid" id="uuid" value="<%=randomFilename %>" />
<br />
<input type="submit" id="download_zip" value="Submit">&nbsp;<input type="reset"  id="download_zip" value="Reset">
</form>
                            <div class="clear"><br></div>
                        </div>     <!--end main -->
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