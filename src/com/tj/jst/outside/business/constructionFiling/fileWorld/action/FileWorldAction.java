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
 * ʩ����ͬwordģ��
 * @author hhc
 *
 */
public class FileWorldAction extends BaseAction {
	
	private String conId;
	private String conType;//��ͬ���
	//��ͬ��������
	private String recordId;
	private String checkType;//����Ƿ��Ѿ��ύ�����δ�ύ��ѯģ�壬����ύ��ѯҵ��� 0��δ�ύ 1�����ύ
	private List<FileWorld> list;
	private FileWorld fileWorld;
	private String fileName;//ģ���ļ�����
	private String newFileName;//�µ�ģ������
	
	/**
	 * ��ѯ�б�
	 * @return
	 */
	public String fileWorldPage()
	{
		IFileWorldService fw = new FileWorldServiceImpl();
		//��ѯ��ͬ
		list = fw.queryFileWorld(recordId,conType);
		
		//�н�
		if(conType.equals("2"))
		{
			return "fileWorldPage";
		}else if(conType.equals("1"))
		{
			//����
			return "reformFileWorld";
		}else if(conType.equals("3"))
		{
			//רҵ�ְ�
			return "subPackageFileWorld";
		}else
		{
			//����ְ�
			return "labourServicesFileWorld";
		}
		
		
	}
	
	/**
	 * ��ѯ��ϸ
	 * @return
	 * @throws Exception 
	 */
	public String queryConMessage() throws Exception
	{
		IFileWorldService fw = new FileWorldServiceImpl();
		fileWorld = fw.queryConMessage(conId,checkType,recordId);
		

    	
		//��worldģ��
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	poCtrl1.setServerPage("poserver.do"); //���б���
    	// Create custom toolbar
    	poCtrl1.addCustomToolButton("����", "SaveDocument()", 1);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("ȫ���л�", "SetFullScreen()", 4);
    	poCtrl1.setSaveFilePage("fileWorldAction_saveword.action");
    	//�����ִ��ҳ��˺���
    	poCtrl1.setJsFunction_AfterDocumentSaved("goMess()");
    	//ģ��·��
    	String worldFile = "";
    	//�����ַ��doc����docx��β,˵���Ѿ��ύ�����ݵ�ҵ���,��ҵ����еı����ַ���и�ֵ
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
    	poCtrl1.setTagId("PageOfficeCtrl1"); //���б���
    	return "queryConMessage";
	}

	/**
	 * ����
	 * @return
	 */
	public String save(FileWorld fw)
	{
		IFileWorldService fws = new FileWorldServiceImpl();
		conType = fw.getConType();
		if(fw.getCheckType().equals("0"))
		{
			//���δ�ύ����ҵ����в�������
			recordId = fws.save(fw);
		}
//		else
//		{
//			//������ύ�޸�ҵ����е�����
//			recordId = fws.update(fw);
//		}
		return "query";
	}
	
	/**
	 * ����ģ��
	 * @return
	 * @throws Exception
	 */
    public void saveword() throws Exception {
    	
    	FileSaver fs = new FileSaver(request, this.getResponse());
    	//��ȡ·��
    	String root = ServletActionContext.getServletContext().getRealPath("completeDoc");
		//����ҳ�洫ֵ
    	String conName = fs.getFormField("fileWorld.conName");
    	String conId = fs.getFormField("fileWorld.conId");
    	String conType = fs.getFormField("fileWorld.conType");
    	String checkType = fs.getFormField("fileWorld.checkType");
    	String recordId = fs.getFormField("fileWorld.recordId");
    	String templateId = fs.getFormField("fileWorld.templateId");
    	String pnumber = fs.getFormField("fileWorld.pnumber");
    	String newConName = "";
    	String worldFile = "";
    	//��ȡuuid
    	String uuid = "";
    	if(checkType.equals("0"))
    	{
    		uuid = UUID.randomUUID().toString();
    		//�����µ��ļ�����
        	newConName = conName+"("+uuid+").doc";
            //�����µ��ļ�����·��
        	worldFile = root+"\\"+newConName;
        	worldFile = worldFile.replace("\\", File.separator);
    	}else
    	{
    		worldFile = root+"\\"+conName;
    		worldFile = worldFile.replace("\\", File.separator);
    	}
    		
    	
    	//���ɱ����world�ĵ�
    	fs.saveToFile(worldFile);
    	//fs.showPage(300, 300);
    	//message = "��ʾ�Զ��屣������";
    	fs.close();
    	
    	FileWorld fw = new FileWorld();
    	//�򱣴淽����ֵ
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
	 * �����б�ҳ��
	 * @return
	 */
	public String goList()
	{
		recordId = fileWorld.getRecordId();
		conType = fileWorld.getConType();
		return "query";
	}
	
	/**
	 * �����н���ͬ�����б�
	 * @return
	 */
	public String goTheContractor()
	{
		return "queryTheContractor";
	}
	
	/**
	 * ���ط��ĺ�ͬ�����б�
	 * @return
	 */
	public String goReform()
	{
		return "queryReform";
	}

	/**
	 * ����ʩ���ְ���ͬ�����б�
	 * @return
	 */
	public String goSubPackage()
	{
		return "querySubPackage";
	}

	/**
	 * ����ʩ�������ͬ�����б�
	 * @return
	 */
	public String goLabourServices()
	{
		return "queryLabourServices";
	}
	
	/**
	 * ɾ��ҵ������ݻ�ԭģ��
	 * @return
	 */
	public String delete()
	{
		IFileWorldService fw = new FileWorldServiceImpl();
		fw.delete(conId);
		return "query";
	}
	
	/**
	 * �鿴
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
		
		//��worldģ��
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	poCtrl1.setServerPage("poserver.do"); //���б���
    	// Create custom toolbar
    	poCtrl1.addCustomToolButton("ȫ���л�", "SetFullScreen()", 4);
    	poCtrl1.webOpen(url, OpenModeType.docReadOnly, (String)this.get("userName"));
    	poCtrl1.setTagId("PageOfficeCtrl2"); //���б���
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
