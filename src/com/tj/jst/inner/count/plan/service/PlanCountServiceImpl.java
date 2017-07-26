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
 * ʩ��ͼ�������
 * 
 * @author Administrator
 *
 */
public class PlanCountServiceImpl implements IPlanCountService {

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	/**
	 * ��ѯ��������
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	/**
	 * ��ѯ��������
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IPlanCountDao dao = new PlanCountDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * ��ѯ��
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
