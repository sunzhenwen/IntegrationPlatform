package com.tj.jst.inner.count.ready.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.ready.dao.IReadyCountDao;
import com.tj.jst.inner.count.ready.dao.ReadyCountDaoImpl;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * �������շ�����
 * 
 * @author Administrator
 *
 */
public class ReadyCountServiceImpl implements IReadyCountService {

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	/**
	 * ������
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	/**
	 * ������
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IReadyCountDao dao = new ReadyCountDaoImpl();
		return dao.queryArea(cityId);
	}


	/**
	 * ��ѯ������ʡ�����еĿ����������
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
	 * ���п������ղ�ѯ
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
	 * ���ؿ������ղ�ѯ
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
