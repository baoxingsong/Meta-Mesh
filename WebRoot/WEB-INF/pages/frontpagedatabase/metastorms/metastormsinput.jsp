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

<style type="text/css">
#download-builder  {font-size:10px; padding:10px 0 20px 30px;}
#download_zip {cursor: pointer; margin: 15px 0 0; width: 80px; text-align: center; font-size: 1.1em; -moz-border-radius: 6px; -webkit-border-radius: 6px; background: #222 0 50% repeat-x; color: #eee; border: 2px solid #aaa; font-weight: bold; padding: .4em 0;}
#download_zip:hover { background: #111; color: #fff;}
.focus{
	border:1px solid #00f;
	background: #ccf;
}
</style>

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
<h4>Create a new a Similar sample search result.</h4>


Structure Analysis Result Name:<s:property value="parallelMetaResult" /><br />
Structure Analysis Result ID:<s:property value="parallelMetaResult.id" /><br />
file name:<s:property value="parallelMetaResult.uploadFile.fileName" /><br />
file ID:<s:property value="parallelMetaResult.uploadFile.id" /><br />
project name:<s:property value="parallelMetaResult.uploadFile.uploadProject.randomFileName" /><br />
project ID:<s:property value="parallelMetaResult.uploadFile.uploadProject.id" /><br />
<br />
<form action="newmetastormsresultdo" method="post" enctype="multipart/form-data" name="uploard_file" target="_self">

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

<!-- 
<p>
<a title="?" href="parallel_meta.cgi?page=help#format">Group Number</a>:&nbsp;
<select name="assignGroupNumber" id="assignGroupNumber">
<option value="-1"  SELECTED>-1</option>
<option value="0" >0</option>
<option value="1" >1</option>
<option value="2" >2</option>
</select>
<br />
</p>
 -->

<input type="hidden" name="parallelMetaResultId" id="parallelMetaResultId" value="<s:property value="parallelMetaResult.id" />" />

<br />
<input type="submit" id="download_zip" value="Submit">&nbsp;<input type="reset"  id="download_zip" value="Reset">
</form>



                        
                        
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