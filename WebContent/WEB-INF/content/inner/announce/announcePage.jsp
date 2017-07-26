<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发布信息内容</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/announceAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function add()
	{
		document.form1.action="<%=basepath%>/announceAction_addPage.action";
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
<body onload="getMessage()">
	<input type="hidden" id="message"
		value="<s:property value="message" />" />
	<div class="ry_wrapp">
		<form id="form1" name="form1" method="post" action="">

			<div class="ry_content">
				<form>
					<div class="ry_main" cellpadding="0" cellspacing="0">
						<h2>发布信息搜索</h2>
						<table class="ry_left left">
							<tr>
								<td>录入时间：</td>
								<td>
								<input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        		<input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        		</td>
							</tr>
							<tr>
								<td>标题名称：</td>
								<td>
								<input type="text" name="condition.announceName"
									value="<s:property value = "condition.announceName"/>" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
						</table>
						<table class="ry_right left">
							<tr>
								<td><input type="image" onclick="query()"
									src="<%=basepath%>/images/ry_look.png" /></td>
								<td><input type="image" onclick="add()"
									src="<%=basepath%>/images/tianjia.png" /></td>
							</tr>
						</table>

					</div>
				</form>
				<div class="ry_liebiao">
					<p class="f16 fb">
						信息发布管理列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>发布信息标题名称</th>
								<th>发布信息种类</th>
								<th>发布时间</th>
								<th>是否发布</th>
								<th>操作</th>
							</tr>
							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="title" /></td>
									<td><s:if test="type==1">文件通知</s:if> <s:if test="type==2">公示</s:if> <s:if test="type==3">公告</s:if>
										<s:if test="type==4">延续通知</s:if> <s:if test="type==5">行政处罚</s:if>
										<s:if test="type==6">行政处理</s:if><s:if test="type==7">通报</s:if>
										<s:if test="type==8">法律</s:if><s:if test="type==9">法规</s:if></td>
									<td><s:date name="date" format="yyyy-MM-dd" /></td>
									<td><s:if test="isPublish==0">未发布</s:if> <s:if
											test="isPublish==1">已发布</s:if></td>
									<td align='center'><a
										href="announceAction_modifyPage.action?announceId=<s:property value="announceId"/>"><span
											class="lbmingx">修改</span></a>
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
