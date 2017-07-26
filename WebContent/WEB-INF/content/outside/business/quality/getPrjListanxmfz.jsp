<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>企业信息</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/QualityanxmfzAction_queryPageanxmfz.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split(","); //字符分割 
		var recordId = strs[0];
		var prjNum = strs[1];
		var constructorNameXMFZ = strs[2];
		var constructorNameZSBH = strs[3];
		var constructorNameKHBH = strs[4];
		parent.document.getElementById("constructorNameXMFZ").value=constructorNameXMFZ;//项目负责人姓名
		parent.document.getElementById("constructorNameZSBH").value=constructorNameZSBH;//项目负责人证书编号
		parent.document.getElementById("constructorNameKHBH").value=constructorNameKHBH;//项目负责人考核编号
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/QualityanfzAction_queryPageanfz.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>项目负责人</h2>
            	<table class="ry_left left">
               
                    <tr>
                        <td>姓名：</td>
                        <td>
                        <input type="text" name="condition.personName" value = "<s:property value = "condition.personName"/>" />
                        <input type="hidden" name="condition.prjNum" value = "<s:property value = "condition.prjNum"/>" />
                        <input type="hidden" name="condition.corpname" value = "<s:property value = "condition.corpname"/>" />
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
            	<p class="f16 fb">项目负责人选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>姓名</th>
							<th>项目负责人注册证号</th>
							<th>项目负责人考核证号</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" value="<s:property value="recordId"/>,<s:property value="prjNum"/>,<s:property value="constructorNameXMFZ"/>,<s:property value="constructorNameZSBH"/>,<s:property value="constructorNameKHBH"/>"></td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="constructorNameXMFZ"/></td>
                            <td><s:property value="constructorNameZSBH"/></td>  
                            <td><s:property value="constructorNameKHBH"/></td>                     
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
