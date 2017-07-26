package com.tj.jst.outside.business.construction.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.condition.ConstructionCondition;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.construction.service.ConstructionServiceImpl;
import com.tj.jst.outside.business.construction.service.IConstructionService;

/**
 * ��Ŀ����
 * @author hhc
 *
 */
public class ConstructionAction extends BaseAction {
	
	//��Ŀ����ʵ������
	private String prjId;
	//��Ŀ����ʵ����
	private Construction construction;

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
	//�ӱ�����
	private String id;
	
	private ConstructionCondition condition = new ConstructionCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(ConstructionCondition condition) {
		this.condition = condition;
	}

	public ConstructionCondition getCondition() {
		ConstructionCondition sessionCondition = (ConstructionCondition) get(getActionName());
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
		IConstructionService service = new ConstructionServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		prjTypeNums = service.queryPrjTypeNums();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת��ӱ���ҳ��
	 * @return
	 */
	public String addPage()
	{
		Login login = (Login)this.get("login");
		//��ҵ��֯��������
		corpCode = login.getCorpCode();
		//��ҵ����
		corpName = login.getUserName();
		IConstructionService service = new ConstructionServiceImpl();
		provinces = service.queryProvince();
		prjTypeNums = service.queryPrjTypeNums();
		//��������(�ֵ��TBPRJPROPERTYDIC)
		prjPropertyNums = service.queryPrjPropertyNums(); 
		//������;(�ֵ��TBPRJFUNCTIONDIC)
		prjFuncitonNums = service.queryPrjFuncitonNums();
		//�����(�ֵ��TBLXJBDIC)
		prjApprovalLevelNums = service.queryPrjApprovalLevelNums();
		return "addPage";
	}
	
	/**
	 * ��ӱ���
	 * @return
	 */
	public String add()
	{
		IConstructionService service = new ConstructionServiceImpl();
		prjId = service.add(construction);
		return "queryAdd";
	}
	
	/**
	 * ��ת�����޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IConstructionService service = new ConstructionServiceImpl();
		construction = service.queryById(prjId);
		//��ѯʡ
		provinces = service.queryProvince();
		prjTypeNums = service.queryPrjTypeNums();
		//��������(�ֵ��TBPRJPROPERTYDIC)
		prjPropertyNums = service.queryPrjPropertyNums(); 
		//������;(�ֵ��TBPRJFUNCTIONDIC)
		prjFuncitonNums = service.queryPrjFuncitonNums();
		//�����(�ֵ��TBLXJBDIC)
		prjApprovalLevelNums = service.queryPrjApprovalLevelNums();
		return "modifyPage";
	}
	
	/**
	 * �����޸�
	 * @return
	 */
	public String modify()
	{
		IConstructionService service = new ConstructionServiceImpl();
		service.modify(construction);
		return "query";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		IConstructionService service = new ConstructionServiceImpl();
		service.delete(prjId);
		return "query";
	}
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public String queryAppDept()
	{
		IConstructionService service = new ConstructionServiceImpl();
		list = service.queryAppDept();
		treeStr = JSONArray.fromObject(list).toString();
		return "queryAppDept";
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

	public List<DictionaryClass> getPrjTypeNums() {
		return prjTypeNums;
	}

	public void setPrjTypeNums(List<DictionaryClass> prjTypeNums) {
		this.prjTypeNums = prjTypeNums;
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
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

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
