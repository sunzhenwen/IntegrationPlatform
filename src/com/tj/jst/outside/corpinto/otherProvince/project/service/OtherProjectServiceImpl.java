package com.tj.jst.outside.corpinto.otherProvince.project.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.project.dao.IOtherProjectDao;
import com.tj.jst.outside.corpinto.otherProvince.project.dao.OtherProjectDaoImpl;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * ��ʡ��Ŀ����
 * @author Administrator
 *
 */
public class OtherProjectServiceImpl implements IOtherProjectService {

	//��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		IOtherProjectDao opd = new OtherProjectDaoImpl();
		return opd.pagedQuery(condition);
	}

	/**
	 * ���
	 * @return
	 */
	public String add(Construction construction)
	{
		IOtherProjectDao opd = new OtherProjectDaoImpl();
		return opd.add(construction);
	}
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public Construction queryById(String prjId)
	{
		IOtherProjectDao constructionDao = new OtherProjectDaoImpl();
		return constructionDao.queryById(prjId);
	}
	/**
	 * �޸�
	 * @return
	 */
	public void modify(Construction construction)
	{
		IOtherProjectDao constructorDao = new OtherProjectDaoImpl();
		constructorDao.modify(construction);
	}
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String otherPrjId)
	{
		IOtherProjectDao constructorDao = new OtherProjectDaoImpl();
		constructorDao.delete(otherPrjId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//��ѯ��ϸ
	@Override
	public Constructor queryDetailed(String idCard,String corpCode) {
		IOtherProjectDao constructorDao = new OtherProjectDaoImpl();
		return constructorDao.queryDetailed(idCard,corpCode);
	}

}
