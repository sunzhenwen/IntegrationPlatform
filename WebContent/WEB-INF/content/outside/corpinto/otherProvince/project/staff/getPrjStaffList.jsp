<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>企业人员</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/queryPrjStaffAction_queryPage.action";
		document.form1.submit();
	}

	//添加
	function save()
	{
		$(document).ready(function(){
			if ($(":checkbox:checked").length == 0)
			{
				alert("请选择人员!");
			}else
			{
				document.form1.action="<%=basepath %>/projectStaffAction_add.action";
				document.form1.submit();
			}
		});
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/projectStaffAction_queryById.action";
		document.form1.submit();
	}
</script>
</head>

<body>
<form id="form1" name="form1" method="post" action="">
	<div class="ry_wrapp">
		<div class="head">
  			<div class="head_a1">
          		<p class="logo"><img src="images/lg.png"></p>
          		<div class="head_a3">
          			<div class="header-search"></div>
          		</div>
  			</div>
		</div>
<div class="wz">
            	<dl>
                	<dt>当前位置：企业人员</dt>
                    
                </dl>
      </div>
<div class="main" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   
    <td valign="top">
    	<div class="wr">

<div class="tit"><img src="images/titico2.gif"/><strong>企业人员</strong>
  <p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
  
  <div class="main "  style="line-heigth:24px;">
  
            	<table width="98%" border="0" cellspacing="0" cellpadding="0" style="min-height:100px;">
                  <tr>
                   <td width="12%"><label>人员名称：</label>
                   </td>
                  
                    <td width="35%">
					<input type="text" name="condition.personName" value = "<s:property value = "condition.personName"/>" class="ipu1" />
                    <input type="hidden" name="condition.corpCode" value = "<s:property value = "condition.corpCode"/>" />
					</td>
                    <td width="28%"><label>证件号码：</label></td>
                    <td width="25%">
					<input name="condition.idCard" value = "<s:property value = "condition.idCard"/>"  class="ipu1" />
					</td>
                    <td><input name="input4" type="button" class="btn" value="搜索" onclick="queryCorpInfo()" /></td>
                    <td><input name="input2" type="button" class="btn" value="添加" onclick="save()"/></td>
                    <td><input name="input3" type="button" class="btn" value="返回" onclick="goBack()" /></td>
                  </tr>
                  
                  
                </table>
				
</div>
  <div class="ry_liebiao">
    <p class="f16 pd10 fb">企业人员列表<img src="images/ry_lie.png" /></p>
    <input type="hidden" name="otherPrjId" value="<s:property value="otherPrjId"/>"/>
    <table class="" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
			<th>选择</th>
	        <th>序号</th>
			<th>姓名</th>
			<th>证件号码</th>
        </tr>
        
        
		<s:iterator status="i" value="currentPage.data" > 
        	<tr>
            	<td>
                    <input name="projectPersons" type="checkbox" value="<s:property value="personName"/>^<s:property value="idCard"/>" />
                </td>
                <td><s:property value="#i.count"/></td>
                <td><s:property value="personName"/></td>
                <td><s:property value="idCard"/></td>
             </tr>
		</s:iterator>
		
      </tbody>
    </table>

    <%@include file="/WEB-INF/content/inc/page.jsp"%> 
  </div></td>
 </tr>
</table>

</div>
</form>
</body>
</html>
