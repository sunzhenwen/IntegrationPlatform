<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业注册申请流程图</title>
<script type="text/javascript">
	function queryCorpCodePage()
	{
		document.form1.action="<%=basepath %>/corpAction_queryCorpNamePage.action";
		document.form1.submit();
	}
</script>
</head>
<body>

	
    <div class="qy_wrapp">
    	<div class="index_top">
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        	
        </div>
        
        <div class="zc_pic left">
        	<p class="f16">新企业注册申请流程图:</p>
        
        	<img src="<%=basepath %>/img/newzcpic.png" />

        </div>
        <div>
        <form id="form1" name="form1" method="post" action="" class="zc_nextbn left">
        	<input  type="image" src="<%=basepath %>/img/pic_next.gif" onclick="queryCorpCodePage()"/>
        </form>
        </div>
   		<%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    
    </div>

</body>
</html>