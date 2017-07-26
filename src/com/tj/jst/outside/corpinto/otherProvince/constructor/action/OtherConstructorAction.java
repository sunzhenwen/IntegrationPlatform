package com.tj.jst.outside.corpinto.otherProvince.constructor.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.constructor.condition.OtherConstructorCondition;
import com.tj.jst.outside.corpinto.otherProvince.constructor.service.IOtherConstructorService;
import com.tj.jst.outside.corpinto.otherProvince.constructor.service.OtherConstructorServiceImpl;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;
import com.webservice.client.constructor.TJWebService;

/**
 * ��ʡע�Ὠ��ʦ
 * @author Administrator
 *
 */
public class OtherConstructorAction extends BaseAction {
	
	//ע�Ὠ��ʦ����
	private String personId;
	//���֤��
	private String idCard;
	//ִҵӡ�º�
	private String stampNum;
	//������ҵ��֯��������
	private String corpCode;
	//ע�Ὠ��ʦ
	private Constructor constructor;
	//ע�Ὠ��ʦlist
	private List<Constructor> constructorList;
	//ѧ��
	private List<DictionaryClass> eduLevelNums;
	//ѧλ
	private List<DictionaryClass> degreeNums;
	//����
	private List<DictionaryClass> nationAlityNums;
	//��ʾ��Ϣ
	private String message;
	//�ж��Ƿ�����ʡ��ҵҳ���ύ,1:��
	private String type;
	//ajax����ֵ
	private String result;
	private List<DictionaryClass> states;//ְҵ�ʸ�״̬(1-8)(�ֵ��TBQSTATEDIC)
	private List<DictionaryClass> regTradeTypeNums; //ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
	private List<DictionaryClass> callingTypeNums;  //������ҵ��ҵ����(�ֵ��TBCALLINGTYPEDIC)
	private List<DictionaryClass> sepecialtyTypNums;//ע�����ͼ��ȼ�(�ֵ��TBSPECIALTYTYPEDIC)
	private List<DictionaryClass> idCardTypeNums; 	//֤������(�ֵ��TBIDCARDTYPEDIC)
	
	private OtherConstructorCondition condition = new OtherConstructorCondition();
	
	public void setCondition(OtherConstructorCondition condition) {
		this.condition = condition;
	}

	public OtherConstructorCondition getCondition() {
		OtherConstructorCondition sessionCondition = (OtherConstructorCondition) get(getActionName());
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
		String corpCode = (String)this.get("cropCode");
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = staffService.pagedQuery(this.getCondition());
		//ѧ��
		eduLevelNums = staffService.eduLevelNums();
		//ѧλ
		degreeNums = staffService.degreeNums();
		
		this.set(getActionName(), condition);
		return "constructorSuccess";
		
	}
	
