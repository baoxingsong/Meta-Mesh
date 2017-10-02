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

<s:if test="">
</s:if>

<script src="skin/metro/display.js" type="text/javascript"></script>
<script src="skin/metro/ga.js" type="text/javascript"></script>
<script src="skin/metro/main.js" type="text/javascript"></script>
<link rel="stylesheet" href="skin/metro/main.css" type="text/css" charset="utf-8" />
<script type="text/javascript">
/* Tiles */
	tiles = function(){/* Add your prefered tiles here */
		tile_title_text_image(0,0,"#558ed5","metadata_list", "Project List", "All the projects and samples could be viewed here. It is updated every month.", "skin/metro/img/datasets.png",scale*0.4,8,3);
		tile_live(2,0,2,"#ff0066","http://autoupdate.meta-mesh.org/", "BEGC-SPIDER",4000,"BEGC-SPIDE is an automatic data collector that collects publically available metagenome related projects and papers."," It includes the following components: (i) Metagenome Paper, (ii) Metagenome Data, and (iii) Weekly Review.","Click here for more infomation.","");
		//tile_live(0,1,4,"#5FB404","metadata_list", "Meta-Mesh Database",8000," ","");
		<s:if test="#session['username']!=null && #session['userid']!=null">
		tile_image_slider(1,1,3,1,"#FF0000","user","skin/metro/img/workshop.png","406","130","<span style='font-size:25px; '>Phylogenic analysis, similar sample search, sample compare, visualization...</span>",1);
		tile_image_slider(0,1,1,1,"#FFBF00","upload.action","skin/metro/img/upload.png","130","130","<span style='font-size:30px; '>Upload</span>",1);
		</s:if><s:else>
		tile_image_slider_unlive(1,1,3,1,"#bfbfbf","user","skin/metro/img/workshop.png","406","130","<span style='font-size:25px; '>Phylogenic analysis, similar sample search, sample compare, visualization...</span>",1);
		tile_image_slider_unlive(0,1,1,1,"#bfbfbf","upload.action","skin/metro/img/upload.png","130","130","<span style='font-size:30px; '>Upload</span>",1);
		</s:else>
		
		tile_image_slider(0,2,2,1,"#558ed5","map_view","skin/metro/img/map.png","268","130","<img width='268' height='130' style='; margin-top: 0px' src='skin/metro/img/map.png'>",1.05);
		//tile_image_slider(2,2,1,1,"#FFBF00","document_content?id=1","skin/metro/img/api.png","130","130","<span style='font-size:18px; padding-left:0px;'>Development API</span>",1);
		//tile_image_slider(3,2,1,1,"#e46c0b","article_content?keyWord=download","skin/metro/img/download.png","130","130","<span style='font-size:25px; padding-left:0px;'>Download</span>",1);
		tile_custom(2,2,1,1,"#FFBF00","document_content?id=1","<img src='skin/metro/img/api.png' height='130' width='130'/>");
		tile_custom(3,2,1,1,"#e46c0b","article_content?keyWord=download","<img src='skin/metro/img/download.png' height='130' width='130'/>");
		
		
		//tile_image_slider(0,3,2,1,"#FFBF00","document_list","skin/metro/img/document.png","268","130","<span style='font-size:30px; padding-left:0px;'>Document</span>",1);
		tile_custom(0,3,2,1,"#FFBF00","document_list","<img src='skin/metro/img/document.png' height='130' width='268'/>");
		tile_custom(2,3,1,1,"#92d050","news_list","<img src='skin/metro/img/news.png' height='130' width='130'/>");
		//tile_image_slider(2,3,1,1,"#92d050","news_list","skin/metro/img/news.png","130","130","<span style='font-size:30px; padding-left:0px;'>News</span>",1);
		//tile_image_slider(3,3,1,1,"#ff0066","article_content?keyWord=contact%20us","skin/metro/img/contact.png","130","130","<img width='130' height='130' style='; margin-top: 0px' src='skin/metro/img/contact.png'>",1);
		tile_custom(3,3,1,1,"#ff0066","article_content?keyWord=contact%20us","<img src='skin/metro/img/contact.png' height='130' width='130'/>");
	}
</script>

<link type='text/css' href='skin/confirm/css/confirm.css' rel='stylesheet' media='screen' />
</head>
  
<body id="project" class="col-float3 rightcol-layout" >

<div id="wrapper">
    <div id="maincontent-wrapper">
    <jsp:include page="../commontemplate/header.jsp" />

        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
                    
                
                        <div id="main" align="center">
                        <span style="width:100%; text-align:left; float:left">More help information can be found in <a href="document_list" target="_blank" style="font-size:16px; font-weight:bold;">Document</a>.</span>
                        
 <table width="800" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top" width="540px"><div id="content"></div></td>
    <td><table width="260" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="skin/metro/img/level1.png" height="135px" /></td>
  </tr>
  <tr>
    <td><img src="skin/metro/img/level2.png" height="135px" /></td>
  </tr>
  <tr>
    <td><img src="skin/metro/img/level3.png" height="135px" /></td>
  </tr>
  <tr>
    <td><img src="skin/metro/img/level4.png" height="135px" /></td>
  </tr>
</table>
</td>
  </tr>
</table>

                        </div>     <!--end main -->
                        <p>&nbsp;</p>
                    </div><!-- endmain-wrapper -->
             
                     <jsp:include page="../commontemplate/rightcolumn.jsp" />
                     
                </div><!-- end wrapper-3 -->
            </div><!-- end wrapper-content -->
            
            <jsp:include page="../commontemplate/footer.jsp" />
                    </div><!-- end wrapper-2 -->
    </div><!--end maincontent-wrapper-->
  <br/><br/>
</div><!-- end wrapper -->



<!-- for comfirm -->
<!-- modal content -->
		<div id='confirm'>
			<div class='header'><span>Confirm</span></div>
			<div class='message'></div>
			<div class='buttons'>
				<div class='no simplemodal-close'>No</div><div class='yes'>Yes</div>
			</div>
		</div>
		<!-- preload the images -->
<div style='display:none'>
			<img src='img/confirm/header.gif' alt='' />
			<img src='img/confirm/button.gif' alt='' />
		</div>
<!-- Load JavaScript files -->

<script type='text/javascript' src='skin/confirm/js/jquery.simplemodal.js'></script>
<script type='text/javascript' src='skin/confirm/js/confirm.js'></script>
</body></html>