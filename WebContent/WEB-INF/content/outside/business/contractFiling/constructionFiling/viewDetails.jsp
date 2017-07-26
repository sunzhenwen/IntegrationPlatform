<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="fileWorld.conName"/> </title>
<script type="text/javascript">

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/fileWorldAction_goList.action";
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
                         	<td>
						<s:property value="fileWorld.conName"/>
                    	<input type="hidden" name="fileWorld.conId" value="<s:property value="fileWorld.conId"/>" />
                    	<input type="hidden" name="fileWorld.conName" value="<s:property value="fileWorld.conName"/>" />
                    	<input type="hidden" name="fileWorld.conType" value="<s:property value="fileWorld.conType"/>" />
                    	<input type="hidden" name="fileWorld.checkType" value="<s:property value="fileWorld.checkType"/>" />
                    	<input type="hidden" name="fileWorld.recordId" value="<s:property value="fileWorld.recordId"/>" />
                    	<input type="hidden" name="fileWorld.templateId" value="<s:property value="fileWorld.templateId"/>" />
                    	<input type="hidden" name="fileWorld.pnumber" value="<s:property value="fileWorld.pnumber"/>" />
							</td>
							
                         </tr>
                         <tr>
                        	<td>
                    		<!--**************   卓正 PageOffice 客户端代码开始    ************************-->
	<script language="javascript" type="text/javascript">

	    function SetFullScreen() {
	        document.getElementById("PageOfficeCtrl2").FullScreen = !document.getElementById("PageOfficeCtrl2").FullScreen;
	    }
	    function AddSeal() {
	        document.getElementById("PageOfficeCtrl2").ZoomSeal.AddSeal();
	    }
	    function AddHandSign() {
	        document.getElementById("PageOfficeCtrl2").ZoomSeal.AddHandSign();
	    }
	    function VerifySeal() {
	        try
	        {
	            document.getElementById("PageOfficeCtrl2").ZoomSeal.VerifySeal();
	        }
	        catch(e)
	        {
	        }
	    }
	</script>
    <!--**************   卓正 PageOffice 客户端代码结束    ************************-->
    <div style="width:auto; height:600px;">
      <po:PageOfficeCtrl id="PageOfficeCtrl2" />
    </div>
							</td>
						</tr>
                
                </tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		        </div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
