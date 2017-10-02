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

<script type="text/javascript">
$(function(){
		getMetaInformation();
});
var getMetaInformation=function(){
	$.ajax({
			type:"get",
			url:"getxmlsourcecode?sourceURL=http://ftp.database.metasee.org/<s:property value="metaDataSample.database_source"/>/<s:property value="metaDataSample.metaData.sourceId" />/<s:property value="metaDataSample.metagenome"/>.xml",
			timeout: 5000,
			success : function(data){
				ergodicXML(data);	
			},
			error: function(xhr,testStatus,error){
				alert("Get meta-information error!");
				$('#information').html($('<br /><br /><br /><h4><p>There was some thing error happend, click <a onclick="getMetaInformation();" style="background="#aaa"">here</a> to retry it or you can <a href="mailto:songbaoxing168@163.com" target="_blank">report error</a> to us!</p></h4>'));	
			},
		});	
};

var ergodicXML=function(data){
	
	$('#information').html('<table width="95%" id="meta-information" borderColor="#aaa" cellSpacing="1px" cellPadding="3px"  border="1px>"</table>');
	$(data).children().each(function(){
		recursionXmlNode(this);
	});
};

var recursionXmlNode=function(data){
	$(data).children().each(function(){
		if($(this).children().length>0){
			recursionXmlNode(this);
		}else{
			$("<tr><td>"+$(this).get(0).tagName+"</td><td>"+$(this).text()+"</td></tr>").appendTo($('#meta-information'));
		}
	});
};
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
<h3 style="color:#4444ee">Detail Information of Project: <a href="metadata/?id=<s:property value="metaDataSample.metaData.id"/>"><s:property value="metaDataSample.metaData.projectName" /></a> --- Sample: <s:property value="metaDataSample.database_source" />_<s:property value="metaDataSample.metagenome" /></h3>
<br />
<a href="ftp://ftp.database.metasee.org/<s:property value="metaDataSample.database_source" />/<s:property value="metaDataSample.metaData.sourceId"/>/<s:property value="metaDataSample.metagenome"/>/" target="_blank"><img src="skin/images/song/download.png"/></a>
<a href="sampleview?id=<s:property value="id" />" target="_blank"><img src="skin/images/song/view.png"/></a>
<a href="sampleMetormsinput?id=<s:property value="id" />" target="_blank"><img src="skin/images/song/search.png"/></a>
<s:if test="metaDataSample.longitude!=null && metaDataSample.latitude!=null && metaDataSample.longitude!=0 && metaDataSample.latitude!=0"><a href="map_view?sampleId=<s:property value="id" />" target="_blank"><img src="skin/images/song/map.png"/></a></s:if>
<br />
<br />
<div id="information">
<br />
<br />
<br />
<br />
<h3 style="width=100%; text-align:center;">Meta-information loading ......</h3> 

</div>
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
 