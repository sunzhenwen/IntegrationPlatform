<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ page import="java.util.*" %>
<%@ page session="true"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>一体化平台身份验证</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="install_lodop.exe"></embed>
</object>

<script language="JavaScript">
//读Ukey信息
function Init(num)
{
	//开发时请参见"ET99多功能锁安全ActiveX控件参考手册.pdf"中的说明
	var ePassSN;
	var ePassDigest;
	var UserID;
	var ePassPID;
	var ePassNum;
	//ePass1000型号Ukey读取
	
	try{
	    
		var aa = ePass1000red();
		
    	var ePass = new ActiveXObject("ET99_FULL.ET99Full.1");
		//找锁
		ePassPID = "853B360C";//"853B360C";	
		//"F737F785"=1
		//"853B360C"=
		ePassNum = ePass.FindToken(ePassPID);
		//打开锁
		ePass.OpenToken(ePassPID,1);
		//得到硬件ID
		ePassSN = ePass.GetSN();
		//ePassSN = "29DB1B7A0B00917A";
		document.getElementById("resultsId").value = ePassSN;
		document.form1.action="<%=basepath %>/loginAction_businessPage.action?typeNum="+num;
	    document.form1.submit();
	   
	}catch(error) 
	{
		if ((error.number& 0xFFFF)==429){
	        alert("请安装白锁(ET99)驱动!");
	        alert("请尝试一下操作：\n1.请确认您已插入一体化平台白色UKey;\n2.请确认您已安装与您系统对应的驱动;\n3.请确认您使用的是IE浏览器（推荐IE10版本浏览器）;"+
	        "\n4.如以上三点确认无误，请打开IE浏览器，点击最上方的“工具”->“Internet选项”->“安全”->“受信任的站点”->将一体化平台的网址http://111.40.3.210:8093/cip保存到受信任的站点中，关闭浏览器，再次进入一体化平台");
	    }
	    ePass.CloseToken();
	    if (((error.number& 0xFFFF)==5)&&(aa==false)){
	        alert("请插入Ukey!\n本系统不兼容2015年以前发放的UKey!\n无新Ukey用户请到建设厅领取企业新系统UKey!");
	        alert("请尝试一下操作：\n1.请确认您已插入一体化平台白色UKey;\n2.请确认您已安装与您系统对应的驱动;\n3.请确认您使用的是IE浏览器（推荐IE10版本浏览器）;"+
	        "\n4.如以上三点确认无误，请打开IE浏览器，点击最上方的“工具”->“Internet选项”->“安全”->“受信任的站点”->将一体化平台的网址http://111.40.3.210:8093/cip保存到受信任的站点中，关闭浏览器，再次进入一体化平台");
	    }
		return false;
	}	
	
	
}


//读黑Ukey ePass1000
function ePass1000red()
{
	var text;
	try{
	    //寻找 ePass1000的Ukey
	     ePass1000.GetLibVersion
	 	
	    //寻找 ePass1000的启动Ukey
	    ePass1000.OpenDevice(1,"")
	  
	    //寻找 ePass1000的提取Ukey密码
	    text = ePass1000.GetStrProperty(7, 0, 0)
	    
		document.getElementById("resultsId").value = text;
	    document.form1.action="<%=basepath %>/loginAction_businessPage.action";
		document.form1.submit();
		 return true;

		
	   
	
	}catch(error)
	{
		return false;
	}
}

//操作提示信息
function getMessage()
{
	var message = document.getElementById("message").value;
	if(message != "")
	{
		alert(message);
	}
}

</script>

<script type="text/javascript">

	function openDriveInstru()
	{
		window.open("<%=basepath %>/loginAction_driveInstructions.action");
	}
	
</script>
<script type="text/javascript">    
	function CheckIsInstall() {	 
		try{ 
		     var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
			if ((LODOP!=null)&&(typeof(LODOP.VERSION)!="undefined")) alert("本机已成功安装过Lodop控件!\n  版本号:"+LODOP.VERSION); 
		 }catch(err){ 
			//alert("Error:本机未安装或需要升级!"); 
 		 } 
	}; 
</script> 
</head>

<body style="background:#93c3d9 url(<%=basepath %>/images/ytbg.jpg) no-repeat left top;background-size:cover;-webkit-background-size: cover;-moz-background-size: cover;
 -o-background-size: cover;" onload="getMessage()">
 <OBJECT classid=clsid:E740C5DF-3454-46A7-80EC-364D1ADB6CF0 id=ePass1000 name = ePass1000 STYLE="LEFT: 0px; TOP: 0px" width=0 height=0></OBJECT>
<form id="form1" name="form1" method="post" action="" onsubmit='return Validate();' language='jscript'>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="dl_main">
    	<img src="<%=basepath %>/images/ytheader.png" />
    	<p>（请将身份验证锁插入，点身份验证）</p>
        <a href="#" CLASS='inputbtn' onclick="javascript:Init(<s:property value="typeNum" />)"><span class="sfyz">身份验证</span></a>
		<input id="resultsId" name="results" type="hidden">
    </div>
    <div class="dl_download">
    	<p style="color:#1db000; font-weight:bold; font-size:16px;">驱动程序及文档下载</p>
        <p ><a href="<%=basepath %>/downloadDrive/xp/INSTDRVxp.exe">加密锁驱动下载(XP系统)</a></p>
        <p ><a href="<%=basepath %>/downloadDrive/win7win8/eps1k_full_new.zip">加密锁驱动下载(Win7/Win8系统) </a></p>
        <p ><a href="#" onclick="openDriveInstru();">驱动安装说明 </a></p>
        <p ><a href="<%=basepath %>/downloadDrive/checkDrive/test_dog.EXE">锁检测程序下载</a></p>
        <p ><a href="<%=basepath %>/downloadDrive/explain/guanliban.EXE">管理版使用说明下载</a></p>
        <p ><a href="<%=basepath %>/downloadDrive/explain/qiyeban.EXE">企业版使用说明下载</a></p>
        <p ><a href="javascript:CheckIsInstall()">查看本机是否安装打印控件</a></p>
    </div>	
	</form>
</body>
</html>
