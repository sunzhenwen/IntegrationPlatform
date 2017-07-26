<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>随机项目</title>
<script type="text/javascript">

	//查询
	function queryProject()
	{
		var cityCode = $("#cityCode").val();
		if(cityCode == "")
		{
			alert("请选择城市!");
		}else
		{
			document.form1.action="<%=basepath%>/randomProjectAction_queryProject.action";
			document.form1.submit();
		}
	}
	
	//查询区
	function queryArea() {
		var cityCode = $("#cityCode").val();
		if(cityCode != "")
		{
			$(document).ready(
				function() {
					//获取部门下拉列表的值
					var cityCode = $("#cityCode").val();
					$.ajax({
						url : 'randomProjectAction_queryArea.action',
						type : 'post',
						dataType : 'json',
						data : 'cityCode=' + cityCode,
						success : function(data) {
							//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
							var items = eval("(" + data + ")");
							//循环items,i为循环下标,(默认i从0开始取值)
							$("#areaCode").empty();
							var area = '<s:property value="areaCode"/>';
							$("#areaCode").append(
									"<option value='' >请选择</option>");
							$.each(items, function(i) {

								if (items[i].code == area) {
									$("#areaCode").append(
											"<option value='" + items[i].code+ "' selected >"
													+ items[i].name
													+ "</option>");
								} else {
									$("#areaCode").append(
											"<option value='" + items[i].code+ "' >"
													+ items[i].name
													+ "</option>");
								}
							});
						}
					});
				}
			);
		}
	}
</script>
</head>
<body onload="queryArea()">
	<div class="ry_wrapp">
		<form id="form1" name="form1" method="post" action="">

			<div class="ry_content">
				<form>
					<div class="ry_main" cellpadding="0" cellspacing="0">
						<h2>随机项目获取</h2>
						<table class="ry_left left">
						<tr>
							<td>市区：</td>
							<td>
							<select id="cityCode" name="cityCode" onchange="queryArea()">
									<option value="">请选择</option>
									<s:iterator value="citysList">
									<option value="<s:property value="code"/>"<s:if test='cityCode==code'>selected</s:if>><s:property value="name" /></option>
									</s:iterator>
							</select>
							</td>
							<td>区县：</td>
							<td>
							<select id="areaCode" name="areaCode">
									<option value="">请选择</option>
							</select>
							</td>
						</tr>
						</table>
						<table class="ry_right left">
							<tr>
								<td><input type="image"
									src="<%=basepath%>/images/ry_look.png"
									onclick="queryProject()" /></td>
							</tr>
						</table>

					</div>
				</form>
				<div class="ry_liebiao">
					<p class="f16 fb">
						随机项目<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>项目编号</th>
								<th>项目名称</th>
								<th>项目报建地</th>
							</tr>
							<s:iterator status="i" value="randomProjects" > 
							<tr>
								<td><s:property value="#i.count"/> </td>
								<td><s:property value="prjNum" /></td>
								<td><s:property value="prjName" /></td>
								<td><s:property value="appDeptName" /></td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>

</body>
</html>