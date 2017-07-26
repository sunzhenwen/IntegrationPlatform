package com.tj.jst.inner.projectShare.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.corpfilings.queryCorpApply.dao.IQueryCorpFilingsDao;
import com.tj.jst.inner.corpfilings.queryCorpApply.dao.QueryCorpFilingsDaoImpl;
import com.tj.jst.inner.projectShare.dao.IProjectShareDao;
import com.tj.jst.inner.projectShare.dao.ProjectShareDaoImpl;
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

/**
 * ��Ŀ��������ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public class ProjectShareServiceImpl implements IProjectShareService {

	/**
	 * ��Ŀ����
	 */
	@Override
	public Page queryConstructionPage(Condition condition) {
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryConstructionPage(condition);
	}

	/**
	 * ��Ŀ������ϸ
	 * @return
	 */
	public Construction queryConstructionInfo(String prjId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryConstructionInfo(prjId);
	}

	//-------------------------------------------------------
	
	/**
	 * ����
	 */
	public Page querySurveySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.querySurveySharePage(condition);
	}

	/**
	 * ����
	 * @return
	 */
	public Survey querySurveyShareInfo(String surveyId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.querySurveyShareInfo(surveyId);
	}
	
	//-------------------------------------------------------
	/**
	 * ���
	 */
	public Page queryDesignSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryDesignSharePage(condition);
	}

	/**
	 * ���
	 * @return
	 */
	public Design queryDesignShareInfo(String designId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryDesignShareInfo(designId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * ��ͬ����
	 */
	public Page queryFilingSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryFilingSharePage(condition);
	}

	/**
	 * ��ͬ����
	 */
	public ContractFiling queryFilingShareInfo(String recordId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryFilingShareInfo(recordId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * ʩ��ͼ���
	 */
	public Page queryPlanSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryPlanSharePage(condition);
	}

	/**
	 * ʩ��ͼ���
	 */
	public ConstructionPlans queryPlanShareInfo(String censorId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryPlanShareInfo(censorId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * �����ල
	 */
	public Page queryQualitySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryQualitySharePage(condition);
	}

	/**
	 * �����ල
	 */
	public Quality queryQualityShareInfo(String qualityId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryQualityShareInfo(qualityId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * ��ȫ�ල
	 */
	public Page querySafetySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.querySafetySharePage(condition);
	}

	/**
	 * ��ȫ�ල
	 */
	public Safety querySafetyInfo(String safetyId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.querySafetyInfo(safetyId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * ʩ�����
	 */
	public Page queryPromiseSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryPromiseSharePage(condition);
	}

	/**
	 * ʩ�����
	 */
	public Permit queryPromiseShareInfo(String permitId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryPromiseShareInfo(permitId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * ��������
	 */
	public Page queryReadySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryReadySharePage(condition);
	}

	/**
	 * ��������
	 */
	public Complete queryReadyShareInfo(String completeId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryReadyShareInfo(completeId);
	}
	
	public Corp queryCorpInfo(String corpCode)
	{
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryCorpInfo(corpCode);
	}
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryCity(provinceId);
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryArea(cityId);
	}
	
	//��ѯ��������Ȩ����
	public List<DictionaryClass> queryApprovalCity()
	{
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryApprovalCity();
	}
	
	//��ѯ��������Ȩ����/��
	public List<DictionaryClass> queryApprovaArea(String approvalCityId)
	{
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryApprovaArea(approvalCityId);
	}
}