	/**
	 * ��ϸ
	 * @return
	 */
	public String detailed()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		constructor = staffService.queryDetailed(idCard,corpCode);
		return "detailed";
	}
	
	/**
	 * ͨ���ӿڵ����������
	 */
	public String leadingIn()
	{
		String corpCode = (String)this.get("cropCode");
		String corpName = (String)this.get("userName");
		//�������ݽ��м��
		TJWebService t = new TJWebService();
		String check = t.getTJWebServiceSoap().getSingleCorpRegPerson(corpName, corpCode);
		//����ɹ�
		if("Success".equals(check))
		{
			IOtherConstructorService staffService = new OtherConstructorServiceImpl();
			//���м�����µ���������
			boolean checked = staffService.importData(corpName,corpCode);
			if(checked==true)
			{
				//����ɹ�
				result = "1";
			}else
			{
				//����ʧ��
				result = "-1";
			}
		}else
		{
			//����ʧ��
			result = "-1";
		}
		return "success";
	}
	
	/**
	 * ��ת���ҳ��
	 * @return
	 */
	public String addPage()
	{
		this.queryDictionaryClass();
		return "addPage";
	}

	/**
	 * ��ת����ҳ��
	 * @return
	 */
	public String loadPage()
	{
		return "loadPage";
	}
	
	/**
	 * ���
	 * @return
	 */
	public String add()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		//��ȡ��ҵ����
		constructor.setCorpId((String)this.get("userId"));
		//��ȡ��ҵ����
		constructor.setCorpName((String)this.get("userName"));
		//��ȡ��ҵ��֯��������
		constructor.setCorpCode((String)this.get("cropCode"));
		staffService.add(constructor);
		return "queryPage";
	}
	
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public String queryById()
	{
		this.queryDictionaryClass();
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		constructor = staffService.queryById(personId);
		return "modifyPage";
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public String modify()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		staffService.modify(constructor);
		return "queryPage";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String deletePerson()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		staffService.deletePerson(personId);
		return "queryPage";
	}
	
	/**
	 * ����
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	/**
	 * ��ѯ�ֵ������
	 */
	public void queryDictionaryClass()
	{
		IOtherConstructorService staffService = new OtherConstructorServiceImpl();
		states = staffService.queryStates();//ְҵ�ʸ�״̬(1-8)(�ֵ��TBQSTATEDIC)
		regTradeTypeNums = staffService.queryRegTradeTypeNums(); //ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
		callingTypeNums = staffService.queryCallingTypeNums();  //������ҵ��ҵ����(�ֵ��TBCALLINGTYPEDIC)
		sepecialtyTypNums =staffService.querySepecialtyTypNums();//ע�����ͼ��ȼ�(�ֵ��TBSPECIALTYTYPEDIC)
		idCardTypeNums =staffService.queryIdCardTypeNums(); 	//֤������(�ֵ��TBIDCARDTYPEDIC)
		//ѧ��
		eduLevelNums = staffService.eduLevelNums();
		//ѧλ
		degreeNums = staffService.degreeNums();
		//����
		nationAlityNums = staffService.nationAlityNums();
	}
	
	public Constructor getConstructor() {
		return constructor;
	}

	public void setConstructor(Constructor constructor) {
		this.constructor = constructor;
	}

	public List<Constructor> getConstructorList() {
		return constructorList;
	}

	public void setConstructorList(List<Constructor> constructorList) {
		this.constructorList = constructorList;
	}

	public List<DictionaryClass> getEduLevelNums() {
		return eduLevelNums;
	}

	public void setEduLevelNums(List<DictionaryClass> eduLevelNums) {
		this.eduLevelNums = eduLevelNums;
	}

	public List<DictionaryClass> getDegreeNums() {
		return degreeNums;
	}

	public void setDegreeNums(List<DictionaryClass> degreeNums) {
		this.degreeNums = degreeNums;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getStampNum() {
		return stampNum;
	}

	public void setStampNum(String stampNum) {
		this.stampNum = stampNum;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<DictionaryClass> getStates() {
		return states;
	}

	public void setStates(List<DictionaryClass> states) {
		this.states = states;
	}

	public List<DictionaryClass> getRegTradeTypeNums() {
		return regTradeTypeNums;
	}

	public void setRegTradeTypeNums(List<DictionaryClass> regTradeTypeNums) {
		this.regTradeTypeNums = regTradeTypeNums;
	}

	public List<DictionaryClass> getCallingTypeNums() {
		return callingTypeNums;
	}

	public void setCallingTypeNums(List<DictionaryClass> callingTypeNums) {
		this.callingTypeNums = callingTypeNums;
	}

	public List<DictionaryClass> getSepecialtyTypNums() {
		return sepecialtyTypNums;
	}

	public void setSepecialtyTypNums(List<DictionaryClass> sepecialtyTypNums) {
		this.sepecialtyTypNums = sepecialtyTypNums;
	}

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}

	public List<DictionaryClass> getNationAlityNums() {
		return nationAlityNums;
	}

	public void setNationAlityNums(List<DictionaryClass> nationAlityNums) {
		this.nationAlityNums = nationAlityNums;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
