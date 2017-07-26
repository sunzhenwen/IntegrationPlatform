<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业职称人员添加</title>
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
		if(document.getElementById('sex').value==""){
	   		alert("请选择性别!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('cardType').value==""){
	   		alert("请选择证件类型!");
	   		check = false;
	   		return check;
	   	}
		if(document.getElementById('cardId').value==""){
	   		alert("请输入证件号码!");
	   		check = false;
	   		return check;
	   	}
		if(document.getElementById('cardId').value!=""){
	   		var re = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	   		if(re.test(document.getElementById('cardId').value) === false)
	   		{
	   			alert("证件号码不合法!");
	       		check = false;
	       		return check;
	   		}
	   	}
		if(document.getElementById('title').value==""){
	   		alert("请输入职称!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('major').value==""){
	   		alert("请输入职称专业!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('level').value==""){
	   		alert("请输入职称级别!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('school').value==""){
	   		alert("请输入毕业学校!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('studyMajor').value==""){
	   		alert("请输入所学专业!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time1').value==""){
	   		alert("请选择毕业时间!");
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
			document.form1.action="<%=basepath %>/otherTitleAction_add.action";
			document.form1.submit();
		}
		
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/otherTitleAction_goList.action";
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

<div class="tit"><img src="images/titico1.gif"/>
<strong>外省企业职称人员添加</strong>
<p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
            <div class="main h384">
            	<div class="list g2">
				<form id="form1" name="form1" method="post" action="">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td width="17%"><label>姓名：</label></td>
                        <td width="32%">
						<input id="name" type="text" maxlength='50'  name="title.personName" value="<s:property value="title.personName"/>" class="ipu1"/>
						<input type="hidden" name="title.personId" value="<s:property value="title.personId"/>"/>
						<span class="red">*</span> 
                        </td>
                        <td width="19%"><label>性别：</label></td>
                        <td width="32%">
						<select id="sex" name="title.sexNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="sexNums">
								<option value="<s:property value="code"/>"<s:if test='title.sexNum==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
						</select>
                        <span class="red">*</span>  </td>
                      </tr>
                      <tr>
                        <td><label>证件类型：</label></td>
                        <td>
						<select id="cardType" name="title.idCardTypeNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="idCardTypeNums">
								<option value="<s:property value="code"/>"<s:if test='title.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
						</select>
                        <span class="red">*</span></td>
                        <td><label>证件号码：</label></td>
                        <td>  
						<input id="cardId" type="text" maxlength='50' name="title.idCard" class="ipu1"/>
						<span class="red">*</span>  </td>
                      </tr>
                      <tr>
                        <td><label>职称：</label></td>
                        <td>
						<input id="title" type="text" maxlength='50'  name="title.titleName" value="<s:property value="title.titleName"/>"  class="ipu1"/>
						<span class="red">*</span></td>
                        <td><label>职称专业：</label></td>
                        <td>
						<input id="major" type="text" maxlength='50'  name="title.titleMajor" value="<s:property value="title.titleMajor"/>" class="ipu1"/>
						<span class="red">*</span>
						</td>
                      </tr>
                      <tr>
                        <td><label>职称级别：</label></td>
                        <td>
						<input id="level" type="text" maxlength='50'  name="title.titleLevel" value="<s:property value="title.titleLevel"/>" class="ipu1"/>
						<span class="red">*</span></td>
                        <td><label>毕业学校：</label></td>
                        <td>
						<input id="school" type="text" maxlength='50'  name="title.graduatedSchool"  value="<s:property value="title.graduatedSchool"/>" class="ipu1"/>
						<span class="red">*</span>
						</td>
                      </tr>
					  <tr>
                        <td><label>所学专业：</label></td>
                        <td>
						<input id="studyMajor" type="text" maxlength='50'  name="title.studyMajor" value="<s:property value="title.studyMajor"/>" class="ipu1"/>
						<span class="red">*</span></td>
                        <td><label>毕业时间：</label></td>
                        <td>
						<input id="time1" type="text" name="title.graduatedDate" value="<s:date name="title.graduatedDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
						<span class="red">*</span>
						</td>
                      </tr>
					  <tr>
                        <td><label>手机号码：</label></td>
                        <td>
						<input type="text" maxlength='50'  name="title.mobile" value="<s:property value="title.mobile"/>" class="ipu1"/>
						</td>
                        <td>&nbsp;</td>
                        <td>
						&nbsp;
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
