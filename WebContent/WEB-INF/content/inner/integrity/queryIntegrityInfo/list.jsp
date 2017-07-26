<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>诚信信息查询</title>
<script type="text/javascript">
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/personGoodIntegrityAction_queryPage.action";
		document.form1.submit();
	}
	
	//增加
	function add()
	{
		document.form1.action="<%=basepath%>/personGoodIntegrityAction_addPage.action";
		document.form1.submit();
	}

	//操作提示信息
	function getMessage() {
		var message = document.getElementById("message").value;
		if (message != "") {
			alert(message);
		}
	}
</script>
</head>

<body>
	<div class="ry_wrapp">
		<form id="form1" name="form1" method="post" action="" >
           <table cellpadding="0" cellspacing="0" class="nw-qycxlh">
            <tr>
				<td align='center'><img src="images/lhqy.jpg" /></td>
				<td align='center'><img src="images/blqy.jpg" /></td>
				<td align='center'><img src="images/ryqy.jpg" /></td>
				<td align='center'><img src="images/ryblqy.jpg" /></td>
			</tr>
            
			<tr>
				<td align='center' class="qycxan"><a href="corpBadIntegrityAction_queryInfoPage.action">企业良好信息查询</a></td>
				<td align='center' class="qycxblan"><a href="corpBadIntegrityAction_queryInfoPage.action" >
				企业不良信息查询</a></td>
				<td align='center' class="qycxan"><a href="personGoodIntegrityAction_queryInfoPage.action">
				人员良好信息查询</a></td>
				<td align='center' class="qycxblan"><a href="personBadIntegrityAction_queryInfoPage.action">
				人员不良信息查询</a></td>
			</tr>
            </table>
		</form>
	</div>
</body>

		