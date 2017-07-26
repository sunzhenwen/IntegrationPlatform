<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>企业信息</title>
<script type="text/javascript">
	var i=<%=session.getAttribute("user")%>;
	//查询
	function queryCorpInfo()
	{ 
		document.form1.action="<%=basepath %>/QualityzzryAction_queryPagezzry.action?i="+i;
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		
		var parent=window.dialogArguments;
		//window.returnValue=value;
 		//alert(i);
		var strs= new Array(); //定义一数组 
		strs=value.split(","); //字符分割 
		//var recordId = strs[0];
		//var prjNum = strs[1];
		var constructorNamezzry = strs[0];
		var constructorNamezzrygw = strs[1];
		var constructorNamezzrykh = strs[2];
		parent.document.getElementById("constructorNamezzry["+i+"]").value=constructorNamezzry;//项目负责人姓名
		parent.document.getElementById("constructorNamezzrygw["+i+"]").value=constructorNamezzrygw;//岗位号
		parent.document.getElementById("constructorNamezzrykh["+i+"]").value=constructorNamezzrykh;//考核编号
		window.close();
	}
	//多项选择  
	function aa(){ 
		var u=0;
		
	 alert(<%=session.getAttribute("user")%>);
			var parent=window.dialogArguments;
	  var r = document.getElementsByName("r");  
		var properties = new Array();
	    for(var i=0;i<r.length;i++){
			if(document.getElementById(r[i].id).checked){
				properties[i] = r[i].id+","+r[i].value;
			}
	    }
	   
		window.returnValue = properties;
		window.close();}
		
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/QualityzzryAction_queryPagezzry.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>现场专职安全管理人员</h2>
            	<table class="ry_left left">
               
                    <tr>
                        <td>姓名：</td>
                        <td>
                        <input type="text" name="condition.constructorNamezzry" value = "<s:property value = "condition.constructorNamezzry"/>" />
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
            	<p class="f16 fb">现场专职安全管理人员<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>姓名</th>
							<th>岗位号</th>
							<th>安全考核证号</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" value="<s:property value="constructorNamezzry"/>,<s:property value="constructorNamezzrygw"/>,<s:property value="constructorNamezzrykh"/>">
                           	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="constructorNamezzry"/></td>
                            <td><s:property value="constructorNamezzrygw"/></td>  
                            <td><s:property value="constructorNamezzrykh"/></td>  </td>                  
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
