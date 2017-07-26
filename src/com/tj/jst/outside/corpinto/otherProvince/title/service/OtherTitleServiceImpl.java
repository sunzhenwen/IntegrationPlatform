package com.tj.jst.outside.corpinto.otherProvince.title.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.title.dao.IOtherTitleDao;
import com.tj.jst.outside.corpinto.otherProvince.title.dao.OtherTitleDaoImpl;
import com.tj.jst.outside.staffmanage.title.model.Title;

/**
 * ��ʡְ����Ա
 * @author Administrator
 *
 */
public class OtherTitleServiceImpl implements IOtherTitleService {

	//��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.pagedQuery(condition);
	}

	/**
	 * ����ְ����Ա������Ϣ
	 */
	@Override
	public String add(Title title) {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		String message = "";
		//��ѯ��λ��Ա���Ƿ����ظ�����
		message = titleDao.queryIdCardInfo(title.getIdCard(), title.getPersonId());
		if(!message.equals("�ɹ�"))
		{
			return message;
		}else
		{
			message = titleDao.queryFormPos(title.getIdCard());
			if(!message.equals("�ɹ�"))
			{
				return message;
			}else
			{
				message = titleDao.queryFormSkill(title.getIdCard());
				if(!message.equals("�ɹ�"))
				{
					return message;
				}else
				{
					return titleDao.add(title);
				}
			}
		}
	}
	
	/**
	 * �޸�ְ����Ա��Ϣ
	 */
	@Override
	public String modify(Title title) {
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		String message = "";
		message = titleDao.queryIdCardInfo(title.getIdCard(), title.getPersonId());
		if(!message.equals("�ɹ�"))
		{
			return message;
		}else
		{
			message = titleDao.queryFormSkill(title.getIdCard());
			if(!message.equals("�ɹ�"))
			{
				return message;
			}else
			{
				message = titleDao.queryFormPos(title.getIdCard());
				if(!message.equals("�ɹ�"))
				{
					return message;
				}else
				{
					return titleDao.modify(title);
				}
			}
		}
	}

	/**
	 * ͨ��PersonId���жϽ���ɾ��������ְ����Ա��Ϣ
	 */
	@Override
	public String delete(String personId) {
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.delete(personId);
	}

	/**
	 * �ֵ䣺�Ա���
	 */
	@Override
	public List<DictionaryClass> querySexNums() {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.querySexNums();
	}

	/**
	 * �ֵ䣺֤��������
	 */
	@Override
	public List<DictionaryClass> queryIdCardTypeNums() {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryIdCardTypeNums();
	}

	/**
	 * ����personId��Ѱ�ҽ���ɾ�������޸Ĳ�������Ա��Ϣ
	 */
	@Override
	public Title queryById(String personId) {
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryById(personId);
	}

	/**
	 * ͨ��idCard��personId���ж�֤�������Ƿ��ظ�
	 */
	@Override
	public String queryIdCardInfo(String idCard, String personId) {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryIdCardInfo(idCard, personId);
	}

	/**
	 * ��ѯ������Ա���ж��Ƿ����ظ�֤������
	 */
	@Override
	public String queryFormSkill(String idCard) {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryFormSkill(idCard);
	}

	/**
	 * ��ѯ��λ��Ա�Ƿ����ظ�֤������
	 */
	@Override
	public String queryFormPos(String idCard) {
		// TODO Auto-generated method stub
		IOtherTitleDao titleDao = new OtherTitleDaoImpl();
		return titleDao.queryFormPos(idCard);
	}
	
}
