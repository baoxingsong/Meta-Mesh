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

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=en"></script>
<script type="text/javascript" src="skin/js/jQuery.bMap.1.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#map').css("width","100%");
	$('#map').css("height",$(window).height() + "px");
	$('#map').bMap({
		mapZoom: 2,
		mapType: google.maps.MapTypeId.HYBRID,
		loadMsg: "<h2>Loading...</h2>"
	});
	$('#map').data('bMap').AJAXMarkers({	
			serviceURL: '<s:property value="ajaxUrl"/>'
	});
	
});
</script>
<style type="text/css"> 
#winpop {z-index:3;width:150px; height:110px; position: fixed !important;position:absolute; right:0; bottom:0; border:1px solid #999999; margin:0; padding:1px; overflow:hidden; background:#baa949} 
#winpop .con { width:100%; height:100px; line-height:20px; font-weight:bold; font-size:12px; color:#FFF; text-align:center} 
</style> 
</head>   
<body id="project" class="col-float3 rightcol-layout" >
<div id="wrapper">
    <div id="maincontent-wrapper">
    <jsp:include page="../commontemplate/header.jsp" />

        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
                        <div id="main" style="width:100%; margin:0; padding:0">
<div id="map"></div>
<div class="clear"></div>
                        </div><!-- end main -->
                    </div><!-- endmain-wrapper -->
                               
               
                 
                </div><!-- end wrapper-3 -->
            </div><!-- end wrapper-content -->
            
            <jsp:include page="../commontemplate/footer.jsp" />
                    </div><!-- end wrapper-2 -->
    </div><!--end maincontent-wrapper-->
  <br/><br/>
</div><!-- end wrapper -->

<div id="winpop"> 
	<div class="con">
		<p>Go to <a href='metadata_list'>All samples</a></p>
		<p style="font-size:10px;">including samples without GIS information</p>
	</div> 
</div>

</body>
</html>