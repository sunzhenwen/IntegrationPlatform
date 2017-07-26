package com.tj.jst.inner.personrecord.skill.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.skill.model.Skill;

/**
 * ������Ա����Dao�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface ISkillDao {

	// ��ҳ��ѯ
	public Page pagedQuery(Condition condition);

	// ������Ա����
	public List<DictionaryClass> skilledTypeNums();

	// ������Ա����
	public List<DictionaryClass> skilledLevelNums();

	// �Ա���Ϣ
	public List<DictionaryClass> sexNums();

	// ������Ϣ
	public List<DictionaryClass> nationalNums();

	// ѧ��
	public List<DictionaryClass> eduLevelNums();

	// ѧλ
	public List<DictionaryClass> degreeNums();

	// ֤������
	public List<DictionaryClass> idCardTypeNums();

	// ����Id������ϸϸ��
	public Skill queryById(String personId);

}
