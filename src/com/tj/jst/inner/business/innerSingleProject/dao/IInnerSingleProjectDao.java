package com.tj.jst.inner.business.innerSingleProject.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.innerSingleProject.model.InnerSingleProject;

/**
 * ���幤��
 * @author sunzw
 *
 */
public interface IInnerSingleProjectDao {
	
	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ���
	 * @param construction
	 * @return
	 */
	public void add(InnerSingleProject singleProject);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public InnerSingleProject queryById(Long spId);
	
	/**
	 * �޸�
	 * @param construction
	 * @return
	 */
	public void modify(InnerSingleProject singleProject);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(Long id);
	
	//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums();

}
