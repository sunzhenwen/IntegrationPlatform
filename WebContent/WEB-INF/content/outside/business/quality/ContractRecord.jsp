<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>合同备案信息选择</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/contractRecordAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split("^&*"); //字符分割 

		var TENDERNUM = strs[0];
		var SECTIONNAME = strs[1];
		var PROJECTADDRESS= strs[2];
		var AREA = strs[3];
		var PROJECTCOST = strs[4];
		var BDATE = strs[5];
		var EDATE = strs[6];
		var BUILDCORPNAME = strs[7];
		var RECORDNUM = strs[8];		
		var CONTRACTMONEY=strs[9];
		var CONTRACTORCORPNAME=strs[10];
		var CONTRACTORCORPCODE=strs[11];
		var TITLELEVE = strs[12];
		var CONSTRUCTORNAME = strs[13];
		var PHONE = strs[14];
		var PROJECTMANAGER = strs[15];
		var UNITPHONE = strs[16];
		

		parent.document.getElementById("tenderNum").value=TENDERNUM;
		parent.document.getElementById("sectionName").value=SECTIONNAME;
		parent.document.getElementById("projectName").value=SECTIONNAME;
		parent.document.getElementById("projectAddress").value=PROJECTADDRESS;//工程地点
		parent.document.getElementById("constructionArea").value=AREA;//建筑面积
		parent.document.getElementById("expensive").value=PROJECTCOST;//工程总造价(万元)
		parent.document.getElementById("time1").value=BDATE;
		parent.document.getElementById("time2").value=EDATE;
		parent.document.getElementById("developmentOrganization").value=BUILDCORPNAME;
		//parent.document.getElementById("constructionContractFileNum").value=RECORDNUM;
		parent.document.getElementById("contractMoney").value=CONTRACTMONEY;
		parent.document.getElementById("constructionUnit").value=CONTRACTORCORPNAME;
		parent.document.getElementById("consCorpCode").value=CONTRACTORCORPCODE;
		parent.document.getElementById("constructionUnitQualLevel").value=TITLELEVE;
		parent.document.getElementById("constructionUnitProjectManager").value=CONSTRUCTORNAME;
		parent.document.getElementById("constructionUnitPhone").value=PHONE;
			
		parent.document.getElementById("developmentCharge").value=PROJECTMANAGER;
		parent.document.getElementById("developmentPhone").value=UNITPHONE;
		window.close();
		
		
		
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>合同备案信息选择</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>时间：</td>
                        <td colspan="3">
                        <input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input type="hidden" name="condition.prjNum" value = "<s:property value = "condition.prjNum"/>" />
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
            	<p class="f16 fb">合同备案信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>项目名称</th>							
							<th>合同编号</th>
							<th>标段名称</th>
							<th>合同类别</th>
							<th>承包单位名称</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio"
                          	 name="corpRadio" 
                          	 value="<s:property value="TENDERNUM"/>^&*<s:property value="SECTIONNAME"/>^&*<s:property value="PROJECTADDRESS"/>^&*<s:property value="AREA"/>^&*<s:property value="PROJECTCOST"/>^&*<s:property value="BDATE"/>^&*<s:property value="EDATE"/>^&*<s:property value="BUILDCORPNAME"/>^&*<s:property value="RECORDNUM"/>^&*<s:property value="CONTRACTMONEY"/>^&*<s:property value="CONTRACTORCORPNAME"/>^&*<s:property value="CONTRACTORCORPCODE"/>^&*<s:property value="TITLELEVE"/>^&*<s:property value="CONSTRUCTORNAME"/>^&*<s:property value="PHONE"/>^&*<s:property value="PROJECTMANAGER"/>^&*<s:property value="UNITPHONE"/>">
                          	 </td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="PRJNAME"/></td>
                            <td><s:property value="RECORDNUM"/></td>
                            <td><s:property value="SECTIONNAME"/></td>                            
                            <td><s:property value="CONTRACTTYPENAME"/>                        
                            </td>
                            <td><s:property value="CONTRACTORCORPNAME"/></td>
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
