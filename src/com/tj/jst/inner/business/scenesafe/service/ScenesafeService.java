package com.tj.jst.inner.business.scenesafe.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.business.scenesafe.model.ConstruScenesafe;
import com.tj.jst.inner.business.scenesafe.model.SceneSafe;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * 施工许可服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface ScenesafeService {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	/**
	 * 删除
	 * @return
	 */
	public void delete(String permitid);
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	
	public SceneSafe queryById(String permitid);
	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuerypage(Condition condition);

	/**
	 * 跳转审批页面
	 * 
	 * @param prjId
	 * @return
	 */
	public Permit queryApproval(String permitId);
	/**
	 * 现场安全监督
	 * @return
	 */
	public String add(SceneSafe scenesafe, List<ConstruScenesafe> construscenesafe);
	/**
	 * 现场安全监督
	 * @return
	 */
	public void modify(SceneSafe scenesafe, List<ConstruScenesafe> construscenesafe);

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
