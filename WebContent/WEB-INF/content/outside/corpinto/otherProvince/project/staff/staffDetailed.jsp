<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	//验证字段
	function check()
	{
		var check = true;
		if(document.getElementById('staffType').value==""){
			alert("请选择人员类型!");
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
		document.form1.action="<%=basepath %>/projectStaffAction_queryById.action";
		document.form1.submit();
	}

	
	//上传
	function upload(count,id,accessotyId,linkName)
	{
		var uid = "#uf"+count;
		var uidd = "#uff"+count;
		var uf = $(uid).val();
		var uff = $(uidd).val();
		if(uf!="")
		{
			//外省建筑企业人员附件上传
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&accessotyId="+accessotyId+"&linkName="+linkName+"&returnRoot=prjPersonSuccess";
			actionUrl = encodeURI(actionUrl);
			actionUrl = encodeURI(actionUrl);
			document.form1.action=actionUrl;
			document.form1.submit();
		}else if(uff!="")
		{
			//外省监理企业人员附件上传
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&accessotyId="+accessotyId+"&linkName="+linkName+"&returnRoot=prjPersonSuccess";
			actionUrl = encodeURI(actionUrl);
			actionUrl = encodeURI(actionUrl);
			document.form1.action=actionUrl;
			document.form1.submit();
		}else
		{
			alert("请选择要上传的附件!");
		}
	}
	
	//删除
	function deleteFile(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_deleteFile.action?id="+uploadId+"&returnRoot=prjPersonSuccess";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=prjPersonSuccess";
		document.form1.submit();
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
                	<dt>当前位置：项目相关人员</dt>
                    
                </dl>
      </div>    
     
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   
    <td valign="top">
    	<div class="wr">

<div class="tit"><img src="images/titico1.gif"/><strong>项目相关人员</strong><p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
            <div class="main h384">
            	<div class="list g2">
                	<form id="form1" name="form1" method="post" action="" enctype="multipart/form-data">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                         	<td width="17%">姓名：</td>
                            <td width="32%">
							<input id="name" name="projectPerson.personName" readonly type="text" value="<s:property value="projectPerson.personName"/>" class="ipu1" />
							<input name="otherPrjId" readonly type="hidden" value="<s:property value="projectPerson.otherPrjId"/>" class="ipu1" />
							<input name="projectPerson.personId" readonly type="hidden" value="<s:property value="projectPerson.personId"/>" class="ipu1" />
							</td>
                            <td width="19%">证件号码：</td>
                            <td width="32%">
							<input id="cardId" name="projectPerson.cardNum" readonly type="text" value="<s:property value="projectPerson.cardNum"/>" class="ipu1" />
							</td>
                            
                         </tr>
                         <tr>
                         	<td>类型：</td>
                            <td>
							<select id="staffType" name="projectPerson.staffType" class="sel">
		      					<option value="">请选择</option>
		      						<s:iterator value="staffTypeList">
		          						<option value="<s:property value="code"/>"><s:property value="name"/></option>
		      						</s:iterator>
							</select>
							<span class="red">*</span>
							</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                         </tr>
                         
                      <tr>
                        <td colspan="4"><font color="red"><strong>外省建筑企业人员附件上传</strong></font></td>
                      </tr>
                      <s:iterator status="i" value="projectPerson.accessoryList">
							<tr>
                       		<td colspan="3" align="left"><s:property value="#i.count"/>、<s:property value="message"/></td>
							<td align="left">
							<input id="uf<s:property value="#i.count"/>" type="file" name="file">
							&nbsp;
							<input type="button" onclick="upload('<s:property value="#i.count"/>','<s:property value="projectPerson.personId"/>','<s:property value="id"/>','<s:property value="linkName"/>')" value="上传" />
							&nbsp;<br />
							<s:iterator status="k" value="list">
								<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<a href="#" onclick="deleteFile('<s:property value="uploadId"/>')">删除</a><br />
							</s:iterator>
							</td>
							</tr>
					  </s:iterator>
					  <tr>
                        <td colspan="4">&nbsp;</td>
                      </tr>
					  <tr>
                        <td colspan="4"><font color="red"><strong>外省监理企业人员附件上传</strong></font></td>
                      </tr>
                      <s:iterator status="i" value="projectPerson.accessoryLists">
							<tr>
                       		<td colspan="3" align="left"><s:property value="#i.count"/>、<s:property value="message"/></td>
							<td align="left">
							<input id="uff<s:property value="#i.count"/>" type="file" name="file">
							&nbsp;
							<input type="button" onclick="upload('<s:property value="#i.count"/>','<s:property value="projectPerson.personId"/>','<s:property value="id"/>','<s:property value="linkName"/>')" value="上传" />
							&nbsp;<br />
							<s:iterator status="k" value="list">
								<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<a href="#" onclick="deleteFile('<s:property value="uploadId"/>')">删除</a><br />
							</s:iterator>
							</td>
							</tr>
					  </s:iterator>
        
                       <tr>
                        <td>&nbsp;</td>
                        <td>
						<input type="button" class="btn" value="返回" onclick="goBack()" />
						<input type="button" class="btn" value="保存" onclick="save()" />
						</td>
                        <td>&nbsp;</td>
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
