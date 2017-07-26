package com.tj.jst.inner.projectShare.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.survey.model.Survey;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public interface IProjectShareDao {

	/**
	 * ��Ŀ����
	 */
	public Page queryConstructionPage(Condition condition);

	/**
	 * ��Ŀ������ϸ
	 * @return
	 */
	public Construction queryConstructionInfo(String prjId);
	
	//-------------------------------------------------------
	
	/**
	 * ����
	 */
	public Page querySurveySharePage(Condition condition);

	/**
	 * ����
	 * @return
	 */
	public Survey querySurveyShareInfo(String surveyId);
	
	//-------------------------------------------------------
	
	/**
	 * ���
	 */
	public Page queryDesignSharePage(Condition condition);

	/**
	 * ���
	 * @return
	 */
	public Design queryDesignShareInfo(String designId);
	
	//-------------------------------------------------------
	
	/**
	 * ��ͬ����
	 */
	public Page queryFilingSharePage(Condition condition);

	/**
	 * ��ͬ����
	 */
	public ContractFiling queryFilingShareInfo(String recordId);
	
	//-------------------------------------------------------
	
	/**
	 * ʩ��ͼ���
	 */
	public Page queryPlanSharePage(Condition condition);

	/**
	 * ʩ��ͼ���
	 */
	public ConstructionPlans queryPlanShareInfo(String censorId);
	
	//-------------------------------------------------------
	
	/**
	 * �����ල
	 */
	public Page queryQualitySharePage(Condition condition);

	/**
	 * �����ල
	 */
	public Quality queryQualityShareInfo(String qualityId);
	
	//-------------------------------------------------------
	
	/**
	 * ��ȫ�ල
	 */
	public Page querySafetySharePage(Condition condition);

	/**
	 * ��ȫ�ල
	 */
	public Safety querySafetyInfo(String safetyId);
	
	//-------------------------------------------------------
	
	/**
	 * ʩ�����
	 */
	public Page queryPromiseSharePage(Condition condition);

	/**
	 * ʩ�����
	 */
	public Permit queryPromiseShareInfo(String permitId);
	
	//-------------------------------------------------------
	
	/**
	 * ��������
	 */
	public Page queryReadySharePage(Condition condition);

	/**
	 * ��������
	 */
	public Complete queryReadyShareInfo(String completeId);
	
	public Corp queryCorpInfo(String corpCode);
	
	//��ѯʡ
	public List<DictionaryClass> queryProvince();

	//��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);
	
	//��ѯ��
	public List<DictionaryClass> queryArea(String cityId);
	
	//��ѯ��������Ȩ����
	public List<DictionaryClass> queryApprovalCity();
	
	//��ѯ��������Ȩ����/��
	public List<DictionaryClass> queryApprovaArea(String approvalCityId);
}
