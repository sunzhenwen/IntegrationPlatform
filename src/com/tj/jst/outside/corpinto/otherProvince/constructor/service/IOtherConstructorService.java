package com.tj.jst.outside.corpinto.otherProvince.constructor.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * ��ʡע�Ὠ��ʦ
 * @author Administrator
 *
 */
public interface IOtherConstructorService {

	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	
	//ѧ��
	public List<DictionaryClass> eduLevelNums();
	//ѧλ
	public List<DictionaryClass> degreeNums();
	//��ѯ��ϸ
	public Constructor queryDetailed(String idCard,String corpCode);
	//���м�����µ���������
	public boolean importData(String corpName,String corpCode);
	
	/**
	 * ���
	 * @return
	 */
	public void add(Constructor constructor);
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public Constructor queryById(String personId);
	/**
	 * �޸�
	 * @return
	 */
	public void modify(Constructor constructor);
	/**
	 * ɾ��
	 * @return
	 */
	public void deletePerson(String personId);
	
	//ְҵ�ʸ�״̬(1-8)(�ֵ��TBQSTATEDIC)
	public List<DictionaryClass> queryStates();
	//ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
	public List<DictionaryClass> queryRegTradeTypeNums();
	//������ҵ��ҵ����(�ֵ��TBCALLINGTYPEDIC)
	public List<DictionaryClass> queryCallingTypeNums();
	//ע�����ͼ��ȼ�(�ֵ��TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySepecialtyTypNums();
	//֤������(�ֵ��TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums();
	//����
	public List<DictionaryClass> nationAlityNums();
	
}
