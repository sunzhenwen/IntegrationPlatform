package com.tj.jst.outside.business.survey.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.survey.model.Survey;
import com.tj.jst.outside.business.survey.model.SurveyQualification;

/**
 * ����
 * @author hhc
 *
 */
public interface ISurveyService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * �������
	 * @return
	 */
	public String add(Survey survey,List<SurveyQualification> surveyQualification);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Survey queryById(String surveyId);
	
	/**
	 * ��������޸�
	 * @return
	 */
	public void modify(Survey survey,List<SurveyQualification> surveyQualification);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String surveyId);

	
}
