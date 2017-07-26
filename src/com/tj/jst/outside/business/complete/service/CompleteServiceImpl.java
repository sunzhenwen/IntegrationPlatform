package com.tj.jst.outside.business.complete.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.dao.CompleteDaoImpl;
import com.tj.jst.outside.business.complete.dao.ICompleteDao;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;

/**
 * ��������
 * @author hhc
 *
 */
public class CompleteServiceImpl implements ICompleteService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ������������
	 * @return
	 */
	public String add(Complete complete)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 8);
		String prjFinishNum = complete.getAppDept() + fDate
				+ complete.getPrjNum().substring(12, 16) + "-JX-" + serNum;
		complete.setPrjFinishNum(prjFinishNum);
		return dao.add(complete);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Complete queryById(String completeId)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.queryById(completeId);
	}
	
	/**
	 * �������������޸�
	 * @return
	 */
	public void modify(Complete complete)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		dao.modify(complete);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String completeId)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		dao.delete(completeId);
	}

	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.queryAppDept();
	}
	
	//�ṹ��ϵ
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.queryPrjStructureTypeNums();
	}
	
	/**
	 * ��������,ʩ�������Ϣ��ѯ
	 * @author Administrator
	 *
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		ICompleteDao dao = new CompleteDaoImpl();
		return dao.pagedTbInfoQuery(condition);
	}
}
