package com.tj.jst.inner.count.filing.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.filing.service.FilingCountServiceImpl;
import com.tj.jst.inner.count.filing.service.IFilingCountService;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * 合同备案方法类
 * 
 * @author Administrator
 *
 */
public class FilingCountAction extends BaseAction {

	private String pieResult;
	// 地市名称
	private String cityName;
	// 房屋建筑工程
	private String houses;
	// 市政工程
	private String municipals;
	// 其他
	private String others;
	// 地市Id
	private String cityId;
	// 开始时间
	private String startDate;
	// 结束时间
	private String endDate;
	private List<ConstructionStatistics> csList;
	// 地市
	private List<DictionaryClass> citys;
	// 区县
	private List<DictionaryClass> areas;
	// 返回结果
	private String result;
	// 所属地市
	private String cityNum;
	// 所属区县
	private String areaNum;
	private String title;

	/**
	 * 查询
	 * 
	 * @return
	 */
	public String queryPage() {

		IFilingCountService service = new FilingCountServiceImpl();
		// 查询地市下拉列表数据
		citys = service.queryCitys();
		if (areaNum != null && !"".equals(areaNum)) {
			// 获取统计图地市
			title = service.queryAreaName(areaNum).get(0);
			cityName = JSONArray.fromObject(service.queryAreaName(areaNum)).toString();
			List<List<Integer>> list = service.queryPage(areaNum, "1",startDate, endDate);
			// 房屋建筑工程
			houses = JSONArray.fromObject(list.get(0)).toString();
			// 市政工程
			municipals = JSONArray.fromObject(list.get(1)).toString();
			// 其他
			others = JSONArray.fromObject(list.get(2)).toString();
			//---------------------饼形图---------------------------
			//区县项目分类合同查询
			csList = service.queryAreaPie(areaNum,"1",startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		} else if (cityNum != null && !"".equals(cityNum)) {
			title = service.queryAreaName(cityNum).get(0);
			// 获取统计图地市
			cityName = JSONArray.fromObject(service.queryCityName(cityNum)).toString();
			List<List<Integer>> list = service.queryPage(cityNum, "2",startDate, endDate);
			// 房屋建筑工程
			houses = JSONArray.fromObject(list.get(0)).toString();
			// 市政工程
			municipals = JSONArray.fromObject(list.get(1)).toString();
			// 其他
			others = JSONArray.fromObject(list.get(2)).toString();
			//---------------------饼形图---------------------------
			//地市项目分类合同查询
			csList = service.queryCityPie(cityNum,"2",startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		} else {
			// 获取统计图地市
			cityName = this.getCityNames(citys);
			List<List<Integer>> list = service.queryPage(citys, startDate,endDate);
			// 房屋建筑工程
			houses = JSONArray.fromObject(list.get(0)).toString();
			// 市政工程
			municipals = JSONArray.fromObject(list.get(1)).toString();
			// 其他
			others = JSONArray.fromObject(list.get(2)).toString();
			
			//---------------------饼形图---------------------------
			//查询黑龙江省各地市的合同备案情况
			csList = service.queryPie(startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		}
		return "queryPage";
	}

	/**
	 * 查询区
	 * 
	 * @return
	 */
	public String queryArea() {
		IFilingCountService service = new FilingCountServiceImpl();
		areas = service.queryArea(cityId);
		JSONArray json = JSONArray.fromObject(areas);// 给result赋值，传递给页面
		result = json.toString();
		return "success";
	}

	/**
	 * 获取json转换后的地市名称
	 * 
	 * @return
	 */
	public String getCityNames(List<DictionaryClass> citys) {
		int q = citys.size();
		List<String> names = new ArrayList<String>();
		for (int i = 0; i < citys.size(); i++) {
			names.add(citys.get(i).getName());
		}
		return JSONArray.fromObject(names).toString();

	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getHouses() {
		return houses;
	}

	public void setHouses(String houses) {
		this.houses = houses;
	}

	public String getMunicipals() {
		return municipals;
	}

	public void setMunicipals(String municipals) {
		this.municipals = municipals;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
