package com.tj.jst.inner.count.plan.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.plan.dao.IPlanCountDao;
import com.tj.jst.inner.count.plan.dao.PlanCountDaoImpl;
import com.tj.jst.inner.count.plan.modal.Plan;
import com.tj.jst.inner.statistics.dao.ConstructionStatisticsDaoImpl;
import com.tj.jst.inner.statistics.dao.IConstructionStatisticsDao;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * 施工图审服务类
 * 
 * @author Administrator
 *
 */
public class PlanCountServiceImpl implements IPlanCountService {

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	/**
	 * 查询区域名称
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	/**
	 * 查询地市名称
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * 查询区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryArea(cityId);
	}

	@Override
	public List<Plan> queryAreaPie(String checkNum,
			String check, String startDate, String endDate) {
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryAreaPie(checkNum,check,startDate,endDate);
	}

	@Override
	public List<Plan> queryCityPie(String checkNum,
			String check, String startDate, String endDate) {
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryCityPie(checkNum,check,startDate,endDate);
	}

	@Override
	public List<Plan> queryPie(List<DictionaryClass> citys,String startDate,
			String endDate) {
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryPie(citys,startDate,endDate);
	}

}
