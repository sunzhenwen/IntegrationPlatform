package com.tj.jst.outside.business.construction.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjNum;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.dao.ConstructionDaoImpl;
import com.tj.jst.outside.business.construction.dao.IConstructionDao;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * ��Ŀ����
 * @author hhc
 *
 */
public class ConstructionServiceImpl implements IConstructionService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IConstructionDao dao = new ConstructionDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ӱ���
	 * @param construction
	 * @return
	 */
	public String add(Construction construction)
	{
		IConstructionDao dao = new ConstructionDaoImpl();
		String appDept = dao.queryAppDeptId(construction.getAppDept());
		construction.setAppDept(appDept);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjNum.querySerNuma(new Date(new java.util.Date().getTime()));
		String prjNum = appDept + fDate + construction.getPrjTypeNum()
				+ serNum;
		construction.setPrjNum(prjNum);
		return dao.add(construction);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Construction queryById(String prjId)
	{
		IConstructionDao dao = new ConstructionDaoImpl();
		return dao.queryById(prjId);
	}
	
	/**
	 * �޸ı���
	 * @param construction
	 * @return
	 */
	public void modify(Construction construction)
	{
		IConstructionDao dao = new ConstructionDaoImpl();
		//�ж��Ƿ���Ĺ���������
		if(construction.getAppDept().startsWith("40"))
		{
			String appDept = dao.queryAppDeptId(construction.getAppDept());
			construction.setAppDept(appDept);
		}
		dao.modify(construction);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String id)
	{
		IConstructionDao dao = new ConstructionDaoImpl();
		dao.delete(id);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IConstructionDao dao = new ConstructionDaoImpl();
		return dao.queryAppDept();
	}
	
	//��Ŀ����(�ֵ��TBPRJTYPEDIC)
	public List<DictionaryClass> queryPrjTypeNums()
	{
		IConstructionDao corpDao = new ConstructionDaoImpl();
		return corpDao.queryPrjTypeNums();
	}
	
	//��������(�ֵ��TBPRJPROPERTYDIC)
	public List<DictionaryClass> queryPrjPropertyNums()
	{
		IConstructionDao corpDao = new ConstructionDaoImpl();
		return corpDao.queryPrjPropertyNums();
	}
	//������;(�ֵ��TBPRJFUNCTIONDIC)
	public List<DictionaryClass> queryPrjFuncitonNums()
	{
		IConstructionDao corpDao = new ConstructionDaoImpl();
		return corpDao.queryPrjFuncitonNums();
	}
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		IConstructionDao corpDao = new ConstructionDaoImpl();
		return corpDao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		IConstructionDao corpDao = new ConstructionDaoImpl();
		return corpDao.queryCity(provinceId);
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		IConstructionDao corpDao = new ConstructionDaoImpl();
		return corpDao.queryArea(cityId);
	}
	//�����
	public List<DictionaryClass> queryPrjApprovalLevelNums()
	{
		IConstructionDao corpDao = new ConstructionDaoImpl();
		return corpDao.queryPrjApprovalLevelNums();
	}
}
