package com.tj.jst.inner.business.cityCount.dao;

import java.util.List;

import com.tj.jst.inner.business.cityCount.model.CityCount;

/**
 * ������Ŀͳ��
 * 
 * @author Administrator
 *
 */
public interface ICityCountDao {

	/**
	 * ��ѯ
	 * 
	 * @return
	 */
	public List<CityCount> queryCount();
	
}
