package com.tj.jst.inner.business.designapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.designapply.model.DesignApply;

/**
 * 项目设计阶段接口类
 * 
 * @author DarkFlameMaster
 *
 */
public interface IDesignApplyService {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * 跳转审批页面
	 * 
	 * @param prjId
	 * @return
	 */
	public DesignApply queryApproval(String designId);

	/**
	 * 审批通过
	 * 
	 * @param project
	 * @return
	 */
	public String applySuccess(DesignApply design);

	/**
	 * 审批退回
	 * 
	 * @param project
	 * @return
	 */
	public String applyFaile(DesignApply design);

	/**
	 * 检查勘察阶段是否完成
	 * 
	 * @param prjNum
	 * @return
	 */
	public String querySurvey(String prjNum);

	/**
	 * 勘察和设计都成功完成后，更改项目基本信息
	 */
	public void updateProjectInfo(String prjNum);

	/**
	 * 审批附页
	 * 
	 * @param desingId
	 * @return
	 */
	public Page sidebyPage(Condition condition);
	
	/**
	 * 查看是否有上传的文件
	 * 
	 * @param prjId
	 * @return
	 */
	public List downloadInfo(String prjId);
}
