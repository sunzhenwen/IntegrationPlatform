package com.tj.jst.outside.business.queryBusiness.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * ��Ŀ����
 * @author hhc
 *
 */
public interface IQueryConstructionDao {
	
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
	public List<Regional> queryAppDept();
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Construction queryById(String prjId);
	
	/**
	 * ������������id��ѯ�������
	 * @param appDept
	 * @return
	 */
	public String queryAppDeptId(String appDept);
	
	//��Ŀ����(�ֵ��TBPRJTYPEDIC)
	public List<DictionaryClass> queryPrjTypeNums();
	//��������(�ֵ��TBPRJPROPERTYDIC)
	public List<DictionaryClass> queryPrjPropertyNums(); 
	//������;(�ֵ��TBPRJFUNCTIONDIC)
	public List<DictionaryClass> queryPrjFuncitonNums();
	//�����
	public List<DictionaryClass> queryPrjApprovalLevelNums();
	//��ѯʡ
	public List<DictionaryClass> queryProvince();

	//��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);
	
	//��ѯ��
	public List<DictionaryClass> queryArea(String cityId);
}
