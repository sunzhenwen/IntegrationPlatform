package com.tj.jst.outside.business.queryprojection.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.queryprojection.dao.IQueryProjectDao;
import com.tj.jst.outside.business.queryprojection.dao.QueryProjectDaoImpl;
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
public class QueryProjectServiceImpl implements IQueryProjectService {

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryPage(condition);
	}

	@Override
	public ProjectModel queryProjectInfo(String prjName) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryProjectInfo(prjName);
	}

	@Override
	public Page queryPlanInfo(Condition condition) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryPlanInfo(condition);
	}

	@Override
	public Page queryFilingInfo(Condition condition) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryFilingInfo(condition);
	}

	@Override
	public Page queryPermitInfo(Condition condition) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryPermitInfo(condition);
	}

	@Override
	public Page queryReadyInfo(Condition condition) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryReadyInfo(condition);
	}

	@Override
	public List<Filing> queryFilingList(String prjNum) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryFilingList(prjNum);
	}

	@Override
	public List<Permit> queryPermitList(String prjNum) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryPermitList(prjNum);
	}

	@Override
	public List<Plan> queryPlanList(String prjID) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryPlanList(prjID);
	}

	@Override
	public List<Ready> queryReadyList(String prjNum) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryReadyList(prjNum);
	}

	@Override
	public List<Tender> queryTenderList(String prjNum) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryTenderList(prjNum);
	}

	@Override
	public Filing queryFilingInfo(String filingId) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryFilingInfo(filingId);
	}

	@Override
	public Permit queryPermitInfo(String permitId) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryPermitInfo(permitId);
	}

	@Override
	public Plan queryPlanInfo(String planId) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryPlanInfo(planId);
	}

	@Override
	public Ready queryReadyInfo(String readyId) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryReadyInfo(readyId);
	}

	@Override
	public Tender queryTenderInfo(String tenderId) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryTenderInfo(tenderId);
	}

	@Override
	public List<Quality> queryQualityList(String prjNum) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryQualityList(prjNum);
	}

	@Override
	public Quality queryQualityInfo(String qualityId) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryQualityInfo(qualityId);
	}

	@Override
	public List<Safety> querySafetyList(String prjNum) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.querySafetyList(prjNum);
	}

	@Override
	public Safety querySafetyInfo(String safetyId) {
		// TODO Auto-generated method stub
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.querySafetyInfo(safetyId);
	}

	/**
	 * 招投标详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public TenderInfo queryTenderById(String tenderNum)
	{
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryTenderById(tenderNum);
	}
	
	/**
	 *合同备案详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public ContractFiling queryFilingById(String recordId)
	{
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryFilingById(recordId);
	}
	
	/**
	 *质量详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public Quality queryQualityById(String qualityId)
	{
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryQualityById(qualityId);
	}
	
	/**
	 * 查询安全详细页面
	 * @return
	 */
	public Safety querySafetyById(String safetyId)
	{
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.querySafetyById(safetyId);
	}
	
	/**
	 * 查询施工许可详细页面
	 * @return
	 */
	public Permit queryPermitById(String permitId)
	{
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryPermitById(permitId);
	}
	
	/**
	 * 查询施工许可详细页面
	 * @return
	 */
	public Complete queryCompleteById(String completeId)
	{
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryCompleteById(completeId);
	}
	
	/**
	 * 查询工程类型详细
	 */
	@Override
	public List<DictionaryClass> queryProjectTypes() {
		IQueryProjectDao dao = new QueryProjectDaoImpl();
		return dao.queryProjectTypes();
	}
}
