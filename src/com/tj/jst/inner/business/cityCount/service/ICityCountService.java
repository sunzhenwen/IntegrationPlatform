package com.tj.jst.inner.business.cityCount.service;

import java.util.List;

import com.tj.jst.inner.business.cityCount.model.CityCount;


/**
 * 地市项目统计
 * 
 * @author Administrator
 *
 */
public interface ICityCountService {
	
	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<CityCount> queryCount();

}
