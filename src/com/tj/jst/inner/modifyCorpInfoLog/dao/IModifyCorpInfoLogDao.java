package com.tj.jst.inner.modifyCorpInfoLog.dao;

import java.util.List;

import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.modifyCorpInfoLog.condition.ModifyCorpInfoLogCondition;
import com.tj.jst.inner.modifyCorpInfoLog.model.ModifyCorpInfoLog;

public interface IModifyCorpInfoLogDao {

	/**
	 * 分页查询
	 * @param condition
	 * @return
	 */
	Page queryPage(ModifyCorpInfoLogCondition condition);

	/**
	 * 查询省
	 * @return
	 */
	List<DictionaryClass> queryProvince();

	/**
	 * 查询市
	 * @param provinceId
	 * @return
	 */
	List<DictionaryClass> queryCity(String provinceId);

	/**
	 * 查询区
	 * @param cityNum
	 * @return
	 */
	List<DictionaryClass> queryArea(String cityId);

	/**
	 * 查询企业类型
	 * @return
	 */
	List<DictionaryClass> queryCertTypeNums();

	/**
	 * 详细
	 * @param logId
	 * @return
	 */
	ModifyCorpInfoLog queryInfo(String logId);

}
