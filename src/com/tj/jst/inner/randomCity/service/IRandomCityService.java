package com.tj.jst.inner.randomCity.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomCity.model.RandomCity;

/**
 * ������в�ѯ
 * 
 * @author Administrator
 *
 */
public interface IRandomCityService {

	/**
	 * ��ѯ�����б�
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryCitys();

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public RandomCity queryArea(String cityCode);
}
