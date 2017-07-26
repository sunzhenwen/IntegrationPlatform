<%@ page language="java" import="java.util.*,com.zhuozhengsoft.pageoffice.*" pageEncoding="utf-8"%>
<%
FileSaver fs=new FileSaver(request,response);
fs.saveToFile(request.getSession().getServletContext().getRealPath("SaveAndSearch/doc/")+"/"+fs.getFileName());
fs.setCustomSaveResult("保存成功！");
fs.close();
%>

