package com.tj.jst.inner.accessory.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.accessory.dao.AccessoryDaoImpl;
import com.tj.jst.inner.accessory.dao.IAccessoryDao;
import com.tj.jst.inner.accessory.model.Accessory;

/**
 * 附件服务类
 * 
 * @author Administrator
 *
 */
public class AccessoryServiceImol implements IAccessoryService {

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * 增加
	 */
	@Override
	public String addPage(Accessory accessory) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.addPage(accessory);
	}

	/**
	 * 修改
	 */
	@Override
	public String modifyPage(Accessory accessory) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.modifyPage(accessory);
	}

	/**
	 * 删除
	 */
	@Override
	public String deletePage(String id) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.deletePage(id);
	}

	/**
	 * 查询详细
	 */
	@Override
	public Accessory queryById(String id) {
		// TODO Auto-generated method stub
		IAccessoryDao dao = new AccessoryDaoImpl();
		return dao.queryById(id);
	}

	/**
	 * 查询环节字典表
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
