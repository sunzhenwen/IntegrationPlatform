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
 * 合同备案统计(按合同类别)
 * @author hhc
 *
 */
public class FilingCategoryStatisticsAction extends BaseAction {
	
	private String pieResult;
	//地市名称
	private String cityName;
//	//房屋建筑工程
//	private String houses;
//	//市政工程
//	private String municipals;
//	//其他
//	private String others;
	//勘察
	private String querySurvey;
	//设计
	private String queryDesign;
	//施工总包
	private String queryTheContractor;
	//施工分包
	private String queryToSubcontract;
	//施工劳务
	private String queryLabourServices;
	//监理
	private String querySupervisor;
	//一体化
	private String queryIntegrated;
	//总承包
	private String queryGeneralContract;
	//项目管理
	private String queryProjectManagement;
	//地市Id
	private String cityId;
	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//地市
	private List<DictionaryClass> citys;
	//区县
	private List<DictionaryClass> areas;
	private List<ConstructionStatistics> csList;
	private String result;
	//所属地市
	private String cityNum;
	//所属区县
	private String areaNum;
	private String title;
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IFilingCategoryStatisticsService service = new FilingCategoryStatisticsServiceImpl();
		//查询地市下拉列表数据
		citys = service.queryCitys();
		
		if(areaNum != null && !"".equals(areaNum))
		{
			//获取统计图地市
			title = service.queryAreaName(areaNum).get(0);
			cityName = JSONArray.fromObject(service.queryAreaName(areaNum)).toString();
			List<List<Integer>> list = service.queryPage(areaNum,"1",startDate,endDate);
			//勘察
			querySurvey = JSONArray.fromObject(list.get(0)).toString();
			//设计
			queryDesign = JSONArray.fromObject(list.get(1)).toString();
			//施工总包
			queryTheContractor = JSONArray.fromObject(list.get(2)).toString();
			//施工分包
			queryToSubcontract = JSONArray.fromObject(list.get(3)).toString();
			//施工劳务
			queryLabourServices = JSONArray.fromObject(list.get(4)).toString();
			//监理
			querySupervisor = JSONArray.fromObject(list.get(5)).toString();
			//一体化
			queryIntegrated = JSONArray.fromObject(list.get(6)).toString();
			//总承包
			queryGeneralContract = JSONArray.fromObject(list.get(7)).toString();
			//项目管理
			queryProjectManagement = JSONArray.fromObject(list.get(8)).toString();
			
			//区县项目分类合同查询
			csList = service.queryAreaPie(areaNum,"1",startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		}else if(cityNum != null && !"".equals(cityNum))
		{
			title = service.queryAreaName(cityNum).get(0);
			//获取统计图地市
			cityName = JSONArray.fromObject(service.queryCityName(cityNum)).toString();
			List<List<Integer>> list = service.queryPage(cityNum,"2",startDate,endDate);
			//勘察
			querySurvey = JSONArray.fromObject(list.get(0)).toString();
			//设计
			queryDesign = JSONArray.fromObject(list.get(1)).toString();
			//施工总包
			queryTheContractor = JSONArray.fromObject(list.get(2)).toString();
			//施工分包
			queryToSubcontract = JSONArray.fromObject(list.get(3)).toString();
			//施工劳务
			queryLabourServices = JSONArray.fromObject(list.get(4)).toString();
			//监理
			querySupervisor = JSONArray.fromObject(list.get(5)).toString();
			//一体化
			queryIntegrated = JSONArray.fromObject(list.get(6)).toString();
			//总承包
			queryGeneralContract = JSONArray.fromObject(list.get(7)).toString();
			//项目管理
			queryProjectManagement = JSONArray.fromObject(list.get(8)).toString();
			
			//---------------------饼形图---------------------------
			//地市项目分类合同查询
			csList = service.queryCityPie(cityNum,"2",startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		}else
		{
			//获取统计图地市
			cityName = this.getCityNames(citys);
			List<List<Integer>> list = service.queryPage(citys,startDate,endDate);
//			//房屋建筑工程
//			houses = JSONArray.fromObject(list.get(0)).toString();
//			//市政工程
//			municipals = JSONArray.fromObject(list.get(1)).toString();
//			//其他
//			others = JSONArray.fromObject(list.get(2)).toString();
//			
			//勘察
			querySurvey = JSONArray.fromObject(list.get(0)).toString();
			//设计
			queryDesign = JSONArray.fromObject(list.get(1)).toString();
			//施工总包
			queryTheContractor = JSONArray.fromObject(list.get(2)).toString();
			//施工分包
			queryToSubcontract = JSONArray.fromObject(list.get(3)).toString();
			//施工劳务
			queryLabourServices = JSONArray.fromObject(list.get(4)).toString();
			//监理
			querySupervisor = JSONArray.fromObject(list.get(5)).toString();
			//一体化
			queryIntegrated = JSONArray.fromObject(list.get(6)).toString();
			//总承包
			queryGeneralContract = JSONArray.fromObject(list.get(7)).toString();
			//项目管理
			queryProjectManagement = JSONArray.fromObject(list.get(8)).toString();
			
			//---------------------饼形图---------------------------
			//查询黑龙江省各地市的合同备案情况
			csList = service.queryPie(startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		}
		return "queryPage";
	}

	/**
	 * 查询区
	 * @return
	 */
	public String queryArea()
    {
		IFilingCategoryStatisticsService service = new FilingCategoryStatisticsServiceImpl();
		areas = service.queryArea(cityId);
		JSONArray json = JSONArray.fromObject(areas);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 获取json转换后的地市名称
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
