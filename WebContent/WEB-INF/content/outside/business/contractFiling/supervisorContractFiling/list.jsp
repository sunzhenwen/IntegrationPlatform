<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业监理合同备案 </title>
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/supervisorContractFilingAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function addTitle()
	{
		document.form1.action="<%=basepath %>/supervisorContractFilingAction_addPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/filingIndexContractFilingAction_filingIndex.action";
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
              	<h2>企业监理合同备案</h2>
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
                        <td>项目名称：</td>
                        <td>
                        <input type="text" name="condition.prjName" value="<s:property value="condition.prjName"/>" />
						</td>
                        <td>项目编号：</td>
                        <td>
                        <input type="text" name="condition.prjNum" value="<s:property value="condition.prjNum"/>" />
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
            	<p class="f16 pd10 fb">企业监理合同备案<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>项目名称</th>
                            <th>项目编号</th>
                            <th>合同名称</th>
                            <th>合同编号</th>
                            <th>申请日期</th>
                            <th>备案状态</th>
                            <th>操作</th>
                          </tr>
                          <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/></td>
                            <td><s:property value="prjName"/></td>
                            <td><s:property value="prjNum"/></td>
                            <td><s:property value="sectionName"/></td>
                            <td><s:property value="contractNum"/></td>
                            <td><s:date name="createDate" format="yyyy-MM-dd" /></td>
                            <td>
                            	<s:if test="appType==0">
                            		申请已提交
                            	</s:if>
                            	<s:if test="appType==1">
                            		备案通过
                            	</s:if>
                            	<s:if test="appType==2">
                            		备案未通过
                            	</s:if>
                            </td>
                            <td>
                            <s:if test="appType==0">
                            	<a href="supervisorContractFilingAction_modifyPage.action?recordId=<s:property value="recordId"/>"><span>修改</span></a>	
                            	&nbsp;
                            	<a href="supervisorContractFilingAction_delete.action?recordId=<s:property value="recordId"/>"><span>删除</span></a>
                            </s:if>
                            <s:if test="appType==2">
                            	<a href="supervisorContractFilingAction_delete.action?recordId=<s:property value="recordId"/>"><span>删除</span></a>
                            </s:if>
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
