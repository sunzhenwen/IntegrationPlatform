package com.tj.jst.outside.corpinto.otherProvince.project.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * ��ʡ��Ŀ����
 * @author Administrator
 *
 */
public interface IOtherProjectDao {
	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	/**
	 * ���
	 * @return
	 */
	public String add(Construction construction);
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public Construction queryById(String prjId);
	/**
	 * �޸�
	 * @return
	 */
	public void modify(Construction construction);
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String otherPrjId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//��ѯ��ϸ
	public Constructor queryDetailed(String idCard,String corpCode);

}
