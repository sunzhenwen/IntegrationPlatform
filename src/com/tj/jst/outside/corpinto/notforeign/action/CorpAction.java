package com.tj.jst.outside.corpinto.notforeign.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;
import com.tj.jst.outside.corpinto.notforeign.service.CorpServiceImpl;
import com.tj.jst.outside.corpinto.notforeign.service.ICorpService;

/**
 * ��ҵ
 * @author Administrator
 *
 */
public class CorpAction extends BaseAction {
	
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

	private String builderLicenceNum;
	
	private String typeNum;// ��Դ 1:���赥λ 2:��ҵ��ҵ 3:���ܲ���
	
	//������Դ,ֵΪoaeas,˵������������ϵͳ����
	private String method;
	//�������ӵ�ַ
	private String fromurl;
	
	//������ʾ��Ϣ
	private String message;
	private String result;
	private int num;
	
	/**
	 * ����ҵ���
	 * @return
	 */
	public String addCorp()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.addCorp(corp);
		
		String returnPage = "";
		//�ж��Ƿ���ת��������ϵͳ��¼ҳ��
		if(!"".equals(this.get("oaeas")))
		{
			//�������ӵ�ַ
			fromurl = (String) this.get("fromurl");
			this.remove("oaeas");
			this.remove("fromurl");
			returnPage = "oaeasPage";
		}else
		{
			returnPage = "addCorp";
		}

		return returnPage;
	}
	
	public String showCodeCertificate()
	{

		return "showCodeCertificate";
	}
	
	
	/**
	 * ���赥λ
	 * ��ҵ�޸�
	 * @return
	 */
	public String modifyCorp()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.modifyCorp(corp);
		corpCode = corp.getCorpCode();
		typeNum = "1" ;
		return "backToBusiness";
	} 
	
	/**
	 * δ��key��ҵ�޸�
	 * ��ҵ������Ϣ�޸�
	 * @return
	 */
	public String corpModify()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.modifyCorp(corp);
		
		String returnPage = "";
		//�ж��Ƿ���ת��������ϵͳ��¼ҳ��
		if(!"".equals(this.get("oaeas")))
		{
			//�������ӵ�ַ
			fromurl = (String) this.get("fromurl");
			this.remove("oaeas");
			this.remove("fromurl");
			returnPage = "oaeasPage";
		}else
		{
			returnPage = "outLogin";
		}
		
		return returnPage;
	} 
	
	/**
	 * ���赥λ
	 * ��ת���޸�ҳ��
	 * @return
	 */
	public String queryCorp(){
		ICorpService corpService = new CorpServiceImpl();
		corp = corpService.queryCorpCode1(corpCode);
		typeNum = "1" ;
		if(corp==null) {
			message = "��ҵ��ӵ�����ʻ����������������޷��޸Ļ�����Ϣ��" ;
			return "backToBusiness" ;
		}
		provinces = corpService.queryProvince();//��ѯʡ
		this.queryDictionary();
		return "modifyCorp";
	}
	
	/**
	 * ��ҵ�����޸�
	 * @return
	 */
	public String modifyCorpType()
	{
		ICorpService corpService = new CorpServiceImpl();
		message = corpService.modifyCorpType(corp);
		return "outLogin";
	}
	
//	/**
//	 * ��ת��ҵע������ͼҳ��
//	 * @return
//	 */
//	public String flowChart()
//	{
//		return "flowchart";
//	}
	
	/**
	 * ��ת��֯��������֤��ѯҳ��
	 * @return
	 */
	public String queryCorpNamePage()
	{
		//�ж��Ƿ�����������ϵͳ����
		if(!"".equals(this.getMethod()))
		{
			//������Դ,ֵΪoaeas,˵������������ϵͳ����
			this.set("oaeas", this.getMethod());
			//�������ӵ�ַ
			this.set("fromurl", this.getFromurl());
		}
		
		return "queryCorpNamePage";
	}
	
	/**
	 * ��ת��ҵ������֯���������ѯҳ��
	 * @return
	 */
	public String queryCorpCodePage()
	{
		
		return "queryCorpCodePage";
	}
	
	/**
	 * ��ת������½ҳ��
	 * @return
	 */
	public String queryOutLoginPage()
	{
		String oaeas = (String)this.get("oaeas");
		if(oaeas != null)
		{
			//�������ӵ�ַ
			fromurl = (String) this.get("fromurl");
			this.remove("oaeas");
			this.remove("fromurl");
			return "oaeasPage";
		}else
		{
			return "outLogin";
		}
		
	}
	
	/**
	 * ��֯���������ѯ
	 * @return
	 */
	public String queryCorpCode()
	{
		String oaeas = (String)this.get("oaeas");
		ICorpService corpService = new CorpServiceImpl();
		//������֯���������ѯ��ҵ��Ϣ
		corp = corpService.queryCorpCode(corpCode);
		String returnPage = "";
		//���ص�½ҳ��
		if(corp.getCheckType() == 0)
		{
			returnPage = "outLogin";
		}
		//��ת�޸�ҳ��
		if(corp.getCheckType() == 1)
		{
			//��ѯʡ
			provinces = corpService.queryProvince();
			this.queryDictionary();
			returnPage = "corpModify";
		}
		//��תע�����ҳ��
		if(corp.getCheckType() == 2)
		{
			//��ѯʡ
			provinces = corpService.queryProvince();
			this.queryDictionary();
			returnPage = "corpAdd";
		}
		return returnPage;
		
	}
	
	/**
	 * ��֯���������ѯ
	 * @return
	 */
	public String queryCorpTypeCode()
	{
		ICorpService corpService = new CorpServiceImpl();
		//������֯���������ѯ��ҵ��Ϣ
		corp = corpService.queryCorpTypeCode(corpCode);
		String returnPage = "";
		if(corp.getCheckType()==2)
		{
			returnPage = "outLogin";
		}else
		{
			returnPage = "queryCorpTypeCode";
		}
		return returnPage;
	}

	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryCity()
    {
		ICorpService corpService = new CorpServiceImpl();
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
		ICorpService corpService = new CorpServiceImpl();
		areas = corpService.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	//������ҵ�޸�ҳ�淵��
	public String goBack(){
		
		String oaeas = (String)this.get("oaeas");
		if(oaeas != null)
		{
			//�������ӵ�ַ
			fromurl = (String) this.get("fromurl");
			this.remove("oaeas");
			this.remove("fromurl");
			return "oaeasPage";
		}else
		{
			return "outLogin";
		}
	}
	
	//���赥λ������Ϣ�޸�ҳ�淵��
	public String goBack1(){
		typeNum = "1" ;
		return "goBusiness";
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBuilderLicenceNum() {
		return builderLicenceNum;
	}

	public void setBuilderLicenceNum(String builderLicenceNum) {
		this.builderLicenceNum = builderLicenceNum;
	}

	public String getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getFromurl() {
		return fromurl;
	}

	public void setFromurl(String fromurl) {
		this.fromurl = fromurl;
	}

}
