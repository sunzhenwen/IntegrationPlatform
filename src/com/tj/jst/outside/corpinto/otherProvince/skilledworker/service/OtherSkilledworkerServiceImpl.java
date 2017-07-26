package com.tj.jst.outside.corpinto.otherProvince.skilledworker.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.skilledworker.dao.IOtherSkilledworkerDao;
import com.tj.jst.outside.corpinto.otherProvince.skilledworker.dao.OtherSkilledworkerDaoImpl;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;

/**
 * ��ʡע�Ἴ��������Ա
 * 
 * @author DarkFlameMaster
 *
 */
public class OtherSkilledworkerServiceImpl implements IOtherSkilledworkerService{

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.pagedQuery(condition);
	}

	/**
	 * ������Ա�����ѯ
	 */
	@Override
	public List<DictionaryClass> skilledTypeNums() {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.skilledTypeNums();
	}

	/**
	 * ������Ա�����ѯ
	 */
	@Override
	public List<DictionaryClass> skilledLevelNums() {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.skilledLevelNums();
	}

	/**
	 * ������Ա��Ϣ
	 */
	@Override
	public String addPersonInfo(Skilledworker skilledworker) {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		String message = "";
		//��ѯ������Ա���Ƿ����ظ�֤������
		message = skilledworkerDao.queryIdCardInfo(skilledworker.getIdentityCard(), skilledworker.getPersonId());
		if(!message.equals("�ɹ�"))
		{
			return message;
		}else
		{
			//����ְ����Ա���Ƿ����ظ�֤������
			message = skilledworkerDao.queryFromTitle(skilledworker.getIdentityCard());
			if(!message.equals("�ɹ�"))
			{
				return message;
			}else{
				//��ѯ��λ��Ա���Ƿ����ظ�֤������
				message = skilledworkerDao.queryFromPos(skilledworker.getIdentityCard());
				if(!message.equals("�ɹ�"))
				{
					return message;
				}else
				{
					return skilledworkerDao.addPersonInfo(skilledworker);
				}
			}
		}
	}

	/**
	 * �޸ļ�����Ա������Ϣ
	 */
	@Override
	public String modifyPersonInfo(Skilledworker skilledworker) {
		// TODO Auto-generated method stub
		String message = "";
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		message = skilledworkerDao.queryIdCardInfo(skilledworker.getIdentityCard(), skilledworker.getPersonId());
		if(!message.equals("�ɹ�"))
		{
			return message;
		}else
		{
			//����ְ����Ա���Ƿ����ظ�֤������
			message = skilledworkerDao.queryFromTitle(skilledworker.getIdentityCard());
			if(!message.equals("�ɹ�"))
			{
				return message;
			}else{
				//��ѯ��λ��Ա���Ƿ����ظ�֤������
				message = skilledworkerDao.queryFromPos(skilledworker.getIdentityCard());
				if(!message.equals("�ɹ�"))
				{
					return message;
				}else
				{
					return skilledworkerDao.modifyPersonInfo(skilledworker);
				}
			}
		}
	}

	/**
	 * �Ա��ѯ
	 */
	@Override
	public List<DictionaryClass> sexNums() {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.sexNums();
	}

	/**
	 * �����ѯ
	 */
	@Override
	public List<DictionaryClass> nationalNums() {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.nationalNums();
	}

	/**
	 * ѧ����ѯ
	 */
	@Override
	public List<DictionaryClass> eduLevelNums() {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.eduLevelNums();
	}

	/**
	 * ѧλ��ѯ
	 */
	@Override
	public List<DictionaryClass> degreeNums() {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.degreeNums();
	}

	/**
	 * ֤�����Ͳ�ѯ
	 */
	@Override
	public List<DictionaryClass> idCardTypeNums() {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.idCardTypeNums();
	}

	/**
	 * ����personid��ֵ�޸���Ա��Ϣ
	 * @param personId
	 * @return
	 */
	@Override
	public Skilledworker queryById(String personId) {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.queryById(personId);
	}

	/**
	 * ����personId��ֵ��ɾ����Ա
	 * @param personId
	 * @return
	 */
	@Override
	public String delete(String personId) {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.deletePersonInfo(personId);
	}

	/**
	 * ����������� identitycard �� personId ����Ϣ��ȷ���Ƿ����ظ���IDCard��Ϣ
	 * @param identitycard
	 * @return
	 */
	@Override
	public String queryIdCardInfo(String identitycard,String personId) {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.queryIdCardInfo(identitycard,personId);
	}

	/**
	 * ���ݴ����idcardֵ���ж��Ƿ����ظ�
	 */
	@Override
	public String queryFromTitle(String identitycard) {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.queryFromTitle(identitycard);
	}

	/**
	 * ���ݴ����idcardֵ���ж��Ƿ����ظ�
	 */
	@Override
	public String queryFromPos(String identitycard) {
		// TODO Auto-generated method stub
		IOtherSkilledworkerDao skilledworkerDao = new OtherSkilledworkerDaoImpl();
		return skilledworkerDao.queryFromPos(identitycard);
	}

}
