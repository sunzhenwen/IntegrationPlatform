package com.tj.jst.inner.business.scenesafe.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.scenesafe.model.ConstruScenesafe;
import com.tj.jst.inner.business.scenesafe.model.SceneSafe;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * ʩ����ɷ���ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface ScenesafeService {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String permitid);
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	
	public SceneSafe queryById(String permitid);
	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuerypage(Condition condition);

	/**
	 * ��ת����ҳ��
	 * 
	 * @param prjId
	 * @return
	 */
	public Permit queryApproval(String permitId);
	/**
	 * �ֳ���ȫ�ල
	 * @return
	 */
	public String add(SceneSafe scenesafe, List<ConstruScenesafe> construscenesafe);
	/**
	 * �ֳ���ȫ�ල
	 * @return
	 */
	public void modify(SceneSafe scenesafe, List<ConstruScenesafe> construscenesafe);

	/**
	 * ����ͨ��
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalSuccess(Permit permit);

	/**
	 * ������ͨ��
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalFailed(Permit permit);

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
