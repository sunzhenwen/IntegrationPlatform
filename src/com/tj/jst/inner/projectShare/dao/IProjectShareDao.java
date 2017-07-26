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
	 * 项目报建
	 */
	public Page queryConstructionPage(Condition condition);

	/**
	 * 项目报建详细
	 * @return
	 */
	public Construction queryConstructionInfo(String prjId);
	
	//-------------------------------------------------------
	
	/**
	 * 勘察
	 */
	public Page querySurveySharePage(Condition condition);

	/**
	 * 勘察
	 * @return
	 */
	public Survey querySurveyShareInfo(String surveyId);
	
	//-------------------------------------------------------
	
	/**
	 * 设计
	 */
	public Page queryDesignSharePage(Condition condition);

	/**
	 * 设计
	 * @return
	 */
	public Design queryDesignShareInfo(String designId);
	
	//-------------------------------------------------------
	
	/**
	 * 合同备案
	 */
	public Page queryFilingSharePage(Condition condition);

	/**
	 * 合同备案
	 */
	public ContractFiling queryFilingShareInfo(String recordId);
	
	//-------------------------------------------------------
	
	/**
	 * 施工图审查
	 */
	public Page queryPlanSharePage(Condition condition);

	/**
	 * 施工图审查
	 */
	public ConstructionPlans queryPlanShareInfo(String censorId);
	
	//-------------------------------------------------------
	
	/**
	 * 质量监督
	 */
	public Page queryQualitySharePage(Condition condition);

	/**
	 * 质量监督
	 */
	public Quality queryQualityShareInfo(String qualityId);
	
	//-------------------------------------------------------
	
	/**
	 * 安全监督
	 */
	public Page querySafetySharePage(Condition condition);

	/**
	 * 安全监督
	 */
	public Safety querySafetyInfo(String safetyId);
	
	//-------------------------------------------------------
	
	/**
	 * 施工许可
	 */
	public Page queryPromiseSharePage(Condition condition);

	/**
	 * 施工许可
	 */
	public Permit queryPromiseShareInfo(String permitId);
	
	//-------------------------------------------------------
	
	/**
	 * 竣工验收
	 */
	public Page queryReadySharePage(Condition condition);

	/**
	 * 竣工验收
	 */
	public Complete queryReadyShareInfo(String completeId);
	
	public Corp queryCorpInfo(String corpCode);
	
	//查询省
	public List<DictionaryClass> queryProvince();

	//查询市
	public List<DictionaryClass> queryCity(String provinceId);
	
	//查询区
	public List<DictionaryClass> queryArea(String cityId);
	
	//查询具有审批权的市
	public List<DictionaryClass> queryApprovalCity();
	
	//查询具有审批权的区/县
	public List<DictionaryClass> queryApprovaArea(String approvalCityId);
}
