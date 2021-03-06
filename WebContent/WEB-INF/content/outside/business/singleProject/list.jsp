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
		document.form1.action="<%=basepath %>/singleProjectAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function addTitle()
	{
		document.form1.action="<%=basepath %>/singleProjectAction_addPage.action";
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
			alert("当前项目未经过报建审批,无法添加单体工程!");
		}
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
                        <td>单位编码：</td>
                        <td>
                        <input type="text" name="condition.spNum" value="<s:property value="condition.spNum"/>" />
                        <input id="prjNum" type="hidden" name="prjNum" value="<s:property value="prjNum"/>" />
                        <input id="linkName" type="hidden" name="linkName" value="<s:property value="linkName"/>" />
                        <input id="prjId" type="hidden" name="prjId" value="<s:property value="prjId"/>" />
                        <input id="message" type="hidden" name="message" value="<s:property value="message"/>" />
                        </td>
                        <td>单位建(构)筑物名称：</td>
                        <td>
                        <input type="text" name="condition.buildingName" value="<s:property value="condition.buildingName"/>" />
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
                            	<a href="singleProjectAction_modifyPage.action?spId=<s:property value="spId"/>"><span>修改</span></a>
                            	&nbsp;
                            	<a href="singleProjectAction_delete.action?spId=<s:property value="spId"/>&prjNum=<s:property value="prjNum"/>&foreignId=<s:property value="foreignId"/>&linkName=<s:property value="linkName"/>"><span>删除</span></a>
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
