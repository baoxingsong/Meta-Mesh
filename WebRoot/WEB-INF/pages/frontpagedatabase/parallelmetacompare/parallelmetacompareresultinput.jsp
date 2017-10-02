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
<script type="text/javascript">
		$(function() {
			$("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
		})
</script>


<link rel="stylesheet" type="text/css" href="http://craigsworks.com/projects/qtip2/packages/latest/jquery.qtip.min.css" />
<!--JavaScript - Might want to move these to the footer of the page to prevent blocking-->
<script type="text/javascript" src="http://craigsworks.com/projects/qtip2/packages/latest/jquery.qtip.min.js"></script>

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
<h4>Create a new a Parallel-META result.</h4>
file name:<s:property value="uploadFIle.fileName" /><br />
file ID:<s:property value="uploadFIle.id" /><br />
project name:<s:property value="uploadFIle.uploadProject.randomFileName" /><br />
project ID:<s:property value="uploadFIle.uploadProject.id" /><br />
<br />
<form action="newparallelmetacompareresultdo" method="post" enctype="multipart/form-data" name="uploard_file" target="_self">

<p id ="lll">
<a title="?" href="parallel_meta.cgi?page=help#length">LENGTH</a>:&nbsp;
<input name="parallelMetaResultIds" id="parallelMetaResultIds" type="text" value="0" size="20" maxlength="3" />
<input name="parallelMetaResultIds" id="parallelMetaResultIds" type="text" value="0" size="20" maxlength="3" />

<br />
</p>

<input type="submit">&nbsp;<input type="reset">



                        
                        
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

<script class="example" type="text/javascript">
// Create the tooltips only on document load
$(document).ready(function()
{
	// Make sure to only match links to wikipedia with a rel tag
	$('a[href*="#"][rel]').each(function()
	{
		// We make use of the .each() loop to gain access to each element via the "this" keyword...
		$(this).qtip(
		{
			content: {
				// Set the text to an image HTML string with the correct src URL to the loading image you want to use
				text: '<img class="throbber" src="/projects/qtip/images/throbber.gif" alt="Loading..." />',
				ajax: {
					url: $(this).attr('rel') // Use the rel attribute of each element for the url to load
				},
				title: {
					text: '' + $(this).text(), // Give the tooltip a title using each elements text
					button: true
				}
			},
			position: {
				at: 'bottom center', // Position the tooltip above the link
				my: 'top center',
				viewport: $(window), // Keep the tooltip on-screen at all times
				effect: false // Disable positioning animation
			},
			show: {
				event: 'click',
				solo: true // Only show one tooltip at a time
			},
			hide: 'unfocus',
			style: {
				classes: 'ui-tooltip-wiki ui-tooltip-light ui-tooltip-shadow'
			}
		})
	})

	// Make sure it doesn't follow the link when we click it
	.click(function(event) { event.preventDefault(); });
});
</script>

</body></html>