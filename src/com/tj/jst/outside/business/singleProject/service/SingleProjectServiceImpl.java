package com.tj.jst.outside.business.singleProject.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.singleProject.dao.ISingleProjectDao;
import com.tj.jst.outside.business.singleProject.dao.SingleProjectDaoImpl;
import com.tj.jst.outside.business.singleProject.model.SingleProject;

/**
 * 单体工程
 * @author hhc
 *
 */
public class SingleProjectServiceImpl implements ISingleProjectService {
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * 添加
	 * @param construction
	 * @return
	 */
	public void add(SingleProject singleProject)
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		dao.add(singleProject);
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public SingleProject queryById(long spId)
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		SingleProject sp = dao.queryById(spId);
		//获取单位编码
		String spNum = sp.getSpNum();
		if(spNum.contains("-"))
		{
			int end = spNum.indexOf("-");
			//截取主体工程编号
			String subSpNum = spNum.substring(0, end);
			sp.setPrjNum(subSpNum);
		}else
		{
			
			String subSpNum = spNum.substring(0, 15);
			sp.setPrjNum(subSpNum);
		}
		
		return sp;
	}
	
	/**
	 * 修改
	 * @param construction
	 * @return
	 */
	public void modify(SingleProject singleProject)
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		dao.modify(singleProject);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(long id)
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		dao.delete(id);
	}

	//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		ISingleProjectDao dao = new SingleProjectDaoImpl();
		return dao.queryPrjStructureTypeNums();
	}


}
