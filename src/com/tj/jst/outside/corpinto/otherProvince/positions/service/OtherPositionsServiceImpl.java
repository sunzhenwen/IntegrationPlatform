package com.tj.jst.outside.corpinto.otherProvince.positions.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.positions.dao.IOtherPositionsDao;
import com.tj.jst.outside.corpinto.otherProvince.positions.dao.OtherPositionsDaoImpl;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * ��ʡ��λ��Ա
 * @author Administrator
 *
 */
public class OtherPositionsServiceImpl implements IOtherPositionsService {

	//��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.pagedQuery(condition);
	}
	
	//�����Ա
	public String add(Positions positions)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.add(positions);
	}
	
	//��ѯ����
	public Positions queryById(String personId)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.queryById(personId);
	}
	
	//��ѯ����
	public String modified(Positions positions)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.modified(positions);
	}
	
	//ɾ��
	public String delete(String personId)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.delete(personId);
	}
	
	//��ѯ��λ����
	public List<DictionaryClass> queryDuty()
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.queryDuty();
	}
	
	/**
     * ������ݿ����Ƿ���ڴ����֤��
     * @return
     */
	public List checkCardId(String cardId)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.checkCardId(cardId);
	}
}
