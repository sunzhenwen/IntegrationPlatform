package com.tj.jst.inner.randomCity.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomCity.dao.IRandomCityDao;
import com.tj.jst.inner.randomCity.dao.RandomCityDaoImpl;
import com.tj.jst.inner.randomCity.model.RandomCity;

/**
 * ������в�ѯ
 * 
 * @author Administrator
 *
 */
public class RandomCityServiceImpl implements IRandomCityService {

	/**
	 * ��ѯ�����б�
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
	 * ��ѯ����
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
