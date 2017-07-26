package com.tj.jst.inner.count.safety.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.safety.dao.ISafetyCountDao;
import com.tj.jst.inner.count.safety.dao.SafetyCountDaoImpl;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * ��ȫ���������
 * 
 * @author Administrator
 *
 */
public class SafetyCountServiceImpl implements ISafetyCountService {

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		ISafetyCountDao dao = new SafetyCountDaoImpl();
		return dao.queryArea(cityId);
	}

	
	/**
	 * ��ѯ������ʡ�����еİ�ȫ���
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
	 * ���а�ȫ��ѯ
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
	 * ���ذ�ȫ��ѯ
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
