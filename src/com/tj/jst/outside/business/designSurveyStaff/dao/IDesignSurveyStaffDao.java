package com.tj.jst.outside.business.designSurveyStaff.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.designSurveyStaff.model.DesignSurveyStaff;

/**
 * 勘察设计审图人员
 * @author hhc
 *
 */
public interface IDesignSurveyStaffDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	public void add(DesignSurveyStaff quality);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public DesignSurveyStaff queryById(String qualityId);
	
	/**
	 * 安全监督申请修改
	 * @return
	 */
	public void modify(DesignSurveyStaff quality);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String qualityId);
	
	//注册类型及等级
	public List<DictionaryClass> querySpecialtyTypNums();
	//承担角色
	public List<DictionaryClass> queryPrjDutys();
}
