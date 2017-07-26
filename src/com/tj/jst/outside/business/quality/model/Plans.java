package com.tj.jst.outside.business.quality.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工图审信息
 * 
 * @author hhc
 *
 */
public class Plans {

	private String censorNum;//审查合格书编号
	private String prjName;//审查时的工程名称
	private String censorCorpName;//审查机构
	private String censorId;//审查主键
	private String econCorpName;//勘察单位
	private String designCorpName;//设计单位名称
	
	public String getCensorNum() {
		return censorNum;
	}
	public void setCensorNum(String censorNum) {
		this.censorNum = censorNum;
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
	public String getCensorId() {
		return censorId;
	}
	public void setCensorId(String censorId) {
		this.censorId = censorId;
	}
	public String getEconCorpName() {
		return econCorpName;
	}
	public void setEconCorpName(String econCorpName) {
		this.econCorpName = econCorpName;
	}
	public String getDesignCorpName() {
		return designCorpName;
	}
	public void setDesignCorpName(String designCorpName) {
		this.designCorpName = designCorpName;
	}

}
