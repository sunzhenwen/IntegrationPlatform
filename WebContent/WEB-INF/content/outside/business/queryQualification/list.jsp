<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop2.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业拥有资质查询 </title>
<script type="text/javascript">
	
</script>
</head>

<body onload="getMessage()" >
	<div class="ry_wrapp" style="min-width: 0px" >
    	
       <div class="ry_content"  style="min-width: 0px" >
        <div class="ry_liebiao" style="min-width: 0px" >
            	<p class="f16 pd10 fb " style="min-width: 0px" ><s:property value="qualifications.get(0).getCorpName()" /><img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" style="min-width: 0px" cellpadding="0" cellspacing="0">
                	<tbody>
                         <tr>
                            <th>资质名称</th>
                            <th>证书编号</th>
                          </tr>
                          <s:iterator status="i" value="qualifications" > 
                          <tr>
                            <td><s:property value="certName"/></td>
                            <td><s:property value="certId"/></td>
                         </tr>
						 </s:iterator>
                      
                	</tbody>  
                </table>
                <%@include file="/WEB-INF/content/inc/page.jsp"%> 
                
         </div>
        </div>
    </div>
</body>
</html>
