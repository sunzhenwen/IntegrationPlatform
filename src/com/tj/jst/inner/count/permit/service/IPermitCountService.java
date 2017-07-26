package com.tj.jst.inner.count.permit.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * ʩ����ɷ���ӿ�
 * @author Administrator
 *
 */
public interface IPermitCountService {
	
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

	/**
	 * ��ѯ������ʡ�����е�ʩ��������
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate);
	
	/**
	 * ����ʩ����ɲ�ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate);
	
	/**
	 * ����ʩ����ɲ�ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate);
}
