package com.tj.jst.outside.business.permit.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import pojo.CORP_AQSCXKZ;
import ws.client.tenderinfo.InfoClient;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.dao.IPermitDao;
import com.tj.jst.outside.business.permit.dao.PermitDaoImpl;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * ʩ�����
 * @author hhc
 *
 */
public class PermitServiceImpl implements IPermitService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IPermitDao dao = new PermitDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ʩ���������
	 * @return
	 */
	public String add(Permit permit)
	{
		IPermitDao dao = new PermitDaoImpl();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String fDate = simpleDateFormat.format(c.getTime());
		String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 7);
		String builderLicenceNum = permit.getAppDept() + fDate
				+ permit.getPrjNum().substring(12, 16) + "-SX-" + serNum;
		permit.setBuilderLicenceNum(builderLicenceNum);
		return dao.add(permit);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId)
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryById(permitId);
	}
	
	/**
	 * ʩ����������޸�
	 * @return
	 */
	public void modify(Permit permit)
	{
		IPermitDao dao = new PermitDaoImpl();
		dao.modify(permit);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String permitId)
	{
		IPermitDao dao = new PermitDaoImpl();
		dao.delete(permitId);
	}

	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryAppDept();
	}
	
	//֤������
	public List<DictionaryClass> queryCardTypeNums()
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.queryCardTypeNums();
	}
	
	/**
	 * ʩ�����,������Ϣ��ѯ
	 * @author Administrator
	 *
	 */
	public Page pagedQueryQuality(Condition condition)
	{
		IPermitDao dao = new PermitDaoImpl();
		Page page = dao.pagedQueryQuality(condition);
		InfoClient ic = new InfoClient();
		for(int i=0;i<page.getData().size();i++)
		{
			//ʩ����λ����
			String corpName = ((Quality)page.getData().get(i)).getConstructionUnit();
			//ʩ����λ��֯��������
			String corpCode = ((Quality)page.getData().get(i)).getConstructionCode();
			//ͨ���ӿڻ�ȡ��ȫ�������֤
			List<CORP_AQSCXKZ> cas = ic.getCORP_AQSCXKZList(corpCode, corpName, "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			
			//ѭ�����صİ�ȫ�������֤��Ϣ
			for(int j=0;j<cas.size();j++)
			{
				//�����ȫ�������֤��Ч
				if(cas.get(j).getFState().equals("��Ч"))
				{
					((Quality)page.getData().get(i)).setSafetyCerId(cas.get(0).getFCertNumber());
				}
			}
			
		}
		return page;
	}

	/**
	 * ʩ�����,��ȫ��Ϣ��ѯ
	 * @author Administrator
	 *
	 */
	public Page pagedQueryPermSafety(Condition condition)
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.pagedQueryPermSafety(condition);
	}
	
	/**
	 * ʩ�����,ʩ��ͼ���ϸ�����
	 * @param condition
	 * @return
	 */
	public Page pagedQueryPlanNum(Condition condition)
	{
		IPermitDao dao = new PermitDaoImpl();
		return dao.pagedQueryPlanNum(condition);
	}
}
