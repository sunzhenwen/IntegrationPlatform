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
<title>����ҳ��</title>
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
//2013-07-02 ��ȡ�����壬ʵ��ҳ����ת
function re(){
	window.parent.location.href="login!reChange.action";
}
function closeSys()
{
	if(confirm("��ȷ��Ҫ�˳�����ϵͳ��?")==true)
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
		  <h1>�װ����û�</h1>
		  <p>���Ĳ���ʧ����...!<s:property value="exception.message" />!����ϵϵͳ����Ա!</p>
		   <div class="sub">
		    <a href="#" onclick="closeSys()"><span>�˳�</span></a>
		    </div>
		</div>
	</div>
	
</body>
</html>