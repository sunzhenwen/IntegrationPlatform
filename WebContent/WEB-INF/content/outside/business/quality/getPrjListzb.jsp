<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>企业信息</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/QualityzbAction_queryPagezb.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split("^&*"); //字符分割 
		var recordId = strs[0];
		var prjNum = strs[1];
		var sectionName = strs[2];
		var projectAddress = strs[3];
		var contractorCorpName= strs[4];
		var contractstart= strs[5];
		var contractend= strs[6];
		//parent.document.getElementById("recordId").value=recordId;
		parent.document.getElementById("contractorCorpNamezb").value=contractorCorpName;
		parent.document.getElementById("sectionName").value=sectionName;
		parent.document.getElementById("projectAddress").value=projectAddress;
		parent.document.getElementById("contractstart").value=contractstart;
		parent.document.getElementById("contractend").value=contractend;
		//alert(contractstart);
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/QualityzbAction_queryPagezb.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>项目信息选择</h2>
            	<table class="ry_left left">
               
                    <tr>
                        <td>工程名称：</td>
                        <td>
                        <input type="text" name="condition.sectionName" value = "<s:property value = "condition.sectionName"/>" />
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
            	<p class="f16 fb">项目信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>工程名称</th>
							<th>合同备案编号</th>
							<th>工程地址</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" value="<s:property value="recordId"/>^&*<s:property value="prjNum"/>^&*<s:property value="sectionName"/>^&*<s:property value="projectAddress"/>^&*<s:property value="contractorCorpNameZCB"/>^&*<s:date name="contractStart" format="yyyy-MM-dd" />^&*<s:date name="contractEnd" format="yyyy-MM-dd" />"></td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="sectionName"/></td>
                            <td><s:property value="recordNum"/></td>
                            <td><s:property value="projectAddress"/></td>                       
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
