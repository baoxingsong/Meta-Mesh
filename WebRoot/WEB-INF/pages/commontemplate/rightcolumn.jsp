<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>       
                    <div id="rightcolumn" class="column">
                        <div id="proj_quick-start" style="padding-top: 0px;">
                            <!-- <div style="border: 0px none;"><a href="http://www.hibernate.org/hibernate.html" style="padding: 0px;">
                                <img border="0" src="skin/hibernate_orm.gif" alt="Hibernate ORM"> </a>
                            </div>
                             -->
                        </div>
                        <div class="clear"><br></div>
                        <div id="proj_quick-start"><h3>NEWS</h3>
                        	<ul>
                        	<s:iterator value="rightNewss">
                        		<li><a href="news_content?id=<s:property value="id"/>"><s:property value="title"/></a></li>
                        	</s:iterator>
                        	</ul>
                        	<div style="float:right"><a href="news_list">MORE ... ...</a></div>
                        </div>
                        <br>
                        <div class="whitebox supported-products-vert"><h3>DOCUMENTS</h3>
                        <ul>
                        	<s:iterator value="rightDocuments">
                        		<li><a href="document_content?id=<s:property value="id"/>"  class="platform"><s:property value="title"/></a></li>
                        	</s:iterator>
                        	<div style="float:right"><a href="document_list">MORE ... ... </a></div>
                        </ul><br class="clearfix"></div>
                        <div class="clear"><br></div>
                     </div>