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
		document.form1.action="<%=basepath %>/QualitykcAction_queryPagekc.action";
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
		var constructorName = strs[3];
		//parent.document.getElementById("recordId").value=recordId;
		parent.document.getElementById("contractorCorpName").value=contractorCorpName;
		parent.document.getElementById("constructorName").value=constructorName;
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/QualitykcxAction_queryPagekc.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>勘察单位选择</h2>
            	<table class="ry_left left">
               
                    <tr >
                        <td>单位名称：</td>
                        <td>
                        <input type="text" name="condition.contractorCorpNameKC" value = "<s:property value = "condition.contractorCorpNameKC"/>" />
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
            	<p class="f16 fb">勘察单位选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
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
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" value="<s:property value="recordId"/>^&*<s:property value="prjNum"/>^&*<s:property value="contractorCorpName"/>^&*<s:property value="constructorName"/>"></td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="contractorCorpName"/></td>
                            <td><s:property value="constructorName"/></td>                       
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
