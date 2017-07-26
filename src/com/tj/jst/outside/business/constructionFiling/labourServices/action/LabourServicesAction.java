package com.tj.jst.outside.business.constructionFiling.labourServices.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionFiling.labourServices.condition.LabourServicesCondition;
import com.tj.jst.outside.business.constructionFiling.labourServices.service.ILabourServices;
import com.tj.jst.outside.business.constructionFiling.labourServices.service.LabourServicesImpl;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * ʩ�������ͬ����
 * @author hhc
 *
 */
public class LabourServicesAction extends BaseAction {
	
	//��ͬ����
	private String recordId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//��ͬ����ʵ����
	private ContractFiling contractFiling;
	//��ͬ���
	private List<DictionaryClass> contractTypeNums;
	//��������
	private List<Regional> list;
	//��Ŀ����ʵ������
	private String prjId;
	//������ʾ��Ϣ
	private String message;
	private String result;
	private String treeStr;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ����
	private String corpName;
	
	private LabourServicesCondition condition = new LabourServicesCondition();
	
	public void setCondition(LabourServicesCondition condition) {
		this.condition = condition;
	}

	public LabourServicesCondition getCondition() {
		LabourServicesCondition sessionCondition = (LabourServicesCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ת �����ͬ��������ƺ�ͬ�����������ͬ������ʩ����ͬ���� ҳ��
	 * @return
	 */
	public String filingIndex()
	{
		return "filingIndex";
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		ILabourServices service = new LabourServicesImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת�������ҳ��
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//��ҵ��֯��������
		corpCode = login.getCorpCode();
		//��ҵ����
		corpName = login.getUserName();
		ILabourServices service = new LabourServicesImpl();
		//��ͬ���
		contractTypeNums = service.queryContractTypeNums();
		return "addPage";
	}
	
	/**
	 * ��ͬ��������
	 * @return
	 */
	public String add()
	{
		ILabourServices service = new LabourServicesImpl();
		recordId = service.add(contractFiling);
		return "queryAdd";
	}
	
	/**
	 * ��ת��ͬ���������޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		ILabourServices service = new LabourServicesImpl();
		//��ͬ���
		contractTypeNums = service.queryContractTypeNums();
		contractFiling = service.queryById(recordId);
		return "modifyPage";
	}
	
	/**
	 * ��ͬ���������޸�
	 * @return
	 */
	public String modify()
	{
		ILabourServices service = new LabourServicesImpl();
		service.modify(contractFiling);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		ILabourServices service = new LabourServicesImpl();
		service.delete(recordId);
		return "query";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		ILabourServices service = new LabourServicesImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		ILabourServices service = new LabourServicesImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	/**
	 * �ύ
	 * @return
	 */
	public String sub()
	{
		ILabourServices service = new LabourServicesImpl();
		service.sub(recordId);
		return "query";
	}
	
	/**
	 * ������Ŀ�����б�Ŀ¼
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * ����ҵ�����Ŀ¼
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
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

}
