<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业项目备案</title>
<link rel="stylesheet" href="<%=basepath %>/css/style.css" type="text/css" >
<link href="<%=basepath %>/css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
	//验证字段
	function check()
	{
		var check = true;
		if(document.getElementById('prjName').value==""){
			alert("请选择项目!");
	   		check = false;
	   		return check;
		}
		return check;
	}
	
	//保存
	function save()
	{
		if(check())
		{
			document.form1.action="<%=basepath %>/otherProjectAction_add.action";
			document.form1.submit();
		}
		
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/otherProjectAction_goList.action";
		document.form1.submit();
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
	
	//查询项目
	function queryPrjName()
	{
		var url1="<%=basepath %>/queryPrjsAction_queryPage.action";
		var newWin1=window.showModalDialog(url1,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin1.open()
	}
</script>
</head>

<body onload="getMessage()">
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="qy_wrapp">
    	<div class="head">
            <div class="head_a1">
               <p class="logo"><img src="images/lg.png"></p>
                 <div class="head_a3">
                     <div class="header-search"> 
                     </div>
                 </div>
            </div>
        </div>
     
     
     
     
     
           <div class="wz">
            	<dl>
                	<dt>当前位置：外省企业项目备案</dt>
                    
                </dl>
      </div>    
     
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   
    <td valign="top">
    	<div class="wr">

<div class="tit"><img src="images/titico1.gif"/><strong>外省企业项目备案</strong></div>
            <div class="main h384">
            	<div class="list g2">
				<form id="form1" name="form1" method="post" action="">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td width="17%"><label>项目名称：</label></td>
                        <td width="32%">
                        <input id="prjId" type="hidden" readonly name="construction.prjId" value="<s:property value="construction.prjId"/>" />
                        <input type="hidden" readonly name="construction.corpId" value="<s:property value="corpId"/>" />
                        <input id="appDept" type="hidden" readonly name="construction.appDept" value="<s:property value="construction.appDept"/>" />
                        <input id="appDeptName" type="hidden" readonly name="construction.appDeptName" value="<s:property value="construction.appDeptName"/>" />
						<input id="prjName" type="text" readonly name="construction.prjName" value="<s:property value="construction.prjName"/>" class="ipu1"/>
						<a href="#" onclick="queryPrjName()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
                        </td>
                        <td width="19%"><label>项目编号：</label></td>
                        <td width="32%">
						<input id="prjNum" type="text" readonly name="construction.prjNum" value="<s:property value="construction.prjNum"/>" class="ipu1"/>
						</td>
                      </tr>
                      <tr>
                        <td><label>企业名称：</label></td>
                        <td>
						<input type="text" readonly name="construction.corpName" value="<s:property value="corpName"/>" class="ipu1"/>
                        </td>
                        <td><label>组织机构代码：</label></td>
                        <td>
						<input type="text" readonly name="construction.corpCode" value="<s:property value="corpCode"/>" class="ipu1"/>
                        </td>
                      </tr>
                      
                      
                       <tr>
                        <td>&nbsp;</td>
                        <td>
						<input type="button" class="btn" value="返回" onclick="goBack()" />
						<input type="button" class="btn" value="保存" onclick="save()" /></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
					</form>
                </div>
            </div>
   		</div>
    </td>
  </tr>
</table>

</div>

<%@include file="/WEB-INF/content/outside/footer.jsp"%>
</body>
</html>
