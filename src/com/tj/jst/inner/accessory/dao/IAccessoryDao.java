package com.tj.jst.inner.accessory.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.accessory.model.Accessory;

/**
 * �������ݿ�ӿ�
 * 
 * @author Administrator
 *
 */
public interface IAccessoryDao {

	/**
	 * ��ҳ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ����
	 * 
	 * @param accessory
	 * @return
	 */
	public String addPage(Accessory accessory);

	/**
	 * �޸�
	 * 
	 * @param id
	 * @return
	 */
	public String modifyPage(Accessory accessory);

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	public String deletePage(String id);

	/**
	 * ��ѯ��ϸ
	 * 
	 * @param id
	 * @return
	 */
	public Accessory queryById(String id);

	/**
	 * ��ѯ�����ֵ��
	 * 
	 * @param id
	 * @return
	 */
	public List<DictionaryClass> queryLinkName();
}
