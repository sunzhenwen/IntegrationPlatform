package com.tj.jst.inner.count.quality.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.quality.dao.IQualityCountDao;
import com.tj.jst.inner.count.quality.dao.QualityCountDaoImpl;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * �����������ӿ�
 * 
 * @author Administrator
 *
 */
public class QualityCountServiceImpl implements IQualityCountService {

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IQualityCountDao dao = new QualityCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IQualityCountDao dao = new QualityCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		IQualityCountDao dao = new QualityCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IQualityCountDao dao = new QualityCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IQualityCountDao dao = new QualityCountDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IQualityCountDao dao = new QualityCountDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * ��ѯ������ʡ�����е��������
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate)
	{
		IQualityCountDao dao = new QualityCountDaoImpl();
		return dao.queryPie(startDate,endDate);
	}
	
	/**
	 * ����������ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate)
	{
		IQualityCountDao dao = new QualityCountDaoImpl();
		return dao.queryCityPie(checkNum,check,startDate,endDate);
	}
	
	/**
	 * ����������ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate)
	{
		IQualityCountDao dao = new QualityCountDaoImpl();
		return dao.queryAreaPie(checkNum,check,startDate,endDate);
	}
}
