package com.tj.jst.inner.statistics.service;
import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.filing.dao.FilingCountDaoImpl;
import com.tj.jst.inner.count.filing.dao.IFilingCountDao;
import com.tj.jst.inner.statistics.dao.FilingCategoryStatisticsDaoImpl;
import com.tj.jst.inner.statistics.dao.IFilingCategoryStatisticsDao;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * ��ͬ����ͳ��(����ͬ���)
 * @author hhc
 *
 */
public class FilingCategoryStatisticsServiceImpl implements IFilingCategoryStatisticsService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,String startDate,String endDate) {
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryPage(citys,startDate,endDate);
	}	
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(String checkNum,String check,String startDate,String endDate)
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryPage(checkNum,check,startDate,endDate);
	}
	
	/**
	 * ��ѯ��������
	 * @param areaNum
	 * @return
	 */
	public List<String> queryAreaName(String areaNum)
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryAreaName(areaNum);
	}
	
	/**
	 * ��ѯ��������
	 * @param areaNum
	 * @return
	 */
	public List<String> queryCityName(String cityNum)
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryCityName(cityNum);
	}
	
	/**
	 * ��ѯ����
	 * @param construction
	 * @return
	 */
	public List<DictionaryClass> queryCitys()
	{
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryCitys();
	}
	/**
	 * ��ѯ��
	 */
	public List<DictionaryClass> queryArea(String cityId) {
		IFilingCategoryStatisticsDao dao = new FilingCategoryStatisticsDaoImpl();
		return dao.queryArea(cityId);
	}
	
	/**
	 * ��ѯ������ʡ�����еĺ�ͬ�������
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
	 * ���к�ͬ������ѯ
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
	 * ���غ�ͬ������ѯ
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
