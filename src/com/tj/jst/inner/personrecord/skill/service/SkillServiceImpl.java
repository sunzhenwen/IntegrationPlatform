package com.tj.jst.inner.personrecord.skill.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.skill.dao.ISkillDao;
import com.tj.jst.inner.personrecord.skill.dao.SkillDaoImpl;
import com.tj.jst.inner.personrecord.skill.model.Skill;

/**
 * ������ԱService��
 * 
 * @author DarkFlameMaster
 *
 */
public class SkillServiceImpl implements ISkillService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ������������
	 */
	@Override
	public List<DictionaryClass> skilledTypeNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.skilledTypeNums();
	}

	/**
	 * �������ּ���
	 */
	@Override
	public List<DictionaryClass> skilledLevelNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.skilledLevelNums();
	}

	/**
	 * ���������Ա�
	 */
	@Override
	public List<DictionaryClass> sexNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.sexNums();
	}

	/**
	 * ����
	 */
	@Override
	public List<DictionaryClass> nationalNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.nationalNums();
	}

	/**
	 * ѧ��
	 */
	@Override
	public List<DictionaryClass> eduLevelNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.eduLevelNums();
	}

	/**
	 * ѧλ
	 */
	@Override
	public List<DictionaryClass> degreeNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.degreeNums();
	}

	/**
	 * ֤������
	 */
	@Override
	public List<DictionaryClass> idCardTypeNums() {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.idCardTypeNums();
	}

	/**
	 * ͨ��IdѰ����Ա
	 */
	@Override
	public Skill queryById(String personId) {
		// TODO Auto-generated method stub
		ISkillDao dao = new SkillDaoImpl();
		return dao.queryById(personId);
	}

}
