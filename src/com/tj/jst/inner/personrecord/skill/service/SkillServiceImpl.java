package com.tj.jst.inner.personrecord.skill.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.skill.dao.ISkillDao;
import com.tj.jst.inner.personrecord.skill.dao.SkillDaoImpl;
import com.tj.jst.inner.personrecord.skill.model.Skill;

/**
 * 技术人员Service类
 * 
 * @author DarkFlameMaster
 *
 */
public class SkillServiceImpl implements ISkillService {

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * 技术工种类型
	 */
	@Override
	public List<DictionaryClass> skilledTypeNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.skilledTypeNums();
	}

	/**
	 * 技术工种级别
	 */
	@Override
	public List<DictionaryClass> skilledLevelNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.skilledLevelNums();
	}

	/**
	 * 技术工种性别
	 */
	@Override
	public List<DictionaryClass> sexNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.sexNums();
	}

	/**
	 * 民族
	 */
	@Override
	public List<DictionaryClass> nationalNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.nationalNums();
	}

	/**
	 * 学历
	 */
	@Override
	public List<DictionaryClass> eduLevelNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.eduLevelNums();
	}

	/**
	 * 学位
	 */
	@Override
	public List<DictionaryClass> degreeNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.degreeNums();
	}

	/**
	 * 证件类型
	 */
	@Override
	public List<DictionaryClass> idCardTypeNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.idCardTypeNums();
	}

	/**
	 * 通过Id寻找人员
	 */
	@Override
	public Skill queryById(String personId) {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.queryById(personId);
	}

}
