package com.tj.jst.inner.projectShare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.design.model.DesignQualification;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.survey.model.Survey;
import com.tj.jst.outside.business.survey.model.SurveyQualification;
import com.tj.jst.outside.business.upload.model.Upload;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class ProjectShareDaoImpl extends BaseDao implements IProjectShareDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��Ŀ����
	 */
	@Override
	public Page queryConstructionPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Construction project = new Construction();
					project.setPrjId(rs.getString("prjId"));// ����
					project.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					project.setPrjName(rs.getString("prjName"));// ��Ŀ����
					project.setPrjTypeNum(rs.getString("prjTypeNum"));// ��Ŀ����
					project.setBuildCorpName(rs.getString("buildCorpName"));// ���赥λ����
					project.setBuildCorpCode(rs.getString("buildCorpCode"));// ���赥λ��֯��������֤
					project.setProvinceNum(rs.getString("provinceNum"));// ��Ŀ����ʡ
					project.setCityNum(rs.getString("cityNum"));// ��Ŀ������
					project.setCountyNum(rs.getString("countyNum"));// ��Ŀ������
					project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// �����ĺ�
					project.setPrjApprovalLevelNum(rs.getString("prjApprovalLevelNum"));// �����
					project.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
					project.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
					project.setAllInvest(rs.getString("allInvest"));// ��Ͷ��
					project.setAllArea(rs.getString("allArea"));// �����
					project.setPrjSize(rs.getString("prjSize"));// �����ģ
					project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// ��������
					project.setPrjFuncitonNum(rs.getString("prjFunctionNum"));// ������;
					project.setBDate(rs.getDate("bDate"));// ��ʼʱ��
					project.setEDate(rs.getDate("eDate"));// ����ʱ��
					project.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
					project.setAppType(rs.getString("appType"));
					project.setProcessSteps(rs.getString("processSteps"));
					page.getData().add(project);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * ��Ŀ������ϸ
	 * @return
	 */
	public Construction queryConstructionInfo(String prjId)
	{
		Construction construction = new Construction();
		try {
			
			String qsql = "select * from V_TBPROJECTINFO_S where prjId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, prjId);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				construction.setPrjId(rs.getString("prjId"));//����
				construction.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				construction.setPrjName(rs.getString("prjName"));//��Ŀ����
				construction.setPrjTypeNum(rs.getString("prjTypeNum").trim());//��Ŀ����(�ֵ��TBPRJTYPEDIC)
				construction.setPrjTypeName(rs.getString("prjTypeName"));
				construction.setBuildCorpName(rs.getString("buildCorpName"));//���赥λ����
				construction.setBuildCorpCode(rs.getString("buildCorpCode"));//���赥λ��֯��������
				construction.setProvinceNum(rs.getString("provinceNum"));//��Ŀ����ʡ(�ֵ��TBXZQDMDIC)
				construction.setProvinceName(rs.getString("provinceName"));
				construction.setCityNum(rs.getString("cityNum"));//��Ŀ������(�ֵ��TBXZQDMDIC)
				construction.setCityName(rs.getString("cityName"));
				construction.setCountyNum(rs.getString("countyNum"));//��Ŀ��������(�ֵ��TBXZQDMDIC)
				construction.setCountyName(rs.getString("countyName"));
				construction.setPrjApprovalNum(rs.getString("prjApprovalNum"));//�����ĺ�
				construction.setPrjApprovalLevelNum(rs.getString("prjApprovalLevelNum"));//�����
				construction.setPrjApprovalLevelName(rs.getString("prjApprovalLevelName"));//���������
				construction.setBuldPlanNum(rs.getString("buldPlanNum"));//�����õع滮���֤���
				construction.setProjectPlanNum(rs.getString("projectPlanNum"));//���蹤�̹滮���֤���
				construction.setAllInvest(rs.getString("allInvest"));//��Ͷ�ʣ���Ԫ��
				construction.setAllArea(rs.getString("allArea"));//�������ƽ���ף�
				construction.setPrjSize(rs.getString("prjSize"));//�����ģ
				construction.setPrjPropertyNum(rs.getString("prjPropertyNum").trim());//��������(�ֵ��TBPRJPORPERTYDIC)
				construction.setPrjPropertyName(rs.getString("prjPropertyName"));
				construction.setPrjFuncitonNum(rs.getString("PRJFUNCTIONNUM").trim());//������;(�ֵ��TBPRJFUNCTIONDIC)
				construction.setPrjFuncitonName(rs.getString("prjFuncitonName"));
				construction.setBDate(rs.getDate("BDate"));//ʵ�ʿ������ڣ�������������ΪM
				construction.setEDate(rs.getDate("EDate"));//ʵ�ʿ����������ڣ�������������ΪM
				construction.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				construction.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				construction.setProcessSteps(rs.getString("processSteps").trim());
				construction.setAppDept(rs.getString("appDept").trim());//������λid
				construction.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				construction.setAddress(rs.getString("address"));//�����ַ
				construction.setBDate(rs.getDate("BDate"));//ʵ�ʿ������ڣ�������������ΪM
				construction.setEDate(rs.getDate("EDate"));//ʵ�ʿ����������ڣ�������������ΪM
			}
			
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,prjId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			construction.setList(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return construction;
	}
	
	
	//-------------------------------------------------------
	
	/**
	 * ����
	 */
	public Page querySurveySharePage(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					Survey survey = new Survey();
					
					survey.setPrjId(rs.getString("prjId"));//����
					survey.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					survey.setPrjName(rs.getString("prjName"));//��Ŀ����
					survey.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					survey.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					survey.setProcessSteps(rs.getString("processSteps").trim());
					survey.setSurveyId(rs.getString("surveyId"));//��������
					survey.setSurveyNum(rs.getString("surveyNum"));//�������
					survey.setSurveyCorpName(rs.getString("surveyCorpName"));//��Ƶ�λ����
					survey.setSurveyCorpCode(rs.getString("surveyCorpCode"));//��Ƶ�λ��֯��������
					survey.setIsUnits(rs.getString("isUnits"));//��Ƶ�λ�Ƿ���д���� 0:�� 1:��
					survey.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					page.getData().add(survey);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * ����
	 * @return
	 */
	public Survey querySurveyShareInfo(String surveyId)
	{
		Survey survey = new Survey();
		try {
			
			String qsql = "select * from survey_business where surveyId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, surveyId);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				survey.setSurveyId(rs.getString("SURVEYID"));//����
				survey.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				survey.setPrjName(rs.getString("prjName"));//��Ŀ����
				survey.setSurveyNum(rs.getString("SURVEYNUM"));//�������
				survey.setSurveyCorpName(rs.getString("SURVEYCorpName"));//���쵥λ����
				survey.setSurveyCorpCode(rs.getString("SURVEYCorpCode"));//���쵥λ��֯��������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				survey.setAppType(rs.getString("appType"));//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				survey.setProcessSteps(rs.getString("processSteps"));
				survey.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				survey.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
				survey.setAppDept(rs.getString("appDept").trim());//������λid
				survey.setAppDeptName(rs.getString("appDeptName"));//������λ����
				survey.setIsUnits(rs.getString("isUnits").trim());//�Ƿ�λ����   0���ǣ�1����
				survey.setPrjId(rs.getString("prjId"));//��Ŀ����id
				survey.setCorpName(rs.getString("corpName"));//���赥λ
				survey.setSurveyNum(rs.getString("surveyNum"));//�������
				survey.setAppOpinion(rs.getString("appOpinion"));
			}
			
			if(survey.getIsUnits().equals("0"))
			{
				pstmt = conn.prepareStatement("select * from SURVEY_QUALIFICATION where SURVEYID=?");
				pstmt.setString(1, surveyId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					SurveyQualification surveyQualification = new SurveyQualification();
					surveyQualification.setId(rs.getString("id"));
					surveyQualification.setSurveyId(rs.getString("SURVEYID"));
					surveyQualification.setTitleLevelName(rs.getString("titleLevelName"));
					surveyQualification.setCertTypeName(rs.getString("certTypeName"));
					surveyQualification.setCertId(rs.getString("certId"));
					surveyQualification.setQualifName(rs.getString("qualifName"));
					survey.getSurveyQualis().add(surveyQualification);
				}
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,surveyId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			survey.setList(list);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return survey;
	}
	
	//-------------------------------------------------------
	
	/**
	 * ���
	 */
	public Page queryDesignSharePage(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					Design design = new Design();
					
					design.setPrjId(rs.getString("prjId"));//����
					design.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					design.setPrjName(rs.getString("prjName"));//��Ŀ����
					design.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					design.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					design.setProcessSteps(rs.getString("processSteps").trim());
					//------------------------------------------���-------------------------------------------
					design.setDesignId(rs.getString("designId"));//�������
					design.setDesignNum(rs.getString("designNum"));//��Ʊ���
					design.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
					design.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
					design.setIsUnits(rs.getString("isUnits"));//��Ƶ�λ�Ƿ���д���� 0:�� 1:��
					design.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					page.getData().add(design);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * ���
	 * @return
	 */
	public Design queryDesignShareInfo(String designId)
	{
		Design design = new Design();
		try {
			
			String qsql = "select * from DESIGN_BUSINESS where designId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, designId);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				design.setDesignId(rs.getString("designId"));//����
				design.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				design.setPrjName(rs.getString("prjName"));//��Ŀ����
				design.setDesignNum(rs.getString("designNum"));//��Ʊ���
				design.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
				design.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				design.setAppType(rs.getString("appType"));//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				design.setProcessSteps(rs.getString("processSteps"));
				design.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				design.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
				design.setAppDept(rs.getString("appDept").trim());//������λid
				design.setAppDeptName(rs.getString("appDeptName"));//������λ����
				design.setIsUnits(rs.getString("isUnits").trim());//�Ƿ�λ����   0���ǣ�1����
				design.setPrjId(rs.getString("prjId"));//��Ŀ����id
				design.setCorpName(rs.getString("corpName"));//���赥λ
				design.setAppOpinion(rs.getString("appOpinion"));
			}
			
			if(design.getIsUnits().equals("0"))
			{
				pstmt = conn.prepareStatement("select * from DESIGN_QUALIFICATION where DESIGNID=?");
				pstmt.setString(1, designId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DesignQualification designQualification = new DesignQualification();
					designQualification.setId(rs.getString("id"));
					designQualification.setDesignId(rs.getString("designId"));
					designQualification.setTitleLevelName(rs.getString("titleLevelName"));
					designQualification.setCertTypeName(rs.getString("certTypeName"));
					designQualification.setCertId(rs.getString("certId"));
					designQualification.setQualifName(rs.getString("qualifName"));
					design.getDesignQualifications().add(designQualification);
				}
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,designId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			design.setList(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return design;
	}
	
	//-------------------------------------------------------
	
	/**
	 * ��ͬ����
	 */
	public Page queryFilingSharePage(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					ContractFiling contractFiling = new ContractFiling();
					
					contractFiling.setRecordId(rs.getString("recordId"));//����
					contractFiling.setRecordNum(rs.getString("recordNum"));//��ͬ�������
					contractFiling.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					contractFiling.setPrjName(rs.getString("prjName"));//��Ŀ����
					contractFiling.setContractNum(rs.getString("contractNum"));//��ͬ���
					contractFiling.setContractTypeNum(rs.getString("contractTypeNum"));//��ͬ���(TBCONTRACTTYPEDIC)
					contractFiling.setContractTypeName(rs.getString("contractTypeName"));//��ͬ�������
					contractFiling.setContractMoney(rs.getString("contractMoney"));//��ͬ���(��Ԫ)
					contractFiling.setPrjSize(rs.getString("prjSize"));//�����ģ
					contractFiling.setContractDate(rs.getDate("contractDate"));//��ͬǩ������
					contractFiling.setPropietorCorpName(rs.getString("propietorCorpName"));//������λ����
					contractFiling.setPropietorCorpCode(rs.getString("propietorCorpCode"));//������λס��֯����
					contractFiling.setContractorCorpName(rs.getString("contractorCorpName"));//�а���λ����
					contractFiling.setContractorCorpCode(rs.getString("contractorCorpCode"));//�а���λ��֯����
					contractFiling.setUnionCorpName(rs.getString("unionCorpName"));//������а���λ����
					contractFiling.setUnionCorpCode(rs.getString("unionCorpCode"));//������а���λ��֯����
					contractFiling.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
					contractFiling.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					contractFiling.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
					contractFiling.setAppSteffId(rs.getString("appSteffId"));//������id
					contractFiling.setAppSteffName(rs.getString("appSteffName"));//����������
					contractFiling.setAppDate(rs.getDate("appDate"));//����ʱ��
					contractFiling.setAppOpinion(rs.getString("appOpinion"));//�������
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					contractFiling.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					contractFiling.setProcessSteps(rs.getString("processSteps").trim());
					contractFiling.setAppDept(rs.getString("appDept").trim());//������λid
					contractFiling.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
					page.getData().add(contractFiling);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * ��ͬ����
	 */
	public ContractFiling queryFilingShareInfo(String recordId)
	{
		ContractFiling contractFiling = new ContractFiling();
		try {
			
			String qsql = "select * from v_tbcontractrecordmanage where recordId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, recordId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				contractFiling.setRecordId(rs.getString("recordId"));//����
				contractFiling.setRecordNum(rs.getString("recordNum"));//��ͬ�������
				contractFiling.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				contractFiling.setPrjName(rs.getString("prjName"));//��Ŀ����
				contractFiling.setContractNum(rs.getString("contractNum"));//��ͬ���
				contractFiling.setContractTypeNum(rs.getString("contractTypeNum"));//��ͬ���(TBCONTRACTTYPEDIC)
				contractFiling.setContractTypeName(rs.getString("contracttypeName"));//��ͬ�������
				contractFiling.setContractMoney(rs.getString("CONTRACTMONEY"));//��ͬ���(��Ԫ)
				contractFiling.setPrjSize(rs.getString("PRJSIZE"));//�����ģ
				contractFiling.setContractDate(rs.getDate("CONTRACTDATE"));//��ͬǩ������
				contractFiling.setPropietorCorpName(rs.getString("PROPIETORCORPNAME"));//������λ����
				contractFiling.setPropietorCorpCode(rs.getString("PROPIETORCORPCODE"));//������λס��֯����
				contractFiling.setContractorCorpName(rs.getString("CONTRACTORCORPNAME"));//�а���λ����
				contractFiling.setContractorCorpCode(rs.getString("CONTRACTORCORPCODE"));//�а���λ��֯����
				contractFiling.setUnionCorpName(rs.getString("UNIONCORPNAME"));//������а���λ����
				contractFiling.setUnionCorpCode(rs.getString("UNIONCORPCODE"));//������а���λ��֯����
				contractFiling.setCreateDate(rs.getDate("CREATEDATE"));//��¼�Ǽ�ʱ��
				contractFiling.setApplyCorpCode(rs.getString("APPLYCORPCODE"));//������ҵ��֯��������
				contractFiling.setApplyCorpName(rs.getString("APPLYCORPNAME"));//������ҵ����
				contractFiling.setAppSteffId(rs.getString("appSteffId"));//������id
				contractFiling.setAppSteffName(rs.getString("appSteffName"));//����������
				contractFiling.setAppDate(rs.getDate("appDate"));//����ʱ��
				contractFiling.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				contractFiling.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				contractFiling.setProcessSteps(rs.getString("processSteps").trim());
				contractFiling.setAppDept(rs.getString("appDept").trim());//������λid
				contractFiling.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,recordId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			contractFiling.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return contractFiling;
	}
	
	//-------------------------------------------------------
	
	/**
	 * ʩ��ͼ���
	 */
	public Page queryPlanSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
				Page page = super.basePagedQuery(condition);
				ResultSet rs = page.getRs();
				try {
					if (rs != null) {
						while (rs.next()) {
							ConstructionPlans plan = new ConstructionPlans();
							plan.setCensorId(rs.getInt("censorId"));// ����
							plan.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�֤����
							plan.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
							plan.setPrjName(rs.getString("prjName"));// ��Ŀ����
							plan.setCensorCorpName(rs.getString("censorCorpName"));// ʩ��ͼ����������
							plan.setCensorCorpCode(rs.getString("censorCorpCode"));// ʩ��ͼ��������֯��������
							plan.setCensorEDate(rs.getDate("censorEDate"));// ����������
							plan.setPrjSize(rs.getString("prjSize"));// �����ģ
							plan.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
							plan.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
							plan.setEconCorpName2(rs.getString("econCorpName2"));// ���쵥λ����2
							plan.setEconCorpCode2(rs.getString("econCorpCode2")); // ���쵥λ��֯��������2
							plan.setEconCorpName3(rs.getString("econCorpName3"));// ���쵥λ����3
							plan.setEconCorpCode3(rs.getString("econCorpCode3")); // ���쵥λ��֯��������3
							plan.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
							plan.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
							plan.setDesignCorpName2(rs.getString("designCorpName2"));// ��Ƶ�λ����2
							plan.setDesignCorpCode2(rs.getString("designCorpCode2"));// ��Ƶ�λ��֯��������2
							plan.setDesignCorpName3(rs.getString("designCorpName3"));// ��Ƶ�λ����3
							plan.setDesignCorpCode3(rs.getString("designCorpCode3"));// ��Ƶ�λ��֯��������3
							plan.setOneCensorIsPass(rs.getString("oneCensorIsPass"));// һ������Ƿ�ͨ��
																						// ͨ��1����ͨ��0
							plan.setOneCensorWfqtCount(rs
									.getString("oneCensorWfqtCount"));// һ�����ʱΥ��ǿ����
							plan.setOneCensorWfqtContent(rs
									.getString("oneCensorWfqtContent"));// һ�����ʱΥ����ǿ����Ŀ
							plan.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
							plan.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
							plan.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
							plan.setAppSteffId(rs.getString("appSteffId"));// ������id
							plan.setAppSteffName(rs.getString("appSteffName"));// ����������
							plan.setAppDate(rs.getDate("appDate"));// ����ʱ��
							plan.setAppOpinion(rs.getString("appOpinion"));// �������
							/**
							 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
							 */
							plan.setAppType(rs.getString("appType").trim());// ����״̬
							/**
							 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
							 * 6:��������
							 */
							plan.setProcessSteps(rs.getString("processSteps").trim());
							plan.setAppDept(rs.getString("appDept").trim());// ������λid
							plan.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
							page.getData().add(plan);
						}
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
							page.getRs());
				}
				return page;
	}

	/**
	 * ʩ��ͼ���
	 */
	public ConstructionPlans queryPlanShareInfo(String censorId)
	{
		ConstructionPlans constructionPlans = new ConstructionPlans();
		try {
			
			String qsql = "select * from TBPROJECTCENSORINFO where censorId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, censorId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				constructionPlans.setCensorId(rs.getInt("censorId"));//����
				constructionPlans.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�֤����
				constructionPlans.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				constructionPlans.setPrjName(rs.getString("prjName"));//��Ŀ����
				constructionPlans.setCensorCorpName(rs.getString("censorCorpName"));//ʩ��ͼ����������
				constructionPlans.setCensorCorpCode(rs.getString("censorCorpCode"));//ʩ��ͼ��������֯��������
				constructionPlans.setCensorEDate(rs.getDate("censorEDate"));//����������
				constructionPlans.setPrjSize(rs.getString("prjSize"));//�����ģ
				constructionPlans.setEconCorpName(rs.getString("econCorpName"));//���쵥λ����
				constructionPlans.setEconCorpCode(rs.getString("econCorpCode"));//���쵥λ��֯��������
				constructionPlans.setEconCorpName2(rs.getString("econCorpName2"));//���쵥λ����2
				constructionPlans.setEconCorpCode2(rs.getString("econCorpCode2")); //���쵥λ��֯��������2
				constructionPlans.setEconCorpName3(rs.getString("econCorpName3"));//���쵥λ����3
				constructionPlans.setEconCorpCode3(rs.getString("econCorpCode3")); //���쵥λ��֯��������3
				constructionPlans.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
				constructionPlans.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
				constructionPlans.setDesignCorpName2(rs.getString("designCorpName2"));//��Ƶ�λ����2
				constructionPlans.setDesignCorpCode2(rs.getString("designCorpCode2"));//��Ƶ�λ��֯��������2
				constructionPlans.setDesignCorpName3(rs.getString("designCorpName3"));//��Ƶ�λ����3
				constructionPlans.setDesignCorpCode3(rs.getString("designCorpCode3"));//��Ƶ�λ��֯��������3
				constructionPlans.setOneCensorIsPass(rs.getString("oneCensorIsPass"));//һ������Ƿ�ͨ�� ͨ��1����ͨ��0
				constructionPlans.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));//һ�����ʱΥ��ǿ����
				constructionPlans.setOneCensorWfqtContent(rs.getString("oneCensorWfqtContent"));//һ�����ʱΥ����ǿ����Ŀ
				constructionPlans.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
				constructionPlans.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				constructionPlans.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				constructionPlans.setAppSteffId(rs.getString("appSteffId"));//������id
				constructionPlans.setAppSteffName(rs.getString("appSteffName"));//����������
				constructionPlans.setAppDate(rs.getDate("appDate"));//����ʱ��
				constructionPlans.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				constructionPlans.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				constructionPlans.setProcessSteps(rs.getString("processSteps").trim());
				constructionPlans.setAppDept(rs.getString("appDept").trim());//������λid
				constructionPlans.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				constructionPlans.setPrjId(rs.getString("prjId"));
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,censorId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			constructionPlans.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return constructionPlans;
	}
	
	//-------------------------------------------------------
	
	/**
	 * �����ල
	 */
	public Page queryQualitySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Quality quality = new Quality();
					quality.setQualityId(rs.getString("qualityId"));// ����
					quality.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					quality.setPrjName(rs.getString("prjName"));// ��Ŀ����
					quality.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					quality.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					quality.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					quality.setAppSteffId(rs.getString("appSteffId"));// ������id
					quality.setAppSteffName(rs.getString("appSteffName"));// ����������
					quality.setAppDate(rs.getDate("appDate"));// ����ʱ��
					quality.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					quality.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					quality.setProcessSteps(rs.getString("processSteps").trim());
					quality.setAppDept(rs.getString("appDept").trim());// ������λid
					quality.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
					page.getData().add(quality);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * �����ල
	 */
	public Quality queryQualityShareInfo(String qualityId)
	{
		Quality quality = new Quality();
		try {
			
			String qsql = "select * from TB_QUALITYSUPERVISION where qualityId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, qualityId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setQualityId(rs.getString("qualityId"));//����
				quality.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				quality.setPrjName(rs.getString("prjName"));//��Ŀ����
				quality.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
				quality.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				quality.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				quality.setAppSteffId(rs.getString("appSteffId"));//������id
				quality.setAppSteffName(rs.getString("appSteffName"));//����������
				quality.setAppDate(rs.getDate("appDate"));//����ʱ��
				quality.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				quality.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				quality.setProcessSteps(rs.getString("processSteps").trim());
				quality.setAppDept(rs.getString("appDept").trim());//������λid
				quality.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				quality.setPrjId(rs.getString("prjId"));
				quality.setProjectName(rs.getString("projectName"));//��������
				quality.setConfiguration(rs.getString("configuration"));//�ṹ/����
				quality.setProjectAddress(rs.getString("projectAddress"));//���̵ص�
				quality.setContact(rs.getString("contact"));//��ϵ��
				quality.setConstructionArea(rs.getString("constructionArea"));//�������(ƽ����)
				quality.setQuantities(rs.getString("quantities"));//��װ������(��Ԫ)
				quality.setExpensive(rs.getString("expensive"));//���������(��Ԫ)
				quality.setSuperviseCost(rs.getString("superviseCost"));//�ල��(Ԫ)
				quality.setStartDate(rs.getDate("startDate"));//�ƻ���������
				quality.setEndDate(rs.getDate("endDate"));//�ƻ���������
				quality.setDevelopmentOrganization(rs.getString("developmentOrganization"));//���赥λ
				quality.setDevelopmentQualificationLevel(rs.getString("developmentQualificationLevel"));//���赥λ���ʵȼ�
				quality.setDevelopmentCharge(rs.getString("developmentCharge"));//���赥λ��Ŀ������
				quality.setDevelopmentPhone(rs.getString("developmentPhone"));//���赥λ��ϵ�绰
				quality.setSurveyUnit(rs.getString("surveyUnit"));//���쵥λ
				quality.setSurveyUnitQualificationLevel(rs.getString("surveyUnitQualificationLevel"));//���쵥λ���ʵȼ�
				quality.setSurveyUnitCharge(rs.getString("surveyUnitCharge"));//���쵥λ��Ŀ������
				quality.setSurveyUnitPhone(rs.getString("surveyUnitPhone"));//���쵥λ��ϵ�绰
				quality.setDesignUnit(rs.getString("designUnit"));//��Ƶ�λ
				quality.setDesignUnitQualificationLevel(rs.getString("designUnitQualificationLevel"));//��Ƶ�λ���ʵȼ�
				quality.setDesignUnitCharge(rs.getString("designUnitCharge"));//��Ƶ�λ��Ŀ������
				quality.setDesignUnitPhone(rs.getString("designUnitPhone"));//��Ƶ�λ��ϵ�绰
				quality.setSupervisionUnit(rs.getString("supervisionUnit"));//����λ
				quality.setSupervisionUnitQualLevel(rs.getString("supervisionUnitQualLevel"));//����λ���ʵȼ�
				quality.setSupervisionUnitEngineer(rs.getString("supervisionUnitEngineer"));//�ܼ�����ʦ
				quality.setSupervisionUnitPhone(rs.getString("supervisionUnitPhone"));//����λ��ϵ�绰
				quality.setConstructionUnit(rs.getString("constructionUnit"));//ʩ����λ
				quality.setConstructionUnitQualLevel(rs.getString("constructionUnitQualLevel"));//ʩ����λ���ʵȼ�
				quality.setConstructionUnitProjectManager(rs.getString("constructionUnitProjectManager"));//ʩ����λ��Ŀ����
				quality.setConstructionUnitPhone(rs.getString("constructionUnitPhone"));//ʩ����λ��ϵ�绰
				quality.setConstructionPlans(rs.getString("constructionPlans"));//ʩ��ͼ������
				quality.setConstructionPlansType(rs.getString("constructionPlansType"));//ʩ��ͼ���������
				quality.setConstructionPlansCharge(rs.getString("constructionPlansCharge"));//ʩ��ͼ��������Ŀ������
				quality.setConstructionPlansPhone(rs.getString("constructionPlansPhone"));//ʩ��ͼ��������ϵ�绰
				quality.setConstructionContractFileNum(rs.getString("constructionContractFileNum"));//ʩ����ͬ�ļ���
				quality.setConstructionOrganFileNum(rs.getString("constructionOrganFileNum"));//ʩ����֯����ļ���
				quality.setConstructionPlansFileNum(rs.getString("constructionPlansFileNum"));//ʩ��ͼ��鱨�����׼���ļ���
				quality.setSupervisionContractFileNum(rs.getString("supervisionContractFileNum"));//�����ͬ�ļ���
				quality.setSupervisionPlanFileNum(rs.getString("supervisionPlanFileNum"));//����滮�ļ���
				quality.setFireControlFileNum(rs.getString("FireControlFileNum"));//����������ϸ�����֤���ļ��ļ���
				quality.setDevelopmentOrganFileNum(rs.getString("DevelopmentOrganFileNum"));//���赥λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setOnstructionUnitFileNum(rs.getString("OnstructionUnitFileNum"));//ʩ����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setSupervisionUnitFileNum(rs.getString("SupervisionUnitFileNum"));//����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setConstructionSiteFileNum(rs.getString("ConstructionSiteFileNum"));//ʩ���ֳ���Ŀ�����ˡ�������Ա�ʸ�֤���ļ���
				quality.setQualityTestingFileNum(rs.getString("QualityTestingFileNum"));//�������Ա��λ֤���ļ���
				quality.setFieldSupervisionFileNum(rs.getString("FieldSupervisionFileNum"));//�ֳ�������Աע��ִҵ֤���ļ���
				quality.setQualityNum(rs.getString("qualityNum"));
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,qualityId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			quality.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}
	
	//-------------------------------------------------------
	
	/**
	 * ��ȫ�ල
	 */
	public Page querySafetySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Safety safety = new Safety();
					safety.setPrjId(rs.getString("prjId"));
					safety.setSafetyId(rs.getString("SAFETYID"));// ����
					safety.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					safety.setPrjName(rs.getString("prjName"));// ��Ŀ����
					safety.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					safety.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					safety.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					safety.setAppSteffId(rs.getString("appSteffId"));// ������id
					safety.setAppSteffName(rs.getString("appSteffName"));// ����������
					safety.setAppDate(rs.getDate("appDate"));// ����ʱ��
					safety.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					safety.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					safety.setProcessSteps(rs.getString("processSteps").trim());
					safety.setAppDept(rs.getString("appDept").trim());// ������λid
					safety.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
					page.getData().add(safety);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * ��ȫ�ල
	 */
	public Safety querySafetyInfo(String safetyId)
	{
		Safety quality = new Safety();
		try {
			
			String qsql = "select * from TB_SAFETYSUPERVISION where SAFETYID=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, safetyId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setPrjId(rs.getString("prjId"));
				quality.setSafetyId(rs.getString("SAFETYID"));//����
				quality.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				quality.setPrjName(rs.getString("prjName"));//��Ŀ����
				quality.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
				quality.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				quality.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				quality.setAppSteffId(rs.getString("appSteffId"));//������id
				quality.setAppSteffName(rs.getString("appSteffName"));//����������
				quality.setAppDate(rs.getDate("appDate"));//����ʱ��
				quality.setAppOpinion(rs.getString("appOpinion"));//�������
				quality.setOversightNum(rs.getString("oversightNum"));
				
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				quality.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				quality.setProcessSteps(rs.getString("processSteps").trim());
				quality.setAppDept(rs.getString("appDept").trim());//������λid
				quality.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				quality.setPrjId(rs.getString("prjId"));
				quality.setProjectName(rs.getString("projectName"));//��������
				quality.setProjectAddress(rs.getString("projectAddress"));//���̵ص�
				quality.setProStartDate(rs.getDate("proStartDate"));//��ͬ��������
				quality.setProEndDate(rs.getDate("proEndDate"));//��ͬ��������
				quality.setProjectType(rs.getString("projectType"));//��������
				quality.setSafetyTarget(rs.getString("safetyTarget"));//��ȫ������׼������Ŀ��
				if(rs.getString("newlyBuild") != null)
				{
					quality.setNewlyBuild(rs.getString("newlyBuild").trim());//�½�
				}else
				{
					quality.setNewlyBuild(rs.getString("newlyBuild"));//�½�
				}
				if(rs.getString("extend") != null)
				{
					quality.setExtend(rs.getString("extend").trim());//������
				}else
				{
					quality.setExtend(rs.getString("extend"));//������
				}
				if(rs.getString("other") != null)
				{
					quality.setOther(rs.getString("other").trim());//����
				}else
				{
					quality.setOther(rs.getString("other"));//����
				}
				quality.setPolicingName(rs.getString("policingName"));//���쵥λȫ��
				quality.setPolicingStaff(rs.getString("policingStaff"));//���쵥λ��Ŀ������
				quality.setDesignName(rs.getString("designName"));//��Ƶ�λȫ��
				quality.setDesignStaff(rs.getString("designStaff"));//��Ƶ�λ��Ŀ������
				quality.setBuildingName(rs.getString("buildingName"));//���赥λȫ��
				quality.setBuildingStaff(rs.getString("buildingStaff"));//���赥λ��Ŀ������
				quality.setBuildingPhone(rs.getString("buildingPhone"));//���赥λ��ϵ�绰
				quality.setSupervisionName(rs.getString("supervisionName"));//����λȫ��
				quality.setSupervisionStaff(rs.getString("supervisionStaff"));//����λ��Ŀ�ܼ�����
				quality.setSupervisionNum(rs.getString("supervisionNum"));//����λ��Ŀ�ܼ�ע��֤���
				quality.setSupervisionPhone(rs.getString("supervisionPhone"));//����λ��Ŀ�ܼ���ϵ�绰
				quality.setProbationStaff(rs.getString("probationStaff"));//����λ��ȫ�ල����
				quality.setProbationPhone(rs.getString("probationPhone"));//����λ��ȫ�ල��ϵ�绰
				quality.setProbationNum(rs.getString("probationNum"));//����λ��ȫ�ලע��֤���
				quality.setProbationSafeNum(rs.getString("probationSafeNum"));//����λ��ȫ�ල��ȫ����֤��
				quality.setContractName(rs.getString("contractName"));//ʩ���ܳа���λȫ��
				quality.setContractAdmin(rs.getString("contractAdmin"));//ʩ���ܳа���λ��˾��ȫ����
				quality.setContractPhone(rs.getString("contractPhone"));//ʩ���ܳа���λ��ϵ�绰
				quality.setContractStaff(rs.getString("contractStaff"));//ʩ���ܳа���λ������
				quality.setContractSafeNum(rs.getString("contractSafeNum"));//ʩ���ܳа���λ��ȫ����֤��
				quality.setContractProStaff(rs.getString("contractProStaff"));//ʩ���ܳа���λ��Ŀ����������
				quality.setContractProStaffPhone(rs.getString("contractProStaffPhone"));//ʩ���ܳа���λ��Ŀ��������ϵ�绰
				quality.setContractStaffRegNum(rs.getString("contractStaffRegNum"));//ʩ���ܳа���λ��Ŀ������ע��֤��
				quality.setContractStaffNum(rs.getString("contractStaffNum"));//ʩ���ܳа���λ��Ŀ�����˰�ȫ����֤��
				//quality.setSingleNum(rs.getString("singleNum"));//��λ���̱��
				quality.setUnitProject(rs.getString("unitProject"));//��λ����
				quality.setScale(rs.getString("scale"));//������ģ
				quality.setCost(rs.getString("cost"));//�������
				quality.setStructure(rs.getString("structure"));//�ṹ/���
				quality.setHeight(rs.getString("height"));//�����߶�
				quality.setSafetyNum(rs.getString("safetyNum"));
				//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
				List<ConstructionSafety> cs = new ArrayList<ConstructionSafety>();
				pstmt = conn.prepareStatement("select * from CONSTRUCTION_SAFETY "
								+ "where safetyId=?");
				pstmt.setString(1,safetyId);	
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					ConstructionSafety constructionSafety = new ConstructionSafety();
					constructionSafety.setConsId(rs.getString("consId"));
					constructionSafety.setPrjId(rs.getString("prjId"));
					constructionSafety.setSafetyId(safetyId);
					constructionSafety.setSafetyManagecheckNum(rs.getString("safetyManagecheckNum"));
					constructionSafety.setSafetyManageNum(rs.getString("safetyManageNum"));
					constructionSafety.setSafetyManageName(rs.getString("SafetyManageName"));
					cs.add(constructionSafety);
				}
				
				
				//רҵ�ְ���λ
				List<Major> majors = new ArrayList<Major>(); 
				pstmt = conn.prepareStatement("select * from SAFETY_MAJOR where safetyId=?");
				pstmt.setString(1,safetyId);	
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Major major = new Major();
					major.setMajorId(rs.getString("majorId"));
					major.setMajorLicenseDate(rs.getDate("majorLicenseDate"));
					major.setMajorCardNum(rs.getString("majorCardNum"));
					major.setMajorName(rs.getString("majorName"));
					major.setMajorPhone(rs.getString("majorPhone"));
					major.setMajorProject(rs.getString("majorProject"));
					major.setMajorStaff(rs.getString("majorStaff"));
					major.setPrjId(rs.getString("prjId"));
					major.setSafetyId(safetyId);
					majors.add(major);
				}
				
				
				//����ְ���λ
				List<Labour> labours = new ArrayList<Labour>(); 
				pstmt = conn.prepareStatement("select * from SAFETY_LABOURS "
						+ "where safetyId=?");
				pstmt.setString(1,safetyId);	
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Labour labour = new Labour();
					labour.setLabourId(rs.getString("labourId"));
					labour.setLabourLicenseDate(rs.getDate("labourLicenseDate"));
					labour.setLabourName(rs.getString("labourName"));
					labour.setLabourPhone(rs.getString("labourPhone"));
					labour.setLabourStaff(rs.getString("labourStaff"));
					labour.setPrjId(rs.getString("prjId"));
					labour.setSafetyId(safetyId);
					labours.add(labour);
				}
				
				quality.setCsList(cs);
				quality.setMajors(majors);
				quality.setLabours(labours);
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,safetyId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			quality.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}
	
	//-------------------------------------------------------
	
	/**
	 * ʩ�����
	 */
	public Page queryPromiseSharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Permit permit = new Permit();
					permit.setPrjId(rs.getString("prjId"));
					permit.setPermitId(rs.getString("permitId"));// ����
					permit.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					permit.setProjectName(rs.getString("projectName"));// ��������
					permit.setPrjName(rs.getString("prjName"));// ��Ŀ����
					permit.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// ʩ�����֤���
					permit.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
					permit.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
					permit.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�����
					permit.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
					permit.setArea(rs.getString("area"));// ���(ƽ����)
					permit.setPrjSize(rs.getString("prjSize"));// �����ģ
					permit.setIssueCertDate(rs.getDate("issueCertDate"));// ��֤����
					permit.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
					permit.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
					permit.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
					permit.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
					permit.setConsCorpname(rs.getString("consCorpname"));// ʩ����λ����
					permit.setConsCorpCode(rs.getString("consCorpCode"));// ʩ����λ��֯��������
					permit.setSafetyCerId(rs.getString("safetyCerId"));// ʩ����λ��ȫ�������֤���
					permit.setSuperCorpName(rs.getString("superCorpName"));// ����λ����
					permit.setSuperCorpCode(rs.getString("superCorpCode"));// ����λ��֯��������
					permit.setConstructorName(rs.getString("constructorName"));// ��Ŀ��������
					permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));// ��Ŀ����֤������(TBIDCARDTYPEDIC)
					permit.setConstructorIdCard(rs
							.getString("constructorIdCard"));// ��Ŀ����֤������
					permit.setSupervisionName(rs.getString("supervisionName"));// �ܼ�����ʦ����
					permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));// �ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
					permit.setSupervisionIdCard(rs
							.getString("supervisionIdCard"));// �ܼ�����ʦ����
					permit.setUserName(rs.getString("userName"));// ��ȫ����������Ա����
					permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));// ��ȫ��������֤������(TBIDCARDTYPEDIC)
					permit.setIdCard(rs.getString("idCard"));// ��ȫ����������Ա֤����
					permit.setCertId(rs.getString("certId"));// ��ȫ�������˺ϸ�֤����
					permit.setUserType(rs.getString("userType"));// ��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
					permit.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					permit.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					permit.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					permit.setAppSteffId(rs.getString("appSteffId"));// ������id
					permit.setAppSteffName(rs.getString("appSteffName"));// ����������
					permit.setAppDate(rs.getDate("appDate"));// ����ʱ��
					permit.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					permit.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					permit.setProcessSteps(rs.getString("processSteps").trim());
					permit.setAppDept(rs.getString("appDept").trim());// ������λid
					permit.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
					page.getData().add(permit);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * ʩ�����
	 */
	public Permit queryPromiseShareInfo(String permitId)
	{
		Permit permit = new Permit();
		try {
			
			String qsql = "select * from tbbuilderlicencemanage where permitId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
			
				permit.setPrjId(rs.getString("prjId"));
				permit.setPermitId(rs.getString("permitId"));//����
				permit.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				permit.setPrjName(rs.getString("prjName"));//��Ŀ����
				permit.setProjectName(rs.getString("projectName"));//��������
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤���
				permit.setBuldPlanNum(rs.getString("buldPlanNum"));//�����õع滮���֤���
				permit.setProjectPlanNum(rs.getString("projectPlanNum"));//���蹤�̹滮���֤���
				permit.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�����
				permit.setContractMoney(rs.getString("contractMoney"));//��ͬ���(��Ԫ)
				permit.setArea(rs.getString("area"));//���(ƽ����)
				permit.setPrjSize(rs.getString("prjSize"));//�����ģ
				permit.setIssueCertDate(rs.getDate("issueCertDate"));//��֤����
				permit.setEconCorpName(rs.getString("econCorpName"));//���쵥λ����
				permit.setEconCorpCode(rs.getString("econCorpCode"));//���쵥λ��֯��������
				permit.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
				permit.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
				permit.setConsCorpname(rs.getString("consCorpname"));//ʩ����λ����
				permit.setConsCorpCode(rs.getString("consCorpCode"));//ʩ����λ��֯��������
				permit.setSafetyCerId(rs.getString("safetyCerId"));//ʩ����λ��ȫ�������֤���
				permit.setSuperCorpName(rs.getString("superCorpName"));//����λ����     
				permit.setSuperCorpCode(rs.getString("superCorpCode"));//����λ��֯��������
				permit.setConstructorName(rs.getString("constructorName"));//��Ŀ��������
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));//��Ŀ����֤������(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));//��Ŀ����֤������
				permit.setSupervisionName(rs.getString("supervisionName"));//�ܼ�����ʦ����
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));//�ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));//�ܼ�����ʦ����
				permit.setUserName(rs.getString("userName"));//��ȫ����������Ա����
				permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));//��ȫ��������֤������(TBIDCARDTYPEDIC)
				permit.setIdCard(rs.getString("idCard"));//��ȫ����������Ա֤����
				permit.setCertId(rs.getString("certId"));//��ȫ�������˺ϸ�֤����
				permit.setUserType(rs.getString("userType"));//��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
				permit.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				permit.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				permit.setAppSteffId(rs.getString("appSteffId"));//������id
				permit.setAppSteffName(rs.getString("appSteffName"));//����������
				permit.setAppDate(rs.getDate("appDate"));//����ʱ��
				permit.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				permit.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				permit.setProcessSteps(rs.getString("processSteps").trim());
				permit.setAppDept(rs.getString("appDept").trim());//������λid
				permit.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				
			}
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,permitId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			permit.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return permit;
	}
	
	//-------------------------------------------------------
	
	/**
	 * ��������
	 */
	public Page queryReadySharePage(Condition condition)
	{
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Complete complete = new Complete();
					complete.setPrjId(rs.getString("prjId"));
					complete.setProjectName(rs.getString("projectName"));
					complete.setCompleteId(rs.getString("completeId"));// ����
					complete.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					complete.setPrjName(rs.getString("prjName"));// ��Ŀ����
					complete.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// ʩ�����֤���
					complete.setQcCorpName(rs.getString("qcCorpName"));
					complete.setQcCorpCode(rs.getString("qcCorpCode"));
					complete.setFactCost(rs.getString("factCost"));
					complete.setFactArea(rs.getString("factArea"));
					complete.setFactSize(rs.getString("factSize"));
					complete.setPrjStructureTypeNum(rs
							.getString("prjStructureTypeNum"));
					complete.setBDate(rs.getDate("bDate"));
					complete.setEDate(rs.getDate("eDate"));
					complete.setMark(rs.getString("mark"));
					complete.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					complete.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					complete.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					complete.setAppSteffId(rs.getString("appSteffId"));// ������id
					complete.setAppSteffName(rs.getString("appSteffName"));// ����������
					complete.setAppDate(rs.getDate("appDate"));// ����ʱ��
					complete.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					complete.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					complete.setProcessSteps(rs.getString("processSteps")
							.trim());
					complete.setAppDept(rs.getString("appDept").trim());// ������λid
					complete.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
					page.getData().add(complete);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * ��������
	 */
	public Complete queryReadyShareInfo(String completeId)
	{
		Complete complete = new Complete();
		try {
			
			String qsql = "select * from TBPROJECTFINISHMANAGE where completeId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, completeId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				complete.setPrjId(rs.getString("prjId"));
				complete.setCompleteId(rs.getString("completeId"));//����
				complete.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				complete.setPrjName(rs.getString("prjName"));//��Ŀ����
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤���
				complete.setPrjFinishNum(rs.getString("prjFinishNum"));
				complete.setQcCorpName(rs.getString("qcCorpName"));
				complete.setQcCorpCode(rs.getString("qcCorpCode"));
				complete.setFactCost(rs.getString("factCost"));
				complete.setFactArea(rs.getString("factArea"));
				complete.setFactSize(rs.getString("factSize"));
				complete.setPrjStructureTypeNum(rs.getString("prjStructureTypeNum"));
				complete.setBDate(rs.getDate("bDate"));
				complete.setEDate(rs.getDate("eDate"));
				complete.setCreateDate(rs.getDate("createDate"));
				complete.setMark(rs.getString("mark"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				complete.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				complete.setAppDept(rs.getString("appDept").trim());//������λid
				complete.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				complete.setProjectName(rs.getString("projectName"));//��������
				complete.setPrjFinishNum(rs.getString("prjFinishNum"));
				complete.setAppOpinion(rs.getString("appOpinion"));
				complete.setAppType(rs.getString("appType").trim());
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,completeId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			complete.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return complete;
	}
	
	public Corp queryCorpInfo(String corpCode)
	{
		Corp corp = new Corp();
		String sql = "select * from V_TBCORPFOREIGNINFO where corpCode=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				corp.setCorpId(rs.getString("corpId")); // ����
				corp.setCorpName(rs.getString("corpName")); // ��ҵ����
				corp.setCorpCode(rs.getString("corpCode")); // ��֯��������
				corp.setLicenseNum(rs.getString("licenseNum"));// ����Ӫҵִ��ע���
				corp.setProvinceNum(rs.getString("provinceNum"));// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum")); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countyNum")); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
				corp.setAddress(rs.getString("address")); // ��ҵӪҵ��ַ
				corp.setPostalCode(rs.getString("postalCode"));// ��ҵӪҵ��ַ��������
				corp.setLegalMan(rs.getString("legalMan")); // ��������������
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));// ����������֤������
				corp.setLegalManDuty(rs.getString("legalManDuty"));// ����������ְ��
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));// ����������ְ��
				corp.setEconomicNum(rs.getString("economicNum")); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
				corp.setRegPrin(rs.getString("regPrin")); // ע���ʱ�(��Ԫ)
				corp.setFactRegPrin(rs.getString("factRegPrin")); // ʵ���ʱ�(��Ԫ)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// ��������
				corp.setOfficePhone(rs.getString("officePhone"));// �칫�绰
				corp.setFax(rs.getString("fax")); // �������
				corp.setLinkMan(rs.getString("linkMan")); // ��ϵ������
				corp.setLinkTel(rs.getString("linkTel")); // ��ϵ�˰칫�绰
				corp.setLinkPhone(rs.getString("linkPhone")); // ��ϵ���ֻ�����
				corp.setEmail(rs.getString("email")); // ��ϵ����
				corp.setUrl(rs.getString("url")); // ��ҵ��ַ
				corp.setDescription(rs.getString("description")); // ��ע
				corp.setAssets(rs.getString("assets")); // ���ʲ�
				corp.setMachinery(rs.getString("machinery"));
				corp.setSpare1(rs.getString("spare1"));// ��ҵ������
				corp.setForeignCorpName(rs.getString("foreignCorpName"));// ����Ͷ��������
				corp.setNationNume(rs.getString("nationnum"));// ���������(�ֵ��TBNATIONALDIC)
				corp.setPercentTage(rs.getString("percentTage"));// ����Ͷ����ռ����(%)
				corp.setForeignIvestor(rs.getString("foreignIvestor")); // ����Ͷ��������
				corp.setCheckForeign(rs.getString("checkForeign"));// �Ƿ�����Ͷ��
				corp.setAppType(rs.getString("appType"));
				corp.setApplyOpinion(rs.getString("applyOpinion"));
				corp.setApplyDeptName(rs.getString("applyDeptName"));
				corp.setApplyDept(rs.getString("applyDept"));
				corp.setApplyStaffId(rs.getString("applyStaffId"));
				corp.setApplyStaffName(rs.getString("applyStaffName"));
				corp.setSpare1(rs.getString("spare1"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%"+end+"' and code != '"+provinceId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+cityId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//��ѯ��������Ȩ����
	public List<DictionaryClass> queryApprovalCity()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement("select * from TBXZQDMDIC_APP where "
					+ "(sortnum like '400%00' and sortnum !='400000') "
					+ "or (sortnum like '4000%' and sortnum !='400000') "
					+ "or (sortnum like '40%000' and sortnum !='400000') "
					+ "or (sortnum like '401100' and sortnum !='400000') "
					+ "or (sortnum like '401200' and sortnum !='400000') "
					+ "or (sortnum like '402700' and sortnum !='400000')");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//��ѯ��������Ȩ����/��
	public List<DictionaryClass> queryApprovaArea(String approvalCityId)
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			if(!"".equals(approvalCityId))
			{
				String star = approvalCityId.substring(0, 4);
				if(!star.equals("4000"))
				{
					pstmt = conn.prepareStatement("select * from TBXZQDMDIC_APP where code like '"+star+"%' and code != '"+approvalCityId+"'");
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						DictionaryClass dictionaryClass = new DictionaryClass();
						dictionaryClass.setCode(rs.getString("code"));
						dictionaryClass.setName(rs.getString("name"));
						list.add(dictionaryClass);
					}
				}else if(approvalCityId.equals("400021"))
				{
					//ɭ��
					pstmt = conn.prepareStatement("select * from TBXZQDMDIC_APP where pid = '400021'");
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						DictionaryClass dictionaryClass = new DictionaryClass();
						dictionaryClass.setCode(rs.getString("code"));
						dictionaryClass.setName(rs.getString("name"));
						list.add(dictionaryClass);
					}
				}else if(approvalCityId.equals("400020"))
				{
					//ũ��
					pstmt = conn.prepareStatement("select * from TBXZQDMDIC_APP where pid = '400020'");
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						DictionaryClass dictionaryClass = new DictionaryClass();
						dictionaryClass.setCode(rs.getString("code"));
						dictionaryClass.setName(rs.getString("name"));
						list.add(dictionaryClass);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
}
