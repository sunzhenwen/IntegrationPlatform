<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>竣工验收备案申请 </title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryCompleteAction_goList.action";
		document.form1.submit();
	}

	//查询单体工程信息
	function querySingleProject()
	{ 
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/querySingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=6&linkName=6";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>竣工验收备案申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="complete.prjName" value="<s:property value="complete.prjName"/>" class="required"/>
							<input id="prjId" type="hidden" readonly name="complete.prjId" value="<s:property value="complete.prjId"/>" class="required"/>
							<input id="completeId" type="hidden" readonly name="complete.completeId" value="<s:property value="complete.completeId"/>" class="required"/>
							</td>
							<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="complete.prjNum" value="<s:property value="complete.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" readonly name="complete.applyCorpName" value="<s:property value="complete.applyCorpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" readonly name="complete.applyCorpCode" value="<s:property value="complete.applyCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="complete.appDeptName" value="<s:property value="complete.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="complete.appDept" value="<s:property value="complete.appDept"/>"/>
							</td>
                         </tr>
                         <tr>
                         	<th>竣工备案编号：</th>
									<td align="left">
										<input type="text" readonly name="complete.prjFinishNum" value="<s:property value="complete.prjFinishNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
									</td>
                         	<th>工程名称：</th>
							<td align="left">
							<input type="text" name="complete.projectName" value="<s:property value="complete.projectName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
                         </tr>
                         
                         <tr>
                         	<th>施工许可证编号：</th>
							<td align="left">
							<input type="text" name="complete.builderLicenceNum" value="<s:property value="complete.builderLicenceNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>质量检测机构名称：</th>
							<td align="left">
							<input type="text" name="complete.qcCorpName" value="<s:property value="complete.qcCorpName"/>" class="required"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>质量检测机构组织机构代码：</th>
							<td align="left">
							<input type="text" name="complete.qcCorpCode" value="<s:property value="complete.qcCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>实际造价(万元)：</th>
							<td align="left">
							<input type="text" name="complete.factCost" value="<s:property value="complete.factCost"/>" class="required"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>实际面积(平方米)：</th>
							<td align="left">
							<input type="text" name="complete.factArea" value="<s:property value="complete.factArea"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
							<th>体系结构：</th>
							<td align="left">
							<select name="complete.prjStructureTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="prjStructureTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='complete.prjStructureTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							
							</td>
                         </tr>
                         <tr>
                         	
							<th>实际开工日期：</th>
							<td align="left">
							<input id="time1" type="text" name="complete.BDate" value="<s:date name="complete.BDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>实际竣工验收日期：</th>
							<td align="left">
							<input id="time2" type="text" name="complete.EDate" value="<s:date name="complete.EDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>实际建设规模：</th>
                         	<td align="left">
							<textarea name="complete.factSize" cols="30" rows="5"><s:property value="complete.factSize"/></textarea>
							</td>
							<th>备注：</th>
							<td align="left">
							<textarea name="complete.mark" cols="30" rows="5"><s:property value="complete.mark"/></textarea>
							</td>
						</tr>
                         
						<tr>
                       		<th>附件：</th>
							<td align="left" colspan="3">
							<s:iterator status="i" value="complete.list">
							<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a><br />
							</s:iterator>
							</td>
						</tr>
                </tbody>  
                </table>
                <s:if test="appType==1">
                 <div class="sp_bton">
				     <a href="#"><span class="sp_last" onclick="prn_preview()">打印</span></a>
				</div>
                </s:if>
                 <div class="botn"> 
          
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		        	<a href="#" onclick="querySingleProject()">
						<input type="image"src="<%=basepath %>/images/dtgc.jpg" />
		            </a>
		        </div>
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
    
    
<div id="table01" style="display: none">
<p align="center">建筑工程和市政基础设施工程竣工验收备案表</p>
<table border="1" width="100%" height="90%" style="border:solid 1px black;border-collapse:collapse">
  <tr>
    <td width="25%" ><p align="center">建设单位名称</p></td>
    <td width="75%" colspan="3" ><p><s:property value="complete.applyCorpName"/> </p></td>
  </tr>
   <tr>
    <td width="25%"><p align="center">备案日期</p></td>
    <td width="75%" colspan="3" ><p><s:date name="complete.createDate" format="yyyy-MM-dd" /> </p></td>
  </tr>
   <tr>
    <td width="25%"><p align="center">工程名称</p></td>
    <td width="75%" colspan="3" ><p><s:property value="complete.prjName"/> </p></td>
  </tr>
   <tr>
    <td width="25%"><p align="center">工程地点</p></td>
    <td width="75%" colspan="3" ><p><s:property value="projectConstruction.address"/>  </p></td>
  </tr>
    <tr>
    <td width="25%"><p align="center">建筑面积（m<sup>2</sup>）</p></td>
    <td width="75%" colspan="3" ><p><s:property value="complete.factArea"/> </p></td>
  </tr>
   <tr>
    <td width="25%"><p align="center">结构类型</p></td>
    <td width="75%" colspan="3" ><p>&nbsp; </p></td>
  </tr>
   <tr>
    <td width="25%"><p align="center">工程用途</p></td>
    <td width="75%" colspan="3" ><p><s:property value="projectConstruction.prjFunctionName"/> </p></td>
  </tr>
   <tr>
    <td width="25%"><p align="center">开工日期</p></td>
    <td width="75%" colspan="3" ><p><s:date name="complete.BDate" format="yyyy-MM-dd" /> </p></td>
  </tr>
  <tr>
    <td width="25%"><p align="center">竣工验收日期</p></td>
    <td width="75%" colspan="3" ><p><s:date name="complete.EDate" format="yyyy-MM-dd" /> </p></td>
  </tr>
  <tr>
    <td width="25%"><p align="center">施工许可证号</p></td>
    <td width="75%" colspan="3" ><p><s:property value="complete.builderLicenceNum"/> </p></td>
  </tr>
  <tr>
    <td width="25%"><p align="center">施工图审查意见</p></td>
    <td width="75%" colspan="3" ><p>&nbsp; </p></td>
  </tr>
  <tr>
    <td width="25%"><p align="center"> 勘察单位名称</p></td>
    <td width="35%"><p align="center"><s:property value="permit.econCorpName"/> </p></td>
    <td width="15%"><p align="center">资质等级 </p></td>
    <td width="25%">&nbsp; </td>
  </tr>
   <tr>
    <td width="25%"><p align="center"> 设计单位名称</p></td>
    <td width="35%"><p align="center"><s:property value="permit.designCorpName"/> </p></td>
    <td width="15%"><p align="center">资质等级 </p></td>
    <td width="25%">&nbsp; </td>
  </tr>
    <tr>
    <td width="25%"><p align="center">施工单位名称 </p></td>
    <td width="35%"><p align="center"><s:property value="permit.consCorpname"/> </p></td>
    <td width="15%"><p align="center">资质等级 </p></td>
    <td width="25%">&nbsp; </td>
  </tr>
   <tr>
    <td width="25%"><p align="center">监理单位名称 </p></td>
    <td width="35%"><p align="center"><s:property value="permit.superCorpName"/></p></td>
    <td width="15%"><p align="center">资质等级 </p></td>
    <td width="25%">&nbsp; </td>
  </tr>
   <tr>
    <td width="25%"><p align="center">施工图审查机构名称</p></td>
    <td width="35%"><p align="center"><s:property value="permit.econCorpName"/> </p></td>
    <td width="15%"><p align="center">类别 </p></td>
    <td width="25%">&nbsp; </td>
  </tr>
  <tr>
    <td width="25%"><p align="center">工程质量监督机构名称</p></td>
    <td width="75%" colspan="3" ><p><s:property value="complete.qcCorpName"/> </p></td>
  </tr>
  </table>
</div>
<div id="table02" style="display: none">
<table border="1" width="100%"  style="border:solid 1px black;border-collapse:collapse">
  <tr>
    <td width="5%" rowspan="5"><p align="center">竣工验收意见</p></td>
    <td width="10%" >
    	<p align="center">勘察</p>
    	<p align="center">单位</p>
    	<p align="center">意见</p>
    </td>
    <td width="85%" >
    	<p align="left">单位（项目）负责人：</p>
    	<p align="center">&nbsp;</p>
    	<p align="center">&nbsp;</p>
    	<p align="right">（公章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="center">&nbsp;</p>
    </td>
  </tr>
  <tr>
    <td width="10%" >
    	<p align="center">设计</p>
    	<p align="center">单位</p>
    	<p align="center">意见</p>
    	</td>
    <td width="85%" >
    	<p align="left">单位（项目）负责人：</p>
    	<p align="center">&nbsp;</p>
    	<p align="center">&nbsp;</p>
    	<p align="right">（公章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="center">&nbsp;</p>
    </td>
  </tr>
   <tr>
    <td width="10%" >
    	<p align="center">施工</p>
    	<p align="center">单位</p>
    	<p align="center">意见</p>
    	</td>
    <td width="85%" >
    	<p align="left">单位（项目）负责人：</p>
    	<p align="center">&nbsp;</p>
    	<p align="center">&nbsp;</p>
    	<p align="right">（公章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="center">&nbsp;</p>
    </td>
  </tr>
  <tr>
    <td width="10%" >
    	<p align="center">监理</p>
    	<p align="center">单位</p>
    	<p align="center">意见</p>
    </td>
    <td width="85%" >
    	<p align="left">总监理工程师：</p>
    	<p align="center">&nbsp;</p>
    	<p align="center">&nbsp;</p>
    	<p align="right">（公章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="center">&nbsp;</p>
    </td>
  </tr>
  <tr>
    <td width="10%" >
    	<p align="center">建设</p>
    	<p align="center">单位</p>
    	<p align="center">意见</p>
    	</td>
    <td width="85%" >
    	<p align="left">单位（项目）负责人：</p>
    	<p align="center">&nbsp;</p>
    	<p align="center">&nbsp;</p>
    	<p align="right">（公章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="center">&nbsp;</p>
    </td>
  </tr>
  </table>
</div>

<div id="table03" style="display: none">
	<table border="1" width="100%"  style="border:solid 1px black;border-collapse:collapse">
	<tr>
    <td width="10%">
    	<p align="center">工程</p>
    	<p align="center">竣工</p>
    	<p align="center">验收</p>
    	<p align="center">备案</p>
    	<p align="center">文件</p>
    	<p align="center">目录</p>
    	</td>
    <td width="90%" colspan="4" >
    	<p>1、建设工程竣工验收报告 ；</p>
    	<p>2、有关行政主管部门对专项建设工程的认可和准许使用文件； </p>
    	<p>3、参与验收的业主代表签署的认可意见；</p>
    	<p>4、监理单位出具的建设工程质量评估报告；</p>
    	<p>5、建设工程质量保修书；</p>
    	<p>6、设计单位和施工图审查机构出具的认可文件；</p>
    	<p>7、市政基础设施的有关质量检测和功能性试验材料；</p>
    	<p>8、法规、法规规定的其他文件。</p>
    	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住宅建设工程项目还应提交《住宅质量保证书》、《住宅使用说明书》和《分户验收证明》。</p>
    	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;民用建筑节能工程还应提交节能验收备案证。</p>
    	</td>
  </tr>
  <tr>
    <td width="10%">
    	<p align="center">备</p>
    	<p align="center">案</p>
    	<p align="center">意</p>
    	<p align="center">见</p>
    	</td>
    <td width="90%" colspan="4" >
    	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该工程的竣工验收备案文件与&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日收讫，文件齐全。</p>
    	<p align="center">&nbsp;</p>
    	<p align="center">&nbsp;</p>
    	<p align="center">&nbsp;</p>
    	<p align="right">（公章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="center">&nbsp;</p>
    </td>
  </tr>
	<tr>
    <td width="20%" colspan="2"><p align="center">备案机构负责人</p></td>
    <td width="30%" ><p>&nbsp; </p></td>
    <td width="20%" ><p align="center">备案经手人</p></td>
    <td width="30%" ><p>&nbsp; </p></td>
  </tr>
  <tr>
    <td width="20%" colspan="5">
    	<p align="left ">备案机构处理意见：</p>
    	<p align="center">&nbsp;</p>
    	<p align="center">&nbsp;</p>
    	<p align="center">&nbsp;</p>
    	<p align="right">（公章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    	<p align="center">&nbsp;</p>
     </td>
  </tr>
	</table>
</div>    
    
    
    
  <script language="javascript" type="text/javascript">   
    var LODOP; //声明为全局变量 
    
    function prn_preview() 
    {	
		CreatePrintPageA();
		LODOP.NewPage();
		CreatePrintPageB();
		LODOP.NewPage();
		CreatePrintPageC();		
		LODOP.NewPage();
		CreatePrintPageD();	
		//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
		//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};  
    
    
  	function CreatePrintPageA() 
	{
		LODOP=getLodop();  
		LODOP.PRINT_INIT("竣工验收备案表");
		LODOP.ADD_PRINT_TEXT(210,69,659,79,"建筑工程和市政基础设施工程竣工验收备案表");
	    LODOP.SET_PRINT_STYLEA(0,"FontSize",23);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		
		LODOP.ADD_PRINT_TEXT(648,71,644,183,
		 "单位工程名称：_____________________________________\n"
		+"建设单位：    _____________________________________\n"
		+"质量监督机构：_____________________________________\n"
		+"备案机构：    _____________________________________\n"
		+"备案日期：    _____________________________________"
		);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"LineSpacing",12);
		LODOP.ADD_PRINT_TEXT(876,233,451,77,"黑龙江省工程质量监督总站监制");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		
		LODOP.ADD_PRINT_TEXT(13,583,179,30,"监督注册号：\n文件编号 ZJ05-02");
	};  
    
	function CreatePrintPageB() 
	{
		//LODOP=getLodop();  
		//LODOP.PRINT_INIT("建筑工程和市政基础设施工程竣工验收备案表1");
		var strHTML="<body style='margin:0;background-color: white'>"+document.getElementById("table01").innerHTML+"</body>";
		LODOP.ADD_PRINT_HTM("15mm","15mm","RightMargin:15mm","BottomMargin:15mm",strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);

	};
	
	function CreatePrintPageC() 
	{
		//LODOP=getLodop();  
		//LODOP.PRINT_INIT("建筑工程和市政基础设施工程竣工验收备案表2");
		var strHTML="<body style='margin:0;background-color: white'>"+document.getElementById("table02").innerHTML+"</body>";
		LODOP.ADD_PRINT_HTM("10mm","15mm","RightMargin:15mm","BottomMargin:10mm",strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};
	
	function CreatePrintPageD() 
	{
		//LODOP=getLodop();  
		//LODOP.PRINT_INIT("建筑工程和市政基础设施工程竣工验收备案表3");
		var strHTML="<body style='margin:0;background-color: white'>"+document.getElementById("table03").innerHTML+"</body>";
		LODOP.ADD_PRINT_HTM("15mm","15mm","RightMargin:15mm","BottomMargin:15mm",strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};     
</script>    
    
</body>
</html>
