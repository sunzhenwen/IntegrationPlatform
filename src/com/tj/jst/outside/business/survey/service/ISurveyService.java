package com.tj.jst.outside.business.survey.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.survey.model.Survey;
import com.tj.jst.outside.business.survey.model.SurveyQualification;

/**
 * 勘察
 * @author hhc
 *
 */
public interface ISurveyService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 设计申请
	 * @return
	 */
	public String add(Survey survey,List<SurveyQualification> surveyQualification);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Survey queryById(String surveyId);
	
	/**
	 * 设计申请修改
	 * @return
	 */
	public void modify(Survey survey,List<SurveyQualification> surveyQualification);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String surveyId);

	
}
