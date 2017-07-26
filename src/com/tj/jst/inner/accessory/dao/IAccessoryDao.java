package com.tj.jst.inner.accessory.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.accessory.model.Accessory;

/**
 * 附件数据库接口
 * 
 * @author Administrator
 *
 */
public interface IAccessoryDao {

	/**
	 * 分页
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 增加
	 * 
	 * @param accessory
	 * @return
	 */
	public String addPage(Accessory accessory);

	/**
	 * 修改
	 * 
	 * @param id
	 * @return
	 */
	public String modifyPage(Accessory accessory);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public String deletePage(String id);

	/**
	 * 查询详细
	 * 
	 * @param id
	 * @return
	 */
	public Accessory queryById(String id);

	/**
	 * 查询环节字典表
	 * 
	 * @param id
	 * @return
	 */
	public List<DictionaryClass> queryLinkName();
}
