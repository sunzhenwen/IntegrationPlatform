<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>随机地市</title>
<script type="text/javascript">

	//查询
	function queryArea()
	{
		var cityCode = $("#cityCode").val();
		if(cityCode == "")
		{
			alert("请选择城市!");
		}else
		{
			document.form1.action="<%=basepath%>/randomCityAction_queryArea.action";
			document.form1.submit();
		}
	}
</script>
</head>
<body>
	<div class="ry_wrapp">
		<form id="form1" name="form1" method="post" action="">

			<div class="ry_content">
				<form>
					<div class="ry_main" cellpadding="0" cellspacing="0">
						<h2>随机地市获取</h2>
						<table class="ry_left left">
						<tr>
							<td>市区：</td>
							<td>
							<select id="cityCode" name="cityCode">
									<option value="">请选择</option>
									<s:iterator value="citysList">
									<option value="<s:property value="code"/>"<s:if test='cityCode==code'>selected</s:if>><s:property value="name" /></option>
									</s:iterator>
							</select>
							</td>
							<td></td>
							<td></td>
						</tr>
						</table>
						<table class="ry_right left">
							<tr>
								<td><input type="image"
									src="<%=basepath%>/images/ry_look.png"
									onclick="queryArea()" /></td>
							</tr>
						</table>

					</div>
				</form>
				<div class="ry_liebiao">
					<p class="f16 fb">
						随机区县<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>名称</th>
							</tr>
							<tr>
								<td><s:property value="randomCity.name" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>

</body>
</html>