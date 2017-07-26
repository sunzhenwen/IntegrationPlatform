package com.tj.jst.outside.business.permit.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.model.Permit;

/**
 * ʩ�����
 * @author hhc
 *
 */
public interface IPermitService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ʩ���������
	 * @return
	 */
	public String add(Permit permit);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId);
	
	/**
	 * ʩ����������޸�
	 * @return
	 */
	public void modify(Permit permit);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String permitId);
	
	//֤������
	public List<DictionaryClass> queryCardTypeNums();
	
	/**
	 * ʩ�����,������Ϣ��ѯ
	 * @author Administrator
	 *
	 */
	public Page pagedQueryQuality(Condition condition);
	
	/**
	 * ʩ�����,��ȫ��Ϣ��ѯ
	 * @author Administrator
	 *
	 */
	public Page pagedQueryPermSafety(Condition condition);
	
	/**
	 * ʩ�����,ʩ��ͼ���ϸ�����
	 * @param condition
	 * @return
	 */
	public Page pagedQueryPlanNum(Condition condition);
}
