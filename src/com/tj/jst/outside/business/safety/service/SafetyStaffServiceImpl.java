package com.tj.jst.outside.business.safety.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;
import com.tj.jst.outside.business.safety.dao.ISafetyStaffDao;
import com.tj.jst.outside.business.safety.dao.SafetyStaffDaoImpl;
import com.tj.jst.outside.business.safety.model.SafetyStaff;

/**
 * ʩ����ȫ��ҵ��Ա
 * @author hhc
 *
 */
public class SafetyStaffServiceImpl implements ISafetyStaffService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	
	public void add(SafetyStaff quality)
	{
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		dao.add(quality);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public SafetyStaff queryById(String qualityId)
	{
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		return dao.queryById(qualityId);
	}
	
	/**
	 * ��ȫ�ල�����޸�
	 * @return
	 */
	public void modify(SafetyStaff quality)
	{
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		dao.modify(quality);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String qualityId)
	{
		ISafetyStaffDao dao = new SafetyStaffDaoImpl();
		dao.delete(qualityId);
	}

	//֤������
	public List<DictionaryClass> queryCardTypeNums()
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryCardTypeNums();
	}
}
