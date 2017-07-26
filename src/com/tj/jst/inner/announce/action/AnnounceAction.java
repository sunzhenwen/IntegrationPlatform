package com.tj.jst.inner.announce.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.announce.condition.AnnounceCondition;
import com.tj.jst.inner.announce.model.Announce;
import com.tj.jst.inner.announce.service.AnnounceServiceImpl;
import com.tj.jst.inner.announce.service.IAnnounceService;

/**
 * 发布信息方法类
 * 
 * @author DarkFlameMaster
 *
 */
public class AnnounceAction extends BaseAction {

	private Announce announce;// Model类
	private String announceId;// 查询主键
	private String message;// 提示信息

	private AnnounceCondition condition = new AnnounceCondition();

	public void setCondition(AnnounceCondition condition) {
		this.condition = condition;
	}

	public AnnounceCondition getCondition() {
		AnnounceCondition sessionCondition = (AnnounceCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 查询分页
	 * 
	 * @return
	 */
	public String queryPage() {
		IAnnounceService service = new AnnounceServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 增加发布信息页面
	 * 
	 * @return
	 */
	public String addPage() {
		return "addPage";
	}

	/**
	 * 增加发布信息方法
	 * 
	 * @return
	 */
	public String addAction() {
		IAnnounceService service = new AnnounceServiceImpl();
		message = service.addAnnounce(announce);
		return "query";
	}

	/**
	 * 修改信息页面
	 * 
	 * @return
	 */
	public String modifyPage() {
		IAnnounceService service = new AnnounceServiceImpl();
		announce = service.queryById(announceId);
		return "modifyPage";
	}

	/**
	 * 修改信息方法
	 * 
	 * @return
	 */
	public String modifyAction() {
		IAnnounceService service = new AnnounceServiceImpl();
		message = service.modifyAnnounce(announce);
		return "query";
	}

	/**
	 * 返回方法
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public Announce getAnnounce() {
		return announce;
	}

	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

	public String getAnnounceId() {
		return announceId;
	}

	public void setAnnounceId(String announceId) {
		this.announceId = announceId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
