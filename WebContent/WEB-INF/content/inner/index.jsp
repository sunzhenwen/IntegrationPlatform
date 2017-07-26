<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>黑龙江省建筑市场一体化平台</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
</head>	
    
    <frameset rows="113,*" frameborder="no" border="0" framespacing="0" >
	   
       
       <frame src="<%=basepath %>/frameAction_top.action" scrolling="no" name="top"  noresize="noresize">
         
       
        <frameset cols="254,*" frameborder="no" border="0"  id="mainframe">
            
            
            <frame src="<%=basepath %>/frameAction_left.action" class="lframestyle"name="leftshowframe" width="100%" height="100%" scrolling="no">
            
           	
            
            <frame src="<%=basepath %>/frameAction_right.action"  noresize="noresize" name="rightshowframe" width="100%" height="100%">

       
         </frameset>
         
    </frameset>
    
    <noframes></noframes>
</html>
