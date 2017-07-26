package com.tj.jst.inner.statistics.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;
import com.tj.jst.inner.statistics.service.FilingCategoryStatisticsServiceImpl;
import com.tj.jst.inner.statistics.service.IFilingCategoryStatisticsService;

/**
 * ��ͬ����ͳ��(����ͬ���)
 * @author hhc
 *
 */
public class FilingCategoryStatisticsAction extends BaseAction {
	
	private String pieResult;
	//��������
	private String cityName;
//	//���ݽ�������
//	private String houses;
//	//��������
//	private String municipals;
//	//����
//	private String others;
	//����
	private String querySurvey;
	//���
	private String queryDesign;
	//ʩ���ܰ�
	private String queryTheContractor;
	//ʩ���ְ�
	private String queryToSubcontract;
	//ʩ������
	private String queryLabourServices;
	//����
	private String querySupervisor;
	//һ�廯
	private String queryIntegrated;
	//�ܳа�
	private String queryGeneralContract;
	//��Ŀ����
	private String queryProjectManagement;
	//����Id
	private String cityId;
	//��ʼʱ��
	private String startDate;
	//����ʱ��
	private String endDate;
	//����
	private List<DictionaryClass> citys;
	//����
	private List<DictionaryClass> areas;
	private List<ConstructionStatistics> csList;
	private String result;
	//��������
	private String cityNum;
	//��������
	private String areaNum;
	private String title;
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IFilingCategoryStatisticsService service = new FilingCategoryStatisticsServiceImpl();
		//��ѯ���������б�����
		citys = service.queryCitys();
		
