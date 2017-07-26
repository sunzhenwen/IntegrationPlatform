package com.tj.jst.inner.business.planapply.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.designapply.model.DesignApply;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;

/**
 * ��ͬ�����ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IPlanApplyDao {

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
	public ConstructionPlans queryApproval(String censorId);

	/**
	 * ����ͨ��
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalSuccess(ConstructionPlans plan);

	/**
	 * ������ͨ��
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalFailed(ConstructionPlans plan);

	/**
	 * ������׶��Ƿ����
	 * 
	 * @param prjNum
	 * @return
	 */
	public String queryFiling(String prjNum);

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

}
