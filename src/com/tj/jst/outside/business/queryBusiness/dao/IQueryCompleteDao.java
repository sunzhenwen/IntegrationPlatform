package com.tj.jst.outside.business.queryBusiness.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * ��������
 * @author hhc
 *
 */
public interface IQueryCompleteDao {
	
	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Complete queryById(String completeId);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	/**
	 * ������������id��ѯ�������
	 * @param appDept
	 * @return
	 */
	public String queryAppDeptId(String appDept);
	
	//�ṹ��ϵ
	public List<DictionaryClass> queryPrjStructureTypeNums();
}
