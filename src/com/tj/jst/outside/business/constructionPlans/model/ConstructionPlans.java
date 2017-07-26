package com.tj.jst.outside.business.constructionPlans.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ��ͼ���
 * @author hhc
 *
 */
public class ConstructionPlans {

	private int censorId; //����
	private String censorNum; //ʩ��ͼ���ϸ�֤����
	private String prjNum; //��Ŀ���
	private String prjName; //��Ŀ����
	private String prjId;//��Ŀ��������
	private String censorCorpName; //ʩ��ͼ����������
	private String censorCorpCode; //ʩ��ͼ��������֯��������
	private Date censorEDate; //����������
	private String prjSize; //�����ģ
	private String econCorpName; //���쵥λ����
	private String econCorpCode; //���쵥λ��֯��������
	private String econCorpName2; //���쵥λ����2
	private String econCorpCode2; //���쵥λ��֯��������2
	private String econCorpName3; //���쵥λ����3
	private String econCorpCode3; //���쵥λ��֯��������3
	private String designCorpName; //��Ƶ�λ����
	private String designCorpCode; //��Ƶ�λ��֯��������
	private String designCorpName2; //��Ƶ�λ����2
	private String designCorpCode2; //��Ƶ�λ��֯��������2
	private String designCorpName3; //��Ƶ�λ����3
	private String designCorpCode3; //��Ƶ�λ��֯��������3
	private String oneCensorIsPass; //һ������Ƿ�ͨ�� ͨ��1����ͨ��0
	private String oneCensorWfqtCount; //һ�����ʱΥ��ǿ����
	private String oneCensorWfqtContent; //һ�����ʱΥ����ǿ����Ŀ
	private Date createDate; //��¼�Ǽ�����
	private String applyCorpCode; //������ҵ��֯��������
	private String applyCorpName; //������ҵ����
	private String appSteffId; //������id
	private String appSteffName; //����������
	private Date appDate; //����ʱ��
	private String appOpinion; //�������
	private List<Upload> list = new ArrayList<Upload>();//����
	/**
	 * ����״̬
	 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
	 */
	private String appType;//����״̬
	/**
	 * ���̲���
	 * 1:��Ŀ����
	 * 2:����׶Ρ���ƽ׶�
	 * 3:��ͬ������ʩ��ͼ��鱸��
	 * 4:�����ල����ȫ�ල
	 * 5:ʩ�����
	 * 6:��������
	 */
	private String processSteps;
	private String appDept;//������λid
	private String appDeptName;//������λ����
	

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
