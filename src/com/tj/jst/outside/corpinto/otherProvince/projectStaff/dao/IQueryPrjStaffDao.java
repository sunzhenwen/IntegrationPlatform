package com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;

/**
 * ��ѯ��ҵ��Ա
 * @author Administrator
 *
 */
public interface IQueryPrjStaffDao {
	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	
	//��Ŀ��Ա����
	public  List<DictionaryClass> queryStaffType();
	
}
