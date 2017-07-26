<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建筑企业统计报表 </title>
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/corpReportAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function addTitle()
	{
		document.form1.action="<%=basepath %>/corpReportAction_addPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/corpReportAction_goBack.action";
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
              	<h2>建筑企业统计报表</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>申请日期：</td>
                        <td colspan="3">
                        <input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                    <tr >
                        <td>年：</td>
                        <td>
                        <input id="time3" value="<s:date name="condition.reportYear" format="yyyy" />" type="text" name="condition.reportYear" onFocus="WdatePicker({dateFmt:'yyyy',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
						</td>
                        <td>季度：</td>
                        <td>
                        <select name="condition.quarter">
    						<option value="">请选择</option>
      						<option value="1">第一季度</option>
      						<option value="2">第二季度</option>
      						<option value="3">第三季度</option>
      						<option value="4">第四季度</option>
						</select>
						</td>
                    </tr>
				</table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/images/ry_look.png" onclick="queryTitle()" /></td>
                        <td><input type="image" src="<%=basepath %>/images/tianjia.png" onclick="addTitle()" /></td>
                        <td><input type="image" src="<%=basepath %>/images/ry_return.png" onclick="goBack()" /></td>
                        
                    </tr>
                </table>		
            
            </div>
            </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">建筑企业统计报表列表<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>企业名称</th>
                            <th>年</th>
                            <th>季度</th>
                            <th>填表人</th>
                            <th>添加日期</th>
                            <th>操作</th>
                          </tr>
                          <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="corpName"/></td>
                            <td><s:property value="reportYear"/></td>
                            <td><s:property value="quarter"/></td>
                            <td><s:property value="fillOut"/></td>
                            <td><s:date name="createDate" format="yyyy-MM-dd" /></td>
                            <td>
                            <a href="corpReportAction_modifyPage.action?id=<s:property value="id"/>"><span>详细</span></a>
                            	&nbsp;
                            <a href="corpReportAction_delete.action?id=<s:property value="id"/>"><span>删除</span></a>
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
