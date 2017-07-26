package com.tj.jst.inner.count.permit.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.permit.dao.IPermitCountDao;
import com.tj.jst.inner.count.permit.dao.PermitCountDaoImpl;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * ʩ����ɷ�����
 * 
 * @author Administrator
 *
 */
public class PermitCountServiceImpl implements IPermitCountService {

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	/**
	 * ��ѯ
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * ��ѯ������ʡ�����е�ʩ��������
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate)
	{
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryPie(startDate,endDate);
	}
	
	/**
	 * ����ʩ����ɲ�ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate)
	{
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryCityPie(checkNum,check,startDate,endDate);
	}
	
	/**
	 * ����ʩ����ɲ�ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate)
	{
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryAreaPie(checkNum,check,startDate,endDate);
	}
}
