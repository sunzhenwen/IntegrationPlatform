package com.tj.jst.inner.personrecord.position.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

public interface IPositionDao {
	// ��ҳ��ѯ
	public Page pagedQuery(Condition condition);

}
