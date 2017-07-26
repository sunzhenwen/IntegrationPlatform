package com.tj.jst.inner.business.surveyapply.condition;

import com.tj.jst.base.page.Condition;

public class SurveyQualificationCondition extends Condition{
	
	private String surveyId;//Ö÷¼ü
	
	public SurveyQualificationCondition(String surveyId){
		this.surveyId = surveyId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where surveyId = '" + surveyId
				+ "' ");
		String sql = "select * from SURVEY_QUALIFICATION  " + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where surveyId = '" + surveyId
				+ "' ");
		String sqlCount = "select count(*) from SURVEY_QUALIFICATION "
				+ sb.toString();
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
	}

}
