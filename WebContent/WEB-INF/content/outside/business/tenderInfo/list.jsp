<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业招投标信息 </title>
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/tenderInfoAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function add()
	{
		document.form1.action="<%=basepath %>/tenderInfoAction_addPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/tenderInfoAction_goBack.action";
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
              	<h2>企业招投标信息</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>项目信息：</td>
                        <td colspan="3">
                        <select name="condition.prjNum">
     						<option value="">请选择</option>
	      					<s:iterator value="list">
	          					<option value="<s:property value="prjNum"/>" <s:if test='condition.prjNum==prjNum'>selected</s:if>><s:property value="prjName"/></option>
	      					</s:iterator>
						</select>
                        </td>
                    </tr>
                    
				</table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/images/ry_look.png" onclick="queryTitle()" /></td>
                        <td><input type="image" src="<%=basepath %>/images/ry_return.png" onclick="goBack()" /></td>
                        <!-- 
                        <td><input type="image" src="<%=basepath %>/images/tianjia.png" onclick="add()" /></td>
                         -->
                    </tr>
                </table>		
            
            </div>
            </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">企业招投标信息列表<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>中标通知书编号</th>
                            <th>项目编号</th>
                            <th>招标类型</th>
                            <th>招标方式</th>
                            <th>中标单位名称</th>
                            <th>操作</th>
                          </tr>
                          <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/></td>
                            <td><s:property value="tenderNum"/></td>
                            <td><s:property value="prjNum"/></td>
                            <td><s:property value="tenderClassName"/></td>
                            <td><s:property value="tenderTypeName"/></td>
                            <td>
                            	<s:property value="tenderCorpName"/>
                            </td>
                            <td>
                            <a href="tenderInfoAction_queryTenderById.action?tenderNum=<s:property value="tenderNum"/>"><span>查看</span></a>
                            </td>
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
