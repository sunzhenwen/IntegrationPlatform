<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业技术工人添加</title>
<link rel="stylesheet" href="<%=basepath %>/css/style.css" type="text/css" >
<link href="<%=basepath %>/css/style20151026.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	
	//验证字段
	function check()
	{
		var check = true;
		if(document.getElementById('name').value==""){
			alert("请输入姓名!");
       		check = false;
       		return check;
		}
		if(document.getElementById('cardId').value==""){
       		alert("请输入身份证号!");
       		check = false;
       		return check;
       	}
		if(document.getElementById('cardId').value!=""){
       		var re = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
       		if(re.test(document.getElementById('cardId').value) === false)
       		{
       			alert("身份证输入不合法!");
           		check = false;
           		return check;
       		}
       	}
		if(document.getElementById('workType').value==""){
       		alert("请选择工种类型!");
       		check = false;
       		return check;
		}
		if(document.getElementById('cer').value==""){
       		alert("请输入证书编号!");
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
			document.form1.action="<%=basepath %>/otherSkilledworkerAction_created.action";
			document.form1.submit();
		}
		
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/otherSkilledworkerAction_goList.action";
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
                	<dt>当前位置：外省企业备案</dt>
                    
                </dl>
      </div>    
  <form id="form1" name="form1" method="post" action="">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   
    <td valign="top">
    	<div class="wr">

<div class="tit">
<img src="images/titico1.gif"/><strong>外省企业技术工人添加</strong>
<p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
            <div class="main h384">
            	<div class="list g2">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td width="17%"><label>人员名称：</label></td>
                        <td width="32%">
						<input id="name" type="text" maxlength='50' name="skilledworker.personName" value="<s:property value="skilledworker.personName"/>" class="ipu1" />
						<input type="hidden" name="skilledworker.personId" value="<s:property value="skilledworker.personId"/>"/>
						<span class="red">*</span> 
                        </td>
                        <td width="19%"><label>身份证号：</label></td>
                        <td width="32%">
						<input id="cardId" type="text" maxlength='18' name="skilledworker.identityCard" class="ipu1" />
                        <span class="red">*</span>  </td>
                      </tr>
                      <tr>
                        <td><label>工种类型：</label></td>
                        <td>

						<select id="workType" name="skilledworker.skilledType" class="sel">
							<option value="">请选择</option>
							<s:iterator value="typedNums">
								<option value="<s:property value = "code" />"<s:if test='skilledworker.skilledTypeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
						</select>
						<span class="red">*</span></td>
                        <td><label>证书编号：</label></td>
                        <td>
						<input id="cer" type="text" maxlength='50' name="skilledworker.certificateNum" class="ipu1" />
                        <span class="red">*</span>  </td>
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
                </div>
            </div>
   		</div>
    </td>
  </tr>
</table>
</form>
</div>

<%@include file="/WEB-INF/content/outside/footer.jsp"%>
</body>
</html>
