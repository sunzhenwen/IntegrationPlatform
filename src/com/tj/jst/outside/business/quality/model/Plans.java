package com.tj.jst.outside.business.quality.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ��ͼ����Ϣ
 * 
 * @author hhc
 *
 */
public class Plans {

	private String censorNum;//���ϸ�����
	private String prjName;//���ʱ�Ĺ�������
	private String censorCorpName;//������
	private String censorId;//�������
	private String econCorpName;//���쵥λ
	private String designCorpName;//��Ƶ�λ����
	
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
