package com.tj.jst.inner.randomCity.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomCity.model.RandomCity;

/**
 * 随机地市查询
 * 
 * @author Administrator
 *
 */
public interface IRandomCityService {

	/**
	 * 查询城市列表
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryCitys();

	/**
	 * 查询区县
	 * 
	 * @return
	 */
	public RandomCity queryArea(String cityCode);
}
