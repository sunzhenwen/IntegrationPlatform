package com.tj.jst.inner.industryStandard.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.industryStandard.dao.IIndustryStandardDao;
import com.tj.jst.inner.industryStandard.dao.IndustryStandardDaoImpl;
import com.tj.jst.inner.industryStandard.model.IndustryStandard;

/**
 * ��ҵ��׼
 * 
 * @author DarkFlameMaster
 *
 */
public class IndustryStandardServiceImpl implements IIndustryStandardService {

	/**
	 * ��ҳ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IIndustryStandardDao dao = new IndustryStandardDaoImpl();
		return dao.queryPage(condition);
	}

	/**
	 * ��ѯ������Ϣ
	 */
	@Override
	public IndustryStandard queryById(String isId) {
		// TODO Auto-generated method stub
		IIndustryStandardDao dao = new IndustryStandardDaoImpl();
		return dao.queryById(isId);
	}

	/**
	 * ���ӷ�����Ϣ
	 */
	@Override
	public void add(IndustryStandard industryStandard) {
		// TODO Auto-generated method stub
		IIndustryStandardDao dao = new IndustryStandardDaoImpl();
		dao.add(industryStandard);
	}

	/**
	 * �޸ķ�����Ϣ
	 */
	@Override
	public void modify(IndustryStandard industryStandard) {
		// TODO Auto-generated method stub
		IIndustryStandardDao dao = new IndustryStandardDaoImpl();
		dao.modify(industryStandard);
	}

	/**
	 * ɾ��
	 * 
	 * @param announceId
	 * @return
	 */
	public void delete(String isId)
	{
		IIndustryStandardDao dao = new IndustryStandardDaoImpl();
		dao.delete(isId);
	}
	
	public List<DictionaryClass> queryIsTypes()
	{
		IIndustryStandardDao dao = new IndustryStandardDaoImpl();
		return dao.queryIsTypes();
	}
	public List<DictionaryClass> queryIsPublishs()
	{
		IIndustryStandardDao dao = new IndustryStandardDaoImpl();
		return dao.queryIsPublishs();
	}
}
