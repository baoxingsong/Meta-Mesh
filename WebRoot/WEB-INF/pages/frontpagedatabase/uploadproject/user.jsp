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

<script language="javascript" type="text/javascript">
function confirmDelete()
{
	//alert(arguments[0]);
	if (confirm("Do you want to remove " + arguments[1] + "?"))  {  
		location.href='removeuploadfile?uploadFileId='+arguments[0];
	}  else  { 
		
	};
}

function confirmDeleteProject()
{
	if (confirm("Do you want to remove " + arguments[1] + "?"))  {  
		location.href='removeuploadproject?uploadProjectId='+arguments[0];
	}  else  { 
		
	};
}
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
                        <h4>Hello, <s:property value="user.userName" />, welcome to Meta-BLAST.</h4>
                        <br />
                        <br />
                        

                        <s:if test="user.uploadProjects.size>0">
                        <h5>Your project list</h5> <br />
                         <div id="sidetree">
						<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>
						<ul id="tree">
                        	<s:iterator value="user.uploadProjects">
                        		<li><span style="color:#f50;font-weight:bold"><s:property value="randomFileName" /></span> create time: <s:property value="%{getText('global.date',{createTime})}"/> &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:confirmDeleteProject('<s:property value="id" />','<s:property value="randomFileName" />');">remove</a>&nbsp;&nbsp;&nbsp;<a href="#" rel="projectcomment?uploadProjectId=<s:property value="id" />"><b>NOTE</</b></a> <br />
                        		<s:if test="uploadFiles.size>0">
                        			<ul>
                        			<s:iterator value="uploadFiles">
                        				<li><s:if test="complete==0">We are busy doing <a><em><s:property value="fileName" /></em></a></s:if><s:else><a href="uploadfile?uploadFileId=<s:property value="id" />">View result of <em><s:property value="fileName" /></em></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:confirmDelete('<s:property value="id" />','<s:property value="fileName" />');">remove</a>&nbsp;&nbsp;&nbsp;<a href="#" rel="filecomment?uploadFileId=<s:property value="id" />"><b>NOTE</</b></a></s:else></li>
                        			</s:iterator>
                        			</ul>
                        		</s:if>
                        		</li>
                       		</s:iterator>
                       	</ul>
						</div>
                        </s:if>

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