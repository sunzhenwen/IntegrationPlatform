package com.tj.jst.outside.business.designSurveyStaff.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.designSurveyStaff.dao.DesignSurveyStaffDaoImpl;
import com.tj.jst.outside.business.designSurveyStaff.dao.IDesignSurveyStaffDao;
import com.tj.jst.outside.business.designSurveyStaff.model.DesignSurveyStaff;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;

/**
 * 勘察设计审图人员
 * @author hhc
 *
 */
public class DesignSurveyStaffServiceImpl implements IDesignSurveyStaffService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	
	public void add(DesignSurveyStaff quality)
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		dao.add(quality);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public DesignSurveyStaff queryById(String qualityId)
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		return dao.queryById(qualityId);
	}
	
	/**
	 * 安全监督申请修改
	 * @return
	 */
	public void modify(DesignSurveyStaff quality)
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		dao.modify(quality);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String qualityId)
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		dao.delete(qualityId);
	}

	//证件类型
	public List<DictionaryClass> queryCardTypeNums()
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryCardTypeNums();
	}
	
	//注册类型及等级
	public List<DictionaryClass> querySpecialtyTypNums()
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		return dao.querySpecialtyTypNums();
	}
	
	//承担角色
	public List<DictionaryClass> queryPrjDutys()
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		return dao.queryPrjDutys();
	}
}
