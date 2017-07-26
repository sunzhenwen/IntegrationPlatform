package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.dao.ConstructionPlansDaoImpl;
import com.tj.jst.outside.business.constructionPlans.dao.IConstructionPlansDao;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryConstructionPlansDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryConstructionPlansDaoImpl;

/**
 * ʩ��ͼ���
 * @author hhc
 *
 */
public class QueryConstructionPlansServiceImpl implements IQueryConstructionPlansService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryConstructionPlansDao dao = new QueryConstructionPlansDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public ConstructionPlans queryById(String censorId)
	{
		IQueryConstructionPlansDao dao = new QueryConstructionPlansDaoImpl();
		return dao.queryById(censorId);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryConstructionPlansDao dao = new QueryConstructionPlansDaoImpl();
		return dao.queryAppDept();
	}
}
