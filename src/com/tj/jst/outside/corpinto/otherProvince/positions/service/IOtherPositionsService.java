package com.tj.jst.outside.corpinto.otherProvince.positions.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * 外省岗位人员
 * @author Administrator
 *
 */
public interface IOtherPositionsService {

	//分页查询
	public Page pagedQuery(Condition condition);
	
	//添加人员
	public String add(Positions positions);
	
	//查询单挑
	public Positions queryById(String personId);
	
	//修改
	public String modified(Positions positions);
	
	//删除
	public String delete(String personId);
	
	//查询岗位名称
	public List<DictionaryClass> queryDuty();
	
	/**
     * 检测数据库中是否存在此身份证号
     * @return
     */
	public List checkCardId(String cardId);
}
