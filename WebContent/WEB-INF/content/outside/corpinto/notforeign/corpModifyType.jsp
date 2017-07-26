<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<title>新企业录入表</title>
<script type="text/javascript">
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});
	
	function checkMaxInput(txt)

	{
	       if (txt.value.length > 500)
	       txt.value = txt.value.substring(0, 500);
	}
	
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/corpAction_queryOutLoginPage.action";
		document.form1.submit();
	}

</script>
</head>

<body>
	<form id="form1" name="form1" method="post"
		action="<%=basepath%>/corpAction_modifyCorpType.action">
		<div class="qy_wrapp">
			<div class="head">
				<div class="head_a1">
					<p class="logo">
						<img src="images/lg.png">
					</p>
					<div class="head_a3">
						<div class="header-search">
							<a href="#">收藏本站</a> | <a href="#">联系我们</a>| <a href="#">安全退出</a>
						</div>
					</div>
				</div>
			</div>
			<div class="wz">
				<dl>
					<dt>当前位置：系统首页</dt>

				</dl>
			</div>

			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td valign="top">
						<div class="wr">

							<div class="tit">
								<img src="images/titico1.gif" /><strong>新企业基本信息录入表</strong>
								<p>
									注：标记为（<span class="red">*</span>）的为必填项
								</p>
							</div>
							<div class="main h384">
								<div class="list g2">
									<table id="tb" width="100%" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td><label>企业名称：</label></td>
											<td align="center" valign="middle">
											<s:property value="corp.corpName" />
											</td>
											<td><label>企业组织机构代码：</label></td>
											<td align="center" valign="middle">
											<s:property value="corp.corpCode" />
											</td>
										</tr>
										
										<tr>
											<td><label>建设单位：</label></td>
											<td align="center" valign="middle">
											<input type="hidden" value="<s:property value="corp.corpId" />" name="corp.corpId" />
											<s:if test='corp.enterpriseType!=null'>
												<s:if test='corp.enterpriseType.contains("1")'>
												<input type="checkbox" name="corp.enterpriseType" value="1" class="sc " checked />
												</s:if> 
												<s:else>
												<input type="checkbox" name="corp.enterpriseType" value="1" class="sc" />
												</s:else>
											</s:if>
											<s:else>
												<input type="checkbox" name="corp.enterpriseType" value="1" class="sc" />
												</s:else>
											</td>
											<td><label>勘察单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType!=null'>
												<s:if test='corp.enterpriseType.contains("2")'>
													<input type="checkbox" name="corp.enterpriseType" value="2"
														class="sc" checked />
												</s:if> 
												<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="2"
														class="sc" />
												</s:else>
											</s:if>
											<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="2"
														class="sc" />
												</s:else>
											</td>
										</tr>
										<tr>
											<td><label>设计单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType!=null'>
											<s:if test='corp.enterpriseType.contains("3")'>
													<input type="checkbox" name="corp.enterpriseType" value="3"
														class="sc" checked />
												</s:if> 
												<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="3"
														class="sc" />
												</s:else>
											</s:if>
											<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="3"
														class="sc" />
												</s:else>
											</td>
											<td><label>施工单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType!=null'>
												<s:if test='corp.enterpriseType.contains("4")'>
													<input type="checkbox" name="corp.enterpriseType" value="4"
														class="sc" checked />
												</s:if> 
												<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="4"
														class="sc" />
												</s:else>
											</s:if>
											<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="4"
														class="sc" />
												</s:else>
												</td>
										</tr>
										<tr>
											<td><label>监理单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType!=null'>
											<s:if test='corp.enterpriseType.contains("5")'>
													<input type="checkbox" name="corp.enterpriseType" value="5"
														class="sc" checked />
												</s:if> 
												<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="5"
														class="sc" />
												</s:else>
											</s:if>
											<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="5"
														class="sc" />
												</s:else>
											</td>
											<td><label>图纸审查单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType!=null'>
											<s:if test='corp.enterpriseType.contains("6")'>
													<input type="checkbox" name="corp.enterpriseType" value="6"
														class="sc" checked />
												</s:if> 
												<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="6"
														class="sc" />
												</s:else>
											</s:if>
											<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="6"
														class="sc" />
												</s:else>
											</td>
										</tr>
										<tr>
											<td><label>检测单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType!=null'>
											<s:if test='corp.enterpriseType.contains("7")'>
													<input type="checkbox" name="corp.enterpriseType" value="7"
														class="sc" checked />
												</s:if> 
												<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="7"
														class="sc" />
												</s:else>
											</s:if>
											<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="7"
														class="sc" />
											</s:else>
											</td>
											<td><label>其他：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType!=null'>
											<s:if test='corp.enterpriseType.contains("8")'>
													<input type="checkbox" name="corp.enterpriseType" value="8"
														class="sc" checked />
												</s:if> 
												<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="8"
														class="sc" />
												</s:else>
											</s:if>
											<s:else>
													<input type="checkbox" name="corp.enterpriseType" value="7"
														class="sc" />
											</s:else>
											</td>
										</tr>
										
									</table>
									<div class="botn">
										<input type="image" src="<%=basepath%>/images/quxiao.jpg"
											onclick="goBack()" /> <input type="image"
											src="<%=basepath%>/images/baocun.jpg" />
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="bot">Copyright © 2015 版权所有 黑龙江住房和城乡建设部建筑市场监管司 |
			技术支持：建设厅信息中心 哈尔滨天健高新技术有限公司 | 建议使用 IE 8及以上，1366*768及以上分辨率浏览</div>
</body>
</html>
