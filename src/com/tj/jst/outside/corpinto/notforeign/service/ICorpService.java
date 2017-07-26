package com.tj.jst.outside.corpinto.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public interface ICorpService {
	
	//企业组织机构代码查询
	public Corp queryCorpCode(String corpCode);

	//企业组织机构代码查询
	public Corp queryCorpTypeCode(String corpCode);
	
	//查询省
	public List<DictionaryClass> queryProvince();
	
	//查询市
	public List<DictionaryClass> queryCity(String provinceId);
	
	//查询区
	public List<DictionaryClass> queryArea(String cityId);
	
	//保存企业
	public String addCorp(Corp corp);
	
	//修改企业
	public String modifyCorp(Corp corp);
	
	//修改企业类型
	public String modifyCorpType(Corp corp);

	//建设单位跳转至修改页面，查询一个企业基本信息
	public Corp queryCorpCode1(String corpCode);
}
