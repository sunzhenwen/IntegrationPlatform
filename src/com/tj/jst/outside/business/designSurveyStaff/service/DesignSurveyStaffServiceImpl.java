package com.tj.jst.outside.business.designSurveyStaff.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.designSurveyStaff.dao.DesignSurveyStaffDaoImpl;
import com.tj.jst.outside.business.designSurveyStaff.dao.IDesignSurveyStaffDao;
import com.tj.jst.outside.business.designSurveyStaff.model.DesignSurveyStaff;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;

/**
 * ���������ͼ��Ա
 * @author hhc
 *
 */
public class DesignSurveyStaffServiceImpl implements IDesignSurveyStaffService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	
	public void add(DesignSurveyStaff quality)
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		dao.add(quality);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public DesignSurveyStaff queryById(String qualityId)
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		return dao.queryById(qualityId);
	}
	
	/**
	 * ��ȫ�ල�����޸�
	 * @return
	 */
	public void modify(DesignSurveyStaff quality)
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		dao.modify(quality);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String qualityId)
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		dao.delete(qualityId);
	}

	//֤������
	public List<DictionaryClass> queryCardTypeNums()
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryCardTypeNums();
	}
	
	//ע�����ͼ��ȼ�
	public List<DictionaryClass> querySpecialtyTypNums()
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		return dao.querySpecialtyTypNums();
	}
	
	//�е���ɫ
	public List<DictionaryClass> queryPrjDutys()
	{
		IDesignSurveyStaffDao dao = new DesignSurveyStaffDaoImpl();
		return dao.queryPrjDutys();
	}
}
