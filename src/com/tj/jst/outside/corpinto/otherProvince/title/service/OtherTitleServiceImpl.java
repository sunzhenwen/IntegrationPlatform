package com.tj.jst.outside.corpinto.otherProvince.title.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.title.dao.IOtherTitleDao;
import com.tj.jst.outside.corpinto.otherProvince.title.dao.OtherTitleDaoImpl;
import com.tj.jst.outside.staffmanage.title.model.Title;

/**
 * 外省职称人员
 * @author Administrator
 *
 */
public class OtherTitleServiceImpl implements IOtherTitleService {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.pagedQuery(condition);
	}

	/**
	 * 增加职称人员基础信息
	 */
	@Override
	public String add(Title title) {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		String message = "";
		//查询岗位人员中是否有重复数据
		message = titleDao.queryIdCardInfo(title.getIdCard(), title.getPersonId());
		if(!message.equals("成功"))
		{
			return message;
		}else
		{
			message = titleDao.queryFormPos(title.getIdCard());
			if(!message.equals("成功"))
			{
				return message;
			}else
			{
				message = titleDao.queryFormSkill(title.getIdCard());
				if(!message.equals("成功"))
				{
					return message;
				}else
				{
					return titleDao.add(title);
				}
			}
		}
	}
	
	/**
	 * 修改职称人员信息
	 */
	@Override
	public String modify(Title title) {
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		String message = "";
		message = titleDao.queryIdCardInfo(title.getIdCard(), title.getPersonId());
		if(!message.equals("成功"))
		{
			return message;
		}else
		{
			message = titleDao.queryFormSkill(title.getIdCard());
			if(!message.equals("成功"))
			{
				return message;
			}else
			{
				message = titleDao.queryFormPos(title.getIdCard());
				if(!message.equals("成功"))
				{
					return message;
				}else
				{
					return titleDao.modify(title);
				}
			}
		}
	}

	/**
	 * 通过PersonId来判断进行删除操作的职称人员信息
	 */
	@Override
	public String delete(String personId) {
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.delete(personId);
	}

	/**
	 * 字典：性别类
	 */
	@Override
	public List<DictionaryClass> querySexNums() {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.querySexNums();
	}

	/**
	 * 字典：证件类型类
	 */
	@Override
	public List<DictionaryClass> queryIdCardTypeNums() {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryIdCardTypeNums();
	}

	/**
	 * 根据personId来寻找进行删除或者修改操作的人员信息
	 */
	@Override
	public Title queryById(String personId) {
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryById(personId);
	}

	/**
	 * 通过idCard和personId来判断证件号码是否重复
	 */
	@Override
	public String queryIdCardInfo(String idCard, String personId) {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryIdCardInfo(idCard, personId);
	}

	/**
	 * 查询技术人员，判断是否有重复证件号码
	 */
	@Override
	public String queryFormSkill(String idCard) {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryFormSkill(idCard);
	}

	/**
	 * 查询岗位人员是否有重复证件号码
	 */
	@Override
	public String queryFormPos(String idCard) {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryFormPos(idCard);
	}
	
}
