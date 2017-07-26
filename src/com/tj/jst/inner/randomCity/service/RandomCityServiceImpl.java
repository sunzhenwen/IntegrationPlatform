package com.tj.jst.inner.randomCity.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomCity.dao.IRandomCityDao;
import com.tj.jst.inner.randomCity.dao.RandomCityDaoImpl;
import com.tj.jst.inner.randomCity.model.RandomCity;

/**
 * 随机地市查询
 * 
 * @author Administrator
 *
 */
public class RandomCityServiceImpl implements IRandomCityService {

	/**
	 * 查询城市列表
	 * 
	 * @return
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IRandomCityDao dao = new RandomCityDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * 查询区县
	 * 
	 * @return
	 */
	@Override
	public RandomCity queryArea(String cityCode)
	{
		// TODO Auto-generated method stub
		IRandomCityDao dao = new RandomCityDaoImpl();
		return dao.queryArea(cityCode.substring(0, 4),cityCode);
	}
}
