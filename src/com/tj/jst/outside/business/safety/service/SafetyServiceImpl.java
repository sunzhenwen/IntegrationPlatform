package com.tj.jst.outside.business.safety.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.safety.dao.ISafetyDao;
import com.tj.jst.outside.business.safety.dao.SafetyDaoImpl;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * ��ȫ�ල
 * @author hhc
 *
 */
public class SafetyServiceImpl implements ISafetyService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ISafetyDao dao = new SafetyDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ȫ�ල����
	 * @return
	 */
	public String add(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours)
	{
		ISafetyDao dao = new SafetyDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 6);
		String safetyNum = quality.getAppDept() + fDate
				+ quality.getPrjNum().substring(12, 16) + "-SA-" + serNum;
		quality.setSafetyNum(safetyNum);
		return dao.add(quality,constructionSafety,majors,labours);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Safety queryById(String qualityId)
	{
		ISafetyDao dao = new SafetyDaoImpl();
		return dao.queryById(qualityId);
	}
	
	/**
	 * ��ȫ�ල�����޸�
	 * @return
	 */
	public void modify(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours)
	{
		ISafetyDao dao = new SafetyDaoImpl();
		dao.modify(quality,constructionSafety,majors,labours);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String qualityId)
	{
		ISafetyDao dao = new SafetyDaoImpl();
		dao.delete(qualityId);
	}

	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		ISafetyDao dao = new SafetyDaoImpl();
		return dao.queryAppDept();
	}
	
	//��������
	public List<DictionaryClass> queryProjectTypes()
	{
		ISafetyDao dao = new SafetyDaoImpl();
		return dao.queryProjectTypes();
	}
}
