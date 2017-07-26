<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业授权 </title>
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/authorizationAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function addTitle()
	{
		document.form1.action="<%=basepath %>/authorizationAction_addPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/authorizationAction_goBack.action";
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
              	<h2>企业授权</h2>
            	<table class="ry_left left">
					<tr>
                        <td>项目名称：</td>
                        <td>
                        <input type="text" name="condition.prjName" value="<s:property value="condition.prjName"/>" />
						</td>
                        <td>项目编号：</td>
                        <td>
                        <input type="text" name="condition.prjNum" value="<s:property value="condition.prjNum"/>" />
						</td>
                    </tr>
                    <tr>
                        <td>企业名称：</td>
                        <td>
                        <input type="text" name="condition.auCorpName" value="<s:property value="condition.auCorpName"/>" />
						</td>
                        <td>企业组织机构代码：</td>
                        <td>
                        <input type="text" name="condition.auCorpCode" value="<s:property value="condition.auCorpCode"/>" />
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
            	<p class="f16 pd10 fb">企业授权<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>项目名称</th>
                            <th>项目编号</th>
                            <th>企业名称</th>
                            <th>组织机构代码</th>
                            <th>企业类型</th>
                            <th>操作</th>
                          </tr>
                          <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="prjName"/></td>
                            <td><s:property value="prjNum"/></td>
                            <td><s:property value="auCorpName"/></td>
                            <td><s:property value="auCorpCode"/></td>
                            <td>
                            <s:if test="enterpriseType==1">
                            	建设单位
                            </s:if>
                            <s:if test="enterpriseType==2">
                            	勘察单位
                            </s:if>
                            <s:if test="enterpriseType==3">
                            	设计单位
                            </s:if>
                            <s:if test="enterpriseType==4">
                            	施工单位
                            </s:if>
                            <s:if test="enterpriseType==5">
                            	监理单位
                            </s:if>
                            <s:if test="enterpriseType==6">
                            	图纸审查单位
                            </s:if>
                            <s:if test="enterpriseType==7">
                            	检测单位
                            </s:if>
                            
                            </td>
                            <td>
                            	<s:if test="enterpriseType!=1">
                            	<a href="authorizationAction_delete.action?id=<s:property value="id"/>"><span>删除</span></a>
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
