package com.tj.jst.inner.business.surveyapply.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.surveyapply.model.SurveyApply;

/**
 * ����׶�Dao�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface ISurveyApplyDao {

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
	public SurveyApply queryApproval(String surveyId);

	/**
	 * ����ͨ��
	 * 
	 * @param project
	 * @return
	 */
	public String applySuccess(SurveyApply design);

	/**
	 * �����˻�
	 * 
	 * @param project
	 * @return
	 */
	public String applyFaile(SurveyApply design);

	/**
	 * �����ƽ׶��Ƿ����
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
