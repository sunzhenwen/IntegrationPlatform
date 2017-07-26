package com.tj.jst.inner.statistics.service;
import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.filing.dao.FilingCountDaoImpl;
import com.tj.jst.inner.count.filing.dao.IFilingCountDao;
import com.tj.jst.inner.statistics.dao.FilingCategoryStatisticsDaoImpl;
import com.tj.jst.inner.statistics.dao.IFilingCategoryStatisticsDao;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * 合同备案统计(按合同类别)
 * @author hhc
 *
 */
public class FilingCategoryStatisticsServiceImpl implements IFilingCategoryStatisticsService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,String startDate,String endDate) {
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryPage(citys,startDate,endDate);
	}	
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(String checkNum,String check,String startDate,String endDate)
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryPage(checkNum,check,startDate,endDate);
	}
	
	/**
	 * 查询区域名称
	 * @param areaNum
	 * @return
	 */
	public List<String> queryAreaName(String areaNum)
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryAreaName(areaNum);
	}
	
	/**
	 * 查询地市名称
	 * @param areaNum
	 * @return
	 */
	public List<String> queryCityName(String cityNum)
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryCityName(cityNum);
	}
	
	/**
	 * 查询地市
	 * @param construction
	 * @return
	 */
	public List<DictionaryClass> queryCitys()
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryCitys();
	}
	/**
	 * 查询区
	 */
	public List<DictionaryClass> queryArea(String cityId) {
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryArea(cityId);
	}
	
	/**
	 * 查询黑龙江省各地市的合同备案情况
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate)
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryPie(startDate,endDate);
	}
	
	/**
	 * 地市合同备案查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate)
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryCityPie(checkNum,check,startDate,endDate);
	}
	
	/**
	 * 区县合同备案查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate)
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryAreaPie(checkNum,check,startDate,endDate);
	}
}
