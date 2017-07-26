package com.tj.jst.outside.corpinto.otherProvince.constructor.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.CertdetailInfo;
import com.tj.jst.outside.business.contractFiling.model.Certinfo;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * ��ʡע�Ὠ��ʦ
 * @author Administrator
 *
 */
public interface IOtherConstructorDao {
	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	//ѧ��
	public List<DictionaryClass> eduLevelNums();
	//ѧλ
	public List<DictionaryClass> degreeNums();
	//��ѯ��ϸ
	public Constructor queryDetailed(String idCard,String corpCode);
	//��ѯ�н����е�����(����ʦ)
	public List<Constructor> queryImportConstructor(String corpName,String corpCode);
	//��ѯ�н����е�����(������ʦ ��һרҵ)
	public List<Constructor> queryImportSupervisorOne(String corpName,String corpCode);
	//��ѯ�н����е�����(������ʦ �ڶ�רҵ)
	public List<Constructor> queryImportSupervisorTwo(String corpName,String corpCode);
	//��ѯ�н����е�����(���˽���ʦ�ͼ�����ʦ�����)
	public List<Constructor> queryImportOther(String corpName,String corpCode);
	//���м�����µ���������
	public boolean importData(List<Constructor> list,String corpCode);
	//���м�������������
	public List<Constructor> queryBasePerson(String corpCode);
	//���м�������������
	public boolean importBasePerson(List<Constructor> listBasePerson,String corpCode);
	//��ѯ��ҵ�����м��(���ʱ�)
	public List<CertdetailInfo> queryCertdetailinfo(String corpCode);
	//��ѯ��ҵ�����м��(֤���)
	public List<Certinfo> queryCertinfo(String corpCode);
	
	//����֤���
	public boolean importCertinfo(List<Certinfo> listCertinfo,String corpCode);
	//����������Ϣ��
	public boolean importCertdetailinfo(List<CertdetailInfo> listCertdetailinfo,String corpCode);

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
