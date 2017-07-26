<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业备案</title>
<link rel="stylesheet" href="<%=basepath%>/css/style.css" type="text/css" >
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

	//外省企业备案
	function otherProvince()
	{
		document.form1.action="<%=basepath%>/otherProvinceAction_check.action";
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

</script>
</head>
<body style="background:#fff url(images/ytbg_new.jpg) no-repeat center top;" onLoad="MM_preloadImages('images/dl_but01_.png','images/dl_but02_.png','images/dl_but03_.png');getMessage()">
	<input type="hidden" id="message" value="<s:property value="corp.message" />" />
	<input type="hidden" id="messages" value="<s:property value="message" />" />
	<form id="form1" name="form1" method="post" action="" onsubmit='return Validate();' language='jscript'>
		<div class="ytkey_wrap">
			<div class="ytmain" style="margin-top:100px;">
				<a href="#" onclick="otherProvince()"><span class="kybun"><img src="images/dl_but04.png" width="297" height="51" id="Image1" onMouseOver="MM_swapImage('Image1','','images/dl_but04_.png',1)" onMouseOut="MM_swapImgRestore()"></span></a>
			</div>	
			<p class="explain" style="margin-top:100px;">Copyright © 2015 版权所有 黑龙江省住房和城乡建设厅  <br />  技术支持：黑龙江省建设厅信息中心  哈尔滨天健高新技术有限公司  |  建议使用 IE 8及以上，1366*768及以上分辨率浏览</p>
    	</div>
    </form>
</body>
</html>
