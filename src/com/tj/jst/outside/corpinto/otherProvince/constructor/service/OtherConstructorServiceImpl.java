package com.tj.jst.outside.corpinto.otherProvince.constructor.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.CertdetailInfo;
import com.tj.jst.outside.business.contractFiling.model.Certinfo;
import com.tj.jst.outside.corpinto.otherProvince.constructor.dao.IOtherConstructorDao;
import com.tj.jst.outside.corpinto.otherProvince.constructor.dao.OtherConstructorDaoImpl;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * ��ʡע�Ὠ��ʦ
 * @author Administrator
 *
 */
public class OtherConstructorServiceImpl implements IOtherConstructorService {

	//��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.pagedQuery(condition);
	}

	//ѧ��
	@Override
	public List<DictionaryClass> eduLevelNums() {
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.eduLevelNums();
	}

	//ѧλ
	@Override
	public List<DictionaryClass> degreeNums() {
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.degreeNums();
	}

	//��ѯ��ϸ
	@Override
	public Constructor queryDetailed(String idCard,String corpCode) {
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryDetailed(idCard,corpCode);
	}

	//���м�����µ���������
	public boolean importData(String corpName,String corpCode)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		//��ѯ�н����е�����(����ʦ)
		List<Constructor> list = constructorDao.queryImportConstructor(corpName,corpCode);
		//��ѯ�н����е�����(������ʦ ��һרҵ)
		List<Constructor> listSupervisorOne = constructorDao.queryImportSupervisorOne(corpName,corpCode);
		//��ѯ�н����е�����(������ʦ �ڶ�רҵ)
		List<Constructor> listSupervisorTwo = constructorDao.queryImportSupervisorTwo(corpName,corpCode);
		//��ѯ�н����е�����(���˽���ʦ�ͼ�����ʦ�����)
		List<Constructor> listOther = constructorDao.queryImportOther(corpName,corpCode);
		//�м���ѯ��Ա��������
		List<Constructor> listBasePerson = constructorDao.queryBasePerson(corpCode);
		//��ѯ��ҵ�����м��(���ʱ�)
		List<CertdetailInfo> listCertdetailinfo = constructorDao.queryCertdetailinfo(corpCode);
		//��ѯ��ҵ�����м��(֤���)
		List<Certinfo> listCertinfo = constructorDao.queryCertinfo(corpCode);
		
		
		list.addAll(listSupervisorOne);
		list.addAll(listSupervisorTwo);
		list.addAll(listOther);
		listSupervisorOne = null;
		listSupervisorTwo = null;
		listOther = null;
		boolean checked = true;
		if(list.size()!=0)
		{
			//������Ա����
			boolean check = constructorDao.importData(list,corpCode);
			if(check==false)
			{
				checked = check;
			}
		}
		if(listBasePerson.size()!=0)
		{
			//������Ա��������
			boolean check = constructorDao.importBasePerson(listBasePerson,corpCode);
			if(check==false)
			{
				checked = check;
			}
		}
		if(listCertinfo.size()!=0)
		{
			//����֤���
			boolean check = constructorDao.importCertinfo(listCertinfo,corpCode);
			if(check==false)
			{
				checked = check;
			}
		}
		if(listCertdetailinfo.size()!=0)
		{
			//����������Ϣ��
			boolean check = constructorDao.importCertdetailinfo(listCertdetailinfo,corpCode);
			if(check==false)
			{
				checked = check;
			}
		}
		return checked;
	}
	
	/**
	 * ���
	 * @return
	 */
	public void add(Constructor constructor)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		constructorDao.add(constructor);
	}
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public Constructor queryById(String personId)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryById(personId);
	}
	/**
	 * �޸�
	 * @return
	 */
	public void modify(Constructor constructor)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		constructorDao.modify(constructor);
	}
	/**
	 * ɾ��
	 * @return
	 */
	public void deletePerson(String personId)
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		constructorDao.deletePerson(personId);
	}
	
	//ְҵ�ʸ�״̬(1-8)(�ֵ��TBQSTATEDIC)
	public List<DictionaryClass> queryStates()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryStates();
	}
	//ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
	public List<DictionaryClass> queryRegTradeTypeNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryRegTradeTypeNums();
	}
	//������ҵ��ҵ����(�ֵ��TBCALLINGTYPEDIC)
	public List<DictionaryClass> queryCallingTypeNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryCallingTypeNums();
	}
	//ע�����ͼ��ȼ�(�ֵ��TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySepecialtyTypNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.querySepecialtyTypNums();
	}
	//֤������(�ֵ��TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.queryIdCardTypeNums();
	}
	
	//����
	public List<DictionaryClass> nationAlityNums()
	{
		IOtherConstructorDao constructorDao = new OtherConstructorDaoImpl();
		return constructorDao.nationAlityNums();
	}
}
