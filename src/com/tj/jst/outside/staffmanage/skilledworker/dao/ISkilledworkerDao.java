package com.tj.jst.outside.staffmanage.skilledworker.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;

public interface ISkilledworkerDao {
	
	//分页查询
	public Page pagedQuery(Condition condition);
	//技术人员类别查询
	public List<DictionaryClass> skilledTypeNums();
	//技术人员级别查询
	public List<DictionaryClass> skilledLevelNums();
	//增加人员信息
	public String addPersonInfo(Skilledworker skilledworker);
	//修改人员信息
	public String modifyPersonInfo(Skilledworker skilledworker);
	//根据idCard和personId的值来判断是否是重复身份信息
	public String queryIdCardInfo(String identitycard,String personId);
	//通过personId来判断所修改或删除的人员
	public Skilledworker queryById(String personId);
	//删除人员信息
	public String deletePersonInfo(String personId);
	//性别信息
	public List<DictionaryClass> sexNums();
	//民族信息
	public List<DictionaryClass> nationalNums();
	//学历
	public List<DictionaryClass> eduLevelNums();
	//学位
	public List<DictionaryClass> degreeNums();
	//证件类型
	public List<DictionaryClass> idCardTypeNums();
	
	//在职称人员中寻找是否有相同的证件号码
	public String queryFromTitle(String identitycard);
	
	//在岗位人员中寻找是否有相同的证件号码
	public String queryFromPos(String identitycard);
	
}
