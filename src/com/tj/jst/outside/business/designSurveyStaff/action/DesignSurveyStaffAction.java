package com.tj.jst.outside.business.designSurveyStaff.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.designSurveyStaff.condition.DesignSurveyStaffCondition;
import com.tj.jst.outside.business.designSurveyStaff.model.DesignSurveyStaff;
import com.tj.jst.outside.business.designSurveyStaff.service.DesignSurveyStaffServiceImpl;
import com.tj.jst.outside.business.designSurveyStaff.service.IDesignSurveyStaffService;

/**
 * ���������ͼ��Ա
 * @author hhc
 *
 */
public class DesignSurveyStaffAction extends BaseAction {
	
	//����
	private String dsId;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//���������ͼ��Ա
	private DesignSurveyStaff dsStaff;
//	//��ҵ��֯��������
//	private String corpCode;
//	//��ҵ����
//	private String corpName;
	//������λ��֯��������
	private String conCorpCode;
	//���쵥λ��ҵ����
	private String conCorpName;
	//֤������
	private List<DictionaryClass> idCardTypeNums;
	//ע�����ͼ��ȼ�
	private List<DictionaryClass> specialtyTypNums;
	//�е���ɫ
	private List<DictionaryClass> prjDutys;
	
	private DesignSurveyStaffCondition condition = new DesignSurveyStaffCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(DesignSurveyStaffCondition condition) {
		this.condition = condition;
	}

	public DesignSurveyStaffCondition getCondition() {
		DesignSurveyStaffCondition sessionCondition = (DesignSurveyStaffCondition) get(getActionName());
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
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
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
		//������ҵ��֯��������
		conCorpCode = login.getCorpCode();
		//������ҵ����
		conCorpName = login.getUserName();
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		//֤������
		idCardTypeNums = service.queryCardTypeNums();
		//ע�����ͼ��ȼ�
		specialtyTypNums = service.querySpecialtyTypNums();
		//�е���ɫ
		prjDutys = service.queryPrjDutys();
		return "addPage";
	}
	
	/**
	 * ʩ����ȫ��ҵ��Ա���
	 * @return
	 */
	public String add()
	{
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		service.add(dsStaff);
		return "query";
	}
	
	/**
	 * ʩ����ȫ��ҵ��Ա�޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		dsStaff = service.queryById(dsId);
		//֤������
		idCardTypeNums = service.queryCardTypeNums();
		//ע�����ͼ��ȼ�
		specialtyTypNums = service.querySpecialtyTypNums();
		//�е���ɫ
		prjDutys = service.queryPrjDutys();
		return "modifyPage";
	}
	
	/**
	 * ʩ����ȫ��ҵ��Ա�޸�
	 * @return
	 */
	public String modify()
	{
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		service.modify(dsStaff);
		return "query";
	}
	
	/**
	 * ʩ����ȫ��ҵ��Աɾ��
	 * @return
	 */
	public String delete()
	{
		IDesignSurveyStaffService service = new DesignSurveyStaffServiceImpl();
		service.delete(dsId);
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

	public String getDsId() {
		return dsId;
	}

	public void setDsId(String dsId) {
		this.dsId = dsId;
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

	public DesignSurveyStaff getDsStaff() {
		return dsStaff;
	}

	public void setDsStaff(DesignSurveyStaff dsStaff) {
		this.dsStaff = dsStaff;
	}

//	public String getCorpCode() {
//		return corpCode;
//	}
//
//	public void setCorpCode(String corpCode) {
//		this.corpCode = corpCode;
//	}
//
//	public String getCorpName() {
//		return corpName;
//	}
//
//	public void setCorpName(String corpName) {
//		this.corpName = corpName;
//	}

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}

	public List<DictionaryClass> getSpecialtyTypNums() {
		return specialtyTypNums;
	}

	public void setSpecialtyTypNums(List<DictionaryClass> specialtyTypNums) {
		this.specialtyTypNums = specialtyTypNums;
	}

	public List<DictionaryClass> getPrjDutys() {
		return prjDutys;
	}

	public void setPrjDutys(List<DictionaryClass> prjDutys) {
		this.prjDutys = prjDutys;
	}

	public String getConCorpCode() {
		return conCorpCode;
	}

	public void setConCorpCode(String conCorpCode) {
		this.conCorpCode = conCorpCode;
	}

	public String getConCorpName() {
		return conCorpName;
	}

	public void setConCorpName(String conCorpName) {
		this.conCorpName = conCorpName;
	}
	
}
