package com.tj.jst.inner.business.cityCount.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.cityCount.model.CityCount;
import com.tj.jst.inner.business.cityCount.service.CityCountServiceImpl;
import com.tj.jst.inner.business.cityCount.service.ICityCountService;

/**
 * ������Ŀͳ��
 * 
 * @author Administrator
 *
 */
public class CityCountAction extends BaseAction {

	private List<CityCount> list;
	
	/**
	 * ��ѯ
	 * 
	 * @return
	 */
	public String queryCount() {
		ICityCountService service = new CityCountServiceImpl();
		list = service.queryCount();
		return "queryCount";
	}
	
	public List<CityCount> getList() {
		return list;
	}

	public void setList(List<CityCount> list) {
		this.list = list;
	}

}
