<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发改合同 </title>
<script type="text/javascript">

	//提交
	function sub()
	{
		document.form1.action="<%=basepath %>/reformAction_sub.action";
		document.form1.submit();
	}	

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/fileWorldAction_goReform.action";
		document.form1.submit();
	}	
</script>
</head>

<body onload="getMessage()" >
	<div class="ry_wrapp">
      
        <div class="ry_content">
        <form id="form1" name="form1" method="post" action="">
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>发改合同</h2>
            		
                <table class="ry_right right">
                	<tr>
                        <td>
                        <input type="hidden" name="recordId" value="<s:property value="recordId"/>" />
                        <input type="image" src="<%=basepath %>/images/ry_sub.png" onclick="sub()" />
                        <input type="image" src="<%=basepath %>/images/ry_return.png" onclick="goBack()" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                </table>		
            
            </div>
            </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">发改合同<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>名称</th>
                            <th>操作</th>
                          </tr>
                          <s:iterator status="i" value="list" > 
                          <tr>
                          	<td><s:property value="#i.count"/></td>
                            <td><s:property value="zhConName"/></td>
                            <td>
                            	<s:if test="isLocking==0">
                            		<s:if test="checkType==1">
                            			<a href="fileWorldAction_queryConMessage.action?conId=<s:property value="conId"/>&checkType=<s:property value="checkType"/>&recordId=<s:property value="recordId"/>"><span>编辑</span></a>
                            			<a href="fileWorldAction_delete.action?conId=<s:property value="conId"/>&checkType=<s:property value="checkType"/>&recordId=<s:property value="recordId"/>&conType=<s:property value="conType"/>"><span>还原模板</span></a>
                            		</s:if>
                            		<s:if test="checkType==0">
                            			<a href="fileWorldAction_queryConMessage.action?conId=<s:property value="conId"/>&checkType=<s:property value="checkType"/>&recordId=<s:property value="recordId"/>"><span>编辑</span></a>
                            		</s:if>
                            	</s:if>
                            	<s:if test="isLocking==1">
                            		已锁定
                            		&nbsp;&nbsp;
                            		<a href="fileWorldAction_viewDetails.action?conId=<s:property value="conId"/>"><span>查看</span></a>
                            	</s:if>
                            </td>
                         </tr>
						 </s:iterator>
                         
                	</tbody>  
                </table>
         </div>
        </div>
        <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    </div>
</body>
</html>
