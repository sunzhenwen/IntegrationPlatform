package com.tj.jst.inner.count.safety.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.safety.dao.ISafetyCountDao;
import com.tj.jst.inner.count.safety.dao.SafetyCountDaoImpl;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * 安全勘察服务类
 * 
 * @author Administrator
 *
 */
public class SafetyCountServiceImpl implements ISafetyCountService {

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	/**
	 * 查询区名称
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	/**
	 * 查询市名称
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * 查询区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryArea(cityId);
	}

	
	/**
	 * 查询黑龙江省各地市的安全情况
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate)
	{
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryPie(startDate,endDate);
	}
	
	/**
	 * 地市安全查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate)
	{
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryCityPie(checkNum,check,startDate,endDate);
	}
	
	/**
	 * 区县安全查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate)
	{
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryAreaPie(checkNum,check,startDate,endDate);
	}
}
