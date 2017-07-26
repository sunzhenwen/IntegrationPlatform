package com.tj.jst.inner.business.innerSingleProject.service;

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
public interface IInnerSingleProjectService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ���
	 * @param construction
	 * @return
	 */
	public void add(InnerSingleProject innerSingleProject);
	
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
	public void modify(InnerSingleProject innerSingleProject);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(Long id);

	//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums();

}
