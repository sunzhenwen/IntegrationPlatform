<%@ page language="java"
	import="java.util.*,java.sql.*,javax.servlet.*,javax.servlet.http.*,java.io.*"
	pageEncoding="gb2312"%>
<%
	String err = "";
	if (request.getParameter("id") != null
			&& request.getParameter("id").trim().length() > 0) {
		String id = request.getParameter("id");
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//载入驱动程序类别
		String strUrl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
				+ this.getServletContext().getRealPath("demodata/")
				+ "\\demo_paper.mdb";
		Connection conn = DriverManager.getConnection(strUrl);
		Statement stmt = conn.createStatement();
		String strSql = "select * from stream where id =" + id;
		ResultSet rs = stmt.executeQuery(strSql);
		if (rs.next()) {
			//******读取磁盘文件，输出文件流 开始*******************************
			byte[] imageBytes = rs.getBytes("Word");
			int fileSize = imageBytes.length;

			response.reset();
			response.setContentType("application/msword"); // application/x-excel, application/ms-powerpoint, application/pdf
			response.setHeader("Content-Disposition", "attachment; filename=down.doc"); //fileN应该是编码后的(utf-8)
			response.setContentLength(fileSize);

			OutputStream outputStream = response.getOutputStream();
			outputStream.write(imageBytes);

			outputStream.flush();
			outputStream.close();
			outputStream = null;
			//******读取磁盘文件，输出文件流 结束*******************************	
		} else {
			err = "未获得文件的信息";
		}
		rs.close();
		conn.close();
	} else {
		err = "未获得文件的ID";
		//out.print(err);
	}
	if (err.length() > 0)
		err = "<script>alert(" + err + ");</script>";
%>
