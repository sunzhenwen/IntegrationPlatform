<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业三类人员修改</title>
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
       		var re = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;//判断正整数
       		if(re.test(document.getElementById('cardId').value) === false)
       		{
       			alert("身份证输入不合法!");
           		check = false;
           		return check;
       		}
       	}
		if(document.getElementById('cerType').value==""){
	   		alert("请输入证书类型!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('cerNum').value==""){
	   		alert("请输入证书编号!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time1').value==""){
	   		alert("请选择发证日期!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time2').value==""){
	   		alert("请选择结束日期!");
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
			document.form1.action="<%=basepath %>/threeTypePersonAction_modify.action";
			document.form1.submit();
		}
		
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/threeTypePersonAction_goList.action";
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
     
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   
    <td valign="top">
    	<div class="wr">

<div class="tit"><img src="images/titico1.gif"/><strong>外省企业三类人员修改</strong><p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
            <div class="main h384">
            	<div class="list g2">
				<form id="form1" name="form1" method="post" action="">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td width="17%"><label>姓名：</label></td>
                        <td width="32%">
						<input id="name" type="text" maxlength='50' name="threeTypePerson.FName" value="<s:property value="threeTypePerson.FName"/>" class="ipu1"/>
						<input type="hidden" name="threeTypePerson.threeTypePersonId" value="<s:property value="threeTypePerson.threeTypePersonId"/>"/>
						<span class="red">*</span> 
                        </td>
                        <td width="19%"><label>身份证号：</label></td>
                        <td width="32%">
						<input id="cardId" type="text" maxlength='18' name="threeTypePerson.FIdCertNo" value="<s:property value="threeTypePerson.FIdCertNo"/>" class="ipu1"/>
						<span class="red">*</span>  </td>
                      </tr>
                      <tr>
                        <td><label>证书类别：</label></td>
                        <td>
						<input id="cerType" type="text" maxlength='50' name="threeTypePerson.FCertType" value="<s:property value="threeTypePerson.FCertType"/>" class="ipu1"/>
                        <span class="red">*</span></td>
                        <td><label>证书编号：</label></td>
                        <td>
						<input id="cerNum" type="text" maxlength='50'  name="threeTypePerson.FCertNumber" value="<s:property value="threeTypePerson.FCertNumber"/>" class="ipu1"/>
                        <span class="red">*</span>  </td>
                      </tr>
                      <tr>
                        <td><label>发证日期：</label></td>
                        <td>
						<input id="time1" value="<s:date name="threeTypePerson.FRegDate" format="yyyy-MM-dd" />" type="text" name="threeTypePerson.FRegDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
						<span class="red">*</span></td>
                        <td><label>结束日期：</label></td>
                        <td>
						<input id="time2" value="<s:date name="threeTypePerson.FRegEndDate" format="yyyy-MM-dd" />" type="text" name="threeTypePerson.FRegEndDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
						<span class="red">*</span>
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
