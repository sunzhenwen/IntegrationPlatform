package com.tj.jst.inner.modifyCorpInfoLog.service;

import java.util.List;

import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.modifyCorpInfoLog.condition.ModifyCorpInfoLogCondition;
import com.tj.jst.inner.modifyCorpInfoLog.model.ModifyCorpInfoLog;

public interface IModifyCorpInfoLogService {

	/**
	 * ��ҳ��ѯ
	 * @param condition
	 * @return
	 */
	Page queryPage(ModifyCorpInfoLogCondition condition);

	/**
	 * ��ѯʡ
	 * @return
	 */
	List<DictionaryClass> queryProvince();

	/**
	 * ��ѯ��
	 * @param provinceId
	 * @return
	 */
	List<DictionaryClass> queryCity(String provinceId);

	/**
	 * ��ѯ��
	 * @param cityNum
	 * @return
	 */
	List<DictionaryClass> queryArea(String cityNum);

	/**
	 * ��ѯ��ҵ����
	 * @return
	 */
	List<DictionaryClass> queryCertTypeNums();

	/**
	 * ��ϸ
	 * @param logId
	 * @return
	 */
	ModifyCorpInfoLog queryInfo(String logId);

}
