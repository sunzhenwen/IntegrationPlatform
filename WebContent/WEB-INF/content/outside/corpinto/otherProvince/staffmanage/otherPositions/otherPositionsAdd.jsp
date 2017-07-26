<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业现场管理人员添加</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	//保存
	function verify()
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
		if(document.getElementById('duty').value==""){
       		alert("请选择岗位名称!");
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
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/otherPositionsAction_goList.action";
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
	//提交
    function checkCardId()
    {
		
		$(document).ready(function(){
            var cardId = $("#cardId").val();
            $.ajax({
                url: 'otherPositionsAction_checkCardId.action',
                type: 'post',
                dataType: 'json',
                data: 'cardId='+cardId,
                success: function(data){ 
                    //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
                    var items = eval("("+data+")");
                    if(items=='')
                    {
                    	if(verify()){
                    		document.form1.action="<%=basepath %>/otherPositionsAction_add.action";
                    		document.form1.submit();
                        }
                    }else
                    {
                    	alert("此身份证号已在本公司注册!");
                    	document.getElementById('cardId').focus();
                    }
                }
            });
        });
    }
</script>
</head>

<body onload="getMessage()">
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

<div class="tit"><img src="images/titico1.gif"/><strong>外省企业现场管理人员添加</strong>
<p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
            <div class="main h384">
            	<div class="list g2">
				<form id="form1" name="form1" method="post" action="">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td width="17%"><label>姓名：</label></td>
                        <td width="32%">
						<input id="name" type="text" maxlength='50'  name="positions.name" class="ipu1"  />
						<span class="red">*</span> 
                        </td>
                        <td width="19%"><label>性别：</label></td>
                        <td width="32%">
						<select id="sex" name="positions.sex" class="sel">
							<option value="">请选择</option>
							<option value="0">男</option>
							<option value="1">女</option>
						</select>
                        <span class="red">*</span>  </td>
                      </tr>
                      <tr>
                        <td><label>身份证号：</label></td>
                        <td>
                        <input id="cardId" type="text" maxlength='18'  name="positions.cardId" class="ipu1"/>
						<span class="red">*</span></td>
                        <td><label>岗位名称：</label></td>
                        <td>
						<select id="duty" name="positions.duty" class="sel">
							<option value="">请选择</option>
							<s:iterator value="dutys">
								<option value="<s:property value="code"/>"
									<s:if test='positions.duty==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
						</select>
						<span class="red">*</span>  </td>
                      </tr>
                      <tr>
                        <td><label>证书编号：</label></td>
                        <td><input id="cer" type="text" maxlength='50' name="positions.certNum" class="ipu1" />
						<span class="red">*</span></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>
							<input type="button" class="btn" value="返回" onclick="goBack()" />
							<input type="button" class="btn" value="保存" onclick="checkCardId()" />
						</td>
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
