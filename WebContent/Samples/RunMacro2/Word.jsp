<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
//******************************卓正PageOffice组件的使用*******************************
	//设置PageOffice服务器组件
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz"); //此行必须
	
	//隐藏菜单栏
	poCtrl1.setMenubar(false);
	//隐藏自定义工具栏
	poCtrl1.setCustomToolbar(false);
	
	//打开文件
	poCtrl1.webOpen("doc/test.doc", OpenModeType.docNormalEdit, "张三");
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须	
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>执行有返回值的宏命令</title>

    <script language="javascript" type="text/javascript">

        function Button1_onclick() {
            var value=document.getElementById("PageOfficeCtrl1").RunMacro("myFunc1", document.getElementById("textarea1").value);
           document.getElementById("PageOfficeCtrl1").Alert("myFunc1宏的返回值是："+value);
        }
	
	function RunMacro2(){
  		var value=document.getElementById("PageOfficeCtrl1").RunMacro("myFunc2", 'Function myFunc2() \r\n myFunc2 = "123" \r\n End Function');
 		document.getElementById("PageOfficeCtrl1").Alert(value);
  	}


    </script>
</head>
<body>
    <form id="form1">
    <div style="font-size: 12px; line-height: 20px; border-bottom: dotted 1px #ccc; border-top: dotted 1px #ccc;
        padding: 5px;">
        注意：<span style="background-color: Yellow;">执行“执行宏myFunc”按钮之前需先设置好MS Word的关于执行宏命令的设置。
        <br />设置步骤如下：打开一个Word文档，点击“文件”→“选项”→“信任中心”→“信任中心设置”→“宏设置”→勾选上“信任对VBA工程对象模型的访问（V）”</span>
    </div>
    <textarea id="textarea1" name="textarea1" style=" height:87px; width:486px;" rows="" cols="" >
   Function myFunc1() 
   myFunc1 = "123"
   End Function
    </textarea>
    <input id="Button1" type="button" value="执行宏myFunc1" onclick="return Button1_onclick()" />
    <input id="Button2" type="button" value="执行宏myFunc2" onclick="RunMacro2()" />
    <div style=" height:800px;">
        <po:PageOfficeCtrl id="PageOfficeCtrl1">
        </po:PageOfficeCtrl>
    </div>
    </form>
</body>
</html>

