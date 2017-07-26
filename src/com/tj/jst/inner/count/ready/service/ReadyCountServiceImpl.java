package com.tj.jst.inner.count.ready.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.ready.dao.IReadyCountDao;
import com.tj.jst.inner.count.ready.dao.ReadyCountDaoImpl;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * 竣工验收服务类
 * 
 * @author Administrator
 *
 */
public class ReadyCountServiceImpl implements IReadyCountService {

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	/**
	 * 区名称
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	/**
	 * 市名称
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * 查询区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryArea(cityId);
	}


	/**
	 * 查询黑龙江省各地市的竣工验收情况
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate)
	{
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryPie(startDate,endDate);
	}
	
	/**
	 * 地市竣工验收查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate)
	{
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryCityPie(checkNum,check,startDate,endDate);
	}
	
	/**
	 * 区县竣工验收查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate)
	{
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryAreaPie(checkNum,check,startDate,endDate);
	}
}
