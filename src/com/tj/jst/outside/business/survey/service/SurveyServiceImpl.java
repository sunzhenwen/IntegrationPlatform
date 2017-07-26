package com.tj.jst.outside.business.survey.service;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.survey.dao.ISurveyDao;
import com.tj.jst.outside.business.survey.dao.SurveyDaoImpl;
import com.tj.jst.outside.business.survey.model.Survey;
import com.tj.jst.outside.business.survey.model.SurveyQualification;

/**
 * 勘察
 * @author hhc
 *
 */
public class SurveyServiceImpl implements ISurveyService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ISurveyDao dao = new SurveyDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 设计申请
	 * @return
	 */
	public String add(Survey survey,List<SurveyQualification> surveyQualification)
	{
		ISurveyDao dao = new SurveyDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 2);
		String surveyNum = survey.getAppDept() + fDate
				+ survey.getPrjNum().substring(12, 16) + "-HB-" + serNum;
		survey.setSurveyNum(surveyNum);
		return dao.add(survey,surveyQualification);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Survey queryById(String surveyId)
	{
		ISurveyDao dao = new SurveyDaoImpl();
		return dao.queryById(surveyId);
	}
	
	/**
	 * 设计申请修改
	 * @return
	 */
	public void modify(Survey survey,List<SurveyQualification> surveyQualification)
	{
		ISurveyDao dao = new SurveyDaoImpl();
		dao.modify(survey,surveyQualification);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String surveyId)
	{
		ISurveyDao dao = new SurveyDaoImpl();
		dao.delete(surveyId);
	}

	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		ISurveyDao dao = new SurveyDaoImpl();
		return dao.queryAppDept();
	}
	
}
