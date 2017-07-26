package com.tj.jst.outside.staffmanage.skilledworker.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.skilledworker.dao.ISkilledworkerDao;
import com.tj.jst.outside.staffmanage.skilledworker.dao.SkilledworkerDaoImpl;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;

public class SkilledworkerServiceImpl implements ISkilledworkerService{

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.pagedQuery(condition);
	}

	/**
	 * 技术人员种类查询
	 */
	@Override
	public List<DictionaryClass> skilledTypeNums() {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.skilledTypeNums();
	}

	/**
	 * 技术人员级别查询
	 */
	@Override
	public List<DictionaryClass> skilledLevelNums() {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.skilledLevelNums();
	}

	/**
	 * 增加人员信息
	 */
	@Override
	public String addPersonInfo(Skilledworker skilledworker) {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		String message = "";
		//查询技术人员中是否有重复证件号码
		message = skilledworkerDao.queryIdCardInfo(skilledworker.getIdentityCard(), skilledworker.getPersonId());
		if(!message.equals("成功"))
		{
			return message;
		}else
		{
			//查找职称人员中是否有重复证件号码
			message = skilledworkerDao.queryFromTitle(skilledworker.getIdentityCard());
			if(!message.equals("成功"))
			{
				return message;
			}else{
				//查询岗位人员中是否有重复证件号码
				message = skilledworkerDao.queryFromPos(skilledworker.getIdentityCard());
				if(!message.equals("成功"))
				{
					return message;
				}else
				{
					return skilledworkerDao.addPersonInfo(skilledworker);
				}
			}
		}
	}

	/**
	 * 修改技术人员基础信息
	 */
	@Override
	public String modifyPersonInfo(Skilledworker skilledworker) {
		// TODO Auto-generated method stub
		String message = "";
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		message = skilledworkerDao.queryIdCardInfo(skilledworker.getIdentityCard(), skilledworker.getPersonId());
		if(!message.equals("成功"))
		{
			return message;
		}else
		{
			//查找职称人员中是否有重复证件号码
			message = skilledworkerDao.queryFromTitle(skilledworker.getIdentityCard());
			if(!message.equals("成功"))
			{
				return message;
			}else{
				//查询岗位人员中是否有重复证件号码
				message = skilledworkerDao.queryFromPos(skilledworker.getIdentityCard());
				if(!message.equals("成功"))
				{
					return message;
				}else
				{
					return skilledworkerDao.modifyPersonInfo(skilledworker);
				}
			}
		}
	}

	/**
	 * 性别查询
	 */
	@Override
	public List<DictionaryClass> sexNums() {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.sexNums();
	}

	/**
	 * 民族查询
	 */
	@Override
	public List<DictionaryClass> nationalNums() {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.nationalNums();
	}

	/**
	 * 学历查询
	 */
	@Override
	public List<DictionaryClass> eduLevelNums() {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.eduLevelNums();
	}

	/**
	 * 学位查询
	 */
	@Override
	public List<DictionaryClass> degreeNums() {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.degreeNums();
	}

	/**
	 * 证件类型查询
	 */
	@Override
	public List<DictionaryClass> idCardTypeNums() {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.idCardTypeNums();
	}

	/**
	 * 根据personid的值修改人员信息
	 * @param personId
	 * @return
	 */
	@Override
	public Skilledworker queryById(String personId) {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.queryById(personId);
	}

	/**
	 * 根据personId的值来删除人员
	 * @param personId
	 * @return
	 */
	@Override
	public String delete(String personId) {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.deletePersonInfo(personId);
	}

	/**
	 * 根据所传入的 identitycard 和 personId 的信息来确认是否有重复的IDCard信息
	 * @param identitycard
	 * @return
	 */
	@Override
	public String queryIdCardInfo(String identitycard,String personId) {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.queryIdCardInfo(identitycard,personId);
	}

	/**
	 * 根据传入的idcard值来判断是否有重复
	 */
	@Override
	public String queryFromTitle(String identitycard) {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.queryFromTitle(identitycard);
	}

	/**
	 * 根据传入的idcard值来判断是否有重复
	 */
	@Override
	public String queryFromPos(String identitycard) {
		// TODO Auto-generated method stub
		ISkilledworkerDao skilledworkerDao = new SkilledworkerDaoImpl();
		return skilledworkerDao.queryFromPos(identitycard);
	}

}
