package com.tj.jst.inner.personrecord.title.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.title.model.Title;

/**
 * 职称人员备案Dao接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface ITitleDao {

	/**
	 * 分页查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * 修改
	 * 
	 * @return
	 */
	public Title queryById(String personId);

	/**
	 * 查询性别
	 * 
	 * @return
	 */
	public List<DictionaryClass> querySexNums();

	/**
	 * 查询证件类型
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryIdCardTypeNums();

}
