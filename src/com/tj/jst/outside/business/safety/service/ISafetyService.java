package com.tj.jst.outside.business.safety.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * 安全监督
 * @author hhc
 *
 */
public interface ISafetyService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 安全监督申请
	 * @return
	 */
	
	public String add(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Safety queryById(String qualityId);
	
	/**
	 * 安全监督申请修改
	 * @return
	 */
	public void modify(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String qualityId);
	
	//工程类型
	public List<DictionaryClass> queryProjectTypes();
}
