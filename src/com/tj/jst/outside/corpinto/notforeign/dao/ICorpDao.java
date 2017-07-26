package com.tj.jst.outside.corpinto.notforeign.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public interface ICorpDao {
	
	//企业组织机构代码查询
	public Corp queryCorpCode(String corpCode);
	
	//企业组织机构代码查询
	public Corp queryCorpTypeCode(String corpCode);
	
	//查询省
	public List<DictionaryClass> queryProvince();

	//查询市
	public List<DictionaryClass> queryCity(String provinceId);
	
	//保存企业
	public String addCorp(Corp corp);

	//保存外商企业
	public String addForeignCorp(Corp corp);
	
	//修改企业
	public String modifyCorp(Corp corp);
	
	//修改企业类型
	public String modifyCorpType(Corp corp);
	
	//修改外商企业
	public String modifyForeignCorp(Corp corp);
	
	//查询区
	public List<DictionaryClass> queryArea(String cityId);

	//建设单位跳转修改页面，查询一个企业基本信息
	public Corp queryCorpCode1(String corpCode);
}
