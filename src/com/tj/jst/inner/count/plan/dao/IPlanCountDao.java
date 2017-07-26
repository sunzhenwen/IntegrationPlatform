package com.tj.jst.inner.count.plan.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.count.plan.modal.Plan;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * ʩ��ͼ�����ݿ�ӿ�
 * 
 * @author Administrator
 *
 */
public interface IPlanCountDao {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate);

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate);

	/**
	 * ��ѯ��������
	 * 
	 * @param areaNum
	 * @return
	 */
	public List<String> queryAreaName(String areaNum);

	/**
	 * ��ѯ��������
	 * 
	 * @param areaNum
	 * @return
	 */
	public List<String> queryCityName(String cityNum);

	/**
	 * ��ѯ����
	 * 
	 * @param construction
	 * @return
	 */
	public List<DictionaryClass> queryCitys();

	/**
	 * ��ѯ����
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
