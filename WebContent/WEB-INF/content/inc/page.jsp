<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.opensymphony.xwork2.ognl.OgnlValueStack"%>
<%@ page import="com.tj.jst.base.page.Page" %>
<div class="ry_fenye" >
    <form name="PageForm" method="POST">
    	<%
	String href = "";
	String target = "";
	OgnlValueStack stack = (OgnlValueStack) request.getAttribute("struts.valueStack");
	Page currentPage  = (Page) stack.findValue("currentPage"); 
	if(currentPage == null) return;
	int pageNo = currentPage.getCurrentPageNo();
	long crossPages = currentPage.getTotalPageCount();
	long rowCounts = currentPage.getTotalCount(); 
	int pageSize = currentPage.getPageSize(); 
	long totalCount = currentPage.getTotalCount();
	int currentRow = currentPage.getStartOfPage(pageNo,pageSize); 
	String orderByItem = currentPage.getOrderByItem();								 
	String contextPath = request.getContextPath();
%>
<span>总数[<%=totalCount%>]</span>
<span>页数[<%=pageNo%>/<%=crossPages%>]</span>
	<%if(pageNo==1){ 
		out.print("<span>[首页]</span> <span>[上一页]</span>");   
	}else{  
	%>   
		<A HREF="javascript:gotoPage(1)"><% out.print("<span>[首页]</span>");%></A>
		<A HREF="javascript:gotoPage(<%=pageNo-1%>)"><% out.print("<span>[上一页]</span>");%></A>
	<%}
	if(pageNo==crossPages){
		out.print("<span>[下一页]</span> <span>[尾页]</span>");
	}else{  
	%>   
		<A HREF="javascript:gotoPage(<%=pageNo+1%>)"><% out.print("<span>[下一页]</span>");%></A>
		<A HREF="javascript:gotoPage(<%=crossPages%>)"><% out.print("<span>[尾页]</span>");%></A>
	<%}%>	
	&nbsp;<% out.print("<span>转到第</span>");%><span><SELECT name="jumpPage" width="20" onchange="Jumping()">
	 <% for(int i=1;i<=crossPages;i++)  {
	 if (i == pageNo){
	 %>
	 <OPTION selected value=<%=i%>><%=i%></OPTION>
	 <%}else{%>
	 <OPTION value=<%=i%>><%=i%></OPTION>
	 <%}}%>   
	 </SELECT></span><% out.print("<span>页</span>"); %>

<input type="hidden" name="condition.orderByItem" value="<%=orderByItem%>"/>
<input type="hidden" name="condition.pageNo" value="<%=pageNo%>"/>
<input type="hidden" name="rowCounts" value="<%=rowCounts%>"/>
<script language="javascript">
<!--
function Jumping(){
  var pageNo = document.PageForm.jumpPage.options[document.PageForm.jumpPage.selectedIndex].value;
  formSubmit(pageNo);
}
function gotoPage(pageNo){
	formSubmit(pageNo);
}
function getHref(){
	var href = "<%=href%>";
	return href;
}
function getTarget(){
	var target = "<%=target%>";
	return target;
}
function formSubmit(pageNo){
	document.PageForm.elements['condition.pageNo'].value = pageNo;
	document.PageForm.action=getHref();
	document.PageForm.target=getTarget();
	document.PageForm.submit();
	return ;
}
//-->
</script>
    </form>
</div>
