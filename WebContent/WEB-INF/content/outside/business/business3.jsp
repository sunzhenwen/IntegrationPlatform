<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop2.jsp"%>
<%@ page import="com.tj.jst.login.model.Login"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业备案</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">

	//查询注册建造师
	function queryConstructo()
	{
		document.form1.action="<%=basepath%>/otherConstructorAction_queryPage.action";
		document.form1.submit();
	}
	
	//查询外省岗位人员
	function queryOtherPositions()
	{
		document.form1.action="<%=basepath%>/otherPositionsAction_queryPage.action";
		document.form1.submit();
	}
	//查询技术工人
	function querySkilledworker()
	{
		document.form1.action="<%=basepath%>/otherSkilledworkerAction_queryPage.action";
		document.form1.submit();
	}

	//职称人员
	function queryTitle()
	{
		document.form1.action="<%=basepath%>/otherTitleAction_queryPage.action";
		document.form1.submit();
	}
	
	//三类人员
	function queryThreeTypePerson()
	{
		document.form1.action="<%=basepath%>/threeTypePersonAction_queryPage.action";
		document.form1.submit();
	}
	
	//操作提示信息
	function getMessage()
	{
		var message = document.getElementById("message").value;
		if(message != "")
		{
			alert(message);
		}
	}

	//查询企业拥有资质 
	function queryCert()
	{
		document.form1.action="<%=basepath%>/queryOtherCorpCertAction_queryPage.action";
		document.form1.submit();
	}

	//项目备案
	function queryProject()
	{
		document.form1.action="<%=basepath%>/otherProjectAction_queryPage.action";
		document.form1.submit();
	}
	
	//项目人员备案
	function queryProjectStaff()
	{
		document.form1.action="<%=basepath%>/projectStaffAction_queryProject.action";
		document.form1.submit();
	}

</script>
</head>
<body style="background:#fff url(images/bg.jpg) no-repeat bottom;background-size:cover;-webkit-background-size: cover;-moz-background-size: cover;
 -o-background-size: cover; min-width:1366px;">
<form id="form1" name="form1" method="post" action="" onsubmit='return Validate();' language='jscript'>
 <div class="ytwrapp">
<div class="head">
  <div class="head_a1">
       <p class="logo"><img src="images/lg.png"></p>
    <div class="head_a3">
      <div class="header-search"> 
      <a href="/">收藏本站</a> |
      <a href="/">联系我们</a>|
      <a href="/">安全退出</a>
      </div>
    </div>
  </div>

</div>  
   <div class="index_bottom">
     <div class="inb_left_new inbb ry_right" >
            	
                 <ul>
                    <li class="ywlifrist">外省企业人员填报</li>
                    <a href="#" onclick="queryConstructo()"><li>注册执业人员(数据导入)</li></a>
					<a href="#" onclick="queryOtherPositions()"><li>现场管理人员(企业填报)</li></a>
					<a href="#" onclick="querySkilledworker()"><li>技术工人(企业填报)</li></a>
					<a href="#" onclick="queryTitle()"><li>技术职称人员(企业填报)</li></a>
					<a href="#" onclick="queryThreeTypePerson()"><li>三类人员(企业填报)</li></a>
					<a href="#" onclick="queryCert()"><li>行业企业拥有资质</li></a>
                               
                </ul>
         
       </div>
            
   
     <div class="inb_left_new inbb ry_right"  style="margin-left:20px;display:inline;">
            	
                 <ul>
                    <li class="ywlifrist">外省企业项目备案</li>
                    <a href="#" onclick="queryProject()"><li>企业项目备案</li></a>
                    <a href="#" onclick="queryProjectStaff()"><li>项目相关人员备案</li></a>
				</ul>
         
       </div> 
            
            
            
            
            
            
            
            
            
            
        
        </div>
        
        
    
 </div>
  </form>
</body>
</html>