package com.tj.jst.outside.business.singleProject.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.singleProject.dao.ISingleProjectDao;
import com.tj.jst.outside.business.singleProject.dao.SingleProjectDaoImpl;
import com.tj.jst.outside.business.singleProject.model.SingleProject;

/**
 * ���幤��
 * @author hhc
 *
 */
public class SingleProjectServiceImpl implements ISingleProjectService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ���
	 * @param construction
	 * @return
	 */
	public void add(SingleProject singleProject)
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		dao.add(singleProject);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public SingleProject queryById(long spId)
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		SingleProject sp = dao.queryById(spId);
		//��ȡ��λ����
		String spNum = sp.getSpNum();
		if(spNum.contains("-"))
		{
			int end = spNum.indexOf("-");
			//��ȡ���幤�̱��
			String subSpNum = spNum.substring(0, end);
			sp.setPrjNum(subSpNum);
		}else
		{
			
			String subSpNum = spNum.substring(0, 15);
			sp.setPrjNum(subSpNum);
		}
		
		return sp;
	}
	
	/**
	 * �޸�
	 * @param construction
	 * @return
	 */
	public void modify(SingleProject singleProject)
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		dao.modify(singleProject);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(long id)
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		dao.delete(id);
	}

	//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		return dao.queryPrjStructureTypeNums();
	}


}
