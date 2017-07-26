package com.tj.jst.outside.business.safety.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.safety.condition.SafetyCondition;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.safety.service.ISafetyService;
import com.tj.jst.outside.business.safety.service.SafetyServiceImpl;

/**
 * ��ȫ�ල
 * @author hhc
 *
 */
public class SafetyAction extends BaseAction {
	
	//��ȫ�ල����
	private String safetyId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//��ȫ�ල
	private Safety safety;
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
	//�칫�绰
	private String officePhone;
	//��������
	private List<DictionaryClass> projectTypes;
	//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
	private List<ConstructionSafety> constructionSafety; 
	//רҵ�ְ���λ
	private List<Major> majors; 
	//����ְ�
	private List<Labour> labours; 
	private SafetyCondition condition = new SafetyCondition();
	
	public void setCondition(SafetyCondition condition) {
		this.condition = condition;
	}

	public SafetyCondition getCondition() {
		SafetyCondition sessionCondition = (SafetyCondition) get(getActionName());
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
		ISafetyService service = new SafetyServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ȫ�ල����ҳ��
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//��ҵ��֯��������
		corpCode = login.getCorpCode();
		//��ҵ����
		corpName = login.getUserName();
		//�칫�绰
		officePhone = login.getOfficePhone();
		ISafetyService service = new SafetyServiceImpl();
		//��������
		projectTypes = service.queryProjectTypes();
		return "addPage";
	}
	
	/**
	 * ��ȫ�ල����
	 * @return
	 */
	public String add()
	{
		ISafetyService service = new SafetyServiceImpl();
		safetyId = service.add(safety,constructionSafety,majors,labours);
		return "queryAdd";
	}
	
	/**
	 * ��ת��ȫ�ල�����޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		ISafetyService service = new SafetyServiceImpl();
		safety = service.queryById(safetyId);
		//��������
		projectTypes = service.queryProjectTypes();
		return "modifyPage";
	}
	
	/**
	 * ��ȫ�ල�����޸�
	 * @return
	 */
	public String modify()
	{
		ISafetyService service = new SafetyServiceImpl();
		service.modify(safety,constructionSafety,majors,labours);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		ISafetyService service = new SafetyServiceImpl();
		service.delete(safetyId);
		return "query";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		ISafetyService service = new SafetyServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
	}
	
	public String queryPrjName()
	{
		ISafetyService service = new SafetyServiceImpl();
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

	public String getSafetyId() {
		return safetyId;
	}

	public void setSafetyId(String safetyId) {
		this.safetyId = safetyId;
	}

	public Safety getSafety() {
		return safety;
	}

	public void setSafety(Safety safety) {
		this.safety = safety;
	}

	public List<DictionaryClass> getProjectTypes() {
		return projectTypes;
	}

	public void setProjectTypes(List<DictionaryClass> projectTypes) {
		this.projectTypes = projectTypes;
	}

	public List<ConstructionSafety> getConstructionSafety() {
		return constructionSafety;
	}

	public void setConstructionSafety(List<ConstructionSafety> constructionSafety) {
		this.constructionSafety = constructionSafety;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public List<Labour> getLabours() {
		return labours;
	}

	public void setLabours(List<Labour> labours) {
		this.labours = labours;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

}
