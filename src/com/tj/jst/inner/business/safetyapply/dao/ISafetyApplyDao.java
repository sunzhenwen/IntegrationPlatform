package com.tj.jst.inner.business.safetyapply.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * ��ȫ�������ݿ�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface ISafetyApplyDao {

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
	public Safety queryApproval(String safetyId);

	/**
	 * ����ͨ��
	 * 
	 * @param project
	 * @return
	 */
	public String applySuccess(Safety safe);

	/**
	 * �����˻�
	 * 
	 * @param project
	 * @return
	 */
	public String applyFaile(Safety safe);

	/**
	 * ��鰲ȫ����׶��Ƿ����
	 * 
	 * @param prjNum
	 * @return
	 */
	public String queryQuality(String prjNum);

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
	 * ��ѯ��������
	 * 
	 * @param typeNum
	 * @return
	 */
	public String queryTypeName(String typeNum);
	
	/**
	 * ͨ��������Ȩ��״̬
	 * 
	 * @param prjId
	 * @return
	 */
	public String changeAuthor(String prjId);
}
