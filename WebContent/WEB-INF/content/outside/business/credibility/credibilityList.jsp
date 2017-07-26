<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业安全监督查询 </title>
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/querySafetyAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryCredAction_query.action";
		document.form1.submit();
	}
	
</script>
</head>

<body>
	<div class="ry_wrapp">

        
        <form id="form1" name="form1" method="post" action="">
            </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">企业不良信息查询列表<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>企业名称</th>
                            <th>组织机构代码</th>
                            <th>企业类型</th>
                            <th>处罚决定内容</th>
                            <th>处罚日期</th>
                            <th>操作</th>                  
                          </tr>
                          <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/></td>
                            <td><s:property value="corpname"/></td>
                            <td><s:property value="corpcode"/></td>
                            <td><s:property value="certtypenum"/></td>
                             <td><s:property value="punishcontent"/></td>
							<td><s:property value="punishdate"/></td>
                             
                            <td>
                            	<a href="queryCredAction_queryPagee.action?corpbadcreditid=<s:property value="corpbadcreditid"/>"><span>详细</span></a>	
                         </tr>
						 </s:iterator>
                         
                	</tbody>  
                </table>
                  <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/ry_return.png" onclick="goBack()" />
            	</div>
                <%@include file="/WEB-INF/content/inc/page.jsp"%> 
                
         </div>
        </div>
        <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    </div>
</body>
</html>
