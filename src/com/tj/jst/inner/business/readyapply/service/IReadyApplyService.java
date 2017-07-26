package com.tj.jst.inner.business.readyapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.permit.model.Permit;

/**
 * �������ձ�������ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IReadyApplyService {

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
	public Complete queryApproval(String completeId);

	/**
	 * ����ͨ��
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalSuccess(Complete complete);

	/**
	 * ������ͨ��
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalFailed(Complete complete);

	/**
	 * ��ɺ󣬸�����Ŀ������Ϣ
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

}
