package com.tj.jst.inner.count.filing.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.filing.dao.FilingCountDaoImpl;
import com.tj.jst.inner.count.filing.dao.IFilingCountDao;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * ��ͬ����������
 * 
 * @author Administrator
 *
 */
public class FilingCountServiceImpl implements IFilingCountService {

	/**
	 * ������
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IFilingCountDao dao = new FilingCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IFilingCountDao dao = new FilingCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		IFilingCountDao dao = new FilingCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IFilingCountDao dao = new FilingCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IFilingCountDao dao = new FilingCountDaoImpl();
		return dao.queryCitys();
	}

	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IFilingCountDao dao = new FilingCountDaoImpl();
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
		IFilingCountDao dao = new FilingCountDaoImpl();
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
		IFilingCountDao dao = new FilingCountDaoImpl();
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
		IFilingCountDao dao = new FilingCountDaoImpl();
		return dao.queryAreaPie(checkNum,check,startDate,endDate);
	}
}
