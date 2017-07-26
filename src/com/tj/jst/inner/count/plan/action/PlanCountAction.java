package com.tj.jst.inner.count.plan.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.plan.modal.Plan;
import com.tj.jst.inner.count.plan.service.IPlanCountService;
import com.tj.jst.inner.count.plan.service.PlanCountServiceImpl;

/**
 * ʩ��ͼ���ͳ��
 * 
 * @author Administrator
 *
 */
public class PlanCountAction extends BaseAction {

	private String pieResult;
	// ��������
	private String cityName;
	// ���ݽ�������
	private String houses;
	// ��������
	private String municipals;
	// ����
	private String others;
	// ����Id
	private String cityId;
	// ��ʼʱ��
	private String startDate;
	// ����ʱ��
	private String endDate;
	private List<Plan> csList;
	// ����
	private List<DictionaryClass> citys;
	// ����
	private List<DictionaryClass> areas;
	// ���ؽ��
	private String result;
	// ��������
	private String cityNum;
	// ��������
	private String areaNum;
	private String title;

	/**
	 * ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		IPlanCountService service = new PlanCountServiceImpl();

		// ��ѯ���������б�����
		citys = service.queryCitys();
		if (areaNum != null && !"".equals(areaNum)) {
			// ��ȡͳ��ͼ����
			title = service.queryAreaName(areaNum).get(0);
			cityName = JSONArray.fromObject(service.queryAreaName(areaNum))
					.toString();
			List<List<Integer>> list = service.queryPage(areaNum, "1",
					startDate, endDate);
			// ���ݽ�������
			houses = JSONArray.fromObject(list.get(0)).toString();
			// ��������
			municipals = JSONArray.fromObject(list.get(1)).toString();
			// ����
			others = JSONArray.fromObject(list.get(2)).toString();
			//---------------------����ͼ---------------------------
			//������Ŀ�����ѯ
			csList = service.queryAreaPie(areaNum,"1",startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		} else if (cityNum != null && !"".equals(cityNum)) {
			title = service.queryAreaName(cityNum).get(0);
			// ��ȡͳ��ͼ����
			cityName = JSONArray.fromObject(service.queryCityName(cityNum))
					.toString();
			List<List<Integer>> list = service.queryPage(cityNum, "2",
					startDate, endDate);
			// ���ݽ�������
			houses = JSONArray.fromObject(list.get(0)).toString();
			// ��������
			municipals = JSONArray.fromObject(list.get(1)).toString();
			// ����
			others = JSONArray.fromObject(list.get(2)).toString();
			//---------------------����ͼ---------------------------
			//������Ŀ�����ѯ
			csList = service.queryCityPie(cityNum,"2",startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		} else {
			// ��ȡͳ��ͼ����
			cityName = this.getCityNames(citys);
			List<List<Integer>> list = service.queryPage(citys, startDate,
					endDate);
			// ���ݽ�������
			houses = JSONArray.fromObject(list.get(0)).toString();
			// ��������
			municipals = JSONArray.fromObject(list.get(1)).toString();
			// ����
			others = JSONArray.fromObject(list.get(2)).toString();
			//---------------------����ͼ---------------------------
			//��ѯ������ʡ�����е���Ŀ�������
			csList = service.queryPie(citys,startDate,endDate);
			pieResult = JSONArray.fromObject(csList).toString();
		}
		return "queryPage";
	}

	/**
	 * ��ѯ��
	 * 
	 * @return
	 */
	public String queryArea() {
		IPlanCountService service = new PlanCountServiceImpl();
		areas = service.queryArea(cityId);
		JSONArray json = JSONArray.fromObject(areas);// ��result��ֵ�����ݸ�ҳ��
		result = json.toString();
		return "success";
	}

	/**
	 * ��ȡjsonת����ĵ�������
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

	public List<DictionaryClass> getCitys() {
		return citys;
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

	public void setCitys(List<DictionaryClass> citys) {
		this.citys = citys;
	}

	public String getPieResult() {
		return pieResult;
	}

	public void setPieResult(String pieResult) {
		this.pieResult = pieResult;
	}

	public List<Plan> getCsList() {
		return csList;
	}

	public void setCsList(List<Plan> csList) {
		this.csList = csList;
	}

}
