<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册人员基本信息 </title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/queryCorpFilingsAction_queryPage.action";
		document.form1.submit();
	}

	//查询企业详细
	function queryCorp(corpId)
	{
		var url="<%=basepath %>/queryCorpFilingsAction_queryCorpInfo.action?corpId="+corpId;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        <form>
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>企业备案审批查询</h2>
            	<table class="ry_left left">
            	<!-- 
                	<tr>
                        <td>时间：</td>
                        <td colspan="3">
                        <input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                -->
                    <tr >
                        <td>企业名称：</td>
                        <td>
                        <input type = "text" name="condition.corpName" value = "<s:property value = "condition.corpName"/>" />
                        </td>
                        <td >组织机构改代码：</td>
                        <td>
                        <input type = "text" name="condition.corpCode" value = "<s:property value = "condition.corpCode"/>" />
                        </td>
                    </tr>
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" onclick="queryCorpInfo()" src="<%=basepath %>/images/ry_look.png" /></td>
                       
                        
                    </tr>
                </table>		
            
            </div>
            </form>
            <div class="ry_liebiao">
            	<p class="f16 fb">企业备案审批查询<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
							<th>企业名称</th>
							<th>组织机构代码</th>
							</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td>
                            <a href="#" onclick="queryCorp('<s:property value="corpId"/>')">
                            <s:property value="corpName"/>
                            </a>
                            </td>
                            <td><s:property value="corpCode"/></td>
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
