<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*,java.sql.*,java.io.*"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
	String id = "1";
	if (request.getParameter("id") != null
			&& request.getParameter("id").trim().length() > 0) {
		id = request.getParameter("id");
	}
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//���������������
	String strUrl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
			+ this.getServletContext().getRealPath("demodata/")
			+ "\\demo_database.mdb";
	Connection conn = DriverManager.getConnection(strUrl);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from stream where id = "
			+ id);
	int newID = 1;
	if (rs.next()) {
		//******��ȡ�����ļ�������ļ��� ��ʼ*******************************
		byte[] imageBytes = rs.getBytes("Word");
		int fileSize = imageBytes.length;

		response.reset();
		response.setContentType("application/msword"); // application/x-excel, application/ms-powerpoint, application/pdf
		response.setHeader("Content-Disposition",
						"attachment; filename=down.doc"); //fileNӦ���Ǳ�����(utf-8)
		response.setContentLength(fileSize);

		OutputStream outputStream = response.getOutputStream();
		outputStream.write(imageBytes);

		outputStream.flush();
		outputStream.close();
		outputStream = null;
		//******��ȡ�����ļ�������ļ��� ����*******************************	
	}
	rs.close();
	conn.close();
%>

