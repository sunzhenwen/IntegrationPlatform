package com.tj.jst.inner.projectShare.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.projectShare.condition.QualityShareCondition;
import com.tj.jst.inner.projectShare.service.IProjectShareService;
import com.tj.jst.inner.projectShare.service.ProjectShareServiceImpl;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * 质量监督
 * @author Administrator
 *
 */
public class QualityShareAction extends BaseAction {
	
	private String qualityId;// 主键
	private Quality quality;// Model类
	//查询具有审批权的市列表
	private List<DictionaryClass> approvalCityList;
	private String approvalCityId;
	private List<DictionaryClass> approvalAreaList;
	private String result;

	private QualityShareCondition condition = new QualityShareCondition();

	public void setCondition(QualityShareCondition condition) {
		this.condition = condition;
	}

	public QualityShareCondition getCondition() {
		QualityShareCondition sessionCondition = (QualityShareCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 设计分页查询
	 * 
	 * @return
	 */
	public String queryPage() {
		IProjectShareService service = new ProjectShareServiceImpl();
		currentPage = service.queryQualitySharePage(this.getCondition());
		approvalCityList = service.queryApprovalCity();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 设计共享详细
	 * @return
	 */
	public String queryInfo() {
		IProjectShareService service = new ProjectShareServiceImpl();
		quality = service.queryQualityShareInfo(qualityId);
		return "queryInfo";
	}
	
	/**
	 * 查询区
	 * @return
	 */
	public String queryApprovaArea()
    {
		IProjectShareService service = new ProjectShareServiceImpl();
		approvalAreaList = service.queryApprovaArea(approvalCityId);
		JSONArray json = JSONArray.fromObject(approvalAreaList);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "goPage";
	}

	public String getQualityId() {
		return qualityId;
	}

	public void setQualityId(String qualityId) {
		this.qualityId = qualityId;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}

	public List<DictionaryClass> getApprovalCityList() {
		return approvalCityList;
	}

	public void setApprovalCityList(List<DictionaryClass> approvalCityList) {
		this.approvalCityList = approvalCityList;
	}

	public String getApprovalCityId() {
		return approvalCityId;
	}

	public void setApprovalCityId(String approvalCityId) {
		this.approvalCityId = approvalCityId;
	}

	public List<DictionaryClass> getApprovalAreaList() {
		return approvalAreaList;
	}

	public void setApprovalAreaList(List<DictionaryClass> approvalAreaList) {
		this.approvalAreaList = approvalAreaList;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
