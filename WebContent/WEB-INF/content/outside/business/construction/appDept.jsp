<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	//取得当前Web应用的名称
	String basepath = request.getContextPath();
%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>企业信息</title>
<link rel="stylesheet" href="<%=basepath%>/css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basepath%>/css/public.css" type="text/css" >
	<link rel="stylesheet" href="<%=basepath %>/js/JQueryzTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="<%=basepath %>/js/JQueryzTree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/JQueryzTree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/JQueryzTree/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/JQueryzTree/js/jquery.ztree.exedit-3.5.js"></script>


<script type="text/javascript">
	
	var setting = {
		check: {
			enable: true,
			chkStyle: "radio",
			radioType: "all"
		},
		data: {
			simpleData: {
				enable: true
			}
		},callback:{
            onCheck:onCheck
        }
	};
	
	var zNodes = eval(<s:property value="treeStr" escapeJavaScript="false" escapeHtml="false"/>);
	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
	//获取选中节点的值
	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getCheckedNodes(true),
		v = "";
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
		    //alert(nodes[i].id);   //获取选中节点的id值
		    document.getElementById('appDeptId').value=nodes[i].id;
		    document.getElementById('appDeptName').value=nodes[i].name;
		}
		var parent=window.dialogArguments;
		parent.document.getElementById("appDeptId").value=document.getElementById("appDeptId").value;
		parent.document.getElementById("appDeptName").value=document.getElementById("appDeptName").value;
		window.close();
	}
</script>
</head>

<body>
	<div class="ry_wrapp">
    	<div class="ry_content">
        
        	<div class="ry_newmain" cellpadding="0" cellspacing="0">
              	<h2>审批部门</h2>
              	<input id="appDeptId" type="hidden" />
              	<input id="appDeptName" type="hidden" />
              	<ul id="treeDemo" class="ztree"></ul>
            </div>
        </div>
    </div>
</body>
</html>
