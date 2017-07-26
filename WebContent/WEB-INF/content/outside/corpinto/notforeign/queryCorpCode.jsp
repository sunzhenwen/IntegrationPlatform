<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<title>组织机构代码证查询</title>
<script type="text/javascript">
	function queryCorpCode()
	{
		var code = document.getElementById("code").value;
		if(code != "")
		{
			document.form1.action="<%=basepath%>/corpAction_queryCorpCode.action";
			document.form1.submit();
		} else {
			alert("请输入企业组织机构代码！");
		}
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
	<form id="form1" name="form1" method="post" action="">
		<div class="qy_wrapp">
			<div class="head">
				<div class="head_a1">
					<p class="logo">
						<img src="<%=basepath%>/images/lgw.png">
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
			<div class="tit">
				<img src="images/titico2.gif" /><strong>组织机构代码证(统一社会信用代码)查询
				</strong>
			</div>
			<div class="main cz"
				style="min-height: 500px; solid: #000 1px solid;">
				<table width="98%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="58%"><label>组织机构代码证查询(统一社会信用代码) ：</label> <input
							 id="code" maxlength="18" type="text" class="ipu1" name="corpCode" style="width:50%"/></td>
						<td width="32%"><input name="" type="button" value="查询"
							class="fl btn" onclick="queryCorpCode()" /></td>
					</tr>

				</table>
			</div>
		</div>


		<div class="bot">Copyright © 2015 版权所有 黑龙江住房和城乡建设部建筑市场监管司 |
			技术支持：建设厅信息中心 哈尔滨天健高新技术有限公司 | 建议使用 IE 8及以上，1366*768及以上分辨率浏览</div>
</body>
</html>