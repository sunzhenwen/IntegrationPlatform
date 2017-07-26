package com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.Certdetail;

/**
 * ��ѯ��ʡ������ҵӵ������
 * 
 * @author Administrator
 *
 */
public interface IQueryOtherCorpCertDao {

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);
	
	//�����ʸ�����(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> qualificationsTypes();
	//�����ʸ�����
	public List<DictionaryClass> queryTradeTypeNum(String requirement);
	//�����ʸ�ȼ�(TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryRating(String requirement);
	/**
	 * רҵ���(TBTRADETYPEBOUNDDIC)
	 * @return
	 */
	public List<DictionaryClass> specialtyType(String specialtyType);
	
	//���
	public void add(Certdetail certdetail);
	
	//ɾ��
	public void deleteCer(String id);
}
