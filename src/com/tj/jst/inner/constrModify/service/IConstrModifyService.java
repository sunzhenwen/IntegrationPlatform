package com.tj.jst.inner.constrModify.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

/**
 * ��Ŀ�����޸�,���ܲ����޸�
 * 
 * @author hhc
 *
 */
public interface IConstrModifyService {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * ��ת�޸�ҳ��
	 * 
	 * @return
	 */
	public ProjectConstruction queryById(String prjId);

	/**
	 * �޸�
	 */
	public void update(ProjectConstruction project);
}