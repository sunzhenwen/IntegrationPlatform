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
		document.form1.action="<%=basepath %>/threePersonAction_goList.action";
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
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/threeTypePersonAction_modify.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>三类人员基本信息</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>姓名：</th>
							<td><input type="text" maxlength='50' name="threeTypePerson.FName" value="<s:property value="threeTypePerson.FName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input type="hidden" name="threeTypePerson.threeTypePersonId" value="<s:property value="threeTypePerson.threeTypePersonId"/>"/></td>
							<th>身份证号：</th>
							<td>
							<input type="text" maxlength='20' name="threeTypePerson.FIdCertNo" value="<s:property value="threeTypePerson.FIdCertNo"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>所在单位：</th>
							<td>
							<input type="text" maxlength='60' name="threeTypePerson.FEntName" value="<s:property value="threeTypePerson.FEntName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>证书类别：</th>
							<td><input type="text" maxlength='50' name="threeTypePerson.FCertType" value="<s:property value="threeTypePerson.FCertType"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                         	<th>单位：</th>
							<td><input type="text" maxlength='60'  name="threeTypePerson.FEntName1" value="<s:property value="threeTypePerson.FEntName1"/>"  class="required"/><strong><font color="#FF0000">*</font></strong></td>
							<th>证书编号：</th>
							<td><input type="text" maxlength='50'  name="threeTypePerson.FCertNumber" value="<s:property value="threeTypePerson.FCertNumber"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
						 </tr>
                         <tr>
                         	<th>发证日期：</th>
							<td>
							<input id="time1" value="<s:date name="threeTypePerson.FRegDate" format="yyyy-MM-dd" />" type="text" name="threeTypePerson.FRegDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>结束日期：</th>
							<td>
							<input id="time2" value="<s:date name="threeTypePerson.FRegEndDate" format="yyyy-MM-dd" />" type="text" name="threeTypePerson.FRegEndDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                </tbody>  
               </table>
                 <div class="botn"> 
        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
            </div>
                
                </div> 
            </div>
                 
         </div>
         	
    
      </form>
		<%@include file="/WEB-INF/content/outside/footer.jsp"%>  
    </div>
</body>
</html>
