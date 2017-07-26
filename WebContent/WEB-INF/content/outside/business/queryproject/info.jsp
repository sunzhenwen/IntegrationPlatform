<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	function zcfg(divname, name, cursel, n) {
		for (i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var con = document.getElementById(divname + name + "_" + i);
			var cl = document.getElementById(name + i);
			con.style.display = i == cursel ? "block" : "none";
			cl.className = i == cursel ? "hover" : "";
		}
	}
	
	//查询招投标信息
	function queryTenderInfo(tenderNum)
	{
		var url="<%=basepath %>/queryProjectAction_queryTenderById.action?tenderNum="+tenderNum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	
	//查询合同备案信息
	function queryFilingById(recordId)
	{
		var url1="<%=basepath %>/queryProjectAction_queryFilingById.action?recordId="+recordId;
		var newWin1=window.showModalDialog(url1,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin1.open()
	}
	
	//查询质量信息
	function queryQualityById(qualityId)
	{
		 
		var url2="<%=basepath %>/queryProjectAction_queryQualityById.action?qualityId="+qualityId;
		var newWin2=window.showModalDialog(url2,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin2.open()
	}
	
	//查询安全信息
	function querySafetyById(safetyId)
	{     
		var url3="<%=basepath %>/queryProjectAction_querySafetyById.action?safetyId="+safetyId;
		var newWin3=window.showModalDialog(url3,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		//newWin3.open();
	}
	
	//查询施工许可信息
	function queryPermitById(permitId)
	{
		var url4="<%=basepath %>/queryProjectAction_queryPermitById.action?permitId="+permitId;
		var newWin4=window.showModalDialog(url4,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin4.open()
	}
	
	//查询竣工验收信息
	function queryCompleteById(completeId)
	{
		var url5="<%=basepath %>/queryProjectAction_queryCompleteById.action?completeId="+completeId;
		var newWin5=window.showModalDialog(url5,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin5.open()
	}
</script>
<head>

<title>项目详细基本信息列表</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

	<div class="area clearfix">
		<div class="cxxx_center">



			<div class="ry_lbxx">
				<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
					<h2>项目详细基本信息列表</h2>
					<table class="" cellpadding="0" cellspacing="0">

						<tbody>
							<tr>
								<th>项目编号：</th>
								<td><s:property value="project.prjNum" /> <input
									type="hidden" name="project.prjId"
									value="<s:property value="project.prjId"/>" /></td>
								<th>项目名称：</th>
								<td><s:property value="project.prjName" /></td>
							</tr>

							<tr>
								<th>项目分类：</th>
								<td><s:property value="project.prjTypeName" /><input
									type="hidden" name="project.prjTypeNum"
									value="<s:property value="project.prjTypeNum"/>" /></td>
								<th>建设单位名称：</th>
								<td><s:property value="project.buildCorpName" /></td>
							</tr>
							<tr>
								<th>建设单位组织机构代码证：</th>
								<td><s:property value="project.buildCorpCode" /></td>
								<th>项目所在省：</th>
								<td><s:property value="project.provinceName" /><input
									type="hidden" name="project.countyNum"
									value="<s:property value="project.countyNum"/>" /></td>
							</tr>
							<tr>
								<th>项目所在市：</th>
								<td><s:property value="project.cityName" /></td>
								<th>项目所在地：</th>
								<td><s:property value="project.countyName" /></td>
							</tr>
							<tr>
								<th>立项文号：</th>
								<td><s:property value="project.prjApprovalNum" /></td>
								<th>立项级别：</th>
								<td><s:property value="project.prjApprovalLevelName" /></td>
							</tr>
							<tr>
								<th>总投资（万元）：</th>
								<td><s:property value="project.allInvest" /></td>
								<th>总面积（平方米）：</th>
								<td><s:property value="project.allArea" /></td>
							</tr>
							<tr>
								<th>建设规模：</th>
								<td><s:property value="project.prjSize" /></td>
								<th>建设性质：</th>
								<td><s:property value="project.prjPropertyName" /></td>
							</tr>
							<tr>
                        		<th>建设用地规划许可证编号：</th>
								<td><s:property value="project.buldPlanNum"/></td>
                       			<th>建设工程规划许可证编号：</th>
								<td><s:property value="project.projectPlanNum"/></td>
							</tr>
							<tr>
                       			<th>开工日期：</th>
								<td><s:date name="project.beginDate" format="yyyy-MM-dd" /></td>
								<th>竣工日期：</th>
								<td><s:date name="project.endDate" format="yyyy-MM-dd" /></td>
                        	</tr>
							<tr>
								<th>工程用途：</th>
								<td><s:property value="project.prjFunctionName" /></td>
								<th>登记日期：</th>
								<td><s:date name="project.createDate" format="yyyy-MM-dd" />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		
	
	<div class="sy_left">
   <div class="zcfg_hover" id="cone_navc_1">

    <div class="left H_new  bor">
  <div class="bt1">
    <ul>
      <li class="selected"><a href="#">招投标信息</a></li>
      <li ><a href="#">施工图审查</a></li>
      <li><a href="#">合同备案</a></li>
      <li ><a href="#">质量审核</a></li>
      <li ><a href="#">安全审核</a></li>
      <li ><a href="#">施工许可</a></li>
      <li ><a href="#">峻工验收</a></li>
    </ul>
  </div>
  <div class="nr">
    <div class="lb">
      <ul>
              
    <div class="cxxx_liebiao" >
            
          	<table cellpadding="0" cellspacing="0" class="">
			<tr>
				<th>序号</th>
				<th>中标通知书编号</th>
				<th>项目编号</th>
				<th>招标类型</th>
				<th>招标方式</th>
				<th>中标日期</th>
				<th>中标金额</th>
				<th>详细</th>
			</tr>

			<s:iterator value="tenderList" var="tenderlistinfo"
				status="i">
				<tr>
					<td><s:property value="#i.count" /></td>
					<td>
					<s:property value="tenderNum" />
					</td>
					<td><s:property value="prjNum" /></td>
					<td><s:property value="tenderClassName" /></td>
					<td><s:property value="tenderTypeName" /></td>
					<td><s:date name="tenderResultDate" format="YYYY-MM-dd" /></td>
					<td><s:property value="tenderMoney" /></td>
					<td>
					<a href="#" onclick="queryTenderInfo('<s:property value="tenderNum" />')">
					<span>查看</span>
					</a>
					</td>
				</tr>
			</s:iterator>

		</table>

                
</div>
      </ul>
    </div>
    <div class="hide">
      <ul>
       
        
            <div class="cxxx_liebiao" >
            
            	<table cellpadding="0" cellspacing="0" class="">
					<tr>
						<th>序号</th>
						<th>施工图编号</th>
						<th>施工图审查机构名称</th>
						<th>勘察单位名称</th>
						<th>设计单位名称</th>
					</tr>

					<tbody>
						<s:iterator value="planList" var="planlistinfo" status="i">
							<tr>
								<td><s:property value="#i.count" /></td>
								<td>
								<s:property value="censorNum" />
								</td>
								<td><s:property value="censorCorpName" /></td>
								<td><s:property value="econCorpName" /></td>
								<td><s:property value="designCorpName" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
</div>
      </ul>
    </div>
    <div class=" hide">
      <ul>
    <div class="cxxx_liebiao" >
            
      		<table cellpadding="0" cellspacing="0" class="">
			<tr>
				<th>序号</th>
				<th>合同备案编号</th>
				<th>合同签订日期</th>
				<th>合同类别名称</th>
				<th>承包单位名称</th>
				<th>详细</th>
			</tr>

			<tbody>
				<s:iterator value="filingList" var="filinglistinfo" status="i">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td>
						<s:property value="recordNum" />
						</td>
						<td><s:date name="contractDate" format="YYYY-MM-dd" /></td>
						<td><s:property value="contractTypeName" /></td>
						<td><s:property value="contractorCorpName" /></td>
						<td>
						<a href="#" onclick="queryFilingById('<s:property value="recordId" />')">
						<span>查看</span>
						</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
                
                
</div>
      </ul>
    </div>
    <div class=" hide">
      <ul>
      <div class="cxxx_liebiao" >
            
       	<table cellpadding="0" cellspacing="0" class="">
			<tr>
				<th>序号</th>
				<th>工程名称</th>
				<th>质量监督编码</th>
				<th>详细</th>
			</tr>
			<tbody>
				<s:iterator value="qualityList" var="qualitylistinfo" status="i">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="projectName" /></td>
						<td>
						<s:property value="qualityNum" />
						</td>
						<td>
						<a href="#" onclick="queryQualityById('<s:property value="qualityId" />')">
							<span>查看</span>
						</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
                
                
</div>
      </ul>
    </div>
    <div class=" hide">
      <ul>
     <div class="cxxx_liebiao" >
            
       	<table cellpadding="0" cellspacing="0" class="">
		<tr>
			<th>序号</th>
			<th>工程名称</th>
			<th>安全监督编码</th>
			<th>详细</th>
		</tr>
		<tbody>
			<s:iterator value="safetyList" var="safetylistinfo" status="i">
				<tr>
					<td><s:property value="#i.count" /></td>
					<td><s:property value="projectName" /></td>
					<td>
					<s:property value="safetyNum" />
					</td>
					<td>
					<a href="#" onclick="querySafetyById('<s:property value="safetyId" />')">
						<span>查看</span>
					</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
                        
</div>
      </ul>
    </div>
 
    <div class=" hide">
      <ul>
        <div class="cxxx_liebiao" >
            
       	<table cellpadding="0" cellspacing="0" class="">
			<tr>
				<th>序号</th>
				<th>施工许可证编号</th>
				<th>勘察单位名称</th>
				<th>设计单位名称</th>
				<th>施工单位名称</th>
				<th>详细</th>
			</tr>
			<tbody>
				<s:iterator value="permitList" var="permitlistinfo" status="i">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td>
						<s:property value="builderLicenceNum" />
						</td>
						<td><s:property value="econCorpName" /></td>
						<td><s:property value="designCorpName" /></td>
						<td><s:property value="consCorpname" /></td>
						<td>
						<a href="#" onclick="queryPermitById('<s:property value="permitId" />')">
						<span>查看</span>
						</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
                
                
</div>
      </ul>
    </div>
    
    
    
       <div class=" hide">
      <ul>
        <div class="cxxx_liebiao" >
            
       <table cellpadding="0" cellspacing="0" class="">
		<tr>
			<th>序号</th>
			<th>施工许可证编号</th>
			<th>记录登记日期</th>
			<th>承建单位名称</th>
			<th>申请单位名称</th>
			<th>详细</th>
		</tr>
		<tbody>
			<s:iterator value="readyList" var="readylistinfo" status="i">
				<tr>
					<td><s:property value="#i.count" /></td>
					<td>
					<s:property value="builderLicenceNum" />
					</td>
					<td><s:date name="createDate" format="YYYY-MM-dd" /></td>
					<td><s:property value="qcCorpName" /></td>
					<td><s:property value="applyCorpName" /></td>
					<td>
					<a href="#" onclick="queryCompleteById('<s:property value="completeId" />')">
					<span>查看</span>
					</a>
					</td>
					
				</tr>
			</s:iterator>
		</tbody>
	</table>
                
                
</div>
      </ul>
    </div>
  </div>
</div>

 
  </div>

</div>
   
  </div>
</div>
<div class="foot">
		<p>

			<a href="/">首页</a> | <a href="/about">总访问量：2711742</a> | <a
				href="/news">今日：1107 </a> | <a href="/product">昨日：9418</a> | <a
				href="/map">Copyright ©2015版权所有</a> | <a href="/fenzhan">技术支持：哈尔滨天健高新技术有限公司
			</a> <br /> <a href="/fenzhan">黑龙江省住建厅 </a> | 地址：哈尔滨 东大直街308号 &nbsp;
			联系电话：0551-88888888 &nbsp; 邮箱：&nbsp;
		</p>
	</div>
	
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jq.Slide.js"></script>
	<script type="text/javascript">
		$(function() {
			$(
					"div.bt ul li,div.bt1 ul li,div.bt2 ul li,div.bt3 ul li,div.bt4 ul li,div.bt5 ul li")
					.mouseover(
							function() {
								$(this).addClass("selected").siblings()
										.removeClass("selected");
								var index = $(
										"div.bt ul li,div.bt1 ul li,div.bt2 ul li,div.bt3 ul li,div.bt4 ul li,div.bt5 ul li")
										.index(this);
								$("div.nr>div").eq(index).show().siblings()
										.hide();
							})
		});

		$(function() {
			$("#slide").Slide({
				effect : "scroolX",
				speed : "normal",
				timer : 3000
			});
		});
	</script>
	<!--[if lte IE 6]>
<script src="js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('*');
    </script>
<![endif]-->
</body>
</html>