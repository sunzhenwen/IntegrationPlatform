<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ page import="com.tj.jst.login.model.Login" %>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>内网</title>
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

function openSys(){
	window.open('<%=basepath %>/testweb/index.html')
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
              <a href="#" onclick="openSys()">建筑监管与信息发布平台</a>|
              <a href="/">联系我们</a>|
              <a href="#" onclick="closeSys()">安全退出</a>|
			  <a href="#">当前用户：<%=login.getName() %></a>
			  </div>
        </div>
    </div>
    </div>
</div>
</body>
</html>
