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

<script type="text/javascript">
$(function(){
	getMetaInformation();
	setInterval(function adsf(){
		
		getMetaInformation();
	},5000);
		
});
var getMetaInformation=function(){
	//alert("123");
	$.ajax({
			type:"get",
			url:"parallelmetacommentlog?id=<s:property value="parallelMetaResult.id"/>",
			timeout: 500,
			dataType: "html",
			success : function(data){
				$('#resText').text(" ");
				$('#resText').text(data);
				$('#resText').scrollTop( document.getElementById("resText").offsetHeight);
			},
			error: function(xhr,testStatus,error){
			
			},
		});	
};
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
               
Parallel Progress!
<br/>
<textarea id="resText" cols="110" rows="35"></textarea>
                        
                            <div class="clear"></div>
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