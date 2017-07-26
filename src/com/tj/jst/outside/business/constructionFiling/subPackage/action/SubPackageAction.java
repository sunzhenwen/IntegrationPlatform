package com.tj.jst.outside.business.constructionFiling.subPackage.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionFiling.mainContractor.service.ConstructionContractServiceImpl;
import com.tj.jst.outside.business.constructionFiling.mainContractor.service.IConstructionContractService;
import com.tj.jst.outside.business.constructionFiling.subPackage.condition.SubPackageCondition;
import com.tj.jst.outside.business.constructionFiling.subPackage.service.ISubPackageService;
import com.tj.jst.outside.business.constructionFiling.subPackage.service.SubPackageServiceImpl;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * �ְ���ͬ����
 * @author hhc
 *
 */
public class SubPackageAction extends BaseAction {
	
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
	
	private SubPackageCondition condition = new SubPackageCondition();
	
	public void setCondition(SubPackageCondition condition) {
		this.condition = condition;
	}

	public SubPackageCondition getCondition() {
		SubPackageCondition sessionCondition = (SubPackageCondition) get(getActionName());
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
		ISubPackageService service = new SubPackageServiceImpl();
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
		ISubPackageService service = new SubPackageServiceImpl();
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
		ISubPackageService service = new SubPackageServiceImpl();
		recordId = service.add(contractFiling);
		return "queryAdd";
	}
	
	/**
	 * ��ת��ͬ���������޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		ISubPackageService service = new SubPackageServiceImpl();
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
		ISubPackageService service = new SubPackageServiceImpl();
		service.modify(contractFiling);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		ISubPackageService service = new SubPackageServiceImpl();
		service.delete(recordId);
		return "query";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		ISubPackageService service = new SubPackageServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		ISubPackageService service = new SubPackageServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
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
	
	/**
	 * �ύ
	 * @return
	 */
	public String sub()
	{
		ISubPackageService service = new SubPackageServiceImpl();
		service.sub(recordId);
		return "query";
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
