<%@ page language="java"
	import="java.util.*,java.sql.*,com.zhuozhengsoft.pageoffice.wordreader.*,com.zhuozhengsoft.pageoffice.*"
	pageEncoding="gb2312"%>
<%
	String err = "";
	String id = request.getParameter("ID");
	if (id != null && id.length() > 0) {
		String strSql = "select * from Salary where id =" + id
				+ " order by ID";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//���������������
		String strUrl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
				+ this.getServletContext().getRealPath("WordSalaryBill/demodata/")
				+ "\\demo_salary.mdb";
		Connection conn = DriverManager.getConnection(strUrl);
		Statement stmt = conn.createStatement();

		String userName = "", deptName = "", salTotoal = "0", salDeduct = "0", salCount = "0", dateTime = "";
		//-----------  PageOffice �������˱�̿�ʼ  -------------------//
		WordDocument doc = new WordDocument(request, response);
		userName = doc.openDataRegion("PO_UserName").getValue();
		deptName = doc.openDataRegion("PO_DeptName").getValue();
		salTotoal = doc.openDataRegion("PO_SalTotal").getValue();
		salDeduct = doc.openDataRegion("PO_SalDeduct").getValue();
		salCount = doc.openDataRegion("PO_SalCount").getValue();
		dateTime = doc.openDataRegion("PO_DataTime").getValue();

		String sql = "UPDATE Salary SET UserName='" + userName
				+ "',DeptName='" + deptName + "',SalTotal='" + salTotoal
				+ "',SalDeduct='" + salDeduct + "',SalCount='" + salCount
				+ "',DataTime='" + dateTime + "' WHERE ID=" + id;
				
		int count = stmt.executeUpdate(sql);
		if (count > 0) {
			//��ͻ��˿ؼ��������ϴ���ִ�гɹ�����Ϣ��
			doc.setCustomSaveResult("ok");
		}
		doc.close();
		conn.close();
	} else {

		err = "<script>alert('δ����ļ���ID������ʧ�ܣ�');location.href='Default.aspx'</script>";
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'SaveData.jsp' starting page</title>

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