package com.tj.jst.inner.business.designapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.designapply.model.DesignApply;

/**
 * ��Ŀ��ƽ׶νӿ���
 * 
 * @author DarkFlameMaster
 *
 */
public interface IDesignApplyService {

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
	public DesignApply queryApproval(String designId);

	/**
	 * ����ͨ��
	 * 
	 * @param project
	 * @return
	 */
	public String applySuccess(DesignApply design);

	/**
	 * �����˻�
	 * 
	 * @param project
	 * @return
	 */
	public String applyFaile(DesignApply design);

	/**
	 * ��鿱��׶��Ƿ����
	 * 
	 * @param prjNum
	 * @return
	 */
	public String querySurvey(String prjNum);

	/**
	 * �������ƶ��ɹ���ɺ󣬸�����Ŀ������Ϣ
	 */
	public void updateProjectInfo(String prjNum);

	/**
	 * ������ҳ
	 * 
	 * @param desingId
	 * @return
	 */
	public Page sidebyPage(Condition condition);
	
	/**
	 * �鿴�Ƿ����ϴ����ļ�
	 * 
	 * @param prjId
	 * @return
	 */
	public List downloadInfo(String prjId);
}
