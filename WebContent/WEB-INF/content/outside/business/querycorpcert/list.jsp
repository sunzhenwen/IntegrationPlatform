<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业拥有资质 </title>
<script type="text/javascript">

//查询
function queryTitle()
{
	document.form1.action="<%=basepath %>/queryCorpCertAction_queryPage.action";
	document.form1.submit();
}
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryCorpCertAction_goBack.action";
		document.form1.submit();
	}
	
	//操作提示信息
	function getMessage()
	{
		var message = document.getElementById("message").value;
		if(message != "")
		{
			alert(message);
		}
	}
	
</script>
</head>

<body onload="getMessage()" >
	<div class="ry_wrapp">
      
        <div class="ry_content">
        <form id="form1" name="form1" method="post" action="">
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              		<h2>企业拥有资质</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>专业类别：</td>
                        <td>
                        <input type="text" name="condition.tradeBoundName" value="<s:property value="condition.tradeBoundName"/>" />
						</td>
                        <td>资质等级：</td>
                        <td>
                        <input type="text" name="condition.titleLevel" value="<s:property value="condition.titleLevel"/>" />
						</td>
                    </tr>
				</table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/images/ry_look.png" onclick="queryTitle()" /></td>
                        <td><input type="image" src="<%=basepath %>/images/ry_return.png" onclick="goBack()" /></td>
                    </tr>
                </table>	
            
            </div>
            </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">资质详情<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>证书编号</th>
                            <th>资质资格类型</th>
                            <th>资质资格序列</th>
                            <th>专业类别</th>
                            <th>资质等级</th>
                          </tr>
                          <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/></td>
                          	<td><s:property value="certNum"/></td>
                            <td><s:property value="certName"/></td>
                            <td><s:property value="tradeTypeName"/></td>
                            <td><s:property value="tradeBoundName"/></td>
                            <td><s:property value="titleLevel"/></td>
                         </tr>
						 </s:iterator>
                	</tbody>  
                </table>
                <%@include file="/WEB-INF/content/inc/page.jsp"%> 
                
         </div>
        </div>
        <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    </div>
</body>
</html>
