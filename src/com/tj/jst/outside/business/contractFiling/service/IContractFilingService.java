package com.tj.jst.outside.business.contractFiling.service;

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
public interface IContractFilingService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	/**
	 * ��ѯ����λ��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedQueryjl(Condition condition);
	/**
	 * ��ѯ�ܳа���λ��Ϣ
	 * @param condition  pagedQueryQycred
	 * @return
	 */
	public Page pagedQueryzb(Condition condition);
	/**
	 * ��ѯ��ҵ����
	 * @param condition 
	 * @return
	 */
	public Page  pagedQueryQycred(Condition condition);
	/**
	 * ��ѯ��ҵ����good
	 * @param condition 
	 * @return
	 */
	public Page  pagedQueryQycredgood(Condition condition);
	/**
	 * ��ѯ��Ŀ��������Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedQueryxmfz(Condition condition);
	/**
	 * ��ѯ��Ŀרְ��Ա��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedQueryzzry(Condition condition);
	/**
	 * ��ѯ��ʡ��Ŀרְ��Ա��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedQueryzzryNoLocal(Condition condition);
	
	
	/**
	 * ��ѯ�������λ��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedQuerylw(Condition condition);
	/**
	 * ��ѯרҵ�ְ���λ��Ϣ
	 * @param condition
	 * @return
	 */
	public Page pagedQueryfb(Condition condition);
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
	 * ��ѯ������ҵ��Ϣ��ϸ
	 * @param construction
	 * @return
	 */
	public CrediBillity querycred(String corpbadcreditid);
	/**
	 * ��ѯ������ҵ��Ϣ��ϸ
	 * @param construction
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
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<ContractFiling> queryByNum(String PjNum);

	Page pagedkcQuery(Condition condition);
	
	
	
	
}






