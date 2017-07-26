package com.tj.jst.inner.business.cityCount.service;

import java.util.List;

import com.tj.jst.inner.business.cityCount.dao.CityCountDaoImpl;
import com.tj.jst.inner.business.cityCount.dao.ICityCountDao;
import com.tj.jst.inner.business.cityCount.model.CityCount;

/**
 * 地市项目统计
 * 
 * @author Administrator
 *
 */
public class CityCountServiceImpl implements ICityCountService {

	@Override
	public List<CityCount> queryCount() {
		// TODO Auto-generated method stub
		ICityCountDao dao = new CityCountDaoImpl();
		return dao.queryCount();
	}

}
