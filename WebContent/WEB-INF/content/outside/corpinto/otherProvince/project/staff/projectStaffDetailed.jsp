<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业项目人员备案</title>
<link rel="stylesheet" href="<%=basepath %>/css/style.css" type="text/css" >
<link href="<%=basepath %>/css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
	//验证字段
	function check()
	{
		var check = true;
		if(document.getElementById('otherPrjId').value==""){
			alert("请选择项目!");
	   		check = false;
	   		return check;
		}
		return check;
	}
	
	//保存
	function save()
	{
		if(check())
		{
			document.form1.action="<%=basepath %>/projectStaffAction_modify.action";
			document.form1.submit();
		}
		
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/projectStaffAction_goBack.action";
		document.form1.submit();
	}

	
	//查询项目
	function queryProjectDetailed()
	{
		if(check())
		{
			document.form1.action="<%=basepath %>/projectStaffAction_queryById.action";
			document.form1.submit();
		}
	}

	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=OtherProjectSuccess";
		document.form1.submit();
	}
	
	//查询人员
	function queryPrjStaff()
	{
		if(check()){
			document.form1.action="<%=basepath %>/queryPrjStaffAction_queryPage.action";
			document.form1.submit();
		}
	}
</script>
</head>

<body>
	<div class="qy_wrapp">
    	<div class="head">
            <div class="head_a1">
               <p class="logo"><img src="images/lg.png"></p>
                 <div class="head_a3">
                     <div class="header-search"> 
                     </div>
                 </div>
            </div>
        </div>
     
     
     
     
     
      <div class="wz">
      	<dl>
           	<dt>当前位置：外省企业项目人员备案</dt>
        </dl>
      </div>    
     
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   
    <td valign="top">
    	<div class="wr">

<div class="tit"><img src="images/titico1.gif"/><strong>外省企业项目人员备案</strong><p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
            <div class="main h384">
            	<div class="list g2">
				<form id="form1" name="form1" method="post" action="" enctype="multipart/form-data">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                        <td width="17%"><label>项目名称：</label></td>
                        <td width="32%">
						<select id="otherPrjId" name="otherPrjId" class="sel">
							<option value="">请选择</option>
							<s:iterator value="projectList">
								<option value="<s:property value = "otherPrjId" />"<s:if test='construction.otherPrjId==otherPrjId'>selected</s:if>><s:property value="prjName" /></option>
							</s:iterator>
						</select>
						<a href="#" onclick="queryProjectDetailed()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
                        </td>
                        <td width="19%"><label>项目编号：</label></td>
                        <td width="32%">
						<input id="prjNum" type="text" readonly name="construction.prjNum" value="<s:property value="construction.prjNum"/>" class="ipu1"/>
						</td>
                      </tr>
                      <tr>
                        <td><label>企业名称：</label></td>
                        <td>
						<input type="text" readonly name="construction.corpName" value="<s:property value="construction.corpName"/>" class="ipu1"/>
                        </td>
                        <td><label>组织机构代码：</label></td>
                        <td>
						<input type="text" readonly name="construction.corpCode" value="<s:property value="construction.corpCode"/>" class="ipu1"/>
                        </td>
                      </tr>
                      <tr>
                        <td colspan="4">&nbsp;</td>
                      </tr>
                      <tr>
                        <td colspan="4"><font color="red"><strong>建筑企业外省附件上传</strong></font></td>
                      </tr>
                      <s:iterator status="i" value="construction.accessoryList">
							<tr>
                       		<td colspan="4" align="left">
                       		<s:property value="#i.count"/>、<s:property value="message"/>
                       		<br />
                       		<font color="#0000CC"><strong>附件下载</strong></font>
                       		<br />
                       		<s:iterator status="k" value="list">
								<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a><br />
							</s:iterator>
                       		</td>
							</tr>
					  </s:iterator>
					  <tr>
                        <td colspan="4">&nbsp;</td>
                      </tr>
					  <tr>
                        <td colspan="4"><font color="red"><strong>监理企业外省附件上传</strong></font></td>
                      </tr>
                      <s:iterator status="i" value="construction.accessoryLists">
							<tr>
                       		<td colspan="4" align="left">
                       		<s:property value="#i.count"/>、<s:property value="message"/>
                       		<br />
                       		<font color="#0000CC"><strong>附件下载</strong></font>
                       		<br />
							<s:iterator status="k" value="list">
								<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a><br />
							</s:iterator>
                       		</td>
                       		</tr>
					  </s:iterator>
					  
					  
					  
					  
					  
					  
					<tr>
                    	<td colspan="4">&nbsp;</td>
                    </tr>
					<tr>
						<td colspan="1">
                        <font color="red">
                        	<strong>添加人员</strong>
                        </font>
                        </td>
                        <td colspan="3">
                        <input type="button" class="btn" value="添加" onclick="queryPrjStaff()" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                        <div class="ry_liebiao">
						<table width="100%" cellpadding="0" cellspacing="0">
						<tbody>
						<tr>
							<td width="20%">
								序号
							</td>
						  	<td width="20%">
								姓名
							</td>
							<td width="20%">
								身份证号
							</td>
							<td width="20%">
								角色
							</td>
							<td width="20%">
								详细
							</td>
	                	</tr>
	                	
	                	
	                	<s:iterator status="i" value="construction.staffList">
							<tr>
							<td>
								<s:property value="#i.count"/>
							</td>
						  	<td>
								<s:property value="personName"/>
							</td>
							<td>
								<s:property value="cardNum"/>
							</td>
							<td>
								<s:property value="staffTypeName"/>
							</td>
							<td>
			<a href="projectStaffAction_personDetailed.action?personId=<s:property value="personId"/>"><span>编辑</span></a>
			&nbsp;
			<a href="projectStaffAction_deletePerson.action?personId=<s:property value="personId"/>&otherPrjId=<s:property value="otherPrjId"/>"><span>删除</span></a>
							</td>
	                	</tr>
					  </s:iterator>
	                	
	                	</tbody>
						</table>
						</div>
						</td>
                    </tr>
					<tr>
                        <td colspan="4">&nbsp;</td>
                    </tr>
					  
					<tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><input type="button" class="btn" value="返回" onclick="goBack()" /></td>
                        <td>&nbsp;</td>
                    </tr>
                    </table>
					</form>
                </div>
            </div>
   		</div>
    </td>
  </tr>
  
</table>














					  
                    	













</div>

<%@include file="/WEB-INF/content/outside/footer.jsp"%>
</body>
</html>
