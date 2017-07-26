package com.tj.jst.inner.integrity.personBadIntegrity.action;

import java.sql.Date;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personBadIntegrity.condition.PersonBadIntegrityCondition;
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;
import com.tj.jst.inner.integrity.personBadIntegrity.service.IPersonBadIntegrityService;
import com.tj.jst.inner.integrity.personBadIntegrity.service.PersonBadIntegrityServiceImpl;
import com.tj.jst.login.model.Login;

/**
 * ע����Ա������Ϊ��Ϣ���ݱ�
 * @author hhc
 *
 */
public class PersonBadIntegrityAction extends BaseAction {
	
	//ע����Ա������Ϊ��ϢModel
	private PersonBadIntegrity personBadIntegrity;
	//����
	private String badPersonId;
	//ʡcode
	private String provinceId;
	//��code
	private String cityNum;
	//ʡ
	private List<DictionaryClass> provinces;
	//��
	private List<DictionaryClass> citys;
	//��
	private List<DictionaryClass> areas;
	
	
	//��Ա����(TBSPECIALTYTYPEDIC)
	private List<DictionaryClass> specialtyTypNums;
	//������Ϊ����(TBCREDITTYPE)
	private List<DictionaryClass> creditClassNums;
	//������Ϊ���(TBCORPBADDIC)
	private List<DictionaryClass> creditType;
	//������Ϊ����(TBCORPBADDIC)
	private List<DictionaryClass> creditCodes;
	//��������(TBCORPBADDIC)
	private List<DictionaryClass> puishEvidences;
	//֤������(�ֵ��TBIDCARDTYPEDIC)
	private List<DictionaryClass> idCardTypeNums;
	
	private String departId;//�Ǽǲ���Id
	private String departName;//�Ǽǲ���
	private String userName;//�Ǽ�������
	private Date createDate;//�Ǽ�ʱ��
	
	private String result;
	private PersonBadIntegrityCondition condition = new PersonBadIntegrityCondition(((Login)this.get("login")).getDepartmentID());
	
	public void setCondition(PersonBadIntegrityCondition condition) {
		this.condition = condition;
	}

	public PersonBadIntegrityCondition getCondition() {
		PersonBadIntegrityCondition sessionCondition = (PersonBadIntegrityCondition) get(getActionName());
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
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		condition.setPersonalID("1");
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	public String queryInfoPage(){
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ���ҳ��
	 * @return
	 */
	public String addPage()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		Login login = (Login)this.get("login");
		departId = login.getDepartmentID();//�Ǽǲ���Id
		departName= login.getDepartment();//�Ǽǲ���
		userName = login.getName();//�Ǽ�������
		createDate = new Date(new java.util.Date().getTime());
		this.queryBadIntegrityDictionary();
		provinces = service.queryProvince();
		return "addPage";
	}
	
	/**
	 * ���
	 * @return
	 */
	public String add()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		service.add(personBadIntegrity);
		return "query";
	}
	
	/**
	 * ���޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		personBadIntegrity = service.queryById(badPersonId);
		provinces = service.queryProvince();
		this.queryBadIntegrityDictionary();
		return "modifyPage";
	}

	/**
	 * �޸�
	 * @return
	 */
	public String modify()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		service.modify(personBadIntegrity);
		return "query";
	}
	
	public String detail(){
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		personBadIntegrity = service.queryById(badPersonId);
		provinces = service.queryProvince();
		this.queryBadIntegrityDictionary();
		return "detailPage";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		service.delete(badPersonId);
		return "query";
	}
	
	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryCity()
    {
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		citys = service.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryArea()
    {
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		areas = service.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ��ѯ�ֵ��
	 */
	public void queryBadIntegrityDictionary()
	{
		IPersonBadIntegrityService service = new PersonBadIntegrityServiceImpl();
		//��Ա����(TBSPECIALTYTYPEDIC)
		specialtyTypNums = service.querySpecialtyTypNums();
		//������Ϊ����(TBCREDITTYPE)
		creditClassNums = service.queryCreditClassNums();
		//������Ϊ���(TBCORPBADDIC)
		creditType = service.queryCreditType();
		//������Ϊ����(TBCORPBADDIC)
		creditCodes = service.queryCreditCodes();
		//��������(TBCORPBADDIC)
		puishEvidences = service.queryPuishEvidences();
		//֤������(�ֵ��TBIDCARDTYPEDIC)
		idCardTypeNums = service.queryIdCardTypeNums();
	}

	/**
	 * ȡ��
	 * @return
	 */
	public String goBack()
	{
		return "query";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public List<DictionaryClass> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<DictionaryClass> provinces) {
		this.provinces = provinces;
	}

	public List<DictionaryClass> getCitys() {
		return citys;
	}

	public void setCitys(List<DictionaryClass> citys) {
		this.citys = citys;
	}

	public List<DictionaryClass> getAreas() {
		return areas;
	}

	public void setAreas(List<DictionaryClass> areas) {
		this.areas = areas;
	}

	public PersonBadIntegrity getPersonBadIntegrity() {
		return personBadIntegrity;
	}

	public void setPersonBadIntegrity(PersonBadIntegrity personBadIntegrity) {
		this.personBadIntegrity = personBadIntegrity;
	}

	public List<DictionaryClass> getSpecialtyTypNums() {
		return specialtyTypNums;
	}

	public void setSpecialtyTypNums(List<DictionaryClass> specialtyTypNums) {
		this.specialtyTypNums = specialtyTypNums;
	}

	public List<DictionaryClass> getCreditClassNums() {
		return creditClassNums;
	}

	public void setCreditClassNums(List<DictionaryClass> creditClassNums) {
		this.creditClassNums = creditClassNums;
	}

	public List<DictionaryClass> getCreditType() {
		return creditType;
	}

	public void setCreditType(List<DictionaryClass> creditType) {
		this.creditType = creditType;
	}

	public List<DictionaryClass> getCreditCodes() {
		return creditCodes;
	}

	public void setCreditCodes(List<DictionaryClass> creditCodes) {
		this.creditCodes = creditCodes;
	}

	public List<DictionaryClass> getPuishEvidences() {
		return puishEvidences;
	}

	public void setPuishEvidences(List<DictionaryClass> puishEvidences) {
		this.puishEvidences = puishEvidences;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getBadPersonId() {
		return badPersonId;
	}

	public void setBadPersonId(String badPersonId) {
		this.badPersonId = badPersonId;
	}

	public List<DictionaryClass> getIdCardTypeNums() {
		return idCardTypeNums;
	}

	public void setIdCardTypeNums(List<DictionaryClass> idCardTypeNums) {
		this.idCardTypeNums = idCardTypeNums;
	}

}
