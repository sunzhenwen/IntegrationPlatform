<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
PageOfficeCtrl pocCtrl=new PageOfficeCtrl(request);
//���÷�����ҳ��
pocCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
//����Զ��尴ť
pocCtrl.addCustomToolButton("����", "Save()", 1);
pocCtrl.addCustomToolButton("ȫ��", "SetFullScreen()", 4);
//���ñ���ҳ��
pocCtrl.setSaveFilePage("SaveFile.jsp?id=1");
//���ļ�
pocCtrl.webOpen("doc/test.doc", OpenModeType.docNormalEdit, "������");
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
        <span style="color: Red;">������Ա��Ϣ��</span><br />
        <input id="Hidden1" name="age" type="hidden" value="25" />
        <span style="color: Red;">������</span><input id="Text1" name="userName" type="text" value="����" /><br />
        <span style="color: Red;">�Ա�</span><select id="Select1" name="selSex">
            <option value="��">��</option>
            <option value="Ů">Ů</option>
        </select>
    </div>
    <div style="width: auto; height: 700px;">
        <po:PageOfficeCtrl id="PageOfficeCtrl1" >
        </po:PageOfficeCtrl>
    </div>
    </form>
</body>
</html>
