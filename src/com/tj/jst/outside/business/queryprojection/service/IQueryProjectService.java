package com.tj.jst.outside.business.queryprojection.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.queryprojection.model.Filing;
import com.tj.jst.outside.business.queryprojection.model.Permit;
import com.tj.jst.outside.business.queryprojection.model.Plan;
import com.tj.jst.outside.business.queryprojection.model.ProjectModel;
import com.tj.jst.outside.business.queryprojection.model.Ready;
import com.tj.jst.outside.business.queryprojection.model.Tender;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;

/**
 * 业务查询
 * 
 * @author Administrator
 *
 */
public interface IQueryProjectService {

	/**
	 * 查询分页
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查询项目详细信息
	 * 
	 * @param prjName
	 * @return
	 */
	public ProjectModel queryProjectInfo(String prjName);

	/**
	 * 施工图审查信息
	 * 
	 * @param prjNum
	 * @return
	 */
	public Page queryPlanInfo(Condition condition);

	/**
	 * 合同备案信息
	 * 
	 * @param prjNum
	 * @return
	 */
	public Page queryFilingInfo(Condition condition);

	/**
	 * 施工许可信息
	 * 
	 * @param prjNum
	 * @return
	 */
	public Page queryPermitInfo(Condition condition);

	/**
	 * 竣工验收信息
	 * 
	 * @param prjNum
	 * @return
	 */
	public Page queryReadyInfo(Condition condition);

	/**
	 * 合同备案list
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Filing> queryFilingList(String prjNum);

	/**
	 * 施工许可list
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Permit> queryPermitList(String prjNum);

	/**
	 * 施工图list
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Plan> queryPlanList(String prjID);

	/**
	 * 竣工验收list
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Ready> queryReadyList(String prjNum);

	/**
	 * 招投标List
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Tender> queryTenderList(String prjNum);

	/**
	 * 查询合同备案详细
	 * 
	 * @param filingId
	 * @return
	 */
	public Filing queryFilingInfo(String filingId);

	/**
	 * 查询施工许可详细
	 * 
	 * @param permitId
	 * @return
	 */
	public Permit queryPermitInfo(String permitId);

	/**
	 * 施工图详细
	 * 
	 * @param planId
	 * @return
	 */
	public Plan queryPlanInfo(String planId);

	/**
	 * 竣工验收详细
	 * 
	 * @param readyId
	 * @return
	 */
	public Ready queryReadyInfo(String readyId);

	/**
	 * 招投标详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public Tender queryTenderInfo(String tenderId);

	/**
	 * 质量List
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Quality> queryQualityList(String prjNum);

	/**
	 * 质量详细
	 * 
	 * @param qualityId
	 * @return
	 */
	public Quality queryQualityInfo(String qualityId);

	/**
	 * 安全详细
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Safety> querySafetyList(String prjNum);

	/**
	 * 查询安全像你
	 * 
	 * @param safetyId
	 * @return
	 */
	public Safety querySafetyInfo(String safetyId);

	/**
	 * 招投标详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public TenderInfo queryTenderById(String tenderNum);
	
	/**
	 *合同备案详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public ContractFiling queryFilingById(String recordId);
	
	/**
	 *质量详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public Quality queryQualityById(String qualityId);
	
	/**
	 * 查询安全详细页面
	 * @return
	 */
	public Safety querySafetyById(String safetyId);
	
	/**
	 * 查询施工许可详细页面
	 * @return
	 */
	public Permit queryPermitById(String permitId);
	
	/**
	 * 查询施工许可详细页面
	 * @return
	 */
	public Complete queryCompleteById(String completeId);

	/**
	 * 查询工程类型详细页面
	 * @return
	 */
	public List<DictionaryClass> queryProjectTypes();
}
