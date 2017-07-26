package com.tj.jst.inner.business.filingapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.filingapply.dao.FilingApplyDaoImpl;
import com.tj.jst.inner.business.filingapply.dao.IFilingApplyDao;
import com.tj.jst.inner.business.filingapply.model.ContractBusiness;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * 合同备案服务类
 * 
 * @author DarkFlameMaster
 *
 */
public class FilingApplyServiceImpl implements IFilingApplyService {

	/**
	 * 分页
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 查询审批页面
	 */
	@Override
	public ContractFiling queryApproval(String recordId) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.queryApproval(recordId);
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(ContractFiling filing) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.approvalSuccess(filing);
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String approvalFailed(ContractFiling filing) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.approvalFailed(filing);
	}

	/**
	 * 查询施工图是否完成
	 */
	@Override
	public String queryPlans(String prjNum) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.queryPlans(prjNum);
	}

	/**
	 * 均完成更改基本信息
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		dao.updateProjectInfo(prjNum);

	}

	/**
	 * 查看是否含有附件
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * 通过更改授权状态
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

	/**
	 * 查询合同信息
	 */
	@Override
	public ContractBusiness queryByConId(String conId) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.queryByConId(conId);
	}

	/**
	 * 修改合同信息
	 */
	@Override
	public String modifyContractBusiness(ContractBusiness contract) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.modifyContractBusiness(contract);
	}

	/**
	 * 增加审核记录
	 */
	@Override
	public String insertContractBusiness(ContractBusiness contract) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.insertContractBusiness(contract);
	}

	/**
	 * 合同分页
	 */
	@Override
	public Page queryBusinessPage(Condition condition) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.queryBusinessPage(condition);
	}

	@Override
	public String changeBusinessType(String recordId , String type) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.changeBusinessType(recordId , type);
	}

}
