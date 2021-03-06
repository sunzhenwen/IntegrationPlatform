<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*"
	pageEncoding="gb2312"%>
<%@page import="com.zhuozhengsoft.pageoffice.excelwriter.*"%>
<%@page import="java.awt.Color"%>
<%@page import="java.text.*"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
	//设置PageOfficeCtrl控件的服务页面
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz"); //此行必须
	poCtrl1.setCaption("简单的给Excel赋值");
	//定义Workbook对象
	Workbook workBook = new Workbook();
	//定义Sheet对象，"Sheet1"是打开的Excel表单的名称
	Sheet sheet = workBook.openSheet("Sheet1");
	Table table = sheet.openTableByDefinedName("report", 10, 5, false);

    table.getDataFields().get(0).setValue("轮胎");
    table.getDataFields().get(1).setValue("100");
    table.getDataFields().get(2).setValue("120");
    table.getDataFields().get(3).setValue("500");
    table.getDataFields().get(4).setValue("120%");
    
    table.nextRow();
    
    table.close();
	
	poCtrl1.setWriter(workBook);
	
	//隐藏菜单栏
	poCtrl1.setMenubar(false);
	
	poCtrl1.setSaveDataPage("SaveData.jsp");
	poCtrl1.addCustomToolButton("保存", "Save()", 1);
	//打开Word文件
	poCtrl1.webOpen("doc/test.xls", OpenModeType.xlsSubmitForm, "张三");
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>给Excel文档中定义名称的区域赋值</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
        function Save() {
            document.getElementById("PageOfficeCtrl1").WebSave();
        }
    </script>
	</head>

	<body>
	表格的数据是使用后台程序填充进去的，请查看ExcelFill.jsp的代码
		<div style="width: 1000px; height: 800px;">
			<po:PageOfficeCtrl id="PageOfficeCtrl1"></po:PageOfficeCtrl>
		</div>
	</body>
</html>
