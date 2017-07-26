package com.tj.jst.inner.count.permit.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * 施工许可服务接口
 * @author Administrator
 *
 */
public interface IPermitCountService {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate);

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate);

	/**
	 * 查询区域名称
	 * 
	 * @param areaNum
	 * @return
	 */
	public List<String> queryAreaName(String areaNum);

	/**
	 * 查询地市名称
	 * 
	 * @param areaNum
	 * @return
	 */
	public List<String> queryCityName(String cityNum);

	/**
	 * 查询地市
	 * 
	 * @param construction
	 * @return
	 */
	public List<DictionaryClass> queryCitys();

	/**
	 * 查询区域
	 * 
	 * @param cityId
	 * @return
	 */
	public List<DictionaryClass> queryArea(String cityId);

	/**
	 * 查询黑龙江省各地市的施工许可情况
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate);
	
	/**
	 * 地市施工许可查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate);
	
	/**
	 * 区县施工许可查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate);
}
