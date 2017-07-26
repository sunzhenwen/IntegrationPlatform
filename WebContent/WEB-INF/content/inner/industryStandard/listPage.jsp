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
		document.form1.action="<%=basepath%>/industryStandardAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function add()
	{
		document.form1.action="<%=basepath%>/industryStandardAction_addPage.action";
		document.form1.submit();
	}


</script>
</head>
<body>
	<div class="ry_wrapp">
		<form id="form1" name="form1" method="post" action="">

			<div class="ry_content">
				<form>
					<div class="ry_main" cellpadding="0" cellspacing="0">
						<h2>发布信息搜索</h2>
						<table class="ry_left left">
							<tr>
								<td>录入时间：</td>
								<td colspan="3">
								<input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        		<input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        		</td>
							</tr>
							<tr>
								<td>标题名称：</td>
								<td>
								<input type="text" name="condition.title" value="<s:property value = "condition.title"/>" />
								</td>
								<td>行业分类：</td>
								<td>
								<select name="condition.isType">
		    						<option value="">请选择</option>
		      						<s:iterator value="isTypes">
		          						<option value="<s:property value="code"/>"<s:if test='condition.isType==code'>selected</s:if>><s:property value="name"/></option>
		      						</s:iterator>
								</select>
								</td>
							</tr>
							<tr>
								<td>是否发布：</td>
								<td>
								<select name="condition.isPublish">
			   						<option value="">请选择</option>
			     						<s:iterator value="isPublishs">
			         						<option value="<s:property value="code"/>"<s:if test='condition.isPublish==code'>selected</s:if>><s:property value="name"/></option>
			     						</s:iterator>
								</select>
								</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
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
						行业标准列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>标题名称</th>
								<th>行业分类</th>
								<th>录入时间</th>
								<th>是否发布</th>
								<th>操作</th>
							</tr>
							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="title" /></td>
									<td>
									<s:if test="isType==1">勘察设计类</s:if>
									<s:if test="isType==2">建筑业企业类</s:if>
									<s:if test="isType==3">工程监理类</s:if>
									<s:if test="isType==4">工程招标代理类</s:if>
									<s:if test="isType==5">实际施工一体化类</s:if>
									<s:if test="isType==6">注册人员类</s:if> 
									</td>
									<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
									<td>
									<s:if test="isPublish==0">已发布</s:if> 
									<s:if test="isPublish==1">未发布</s:if>
									</td>
									<td align='center'>
									<a href="industryStandardAction_modifyPage.action?isId=<s:property value="isId"/>">
									<span class="lbmingx">修改</span></a>
									<a href="industryStandardAction_delete.action?isId=<s:property value="isId"/>">
									<span class="lbmingx">删除</span></a>
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
