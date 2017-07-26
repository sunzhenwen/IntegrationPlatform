package com.tj.jst.outside.business.contractFiling.dao;

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
public interface IContractFilingDao {
	
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * 合同备案申请
	 * @return
	 */
	public String add(ContractFiling contractFiling);
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId);
	/**
	 * 查询企业诚信信息
	 * @param 
	 * @return
	 */
	public CrediBillity querycred(String corpbadcreditid);
	/**
	 * 查询企业诚信信息good
	 * @param 
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
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	/**
	 * 根据树形排序id查询区域编码
	 * @param appDept
	 * @return
	 */
	public String queryAppDeptId(String appDept);
	//合同类别
	public List<DictionaryClass> queryContractTypeNums();
	/**
	 * 查询项目
	 * @param condition
	 * @return
	 */
	public Page pagedkcQuery(Condition condition);
	/**
	 * 查询勘察单位
	 * @param condition
	 * @returnpagedkcQuery
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
	 * 查询监理单位信息
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryjl(Condition condition);
	/**
	 * 查询总承包单位信息
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryzb(Condition condition);
	/**
	 * 查询企业诚信信息
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryQycred(Condition condition);
	/**
	 * 查询企业诚信信息good
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryQycredgood(Condition condition);
	/**
	 * 查询劳务分包包单位信息
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuerylw(Condition condition);
	/**
	 * 查询项目负责人信息
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryxmfz(Condition condition);
	/**
	 * 查询专职人员信息
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryzzry(Condition condition);
	/**
	 * 查询专业分包单位信息
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryfb(Condition condition);
	/**
	 * 根据项目编号查询
	 * @param PrNum
	 * @return
	 */
	public List<ContractFiling> queryByPrNum(String PrNum);
	
	
}
