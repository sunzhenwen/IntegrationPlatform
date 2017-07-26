package com.tj.jst.inner.projectconstruction.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

public interface IProjectConstructionDao {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * ��ʷ������ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page historyPagedQuery(Condition condition);

	/**
	 * ��ת����ҳ��
	 * 
	 * @param prjId
	 * @return
	 */
	public ProjectConstruction queryApproval(String prjId);

	/**
	 * ����ͨ��
	 * 
	 * @param project
	 * @return
	 */
	public String applySuccess(ProjectConstruction project);

	/**
	 * �����˻�
	 * 
	 * @param project
	 * @return
	 */
	public String applyFaile(ProjectConstruction project);

	/**
	 * ��������
	 * 
	 * @return
	 */
	public List<ProjectConstruction> batchApplythrough(String[] ids);

	/**
	 * ������Ŀ��Ų�����Ŀ
	 * 
	 * @param prjNum
	 * @return
	 */
	public ProjectConstruction getProjectInfo(String prjNum);

	// /**
	// * ��������
	// *
	// * @param condition
	// * @return
	// */
	// public Page projectPage(Condition condition);

	/**
	 * �鿴�Ƿ����ϴ����ļ�
	 * 
	 * @param prjId
	 * @return
	 */
	public List downloadInfo(String prjId);

	/**
	 * ���µ���Ȩ��
	 * 
	 * @param project
	 * @return
	 */
	public String updateAuthor(ProjectConstruction project);

}
