package com.tj.jst.inner.business.promiseapply.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.permit.model.Permit;

/**
 * 施工许可服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IPromiseApplyService {

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
	public Permit queryApproval(String permitId);

	/**
	 * 审批通过
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalSuccess(Permit permit);

	/**
	 * 审批不通过
	 * 
	 * @param plan
	 * @return
	 */
	public String approvalFailed(Permit permit);

	/**
	 * 完成后，更改项目基本信息
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
