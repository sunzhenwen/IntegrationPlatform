package com.tj.jst.inner.count.permit.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.permit.dao.IPermitCountDao;
import com.tj.jst.inner.count.permit.dao.PermitCountDaoImpl;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * 施工许可服务类
 * 
 * @author Administrator
 *
 */
public class PermitCountServiceImpl implements IPermitCountService {

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryPage(citys, startDate, endDate);
	}

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryPage(checkNum, check, startDate, endDate);
	}

	/**
	 * 查询区名称
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryAreaName(areaNum);
	}

	/**
	 * 查询市名称
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryCityName(cityNum);
	}

	/**
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * 查询区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		IPermitCountDao dao = new PermitCountDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * 查询黑龙江省各地市的施工许可情况
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
	 * 地市施工许可查询
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
	 * 区县施工许可查询
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
