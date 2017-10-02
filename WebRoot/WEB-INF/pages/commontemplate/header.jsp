<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
        <div id="top_subnav_branding">
        	<div id="banner"><img src="skin/img/banner.png" onerror="this.style.display=&#39;none&#39;"></div>
            <div id="proj_nav" class="">
                <ul class="sf-menu sf-js-enabled">
                    <li class="open">
                        <span class="notch">&nbsp;</span>
                        <a href="index" class="menu-title">Home</a>
                 
                    </li>
                    <li class="open"><span class="notch">&nbsp;</span><a href="metadata_list" class="menu-title">Project List</a></li>
                    <li class="open"><span class="notch">&nbsp;</span><a href="map_view" class="menu-title">Map</a></li>                    
                	
                	
                    
                    <s:if test="#session['username']!=null && #session['userid']!=null">
                    <li class="open"><span class="notch">&nbsp;</span><a href="user">Work Center</a>
                     <ul class="level1" style="display: none; visibility: hidden; ">
                     	<li class="open"><a href="user">Work Center</a></li>
                     	<li class="open"><a href="upload.action" class="menu-title">Upload Your Data</a></li>
                     </ul>
                    </li>
                     <li class="open"><span class="notch">&nbsp;</span><a>Control Panel</a>
                     <ul class="level1" style="display: none; visibility: hidden; ">
                     	<li class="open"><a href="user/changePassword">Change Password</a></li>
                     	<li class="open"><a href="user/logout">Log Out</a></li>
                     </ul>
                     
                    </li></s:if>
                    <s:else><li class="open"><span class="notch">&nbsp;</span><a style="float:left" href="user/logininput">login</a></li>
                    <li class="open"><a>/</a></li><li class="open"><a style="float:left" href="user/registerinput">register</a></li></s:else>
                    
                    <li class="open"><span class="notch">&nbsp;</span><a href="article_content?keyWord=download" target="_blank">Download</a>
                    	<ul class="level1" style="display: none; visibility: hidden; ">
                    		<li class="open"><a href="article_content?keyWord=download" class="menu-title">Download</a></li>
                    		<li class="open"><a href="article_content?keyWord=Meta-Mesh%20Data%20Manager" class="menu-title">Meta-Mesh Data Manager</a></li>
                    	</ul>
                    </li>
                   	
                    <li class="open"><span class="notch">&nbsp;</span><a href="news_list" class="menu-title"><s:text name="newspage"/></a></li>
                    
                    <li class="open"><span class="notch">&nbsp;</span><a>Help</a>
                    	<ul class="level1" style="display: none; visibility: hidden; ">
                    		<li class="open"><a href="document_list" class="menu-title">Document</a></li>
                    		<li class="open"><a href="wiki_list" class="menu-title"><s:text name="wikipage"/></a></li>
                    		<li class="open"><a href="article_content?keyWord=faq">FAQ</a></li>
                    	</ul>
                    </li>
                    	
                	
                	<li class="open"><span class="notch">&nbsp;</span><a href="article_content?keyWord=about us">About Us</a>
                     <ul class="level1" style="display: none; visibility: hidden; ">
                     	<li class="open"><a href="article_content?keyWord=about us">About Us</a></li>
                     	<li class="open"><a href="article_content?keyWord=contact us">Contact Us</a></li>
                     	<li class="open"><a href="article_content?keyWord=facility">Facility</a></li>
                     	<li class="open"><a href="article_content?keyWord=publication">Publication</a></li>
                     </ul>
                    </li>
                </ul>
            </div>
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        