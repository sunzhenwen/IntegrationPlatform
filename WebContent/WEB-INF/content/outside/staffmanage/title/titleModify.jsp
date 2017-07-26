<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技术职称基本信息 </title>
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
		document.form1.action="<%=basepath %>/titleAction_goList.action";
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
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/titleAction_modify.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>技术职称详细基本信息</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>姓名：</th>
								<td>
									<input type="text" maxlength='50'  name="title.personName" value="<s:property value="title.personName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
									<input type="hidden" name="title.personId" value="<s:property value="title.personId"/>"/>
								</td>
								<th>性别：</th>
								<td>
								<select name="title.sexNum" class="required">
      								<option value="">请选择</option>
		      						<s:iterator value="sexNums">
		          						<option value="<s:property value="code"/>" <s:if test='title.sexNum==code'>selected</s:if>><s:property value="name"/></option>
		      						</s:iterator>
								</select><strong><font color="#FF0000">*</font></strong>
								</td>
                            
                         </tr>
                         <tr>
                         	<th>证件类型：</th>
								<td>
								<select name="title.idCardTypeNum" class="required">
		      						<option value="">请选择</option>
		      						<s:iterator value="idCardTypeNums">
		          						<option value="<s:property value="code"/>" <s:if test='title.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
		      						</s:iterator>
								</select><strong><font color="#FF0000">*</font></strong>
								</td>
								<th>证件号码：</th>
								<td><input type="text" maxlength='50'  name="title.idCard" value="<s:property value="title.idCard"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                           <tr>
                         	<th>职称：</th>
								<td><input type="text" maxlength='50'  name="title.titleName" value="<s:property value="title.titleName"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
								<th>职称专业：</th>
								<td><input type="text" maxlength='50'  name="title.titleMajor" value="<s:property value="title.titleMajor"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>

                          
                         </tr>
                         <tr>
                         	<th>职称级别：</th>
								<td><input type="text" maxlength='50'  name="title.titleLevel" value="<s:property value="title.titleLevel"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
								<th>毕业学校：</th>
								<td><input type="text" maxlength='50'  name="title.graduatedSchool" value="<s:property value="title.graduatedSchool"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>

                         </tr>
                         
                           <tr>
                         	<th>所学专业：</th>
								<td><input type="text" maxlength='50'  name="title.studyMajor" value="<s:property value="title.studyMajor"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
								<th>毕业时间：</th>
								<td><input id="time1" maxlength='50'  type="text" name="title.graduatedDate" value="<s:date name="title.graduatedDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>


                          
                         </tr>
                         <tr>
                         	<th>手机号码：</th>
								<td><input type="text" maxlength='50'  name="title.mobile" value="<s:property value="title.mobile"/>"/>&nbsp;&nbsp;</td>
								<th></th>
								<td></td>
                            
                          
                         </tr>
                         
                      
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
