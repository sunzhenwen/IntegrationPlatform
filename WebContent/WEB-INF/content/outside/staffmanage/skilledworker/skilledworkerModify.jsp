<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技术工人详细基本信息 </title>
<script type="text/javascript">
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/skilledworkerAction_goList.action";
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

<body onload="getMessage()" >
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">
    	<div class="head">
  <div class="head_a1">
          <p class="logo"><img src="<%=basepath %>/images/lg.png"></p>
          <div class="head_a3">
          <div class="header-search"> 
          <a href="/">收藏本站</a> |
          <a href="/">联系我们</a>|
          <a href="/">安全退出</a>
          </div>
          </div>
  </div>

</div>
      <form id="form1" name="form1" method="post" action="<%=basepath %>/skilledworkerAction_modified.action">
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>技术工人详细基本信息</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>姓名：</th>
                            <td align="left"><input type="text" maxlength='50'  name="skilledworker.personName" value="<s:property value="skilledworker.personName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
									<input type="hidden" name="skilledworker.personId" value="<s:property value="skilledworker.personId"/>" /></td>
                            <th>身份证号：</th>
                        	<td align="left"><input type="text" maxlength='50'  name="skilledworker.identityCard" value="<s:property value="skilledworker.identityCard"/>"  class="{required:true,digits:true}" /><strong><font color="#FF0000">*</font></strong></td>
                            <!-- 
                            <th>性别：</th>
                            <td><select name="skilledworker.sexNum" class="required">
      								<option value="">请选择</option>
		      						<s:iterator value="sexName">
		          						<option value="<s:property value="code"/>" <s:if test='skilledworker.sexNum==code'>selected</s:if>><s:property value="name"/></option>
		      						</s:iterator>
								</select><strong><font color="#FF0000">*</font></strong></td>
                             -->
                         </tr>
                         <!-- 
                         <tr>
                         	<th>证件类型：</th>
                            <td><select name="skilledworker.idCardTypeNum" class="required">
		      						<option value="">请选择</option>
		      						<s:iterator value="idCardTypeName">
		          						<option value="<s:property value="code"/>" <s:if test='skilledworker.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
		      						</s:iterator>
								</select><strong><font color="#FF0000">*</font></strong></td>
                            <th>证件号码：</th>
                            <td><input type="text" maxlength='50'  name="skilledworker.identityCard" value="<s:property value="skilledworker.identityCard"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                           
                          
                         </tr>
                          -->
                           <tr>
                         	<th>工种类型：</th>
                            <td align="left"><select id="" name="skilledworker.skilledTypeNum" class="required">
								<option value="">请选择</option>
								<s:iterator value="typedNums">
									<option value="<s:property value="code"/>"<s:if test='skilledworker.skilledTypeNum==code'>selected</s:if>><s:property value="name" /></option>
								</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong></td>
                            <th>证书编号：</th>
                        	<td align="left"><input type="text" maxlength='50' name="skilledworker.certificateNum" value="<s:property value="skilledworker.certificateNum"/>" class="{required:true,digits:true}" /><strong><font color="#FF0000">*</font></strong></td>
                            <!-- 
                            <th>工种级别：</th>
                            <td><select id="" name="skilledworker.skilledLevelNum" class="required">
								<option value="">请选择</option>
								<s:iterator value="levelNums">
									<option value="<s:property value="code"/>"<s:if test='skilledworker.skilledLevelNum==code'>selected</s:if>><s:property value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>
                           -->
                          
                         </tr>
                         <!-- 
                         <tr>
                         	<th>民族：</th>
                            <td><select id="" name="skilledworker.nationAlityNum" class="required">
								<option value="">请选择</option>
								<s:iterator value="nationalName">
									<option value="<s:property value="code"/>"<s:if test='skilledworker.nationAlityNum==code'>selected</s:if>><s:property value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>
                            <th>手机号码：</th>
                            <td><input type="text" maxlength='50'  name="skilledworker.mobile" value="<s:property value="skilledworker.mobile"/>"
							class="required" /><strong><font color="#FF0000">*</font></strong></td>
                           
                         </tr>
                          
                           <tr>
                         	<th>学位：</th>
                            <td><select id="" name="skilledworker.degreeNum"
							class="required">
								<option value="">请选择</option>
								<s:iterator value="degreeName">
									<option value="<s:property value="code"/>"<s:if test='skilledworker.degreeNum==code'>selected</s:if>><s:property value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>
                            <th>学历：</th>
                            <td><select id="" name="skilledworker.eduLevelNum"
							class="required">
								<option value="">请选择</option>
								<s:iterator value="eduLevelName">
								<option value="<s:property value="code"/>" <s:if test='skilledworker.eduLevelNum==code'>selected</s:if>><s:property value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>
                            
                          
                         </tr>
                         <tr>
                         	<th>出生日期：</th>
                            <td><input id="time1" type="text" name="skilledworker.birthday" value="<s:date name="skilledworker.birthday" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                            <th>&nbsp;</th>
                            <td>&nbsp;</td>
                            
                          
                         </tr>
                         -->
             	</tbody>  
                </table>
                 <div class="botn"> 
        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
            <input type="image"src="<%=basepath %>/images/baocun.jpg" />
            </div>
                
                </div> 
            </div>
                 
         </div>
         	
    
        </form>
		<%@include file="/WEB-INF/content/outside/footer.jsp"%>
    </div>
</body>
</html>
