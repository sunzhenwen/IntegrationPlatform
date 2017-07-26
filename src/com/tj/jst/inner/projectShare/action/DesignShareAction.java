package com.tj.jst.inner.projectShare.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.projectShare.condition.DesignShareCondition;
import com.tj.jst.inner.projectShare.service.IProjectShareService;
import com.tj.jst.inner.projectShare.service.ProjectShareServiceImpl;
import com.tj.jst.outside.business.design.model.Design;

/**
 * ��ƹ����ѯ
 * @author Administrator
 *
 */
public class DesignShareAction extends BaseAction {
	
	// ����
	private String designId;
	private Design design;

	private DesignShareCondition condition = new DesignShareCondition();

	public void setCondition(DesignShareCondition condition) {
		this.condition = condition;
	}

	public DesignShareCondition getCondition() {
		DesignShareCondition sessionCondition = (DesignShareCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��Ʒ�ҳ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		IProjectShareService service = new ProjectShareServiceImpl();
		currentPage = service.queryDesignSharePage(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ƹ�����ϸ
	 * @return
	 */
	public String queryInfo() {
		IProjectShareService service = new ProjectShareServiceImpl();
		design = service.queryDesignShareInfo(designId);
		return "queryInfo";
	}
	
	/**
	 * ����
	 * 
	 * @return
	 */
	public String goPage() {
		return "goPage";
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}
}
