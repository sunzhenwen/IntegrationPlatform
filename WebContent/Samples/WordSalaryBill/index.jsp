<%@ page language="java"
	import="java.util.*, java.sql.*, java.text.NumberFormat, java.util.Locale,
	java.text.SimpleDateFormat,java.util.Date"
	pageEncoding="gb2312"%>
<%
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//载入驱动程序类别
	String strUrl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
			+ this.getServletContext().getRealPath("WordSalaryBill/demodata/")
			+ "\\demo_salary.mdb";
	Connection conn = DriverManager.getConnection(strUrl);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from Salary  order by ID");
	boolean flg = false;//标识是否有数据
	StringBuilder strHtmls = new StringBuilder();
	SimpleDateFormat  formatDate = new SimpleDateFormat("yyyy-MM-dd");
	//DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	NumberFormat formater = NumberFormat.getCurrencyInstance(Locale.CHINA);
	while (rs.next()) {
		flg = true;
		String pID = rs.getString("ID");
		strHtmls.append("<tr  style='height:40px; text-indent:10px; padding:0; border-right:1px solid #a2c5d9; border-bottom:1px solid #a2c5d9; color:#666;'>");
		strHtmls.append("<td style=' text-align:center;'><input id='check" + pID + "'  type='checkbox' /></td>");
        strHtmls.append("<td style=' text-align:left;'>" + pID + "</td>");
        strHtmls.append("<td style=' text-align:left;'>" + rs.getString("UserName").toString() + "</td>");
        strHtmls.append("<td style=' text-align:left;'>" + rs.getString("DeptName").toString() + "</td>");
        
		
        strHtmls.append("<td style=' text-align:left;'>" + formater.format(Double.parseDouble(rs.getString("SalTotal").toString())) + "</td>");
		strHtmls.append("<td style=' text-align:left;'>" + formater.format(Double.parseDouble(rs.getString("SalDeduct").toString())) + "</td>");
		strHtmls.append("<td style=' text-align:left;'>" + formater.format(Double.parseDouble(rs.getString("SalCount").toString())) + "</td>");
		strHtmls.append("<td style=' text-align:center;'>" + formatDate.format(formatDate.parse(rs.getString("DataTime"))) + "</td>");//rs.getString("DataTime")
		strHtmls.append("<td style=' text-align:center;'><a href='View.jsp?ID=" + pID + "' target='_blank'>查看</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='Openfile.jsp?ID=" + pID + "' target='_blank'>编辑</a></td>");
		strHtmls.append("</tr>");
	}

	if (!flg) {
		strHtmls.append("<tr>\r\n");
		strHtmls.append("<td width='100%' height='100' align='center'>对不起，暂时没有可以操作的数据。\r\n");
		strHtmls.append("</td></tr>\r\n");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>动态生成工资条</title>

		<script type="text/javascript">
        function getID() {
            var ids = "";
            for (var i = 1; i < 11; i++) {
                if (document.getElementById("check" + i.toString()).checked) {
                    ids += i.toString() + ",";
                }
            }
            
            if (ids == "")
                alert("请先选择要生成工资条的记录");
            else
                location.href = "Compose.jsp?ids=" + ids.substr(0, ids.length - 1);
        }

    </script>

	</head>
	<body>
		<div style="text-align: center;">
			<p style="color: Red; font-size: 14px;">
				1.可以点击“操作”栏中的“编辑”来编辑各个员工的工作条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<br />
				2.可以点击“操作”栏中的“查看”来查看各个员工的工作条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<br />
				3.可选择多条工资记录，点“生成工资条”按钮，生成工资条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</p>
			<table
				style="width: 60%; font-size: 12px; text-align: center; border: solid 1px #a2c5d9;">
<%=strHtmls %>
			</table>
			<br />
			<input type="button" value="生成工资条" onclick="getID()" />
		</div>
	</body>
</html>
