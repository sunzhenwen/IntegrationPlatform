package com.tj.jst.outside.business.constructionFiling.fileWorld.action;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;
import com.tj.jst.outside.business.constructionFiling.fileWorld.service.FileWorldServiceImpl;
import com.tj.jst.outside.business.constructionFiling.fileWorld.service.IFileWorldService;
import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

/**
 * 施工合同word模板
 * @author hhc
 *
 */
public class FileWorldAction extends BaseAction {
	
	private String conId;
	private String conType;//合同类别
	//合同备案主键
	private String recordId;
	private String checkType;//监测是否已经提交，如果未提交查询模板，如果提交查询业务表 0：未提交 1：已提交
	private List<FileWorld> list;
	private FileWorld fileWorld;
	private String fileName;//模板文件名称
	private String newFileName;//新的模板名称
	
	/**
	 * 查询列表
	 * @return
	 */
	public String fileWorldPage()
	{
		IFileWorldService fw = new FileWorldServiceImpl();
		//查询合同
		list = fw.queryFileWorld(recordId,conType);
		
		//市建
		if(conType.equals("2"))
		{
			return "fileWorldPage";
		}else if(conType.equals("1"))
		{
			//发改
			return "reformFileWorld";
		}else if(conType.equals("3"))
		{
			//专业分包
			return "subPackageFileWorld";
		}else
		{
			//劳务分包
			return "labourServicesFileWorld";
		}
		
		
	}
	
	/**
	 * 查询详细
	 * @return
	 * @throws Exception 
	 */
	public String queryConMessage() throws Exception
	{
		IFileWorldService fw = new FileWorldServiceImpl();
		fileWorld = fw.queryConMessage(conId,checkType,recordId);
		

    	
		//打开world模板
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	// Create custom toolbar
    	poCtrl1.addCustomToolButton("保存", "SaveDocument()", 1);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.setSaveFilePage("fileWorldAction_saveword.action");
    	//保存后执行页面此函数
    	poCtrl1.setJsFunction_AfterDocumentSaved("goMess()");
    	//模板路径
    	String worldFile = "";
    	//如果地址以doc或者docx结尾,说明已经提交过数据到业务表,将业务表中的保存地址进行赋值
    	if(fileWorld.getLinkAddress().endsWith("doc")||fileWorld.getLinkAddress().endsWith("docx"))
    	{
    		//window
    		//worldFile = fileWorld.getLinkAddress();
    		//linux
    		worldFile = fileWorld.getLinkAddress().substring(fileWorld.getLinkAddress().indexOf("/cip"), fileWorld.getLinkAddress().length());
    	}else
    	{
    		worldFile = fileWorld.getLinkAddress()+"\\"+fileWorld.getConName()+".doc";
    		worldFile = worldFile.replace("\\", File.separator);
    	}
    	poCtrl1.webOpen(worldFile, OpenModeType.docNormalEdit, (String)this.get("userName"));
    	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
    	return "queryConMessage";
	}

	/**
	 * 保存
	 * @return
	 */
	public String save(FileWorld fw)
	{
		IFileWorldService fws = new FileWorldServiceImpl();
		conType = fw.getConType();
		if(fw.getCheckType().equals("0"))
		{
			//如果未提交，在业务表中插入数据
			recordId = fws.save(fw);
		}
//		else
//		{
//			//如果已提交修改业务表中的数据
//			recordId = fws.update(fw);
//		}
		return "query";
	}
	
	/**
	 * 保存模板
	 * @return
	 * @throws Exception
	 */
    public void saveword() throws Exception {
    	
    	FileSaver fs = new FileSaver(request, this.getResponse());
    	//获取路径
    	String root = ServletActionContext.getServletContext().getRealPath("completeDoc");
		//接收页面传值
    	String conName = fs.getFormField("fileWorld.conName");
    	String conId = fs.getFormField("fileWorld.conId");
    	String conType = fs.getFormField("fileWorld.conType");
    	String checkType = fs.getFormField("fileWorld.checkType");
    	String recordId = fs.getFormField("fileWorld.recordId");
    	String templateId = fs.getFormField("fileWorld.templateId");
    	String pnumber = fs.getFormField("fileWorld.pnumber");
    	String newConName = "";
    	String worldFile = "";
    	//获取uuid
    	String uuid = "";
    	if(checkType.equals("0"))
    	{
    		uuid = UUID.randomUUID().toString();
    		//生成新的文件名称
        	newConName = conName+"("+uuid+").doc";
            //生成新的文件保存路径
        	worldFile = root+"\\"+newConName;
        	worldFile = worldFile.replace("\\", File.separator);
    	}else
    	{
    		worldFile = root+"\\"+conName;
    		worldFile = worldFile.replace("\\", File.separator);
    	}
    		
    	
    	//生成保存的world文档
    	fs.saveToFile(worldFile);
    	//fs.showPage(300, 300);
    	//message = "显示自定义保存结果。";
    	fs.close();
    	
    	FileWorld fw = new FileWorld();
    	//向保存方法传值
    	fw.setConName(conName);
    	fw.setConId(conId);
    	fw.setConType(conType);
    	fw.setCheckType(checkType);
    	fw.setRecordId(recordId);
    	fw.setTemplateId(templateId);
    	fw.setPnumber(Integer.parseInt(pnumber));
    	fw.setSaveLink(worldFile);
    	fw.setNewConName(newConName);
    	this.save(fw);
    }
	
	/**
	 * 返回列表页面
	 * @return
	 */
	public String goList()
	{
		recordId = fileWorld.getRecordId();
		conType = fileWorld.getConType();
		return "query";
	}
	
	/**
	 * 返回市建合同备案列表
	 * @return
	 */
	public String goTheContractor()
	{
		return "queryTheContractor";
	}
	
	/**
	 * 返回发改合同备案列表
	 * @return
	 */
	public String goReform()
	{
		return "queryReform";
	}

	/**
	 * 返回施工分包合同备案列表
	 * @return
	 */
	public String goSubPackage()
	{
		return "querySubPackage";
	}

	/**
	 * 返回施工劳务合同备案列表
	 * @return
	 */
	public String goLabourServices()
	{
		return "queryLabourServices";
	}
	
	/**
	 * 删除业务表数据还原模板
	 * @return
	 */
	public String delete()
	{
		IFileWorldService fw = new FileWorldServiceImpl();
		fw.delete(conId);
		return "query";
	}
	
	/**
	 * 查看
	 * @return
	 */
	public String viewDetails()
	{
		IFileWorldService fw = new FileWorldServiceImpl();
		fileWorld = fw.viewDetails(conId);

		String url = "";
		//linux
		url = fileWorld.getLinkAddress().substring(fileWorld.getLinkAddress().indexOf("/cip"), fileWorld.getLinkAddress().length());
	
		//windows
		//url = fileWorld.getLinkAddress();
		
		//打开world模板
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	// Create custom toolbar
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.webOpen(url, OpenModeType.docReadOnly, (String)this.get("userName"));
    	poCtrl1.setTagId("PageOfficeCtrl2"); //此行必须
		return "viewDetails";
	}
	
	public List<FileWorld> getList() {
		return list;
	}

	public void setList(List<FileWorld> list) {
		this.list = list;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public FileWorld getFileWorld() {
		return fileWorld;
	}

	public void setFileWorld(FileWorld fileWorld) {
		this.fileWorld = fileWorld;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getConType() {
		return conType;
	}

	public void setConType(String conType) {
		this.conType = conType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

}
