package com.tj.jst.outside.corpinto.otherProvince.title.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.title.model.Title;

/**
 * 外省职称人员
 * @author Administrator
 *
 */
public interface IOtherTitleService {

	//分页查询
	public Page pagedQuery(Condition condition);
	
	/**
	 * 添加
	 * @return
	 */
	public String add(Title title);
	
	/**
	 * 修改
	 * @return
	 */
	public Title queryById(String personId);
	
	/**
	 * 通过查询IDcard值和personID的值来判断所输入的证件信息是否重复！
	 * @param idCard
	 * @param personId
	 * @return
	 */
	public String queryIdCardInfo(String idCard , String personId);
	
	/**
	 * 修改
	 * @return
	 */
	public String modify(Title title);
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(String personId);
	
	/**
	 * 查询性别
	 * @return
	 */
	public List<DictionaryClass> querySexNums();
	
	/**
	 * 查询证件类型
	 * @return
	 */
	public List<DictionaryClass> queryIdCardTypeNums();
	
	
	/**
	 * 查询技术人员数据库中是否有重复数据
	 * @param idCard
	 * @return
	 */
	public String queryFormSkill(String idCard);
	
	/**
	 * 查询岗位人员中是否有重复证件号码
	 * @param idCard
	 * @return
	 */
	public String queryFormPos(String idCard);
}
