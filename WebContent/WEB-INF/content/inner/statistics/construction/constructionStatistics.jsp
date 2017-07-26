<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目报建统计分析 </title>
<script type="text/javascript" src="<%=basepath %>/js/highcharts/js/highcharts.js"></script>
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/constructionStatisticsAction_queryPage.action";
		document.form1.submit();
	}
	
	//查询市
	function queryArea(){
       $(document).ready(function(){
           //获取部门下拉列表的值
           var cityId = $("#cityId").val();
           $.ajax({
               url: 'constructionStatisticsAction_queryArea.action',
               type: 'post',
               dataType: 'json',
               data: 'cityId='+cityId,
               success: function(data){
            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
                   var items = eval("("+data+")");
                   $("#areaId").empty();
                   $("#areaId").append("<option value=''>请选择</option>");
                   //循环items,i为循环下标,(默认i从0开始取值)
                   var area ='<s:property value="areaNum"/>';
                   $.each(items,function(i){
                	   if(items[i].code==area)
                       {
                		    $("#areaId").append("<option value='" + items[i].code+ "' selected >" + items[i].name + "</option>");
                       }else
                       {
                    	    $("#areaId").append("<option value='" + items[i].code+ "' >" + items[i].name + "</option>");
                       }
                	});  
               }
           });
       });
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	$(function () {
		var cityName = eval(<s:property value="cityName" escapeJavaScript="false" escapeHtml="false"/>);
		var houses = eval(<s:property value="houses" escapeJavaScript="false" escapeHtml="false"/>);
		var municipals = eval(<s:property value="municipals" escapeJavaScript="false" escapeHtml="false"/>);
		var others = eval(<s:property value="others" escapeJavaScript="false" escapeHtml="false"/>);
		var pieResult = eval(<s:property value="pieResult" escapeJavaScript="false" escapeHtml="false"/>);

	    $('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '<s:property value="title"/>项目报建区域分布统计'
	        },
	        subtitle: {
	            text: 'Source: Regional distribution statistics'
	        },
	        xAxis: {
	        	categories: cityName
	        },
	        yAxis: {
	            min: 0,
	            title: {
	            	text: '项目数'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span>',
	            pointFormat: '' +
	                '',
	            footerFormat: '<table><tbody><tr><td style="color:{series.color};padding:0">{series.name}: </td><td style="padding:0"><b>{point.y:.1f} </b></td></tr></tbody></table>',
	            shared: false,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '房屋建筑工程',
	            data: houses
	        }, {
	            name: '市政工程',
	            data: municipals
	        }, {
	            name: '其他',
	            data: others
	        }]
	    });



		$('#containerPie').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '<s:property value="title"/>项目报建区域分布统计'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: '项目报建',
            data: pieResult
        }]
		});

	});
</script>
</head>

<body onload="queryArea()">
	<div class="ry_wrapp">
      
        <div class="ry_content">
        <form>
					<div class="ry_main" cellpadding="0" cellspacing="0">
						<h2>项目报建统计分析</h2>
						<table class="ry_left left">
							<tr>
                        		<td>申请日期：</td>
                        		<td colspan="3">
                        <input id="time1" value="<s:date name="startDate" format="yyyy-MM-dd" />" type="text" name="startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input id="time2" value="<s:date name="endDate" format="yyyy-MM-dd" />" type="text" name="endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
							<tr>
								<td>所属地市：</td>
								<td>
								<select id="cityId" name="cityNum" onchange="queryArea()">
     							<option value="">请选择</option>
	      						<s:iterator value="citys">
	          						<option value="<s:property value="code"/>"<s:if test='cityNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
								</select>
								</td>
								<td>所属区县：</td>
								<td>
								<select id="areaId" name="areaNum" class="required" >
		                			<option value="">请选择</option>
		                		</select>
								</td>
							</tr>
							
						</table>
						<table class="ry_right left">
							<tr>
								<td><input type="image" onclick="query()"
									src="<%=basepath%>/images/ry_look.png" /></td>
							</tr>
						</table>

					</div>
				</form>
            <div class="ry_liebiao">
            	
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                          	<td>
                          		<div id="container" style="width: 100%; height: 400px"></div>
                          	</td>
                         </tr>
					</tbody>  


					<tbody>   
                         <tr>
                          	<td>
                          		<div id="containerPie" style="width: 100%; height: 400px"></div>
                          	</td>
                         </tr>
					</tbody>  
                </table>
         </div>
        </div>
    </div>
</body>
</html>
