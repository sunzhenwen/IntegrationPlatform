package com.tj.jst.outside.business.contractFiling.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.credibility.model.CrediBillity;
import com.tj.jst.outside.business.credibility.model.CrediBillityGood;

/**
 * ��ͬ����
 * @author hhc
 *
 */
public interface IContractFilingDao {
	
	/**
	 * ��ѯ
	 * 
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
	public ContractFiling queryById(String recordId);
	/**
	 * ��ѯ��ҵ������Ϣ
	 * @param 
	 * @return
	 */
	public CrediBillity querycred(String corpbadcreditid);
	/**
	 * ��ѯ��ҵ������Ϣgood
	 * @param 
	 * @return
	 */
	public CrediBillityGood querycredgood(String goodcreditid);
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
	//��ͬ���
	public List<DictionaryClass> queryContractTypeNums();
	/**
	 * ��ѯ��Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedkcQuery(Condition condition);
	/**
	 * ��ѯ���쵥λ
	 * @param condition
	 * @returnpagedkcQuery
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
	 * ��ѯ����λ��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryjl(Condition condition);
	/**
	 * ��ѯ�ܳа���λ��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryzb(Condition condition);
	/**
	 * ��ѯ��ҵ������Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryQycred(Condition condition);
	/**
	 * ��ѯ��ҵ������Ϣgood
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryQycredgood(Condition condition);
	/**
	 * ��ѯ����ְ�����λ��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuerylw(Condition condition);
	/**
	 * ��ѯ��Ŀ��������Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryxmfz(Condition condition);
	/**
	 * ��ѯרְ��Ա��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryzzry(Condition condition);
	/**
	 * ��ѯרҵ�ְ���λ��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryfb(Condition condition);
	/**
	 * ������Ŀ��Ų�ѯ
	 * @param PrNum
	 * @return
	 */
	public List<ContractFiling> queryByPrNum(String PrNum);
	
	
}
