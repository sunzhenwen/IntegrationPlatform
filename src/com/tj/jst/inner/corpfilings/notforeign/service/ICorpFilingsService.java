package com.tj.jst.inner.corpfilings.notforeign.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ��ҵ����
 * @author Administrator
 *
 */
public interface ICorpFilingsService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ����ҵ���
	 * @return
	 */
	public void addCorp(Corp corp);
	
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public Corp modifyCorpPage(String corpId);
	
	/**
	 * ��ҵ�޸�
	 * @return
	 */
	public void modifyCorp(Corp corp);

	/**
	 * ��ת����ҳ��
	 * @return
	 */
	public Corp applyCorpPage(String corpId);
	
	/**
	 * ����ͨ��
	 * @return
	 */
	public void applythrough(Corp corp);
	
	/**
	 * ����δͨ��
	 * @return
	 */
	public void applyThroughBack(Corp corp);
	
	//��ѯʡ
	public List<DictionaryClass> queryProvince();
	
	//��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);
	
	//��ѯ��
	public List<DictionaryClass> queryArea(String cityId);
	
	//��֯��������֤�ظ��ж�
	public String queryCorpCode(String corpCode);
	
}
