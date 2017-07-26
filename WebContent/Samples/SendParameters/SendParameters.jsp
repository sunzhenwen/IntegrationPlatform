<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
PageOfficeCtrl pocCtrl=new PageOfficeCtrl(request);
//设置服务器页面
pocCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
//添加自定义按钮
pocCtrl.addCustomToolButton("保存", "Save()", 1);
pocCtrl.addCustomToolButton("全屏", "SetFullScreen()", 4);
//设置保存页面
pocCtrl.setSaveFilePage("SaveFile.jsp?id=1");
//打开文件
pocCtrl.webOpen("doc/test.doc", OpenModeType.docNormalEdit, "张佚名");
pocCtrl.setTagId("PageOfficeCtrl1");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>

    <script type="text/javascript">
        function Save() {
            document.getElementById("PageOfficeCtrl1").WebSave();
        }
        function SetFullScreen() {
            document.getElementById("PageOfficeCtrl1").FullScreen = !document.getElementById("PageOfficeCtrl1").FullScreen;
        }
    </script>

</head>
<body>
    <form id="form1">
    <div style="font-size: 14px;">
        <span style="color: Red;">更新人员信息：</span><br />
        <input id="Hidden1" name="age" type="hidden" value="25" />
        <span style="color: Red;">姓名：</span><input id="Text1" name="userName" type="text" value="张三" /><br />
        <span style="color: Red;">性别：</span><select id="Select1" name="selSex">
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
    </div>
    <div style="width: auto; height: 700px;">
        <po:PageOfficeCtrl id="PageOfficeCtrl1" >
        </po:PageOfficeCtrl>
    </div>
    </form>
</body>
</html>
