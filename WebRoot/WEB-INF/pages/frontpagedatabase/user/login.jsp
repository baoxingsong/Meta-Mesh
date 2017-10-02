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
<script type="text/javascript" src="skin/js/metaseeUtil.js"></script>
<script type="text/javascript" src="skin/js/jquery.query.js"></script>
<style type="text/css">
#download-builder  {font-size:10px; padding:10px 0 20px 30px;}
#download_zip {cursor: pointer; margin: 15px 0 0; width: 80px; text-align: center; font-size: 1.1em; -moz-border-radius: 6px; -webkit-border-radius: 6px; background: #222 0 50% repeat-x; color: #eee; border: 2px solid #aaa; font-weight: bold; padding: .4em 0;}
#download_zip:hover { background: #111; color: #fff;}
.focus{
	border:1px solid #00f;
	background: #ccf;
}
</style>

<script type="text/javascript">
	$(function(){
		$(":input").focus(function(){
			$(this).addClass("focus");
		}).blur(function(){
			$(this).removeClass("focus");
		});
		var sourceurl=$.query.get('sourceurl');
		$("#sourceurl").val(sourceurl);
	})
</script>

</head>
  
<body id="project" class="col-float3 rightcol-layout" onLoad=metaseechangeImage();>

<div id="wrapper">
    <div id="maincontent-wrapper">
    <jsp:include page="../../commontemplate/header.jsp" />

        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
                    
                
                        <div id="main">
 
<span style="color:#f00;weight:folder"><s:property value="message"/> </span>


<s:fielderror/>

<form action="user/login" method="post">
<table>
   <tr>
      <td>Username:</td>
      <td><input type="text" name="username"></td>
   </tr>
   <tr>
      <td>Password:</td>
      <td><input type="password" name="password1"></td>
   </tr>
   <tr>
	<td>CheckCode:</td>
      <td><img id="imgRandom" src="user/imginput" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:metaseechangeImage();">refresh check code</a></td>
	</tr>
   <tr>
	<td>Please input the check code:</td>
      <td><input type="text" name="checkcode" value=""></input></td>
   </tr>
   <tr><div id="download-builder">
      <td align="center"></td>
      <td align="center"><input type="submit" id="download_zip" value="Log in">&nbsp;&nbsp;<input type="reset" id="download_zip" value="Reset"></td></div>
   </tr>
</table>
<input type="hidden" name="sourceurl" id="sourceurl" />
<div>Still don't have an account? Please <a href="user/registerinput">register</a>.</div>
<div>Forget your username or password? Please <a href="user/findpasswordinput">find your account back</a>.</div>
<div>Your account was still not activated? Please <a href="user/resendactivityemailinput">resend activity email</a>.</div>
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
</body></html>