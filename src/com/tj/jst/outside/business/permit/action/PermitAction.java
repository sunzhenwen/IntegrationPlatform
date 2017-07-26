package com.tj.jst.outside.business.permit.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.condition.PermitCondition;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.permit.service.IPermitService;
import com.tj.jst.outside.business.permit.service.PermitServiceImpl;

/**
 * ʩ�����
 * @author hhc
 *
 */
public class PermitAction extends BaseAction {
	
	//ʩ���������
	private String permitId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//ʩ�����
	private Permit permit;
	//֤������
	private List<DictionaryClass> cardTypeNums;
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
	
	private PermitCondition condition = new PermitCondition();
	
	public void setCondition(PermitCondition condition) {
		this.condition = condition;
	}

	public PermitCondition getCondition() {
		PermitCondition sessionCondition = (PermitCondition) get(getActionName());
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
		IPermitService service = new PermitServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ʩ���������ҳ��
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//��ҵ��֯��������
		corpCode = login.getCorpCode();
		//��ҵ����
		corpName = login.getUserName();
		IPermitService service = new PermitServiceImpl();
		cardTypeNums = service.queryCardTypeNums();
		return "addPage";
	}
	
	/**
	 * ʩ���������
	 * @return
	 */
	public String add()
	{
		IPermitService service = new PermitServiceImpl();
		permitId = service.add(permit);
		return "queryAdd";
	}
	
	/**
	 * ��תʩ����������޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IPermitService service = new PermitServiceImpl();
		cardTypeNums = service.queryCardTypeNums();
		permit = service.queryById(permitId);
		return "modifyPage";
	}
	
	/**
	 * ʩ����������޸�
	 * @return
	 */
	public String modify()
	{
		IPermitService service = new PermitServiceImpl();
		service.modify(permit);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		IPermitService service = new PermitServiceImpl();
		service.delete(permitId);
		return "query";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		IPermitService service = new PermitServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		IPermitService service = new PermitServiceImpl();
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

	public String getPermitId() {
		return permitId;
	}

	public void setPermitId(String permitId) {
		this.permitId = permitId;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

	public List<DictionaryClass> getCardTypeNums() {
		return cardTypeNums;
	}

	public void setCardTypeNums(List<DictionaryClass> cardTypeNums) {
		this.cardTypeNums = cardTypeNums;
	}

}
