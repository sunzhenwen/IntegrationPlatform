package com.tj.jst.inner.constrModify.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.constrModify.condition.ConstrModifyCondition;
import com.tj.jst.inner.constrModify.service.ConstrModifyServiceImpl;
import com.tj.jst.inner.constrModify.service.IConstrModifyService;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.service.ConstructionServiceImpl;
import com.tj.jst.outside.business.construction.service.IConstructionService;

/**
 * ��Ŀ�����޸�,���ܲ����޸�
 * 
 * @author hhc
 *
 */
public class ConstrModifyAction extends BaseAction {
	// Model��
	private ProjectConstruction project;
	// ��Ŀ����
	private String prjName;
	// �����ĺ�
	private String prjApprovalNum;
	// ���赥λ����
	private String buildCorpName;
	// ���赥λ��֯��������֤
	private String buildCorpCode;
	// ����
	private String prjId;
	// ������ʾ��Ϣ
	private String message;
	// ��������
	private String[] ids;
	// ��Ŀ����
	private String prjNum;

	
	
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
	//��Ŀ����(�ֵ��TBPRJTYPEDIC)
	private List<DictionaryClass> prjTypeNums; 
	//��������(�ֵ��TBPRJPROPERTYDIC)
	private List<DictionaryClass> prjPropertyNums; 
	//������;(�ֵ��TBPRJFUNCTIONDIC)
	private List<DictionaryClass> prjFuncitonNums; 
	//�����(�ֵ��TBLXJBDIC)
	private List<DictionaryClass> prjApprovalLevelNums; 
	private String result;
	
	private ConstrModifyCondition condition = new ConstrModifyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(ConstrModifyCondition condition) {
		this.condition = condition;
	}

	public ConstrModifyCondition getCondition() {
		ConstrModifyCondition sessionCondition = (ConstrModifyCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * �б��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		IConstrModifyService service = new ConstrModifyServiceImpl();
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת�޸�ҳ��
	 * 
	 * @return
	 */
	public String queryById() {
		IConstrModifyService service = new ConstrModifyServiceImpl();
		project = service.queryById(prjId);
		
		IConstructionService serviceImpl = new ConstructionServiceImpl();
		//��ѯʡ
		provinces = serviceImpl.queryProvince();
		prjTypeNums = serviceImpl.queryPrjTypeNums();
		//��������(�ֵ��TBPRJPROPERTYDIC)
		prjPropertyNums = serviceImpl.queryPrjPropertyNums(); 
		//������;(�ֵ��TBPRJFUNCTIONDIC)
		prjFuncitonNums = serviceImpl.queryPrjFuncitonNums();
		//�����(�ֵ��TBLXJBDIC)
		prjApprovalLevelNums = serviceImpl.queryPrjApprovalLevelNums();
		
		return "queryById";
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public String update()
	{
		IConstrModifyService service = new ConstrModifyServiceImpl();
		service.update(project);
		return "query";
	}
	
	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryCity()
    {
		IConstructionService corpService = new ConstructionServiceImpl();
		citys = corpService.queryCity(provinceId);
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
		IConstructionService corpService = new ConstructionServiceImpl();
		areas = corpService.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public ProjectConstruction getProject() {
		return project;
	}

	public void setProject(ProjectConstruction project) {
		this.project = project;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjApprovalNum() {
		return prjApprovalNum;
	}

	public void setPrjApprovalNum(String prjApprovalNum) {
		this.prjApprovalNum = prjApprovalNum;
	}

	public String getBuildCorpName() {
		return buildCorpName;
	}

	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}

	public String getBuildCorpCode() {
		return buildCorpCode;
	}

	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
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

	public List<DictionaryClass> getPrjTypeNums() {
		return prjTypeNums;
	}

	public void setPrjTypeNums(List<DictionaryClass> prjTypeNums) {
		this.prjTypeNums = prjTypeNums;
	}

	public List<DictionaryClass> getPrjPropertyNums() {
		return prjPropertyNums;
	}

	public void setPrjPropertyNums(List<DictionaryClass> prjPropertyNums) {
		this.prjPropertyNums = prjPropertyNums;
	}

	public List<DictionaryClass> getPrjFuncitonNums() {
		return prjFuncitonNums;
	}

	public void setPrjFuncitonNums(List<DictionaryClass> prjFuncitonNums) {
		this.prjFuncitonNums = prjFuncitonNums;
	}

	public List<DictionaryClass> getPrjApprovalLevelNums() {
		return prjApprovalLevelNums;
	}

	public void setPrjApprovalLevelNums(List<DictionaryClass> prjApprovalLevelNums) {
		this.prjApprovalLevelNums = prjApprovalLevelNums;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
