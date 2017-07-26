﻿<%@ page language="java" import="java.util.*,java.sql.*,java.net.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head id="Head1">
    <title></title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
        function onColor(td) {
            td.style.backgroundColor = '#D7FFEE';
        }
        function offColor(td) {
            td.style.backgroundColor = '';
        }
        function getFocus() {
            var str = document.getElementById("Input_KeyWord").value;
            if (str == "请输入关键字") {
                document.getElementById("Input_KeyWord").value = "";
            }

        }
        function lostFocus() {
            var str = document.getElementById("Input_KeyWord").value;
            if (str.length <= 0) {
                document.getElementById("Input_KeyWord").value = "请输入关键字";
            }
        }
        function copyKeyToInput(key) {
            document.getElementById("Input_KeyWord").value = key;
        }

    </script>

</head>
  
 <body>
    <!--header-->
    <div class="zz-headBox br-5 clearfix" align="center">
        <div class="zz-head mc">
            <!--logo-->
            <div class="logo fl">
                <a href="#">
                    <img src="images/logo.png" alt="" /></a></div>
            <!--logo end-->
            <ul class="head-rightUl fr">
                <li><a href="http://www.zhuozhengsoft.com">卓正网站</a></li>
                <li><a href="http://www.zhuozhengsoft.com/poask/index.asp">客户问吧</a></li>
                <li class="bor-0"><a href="http://www.zhuozhengsoft.com/contact-us.html">联系我们</a></li>
            </ul>
        </div>
    </div>
    <!--header end-->
    <!--content-->
    <div class="zz-content mc clearfix pd-28" align="center">
        <div class="demo mc">
            <h2 class="fs-16">
                PageOffice 实现Word文档的在线编辑保存和全文关键字搜索</h2>
        </div>
        <div class="demo mc">
            <h3 class="fs-12">
                搜索文件</h3>
            <form id="form1" action="FileManage.jsp">
            <table class="text" cellspacing="0" cellpadding="0" border="0">
                <tr>
                    <td style="font-size: 9pt" align="left">
                        通过文档内容中的关键字搜索文档&nbsp;&nbsp;&nbsp;
                    </td>
                    <td align="center">
                        <input name="Input_KeyWord" id="Input_KeyWord" type="text" onfocus="getFocus()" onblur="lostFocus()"
                            class="boder" style="width: 180px;" value="请输入关键字" />
                    </td>
                    <td style="width: 221px;">
                        &nbsp;
                        <input type="submit" value="搜索文档" style=" width:86px;" />
                    </td>
                </tr>
                <tr>
                    <td >&nbsp;</td>
                    <td colspan="2">&nbsp;<span style="color:Gray;">热门搜索：</span> 
                    <a href="#" style="color:#00217d;" onclick="copyKeyToInput('网站');">网站</a>
                    <a href="#" style="color:#00217d;" onclick="copyKeyToInput('软件');">软件</a>
                    <a href="#" style="color:#00217d;" onclick="copyKeyToInput('字体');">字体</a></td>
                </tr>
            </table>
            </form>
        </div>
        <div class="zz-talbeBox mc" >
            <h2 class="fs-12">
                    文档列表</h2>
            <table class="zz-talbe">
                <thead>
                    <tr>
                        <th width="90%">
                                               文档名称
                        </th>
                        <th width="100%">
                                               操作
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    	String key = request.getParameter("Input_KeyWord");
                    	String sql = "";
                    	if (key != null && key.trim().length() > 0) {
                    		key= new String(key.getBytes("ISO-8859-1"), "utf-8");
                    		sql = "select * from word  where Content like '%" + key
                    				+ "%' order by ID desc";
                    	} else {
                    		sql = "select * from word order by ID desc";
                    	}
                    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//载入驱动程序类别
                    	String strUrl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="
                    			+ this.getServletContext().getRealPath("demodata/")
                    			+ "\\demo_search.mdb";
                    	Connection conn = DriverManager.getConnection(strUrl);
                    	Statement stmt = conn.createStatement();
                    	ResultSet rs = stmt.executeQuery(sql);
                    	int id;
                    	String FileName = "";
                    	String Content = "";
                    	while (rs.next()) {
                    		FileName = rs.getString("FileName");
                    		Content = rs.getString("Content");
                    		//id = rs.getInt("ID");
                    %>
					<tr onmouseover='onColor(this)' onmouseout='offColor(this)'>
					<td>
					<%=FileName%>			
					</td>
					
					<td style='text-align:center;'>
					<a style="color:#00217d;" href='Edit.jsp?filename=<%=URLEncoder.encode(FileName, "utf-8") %>&key=<%=key%>'>编辑</a>			
					</td>
					
				<%
					}
				%>
					</tr>
					<%
						stmt.close();
						conn.close();
					%>
                </tbody>
            </table>
        </div>
    </div>
    <!--content end-->
    <!--footer-->
    <div class="login-footer clearfix">
        Copyright &copy 2013 北京卓正志远软件有限公司</div>
    <!--footer end-->
</body>
</html>
