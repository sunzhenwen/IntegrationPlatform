<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不良行为代码</title>
<base target="_self" />
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/queryCreditCodeAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		var strs= new Array(); //定义一数组 
		strs=value.split(","); //字符分割 
		var beHavior = strs[0];
		var beHviorCode = strs[1];
		var punishBasis = strs[2];
		parent.document.getElementById("beHavior").value=beHavior;
		parent.document.getElementById("beHviorCode").value=beHviorCode;
		parent.document.getElementById("punishBasis").value=punishBasis;
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/queryCreditCodeAction_queryPage.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>不良行为代码选择</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>行为代码：</td>
                        <td>
                        <input type = "text" name="condition.beHviorCode" value = "<s:property value = "condition.beHviorCode"/>" />
                        </td>
                        <td>不良行为：</td>
                        <td>
                        <input type = "text" name="condition.badBeHavior" value = "<s:property value = "condition.badBeHavior"/>" />
                        </td>
                    </tr>
                    <tr>
                        <td>法律依据：</td>
                        <td>
                        <input type = "text" name="condition.legalBasis" value = "<s:property value = "condition.legalBasis"/>" />
                        </td>
                        <td>处罚依据：</td>
                        <td>
                        <input type = "text" name="condition.punishBasis" value = "<s:property value = "condition.punishBasis"/>" />
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
            	<p class="f16 fb">不良行为代码选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>行为类别</th>
							<th>行为代码</th>
							<th>不良行为</th>
							<th>法律依据</th>
							<th>处罚依据</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" value="<s:property value="beHavior"/>,<s:property value="beHviorCode"/>,<s:property value="punishBasis"/>"></td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="beHavior"/></td>
                            <td><s:property value="beHviorCode"/></td>
                            <td><s:property value="badBeHavior"/></td>
                            <td><s:property value="legalBasis"/></td>
                            <td><s:property value="punishBasis"/></td>
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
