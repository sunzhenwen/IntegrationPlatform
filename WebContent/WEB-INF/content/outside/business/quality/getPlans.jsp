<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title></title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/qualityPlansAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split("^&*"); //字符分割 

		var censorNum = strs[0];
		
		
		parent.document.getElementById("constructionPlans").value=censorNum;//审查合格书编号
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>信息选择</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>审查合格书编号：</td>
                        <td colspan="3">
                        <input type="text" name="condition.censorNum" value = "<s:property value = "condition.censorNum"/>" />
                        <input type="hidden" name="condition.prjId" value = "<s:property value = "condition.prjId"/>" />
                        </td>
                        <td>审查时的工程名称：</td>
                        <td colspan="3">
                        <input type="text" name="condition.prjName" value = "<s:property value = "condition.prjName"/>" />
                        </td>
                    </tr>
                    
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" onclick="queryCorpInfo()" src="<%=basepath %>/images/ry_look.png" /></td>
                        <td>&nbsp;</td>
                    </tr>
                </table>		
            
            </div>
            
            <div class="ry_liebiao">
            	<p class="f16 fb">信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>审查合格书编号</th>
							<th>审查时的工程名称</th>
							<th>审查机构</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" 
                          	value="<s:property value="censorNum"/>">
							</td>
							<td><s:property value="#i.count"/> </td>
                            <td><s:property value="censorNum"/></td>
                            <td><s:property value="prjName"/></td>
                            <td><s:property value="censorCorpName"/></td>
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
