package com.tj.jst.inner.announce.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.announce.condition.AnnounceCondition;
import com.tj.jst.inner.announce.model.Announce;
import com.tj.jst.inner.announce.service.AnnounceServiceImpl;
import com.tj.jst.inner.announce.service.IAnnounceService;

/**
 * ������Ϣ������
 * 
 * @author DarkFlameMaster
 *
 */
public class AnnounceAction extends BaseAction {

	private Announce announce;// Model��
	private String announceId;// ��ѯ����
	private String message;// ��ʾ��Ϣ

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
	 * ��ѯ��ҳ
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
	 * ���ӷ�����Ϣҳ��
	 * 
	 * @return
	 */
	public String addPage() {
		return "addPage";
	}

	/**
	 * ���ӷ�����Ϣ����
	 * 
	 * @return
	 */
	public String addAction() {
		IAnnounceService service = new AnnounceServiceImpl();
		message = service.addAnnounce(announce);
		return "query";
	}

	/**
	 * �޸���Ϣҳ��
	 * 
	 * @return
	 */
	public String modifyPage() {
		IAnnounceService service = new AnnounceServiceImpl();
		announce = service.queryById(announceId);
		return "modifyPage";
	}

	/**
	 * �޸���Ϣ����
	 * 
	 * @return
	 */
	public String modifyAction() {
		IAnnounceService service = new AnnounceServiceImpl();
		message = service.modifyAnnounce(announce);
		return "query";
	}

	/**
	 * ���ط���
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
