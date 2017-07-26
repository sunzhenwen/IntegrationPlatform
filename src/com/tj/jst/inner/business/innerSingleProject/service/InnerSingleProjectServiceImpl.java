package com.tj.jst.inner.business.innerSingleProject.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.innerSingleProject.dao.IInnerSingleProjectDao;
import com.tj.jst.inner.business.innerSingleProject.dao.InnerSingleProjectDaoImpl;
import com.tj.jst.inner.business.innerSingleProject.model.InnerSingleProject;
import com.tj.jst.outside.business.singleProject.dao.ISingleProjectDao;
import com.tj.jst.outside.business.singleProject.dao.SingleProjectDaoImpl;
import com.tj.jst.outside.business.singleProject.model.SingleProject;

/**
 * ���幤��
 * @author sunzw
 *
 */
public class InnerSingleProjectServiceImpl implements IInnerSingleProjectService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IInnerSingleProjectDao dao = new InnerSingleProjectDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ���
	 * @param construction
	 * @return
	 */
	public void add(InnerSingleProject singleProject)
	{
		IInnerSingleProjectDao dao = new InnerSingleProjectDaoImpl();
		dao.add(singleProject);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public InnerSingleProject queryById(Long spId)
	{
		IInnerSingleProjectDao dao = new InnerSingleProjectDaoImpl();
		InnerSingleProject sp = dao.queryById(spId);
		//��ȡ��λ����
		String spNum = sp.getSpNum();
		int end = spNum.indexOf("-");
		//��ȡ���幤�̱��
		String subSpNum = spNum.substring(0, end);
		sp.setPrjNum(subSpNum);
		return sp;
	}
	
	/**
	 * �޸�
	 * @param construction
	 * @return
	 */
	public void modify(InnerSingleProject singleProject)
	{
		IInnerSingleProjectDao dao = new InnerSingleProjectDaoImpl();
		dao.modify(singleProject);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(Long id)
	{
		IInnerSingleProjectDao dao = new InnerSingleProjectDaoImpl();
		dao.delete(id);
	}

	//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		IInnerSingleProjectDao dao = new InnerSingleProjectDaoImpl();
		return dao.queryPrjStructureTypeNums();
	}


}
