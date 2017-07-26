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
		document.form1.action="<%=basepath %>/QualityanfzAction_queryPageanfz.action";
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
		var FName = strs[2];
		var FCertNumber = strs[3];
		var FIdCertNo = strs[4];
		//parent.document.getElementById("recordId").value=recordId;
		parent.document.getElementById("FName").value=FName;
		parent.document.getElementById("FCertNumber").value=FCertNumber;
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/QualityanfzAction_queryPageanfz.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>安全管理负责人</h2>
            	<table class="ry_left left">
               
                    <tr>
                        <td>身份证号：</td>
                        <td>
                        <input type="text" name="cardNum" value = "<s:property value = "cardNum"/>" />
                        <input type="hidden" name="condition.prjNum" value = "<s:property value = "condition.prjNum"/>" />
                        <input type="hidden" name="personaqfz" value = "<s:property value = "personaqfz"/>" />
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
            	<p class="f16 fb">安全管理负责人<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>姓名</th>
							<th>安全考核证</th>
						</tr>
                          
                         <s:iterator status="i" value="list" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" value="<s:property value="recordId"/>,<s:property value="prjNum"/>,<s:property value="FName"/>,<s:property value="FCertNumber"/>,<s:property value="FIdCertNo"/>"></td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="FName"/></td>
                            <td><s:property value="FCertNumber"/></td>                       
                         </tr>                         
						</s:iterator>
                          
                	</tbody>  
                </table>
                
                
         </div>
    	</div>
        </form>
    </div>
</body>
</html>
