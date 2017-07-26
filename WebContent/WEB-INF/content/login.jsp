<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>一体化平台管理key登陆页</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript">

	function MM_preloadImages() { //v3.0
	  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
	    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
	    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
	}

	function MM_swapImgRestore() { //v3.0
	  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
	}

	function MM_findObj(n, d) { //v4.01
	  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
	    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
	  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
	  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
	  if(!x && d.getElementById) x=d.getElementById(n); return x;
	}

	function MM_swapImage() { //v3.0
	  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
	   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
	}
	

	//新企业注册
	function regCorp()
	{
		document.form1.action="<%=basepath%>/corpAction_queryCorpNamePage.action";
		document.form1.submit();
	}
	
	//跳转企业类型组织机构代码查询页面
	function queryCorpCodePage()
	{
		document.form1.action="<%=basepath%>/corpAction_queryCorpCodePage.action";
		document.form1.submit();
	}
	
	//跳转外省组织机构代码查询页面
	function queryForeignCorpCode()
	{
		document.form1.action="<%=basepath%>/foreignCorpAction_queryCorpCodePage.action";
		document.form1.submit();
	}
	
	//UKey登陆
	function checkOne(num)
	{
		document.form1.action="<%=basepath%>/loginAction_checkOne.action?typeNum="+num;
		document.form1.submit();
	}
	
	//外省企业备案登陆页
	function otherProvinceLogin()
	{
		document.form1.action="<%=basepath%>/otherProvinceAction_otherProvinceLogin.action";
		document.form1.submit();
	}
	
	function getMessage()
	{
		var message = document.getElementById("message").value;
		var messages = document.getElementById("messages").value;
		if(message != "")
		{
			alert(message);
		}
		if(messages != "")
		{
			alert(messages);
		}
	}
	function regForeignCorp()
	{
		document.form1.action="<%=basepath%>/foreignCorpAction_foreignFlowChart.action";
		document.form1.submit();
	}
	
	//资质查询
	function queryQualificationAction() {
		document.form1.action="<%=basepath%>/queryQualificationAction_queryCorpCode.action";
		document.form1.submit();
	}

	//操作提示信息
//	function getMessage() {
//		var message = document.getElementById("message").value;
//		if (message != "") {
//			alert(message);
//		}
//	}
</script>
</head>
<body style="background: #fff url(images/ytbg.jpg) no-repeat center top;"
	onLoad="MM_preloadImages('images/dl_but01_.png','images/dl_but02_.png','images/dl_but03_.png');getMessage()">
	<input type="hidden" id="message" value="<s:property value="corp.message" />" />
	<input type="hidden" id="messages" value="<s:property value="message" />" />
<form id="form1" name="form1" method="post" action="" onsubmit='return Validate();' language='jscript'>
	<div class="ytkey_wrap">
		<div class="ytmain">
			
			<a href="#" onclick="checkOne(1)">
			<span class="kybun">
			<img src="images/dl_but01.png" width="297" height="51" id="Image1"
					onMouseOver="MM_swapImage('Image1','','images/dl_but01_.png',1)"
					onMouseOut="MM_swapImgRestore()">
			</span>
			</a> 
			<a href="#" onclick="checkOne(2)">
			<span class="kybun">
			<img src="images/dl_but02.png" width="297" height="51" id="Image2"
					onMouseOver="MM_swapImage('Image2','','images/dl_but02_.png',1)"
					onMouseOut="MM_swapImgRestore()">
			</span>
			</a> 
			<a href="#" onclick="checkOne(3)">
			<span class="kybun">
			<img src="images/dl_but03.png" width="297" height="51" id="Image3"
					onMouseOver="MM_swapImage('Image3','','images/dl_but03_.png',1)"
					onMouseOut="MM_swapImgRestore()">
			</span>
			</a>
			
			<span class="kybun">
			<a href="http://111.40.3.210:8097/ocip/" >
			<img src="images/dl_but06.png" width="297" height="51" id="Image6"
					onMouseOver="MM_swapImage('Image6','','images/dl_but06_.png',1)"
					onMouseOut="MM_swapImgRestore()">
			</a>
			</span>
			
			<font color="#FFFFFF"><strong>QQ交流群:472032094</strong></font>
			<ul class="zhkey_content f16">
				<a href="#" onclick="regCorp()"><li>新企业录入</li></a>
				<a href="#" onclick="regCorp()"><li>企业基本信息修改</li></a>
				<a href="#" onclick="queryCorpCodePage()"><li>企业类型修改</li></a>
				<a href="#" onclick="otherProvinceLogin()"><li>外省企业备案</li></a>
				<!-- <a href="#" onclick="queryQualificationAction()"><li>企业拥有资质查询</li></a> -->
				<a href="<%=basepath%>/download/filetext/1.doc"><li>新企业登记说明下载</li></a>
				<a href="<%=basepath%>/download/filetext/2.doc"><li>系统使用说明书下载</li></a>
				<a href="<%=basepath%>/download/permit/permit.rar"><li>施工许可证-样表</li></a>
				<a href="<%=basepath%>/download/ie64win7/IE10-Windows6.1-zh-cn.exe"><li>win7 IE10 64位升级下载</li></a>
			</ul>


			<p class="explain">
				Copyright © 2015 版权所有 黑龙江省住房和城乡建设厅<br /> 技术支持：黑龙江省建设厅信息中心
				哈尔滨天健高新技术有限公司<br /> 建议使用 IE 10及以上，1366*768及以上分辨率浏览
			</p>
		</div>



	</div>
	</form>
</body>
</html>
