package com.tj.jst.inner.personrecord.threeTypesPersonnel.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.model.ThreeTypesPersonnel;

public interface IThreeTypesPersonnelDao {
	// ∑÷“≥≤È—Ø
	public Page pagedQuery(Condition condition);

	public ThreeTypesPersonnel queryById(String threeTypePersonId);

	public String queryCorpName(String corpId);

}
