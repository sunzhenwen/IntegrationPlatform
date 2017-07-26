package com.tj.jst.outside.business.constructionPlans.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工图审查
 * @author hhc
 *
 */
public class ConstructionPlans {

	private int censorId; //主键
	private String censorNum; //施工图审查合格证书编号
	private String prjNum; //项目编号
	private String prjName; //项目名称
	private String prjId;//项目报建主键
	private String censorCorpName; //施工图审查机构名称
	private String censorCorpCode; //施工图审查机构组织机构代码
	private Date censorEDate; //审查完成日期
	private String prjSize; //建设规模
	private String econCorpName; //勘察单位名称
	private String econCorpCode; //勘察单位组织机构代码
	private String econCorpName2; //勘察单位名称2
	private String econCorpCode2; //勘察单位组织机构代码2
	private String econCorpName3; //勘察单位名称3
	private String econCorpCode3; //勘察单位组织机构代码3
	private String designCorpName; //设计单位名称
	private String designCorpCode; //设计单位组织机构代码
	private String designCorpName2; //设计单位名称2
	private String designCorpCode2; //设计单位组织机构代码2
	private String designCorpName3; //设计单位名称3
	private String designCorpCode3; //设计单位组织机构代码3
	private String oneCensorIsPass; //一次审查是否通过 通过1、不通过0
	private String oneCensorWfqtCount; //一次审查时违反强条数
	private String oneCensorWfqtContent; //一次审查时违反的强条条目
	private Date createDate; //记录登记日期
	private String applyCorpCode; //申请企业组织机构代码
	private String applyCorpName; //申请企业名称
	private String appSteffId; //审批人id
	private String appSteffName; //审批人姓名
	private Date appDate; //审批时间
	private String appOpinion; //审批意见
	private List<Upload> list = new ArrayList<Upload>();//附件
	/**
	 * 审批状态
	 * 项目报建：0、申请，1、审批通过，2、审批未通过
	 */
	private String appType;//审批状态
	/**
	 * 流程步骤
	 * 1:项目报建
	 * 2:勘察阶段、设计阶段
	 * 3:合同备案、施工图审查备案
	 * 4:质量监督、安全监督
	 * 5:施工许可
	 * 6:竣工验收
	 */
	private String processSteps;
	private String appDept;//审批单位id
	private String appDeptName;//审批单位名称
	

	public int getCensorId() {
		return censorId;
	}
	public void setCensorId(int censorId) {
		this.censorId = censorId;
	}
	public String getCensorNum() {
		return censorNum;
	}
	public void setCensorNum(String censorNum) {
		this.censorNum = censorNum;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getCensorCorpName() {
		return censorCorpName;
	}
	public void setCensorCorpName(String censorCorpName) {
		this.censorCorpName = censorCorpName;
	}
	public String getCensorCorpCode() {
		return censorCorpCode;
	}
	public void setCensorCorpCode(String censorCorpCode) {
		this.censorCorpCode = censorCorpCode;
	}
	public Date getCensorEDate() {
		return censorEDate;
	}
	public void setCensorEDate(Date censorEDate) {
		this.censorEDate = censorEDate;
	}
	public String getPrjSize() {
		return prjSize;
	}
	public void setPrjSize(String prjSize) {
		this.prjSize = prjSize;
	}
	public String getEconCorpName() {
		return econCorpName;
	}
	public void setEconCorpName(String econCorpName) {
		this.econCorpName = econCorpName;
	}
	public String getEconCorpCode() {
		return econCorpCode;
	}
	public void setEconCorpCode(String econCorpCode) {
		this.econCorpCode = econCorpCode;
	}
	public String getEconCorpName2() {
		return econCorpName2;
	}
	public void setEconCorpName2(String econCorpName2) {
		this.econCorpName2 = econCorpName2;
	}
	public String getEconCorpCode2() {
		return econCorpCode2;
	}
	public void setEconCorpCode2(String econCorpCode2) {
		this.econCorpCode2 = econCorpCode2;
	}
	public String getEconCorpName3() {
		return econCorpName3;
	}
	public void setEconCorpName3(String econCorpName3) {
		this.econCorpName3 = econCorpName3;
	}
	public String getEconCorpCode3() {
		return econCorpCode3;
	}
	public void setEconCorpCode3(String econCorpCode3) {
		this.econCorpCode3 = econCorpCode3;
	}
	public String getDesignCorpName() {
		return designCorpName;
	}
	public void setDesignCorpName(String designCorpName) {
		this.designCorpName = designCorpName;
	}
	public String getDesignCorpCode() {
		return designCorpCode;
	}
	public void setDesignCorpCode(String designCorpCode) {
		this.designCorpCode = designCorpCode;
	}
	public String getDesignCorpName2() {
		return designCorpName2;
	}
	public void setDesignCorpName2(String designCorpName2) {
		this.designCorpName2 = designCorpName2;
	}
	public String getDesignCorpCode2() {
		return designCorpCode2;
	}
	public void setDesignCorpCode2(String designCorpCode2) {
		this.designCorpCode2 = designCorpCode2;
	}
	public String getDesignCorpName3() {
		return designCorpName3;
	}
	public void setDesignCorpName3(String designCorpName3) {
		this.designCorpName3 = designCorpName3;
	}
	public String getDesignCorpCode3() {
		return designCorpCode3;
	}
	public void setDesignCorpCode3(String designCorpCode3) {
		this.designCorpCode3 = designCorpCode3;
	}
	public String getOneCensorIsPass() {
		return oneCensorIsPass;
	}
	public void setOneCensorIsPass(String oneCensorIsPass) {
		this.oneCensorIsPass = oneCensorIsPass;
	}
	public String getOneCensorWfqtCount() {
		return oneCensorWfqtCount;
	}
	public void setOneCensorWfqtCount(String oneCensorWfqtCount) {
		this.oneCensorWfqtCount = oneCensorWfqtCount;
	}
	public String getOneCensorWfqtContent() {
		return oneCensorWfqtContent;
	}
	public void setOneCensorWfqtContent(String oneCensorWfqtContent) {
		this.oneCensorWfqtContent = oneCensorWfqtContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getApplyCorpCode() {
		return applyCorpCode;
	}
	public void setApplyCorpCode(String applyCorpCode) {
		this.applyCorpCode = applyCorpCode;
	}
	public String getApplyCorpName() {
		return applyCorpName;
	}
	public void setApplyCorpName(String applyCorpName) {
		this.applyCorpName = applyCorpName;
	}
	public String getAppSteffId() {
		return appSteffId;
	}
	public void setAppSteffId(String appSteffId) {
		this.appSteffId = appSteffId;
	}
	public String getAppSteffName() {
		return appSteffName;
	}
	public void setAppSteffName(String appSteffName) {
		this.appSteffName = appSteffName;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public String getAppOpinion() {
		return appOpinion;
	}
	public void setAppOpinion(String appOpinion) {
		this.appOpinion = appOpinion;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getProcessSteps() {
		return processSteps;
	}
	public void setProcessSteps(String processSteps) {
		this.processSteps = processSteps;
	}
	public String getAppDept() {
		return appDept;
	}
	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}
	public String getAppDeptName() {
		return appDeptName;
	}
	public void setAppDeptName(String appDeptName) {
		this.appDeptName = appDeptName;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public List<Upload> getList() {
		return list;
	}
	public void setList(List<Upload> list) {
		this.list = list;
	}
	
}
