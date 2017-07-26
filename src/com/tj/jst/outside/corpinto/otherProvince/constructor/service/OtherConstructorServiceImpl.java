package com.tj.jst.outside.corpinto.otherProvince.constructor.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.CertdetailInfo;
import com.tj.jst.outside.business.contractFiling.model.Certinfo;
import com.tj.jst.outside.corpinto.otherProvince.constructor.dao.IOtherConstructorDao;
import com.tj.jst.outside.corpinto.otherProvince.constructor.dao.OtherConstructorDaoImpl;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * 外省注册建造师
 * @author Administrator
 *
 */
public class OtherConstructorServiceImpl implements IOtherConstructorService {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.pagedQuery(condition);
	}

	//学历
	@Override
	public List<DictionaryClass> eduLevelNums() {
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.eduLevelNums();
	}

	//学位
	@Override
	public List<DictionaryClass> degreeNums() {
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.degreeNums();
	}

	//查询详细
	@Override
	public Constructor queryDetailed(String idCard,String corpCode) {
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryDetailed(idCard,corpCode);
	}

	//从中间表重新导入新数据
	public boolean importData(String corpName,String corpCode)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		//查询中建表中的数据(建造师)
		List<Constructor> list = constructorDao.queryImportConstructor(corpName,corpCode);
		//查询中建表中的数据(监理工程师 第一专业)
		List<Constructor> listSupervisorOne = constructorDao.queryImportSupervisorOne(corpName,corpCode);
		//查询中建表中的数据(监理工程师 第二专业)
		List<Constructor> listSupervisorTwo = constructorDao.queryImportSupervisorTwo(corpName,corpCode);
		//查询中建表中的数据(除了建造师和监理工程师以外的)
		List<Constructor> listOther = constructorDao.queryImportOther(corpName,corpCode);
		//中间表查询人员基础数据
		List<Constructor> listBasePerson = constructorDao.queryBasePerson(corpCode);
		//查询企业资质中间表(资质表)
		List<CertdetailInfo> listCertdetailinfo = constructorDao.queryCertdetailinfo(corpCode);
		//查询企业资质中间表(证书表)
		List<Certinfo> listCertinfo = constructorDao.queryCertinfo(corpCode);
		
		
		list.addAll(listSupervisorOne);
		list.addAll(listSupervisorTwo);
		list.addAll(listOther);
		listSupervisorOne = null;
		listSupervisorTwo = null;
		listOther = null;
		boolean checked = true;
		if(list.size()!=0)
		{
			//导入人员数据
			boolean check = constructorDao.importData(list,corpCode);
			if(check==false)
			{
				checked = check;
			}
		}
		if(listBasePerson.size()!=0)
		{
			//导入人员基础数据
			boolean check = constructorDao.importBasePerson(listBasePerson,corpCode);
			if(check==false)
			{
				checked = check;
			}
		}
		if(listCertinfo.size()!=0)
		{
			//导入证书表
			boolean check = constructorDao.importCertinfo(listCertinfo,corpCode);
			if(check==false)
			{
				checked = check;
			}
		}
		if(listCertdetailinfo.size()!=0)
		{
			//导入资质信息表
			boolean check = constructorDao.importCertdetailinfo(listCertdetailinfo,corpCode);
			if(check==false)
			{
				checked = check;
			}
		}
		return checked;
	}
	
	/**
	 * 添加
	 * @return
	 */
	public void add(Constructor constructor)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		constructorDao.add(constructor);
	}
	/**
	 * 跳转修改页面
	 * @return
	 */
	public Constructor queryById(String personId)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryById(personId);
	}
	/**
	 * 修改
	 * @return
	 */
	public void modify(Constructor constructor)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		constructorDao.modify(constructor);
	}
	/**
	 * 删除
	 * @return
	 */
	public void deletePerson(String personId)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		constructorDao.deletePerson(personId);
	}
	
	//职业资格状态(1-8)(字典表：TBQSTATEDIC)
	public List<DictionaryClass> queryStates()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryStates();
	}
	//注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
	public List<DictionaryClass> queryRegTradeTypeNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryRegTradeTypeNums();
	}
	//所在企业行业类型(字典表：TBCALLINGTYPEDIC)
	public List<DictionaryClass> queryCallingTypeNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryCallingTypeNums();
	}
	//注册类型及等级(字典表：TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySepecialtyTypNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.querySepecialtyTypNums();
	}
	//证件类型(字典表：TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryIdCardTypeNums();
	}
	
	//民族
	public List<DictionaryClass> nationAlityNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.nationAlityNums();
	}
}
