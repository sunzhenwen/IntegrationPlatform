package com.tj.jst.inner.business.cityCount.dao;

import java.util.List;

import com.tj.jst.inner.business.cityCount.model.CityCount;

/**
 * 地市项目统计
 * 
 * @author Administrator
 *
 */
public interface ICityCountDao {

	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<CityCount> queryCount();
	
}
