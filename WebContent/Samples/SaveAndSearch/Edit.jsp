<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*;"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
    String strKey=request.getParameter("key");
    if(strKey!=null&&strKey.trim().length()>0){
     strKey=new String(strKey.getBytes("ISO-8859-1"),"utf-8");
    }
    PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.zz"); //此行必须
	//隐藏菜单栏
	poCtrl1.setMenubar(false);
	poCtrl1.addCustomToolButton("保存","Save()",1);
	//设置保存页面
	poCtrl1.setSaveFilePage("SaveFile.jsp");
	//打开Word文件
	request.setCharacterEncoding("utf-8");
	String filename=new String(request.getParameter("filename").getBytes("ISO-8859-1"),"utf-8").trim();
	String filePath= request.getSession().getServletContext().getRealPath("SaveAndSearch/doc/"+filename+".doc");
	poCtrl1.webOpen(filePath, OpenModeType.docNormalEdit, "张三");
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>编辑文档页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
        var strKey = "<%=strKey%>";
        function Save() {
            if (strKey != "") SetKeyWord(strKey, false);
            document.getElementById("PageOfficeCtrl1").WebSave();
            //document.getElementById("PageOfficeCtrl1").CustomSaveResult获取的是保存页面的返回值
            if (document.getElementById("PageOfficeCtrl1").CustomSaveResult == "ok")
                document.getElementById("PageOfficeCtrl1").Alert("保存成功");
            else
                 document.getElementById("PageOfficeCtrl1").Alert(document.getElementById("PageOfficeCtrl1").CustomSaveResult);
        }

         function SetKeyWord(key, visible) { 
           if (key=="null"||"" == key) {
                 document.getElementById("PageOfficeCtrl1").Alert("关键字为空。");
                return;
            }  
             var sMac = "function myfunc()" + "\r\n"
                        + "Application.Selection.HomeKey(6) \r\n"
                        + "Application.Selection.Find.ClearFormatting \r\n"
                        + "Application.Selection.Find.Replacement.ClearFormatting \r\n"
                        + "Application.Selection.Find.Text = \"" + key + "\" \r\n"

                        + "While (Application.Selection.Find.Execute()) \r\n"
                        +  "If (" + visible + ") Then \r\n"
                        +  "Application.Selection.Range.HighlightColorIndex = 7 \r\n"
                        +  "Else \r\n"
                        +  "Application.Selection.Range.HighlightColorIndex = 0 \r\n"
                        +  "End If \r\n"
                        +  "Wend \r\n"
                        +  "Application.Selection.HomeKey(6) \r\n"
                        + "End function";
            
            document.getElementById("PageOfficeCtrl1").RunMacro("myfunc", sMac);
            
        }
    </script>

  </head>
  
  <body>
   <form id="form1" >
    <input name="button" id="Button1" type="button" onclick="SetKeyWord(strKey,true)" value="高亮显示关键字" />
    <input name="button" id="Button2" type="button" onclick="SetKeyWord(strKey,false)" value="取消关键字显示" />
    <div style="width: auto; height: 700px;">
        <po:PageOfficeCtrl id="PageOfficeCtrl1">
        </po:PageOfficeCtrl>
    </div>
    </form>
  </body>
</html>
