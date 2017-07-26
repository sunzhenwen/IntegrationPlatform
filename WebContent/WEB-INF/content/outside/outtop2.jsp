<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.tj.jst.login.model.Login" %>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外网</title>
<%
	//取得当前Web应用的名称
	String basepath = request.getContextPath();
%>
<script type="text/javascript" src="<%=basepath%>/js/My97/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/jquery/jquery.metadata.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/jquery/messages_cn.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/checkbox/checkbox.js"></script>
<link rel="stylesheet" href="<%=basepath%>/css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basepath%>/css/public.css" type="text/css" >
<script language="javascript">
//2013-07-02 获取父窗体，实现页面跳转
function re(){
	window.parent.location.href="login!reChange.action";
}


</script>
</head>	

<body >
 <%
 	Login login = (Login)session.getAttribute("login");
 	String provinceNum = (String)session.getAttribute("provinceNum");
 %>
</body>
</html>
