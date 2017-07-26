package com.tj.jst.inner.personrecord.threeTypesPersonnel.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.model.ThreeTypesPersonnel;

public interface IThreeTypesPersonnelService {
	// ��ҳ��ѯ
	public Page pagedQuery(Condition condition);

	public ThreeTypesPersonnel queryById(String threeTypePersonId);

	public String queryCorpName(String corpId);

}
