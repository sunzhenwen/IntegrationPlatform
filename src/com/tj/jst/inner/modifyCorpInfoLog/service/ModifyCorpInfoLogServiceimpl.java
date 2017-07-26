package com.tj.jst.inner.modifyCorpInfoLog.service;

import java.util.List;

import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.corpfilings.notforeign.dao.CorpFilingsDaoImpl;
import com.tj.jst.inner.corpfilings.notforeign.dao.ICorpFilingsDao;
import com.tj.jst.inner.modifyCorpInfoLog.condition.ModifyCorpInfoLogCondition;
import com.tj.jst.inner.modifyCorpInfoLog.dao.IModifyCorpInfoLogDao;
import com.tj.jst.inner.modifyCorpInfoLog.dao.ModifyCorpInfoLogDaoImpl;
import com.tj.jst.inner.modifyCorpInfoLog.model.ModifyCorpInfoLog;

public class ModifyCorpInfoLogServiceimpl implements IModifyCorpInfoLogService  {

	@Override
	public Page queryPage(ModifyCorpInfoLogCondition condition) {
		// TODO Auto-generated method stub
		IModifyCorpInfoLogDao dao = new ModifyCorpInfoLogDaoImpl();
		return dao.queryPage(condition);
	}

	// 查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		IModifyCorpInfoLogDao dao = new ModifyCorpInfoLogDaoImpl();
		return dao.queryProvince();
	}

	// 查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IModifyCorpInfoLogDao dao = new ModifyCorpInfoLogDaoImpl();
		return dao.queryCity(provinceId);
	}

	// 查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IModifyCorpInfoLogDao dao = new ModifyCorpInfoLogDaoImpl();
		return dao.queryArea(cityId);
	}

	//企业类型(TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCertTypeNums() {
		// TODO Auto-generated method stub
		IModifyCorpInfoLogDao dao = new ModifyCorpInfoLogDaoImpl();
		return dao.queryCertTypeNums();
	}

	//详细
	@Override
	public ModifyCorpInfoLog queryInfo(String logId) {
		// TODO Auto-generated method stub
		IModifyCorpInfoLogDao dao = new ModifyCorpInfoLogDaoImpl();
		return dao.queryInfo(logId);
	}

}
