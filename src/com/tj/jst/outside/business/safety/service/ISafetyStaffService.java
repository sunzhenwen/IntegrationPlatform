package com.tj.jst.outside.business.safety.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.safety.model.SafetyStaff;

/**
 * 施工安全从业人员
 * @author hhc
 *
 */
public interface ISafetyStaffService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 施工安全从业人员添加
	 * @return
	 */
	public void add(SafetyStaff quality);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public SafetyStaff queryById(String qualityId);
	
	/**
	 * 施工安全从业人员修改
	 * @return
	 */
	public void modify(SafetyStaff quality);
	
	/**
	 * 施工安全从业人员删除
	 * @return
	 */
	public void delete(String qualityId);
	
	//证件类型
	public List<DictionaryClass> queryCardTypeNums();
}
