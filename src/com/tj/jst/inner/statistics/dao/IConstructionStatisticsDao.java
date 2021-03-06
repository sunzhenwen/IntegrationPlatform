package com.tj.jst.inner.statistics.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * 项目报建统计
 * @author hhc
 *
 */
public interface IConstructionStatisticsDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,String startDate,String endDate);
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(String checkNum,String check,String startDate,String endDate);
	
	/**
	 * 查询区域名称
	 * @param areaNum
	 * @return
	 */
	public List<String> queryAreaName(String areaNum);
	
	/**
	 * 查询地市名称
	 * @param areaNum
	 * @return
	 */
	public List<String> queryCityName(String cityNum);
	
	/**
	 * 查询地市
	 * @param construction
	 * @return
	 */
	public List<DictionaryClass> queryCitys();
	/**
	 * 查询区域
	 * @param cityId
	 * @return
	 */
	public List<DictionaryClass> queryArea(String cityId);
	
	/**
	 * 查询黑龙江省各地市的项目报建情况
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate);
	
	/**
	 * 地市项目分类查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate);

	/**
	 * 区县项目分类查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate);
}
