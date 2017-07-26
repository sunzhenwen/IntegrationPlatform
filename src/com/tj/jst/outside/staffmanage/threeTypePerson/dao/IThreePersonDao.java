package com.tj.jst.outside.staffmanage.threeTypePerson.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * 外省三类人员
 * @author Administrator
 *
 */
public interface IThreePersonDao {
	
	//分页查询
	public Page pagedQuery(Condition condition);
	
}
