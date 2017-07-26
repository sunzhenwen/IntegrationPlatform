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
 * ��ͬ����
 * @author hhc
 *
 */
public class QueryContractFilingServiceImpl implements IQueryContractFilingService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.pagedQuery(condition);
	}	

	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId)
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.queryById(recordId);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.queryAppDept();
	}
	//��ͬ���
	public List<DictionaryClass> queryContractTypeNums()
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.queryContractTypeNums();
	}
	/**
	 * ��ѯ��Ŀ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedPrjQuery(Condition condition) {
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.pagedPrjQuery(condition);
	}
	
	/**
	 * �鿴��ͬ�б�
	 * @return
	 */
	public List<FileWorld> fileWorldList(String recordId)
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		List<FileWorld> list = dao.fileWorldList(recordId);
		//����
		Collections.sort(list, new Comparator<FileWorld>(){  
			/*  
			 * int compare(FileWorld o1, FileWorld o2) ����һ���������͵����ͣ�  
	         * ���ظ�����ʾ��o1 С��o2��  
	         * ����0 ��ʾ��o1��o2��ȣ�  
	         * ����������ʾ��o1����o2��  
	         */  
			public int compare(FileWorld o1, FileWorld o2) {  
				//����ѧ�������������������  
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
	 * �鿴��ͬ
	 * @return
	 */
	public FileWorld fileWorld(String conId)
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		//��ѯ��ͬ��Ϣ
		return dao.fileWorld(conId);
	}
	
	/**
	 * �鿴ͨ�ú�ͬ
	 * @return
	 */
	public FileWorld currencyFileWorld(String inCommon,String conType)
	{
		IQueryContractFilingDao dao = new QueryContractFilingDaoImpl();
		return dao.currencyFileWorld(inCommon,conType);	
	}
	
}
