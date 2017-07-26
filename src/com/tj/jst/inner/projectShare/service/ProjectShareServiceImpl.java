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
 * 项目报建服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public class ProjectShareServiceImpl implements IProjectShareService {

	/**
	 * 项目报建
	 */
	@Override
	public Page queryConstructionPage(Condition condition) {
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryConstructionPage(condition);
	}

	/**
	 * 项目报建详细
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
	 * 勘察
	 */
	public Page querySurveySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.querySurveySharePage(condition);
	}

	/**
	 * 勘察
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
	 * 设计
	 */
	public Page queryDesignSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryDesignSharePage(condition);
	}

	/**
	 * 设计
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
	 * 合同备案
	 */
	public Page queryFilingSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryFilingSharePage(condition);
	}

	/**
	 * 合同备案
	 */
	public ContractFiling queryFilingShareInfo(String recordId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryFilingShareInfo(recordId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * 施工图审查
	 */
	public Page queryPlanSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryPlanSharePage(condition);
	}

	/**
	 * 施工图审查
	 */
	public ConstructionPlans queryPlanShareInfo(String censorId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryPlanShareInfo(censorId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * 质量监督
	 */
	public Page queryQualitySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryQualitySharePage(condition);
	}

	/**
	 * 质量监督
	 */
	public Quality queryQualityShareInfo(String qualityId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryQualityShareInfo(qualityId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * 安全监督
	 */
	public Page querySafetySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.querySafetySharePage(condition);
	}

	/**
	 * 安全监督
	 */
	public Safety querySafetyInfo(String safetyId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.querySafetyInfo(safetyId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * 施工许可
	 */
	public Page queryPromiseSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryPromiseSharePage(condition);
	}

	/**
	 * 施工许可
	 */
	public Permit queryPromiseShareInfo(String permitId)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryPromiseShareInfo(permitId);
	}
	
	//-------------------------------------------------------
	
	/**
	 * 竣工验收
	 */
	public Page queryReadySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryReadySharePage(condition);
	}

	/**
	 * 竣工验收
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
	
	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryProvince();
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryCity(provinceId);
	}

	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IQueryCorpFilingsDao dao = new QueryCorpFilingsDaoImpl();
		return dao.queryArea(cityId);
	}
	
	//查询具有审批权的市
	public List<DictionaryClass> queryApprovalCity()
	{
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryApprovalCity();
	}
	
	//查询具有审批权的区/县
	public List<DictionaryClass> queryApprovaArea(String approvalCityId)
	{
		IProjectShareDao dao = new ProjectShareDaoImpl();
		return dao.queryApprovaArea(approvalCityId);
	}
}
