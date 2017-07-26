package com.tj.jst.outside.business.contractFiling.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.credibility.model.CrediBillity;
import com.tj.jst.outside.business.credibility.model.CrediBillityGood;

/**
 * 合同备案
 * @author hhc
 *
 */
public interface IContractFilingService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	/**
	 * 查询监理单位信息
	 * @param condition
	 * @return
	 */
	public Page pagedQueryjl(Condition condition);
	/**
	 * 查询总承包单位信息
	 * @param condition  pagedQueryQycred
	 * @return
	 */
	public Page pagedQueryzb(Condition condition);
	/**
	 * 查询企业诚信
	 * @param condition 
	 * @return
	 */
	public Page  pagedQueryQycred(Condition condition);
	/**
	 * 查询企业诚信good
	 * @param condition 
	 * @return
	 */
	public Page  pagedQueryQycredgood(Condition condition);
	/**
	 * 查询项目负责人信息
	 * @param condition
	 * @return
	 */
	public Page pagedQueryxmfz(Condition condition);
	/**
	 * 查询项目专职人员信息
	 * @param condition
	 * @return
	 */
	public Page pagedQueryzzry(Condition condition);
	/**
	 * 查询外省项目专职人员信息
	 * @param condition
	 * @return
	 */
	public Page pagedQueryzzryNoLocal(Condition condition);
	
	
	/**
	 * 查询劳务包单位信息
	 * @param condition
	 * @return
	 */
	public Page pagedQuerylw(Condition condition);
	/**
	 * 查询专业分包单位信息
	 * @param condition
	 * @return
	 */
	public Page pagedQueryfb(Condition condition);
	/**
	 * 合同备案申请
	 * @return
	 */
	public String add(ContractFiling contractFiling);
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId);
	/**
	 * 查询不良企业信息明细
	 * @param construction
	 * @return
	 */
	public CrediBillity querycred(String corpbadcreditid);
	/**
	 * 查询良好企业信息明细
	 * @param construction
	 * @return
	 */
	public CrediBillityGood querycredgood(String goodcreditid);
	
	/**
	 * 合同备案申请修改
	 * @return
	 */
	public void modify(ContractFiling contractFiling);
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String recordId);
	//合同类别
	public List<DictionaryClass> queryContractTypeNums();
	/**
	 * 查询项目
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition);
	
	/**
	 * 查询招投标项目
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition);
	
	/**
	 * 查询企业资质
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuery(Condition condition);
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public List<ContractFiling> queryByNum(String PjNum);

	Page pagedkcQuery(Condition condition);
	
	
	
	
}






