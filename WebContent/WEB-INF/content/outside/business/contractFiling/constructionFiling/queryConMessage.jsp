<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title><s:property value="fileWorld.conName"/> </title>
<script type="text/javascript">

	//保存
	function save()
	{
		document.form1.action="<%=path %>/fileWorldAction_save.action";
		document.form1.submit();
	}

	//取消
	function goMess()
	{
		document.form1.action="<%=path %>/fileWorldAction_fileWorldPage.action?recordId=<s:property value="fileWorld.recordId"/>&conType=<s:property value="fileWorld.conType"/>";
		document.form1.submit();
	}
	
	
	//取消
	function goBack()
	{
		document.form1.action="<%=path %>/fileWorldAction_goList.action";
		document.form1.submit();
	}
</script>

</head>

<body>

	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2><s:property value="fileWorld.zhConName"/></h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                        <input type="hidden" name="fileWorld.conId" value="<s:property value="fileWorld.conId"/>" />
                    	<input type="hidden" name="fileWorld.conName" value="<s:property value="fileWorld.conName"/>" />
                    	<input type="hidden" name="fileWorld.conType" value="<s:property value="fileWorld.conType"/>" />
                    	<input type="hidden" name="fileWorld.checkType" value="<s:property value="fileWorld.checkType"/>" />
                    	<input type="hidden" name="fileWorld.recordId" value="<s:property value="fileWorld.recordId"/>" />
                    	<input type="hidden" name="fileWorld.templateId" value="<s:property value="fileWorld.templateId"/>" />
                    	<input type="hidden" name="fileWorld.pnumber" value="<s:property value="fileWorld.pnumber"/>" />
                         	<td colspan="2">
	<!--**************   卓正 PageOffice 客户端代码开始    ************************-->
	<script language="javascript" type="text/javascript">
	    function SaveDocument() {
	        document.getElementById("PageOfficeCtrl1").WebSave();
	        //alert(document.getElementById("PageOfficeCtrl1").CustomSaveResult);
	    }
	    function SetFullScreen() {
	        document.getElementById("PageOfficeCtrl1").FullScreen = !document.getElementById("PageOfficeCtrl1").FullScreen;
	    }
	    function AddSeal() {
	        document.getElementById("PageOfficeCtrl1").ZoomSeal.AddSeal();
	    }
	    function AddHandSign() {
	        document.getElementById("PageOfficeCtrl1").ZoomSeal.AddHandSign();
	    }
	    function VerifySeal() {
	        try
	        {
	            document.getElementById("PageOfficeCtrl1").ZoomSeal.VerifySeal();
	        }
	        catch(e)
	        {
	        }
	    }
	</script>
    <!--**************   卓正 PageOffice 客户端代码结束    ************************-->
    <div style="width:auto; height:600px;">
      <po:PageOfficeCtrl id="PageOfficeCtrl1" />
    </div>
				</tr>
                
                <tr>
                	<th>审核意见<br/><font color="red" style="font-size: small;">*审核部门填写</font></th>
                    <td>
					<textarea name="fileWorld.reason" cols="100" rows="5"><s:property value="fileWorld.reason"/></textarea>
    				</td>
				</tr>
                         
                </tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		        	<!-- 
		            <input type="image" onclick="save()" src="<%=basepath %>/images/baocun.jpg" />
            		 -->
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
