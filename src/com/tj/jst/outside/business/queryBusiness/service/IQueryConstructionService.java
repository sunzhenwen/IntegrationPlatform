package com.tj.jst.outside.business.queryBusiness.service;

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
public interface IQueryConstructionService {
	
	/**
	 * ��ѯ
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
	
	//��Ŀ����(�ֵ��TBPRJTYPEDIC)
	public List<DictionaryClass> queryPrjTypeNums();
	//��������(�ֵ��TBPRJPROPERTYDIC)
	public List<DictionaryClass> queryPrjPropertyNums(); 
	//������;(�ֵ��TBPRJFUNCTIONDIC)
	public List<DictionaryClass> queryPrjFuncitonNums();
	//��ѯʡ
	public List<DictionaryClass> queryProvince();
	//��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);
	//��ѯ��
	public List<DictionaryClass> queryArea(String cityId);
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Construction queryById(String prjId);
	//�����
	public List<DictionaryClass> queryPrjApprovalLevelNums();
}
