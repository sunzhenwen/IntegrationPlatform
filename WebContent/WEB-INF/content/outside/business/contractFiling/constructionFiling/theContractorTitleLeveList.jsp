<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>施工总包资质信息选择</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/theContractorTitleLeveAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split(","); //字符分割 
		var qualificationsTypeName = strs[0];
		var specialtyTypeName = strs[1];
		var ratingName = strs[2];
		var qualificationsType = strs[3];
		var specialtyType = strs[4];
		var rating = strs[5];
		
		parent.document.getElementById("titleLeve").value=specialtyTypeName+""+ratingName;
		parent.document.getElementById("qualificationsTypeName").value=qualificationsTypeName;
		parent.document.getElementById("specialtyTypeName").value=specialtyTypeName;
		parent.document.getElementById("ratingName").value=ratingName;
		parent.document.getElementById("qualificationsType").value=qualificationsType;
		parent.document.getElementById("specialtyType").value=specialtyType;
		parent.document.getElementById("rating").value=rating;
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>施工总包资质信息选择</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>企业名称：</td>
                        <td colspan="3">
                        <input name="condition.corpName" value="<s:property value = "condition.corpName"/>" type="text"  />
                        <input type="hidden" name="condition.prjNum" value = "<s:property value = "condition.prjNum"/>" />
                        </td>
                    </tr>
                    
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" onclick="queryCorpInfo()" src="<%=basepath %>/images/ry_look.png" /></td>
                        <td>&nbsp;</td>
                    </tr>
                </table>		
            
            </div>
            
            <div class="ry_liebiao">
            	<p class="f16 fb">施工总包资质信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
                         	<th>企业名称</th>
							<th>资质资格类型</th>
							<th>专业类别</th>
							<th>资质资格等级</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio"
                          	 name="corpRadio" 
                          	 value="<s:property value="qualificationsTypeName"/>,<s:property value="specialtyTypeName"/>,<s:property value="ratingName"/>,<s:property value="qualificationsType"/>,<s:property value="specialtyType"/>,<s:property value="rating"/>">
                          	 </td>
                          	<td><s:property value="#i.count"/> </td>
                          	<td><s:property value="corpName"/></td>
                            <td><s:property value="qualificationsTypeName"/></td>
                            <td><s:property value="specialtyTypeName"/></td>
                            <td><s:property value="ratingName"/></td>
                         </tr>
						</s:iterator>
                
                	</tbody>  
                </table>
                
                
         </div>
    	</div>
        </form>
    </div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>
