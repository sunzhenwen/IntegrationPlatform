<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>设计企业信息</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/contractCorpQualAction_queryPageB.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split("^&*"); //字符分割 

		var CONTRACTORCORPNAME = strs[0];
		var TITLELEVE = strs[1];
		var CONSTRUCTORNAME = strs[2];
		var PHONE = strs[3];
		var CONTRACTORCORPCODE = strs[4];

		parent.document.getElementById("designUnit").value=CONTRACTORCORPNAME;
		parent.document.getElementById("designUnitQualificationLevel").value=TITLELEVE;
		parent.document.getElementById("designUnitCharge").value=CONSTRUCTORNAME;
		parent.document.getElementById("designUnitPhone").value=PHONE;
		parent.document.getElementById("designCorpCode").value=CONTRACTORCORPCODE;
		
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>设计企业信息选择</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>时间：</td>
                        <td colspan="3">
                        <input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
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
            	<p class="f16 fb">设计企业信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>项目名称</th>
							<th>标段名称</th>
							<th>合同类别</th>
							<th>承包单位名称</th>
							<th>资质等级</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio"
                          	 name="corpRadio" 
                          	 value="<s:property value="CONTRACTORCORPNAME"/>^&*<s:property value="TITLELEVE"/>^&*<s:property value="CONSTRUCTORNAME"/>^&*<s:property value="PHONE"/>^&*<s:property value="CONTRACTORCORPCODE"/>">
                          	 </td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="PRJNAME"/></td>
                            <td><s:property value="SECTIONNAME"/></td>
                            <td><s:property value="CONTRACTTYPENAME"/></td>
                            <td><s:property value="CONTRACTORCORPNAME"/></td>
                            <td><s:property value="TITLELEVE"/></td>
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
