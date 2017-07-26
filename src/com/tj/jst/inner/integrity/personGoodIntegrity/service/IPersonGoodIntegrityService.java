package com.tj.jst.inner.integrity.personGoodIntegrity.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.personGoodIntegrity.model.PersonGoodIntegrity;

/**
 * 人员良好信息接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IPersonGoodIntegrityService {

	// 分页查询
	public Page pagedQuery(Condition condition);

	// 查询省
	public List<DictionaryClass> queryProvince();

	// 查询市
	public List<DictionaryClass> queryCity(String provinceId);

	// 查询区
	public List<DictionaryClass> queryArea(String cityId);

	// 证件类型
	public List<DictionaryClass> queryCardType();

	// 人员类型
	public List<DictionaryClass> queryPersonType();

	// 增加人员良好信息
	public String addPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity);

	// 人员良好信息修改
	public String modifyPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity);

	// 人员良好信息删除
	public String deletePersonGoodInfo(String goodCreditId);

	// 人员良好信息查找
	public PersonGoodIntegrity queryGoodInfo(String goodCreditId);

}
