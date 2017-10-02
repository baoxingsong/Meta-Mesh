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
<script src="skin/allinone.js" type="text/javascript"></script>
<style type="text/css">
#fileQueue {
	width: 400px;
	height: 300px;
	overflow: auto;
	border: 1px solid #E5E5E5;
	margin-bottom: 10px;
}
</style>

<link href="skin/css/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="skin/js/uploadify/swfobject.js"></script>
<script type="text/javascript"	src="skin/js/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="skin/js/jquery.chained.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	var fileNameHash=new Hashtable();
	var uploadhiddenfile="";

	$(document).ready(function() {
		$('#fileInput').uploadify( {
			'uploader' : 'skin/js/uploadify/uploadify.swf',
			'script' : 'uploadFile?savePath=<s:property value="randomFilename"/>___<%=session.getAttribute("username")%>___<s:property value="workShopProject"/>',  
			'folder' : 'upldaoad',
			'cancelImg' : 'skin/img/uploadify/cancel.png',
			'fileDataName' : 'fileInput', //和input的name属性值保持一致就好，Struts2就能处理了   
			'auto' : true,//是否选取文件后自动上传   
			'multi' : true,//是否支持多文件上传 
			'simUploadLimit' :3,//一次同步上传的文件数目   
			'queueSizeLimit':3,
			'sizeLimit' :1024000000, //单位为字节
				'onError' : function(event, ID, fileObj, errorObj) {
					if (errorObj.type == "File Size") {
						alert('You are trying to upload a too large file, and you are recommended to upload it with our data management client!');
						$('#fileInput').uploadifyClearQueue(ID);
					}
				},
				
				'onQueueFull': function(event,data) {  
					alert("you can upload at most 5 files at one time");
				},
    		 
				'onComplete': function(event, queueID, fileObj, response, data) {
					fileAddFile(queueID,fileObj.name);
					updateUploadHiddenFile();
					$('#rawUploadFiles').val(uploadhiddenfile);
					setsubmitabled(uploadhiddenfile);
				},
				
				'onCancel': function(event, queueID, fileObj, data) {
					cancleFile(queueID);
					updateUploadHiddenFile();
					$('#rawUploadFiles').val(uploadhiddenfile);
				}
		});
	});
	
function cancleFile(queueID){
	if(queueID){
		if(fileNameHash.contains(queueID)){
			fileNameHash.remove(queueID);
		}
	}
}

function fileAddFile(queueID,filename){
	if(filename && queueID){
		if(fileNameHash.contains(filename)){
			alert(filename);
			return;
		}else{
			fileNameHash.add(queueID,filename);
		}
	}
}

function updateUploadHiddenFile(){
	uploadhiddenfile="";
	for(var k in fileNameHash._hash){
		uploadhiddenfile+=fileNameHash.items(k)+"__SeeMetaSee__";
	}
}

function setsubmitabled() {
	var b = new Object();
	b = document.getElementById("submit");
	b.disabled = false;
}

function Hashtable()
{
    this._hash = new Object();  
	this.add = function(key,value){
                if(typeof(key)!="undefined"){
                    if(this.contains(key)==false){
                          this._hash[key]=typeof(value)=="undefined"?null:value;
                          return true;
                    } else {
                           return false;
                    }
                } else {
                          return false;
                }
            }
    this.remove = function(key){delete this._hash[key];}
    this.count = function(){var i=0;for(var k in this._hash){i++;} return i;}
    this.items = function(key){return this._hash[key];}
    this.contains  = function(key){ return typeof(this._hash[key])!= "undefined";}
    this.clear = function(){for(var k in this._hash){delete this._hash[k];}}
}

</script>
</head>
<body>
        <div id="wrapper-2">
            <div id="wrap-content">
                <div id="wrapper-3">
                    <div id="main-wrapper">
                        <div id="main">
	<span style="color:#f00"><s:property value="message"/></span>
	<br />
	
		<input type="file" name="fileInput" id="fileInput" />
		<br /><!-- 
		randomFilename : <s:property value="randomFilename"/>
		workShopProject : <s:property value="workShopProject"/> -->
</body></html>
