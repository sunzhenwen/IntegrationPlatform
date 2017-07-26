<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//查询
	function queryConstructor()
	{
		document.form1.action="<%=basepath %>/otherConstructorAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/otherConstructorAction_goBack.action";
		document.form1.submit();
	}
	
	//导入数据
	function leadingIn()
	{
		document.form1.action="<%=basepath %>/otherConstructorAction_loadPage.action";
		document.form1.submit();
	}
	
	//添加
	function add()
	{
		document.form1.action="<%=basepath%>/otherConstructorAction_addPage.action";
		document.form1.submit();
	}

</script>
</head>

<body>
	<div class="ry_wrapp">
		<div class="head">
			<input type="hidden" id="message" value="<s:property value="message" />" />
			<div class="head_a1">
				<p class="logo">
					<img src="images/lg.png">
				</p>
				<div class="head_a3">
					<div class="header-search">
					</div>
				</div>
			</div>
		</div>
		<div class="wz">
			<dl>
				<dt>当前位置：外省企业备案</dt>

			</dl>
		</div>
	</div>
	<div class="main">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td valign="top">
						<div class="wr">

							<div class="tit">
								<img src="images/titico2.gif" /><strong>外省企业注册执业人员搜索</strong>
							</div>

							<div class="main " style="line-heigth: 24px;">
								<table width="98%" border="0" cellspacing="0" cellpadding="0"
									style="min-height: 100px;">
									<tr>
                    <td width="12%"><label>人员名称：</label>
                   </td>
                  
                    <td width="35%">
					<input type="text" name="condition.personName" value="<s:property value="condition.personName"/>" class="ipu1" />
					</td>
                    <td width="28%"><label>证件号码：</label></td>
                    <td width="25%">
					
					<input type="text" name="condition.idCard" value="<s:property value="condition.idCard"/>" class="ipu1" />
					</td>
                  </tr>
                  <tr>
                    <td><label>学历：</label></td>
                    <td>
					<select name="condition.eduLevelNum" class="sel">
      					<option value="">请选择</option>
      						<s:iterator value="eduLevelNums">
          						<option value="<s:property value="code"/>" <s:if test='condition.eduLevelNum==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select>
					</td>
                    <td><label>学位：</label></td>
                    <td>
					<select name="condition.degreeNum" class="sel">
      					<option value="">请选择</option>
      						<s:iterator value="degreeNums">
          						<option value="<s:property value="code"/>" <s:if test='condition.degreeNum==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select>
					</td>
					<s:if test="type!=1">
                        <td><input name="input4" type="button" class="btn" value="数据导入" onclick="leadingIn()" /></td>
                    </s:if>
                    
                  </tr>
								</table>
								<table class="ry_right right">
									<tr>
										<td><input type="button" 
											class="btn" value="搜索" onclick="queryConstructor()" /></td>
										<td><input type="button" 
											class="btn" value="添加" onclick="add()" /></td>
										<td><input type="button" 
											class="btn" value="返回" onclick="goBack()" /></td>

									</tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="ry_liebiao">
		<p class="f16 pd10 fb">
		外省企业注册执业人员列表<img src="<%=basepath%>/images/ry_lie.png" />
		</p>
		<table class="" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<th>序号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>证件类型</th>
			<th>证件号码</th>
			<th>注册类型及等级名称</th>
			<th>学历</th>
			<th>手机号码</th>
			<th>详细</th>
				</tr>
				<s:iterator status="i" value="currentPage.data" > 
        <tr>
			<td><s:property value="#i.count"/> </td>
			<td><s:property value="personName"/></td>
			<td><s:property value="sexName"/></td>
			<td><s:property value="idCardTypeName"/></td>
			<td><s:property value="idCard"/></td>
			<td><s:property value="sepecialtyTypName"/></td>
			<td><s:property value="eduLevelName"/></td>
			<td><s:property value="mobile"/>
			</td>
			<td>
			<s:if test='dataSource=="09"'>
			<a href="otherConstructorAction_queryById.action?personId=<s:property value="personId"/>"><span>修改</span></a>
			&nbsp;
			<a href="otherConstructorAction_deletePerson.action?personId=<s:property value="personId"/>"><span>删除</span></a>
			
			</s:if>
			<s:else>
			<a href="otherConstructorAction_detailed.action?idCard=<s:property value="idCard"/>&corpCode=<s:property value="corpCode"/>"><span>详细</span></a>
			
			</s:else>
			</td>
			
		 </tr>
        </s:iterator>

			</tbody>
		</table>
		<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
	<%@include file="/WEB-INF/content/outside/footer.jsp"%>
</body>
</html>
