package com.tj.jst.inner.business.cityCount.service;

import java.util.List;

import com.tj.jst.inner.business.cityCount.model.CityCount;


/**
 * ������Ŀͳ��
 * 
 * @author Administrator
 *
 */
public interface ICityCountService {
	
	/**
	 * ��ѯ
	 * 
	 * @return
	 */
	public List<CityCount> queryCount();

}
