package com.tj.jst.inner.count.plan.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.plan.modal.Plan;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * 施工图审数据库接口
 * 
 * @author Administrator
 *
 */
public interface IPlanCountDao {

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

	public List<Plan> queryAreaPie(String checkNum,
			String check, String startDate, String endDate);

	public List<Plan> queryCityPie(String checkNum,
			String check, String startDate, String endDate);

	public List<Plan> queryPie(List<DictionaryClass> citys,String startDate,
			String endDate);

}
