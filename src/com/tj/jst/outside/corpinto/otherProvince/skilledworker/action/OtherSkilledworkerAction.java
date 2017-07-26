package com.tj.jst.outside.corpinto.otherProvince.skilledworker.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.otherProvince.skilledworker.condition.OtherSkilledworkerCondition;
import com.tj.jst.outside.corpinto.otherProvince.skilledworker.service.IOtherSkilledworkerService;
import com.tj.jst.outside.corpinto.otherProvince.skilledworker.service.OtherSkilledworkerServiceImpl;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;

/**
 * ��ʡע�Ἴ��������Ա
 * 
 * @author DarkFlameMaster
 *
 */
public class OtherSkilledworkerAction extends BaseAction {

	// ע�Ἴ������
	private Skilledworker skilledworker;
	// ��������LIst
	private List<Skilledworker> skilledworkerList;
	// ������������
	private List<DictionaryClass> typedNums;
	// �������ּ���
	private List<DictionaryClass> levelNums;
	// ������ʾ��Ϣ
	private String message;
	// ע��֤�����
	private List<DictionaryClass> idCardTypeName;
	// �Ա����
	private List<DictionaryClass> sexName;
	// �������
	private List<DictionaryClass> nationalName;
	// ѧλ���
	private List<DictionaryClass> degreeName;
	// ѧ�����
	private List<DictionaryClass> eduLevelName;
	// ��Ա����
	private String personId;

	private OtherSkilledworkerCondition condition = new OtherSkilledworkerCondition();

	public void setCondition(OtherSkilledworkerCondition condition) {
		this.condition = condition;
	}

	public OtherSkilledworkerCondition getCondition() {
		OtherSkilledworkerCondition sessionCondition = (OtherSkilledworkerCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ѯ���еļ�����Ա������Ϣ
	 * 
	 * @return
	 */
	public String queryPage() {

		IOtherSkilledworkerService staffService = new OtherSkilledworkerServiceImpl();
		String corpId = (String)this.get("userId");
		this.getCondition().setCorpId(corpId);
		// ��ҳ��ѯ
		currentPage = staffService.pagedQuery(this.getCondition());
		// �������Ͳ�ѯ
		typedNums = staffService.skilledTypeNums();
		// ���������ѯ
		//levelNums = staffService.skilledLevelNums();
		this.set(getActionName(), condition);
		return "skillworkerSuccess";

	}

	/**
	 * ��ת��������Ա��Ϣ�޸Ľ���
	 * 
	 * @return
	 */
	public String modifiedPage() {
		IOtherSkilledworkerService staffService = new OtherSkilledworkerServiceImpl();
		this.queryDictionary();
		skilledworker = staffService.queryById(personId);
		return "modifyPage";
	}

	/**
	 * ������Ա��Ϣ�޸�
	 * 
	 * @return
	 */
	public String modified() {
		IOtherSkilledworkerService staffService = new OtherSkilledworkerServiceImpl();
		message = staffService.modifyPersonInfo(skilledworker);
		this.queryDictionary();
		if(!message.equals("�޸ĳɹ���")){
			message = "��֤�������Ѿ���" + message + "ʹ�ã��޷��ظ����ӣ���˶ԣ�";
			return "modifyPage";
		}else{
			message = "�޸ĳɹ���";
			return "queryPage";
		}
		
	}

	/**
	 * ������Ա��Ϣ����ҳ��
	 * 
	 * @return
	 */
	public String createdPage() {
		this.queryDictionary();
		return "addPage";
	}

	/**
	 * ������Ա��Ϣ����
	 * 
	 * @return
	 */
	public String created() {
		IOtherSkilledworkerService staffService = new OtherSkilledworkerServiceImpl();
		Login login = (Login) this.get("login");
		this.getSkilledworker().setCorpCode(login.getCorpCode());
		this.getSkilledworker().setUserId(login.getUserId());
		this.getSkilledworker().setCorpName(login.getUserName());
		this.queryDictionary();
		message = staffService.addPersonInfo(skilledworker);
		if(!message.equals("������Ա�ɹ���")){
			message = "��֤�������Ѿ���" + message + "ʹ�ã��޷��ظ����ӣ���˶ԣ�";
			return "addPage";
		}else{
			message = "���ӳɹ���";
			return "queryPage";
		}
		
	}

	/**
	 * ����ҵ���������
	 * 
	 * @return
	 */
	public String goBack() {
		return "goBusiness";
	}

	/**
	 * ���ؼ�����Ա�б�����
	 * 
	 * @return
	 */
	public String goList() {
		return "queryPage";
	}

	/**
	 * ������Ա��Ϣɾ��
	 * 
	 * @return
	 */
	public String delete() {
		IOtherSkilledworkerService staffService = new OtherSkilledworkerServiceImpl();
		message = staffService.delete(personId);
		return "queryPage";
	}

	/**
	 * ��ѯ�ֵ��
	 * 
	 * @return
	 */
	public void queryDictionary() {

		IOtherSkilledworkerService staffService = new OtherSkilledworkerServiceImpl();
		// ֤������
		//idCardTypeName = staffService.idCardTypeNums();
		// �Ա�
		//sexName = staffService.sexNums();
		// ������Ա����
		//levelNums = staffService.skilledLevelNums();
		// ������Ա����
		typedNums = staffService.skilledTypeNums();
		// ����
		//nationalName = staffService.nationalNums();
		// ѧλ
		//degreeName = staffService.degreeNums();
		// ѧ��
		//eduLevelName = staffService.eduLevelNums();
	}

	public Skilledworker getSkilledworker() {
		return skilledworker;
	}

	public void setSkilledworker(Skilledworker skilledworker) {
		this.skilledworker = skilledworker;
	}

	public List<Skilledworker> getSkilledworkerList() {
		return skilledworkerList;
	}

	public void setSkilledworkerList(List<Skilledworker> skilledworkerList) {
		this.skilledworkerList = skilledworkerList;
	}

	public List<DictionaryClass> getTypedNums() {
		return typedNums;
	}

	public void setTypedNums(List<DictionaryClass> typedNums) {
		this.typedNums = typedNums;
	}

	public List<DictionaryClass> getLevelNums() {
		return levelNums;
	}

	public void setLevelNums(List<DictionaryClass> levelNums) {
		this.levelNums = levelNums;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DictionaryClass> getIdCardTypeName() {
		return idCardTypeName;
	}

	public void setIdCardTypeName(List<DictionaryClass> idCardTypeName) {
		this.idCardTypeName = idCardTypeName;
	}

	public List<DictionaryClass> getSexName() {
		return sexName;
	}

	public void setSexName(List<DictionaryClass> sexName) {
		this.sexName = sexName;
	}

	public List<DictionaryClass> getNationalName() {
		return nationalName;
	}

	public void setNationalName(List<DictionaryClass> nationalName) {
		this.nationalName = nationalName;
	}

	public List<DictionaryClass> getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(List<DictionaryClass> degreeName) {
		this.degreeName = degreeName;
	}

	public List<DictionaryClass> getEduLevelName() {
		return eduLevelName;
	}

	public void setEduLevelName(List<DictionaryClass> eduLevelName) {
		this.eduLevelName = eduLevelName;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
}