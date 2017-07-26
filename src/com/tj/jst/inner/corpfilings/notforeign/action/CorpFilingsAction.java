package com.tj.jst.inner.corpfilings.notforeign.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.corpfilings.notforeign.condition.CorpFilingsCondition;
import com.tj.jst.inner.corpfilings.notforeign.service.CorpFilingsServiceImpl;
import com.tj.jst.inner.corpfilings.notforeign.service.ICorpFilingsService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ��ҵ����
 * @author Administrator
 *
 */
public class CorpFilingsAction extends BaseAction {
	
	//��ҵ����
	private String corpId;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ
	private Corp corp;
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

	//������ʾ��Ϣ
	private String message;
	private String result;
	
	private CorpFilingsCondition condition = new CorpFilingsCondition(((Login)this.get("login")).getDepartmentID());
	
	public void setCondition(CorpFilingsCondition condition) {
		this.condition = condition;
	}

	public CorpFilingsCondition getCondition() {
		CorpFilingsCondition sessionCondition = (CorpFilingsCondition) get(getActionName());
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
		ICorpFilingsService service = new CorpFilingsServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.queryDictionary();
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
	/**
	 * �����ҳ��
	 * @return
	 */
	public String corpAddPage()
	{
		ICorpFilingsService service = new CorpFilingsServiceImpl();
		this.queryDictionary();
		provinces = service.queryProvince();
		return "corpAddPage";
	}
	
	/**
	 * ����ҵ���
	 * @return
	 */
	public String addCorp()
	{
		ICorpFilingsService service = new CorpFilingsServiceImpl();
		Login login = (Login)this.get("login");
		message = service.queryCorpCode(corp.getCorpCode());
		if (message.equals("�ظ�")){
			this.queryDictionary();
			provinces = service.queryProvince();
			citys = service.queryCity(corp.getProvinceNum());
			areas = service.queryArea(corp.getCityNum());
			message = "�Բ������������֯�ṹ����֤�ظ���";
			return "corpAddPage";
		}else{
			corp.setApplyStaffId(login.getPersonalID());
			corp.setApplyStaffName(login.getName());
			corp.setApplyDept(login.getDepartmentID());
			corp.setApplyDeptName(login.getDepartment());
			service.addCorp(corp);
			return "query";
		}
		
	}
	
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public String modifyCorpPage()
	{
		
		ICorpFilingsService service = new CorpFilingsServiceImpl();
		corp = service.modifyCorpPage(corpId);
		provinces = service.queryProvince();
		this.queryDictionary();
		return "modifyCorpPage";
	}
	
	/**
	 * ��ҵ�޸�
	 * @return
	 */
	public String modifyCorp()
	{
		ICorpFilingsService service = new CorpFilingsServiceImpl();
		service.modifyCorp(corp);
		return "query";
	}
	
	/**
	 * ��ת����ҳ��
	 * @return
	 */
	public String applyCorpPage()
	{
		
		ICorpFilingsService service = new CorpFilingsServiceImpl();
		corp = service.applyCorpPage(corpId);
		provinces = service.queryProvince();
		citys = service.queryCity(corp.getProvinceNum());
		areas = service.queryArea(corp.getCityNum());
		this.queryDictionary();
		return "applyCorpPage";
	}

	/**
	 * ����ͨ��
	 * @return
	 */
	public String applythrough()
	{
		
		ICorpFilingsService service = new CorpFilingsServiceImpl();
		Login login = (Login)this.get("login");
		corp.setApplyStaffId(login.getPersonalID());
		corp.setApplyStaffName(login.getName());
		corp.setApplyDept(login.getDepartmentID());
		corp.setApplyDeptName(login.getDepartment());
		service.applythrough(corp);
		return "query";
	}
	
	/**
	 * ����δͨ��
	 * @return
	 */
	public String applyThroughBack()
	{
		
		ICorpFilingsService service = new CorpFilingsServiceImpl();
		Login login = (Login)this.get("login");
		corp.setApplyStaffId(login.getPersonalID());
		corp.setApplyStaffName(login.getName());
		corp.setApplyDept(login.getDepartmentID());
		corp.setApplyDeptName(login.getDepartment());
		service.applyThroughBack(corp);
		return "query";
	}
	
	
	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryCity()
    {
		ICorpFilingsService service = new CorpFilingsServiceImpl();
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
		ICorpFilingsService service = new CorpFilingsServiceImpl();
		areas = service.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ȡ��
	 * @return
	 */
	public String goBack()
	{
		return "query";
	}
	
	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<DictionaryClass> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<DictionaryClass> provinces) {
		this.provinces = provinces;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public List<DictionaryClass> getCitys() {
		return citys;
	}

	public void setCitys(List<DictionaryClass> citys) {
		this.citys = citys;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public List<DictionaryClass> getAreas() {
		return areas;
	}

	public void setAreas(List<DictionaryClass> areas) {
		this.areas = areas;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

}
