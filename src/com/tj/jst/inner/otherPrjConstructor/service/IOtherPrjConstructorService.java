package com.tj.jst.inner.otherPrjConstructor.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * 外省项目备案内网查看
 * @author Administrator
 *
 */
public interface IOtherPrjConstructorService {

	//分页查询
	public Page pagedQuery(Condition condition);
	
	public Construction projectById(String otherPrjId);
	
	/**
	 * 人员详细
	 * @return
	 */
	public ProjectPerson personDetailed(String personId);
}
