package com.tj.jst.outside.corpinto.otherProvince.positions.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.otherProvince.positions.dao.IOtherPositionsDao;
import com.tj.jst.outside.corpinto.otherProvince.positions.dao.OtherPositionsDaoImpl;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * 外省岗位人员
 * @author Administrator
 *
 */
public class OtherPositionsServiceImpl implements IOtherPositionsService {

	//分页查询
	@Override
	public Page pagedQuery(Condition condition) {
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.pagedQuery(condition);
	}
	
	//添加人员
	public String add(Positions positions)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.add(positions);
	}
	
	//查询单挑
	public Positions queryById(String personId)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.queryById(personId);
	}
	
	//查询单挑
	public String modified(Positions positions)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.modified(positions);
	}
	
	//删除
	public String delete(String personId)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.delete(personId);
	}
	
	//查询岗位名称
	public List<DictionaryClass> queryDuty()
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.queryDuty();
	}
	
	/**
     * 检测数据库中是否存在此身份证号
     * @return
     */
	public List checkCardId(String cardId)
	{
		IOtherPositionsDao constructorDao = new OtherPositionsDaoImpl();
		return constructorDao.checkCardId(cardId);
	}
}
