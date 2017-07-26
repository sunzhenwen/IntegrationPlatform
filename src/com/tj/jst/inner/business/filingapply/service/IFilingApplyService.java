package com.tj.jst.inner.business.filingapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.filingapply.model.ContractBusiness;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * 合同备案服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IFilingApplyService {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * 跳转审批页面
	 * 
	 * @param prjId
	 * @return
	 */
	public ContractFiling queryApproval(String recordId);

	/**
	 * 审批通过
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalSuccess(ContractFiling filing);

	/**
	 * 审批不通过
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalFailed(ContractFiling filing);

	/**
	 * 检查审查阶段是否完成
	 * 
	 * @param prjNum
	 * @return
	 */
	public String queryPlans(String prjNum);

	/**
	 * 勘察和设计都成功完成后，更改项目基本信息
	 */
	public void updateProjectInfo(String prjNum);

	/**
	 * 查看是否有上传的文件
	 * 
	 * @param prjId
	 * @return
	 */
	public List downloadInfo(String prjId);

	/**
	 * 通过更改授权表状态
	 * 
	 * @param prjId
	 * @return
	 */
	public String changeAuthor(String prjId);

	/**
	 * 查询合同模板信息
	 * 
	 * @param conId
	 * @return
	 */
	public ContractBusiness queryByConId(String conId);

	/**
	 * 修改合同模板信息
	 * 
	 * @param contract
	 * @return
	 */
	public String modifyContractBusiness(ContractBusiness contract);

	/**
	 * 审核记录表
	 * 
	 * @param contract
	 * @return
	 */
	public String insertContractBusiness(ContractBusiness contract);

	/**
	 * 合同分页
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryBusinessPage(Condition condition);

	/**
	 * 审核不通过改回状态
	 * 
	 * @param recordId
	 * @return
	 */
	public String changeBusinessType(String recordId , String type);
}
