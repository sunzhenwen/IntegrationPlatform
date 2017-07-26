package com.tj.jst.outside.business.safety.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;
import com.tj.jst.outside.business.safety.dao.ISafetyStaffDao;
import com.tj.jst.outside.business.safety.dao.SafetyStaffDaoImpl;
import com.tj.jst.outside.business.safety.model.SafetyStaff;

/**
 * 施工安全从业人员
 * @author hhc
 *
 */
public class SafetyStaffServiceImpl implements ISafetyStaffService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	
	public void add(SafetyStaff quality)
	{
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		dao.add(quality);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public SafetyStaff queryById(String qualityId)
	{
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		return dao.queryById(qualityId);
	}
	
	/**
	 * 安全监督申请修改
	 * @return
	 */
	public void modify(SafetyStaff quality)
	{
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		dao.modify(quality);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String qualityId)
	{
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		dao.delete(qualityId);
	}

	//证件类型
	public List<DictionaryClass> queryCardTypeNums()
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryCardTypeNums();
	}
}
