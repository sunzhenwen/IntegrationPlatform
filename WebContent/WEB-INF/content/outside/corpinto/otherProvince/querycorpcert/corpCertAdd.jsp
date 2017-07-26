<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业资质</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	//验证字段
	function check()
	{
		var check = true;
		if(document.getElementById('qualificationsType').value==""){
			alert("请选择资质资格类型!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('certId').value==""){
	   		alert("请输入证书编号!");
	   		check = false;
	   		return check;
	   	}
		if(document.getElementById('organName').value==""){
	   		alert("请输入发证机关!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time1').value==""){
	   		alert("请选择发证日期!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time5').value==""){
	   		alert("请选择证书有效期截止日期!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time3').value==""){
	   		alert("请选择首次批准资质资格日期!");
	   		check = false;
	   		return check;
		}
//		if(document.getElementById('isMasterId').value==""){
//	   		alert("请选择是否主项资质!");
//	   		check = false;
//	   		return check;
//		}
		
		return check;
	}

	//保存
	function save()
	{
		if(check())
		{
			document.form1.action="<%=basepath %>/queryOtherCorpCertAction_add.action";
			document.form1.submit();
		}
		
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryOtherCorpCertAction_queryPage.action";
		document.form1.submit();
	}
	
	//资质资格序列
	function queryTradeTypeNum() {
		$(document).ready(
			function() {
				//获取部门下拉列表的值
				var qualificationsType = $("#qualificationsType").val();
				$.ajax({
					url : 'queryOtherCorpCertAction_queryTradeTypeNum.action',
					type : 'post',
					dataType : 'json',
					data : 'qualificationsType=' + qualificationsType,
					success : function(data) {
						//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
						var items = eval("(" + data + ")");
						$("#tradeTypeNum").empty();
						$("#tradeTypeNum").append("<option value='0'>请选择</option>");
						$("#specialtyType").empty();
						$("#specialtyType").append("<option value='0'>请选择</option>");
						//循环items,i为循环下标,(默认i从0开始取值)
						$.each(items, function(i) {
							$("#tradeTypeNum").append(
								"<option value='" + items[i].code+ "'>"+ items[i].name + "</option>");
						});
					}
				});
		});
	}
	
	//资质资格等级
	function queryRating() {
		$(document).ready(
			function() {
				//获取部门下拉列表的值
				var qualificationsType = $("#qualificationsType").val();
				$.ajax({
					url : 'queryOtherCorpCertAction_queryRating.action',
					type : 'post',
					dataType : 'json',
					data : 'qualificationsType=' + qualificationsType,
					success : function(data) {
						//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
						var items = eval("(" + data + ")");
						$("#titleLevelNum").empty();
						$("#titleLevelNum").append("<option value='0'>请选择</option>");
						//循环items,i为循环下标,(默认i从0开始取值)
						$.each(items, function(i) {
							$("#titleLevelNum").append(
								"<option value='" + items[i].code+ "'>"+ items[i].name + "</option>");
						});
					}
				});
		});
	}
	
	
	//专业类别
	function querySpecialtyType() {
		$(document).ready(
			function() {
				
				//获取部门下拉列表的值
				var tradeTypeNum = $("#tradeTypeNum").val();
				$.ajax({
					url : 'queryOtherCorpCertAction_specialtyType.action',
					type : 'post',
					dataType : 'json',
					data : 'specialtyType=' + tradeTypeNum,
					success : function(data) {
						//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
						var items = eval("(" + data + ")");
						$("#specialtyType").empty();
						$("#specialtyType").append("<option value='0'>请选择</option>");
						//循环items,i为循环下标,(默认i从0开始取值)
						$.each(items, function(i) {
							$("#specialtyType").append(
								"<option value='" + items[i].code+ "'>"+ items[i].name + "</option>");
						});
					}
				});
		});
	}
</script>
</head>

<body>
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

<div class="tit"><img src="images/titico1.gif"/><strong>外省企业资质添加</strong><p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
            <div class="main h384">
            	<div class="list g2">
                	<form id="form1" name="form1" metdod="post" action="">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                         	<td width="17%">资质资格类型：</td>
                            <td width="32%">
							<select id="qualificationsType" onchange="queryTradeTypeNum();queryRating();" name="certdetail.qualificationsType" class="sel">
							<option value="">请选择</option>
							<s:iterator value="qualificationsTypes">
								<option value="<s:property value = "code" />"<s:if test='certdetail.qualificationsType==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							<span class="red">*</span>
							</td>
                            <td width="19%">资质资格序列：</td>
                            <td width="32%">
							<select id="tradeTypeNum" onchange="querySpecialtyType()" name="certdetail.tradeTypeNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="tradeTypeNums">
								<option value="<s:property value = "code" />"<s:if test='certdetail.tradeTypeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							</td>
                         </tr>
                         <tr>
                         	<td>专业类别：</td>
                            <td>
							<select id="specialtyType" name="certdetail.specialtyType" class="sel">
							<option value="">请选择</option>
							<s:iterator value="specialtyTypes">
								<option value="<s:property value = "code" />"<s:if test='certdetail.specialtyType==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							</td>
                            <td>资质资格等级：</td>
                            <td>
							<select id="titleLevelNum" name="certdetail.titleLevelNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="titleLevelNums">
								<option value="<s:property value = "code" />"<s:if test='certdetail.idCardTypeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							</td>
                         </tr>
                         <tr>
                         	<td>证书编号：</td>
                            <td>
							<input id="certId" name="certdetail.certId" type="text" value="<s:property value="certdetail.certId"/>" class="ipu1" />
							<span class="red">*</span>
							</td>
                            <td>发证机关：</td>
                            <td>
							<input id="organName" name="certdetail.organName" type="text" value="<s:property value="certdetail.organName"/>" class="ipu1" />
							<span class="red">*</span>
							</td>
                         </tr>
                         <tr>
                         	<td>发证日期：</td>
                            <td>
							<input id="time1" type="text" name="certdetail.organDate" value="<s:date name="certdetail.organDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
							<span class="red">*</span>
							</td>
                            <td>证书有效期截止日期：</td>
                            <td>
							<input id="time5" type="text" name="certdetail.endDate" value="<s:date name="certdetail.endDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
							<span class="red">*</span>
							</td>
                         </tr>
                         <tr>
                         	<td>首次批准资质资格文号：</td>
                            <td>
							<input name="certdetail.noteNumber" type="text" value="<s:property value="certdetail.noteNumber"/>" class="ipu1" />
							</td>
                            <td>首次批准资质资格日期：</td>
                            <td>
							<input id="time3" type="text" name="certdetail.noteDate" value="<s:date name="certdetail.noteDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
							<span class="red">*</span>
							</td>
                         </tr>
                         <tr>
                         	<td>是否主项资质：</td>
                            <td>
							<select id="isMasterId" name="certdetail.isMaster" class="sel">
							<option value="">请选择</option>
							<option value="0">非主项</option>
							<option value="1">主项</option>
							</select>
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
						<input type="button" class="btn" value="保存" onclick="save()" />
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
