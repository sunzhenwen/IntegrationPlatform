package com.tj.jst.inner.business.filingapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.filingapply.dao.FilingApplyDaoImpl;
import com.tj.jst.inner.business.filingapply.dao.IFilingApplyDao;
import com.tj.jst.inner.business.filingapply.model.ContractBusiness;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * ��ͬ����������
 * 
 * @author DarkFlameMaster
 *
 */
public class FilingApplyServiceImpl implements IFilingApplyService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ѯ����ҳ��
	 */
	@Override
	public ContractFiling queryApproval(String recordId) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.queryApproval(recordId);
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String approvalSuccess(ContractFiling filing) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.approvalSuccess(filing);
	}

	/**
	 * ������ͨ��
	 */
	@Override
	public String approvalFailed(ContractFiling filing) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.approvalFailed(filing);
	}

	/**
	 * ��ѯʩ��ͼ�Ƿ����
	 */
	@Override
	public String queryPlans(String prjNum) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.queryPlans(prjNum);
	}

	/**
	 * ����ɸ��Ļ�����Ϣ
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		dao.updateProjectInfo(prjNum);

	}

	/**
	 * �鿴�Ƿ��и���
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.downloadInfo(prjId);
	}

	/**
	 * ͨ��������Ȩ״̬
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.changeAuthor(prjId);
	}

	/**
	 * ��ѯ��ͬ��Ϣ
	 */
	@Override
	public ContractBusiness queryByConId(String conId) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.queryByConId(conId);
	}

	/**
	 * �޸ĺ�ͬ��Ϣ
	 */
	@Override
	public String modifyContractBusiness(ContractBusiness contract) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.modifyContractBusiness(contract);
	}

	/**
	 * ������˼�¼
	 */
	@Override
	public String insertContractBusiness(ContractBusiness contract) {
		// TODO Auto-generated method stub
		IFilingApplyDao dao = new FilingApplyDaoImpl();
		return dao.insertContractBusiness(contract);
	}

	/**
	 * ��ͬ��ҳ
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
