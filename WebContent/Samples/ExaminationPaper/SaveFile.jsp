<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,java.sql.*"
	pageEncoding="gb2312"%>
<%@page import="java.awt.image.ConvolveOp"%>
<%
	FileSaver fs = new FileSaver(request, response);
	String err = "";
	if (request.getParameter("id") != null
			&& request.getParameter("id").trim().length() > 0) {
		String id = request.getParameter("id").trim();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//���������������
		String strUrl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
				+ this.getServletContext().getRealPath("demodata/")
				+ "\\demo_paper.mdb";
		Connection conn = DriverManager.getConnection(strUrl);
		String sql= "UPDATE  Stream SET Word=?  where ID=" + id ;
		PreparedStatement pstmt=null;
		pstmt= conn.prepareStatement(sql);
		//�˴���ò��ô˷���pstmt.setBytes(1,fs.getFileBytes());��ȡWord�ĵ��е��������ݣ���Ϊ��Java�д����Ķ���������ĳ����������Ƶ�
		pstmt.setBinaryStream(1,fs.getFileStream(),fs.getFileSize());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();

		fs.setCustomSaveResult("ok");
	} else {
		err = "<script>alert('δ����ļ���ID������ʧ��');</script>";
	}
	fs.close();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'SaveFile.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<%=err%>
	</body>
</html>
