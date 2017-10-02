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
function change_database(){
	if(document.getElementById("database").value == 'gg'){
		document.getElementById("phylogeneticanalysis").value = 'T';
		document.getElementById("phylogeneticanalysis").disabled=false;
	}
	else{
		document.getElementById("phylogeneticanalysis").value = 'F';
		document.getElementById("phylogeneticanalysis").disabled=true;
	}
}

function change_type(){
	if(document.getElementById("type").value == 'm'){
		document.getElementById("llvalue").value = '0';
		document.getElementById("lll").style.display="block";
	}
	else{
		document.getElementById("llvalue").value = '0';
		document.getElementById("lll").style.display="none";		
	}
}
</script>
<style type="text/css">
#download-builder  {font-size:10px; padding:10px 0 20px 30px;}
#download_zip {cursor: pointer; margin: 15px 0 0; width: 80px; text-align: center; font-size: 1.1em; -moz-border-radius: 6px; -webkit-border-radius: 6px; background: #222 0 50% repeat-x; color: #eee; border: 2px solid #aaa; font-weight: bold; padding: .4em 0;}
#download_zip:hover { background: #111; color: #fff;}
.focus{
	border:1px solid #00f;
	background: #ccf;
}
</style>

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
<form action="newparallelaction?uploadFileId=<s:property value="uploadFIle.id" />" method="post" name="uploard_file" target="_self">
<a title="?" href="document_content?id=2#type">TYPE</a>:&nbsp;
<select name="type" onChange="change_type();" id="type">
<option value="m">SHOTGUN</option>
<option value="r">16S</option>
</select>
<br />
</p>
<p>
<a title="?" href="document_content?id=2#format">FORMAT</a>:&nbsp;
<select name="format" id="format">
<option value="F"  SELECTED>FASTA</option>
<option value="Q">FASTQ</option>
</select>
<br />
</p>
<p id ="lll">
<a title="?" href="document_content?id=2#length">LENGTH</a>:&nbsp;
<input name="length" id="llvalue" type="text" value="0" size="20" maxlength="3" />
<br />
</p>
<p>
<a title="?" href="document_content?id=2#database">DATABASE</a>:&nbsp;
<select name="database" onChange="change_database();" id="database">
<option value="g" SELECTED>GreenGenes</option>
<option value="r">RDP</option>
<option value="s">Sliva</option>
<option value="o">Oral_Core</option>
</select>
<br />
</p>

<p>
<a title="?" href="document_content?id=2#domainsample">DOMAINSAMPLE</a>:&nbsp;
<select name="domainsample" id="domainsample">
<option value="B" SELECTED>Bacteria</option>
<option value="E">Eukaryota</option>
</select>
<br />
</p>

<p>
<a title="?" href="document_content?id=2#evalue">EVALUE</a>:&nbsp;
<select name="evalue">
<option value="1e-10">1e-10</option>
<option value="1e-20">1e-20</option>
<option value="1e-30" SELECTED>1e-30</option>
</select>
<br />
</p>


<p>
<a title="?" href="document_content?id=2#phylogenticanalysis">PHYLOGENETIC ANALYSIS</a>:&nbsp;
<select name="phylogeneticanalysis" id="phylogeneticanalysis">
<option value="T"  SELECTED>True</option>
<option value="F">False</option>
</select>
<br />
</p>
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