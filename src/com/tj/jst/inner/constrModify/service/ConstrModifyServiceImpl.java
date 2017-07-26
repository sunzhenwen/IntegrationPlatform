package com.tj.jst.inner.constrModify.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.constrModify.dao.ConstrModifyDaoImpl;
import com.tj.jst.inner.constrModify.dao.IConstrModifyDao;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

/**
 * ��Ŀ�����޸�,���ܲ����޸�
 * 
 * @author hhc
 *
 */
public class ConstrModifyServiceImpl implements IConstrModifyService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IConstrModifyDao dao = new ConstrModifyDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ��ת�޸�ҳ��
	 * 
	 * @return
	 */
	@Override
	public ProjectConstruction queryById(String prjId) {
		// TODO Auto-generated method stub
		IConstrModifyDao dao = new ConstrModifyDaoImpl();
		return dao.queryById(prjId);
	}

	/**
	 * �޸�
	 */
	public void update(ProjectConstruction project)
	{
		IConstrModifyDao dao = new ConstrModifyDaoImpl();
		dao.update(project);
	}
}
