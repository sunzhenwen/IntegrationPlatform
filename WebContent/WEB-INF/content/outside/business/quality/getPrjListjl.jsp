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
		document.form1.action="<%=basepath %>/QualityjlAction_queryPagejl.action";
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
		var contractorCorpName = strs[2];
		var directorName = strs[3];
		var directorIdCard=strs[4];
		var phone=strs[5];
		var safetyName=strs[6];
		var safetyIdCard=strs[7];
		var contractorCorpCode=strs[8];
		//alert(contractorCorpCode);
		//parent.document.getElementById("recordId").value=recordId;  
		parent.document.getElementById("contractorCorpNamejl").value=contractorCorpName;
		parent.document.getElementById("directorName").value=directorName;
		parent.document.getElementById("directorIdCard").value=directorIdCard;
		parent.document.getElementById("phoneJLL").value=phone;
		parent.document.getElementById("safetyName").value=safetyName;
		parent.document.getElementById("safetyIdCard").value=safetyIdCard;
		parent.document.getElementById("phoneAQ").value=phone;
		parent.document.getElementById("contractorCorpCode").value=contractorCorpCode;
		//parent.document.getElementById("constructorNamelw").focus();
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/QualitykcxAction_queryPagekc.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>监理单位选择</h2>
            	<table class="ry_left left">
               
                    <tr >
                        <td>单位名称：</td>
                        <td>
                        <input type="text" name="condition.contractorCorpName" value = "<s:property value = "condition.contractorCorpName"/>" />
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
            	<p class="f16 fb">监理单位信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>单位名称</th>
							<th>单位负责人</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" value="<s:property value="recordId"/>^&*<s:property value="prjNum"/>^&*<s:property value="contractorCorpName"/>^&*<s:property value="directorName"/>^&*<s:property value="directorIdCard"/>^&*<s:property value="phoneJL"/>^&*<s:property value="safetyName"/>^&*<s:property value="safetyIdCard"/>^&*<s:property value="contractorCorpCode"/>"></td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="contractorCorpName"/></td>
                            <td><s:property value="directorName"/></td>                       
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
