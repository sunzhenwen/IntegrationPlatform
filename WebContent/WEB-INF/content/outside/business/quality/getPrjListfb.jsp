<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>企业信息</title>
<script type="text/javascript">
	var k=<%=session.getAttribute("userrr")%>;

	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/QualityfbAction_queryPagefb.action?k="+k;
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		
		var parent=window.dialogArguments;
		var strs= new Array(); //定义一数组 
		strs=value.split("^&*"); //字符分割 
		var recordId = strs[0];
		var prjNum = strs[1];
		var contractorCorpName = strs[2];
		var constructorName = strs[3];
		var constructorNamefbdate = strs[4];
		//parent.document.getElementById("recordId").value=recordId;
		parent.document.getElementById("contractorCorpNamefb["+k+"]").value=contractorCorpName;
		//parent.document.getElementById("constructorNamefb").value=constructorName;
		parent.document.getElementById("constructorNamefbdate["+k+"]").value=constructorNamefbdate;
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/QualityfbAction_queryPagefb.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>专业分包单位信息选择</h2>
            	<table class="ry_left left">
               
                    <tr >
                        <td>单位名称：</td>
                        <td>
                        <input type="text" name="condition.contractorCorpNameFB" value = "<s:property value = "condition.contractorCorpNameFB"/>" />
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
            	<p class="f16 fb">专业分包单位信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>单位名称</th>
							<th>安全生产许可证有效期</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" value="<s:property value="recordId"/>^&*<s:property value="prjNum"/>^&*<s:property value="contractorCorpNameFB"/>^&*<s:property value="constructorNameFB"/>^&*<s:property value="constructorNamefbdate"/>"></td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="contractorCorpNameFB"/></td>
                            <td><s:property value="constructorNamefbdate"/></td>                       
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
