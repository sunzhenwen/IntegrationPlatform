<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>现场管理人员搜索 </title>
<script type="text/javascript">
	//查询
	function queryConstructor()
	{
		document.form1.action="<%=basepath %>/queryOtherPositionsAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryOtherPositionsAction_goBack.action";
		document.form1.submit();
	}
	
</script>
</head>

<body >
	<div class="ry_wrapp">
    	<div class="head">
  <div class="head_a1">
          <p class="logo"><img src="<%=basepath %>/images/lg.png"></p>
          <div class="head_a3">
          <div class="header-search"> 
          <a href="/">收藏本站</a> |
          <a href="/">联系我们</a>|
          <a href="/">安全退出</a>
          </div>
          </div>
  </div>

</div>
      
        <div class="ry_content">
        <form id="form1" name="form1" method="post" action="">
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>现场管理人员搜索</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>人员名称：</td>
                        <td><input type="text" name="condition.personName" value="<s:property value="condition.personName"/>"/></td>
                        <td>证件号码：</td>
                        <td><input type="text" name="condition.idCard" value="<s:property value="condition.idCard"/>" />
                        </td>
                    </tr>
                    <tr >
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/images/ry_look.png" onclick="queryConstructor()" /></td>
                        <td><input type="image" src="<%=basepath %>/images/ry_return.png" onclick="goBack()" /></td>
                        
                    </tr>
                </table>		
            
            </div>
            </form>
            <div class="ry_liebiao">
            	<p class="f16 pd10 fb">现场管理人员列表<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>序号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>证件号码</th>
                            <th>岗位名称</th>
                            <th>证书编号</th>
                            <th>企业名称</th>
                          </tr>
                          <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="name"/></td>
                            <td>
							<s:if test="sex==0">
                            	男
                            </s:if>
                            <s:else>
                            	女
                            </s:else>
							</td>
                            <td><s:property value="cardId"/></td>
                            <td><s:property value="duty"/></td>
                            <td><s:property value="certNum"/></td>
                            <td><s:property value="entName"/></td>
                            
                         </tr>
						 </s:iterator>
                         
                
                	</tbody>  
                </table>
                <%@include file="/WEB-INF/content/inc/page.jsp"%> 
                
         </div>
         
        
        
    
    	</div>
        <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    </div>
</body>
</html>
