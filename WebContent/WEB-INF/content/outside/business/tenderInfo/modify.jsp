<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业招投标信息 </title>
<script type="text/javascript">


	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/tenderInfoAction_goList.action";
		document.form1.submit();
	}

	
</script>

</head>

<body>

	<div class="ry_wrapp">
	
	<form id="form1" name="form1" method="post" action="<%=basepath %>/tenderInfoAction_modify.action" enctype="multipart/form-data">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业招投标信息</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>中标通知书编号：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.tenderNum"/>
							</td>
							<th>项目编号：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.prjNum"/>
							</td>
                         </tr>
                         <tr>
                         	<th>招标类型：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.tenderClassName"/>
							</td>
							<th>招标方式：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.tenderTypeName"/>
							</td>
                         </tr>
                         <tr>
                         	<th>中标日期：</th>
							<td colspan="2" align="left">
							<s:date name="tenderInfo.tenderResultDate" format="yyyy-MM-dd" />
							</td>
							<th>中标金额：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.tenderMoney"/>元
							</td>
						</tr>
                        <tr>
                         	<th>建设规模：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.prjSize"/>
							</td>
							<th>面积(平方米)：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.area"/>
							</td>
						</tr>
                        <tr>
                         	<th>招标代理单位名称：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.agencyCorpName"/>
							</td>
							<th>招标代理单位组织机构代码：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.agencyCorpCode"/>
							</td>
						</tr>
                        <tr>
                       		<th>中标单位名称：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.tenderCorpName"/>
							</td>
							<th>中标单位组织机构代码：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.tenderCorpCode"/>
							</td>
                        </tr>
                        <tr>
                       		<th>项目经理/总监理工程师姓名：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.constructorName"/>
							</td>
							<th>项目经理/总监理工程师证件类型：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.idCardTypeName"/>
							</td>
                        </tr>
                        <tr>
                       		<th>项目经理/总监理工程师证件号码：</th>
							<td colspan="2" align="left">
							<s:property value="tenderInfo.constructorIdCard"/>
							</td>
							<th>记录登记时间：</th>
							<td colspan="2" align="left">
							<s:date name="tenderInfo.createDate" format="yyyy-MM-dd" />
							</td>
                        </tr>
                        
                </tbody> 
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		        </div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
