package com.tj.jst.inner.corpfilings.notforeign.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ��ҵ����
 * 
 * @author Administrator
 *
 */
public interface ICorpFilingsDao {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * ����ҵ���
	 * 
	 * @return
	 */
	public void addCorp(Corp corp);

	/**
	 * ����������ҵ
	 * 
	 * @param corp
	 * @return
	 */
	public void addForeignCorp(Corp corp);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public Corp queryCorpForId(String corpId);

	/**
	 * ��ҵ�޸�
	 * 
	 * @return
	 */
	public void modifyCorp(Corp corp);

	/**
	 * ����ͨ��
	 * 
	 * @return
	 */
	public void applythrough(Corp corp);

	/**
	 * ����δͨ��
	 * 
	 * @return
	 */
	public void applyThroughBack(Corp corp);

	// ��ѯʡ
	public List<DictionaryClass> queryProvince();

	// ��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);

	// ��ѯ��
	public List<DictionaryClass> queryArea(String cityId);

	// ��֯��������֤�ظ��ж�
	public String queryCorpCode(String corpCode);
}
