package com.tj.jst.outside.business.queryBusiness.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.queryBusiness.dao.IQueryContractFilingDao;
import com.tj.jst.outside.business.queryBusiness.dao.QueryContractFilingDaoImpl;

/**
 * 合同备案
 * @author hhc
 *
 */
public class QueryContractFilingServiceImpl implements IQueryContractFilingService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.pagedQuery(condition);
	}	

	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId)
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.queryById(recordId);
	}
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.queryAppDept();
	}
	//合同类别
	public List<DictionaryClass> queryContractTypeNums()
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.queryContractTypeNums();
	}
	/**
	 * 查询项目
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedPrjQuery(Condition condition) {
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.pagedPrjQuery(condition);
	}
	
	/**
	 * 查看合同列表
	 * @return
	 */
	public List<FileWorld> fileWorldList(String recordId)
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		List<FileWorld> list = dao.fileWorldList(recordId);
		//排序
		Collections.sort(list, new Comparator<FileWorld>(){  
			/*  
			 * int compare(FileWorld o1, FileWorld o2) 返回一个基本类型的整型，  
	         * 返回负数表示：o1 小于o2，  
	         * 返回0 表示：o1和o2相等，  
	         * 返回正数表示：o1大于o2。  
	         */  
			public int compare(FileWorld o1, FileWorld o2) {  
				//按照学生的年龄进行升序排列  
	            if(o1.getPnumber() > o2.getPnumber()){  
	            	return 1;  
	            }  
	            if(o1.getPnumber() == o2.getPnumber()){  
	            	return 0;  
	            }  
	            return -1;  
	        }  
		});
		return list;
	}
	
	/**
	 * 查看合同
	 * @return
	 */
	public FileWorld fileWorld(String conId)
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		//查询合同信息
		return dao.fileWorld(conId);
	}
	
	/**
	 * 查看通用合同
	 * @return
	 */
	public FileWorld currencyFileWorld(String inCommon,String conType)
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.currencyFileWorld(inCommon,conType);	
	}
	
}
