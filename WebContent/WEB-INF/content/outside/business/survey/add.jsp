<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业项目勘察申请 </title>
<script type="text/javascript">

	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/surveyAction_goList.action";
		document.form1.submit();
	}

	function checkForeignCorp()
	{
		var node = $("#isUnits").val();
		if(node=="0")
		{
			$('#unitId').show();
			$(addTr).after("<tr><td><input type='text' name='surveyQualification["+i+"].qualifName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='surveyQualification["+i+"].certTypeName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='surveyQualification["+i+"].titleLevelName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='surveyQualification["+i+"].certId' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><a href='#' onclick='deleteCurrentRow(this)'>删除</a></td><tr/>");
		}else
		{
			$('#unitId').hide();
		}
	}
	
	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath %>/designSurveyPrjsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
</script>
<script type="text/javascript">
	var i = 0;
    //添加行
	function onAddTR(trObj)
    {
    	i = i+1;
    	$(addTr).after("<tr><td><input type='text' name='surveyQualification["+i+"].qualifName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='surveyQualification["+i+"].certTypeName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='surveyQualification["+i+"].titleLevelName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='surveyQualification["+i+"].certId' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><a href='#' onclick='deleteCurrentRow(this)'>删除</a></td><tr/>");
    }
    //删除指定行
    function deleteCurrentRow(obj){   
		var tr=obj.parentNode.parentNode;   
		var tbody=tr.parentNode;   
		tbody.removeChild(tr);   
	}   
</script>
</head>

<body onload="checkForeignCorp()" >
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/surveyAction_add.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业项目勘察申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="survey.prjName" value="<s:property value="prjName"/>" class="required"/><strong><font color="#FF0000">*</font></strong><a href="#" onclick="queryPrjName()">选择</a>
							<input id="prjId" type="hidden" name="survey.prjId" value="<s:property value="prjId"/>"/>
							<input type="hidden" name="survey.corpName" value="<s:property value="corpName"/>"/>
							</td>
							<th>项目编号：</th>
							<td colspan="2" align="left">
							<input id="prjNum" type="text" readonly name="survey.prjNum" value="<s:property value="prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>勘察单位名称：</th>
							<td align="left">
							<input type="text" name="survey.surveyCorpName" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>勘察单位组织机构代码：</th>
							<td colspan="2" align="left">
							<input type="text" name="survey.surveyCorpCode" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							<th>是否添加资质：</th>
							<td>
							<select id="isUnits" name="survey.isUnits" onchange="checkForeignCorp()" class="required" >
                    			<option value="">请选择</option>
                    			<option value="0">是</option>
                    			<option value="1">否</option>
                			</select><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" type="hidden" name="survey.appDeptName" value="<s:property value="survey.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="survey.appDept" value="<s:property value="survey.appDept"/>"/>
							</td>
							<th>&nbsp;</th>
							<td colspan="2">
							&nbsp;
							</td>
						</tr>
                        
                </tbody>  
                <tbody id="unitId">
                	<tr>
                       	<td colspan="5"><a href="#" onclick="onAddTR(this)">添加</a></td>
                    </tr>
                    <tr id="addTr">
                    	<th>资质名称：</th>
                      	<th>资质类型：</th>
                      	<th>资质等级：</th>
						<th>证书编号：</th>
						<th>操作</th>
                 	</tr>
                </tbody>  
                
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		            <input type="image"src="<%=basepath %>/images/shangbao.jpg" />
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