		if(areaNum != null && !"".equals(areaNum))
		{
			//��ȡͳ��ͼ����
			title = service.queryAreaName(areaNum).get(0);
			cityName = JSONArray.fromObject(service.queryAreaName(areaNum)).toString();
			List<List<Integer>> list = service.queryPage(areaNum,"1",startDate,endDate);
			//����
			querySurvey = JSONArray.fromObject(list.get(0)).toString();
			//���
			queryDesign = JSONArray.fromObject(list.get(1)).toString();
			//ʩ���ܰ�
			queryTheContractor = JSONArray.fromObject(list.get(2)).toString();
			//ʩ���ְ�
			queryToSubcontract = JSONArray.fromObject(list.get(3)).toString();
			//ʩ������
			queryLabourServices = JSONArray.fromObject(list.get(4)).toString();
			//����
			querySupervisor = JSONArray.fromObject(list.get(5)).toString();
			//һ�廯
			queryIntegrated = JSONArray.fromObject(list.get(6)).toString();
			//�ܳа�
			queryGeneralContract = JSONArray.fromObject(list.get(7)).toString();
			//��Ŀ����
			queryProjectManagement = JSONArray.fromObject(list.get(8)).toString();
			
			//������Ŀ�����ͬ��ѯ
			csList = service.queryAreaPie(areaNum,"1",startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		}else if(cityNum != null && !"".equals(cityNum))
		{
			title = service.queryAreaName(cityNum).get(0);
			//��ȡͳ��ͼ����
			cityName = JSONArray.fromObject(service.queryCityName(cityNum)).toString();
			List<List<Integer>> list = service.queryPage(cityNum,"2",startDate,endDate);
			//����
			querySurvey = JSONArray.fromObject(list.get(0)).toString();
			//���
			queryDesign = JSONArray.fromObject(list.get(1)).toString();
			//ʩ���ܰ�
			queryTheContractor = JSONArray.fromObject(list.get(2)).toString();
			//ʩ���ְ�
			queryToSubcontract = JSONArray.fromObject(list.get(3)).toString();
			//ʩ������
			queryLabourServices = JSONArray.fromObject(list.get(4)).toString();
			//����
			querySupervisor = JSONArray.fromObject(list.get(5)).toString();
			//һ�廯
			queryIntegrated = JSONArray.fromObject(list.get(6)).toString();
			//�ܳа�
			queryGeneralContract = JSONArray.fromObject(list.get(7)).toString();
			//��Ŀ����
			queryProjectManagement = JSONArray.fromObject(list.get(8)).toString();
			
			//---------------------����ͼ---------------------------
			//������Ŀ�����ͬ��ѯ
			csList = service.queryCityPie(cityNum,"2",startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		}else
		{
			//��ȡͳ��ͼ����
			cityName = this.getCityNames(citys);
			List<List<Integer>> list = service.queryPage(citys,startDate,endDate);
//			//���ݽ�������
//			houses = JSONArray.fromObject(list.get(0)).toString();
//			//��������
//			municipals = JSONArray.fromObject(list.get(1)).toString();
//			//����
//			others = JSONArray.fromObject(list.get(2)).toString();
//			
			//����
			querySurvey = JSONArray.fromObject(list.get(0)).toString();
			//���
			queryDesign = JSONArray.fromObject(list.get(1)).toString();
			//ʩ���ܰ�
			queryTheContractor = JSONArray.fromObject(list.get(2)).toString();
			//ʩ���ְ�
			queryToSubcontract = JSONArray.fromObject(list.get(3)).toString();
			//ʩ������
			queryLabourServices = JSONArray.fromObject(list.get(4)).toString();
			//����
			querySupervisor = JSONArray.fromObject(list.get(5)).toString();
			//һ�廯
			queryIntegrated = JSONArray.fromObject(list.get(6)).toString();
			//�ܳа�
			queryGeneralContract = JSONArray.fromObject(list.get(7)).toString();
			//��Ŀ����
			queryProjectManagement = JSONArray.fromObject(list.get(8)).toString();
			
			//---------------------����ͼ---------------------------
			//��ѯ������ʡ�����еĺ�ͬ�������
			csList = service.queryPie(startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		}
		return "queryPage";
	}

	/**
	 * ��ѯ��
	 * @return
	 */
	public String queryArea()
    {
		IFilingCategoryStatisticsService service = new FilingCategoryStatisticsServiceImpl();
		areas = service.queryArea(cityId);
		JSONArray json = JSONArray.fromObject(areas);//��result��ֵ�����ݸ�ҳ�� 
        result = json.toString();
        return "success";
    }
	
	/**
	 * ��ȡjsonת����ĵ�������
	 * @return
	 */
	public String getCityNames(List<DictionaryClass> citys)
	{
		List<String> names = new ArrayList<String>();
		for(int i=0;i<citys.size();i++)
		{
			names.add(citys.get(i).getName());
		}
		return JSONArray.fromObject(names).toString();
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

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getQuerySurvey() {
		return querySurvey;
	}

	public void setQuerySurvey(String querySurvey) {
		this.querySurvey = querySurvey;
	}

	public String getQueryDesign() {
		return queryDesign;
	}

	public void setQueryDesign(String queryDesign) {
		this.queryDesign = queryDesign;
	}

	public String getQueryTheContractor() {
		return queryTheContractor;
	}

	public void setQueryTheContractor(String queryTheContractor) {
		this.queryTheContractor = queryTheContractor;
	}

	public String getQueryToSubcontract() {
		return queryToSubcontract;
	}

	public void setQueryToSubcontract(String queryToSubcontract) {
		this.queryToSubcontract = queryToSubcontract;
	}

	public String getQueryLabourServices() {
		return queryLabourServices;
	}

	public void setQueryLabourServices(String queryLabourServices) {
		this.queryLabourServices = queryLabourServices;
	}

	public String getQuerySupervisor() {
		return querySupervisor;
	}

	public void setQuerySupervisor(String querySupervisor) {
		this.querySupervisor = querySupervisor;
	}

	public String getQueryIntegrated() {
		return queryIntegrated;
	}

	public void setQueryIntegrated(String queryIntegrated) {
		this.queryIntegrated = queryIntegrated;
	}

	public String getQueryGeneralContract() {
		return queryGeneralContract;
	}

	public void setQueryGeneralContract(String queryGeneralContract) {
		this.queryGeneralContract = queryGeneralContract;
	}

	public String getQueryProjectManagement() {
		return queryProjectManagement;
	}

	public void setQueryProjectManagement(String queryProjectManagement) {
		this.queryProjectManagement = queryProjectManagement;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public String getAreaNum() {
		return areaNum;
	}

	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPieResult() {
		return pieResult;
	}

	public void setPieResult(String pieResult) {
		this.pieResult = pieResult;
	}

	public List<ConstructionStatistics> getCsList() {
		return csList;
	}

	public void setCsList(List<ConstructionStatistics> csList) {
		this.csList = csList;
	}
	
}
