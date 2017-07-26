package com.tj.jst.outside.business.complete.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.complete.condition.CompleteCondition;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.complete.service.CompleteServiceImpl;
import com.tj.jst.outside.business.complete.service.ICompleteService;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * ��������
 * @author hhc
 *
 */
public class CompleteAction extends BaseAction {
	
	//������������
	private String completeId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//��������
	private Complete complete;
	//�ṹ��ϵ
	private List<DictionaryClass> prjStructureTypeNums;
	//��������
	private List<Regional> list;
	//������ʾ��Ϣ
	private String message;
	private String result;
	private String treeStr;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ����
	private String corpName;
	
	private CompleteCondition condition = new CompleteCondition();
	
	public void setCondition(CompleteCondition condition) {
		this.condition = condition;
	}

	public CompleteCondition getCondition() {
		CompleteCondition sessionCondition = (CompleteCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		ICompleteService service = new CompleteServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ������������ҳ��
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//��ҵ��֯��������
		corpCode = login.getCorpCode();
		//��ҵ����
		corpName = login.getUserName();
		ICompleteService service = new CompleteServiceImpl();
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		return "addPage";
	}
	
	/**
	 * ������������
	 * @return
	 */
	public String add()
	{
		ICompleteService service = new CompleteServiceImpl();
		completeId = service.add(complete);
		return "queryAdd";
	}
	
	/**
	 * ��ת�������������޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		ICompleteService service = new CompleteServiceImpl();
		prjStructureTypeNums = service.queryPrjStructureTypeNums();
		complete = service.queryById(completeId);
		return "modifyPage";
	}
	
	/**
	 * �������������޸�
	 * @return
	 */
	public String modify()
	{
		ICompleteService service = new CompleteServiceImpl();
		service.modify(complete);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		ICompleteService service = new CompleteServiceImpl();
		service.delete(completeId);
		return "query";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		ICompleteService service = new CompleteServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		ICompleteService service = new CompleteServiceImpl();
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

	public String getCompleteId() {
		return completeId;
	}

	public void setCompleteId(String completeId) {
		this.completeId = completeId;
	}

	public Complete getComplete() {
		return complete;
	}

	public void setComplete(Complete complete) {
		this.complete = complete;
	}

	public List<DictionaryClass> getPrjStructureTypeNums() {
		return prjStructureTypeNums;
	}

	public void setPrjStructureTypeNums(List<DictionaryClass> prjStructureTypeNums) {
		this.prjStructureTypeNums = prjStructureTypeNums;
	}

}
