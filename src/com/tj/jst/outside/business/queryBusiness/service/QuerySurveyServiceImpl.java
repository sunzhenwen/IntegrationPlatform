package com.tj.jst.outside.business.queryBusiness.service;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.queryBusiness.dao.IQuerySurveyDao;
import com.tj.jst.outside.business.queryBusiness.dao.QuerySurveyDaoImpl;
import com.tj.jst.outside.business.survey.dao.ISurveyDao;
import com.tj.jst.outside.business.survey.dao.SurveyDaoImpl;
import com.tj.jst.outside.business.survey.model.Survey;

/**
 * ����
 * @author hhc
 *
 */
public class QuerySurveyServiceImpl implements IQuerySurveyService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQuerySurveyDao dao = new QuerySurveyDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Survey queryById(String surveyId)
	{
		IQuerySurveyDao dao = new QuerySurveyDaoImpl();
		return dao.queryById(surveyId);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQuerySurveyDao dao = new QuerySurveyDaoImpl();
		return dao.queryAppDept();
	}
	
}
