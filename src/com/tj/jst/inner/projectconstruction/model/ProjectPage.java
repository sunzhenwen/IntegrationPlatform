package com.tj.jst.inner.projectconstruction.model;

/**
 * 审批时，分项名称
 * 
 * @author DarkFlameMaster
 *
 */
public class ProjectPage {

	private String id;// 主键
	private String prjId;// 项目主键
	private String prjName;// 项目名称
	private String pliesNum;// 层数
	private String prjSize;// 建筑规模
	private String prjNvest;// 投资
	private String prjBuild;// 结构
	private String buildCorpName;// 建设公司名称

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPliesNum() {
		return pliesNum;
	}

	public void setPliesNum(String pliesNum) {
		this.pliesNum = pliesNum;
	}

	public String getPrjSize() {
		return prjSize;
	}

	public void setPrjSize(String prjSize) {
		this.prjSize = prjSize;
	}

	public String getPrjNvest() {
		return prjNvest;
	}

	public void setPrjNvest(String prjNvest) {
		this.prjNvest = prjNvest;
	}

	public String getPrjBuild() {
		return prjBuild;
	}

	public void setPrjBuild(String prjBuild) {
		this.prjBuild = prjBuild;
	}

	public String getBuildCorpName() {
		return buildCorpName;
	}

	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}

}
