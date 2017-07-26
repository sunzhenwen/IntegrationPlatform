package com.tj.jst.outside.corpinto.otherProvince.constructor.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * 外省注册建造师
 * @author Administrator
 *
 */
public interface IOtherConstructorService {

	//分页查询
	public Page pagedQuery(Condition condition);
	
	//学历
	public List<DictionaryClass> eduLevelNums();
	//学位
	public List<DictionaryClass> degreeNums();
	//查询详细
	public Constructor queryDetailed(String idCard,String corpCode);
	//从中间表重新导入新数据
	public boolean importData(String corpName,String corpCode);
	
	/**
	 * 添加
	 * @return
	 */
	public void add(Constructor constructor);
	/**
	 * 跳转修改页面
	 * @return
	 */
	public Constructor queryById(String personId);
	/**
	 * 修改
	 * @return
	 */
	public void modify(Constructor constructor);
	/**
	 * 删除
	 * @return
	 */
	public void deletePerson(String personId);
	
	//职业资格状态(1-8)(字典表：TBQSTATEDIC)
	public List<DictionaryClass> queryStates();
	//注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
	public List<DictionaryClass> queryRegTradeTypeNums();
	//所在企业行业类型(字典表：TBCALLINGTYPEDIC)
	public List<DictionaryClass> queryCallingTypeNums();
	//注册类型及等级(字典表：TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySepecialtyTypNums();
	//证件类型(字典表：TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums();
	//民族
	public List<DictionaryClass> nationAlityNums();
	
}
