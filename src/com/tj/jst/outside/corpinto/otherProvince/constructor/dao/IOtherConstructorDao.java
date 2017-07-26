package com.tj.jst.outside.corpinto.otherProvince.constructor.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.CertdetailInfo;
import com.tj.jst.outside.business.contractFiling.model.Certinfo;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * 外省注册建造师
 * @author Administrator
 *
 */
public interface IOtherConstructorDao {
	//分页查询
	public Page pagedQuery(Condition condition);
	//学历
	public List<DictionaryClass> eduLevelNums();
	//学位
	public List<DictionaryClass> degreeNums();
	//查询详细
	public Constructor queryDetailed(String idCard,String corpCode);
	//查询中建表中的数据(建造师)
	public List<Constructor> queryImportConstructor(String corpName,String corpCode);
	//查询中建表中的数据(监理工程师 第一专业)
	public List<Constructor> queryImportSupervisorOne(String corpName,String corpCode);
	//查询中建表中的数据(监理工程师 第二专业)
	public List<Constructor> queryImportSupervisorTwo(String corpName,String corpCode);
	//查询中建表中的数据(除了建造师和监理工程师以外的)
	public List<Constructor> queryImportOther(String corpName,String corpCode);
	//从中间表重新导入新数据
	public boolean importData(List<Constructor> list,String corpCode);
	//从中间表导入基础表数据
	public List<Constructor> queryBasePerson(String corpCode);
	//从中间表导入基础表数据
	public boolean importBasePerson(List<Constructor> listBasePerson,String corpCode);
	//查询企业资质中间表(资质表)
	public List<CertdetailInfo> queryCertdetailinfo(String corpCode);
	//查询企业资质中间表(证书表)
	public List<Certinfo> queryCertinfo(String corpCode);
	
	//导入证书表
	public boolean importCertinfo(List<Certinfo> listCertinfo,String corpCode);
	//导入资质信息表
	public boolean importCertdetailinfo(List<CertdetailInfo> listCertdetailinfo,String corpCode);

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
