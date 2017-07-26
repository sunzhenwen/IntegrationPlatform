package com.tj.jst.outside.business.queryBusiness.service;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.design.dao.DesignDaoImpl;
import com.tj.jst.outside.business.design.dao.IDesignDao;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryDesignDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryDesignDaoImpl;

/**
 * 设计
 * @author hhc
 *
 */
public class QueryDesignServiceImpl implements IQueryDesignService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryDesignDao dao = new QueryDesignDaoImpl();
		return dao.pagedQuery(condition);
	}	

	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Design queryById(String designId)
	{
		IQueryDesignDao dao = new QueryDesignDaoImpl();
		return dao.queryById(designId);
	}
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryDesignDao dao = new QueryDesignDaoImpl();
		return dao.queryAppDept();
	}
	
}
