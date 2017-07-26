package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.quality.dao.IQualityDao;
import com.tj.jst.outside.business.quality.dao.QualityDaoImpl;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryQualityDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryQualityDaoImpl;

/**
 * �����ල
 * @author hhc
 *
 */
public class QueryQualityServiceImpl implements IQueryQualityService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryQualityDao dao = new QueryQualityDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Quality queryById(String qualityId)
	{
		IQueryQualityDao dao = new QueryQualityDaoImpl();
		return dao.queryById(qualityId);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryQualityDao dao = new QueryQualityDaoImpl();
		return dao.queryAppDept();
	}
}
