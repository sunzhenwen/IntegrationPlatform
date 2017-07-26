package com.tj.jst.inner.business.filingapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.filingapply.model.ContractBusiness;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * ��ͬ��������ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IFilingApplyService {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * ��ת����ҳ��
	 * 
	 * @param prjId
	 * @return
	 */
	public ContractFiling queryApproval(String recordId);

	/**
	 * ����ͨ��
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalSuccess(ContractFiling filing);

	/**
	 * ������ͨ��
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalFailed(ContractFiling filing);

	/**
	 * ������׶��Ƿ����
	 * 
	 * @param prjNum
	 * @return
	 */
	public String queryPlans(String prjNum);

	/**
	 * �������ƶ��ɹ���ɺ󣬸�����Ŀ������Ϣ
	 */
	public void updateProjectInfo(String prjNum);

	/**
	 * �鿴�Ƿ����ϴ����ļ�
	 * 
	 * @param prjId
	 * @return
	 */
	public List downloadInfo(String prjId);

	/**
	 * ͨ��������Ȩ��״̬
	 * 
	 * @param prjId
	 * @return
	 */
	public String changeAuthor(String prjId);

	/**
	 * ��ѯ��ͬģ����Ϣ
	 * 
	 * @param conId
	 * @return
	 */
	public ContractBusiness queryByConId(String conId);

	/**
	 * �޸ĺ�ͬģ����Ϣ
	 * 
	 * @param contract
	 * @return
	 */
	public String modifyContractBusiness(ContractBusiness contract);

	/**
	 * ��˼�¼��
	 * 
	 * @param contract
	 * @return
	 */
	public String insertContractBusiness(ContractBusiness contract);

	/**
	 * ��ͬ��ҳ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryBusinessPage(Condition condition);

	/**
	 * ��˲�ͨ���Ļ�״̬
	 * 
	 * @param recordId
	 * @return
	 */
	public String changeBusinessType(String recordId , String type);
}
