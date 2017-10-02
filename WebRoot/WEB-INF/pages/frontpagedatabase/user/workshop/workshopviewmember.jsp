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
<jsp:include page="../../../commontemplate/metainformation.jsp" />

<link rel="stylesheet" href="skin/css/jquery.treeview.css" />
<style type="text/css">
body {
	font-family: Verdana, helvetica, arial, sans-serif;
	font-size: 68.75%;
	background: #fff;
	color: #333;
}
#download-builder  {font-size:10px; padding:10px 0 20px 30px;}
#download_zip {cursor: pointer; margin: 15px 0 0; width: 80px; text-align: center; font-size: 1.1em; -moz-border-radius: 6px; -webkit-border-radius: 6px; background: #222 0 50% repeat-x; color: #eee; border: 2px solid #aaa; font-weight: bold; padding: .4em 0;}
#download_zip:hover { background: #111; color: #fff;}
.focus{
	border:1px solid #00f;
	background: #ccf;
}
.centitle{
width:66%;
background:#5a666c;
color:#bcae79;
font-size:12px;
height:20px;
padding-left:10px;
line-height:20px;
}
</style>

<script src="skin/js/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {
	$("#tree").treeview({
		collapsed: true,
		animated: "medium",
		control:"#sidetreecontrol",
		persist: "location"
	});
	$("#tree2").treeview({
		collapsed: true,
		animated: "medium",
		control:"#sidetreecontrol2",
		persist: "location"
	});
	$("#tree3").treeview({
		collapsed: true,
		animated: "medium",
		control:"#sidetreecontrol3",
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

function confirmDeleteParallelMetaResult()
{
	if (confirm("Do you want to remove " + arguments[1] + "?"))  {  
		location.href='removeparallelmetaresult?parallelMetaResultId='+arguments[0];
	}  else  { 
		
	};
}
function metastormscompare(){
	form = document.forms[1];
	form.action = "metastormscompareresultdo";
	form.submit();
}
</script>

<link rel="stylesheet" type="text/css" href="http://craigsworks.com/projects/qtip2/packages/latest/jquery.qtip.min.css" />
<!--JavaScript - Might want to move these to the footer of the page to prevent blocking-->
<script type="text/javascript" src="http://craigsworks.com/projects/qtip2/packages/latest/jquery.qtip.min.js"></script>

</head>
  
<body id="project" class="col-float3 rightcol-layout" >
<div id="wrapper">
    <div id="maincontent-wrapper">
    <jsp:include page="../../../commontemplate/header.jsp" />

        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
						
                        <div id="main" style="width:100%">
                        <h4>Work Shop <s:property value="workShop.name"/>, created by <s:property value="workShop.owner.userName"/></h4>
                        <span style="width:100%; text-align:left; float:left">More help information can be found in <a href="document_content?id=16" target="_blank" style="font-size:16px; font-weight:bold;">Document</a>.</span>
                        
                        <span style="color:#f00;weight:folder"><s:property value="message"/><br /></span>
                        <p>&nbsp;</p>
                        <div class="centitle">Shared by (Work Groups):</div>
                        <s:if test="shareedByWorkGroups.size>0">
	                        <s:iterator value="shareedByWorkGroups">
	                        	<ol>
	                        	<li>Work Group <em><s:property value="name"/></em> created by <em><s:property value="owner.userName"/></em></li>
	                        	</ol>
	                        </s:iterator>
                        </s:if>
                        	
                        <br />
                        <s:if test="workShop.uploadProjects.size>0">
                        <div class="centitle">Project list:</div><br/>
                         <div id="sidetree">
						<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>
						<ul id="tree">
                        	<s:iterator value="workShop.uploadProjects">
                        		<li><span style="color:#f50;font-weight:bold"><s:property value="randomFileName" /></span> create time: <s:property value="%{getText('global.date',{createTime})}"/> &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" rel="projectcomment?uploadProjectId=<s:property value="id" />"><b>NOTE</b></a> <br />
                        		<s:if test="uploadFiles.size>0">
                        			<ul>
                        			<s:iterator value="uploadFiles">
                        				<li><a href="getUploadfile?uploadFileId=<s:property value="id" />">View file <em><s:property value="fileName" /></em></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" rel="getfilecomment?uploadFileId=<s:property value="id" />"><b>NOTE</b></a>
                        					<s:if test="parallelMetaResults.size>0">
                        					<ul>
                        					<s:iterator value="parallelMetaResults">
                        						<li><a name="<s:property value="id"/>" id="<s:property value="id"/>"></a><s:if test="error==1"><span style="color:#f00">ERROR</span>&nbsp;&nbsp;&nbsp;</s:if><s:elseif test="complete==0">We are doing it!&nbsp;&nbsp;&nbsp;</s:elseif><s:property value="toStringName" /><s:else>&nbsp;&nbsp;<a href="getparallelresult?parallelMetaResultId=<s:property value="id" />">view the result</a>&nbsp;&nbsp;&nbsp;&nbsp;</s:else>&nbsp;&nbsp;&nbsp;<a href="parallelmetaprogress?parallelMetaResultId=<s:property value="id" />" target="_blank">LOG</a>&nbsp;&nbsp;&nbsp;<a href="#" rel="parallelmetacomment?parallelMetaResultId=<s:property value="id" />"><b>NOTE</b></a>
                        							<s:if test="metaStormsResults.size>0">
                        							<ul>
                        							<s:iterator value="metaStormsResults">
														<li><s:if test="error==1"><span style="color:#f00">ERROR</span>&nbsp;&nbsp;&nbsp;</s:if><s:elseif test="complete==0">We are doing it!&nbsp;&nbsp;&nbsp;</s:elseif><s:property value="toStringName" /><s:else>&nbsp;&nbsp;&nbsp;&nbsp;<a href="getmetastormresult?metaStormsResultId=<s:property value="id" />">view the result</a></s:else>&nbsp;&nbsp;&nbsp;<a href="#" rel="metastormscomment?metaStormsResultId=<s:property value="id" />"><b>NOTE</b></a></li>
													</s:iterator>
													</ul>
													</s:if>
												</li>
                        					</s:iterator>
                        					</ul>
                        					</s:if>
                        				</li>
                        			</s:iterator>
                        			</ul>
                        		</s:if>
                        		</li>
                       		</s:iterator>
                       	</ul>
						</div>
						
                        </s:if><s:else>
                        	<div style="font-size:20px">Did not upload any data!</div>
                        </s:else>
                        
                        <s:if test="workShop.parallelMetaCompareResults.size>0">
                        	<br /><br />
                        	<div class="centitle">Multiple metagenome sample combine results list:</div><br/>
                        	<div id="sidetree">
							<div id="sidetreecontrol2"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>
                        	<ul id="tree2" class="treeview">
                        	<s:iterator value="workShop.parallelMetaCompareResults">
                        		<li>
                        			<s:if test="1==songChecked"><s:property value="frontFaceName"/><s:property value="id"/> <s:if test="error==1"><span style="color:#f00">ERROR</span></s:if><s:elseif test="complete==0">We are doing it</s:elseif><s:else> <a href="parallelmetacompareview?parallelMetaCompareResultId=<s:property value="id"/>" target="_blank">View</a> <a href="parallelmetacomparedownload?id=<s:property value="id"/>">DownLoad</a> </s:else> <a href="#" rel="parallelmetacomparecomment?parallelMetaCompareResultId=<s:property value="id"/>">NOTE</a>
	                        			<s:iterator value="parallelMetaResults">
	                        			<ul>
	                        				<s:if test="1==songChecked"> <li><a href="getparallelresult?parallelMetaResultId=<s:property value="id"/>"><s:property value="toStringName"/></a></li></s:if>
	                        			</ul>
	                        			</s:iterator>
	                        		</s:if>
                        		</li>
                        	</s:iterator>
                        	</ul>
                        	</div>
                        </s:if>
                        
                        <s:if test="workShop.metaStormsCompareResults.size>0">
                        	<br /><br />
                        	<div class="centitle">Multiple metagenome sample compare results list:</div><br/>
                        	<div id="sidetree">
							<div id="sidetreecontrol3"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>
                        	<ul id="tree3" class="treeview">
                        	<s:iterator value="workShop.metaStormsCompareResults">
                        		<li>
                        			<s:if test="1==songChecked"><s:property value="frontFaceName"/><s:property value="id"/> <s:if test="error==1"><span style="color:#f00">ERROR</span></s:if><s:elseif test="complete==0">We are doing it</s:elseif><s:else> <a href="metastormscompareview?id=<s:property value="id"/>" target="_blank">View</a> <a href="metastormscomparedownload?id=<s:property value="id"/>">DownLoad</a></s:else> <a href="#" rel="metastormscomparecomment?id=<s:property value="id"/>">NOTE</a>
	                        			<s:iterator value="parallelMetaResults">
	                        			<ul>
	                        				<s:if test="1==songChecked"> <li><a href="getparallelresult?parallelMetaResultId=<s:property value="id"/>"><s:property value="toStringName"/></a></li></s:if>
	                        			</ul>
	                        			</s:iterator>
                        			</s:if>
                        		</li>
                        	</s:iterator>
                        	</ul>
                        	</div>
                        </s:if>
                        

                            <div class="clear"><br></div>
                        </div>     <!--end main -->
                    </div><!-- endmain-wrapper -->
             
                   
                     
                </div><!-- end wrapper-3 -->
            </div><!-- end wrapper-content -->
            
            <jsp:include page="../../../commontemplate/footer.jsp" />
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