package com.tj.jst.outside.business.singleProject.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.singleProject.model.SingleProject;

/**
 * ���幤��
 * @author hhc
 *
 */
public interface ISingleProjectService {
	
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
	public void add(SingleProject singleProject);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public SingleProject queryById(long spId);
	
	/**
	 * �޸�
	 * @param construction
	 * @return
	 */
	public void modify(SingleProject singleProject);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(long id);

	//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums();

}
