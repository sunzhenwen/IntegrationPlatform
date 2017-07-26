package com.tj.jst.outside.business.queryBusiness.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.queryBusiness.condition.QueryContractFilingCondition;
import com.tj.jst.outside.business.queryBusiness.service.IQueryContractFilingService;
import com.tj.jst.outside.business.queryBusiness.service.QueryContractFilingServiceImpl;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

/**
 * 合同备案
 * @author hhc
 *
 */
public class QueryContractFilingAction extends BaseAction {
	
	//合同主键
	private String recordId;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//合同备案实体类
	private ContractFiling contractFiling;
	//合同类别
	private List<DictionaryClass> contractTypeNums;
	//审批部门
	private List<Regional> list;
	//项目报建实体主键
	private String prjId;
	//返回提示信息
	private String message;
	private String result;
	private String treeStr;
	//企业组织机构代码
	private String corpCode;
	//企业名称
	private String corpName;
	private String conId;
	private FileWorld fw;
	private List<FileWorld> worldList;
	private String inCommon;
	private String conType;
	private String fileName;
	private String filePath;
	private String nameCode;
	
	private QueryContractFilingCondition condition = new QueryContractFilingCondition();
	
	public void setCondition(QueryContractFilingCondition condition) {
		this.condition = condition;
	}

	public QueryContractFilingCondition getCondition() {
		QueryContractFilingCondition sessionCondition = (QueryContractFilingCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IQueryContractFilingService service = new QueryContractFilingServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 查询审批部门
	 * @return
	 */
	public String queryAppDept()
	{
		IQueryContractFilingService service = new QueryContractFilingServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	/**
	 * 跳转合同备案申请修改页面
	 * @return
	 */
	public String modifyPage()
	{
		IQueryContractFilingService service = new QueryContractFilingServiceImpl();
		//合同类别
		contractTypeNums = service.queryContractTypeNums();
		contractFiling = service.queryById(recordId);
		worldList = service.fileWorldList(recordId);
		return "modifyPage";
	}
	public String queryPrjName()
	{
		IQueryContractFilingService service = new QueryContractFilingServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	/**
	 * 返回项目报建列表目录
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * 返回业务办理目录
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}
	
	/**
	 * 查看合同
	 * @return
	 */
	public String fileWorld()
	{
		IQueryContractFilingService service = new QueryContractFilingServiceImpl();
		fw = service.fileWorld(conId);
		
		String url = "";
		//linux
		url = fw.getLinkAddress().substring(fw.getLinkAddress().indexOf("/cip"), fw.getLinkAddress().length());
		//windows
		//url = fw.getLinkAddress();
		
		//打开world模板
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	// Create custom toolbar
    	poCtrl1.addCustomToolButton("打印", "ShowPrintDlg()", 6);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.webOpen(url, OpenModeType.docReadOnly, (String)this.get("userName"));
    	poCtrl1.setTagId("PageOfficeCtrl2"); //此行必须
    	
		recordId = fw.getRecordId();
		return "fileWorld";
	}
	
	

	
	
	
	/**
	 * 查看通用合同
	 * @return
	 */
	public String currencyFileWorld()
	{
		IQueryContractFilingService service = new QueryContractFilingServiceImpl();
		fw = service.currencyFileWorld(inCommon,conType);
		
		//打开world模板
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(ServletActionContext.getRequest());
    	poCtrl1.setServerPage("poserver.do"); //此行必须
    	// Create custom toolbar
    	poCtrl1.addCustomToolButton("打印", "ShowPrintDlg()", 6);
    	poCtrl1.addCustomToolButton("-", "", 0);
    	poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
    	poCtrl1.webOpen(fw.getLinkAddress(), OpenModeType.docReadOnly, (String)this.get("userName"));
    	poCtrl1.setTagId("PageOfficeCtrl2"); //此行必须

		recordId = fw.getRecordId();
		return "fileWorld";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Regional> getList() {
		return list;
	}

	public void setList(List<Regional> list) {
		this.list = list;
	}

	public String getTreeStr() {
		return treeStr;
	}

	public void setTreeStr(String treeStr) {
		this.treeStr = treeStr;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public ContractFiling getContractFiling() {
		return contractFiling;
	}

	public void setContractFiling(ContractFiling contractFiling) {
		this.contractFiling = contractFiling;
	}

	public List<DictionaryClass> getContractTypeNums() {
		return contractTypeNums;
	}

	public void setContractTypeNums(List<DictionaryClass> contractTypeNums) {
		this.contractTypeNums = contractTypeNums;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public FileWorld getFw() {
		return fw;
	}

	public void setFw(FileWorld fw) {
		this.fw = fw;
	}

	public List<FileWorld> getWorldList() {
		return worldList;
	}

	public void setWorldList(List<FileWorld> worldList) {
		this.worldList = worldList;
	}

	public String getInCommon() {
		return inCommon;
	}

	public void setInCommon(String inCommon) {
		this.inCommon = inCommon;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getNameCode() {
		return nameCode;
	}

	public void setNameCode(String nameCode) {
		this.nameCode = nameCode;
	}

}
