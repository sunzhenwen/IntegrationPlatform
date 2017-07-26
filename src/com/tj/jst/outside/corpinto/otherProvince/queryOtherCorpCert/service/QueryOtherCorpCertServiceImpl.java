package com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.Certdetail;
import com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.dao.IQueryOtherCorpCertDao;
import com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.dao.QueryOtherCorpCertDaoImpl;

/**
 * ��ѯ��ʡ������ҵӵ������
 * 
 * @author Administrator
 *
 */
public class QueryOtherCorpCertServiceImpl implements IQueryOtherCorpCertService {

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.queryPage(condition);
	}

	//�����ʸ�����(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> qualificationsTypes()
	{
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.qualificationsTypes();
	}
	
	//�����ʸ�����
	public List<DictionaryClass> queryTradeTypeNum(String qualificationsType)
	{
		String requirement = "";
		if("1".equals(qualificationsType))
		{
			//���̿���
			requirement = "101";
		}else if("2".equals(qualificationsType))
		{
			//�������
			requirement = "102";
		}else if("3".equals(qualificationsType))
		{
			//����ҵ
			requirement = "104";
		}else if("4".equals(qualificationsType))
		{
			//���̼���
			requirement = "105";
		}else if("5".equals(qualificationsType))
		{
			//�����б����
			requirement = "103";
		}else if("6".equals(qualificationsType))
		{
			//���ʩ��һ�廯
			requirement = "113";
		}else
		{
			requirement = "sdfgsdfgsdf";
		}
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.queryTradeTypeNum(requirement);
	}
	
	//�����ʸ�ȼ�(TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryRating(String qualificationsType)
	{
		String requirement = "";
		if("1".equals(qualificationsType))
		{
			//���̿���
			requirement = "���̿���";
		}else if("2".equals(qualificationsType))
		{
			//�������
			requirement = "�������";
		}else if("3".equals(qualificationsType))
		{
			//����ҵ
			requirement = "����ҵ";
		}else if("4".equals(qualificationsType))
		{
			//���̼���
			requirement = "���̼���";
		}else if("5".equals(qualificationsType))
		{
			//�����б����
			requirement = "�����б����";
		}else if("6".equals(qualificationsType))
		{
			//���ʩ��һ�廯
			requirement = "���ʩ��һ�廯";
		}else if("7".equals(qualificationsType))
		{
			requirement = "���������ѯ";
		}else if("8".equals(qualificationsType))
		{
			requirement = "��ȫ�������";
		}else if("9".equals(qualificationsType))
		{
			requirement = "ʩ��ͼ���";
		}else if("10".equals(qualificationsType))
		{
			requirement = "�������";
		}else if("11".equals(qualificationsType))
		{
			requirement = "����滮";
		}else if("12".equals(qualificationsType))
		{
			requirement = "԰���̻�";
		}else
		{
			requirement = "aaasgasdfgsdfgd";
		}
		
		
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.queryRating(requirement);
	}
	
	/**
	 * רҵ���(TBTRADETYPEBOUNDDIC)
	 * @return
	 */
	public List<DictionaryClass> specialtyType(String specialtyType)
	{
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		return dao.specialtyType(specialtyType);
	}
	
	//���
	public void add(Certdetail certdetail)
	{
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		dao.add(certdetail);
	}
	
	//ɾ��
	public void deleteCer(String id)
	{
		IQueryOtherCorpCertDao dao = new QueryOtherCorpCertDaoImpl();
		dao.deleteCer(id);
	}
}
