package com.tj.jst.outside.business.safety.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.safety.condition.SafetyStaffCondition;
import com.tj.jst.outside.business.safety.model.SafetyStaff;
import com.tj.jst.outside.business.safety.service.ISafetyStaffService;
import com.tj.jst.outside.business.safety.service.SafetyStaffServiceImpl;

/**
 * ʩ����ȫ��ҵ��Ա
 * @author hhc
 *
 */
public class SafetyStaffAction extends BaseAction {
	
	//ʩ����ȫ��ҵ��Ա��ϸ����
	private String builderUserId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//ʩ����ȫ��ҵ��Ա��ϸ
	private SafetyStaff safetyStaff;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ����
	private String corpName;
	//֤������
	private List<DictionaryClass> idCardTypeNums;
	
	private SafetyStaffCondition condition = new SafetyStaffCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(SafetyStaffCondition condition) {
		this.condition = condition;
	}

	public SafetyStaffCondition getCondition() {
		SafetyStaffCondition sessionCondition = (SafetyStaffCondition) get(getActionName());
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
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ʩ����ȫ��ҵ��Ա���ҳ��
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//��ҵ��֯��������
		corpCode = login.getCorpCode();
		//��ҵ����
		corpName = login.getUserName();
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		idCardTypeNums = service.queryCardTypeNums();
		return "addPage";
	}
	
	/**
	 * ʩ����ȫ��ҵ��Ա���
	 * @return
	 */
	public String add()
	{
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		service.add(safetyStaff);
		return "query";
	}
	
	/**
	 * ʩ����ȫ��ҵ��Ա�޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		safetyStaff = service.queryById(builderUserId);
		idCardTypeNums = service.queryCardTypeNums();
		return "modifyPage";
	}
	
	/**
	 * ʩ����ȫ��ҵ��Ա�޸�
	 * @return
	 */
	public String modify()
	{
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		service.modify(safetyStaff);
		return "query";
	}
	
	/**
	 * ʩ����ȫ��ҵ��Աɾ��
	 * @return
	 */
	public String delete()
	{
		ISafetyStaffService service = new SafetyStaffServiceImpl();
		service.delete(builderUserId);
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

	public String getBuilderUserId() {
		return builderUserId;
	}

	public void setBuilderUserId(String builderUserId) {
		this.builderUserId = builderUserId;
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

	public SafetyStaff getSafetyStaff() {
		return safetyStaff;
	}

	public void setSafetyStaff(SafetyStaff safetyStaff) {
		this.safetyStaff = safetyStaff;
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

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}
	
}
