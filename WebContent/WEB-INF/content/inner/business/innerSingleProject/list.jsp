<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单体工程 </title>
<base  target="_self" />  
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/innerSingleProjectAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		window.close();
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
	
	//查看
	function queryDetail(spId){
		var url = "<%=basepath %>/innerSingleProjectAction_modifyPage.action?spId="+spId;
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	
</script>
</head>

<body onload="getMessage()" >
	<div class="ry_wrapp">
      	<input id="message" type="hidden" name="message" value="<s:property value="message"/>" />
        <div class="ry_content">
        <form id="form1" name="form1" method="post" action="">
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>单体工程</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>创建日期：</td>
                        <td colspan="3">
                        <input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input id="prjNum" type="hidden" name="prjNum" value="<s:property value="prjNum"/>" />
                        <input id="foreignId" type="hidden" name="foreignId" value="<s:property value="foreignId"/>" />
                        <input id="linkName" type="hidden" name="linkName" value="<s:property value="linkName"/>" />
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
            	<p class="f16 pd10 fb">单体工程列表<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>单位编码</th>
                            <th>单位建(构)筑物名称</th>
                            <th>建筑面积(平方米)</th>
                            <th>投资额(万元)</th>
                            <th>环节名称</th>
                            <th>操作</th>
                          </tr>
                          <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="spNum"/></td>
                            <td><s:property value="buildingName"/></td>
                            <td><s:property value="buildingArea"/></td>
                            <td><s:property value="investAmount"/></td>
                            <td>
                            	<s:if test="linkName==3">
                           			 施工图审查申请
	                            </s:if>
								<s:if test="linkName==4">
	                           		 安全监督手续
	                            </s:if>
	                            <s:if test="linkName==5">
	                           		 施工许可申请
	                            </s:if>
	                            <s:if test="linkName==6">
	                           		 竣工备案申请
	                            </s:if>
                            </td>
                            <td>
                            	<a href="#" onclick="queryDetail('<s:property value="spId"/>')">查看</a>
                            	<!--<a href="innerSingleProjectAction_queryDetailPage.action?spId=<s:property value="spId"/>"><span>查看</span></a>  -->
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
