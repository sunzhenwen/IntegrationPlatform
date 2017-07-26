package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.action;

import java.sql.Date;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.condition.CorpBadIntegrityCondition;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.CorpBadIntegrityServiceImpl;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.ICorpBadIntegrityService;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.condition.CorpBadIntegrityShareCondition;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service.CorpBadIntegrityShareServiceImpl;
import com.tj.jst.inner.integrityShare.corpBadIntegrityShare.service.ICorpBadIntegrityShareService;
import com.tj.jst.login.model.Login;

/**
 * ��ҵ������Ϊ����
 * @author hhc
 *
 */
public class CorpBadIntegrityShareAction extends BaseAction {
	
	//��ҵ������Ϊ����Model
	private CorpBadIntegrity corpBadIntegrity;
	//����
	private String corpBadCreditId;
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
	
	
	//��ҵ����(TBAPTITUDEKINDDIC)
	private List<DictionaryClass> certTypeNums;
	//������Ϊ����(TBCREDITTYPE)
	private List<DictionaryClass> creditClassNums;
	
	private String departId;//�Ǽǲ���Id
	private String departName;//�Ǽǲ���
	private String userName;//�Ǽ�������
	private Date createDate;//�Ǽ�ʱ��
	
	private String result;
	private CorpBadIntegrityShareCondition condition = new CorpBadIntegrityShareCondition(((Login)this.get("login")).getDepartmentID());
	
	public void setCondition(CorpBadIntegrityShareCondition condition) {
		this.condition = condition;
	}

	public CorpBadIntegrityShareCondition getCondition() {
		CorpBadIntegrityShareCondition sessionCondition = (CorpBadIntegrityShareCondition) get(getActionName());
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
		ICorpBadIntegrityShareService service = new CorpBadIntegrityShareServiceImpl();
		condition.setPersonalID("1");
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	public String queryInfoPage(){
		ICorpBadIntegrityShareService service = new CorpBadIntegrityShareServiceImpl();
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		service.add(corpBadIntegrity);
		return "query";
	}
	
	/**
	 * ���޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		corpBadIntegrity = service.queryById(corpBadCreditId);
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		service.modify(corpBadIntegrity);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		service.delete(corpBadCreditId);
		return "query";
	}
	
	/**
	 * ��ϸ
	 * @return
	 */
	public String detail(){
		ICorpBadIntegrityShareService service = new CorpBadIntegrityShareServiceImpl();
		corpBadIntegrity = service.queryById(corpBadCreditId);
		provinces = service.queryProvince();
		this.queryBadIntegrityDictionary();
		return "detailPage";
	}
	
	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryCity()
    {
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
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
		ICorpBadIntegrityService service = new CorpBadIntegrityServiceImpl();
		//��ҵ����(TBAPTITUDEKINDDIC)
		certTypeNums = service.queryCertTypeNums();
		//������Ϊ����(TBCREDITTYPE)
		creditClassNums = service.queryCreditClassNums();
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

	public CorpBadIntegrity getCorpBadIntegrity() {
		return corpBadIntegrity;
	}

	public void setCorpBadIntegrity(CorpBadIntegrity corpBadIntegrity) {
		this.corpBadIntegrity = corpBadIntegrity;
	}

	public List<DictionaryClass> getCertTypeNums() {
		return certTypeNums;
	}

	public void setCertTypeNums(List<DictionaryClass> certTypeNums) {
		this.certTypeNums = certTypeNums;
	}

	public List<DictionaryClass> getCreditClassNums() {
		return creditClassNums;
	}

	public void setCreditClassNums(List<DictionaryClass> creditClassNums) {
		this.creditClassNums = creditClassNums;
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

	public String getCorpBadCreditId() {
		return corpBadCreditId;
	}

	public void setCorpBadCreditId(String corpBadCreditId) {
		this.corpBadCreditId = corpBadCreditId;
	}
}
