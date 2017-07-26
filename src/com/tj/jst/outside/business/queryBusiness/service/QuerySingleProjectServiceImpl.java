package com.tj.jst.outside.business.queryBusiness.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.queryBusiness.dao.IQuerySingleProjectDao;
import com.tj.jst.outside.business.queryBusiness.dao.QuerySingleProjectDaoImpl;
import com.tj.jst.outside.business.singleProject.model.SingleProject;

/**
 * ���幤��
 * @author hhc
 *
 */
public class QuerySingleProjectServiceImpl implements IQuerySingleProjectService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IQuerySingleProjectDao dao = new QuerySingleProjectDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public SingleProject queryById(long spId)
	{
		IQuerySingleProjectDao dao = new QuerySingleProjectDaoImpl();
		SingleProject sp = dao.queryById(spId);
		//��ȡ��λ����
		String spNum = sp.getSpNum();
		
		if(spNum.contains("-"))
		{
			int end = spNum.indexOf("-");
			//��ȡ���幤�̱��
			String subSpNum = spNum.substring(0, end);
			sp.setPrjNum(subSpNum);
		}else
		{
			
			String subSpNum = spNum.substring(0, 15);
			sp.setPrjNum(subSpNum);
		}

		return sp;
		
	}
	
	//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		IQuerySingleProjectDao dao = new QuerySingleProjectDaoImpl();
		return dao.queryPrjStructureTypeNums();
	}


}
