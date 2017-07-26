package com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.model.ThreeTypePerson;

/**
 * 外省三类人员
 * @author Administrator
 *
 */
public interface IThreeTypePersonDao {
	
	//分页查询
	public Page pagedQuery(Condition condition);
	
	/**
	 * 添加
	 * @return
	 */
	public String add(ThreeTypePerson threeTypePerson);
	
	/**
	 * 查询一条
	 * @return
	 */
	public ThreeTypePerson queryById(String threeTypePersonId);
	
	/**
	 * 修改
	 * @return
	 */
	public String modify(ThreeTypePerson threeTypePerson);
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(String threeTypePersonId);


}
