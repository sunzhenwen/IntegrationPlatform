package com.tj.jst.outside.business.queryBusiness.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;
import com.tj.jst.outside.business.permit.model.Permit;

/**
 * ʩ�����
 * @author hhc
 *
 */
public interface IQueryPermitDao {
	
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
	public Permit queryById(String permitId);
	
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
	
	//֤������
	public List<DictionaryClass> queryCardTypeNums();
}
