package com.tj.jst.outside.business.safety.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.safety.model.SafetyStaff;

/**
 * 施工安全从业人员
 * @author hhc
 *
 */
public interface ISafetyStaffDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	public void add(SafetyStaff quality);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public SafetyStaff queryById(String qualityId);
	
	/**
	 * 安全监督申请修改
	 * @return
	 */
	public void modify(SafetyStaff quality);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String qualityId);
	
}
