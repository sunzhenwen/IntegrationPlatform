package com.tj.jst.inner.accessory.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.accessory.dao.AccessoryDaoImpl;
import com.tj.jst.inner.accessory.dao.IAccessoryDao;
import com.tj.jst.inner.accessory.model.Accessory;

/**
 * ����������
 * 
 * @author Administrator
 *
 */
public class AccessoryServiceImol implements IAccessoryService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ����
	 */
	@Override
	public String addPage(Accessory accessory) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.addPage(accessory);
	}

	/**
	 * �޸�
	 */
	@Override
	public String modifyPage(Accessory accessory) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.modifyPage(accessory);
	}

	/**
	 * ɾ��
	 */
	@Override
	public String deletePage(String id) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.deletePage(id);
	}

	/**
	 * ��ѯ��ϸ
	 */
	@Override
	public Accessory queryById(String id) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.queryById(id);
	}

	/**
	 * ��ѯ�����ֵ��
	 * 
	 * @param id
	 * @return
	 */
	public List<DictionaryClass> queryLinkName()
	{
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.queryLinkName();
	}
}
