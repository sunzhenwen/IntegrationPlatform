package com.tj.jst.inner.personrecord.skill.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.skill.model.Skill;

/**
 * 技术人员备案Dao接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface ISkillDao {

	// 分页查询
	public Page pagedQuery(Condition condition);

	// 技术人员类型
	public List<DictionaryClass> skilledTypeNums();

	// 技术人员级别
	public List<DictionaryClass> skilledLevelNums();

	// 性别信息
	public List<DictionaryClass> sexNums();

	// 民族信息
	public List<DictionaryClass> nationalNums();

	// 学历
	public List<DictionaryClass> eduLevelNums();

	// 学位
	public List<DictionaryClass> degreeNums();

	// 证件类型
	public List<DictionaryClass> idCardTypeNums();

	// 根据Id查找详细细信
	public Skill queryById(String personId);

}
