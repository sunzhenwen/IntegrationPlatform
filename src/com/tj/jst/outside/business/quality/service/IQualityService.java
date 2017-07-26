package com.tj.jst.outside.business.quality.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * 质量监督
 * @author hhc
 *
 */
public interface IQualityService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 查询施工图审
	 * @param condition
	 * @return
	 */
	public Page pagedQualityPlans(Condition condition);
	
	/**
	 * 质量监督申请
	 * @return
	 */
	public String add(Quality quality);
	
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
	public Quality queryById(String qualityId);
	
	/**
	 * 质量监督申请修改
	 * @return
	 */
	public void modify(Quality quality);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String qualityId);
	
	/**
	 * 查询招投标项目
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition);
}
