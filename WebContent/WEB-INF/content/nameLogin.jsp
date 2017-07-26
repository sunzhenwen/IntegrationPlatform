<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>登陆</title>
<link href="<%=basepath%>/login-img/login-style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//企业名登陆
	function loginForCorpName()
	{
		document.form1.action="<%=basepath %>/loginAction_businessPage.action";
		document.form1.submit();
	}
	
</script>
</head>

<body>
<form id="form1" name="form1" method="post" action="" onsubmit='return Validate();' language='jscript'>
	<input type="hidden" id="message" value="<s:property value="corp.message" />" />
	<input type="hidden" id="messages" value="<s:property value="message" />" />
<div class="warp">
	<div class="logo"><img src="<%=basepath%>/login-img/logo.png" /></div>
        <div class="w800">
  
            
            <div class="fr login-qy">
            	<span>企业模拟登陆</span>
       	        <ul>
                        <li style="font-size:16px;">企业名称：</li>
                        <li ><input name="corpName" type="text" value="<s:property value="corpName"/>" size="39" maxlength="39" style="height:20px;padding:5px 0;" /></li>
                      
                        <li><input name="" type="button" class="dlbtn-qy" onclick="loginForCorpName()" /></li>
               </ul>
            </div>
      </div>
</div>

<div class="bot">
Copyright © 2015 版权所有 黑龙江省住房和城乡建设厅<br /> 技术支持：黑龙江省建设厅信息中心
				哈尔滨天健高新技术有限公司<br /> 建议使用 IE 10及以上，1366*768及以上分辨率浏览
</div>

<script type="text/javascript" src="js/jquery.js"></script>

<!--[if lte IE 6]>
<script src="js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('*');
    </script>
<![endif]-->
</form>
</body>
</html>
