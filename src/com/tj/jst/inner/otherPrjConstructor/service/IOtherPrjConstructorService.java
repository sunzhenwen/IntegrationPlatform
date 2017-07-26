package com.tj.jst.inner.otherPrjConstructor.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * ��ʡ��Ŀ���������鿴
 * @author Administrator
 *
 */
public interface IOtherPrjConstructorService {

	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	
	public Construction projectById(String otherPrjId);
	
	/**
	 * ��Ա��ϸ
	 * @return
	 */
	public ProjectPerson personDetailed(String personId);
}
