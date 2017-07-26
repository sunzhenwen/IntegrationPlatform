package com.tj.jst.inner.statistics.service;
import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.statistics.dao.ConstructionStatisticsDaoImpl;
import com.tj.jst.inner.statistics.dao.IConstructionStatisticsDao;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * ��Ŀ����ͳ��
 * @author hhc
 *
 */
public class ConstructionStatisticsServiceImpl implements IConstructionStatisticsService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,String startDate,String endDate) {
		IConstructionStatisticsDao dao = new ConstructionStatisticsDaoImpl();
		return dao.queryPage(citys,startDate,endDate);
	}	
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(String checkNum,String check,String startDate,String endDate)
	{
		IConstructionStatisticsDao dao = new ConstructionStatisticsDaoImpl();
		return dao.queryPage(checkNum,check,startDate,endDate);
	}
	
	/**
	 * ��ѯ��������
	 * @param areaNum
	 * @return
	 */
	public List<String> queryAreaName(String areaNum)
	{
		IConstructionStatisticsDao dao = new ConstructionStatisticsDaoImpl();
		return dao.queryAreaName(areaNum);
	}
	
	/**
	 * ��ѯ��������
	 * @param areaNum
	 * @return
	 */
	public List<String> queryCityName(String cityNum)
	{
		IConstructionStatisticsDao dao = new ConstructionStatisticsDaoImpl();
		return dao.queryCityName(cityNum);
	}
	
	/**
	 * ��ѯ����
	 * @param construction
	 * @return
	 */
	public List<DictionaryClass> queryCitys()
	{
		IConstructionStatisticsDao dao = new ConstructionStatisticsDaoImpl();
		return dao.queryCitys();
	}
	/**
	 * ��ѯ��
	 */
	public List<DictionaryClass> queryArea(String cityId) {
		IConstructionStatisticsDao dao = new ConstructionStatisticsDaoImpl();
		return dao.queryArea(cityId);
	}
	
	/**
	 * ��ѯ������ʡ�����е���Ŀ�������
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate)
	{
		IConstructionStatisticsDao dao = new ConstructionStatisticsDaoImpl();
		return dao.queryPie(startDate,endDate);
	}
	
	/**
	 * ������Ŀ�����ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate)
	{
		IConstructionStatisticsDao dao = new ConstructionStatisticsDaoImpl();
		return dao.queryCityPie(checkNum,check,startDate,endDate);
	}
	
	/**
	 * ������Ŀ�����ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate)
	{
		IConstructionStatisticsDao dao = new ConstructionStatisticsDaoImpl();
		return dao.queryAreaPie(checkNum,check,startDate,endDate);
	}
}
