package com.tj.jst.inner.business.qualityapply.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * �����������ݿ�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQualityApplyDao {

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
	public Quality queryApproval(String qualityId);

	/**
	 * ����ͨ��
	 * 
	 * @param project
	 * @return
	 */
	public String applySuccess(Quality qu);

	/**
	 * �����˻�
	 * 
	 * @param project
	 * @return
	 */
	public String applyFaile(Quality qu);

	/**
	 * ��鰲ȫ����׶��Ƿ����
	 * 
	 * @param prjNum
	 * @return
	 */
	public String querySafety(String prjNum);

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
