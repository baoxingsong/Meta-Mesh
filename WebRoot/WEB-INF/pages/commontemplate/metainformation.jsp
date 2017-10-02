<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<title><s:property value="webPageTitle"  escape="false"/></title>
    <link rel="stylesheet" type="text/css" href="skin/css/hibernate/stkdefault-styles.css" media="screen, projection">
    <link rel="stylesheet" type="text/css" href="skin/css/hibernate/org_common.css" media="screen, projection">
    <link rel="stylesheet" type="text/css" href="skin/css/hibernate/shstyles.css" media="screen, projection">
    <link rel="stylesheet" type="text/css" href="skin/css/hibernate/jquery-ui.css" media="screen, projection">
    <link rel="stylesheet" type="text/css" href="skin/css/hibernate/project.css" media="screen, projection">
    <link rel="stylesheet" type="text/css" href="skin/css/hibernate/clearspace_common.css" media="screen, projection">
    <link rel="stylesheet" type="text/css" href="skin/css/hibernate/wide.css" media="only screen and (min-width: 1200px)">
    <link rel="stylesheet" type="text/css" href="skin/css/hibernate/small.css" media="only screen and (max-width: 980px)">
  	<script src="skin/allinone.js" type="text/javascript"></script>

<!--this js is for dropdown list-->
<script type="text/javascript">
     // initialise Superfish
     $(document).ready(function() {
         $('ul.sf-menu').superfish({
             delay:       300,                            // one second delay on mouseout
             animation:   {opacity:'show',height:'show'},  // fade-in and slide-down animation
             speed:       'fast',                          // faster animation speed
             autoArrows:  false,                           // disable generation of arrow mark-up
             dropShadows: false                            // disable drop shadows
         });         
     }); 
</script>