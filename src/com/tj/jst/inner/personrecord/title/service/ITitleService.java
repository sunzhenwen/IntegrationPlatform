package com.tj.jst.inner.personrecord.title.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.personrecord.title.model.Title;

/**
 * ְ����Ա����
 * 
 * @author DarkFlameMaster
 *
 */
public interface ITitleService {

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * �޸�
	 * 
	 * @return
	 */
	public Title queryById(String personId);

	/**
	 * ��ѯ�Ա�
	 * 
	 * @return
	 */
	public List<DictionaryClass> querySexNums();

	/**
	 * ��ѯ֤������
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryIdCardTypeNums();

}