package com.tj.jst.inner.business.planapply.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.designapply.model.DesignApply;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;

/**
 * 合同备案接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IPlanApplyDao {

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
	public ConstructionPlans queryApproval(String censorId);

	/**
	 * 审批通过
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalSuccess(ConstructionPlans plan);

	/**
	 * 审批不通过
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalFailed(ConstructionPlans plan);

	/**
	 * 检查审查阶段是否完成
	 * 
	 * @param prjNum
	 * @return
	 */
	public String queryFiling(String prjNum);

	/**
	 * 勘察和设计都成功完成后，更改项目基本信息
	 */
	public void updateProjectInfo(String prjNum);

	/**
	 * 查看是否有上传的文件
	 * 
	 * @param prjId
	 * @return
	 */
	public List downloadInfo(String prjId);
	
	/**
	 * 通过更改授权表状态
	 * 
	 * @param prjId
	 * @return
	 */
	public String changeAuthor(String prjId);

}
