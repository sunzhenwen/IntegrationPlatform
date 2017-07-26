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
 * ҵ���ѯ
 * 
 * @author Administrator
 *
 */
public interface IQueryProjectService {

	/**
	 * ��ѯ��ҳ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ��ѯ��Ŀ��ϸ��Ϣ
	 * 
	 * @param prjName
	 * @return
	 */
	public ProjectModel queryProjectInfo(String prjName);

	/**
	 * ʩ��ͼ�����Ϣ
	 * 
	 * @param prjNum
	 * @return
	 */
	public Page queryPlanInfo(Condition condition);

	/**
	 * ��ͬ������Ϣ
	 * 
	 * @param prjNum
	 * @return
	 */
	public Page queryFilingInfo(Condition condition);

	/**
	 * ʩ�������Ϣ
	 * 
	 * @param prjNum
	 * @return
	 */
	public Page queryPermitInfo(Condition condition);

	/**
	 * ����������Ϣ
	 * 
	 * @param prjNum
	 * @return
	 */
	public Page queryReadyInfo(Condition condition);

	/**
	 * ��ͬ����list
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Filing> queryFilingList(String prjNum);

	/**
	 * ʩ�����list
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Permit> queryPermitList(String prjNum);

	/**
	 * ʩ��ͼlist
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Plan> queryPlanList(String prjID);

	/**
	 * ��������list
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Ready> queryReadyList(String prjNum);

	/**
	 * ��Ͷ��List
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Tender> queryTenderList(String prjNum);

	/**
	 * ��ѯ��ͬ������ϸ
	 * 
	 * @param filingId
	 * @return
	 */
	public Filing queryFilingInfo(String filingId);

	/**
	 * ��ѯʩ�������ϸ
	 * 
	 * @param permitId
	 * @return
	 */
	public Permit queryPermitInfo(String permitId);

	/**
	 * ʩ��ͼ��ϸ
	 * 
	 * @param planId
	 * @return
	 */
	public Plan queryPlanInfo(String planId);

	/**
	 * ����������ϸ
	 * 
	 * @param readyId
	 * @return
	 */
	public Ready queryReadyInfo(String readyId);

	/**
	 * ��Ͷ����ϸ
	 * 
	 * @param tenderId
	 * @return
	 */
	public Tender queryTenderInfo(String tenderId);

	/**
	 * ����List
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Quality> queryQualityList(String prjNum);

	/**
	 * ������ϸ
	 * 
	 * @param qualityId
	 * @return
	 */
	public Quality queryQualityInfo(String qualityId);

	/**
	 * ��ȫ��ϸ
	 * 
	 * @param prjNum
	 * @return
	 */
	public List<Safety> querySafetyList(String prjNum);

	/**
	 * ��ѯ��ȫ����
	 * 
	 * @param safetyId
	 * @return
	 */
	public Safety querySafetyInfo(String safetyId);

	/**
	 * ��Ͷ����ϸ
	 * 
	 * @param tenderId
	 * @return
	 */
	public TenderInfo queryTenderById(String tenderNum);
	
	/**
	 *��ͬ������ϸ
	 * 
	 * @param tenderId
	 * @return
	 */
	public ContractFiling queryFilingById(String recordId);
	
	/**
	 *������ϸ
	 * 
	 * @param tenderId
	 * @return
	 */
	public Quality queryQualityById(String qualityId);
	
	/**
	 * ��ѯ��ȫ��ϸҳ��
	 * @return
	 */
	public Safety querySafetyById(String safetyId);
	
	/**
	 * ��ѯʩ�������ϸҳ��
	 * @return
	 */
	public Permit queryPermitById(String permitId);
	
	/**
	 * ��ѯʩ�������ϸҳ��
	 * @return
	 */
	public Complete queryCompleteById(String completeId);

	/**
	 * ��ѯ����������ϸҳ��
	 * @return
	 */
	public List<DictionaryClass> queryProjectTypes();
}
