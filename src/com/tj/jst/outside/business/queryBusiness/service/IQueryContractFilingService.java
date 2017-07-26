package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * ��ͬ����
 * @author hhc
 *
 */
public interface IQueryContractFilingService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	
	//��ͬ���
	public List<DictionaryClass> queryContractTypeNums();
	/**
	 * ��ѯ��Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition);

	/**
	 * �鿴��ͬ�б�
	 * @return
	 */
	public List<FileWorld> fileWorldList(String recordId);
	
	/**
	 * �鿴��ͬ
	 * @return
	 */
	public FileWorld fileWorld(String conId);
	
	/**
	 * �鿴ͨ�ú�ͬ
	 * @return
	 */
	public FileWorld currencyFileWorld(String inCommon,String conType);

	
}
