package com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.model.ThreeTypePerson;

/**
 * ��ʡ������Ա
 * @author Administrator
 *
 */
public interface IThreeTypePersonDao {
	
	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	
	/**
	 * ���
	 * @return
	 */
	public String add(ThreeTypePerson threeTypePerson);
	
	/**
	 * ��ѯһ��
	 * @return
	 */
	public ThreeTypePerson queryById(String threeTypePersonId);
	
	/**
	 * �޸�
	 * @return
	 */
	public String modify(ThreeTypePerson threeTypePerson);
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete(String threeTypePersonId);


}
