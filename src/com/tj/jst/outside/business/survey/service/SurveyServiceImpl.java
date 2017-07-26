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
 * ����
 * @author hhc
 *
 */
public class SurveyServiceImpl implements ISurveyService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ISurveyDao dao = new SurveyDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * �������
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
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Survey queryById(String surveyId)
	{
		ISurveyDao dao = new SurveyDaoImpl();
		return dao.queryById(surveyId);
	}
	
	/**
	 * ��������޸�
	 * @return
	 */
	public void modify(Survey survey,List<SurveyQualification> surveyQualification)
	{
		ISurveyDao dao = new SurveyDaoImpl();
		dao.modify(survey,surveyQualification);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String surveyId)
	{
		ISurveyDao dao = new SurveyDaoImpl();
		dao.delete(surveyId);
	}

	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		ISurveyDao dao = new SurveyDaoImpl();
		return dao.queryAppDept();
	}
	
}
