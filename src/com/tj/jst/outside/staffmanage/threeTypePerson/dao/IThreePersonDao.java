package com.tj.jst.outside.staffmanage.threeTypePerson.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

/**
 * ��ʡ������Ա
 * @author Administrator
 *
 */
public interface IThreePersonDao {
	
	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	
}
