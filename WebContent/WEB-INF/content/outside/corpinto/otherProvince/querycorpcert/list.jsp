<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业资质搜索 </title>
<link rel="stylesheet" href="<%=basepath %>/css/style.css" type="text/css" >
<link href="<%=basepath %>/css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/queryOtherCorpCertAction_queryPage.action";
		document.form1.submit();
	}
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryOtherCorpCertAction_goBack.action";
		document.form1.submit();
	}
	//添加
	function add()
	{
		document.form1.action="<%=basepath %>/queryOtherCorpCertAction_addPage.action";
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

<div class="wz">
            	<dl>
                	<dt>当前位置：外省企业备案</dt>
                    
                </dl>
      </div>

<div class="main" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   
    <td valign="top">
    	<div class="wr">

<div class="tit"><img src="images/titico2.gif"/><strong>外省企业资质搜索</strong>
  <p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
  
  <div class="main "  style="line-heigth:24px;">
  <form id="form1" name="form1" method="post" action="">
            	<table width="98%" border="0" cellspacing="0" cellpadding="0" style="min-height:100px;">
                  <tr>
                    <td width="12%"><label>专业类别：</label></td>
					<td width="35%">
					<input type="text" name="condition.tradeBoundName" value="<s:property value="condition.tradeBoundName"/>" class="ipu1"  />
					</td>
                    <td width="28%"><label>资质等级：</label></td>
                    <td width="25%">
					<input type="text" name="condition.titleLevel" value="<s:property value="condition.titleLevel"/>" class="ipu1" />
					</td>
                    <td width="25%"><input name="input4" type="button" class="btn" value="添加" onclick="add()" /></td>
                    <td width="25%"><input name="input4" type="button" class="btn" value="搜索" onclick="queryTitle()" /></td>
                    <td width="25%"><input name="input3" type="button" class="btn" value="返回" onclick="goBack()" /></td>
                  </tr>
                  
                  
                </table>
</form>
</div>
  <div class="ry_liebiao">
    <p class="f16 pd10 fb">外省企业资质列表<img src="images/ry_lie.png" /></p>
    <table class="" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <th>序号</th>
          <th>证书编号</th>
          <th>资质资格类型</th>
          <th>资质资格序列</th>
          <th>专业类别</th>
          <th>资质等级</th>
          <th>操作</th>
        </tr>
		<s:iterator status="i" value="currentPage.data" > 
        <tr>
			<td><s:property value="#i.count"/></td>
			<td><s:property value="certNum"/></td>
			<td><s:property value="certName"/></td>
			<td>
			<s:if test='tradeTypeName==null'>
			无
			</s:if>
			<s:else>
			<s:property value="tradeTypeName"/>
			</s:else>
			</td>
			<td>
			<s:if test='tradeBoundName==null'>
			无
			</s:if>
			<s:else>
			<s:property value="tradeBoundName"/>
			</s:else>
			</td>
			<td>
			<s:if test='titleLevel==null'>
			无
			</s:if>
			<s:else>
			<s:property value="titleLevel"/>
			</s:else>
			</td>
			<td>
			<s:if test='dataSource=="09"'>
			<a href="queryOtherCorpCertAction_deleteCer.action?id=<s:property value="id"/>"><span>删除</span></a>
			</s:if>
			</td>
        </tr>
        </s:iterator>
      </tbody>
    </table>
    <%@include file="/WEB-INF/content/inc/page.jsp"%> 
  </div></td>
 </tr>
                  
                </table>

</div>
    <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
</body>
</html>
