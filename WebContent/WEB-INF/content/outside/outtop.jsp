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
function closeSys()
{
	if(confirm("您确定要退出资质系统吗?")==true)
	{
		window.parent.location.href="<%=basepath %>/loginAction_exitSystem.action";
	}
	else
	{
		return;
	}
}

</script>
</head>	

<body >
 <%
 	Login login = (Login)session.getAttribute("login");
 %>
 <div class="nw_top" >
    <div class="head">
      <div class="head_a1">
           <p class="logonw"><img src="<%=basepath %>/images/lg.png"></p>
             <div class="head_a3">
              <div class="header-search"> 
              <a href="/">联系我们</a>|
              <a href="#" onclick="closeSys()">安全退出</a>|
			  <a href="#">当前用户：<%=login.getSpareName() %></a>
			  </div>
        </div>
    </div>
    </div>
</div>
</body>
</html>
