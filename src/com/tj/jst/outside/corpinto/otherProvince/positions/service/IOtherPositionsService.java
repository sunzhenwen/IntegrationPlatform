package com.tj.jst.outside.corpinto.otherProvince.positions.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * ��ʡ��λ��Ա
 * @author Administrator
 *
 */
public interface IOtherPositionsService {

	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	
	//�����Ա
	public String add(Positions positions);
	
	//��ѯ����
	public Positions queryById(String personId);
	
	//�޸�
	public String modified(Positions positions);
	
	//ɾ��
	public String delete(String personId);
	
	//��ѯ��λ����
	public List<DictionaryClass> queryDuty();
	
	/**
     * ������ݿ����Ƿ���ڴ����֤��
     * @return
     */
	public List checkCardId(String cardId);
}
