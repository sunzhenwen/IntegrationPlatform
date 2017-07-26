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
		document.form1.action="<%=basepath %>/scenesafeAction_queryPagee.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split(","); //字符分割 
		var prjnamee = strs[0];
		var prjnumm = strs[1];
		var builderlicencenum = strs[2];
 
		parent.document.getElementById("prjnamee").value=prjnamee;
		parent.document.getElementById("prjnumm").value=prjnumm;
		parent.document.getElementById("builderlicencenum").value=builderlicencenum;
 
		 
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/queryPrjsAction_queryPage.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>项目信息选择</h2>
            	<table class="ry_left left">
                	
                    <tr >
                        <td>项目编号：</td>
                        <td>
                        <input type="text" name="condition.prjnumm" value = "<s:property value = "condition.prjnumm"/>" />
                        </td>
                        <td>项目名称：</td>
                        <td>
                        <input name="condition.prjnamee" value = "<s:property value = "condition.prjnamee"/>" />
                        <input type="hidden" name="condition.corpCode" value = "<s:property value = "condition.corpCode"/>" />
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
							<th>项目名称</th>
							<th>项目编号</th>
							<th>施工许可证</th>
							
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" value="<s:property value="prjnamee"/>,<s:property value="prjnumm"/>,<s:property value="builderlicencenum"/> "></td>
                          	<td><s:property value="#i.count"/> </td>                          
                            <td><s:property value="prjnamee"/></td>
                             <td><s:property value="prjnumm"/></td>
                            <td><s:property value="builderlicencenum"/></td>                           
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
