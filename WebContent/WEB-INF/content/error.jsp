<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>错误页面</title>
<style type="text/css">
body{
	background:skyblue;}	
.wrap{
	margin:0 auto;
	padding-top:50px;
	
	}
.logo h1{
	font-size:50px;
	color:yellow;
	text-align:center;
	margin-bottom:1px;
	text-shadow:1px 1px 6px #555;
	}	
.logo p{
	color:white;
	font-size:20px;
	text-align:center;
	
	}	
.sub{ margin:0 auto;text-align:center; padding-top:20px;}
.sub span{
	color:lightgreen;
	text-align:center;
	}	
.sub span:hover{color:#66FFCC; }
	
.sub a{
	color:yellow;
	background:#06afd8;
	text-decoration:none;
	padding:10px 26px;
	font-size:14px;
	font-weight:bold;
	text-align:center;
	
	}		
</style>
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
<body>
	<div class="wrap">
		<div class="logo">
		  <h1>亲爱的用户</h1>
		  <p>您的操作失败了...!<s:property value="exception.message" />!请联系系统管理员!</p>
		   <div class="sub">
		    <a href="#" onclick="closeSys()"><span>退出</span></a>
		    </div>
		</div>
	</div>
	
</body>
</html>