package com.tj.jst.outside.business.constructionFiling.labourServices.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * ʩ�������ͬ����
 * @author hhc
 *
 */
public interface ILabourServices {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��ͬ��������
	 * @return
	 */
	public String add(ContractFiling contractFiling);
	
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
	public ContractFiling queryById(String recordId);
	
	/**
	 * ��ͬ���������޸�
	 * @return
	 */
	public void modify(ContractFiling contractFiling);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String recordId);
	//��ͬ���
	public List<DictionaryClass> queryContractTypeNums();
	/**
	 * ��ѯ��Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition);
	
	/**
	 * ��ѯ��Ͷ����Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition);
	
	/**
	 * ��ѯ��ҵ����
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuery(Condition condition);
	
	/**
	 * ��ѯʩ���ܰ���ͬ
	 * @author Administrator
	 *
	 */
	public Page pagedMainContractor(Condition condition);
	
	/**
	 * �ύ
	 * @return
	 */
	public void sub(String recordId);
}