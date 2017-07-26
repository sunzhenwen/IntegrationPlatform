package com.tj.jst.inner.corpfilings.notforeign.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.corpfilings.notforeign.dao.CorpFilingsDaoImpl;
import com.tj.jst.inner.corpfilings.notforeign.dao.ICorpFilingsDao;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ��ҵ����
 * 
 * @author Administrator
 *
 */
public class CorpFilingsServiceImpl implements ICorpFilingsService {

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.pagedQuery(condition);
	}

	/**
	 * ����ҵ���
	 * 
	 * @return
	 */
	@Override
	public void addCorp(Corp corp) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		if (corp.getCheckForeign().equals("0")) {
			// ������ҵ
			dao.addForeignCorp(corp);
		} else {
			// ��������ҵ
			dao.addCorp(corp);
		}

	}

	/**
	 * ��ת�޸�ҳ��
	 * 
	 * @return
	 */
	public Corp modifyCorpPage(String corpId) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryCorpForId(corpId);
	}

	/**
	 * ��ҵ�޸�
	 * 
	 * @return
	 */
	@Override
	public void modifyCorp(Corp corp) {
		// TODO Auto-generated method stub
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		dao.modifyCorp(corp);
	}

	/**
	 * ��ת����ҳ��
	 * 
	 * @return
	 */
	public Corp applyCorpPage(String corpId) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		// ��ѯ��������
		return dao.queryCorpForId(corpId);
	}

	/**
	 * ����ͨ��
	 * 
	 * @return
	 */
	public void applythrough(Corp corp) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();

		dao.applythrough(corp);
	}

	/**
	 * ����δͨ��
	 * 
	 * @return
	 */
	public void applyThroughBack(Corp corp) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		dao.applyThroughBack(corp);
	}

	// ��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryProvince();
	}

	// ��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryCity(provinceId);
	}

	// ��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryArea(cityId);
	}

	/**
	 * ��֯��������֤�ظ��ж�
	 */
	@Override
	public String queryCorpCode(String corpCode) {
		// TODO Auto-generated method stub
		ICorpFilingsDao dao = new CorpFilingsDaoImpl();
		return dao.queryCorpCode(corpCode);
	}

}
