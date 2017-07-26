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
	 * 项目报建
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
					project.setPrjId(rs.getString("prjId"));// 主键
					project.setPrjNum(rs.getString("prjNum"));// 项目编号
					project.setPrjName(rs.getString("prjName"));// 项目名称
					project.setPrjTypeNum(rs.getString("prjTypeNum"));// 项目分类
					project.setBuildCorpName(rs.getString("buildCorpName"));// 建设单位名称
					project.setBuildCorpCode(rs.getString("buildCorpCode"));// 建设单位组织机构代码证
					project.setProvinceNum(rs.getString("provinceNum"));// 项目所在省
					project.setCityNum(rs.getString("cityNum"));// 项目所在市
					project.setCountyNum(rs.getString("countyNum"));// 项目所在区
					project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// 立项文号
					project.setPrjApprovalLevelNum(rs.getString("prjApprovalLevelNum"));// 立项级别
					project.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
					project.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
					project.setAllInvest(rs.getString("allInvest"));// 总投资
					project.setAllArea(rs.getString("allArea"));// 总面积
					project.setPrjSize(rs.getString("prjSize"));// 建设规模
					project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// 建设性质
					project.setPrjFuncitonNum(rs.getString("prjFunctionNum"));// 工程用途
					project.setBDate(rs.getDate("bDate"));// 开始时间
					project.setEDate(rs.getDate("eDate"));// 结束时间
					project.setCreateDate(rs.getDate("createDate"));// 记录登记时间
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
	 * 项目报建详细
	 * @return
	 */
	public Construction queryConstructionInfo(String prjId)
	{
		Construction construction = new Construction();
		try {
			
			String qsql = "select * from V_TBPROJECTINFO_S where prjId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, prjId);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				construction.setPrjId(rs.getString("prjId"));//主键
				construction.setPrjNum(rs.getString("prjNum"));//项目编号
				construction.setPrjName(rs.getString("prjName"));//项目名称
				construction.setPrjTypeNum(rs.getString("prjTypeNum").trim());//项目分类(字典表：TBPRJTYPEDIC)
				construction.setPrjTypeName(rs.getString("prjTypeName"));
				construction.setBuildCorpName(rs.getString("buildCorpName"));//建设单位名称
				construction.setBuildCorpCode(rs.getString("buildCorpCode"));//建设单位组织机构代码
				construction.setProvinceNum(rs.getString("provinceNum"));//项目所在省(字典表：TBXZQDMDIC)
				construction.setProvinceName(rs.getString("provinceName"));
				construction.setCityNum(rs.getString("cityNum"));//项目所在市(字典表：TBXZQDMDIC)
				construction.setCityName(rs.getString("cityName"));
				construction.setCountyNum(rs.getString("countyNum"));//项目所在区县(字典表：TBXZQDMDIC)
				construction.setCountyName(rs.getString("countyName"));
				construction.setPrjApprovalNum(rs.getString("prjApprovalNum"));//立项文号
				construction.setPrjApprovalLevelNum(rs.getString("prjApprovalLevelNum"));//立项级别
				construction.setPrjApprovalLevelName(rs.getString("prjApprovalLevelName"));//立项级别名称
				construction.setBuldPlanNum(rs.getString("buldPlanNum"));//建设用地规划许可证编号
				construction.setProjectPlanNum(rs.getString("projectPlanNum"));//建设工程规划许可证编号
				construction.setAllInvest(rs.getString("allInvest"));//总投资（万元）
				construction.setAllArea(rs.getString("allArea"));//总面积（平方米）
				construction.setPrjSize(rs.getString("prjSize"));//建设规模
				construction.setPrjPropertyNum(rs.getString("prjPropertyNum").trim());//建设性质(字典表：TBPRJPORPERTYDIC)
				construction.setPrjPropertyName(rs.getString("prjPropertyName"));
				construction.setPrjFuncitonNum(rs.getString("PRJFUNCTIONNUM").trim());//工程用途(字典表：TBPRJFUNCTIONDIC)
				construction.setPrjFuncitonName(rs.getString("prjFuncitonName"));
				construction.setBDate(rs.getDate("BDate"));//实际开工日期；竣工备案环节为M
				construction.setEDate(rs.getDate("EDate"));//实际竣工验收日期；竣工备案环节为M
				construction.setCreateDate(rs.getDate("createDate"));//记录登记时间
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				construction.setAppType(rs.getString("appType").trim());//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				construction.setProcessSteps(rs.getString("processSteps").trim());
				construction.setAppDept(rs.getString("appDept").trim());//审批单位id
				construction.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
				construction.setAddress(rs.getString("address"));//建设地址
				construction.setBDate(rs.getDate("BDate"));//实际开工日期；竣工备案环节为M
				construction.setEDate(rs.getDate("EDate"));//实际竣工验收日期；竣工备案环节为M
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
	 * 勘察
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
					
					survey.setPrjId(rs.getString("prjId"));//主键
					survey.setPrjNum(rs.getString("prjNum"));//项目编号
					survey.setPrjName(rs.getString("prjName"));//项目名称
					survey.setCreateDate(rs.getDate("createDate"));//记录登记时间
					/**
					 * 审批状态
					 * 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					survey.setAppType(rs.getString("appType").trim());//审批状态
					/**
					 * 流程步骤
					 * 1:项目报建
					 * 2:勘察阶段、设计阶段
					 * 3:合同备案、施工图审查备案
					 * 4:质量监督、安全监督
					 * 5:施工许可
					 * 6:竣工验收
					 */
					survey.setProcessSteps(rs.getString("processSteps").trim());
					survey.setSurveyId(rs.getString("surveyId"));//勘察主键
					survey.setSurveyNum(rs.getString("surveyNum"));//勘察编码
					survey.setSurveyCorpName(rs.getString("surveyCorpName"));//设计单位名称
					survey.setSurveyCorpCode(rs.getString("surveyCorpCode"));//设计单位组织机构代码
					survey.setIsUnits(rs.getString("isUnits"));//设计单位是否填写资质 0:是 1:否
					survey.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
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
	 * 勘察
	 * @return
	 */
	public Survey querySurveyShareInfo(String surveyId)
	{
		Survey survey = new Survey();
		try {
			
			String qsql = "select * from survey_business where surveyId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, surveyId);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				survey.setSurveyId(rs.getString("SURVEYID"));//主键
				survey.setPrjNum(rs.getString("prjNum"));//项目编号
				survey.setPrjName(rs.getString("prjName"));//项目名称
				survey.setSurveyNum(rs.getString("SURVEYNUM"));//勘察编码
				survey.setSurveyCorpName(rs.getString("SURVEYCorpName"));//勘察单位名称
				survey.setSurveyCorpCode(rs.getString("SURVEYCorpCode"));//勘察单位组织机构代码
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				survey.setAppType(rs.getString("appType"));//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				survey.setProcessSteps(rs.getString("processSteps"));
				survey.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				survey.setCreateDate(rs.getDate("createDate"));//记录登记时间
				survey.setAppDept(rs.getString("appDept").trim());//审批单位id
				survey.setAppDeptName(rs.getString("appDeptName"));//审批单位名称
				survey.setIsUnits(rs.getString("isUnits").trim());//是否单位工程   0：是，1：否
				survey.setPrjId(rs.getString("prjId"));//项目报建id
				survey.setCorpName(rs.getString("corpName"));//建设单位
				survey.setSurveyNum(rs.getString("surveyNum"));//勘察编码
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
	 * 设计
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
					
					design.setPrjId(rs.getString("prjId"));//主键
					design.setPrjNum(rs.getString("prjNum"));//项目编号
					design.setPrjName(rs.getString("prjName"));//项目名称
					design.setCreateDate(rs.getDate("createDate"));//记录登记时间
					/**
					 * 审批状态
					 * 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					design.setAppType(rs.getString("appType").trim());//审批状态
					/**
					 * 流程步骤
					 * 1:项目报建
					 * 2:勘察阶段、设计阶段
					 * 3:合同备案、施工图审查备案
					 * 4:质量监督、安全监督
					 * 5:施工许可
					 * 6:竣工验收
					 */
					design.setProcessSteps(rs.getString("processSteps").trim());
					//------------------------------------------设计-------------------------------------------
					design.setDesignId(rs.getString("designId"));//设计主键
					design.setDesignNum(rs.getString("designNum"));//设计编码
					design.setDesignCorpName(rs.getString("designCorpName"));//设计单位名称
					design.setDesignCorpCode(rs.getString("designCorpCode"));//设计单位组织机构代码
					design.setIsUnits(rs.getString("isUnits"));//设计单位是否填写资质 0:是 1:否
					design.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
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
	 * 设计
	 * @return
	 */
	public Design queryDesignShareInfo(String designId)
	{
		Design design = new Design();
		try {
			
			String qsql = "select * from DESIGN_BUSINESS where designId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, designId);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				design.setDesignId(rs.getString("designId"));//主键
				design.setPrjNum(rs.getString("prjNum"));//项目编号
				design.setPrjName(rs.getString("prjName"));//项目名称
				design.setDesignNum(rs.getString("designNum"));//设计编码
				design.setDesignCorpName(rs.getString("designCorpName"));//设计单位名称
				design.setDesignCorpCode(rs.getString("designCorpCode"));//设计单位组织机构代码
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				design.setAppType(rs.getString("appType"));//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				design.setProcessSteps(rs.getString("processSteps"));
				design.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				design.setCreateDate(rs.getDate("createDate"));//记录登记时间
				design.setAppDept(rs.getString("appDept").trim());//审批单位id
				design.setAppDeptName(rs.getString("appDeptName"));//审批单位名称
				design.setIsUnits(rs.getString("isUnits").trim());//是否单位工程   0：是，1：否
				design.setPrjId(rs.getString("prjId"));//项目报建id
				design.setCorpName(rs.getString("corpName"));//建设单位
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
	 * 合同备案
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
					
					contractFiling.setRecordId(rs.getString("recordId"));//主键
					contractFiling.setRecordNum(rs.getString("recordNum"));//合同备案编号
					contractFiling.setPrjNum(rs.getString("prjNum"));//项目编号
					contractFiling.setPrjName(rs.getString("prjName"));//项目名称
					contractFiling.setContractNum(rs.getString("contractNum"));//合同编号
					contractFiling.setContractTypeNum(rs.getString("contractTypeNum"));//合同类别(TBCONTRACTTYPEDIC)
					contractFiling.setContractTypeName(rs.getString("contractTypeName"));//合同类别名称
					contractFiling.setContractMoney(rs.getString("contractMoney"));//合同金额(万元)
					contractFiling.setPrjSize(rs.getString("prjSize"));//建设规模
					contractFiling.setContractDate(rs.getDate("contractDate"));//合同签订日期
					contractFiling.setPropietorCorpName(rs.getString("propietorCorpName"));//发包单位名称
					contractFiling.setPropietorCorpCode(rs.getString("propietorCorpCode"));//发包单位住组织代码
					contractFiling.setContractorCorpName(rs.getString("contractorCorpName"));//承包单位名称
					contractFiling.setContractorCorpCode(rs.getString("contractorCorpCode"));//承包单位组织代码
					contractFiling.setUnionCorpName(rs.getString("unionCorpName"));//联合体承包单位名称
					contractFiling.setUnionCorpCode(rs.getString("unionCorpCode"));//联合体承包单位组织代码
					contractFiling.setCreateDate(rs.getDate("createDate"));//记录登记时间
					contractFiling.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
					contractFiling.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
					contractFiling.setAppSteffId(rs.getString("appSteffId"));//审批人id
					contractFiling.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
					contractFiling.setAppDate(rs.getDate("appDate"));//审批时间
					contractFiling.setAppOpinion(rs.getString("appOpinion"));//审批意见
					/**
					 * 审批状态
					 * 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					contractFiling.setAppType(rs.getString("appType").trim());//审批状态
					/**
					 * 流程步骤
					 * 1:项目报建
					 * 2:勘察阶段、设计阶段
					 * 3:合同备案、施工图审查备案
					 * 4:质量监督、安全监督
					 * 5:施工许可
					 * 6:竣工验收
					 */
					contractFiling.setProcessSteps(rs.getString("processSteps").trim());
					contractFiling.setAppDept(rs.getString("appDept").trim());//审批单位id
					contractFiling.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
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
	 * 合同备案
	 */
	public ContractFiling queryFilingShareInfo(String recordId)
	{
		ContractFiling contractFiling = new ContractFiling();
		try {
			
			String qsql = "select * from v_tbcontractrecordmanage where recordId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, recordId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				contractFiling.setRecordId(rs.getString("recordId"));//主键
				contractFiling.setRecordNum(rs.getString("recordNum"));//合同备案编号
				contractFiling.setPrjNum(rs.getString("prjNum"));//项目编号
				contractFiling.setPrjName(rs.getString("prjName"));//项目名称
				contractFiling.setContractNum(rs.getString("contractNum"));//合同编号
				contractFiling.setContractTypeNum(rs.getString("contractTypeNum"));//合同类别(TBCONTRACTTYPEDIC)
				contractFiling.setContractTypeName(rs.getString("contracttypeName"));//合同类别名称
				contractFiling.setContractMoney(rs.getString("CONTRACTMONEY"));//合同金额(万元)
				contractFiling.setPrjSize(rs.getString("PRJSIZE"));//建设规模
				contractFiling.setContractDate(rs.getDate("CONTRACTDATE"));//合同签订日期
				contractFiling.setPropietorCorpName(rs.getString("PROPIETORCORPNAME"));//发包单位名称
				contractFiling.setPropietorCorpCode(rs.getString("PROPIETORCORPCODE"));//发包单位住组织代码
				contractFiling.setContractorCorpName(rs.getString("CONTRACTORCORPNAME"));//承包单位名称
				contractFiling.setContractorCorpCode(rs.getString("CONTRACTORCORPCODE"));//承包单位组织代码
				contractFiling.setUnionCorpName(rs.getString("UNIONCORPNAME"));//联合体承包单位名称
				contractFiling.setUnionCorpCode(rs.getString("UNIONCORPCODE"));//联合体承包单位组织代码
				contractFiling.setCreateDate(rs.getDate("CREATEDATE"));//记录登记时间
				contractFiling.setApplyCorpCode(rs.getString("APPLYCORPCODE"));//申请企业组织机构代码
				contractFiling.setApplyCorpName(rs.getString("APPLYCORPNAME"));//申请企业名称
				contractFiling.setAppSteffId(rs.getString("appSteffId"));//审批人id
				contractFiling.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
				contractFiling.setAppDate(rs.getDate("appDate"));//审批时间
				contractFiling.setAppOpinion(rs.getString("appOpinion"));//审批意见
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				contractFiling.setAppType(rs.getString("appType").trim());//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				contractFiling.setProcessSteps(rs.getString("processSteps").trim());
				contractFiling.setAppDept(rs.getString("appDept").trim());//审批单位id
				contractFiling.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
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
	 * 施工图审查
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
							plan.setCensorId(rs.getInt("censorId"));// 主键
							plan.setCensorNum(rs.getString("censorNum"));// 施工图审查合格证书编号
							plan.setPrjNum(rs.getString("prjNum"));// 项目编号
							plan.setPrjName(rs.getString("prjName"));// 项目名称
							plan.setCensorCorpName(rs.getString("censorCorpName"));// 施工图审查机构名称
							plan.setCensorCorpCode(rs.getString("censorCorpCode"));// 施工图审查机构组织机构代码
							plan.setCensorEDate(rs.getDate("censorEDate"));// 审查完成日期
							plan.setPrjSize(rs.getString("prjSize"));// 建设规模
							plan.setEconCorpName(rs.getString("econCorpName"));// 勘察单位名称
							plan.setEconCorpCode(rs.getString("econCorpCode"));// 勘察单位组织机构代码
							plan.setEconCorpName2(rs.getString("econCorpName2"));// 勘察单位名称2
							plan.setEconCorpCode2(rs.getString("econCorpCode2")); // 勘察单位组织机构代码2
							plan.setEconCorpName3(rs.getString("econCorpName3"));// 勘察单位名称3
							plan.setEconCorpCode3(rs.getString("econCorpCode3")); // 勘察单位组织机构代码3
							plan.setDesignCorpName(rs.getString("designCorpName"));// 设计单位名称
							plan.setDesignCorpCode(rs.getString("designCorpCode"));// 设计单位组织机构代码
							plan.setDesignCorpName2(rs.getString("designCorpName2"));// 设计单位名称2
							plan.setDesignCorpCode2(rs.getString("designCorpCode2"));// 设计单位组织机构代码2
							plan.setDesignCorpName3(rs.getString("designCorpName3"));// 设计单位名称3
							plan.setDesignCorpCode3(rs.getString("designCorpCode3"));// 设计单位组织机构代码3
							plan.setOneCensorIsPass(rs.getString("oneCensorIsPass"));// 一次审查是否通过
																						// 通过1、不通过0
							plan.setOneCensorWfqtCount(rs
									.getString("oneCensorWfqtCount"));// 一次审查时违反强条数
							plan.setOneCensorWfqtContent(rs
									.getString("oneCensorWfqtContent"));// 一次审查时违反的强条条目
							plan.setCreateDate(rs.getDate("createDate"));// 记录登记日期
							plan.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
							plan.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
							plan.setAppSteffId(rs.getString("appSteffId"));// 审批人id
							plan.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
							plan.setAppDate(rs.getDate("appDate"));// 审批时间
							plan.setAppOpinion(rs.getString("appOpinion"));// 审批意见
							/**
							 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
							 */
							plan.setAppType(rs.getString("appType").trim());// 审批状态
							/**
							 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
							 * 6:竣工验收
							 */
							plan.setProcessSteps(rs.getString("processSteps").trim());
							plan.setAppDept(rs.getString("appDept").trim());// 审批单位id
							plan.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
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
	 * 施工图审查
	 */
	public ConstructionPlans queryPlanShareInfo(String censorId)
	{
		ConstructionPlans constructionPlans = new ConstructionPlans();
		try {
			
			String qsql = "select * from TBPROJECTCENSORINFO where censorId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, censorId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				constructionPlans.setCensorId(rs.getInt("censorId"));//主键
				constructionPlans.setCensorNum(rs.getString("censorNum"));//施工图审查合格证书编号
				constructionPlans.setPrjNum(rs.getString("prjNum"));//项目编号
				constructionPlans.setPrjName(rs.getString("prjName"));//项目名称
				constructionPlans.setCensorCorpName(rs.getString("censorCorpName"));//施工图审查机构名称
				constructionPlans.setCensorCorpCode(rs.getString("censorCorpCode"));//施工图审查机构组织机构代码
				constructionPlans.setCensorEDate(rs.getDate("censorEDate"));//审查完成日期
				constructionPlans.setPrjSize(rs.getString("prjSize"));//建设规模
				constructionPlans.setEconCorpName(rs.getString("econCorpName"));//勘察单位名称
				constructionPlans.setEconCorpCode(rs.getString("econCorpCode"));//勘察单位组织机构代码
				constructionPlans.setEconCorpName2(rs.getString("econCorpName2"));//勘察单位名称2
				constructionPlans.setEconCorpCode2(rs.getString("econCorpCode2")); //勘察单位组织机构代码2
				constructionPlans.setEconCorpName3(rs.getString("econCorpName3"));//勘察单位名称3
				constructionPlans.setEconCorpCode3(rs.getString("econCorpCode3")); //勘察单位组织机构代码3
				constructionPlans.setDesignCorpName(rs.getString("designCorpName"));//设计单位名称
				constructionPlans.setDesignCorpCode(rs.getString("designCorpCode"));//设计单位组织机构代码
				constructionPlans.setDesignCorpName2(rs.getString("designCorpName2"));//设计单位名称2
				constructionPlans.setDesignCorpCode2(rs.getString("designCorpCode2"));//设计单位组织机构代码2
				constructionPlans.setDesignCorpName3(rs.getString("designCorpName3"));//设计单位名称3
				constructionPlans.setDesignCorpCode3(rs.getString("designCorpCode3"));//设计单位组织机构代码3
				constructionPlans.setOneCensorIsPass(rs.getString("oneCensorIsPass"));//一次审查是否通过 通过1、不通过0
				constructionPlans.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));//一次审查时违反强条数
				constructionPlans.setOneCensorWfqtContent(rs.getString("oneCensorWfqtContent"));//一次审查时违反的强条条目
				constructionPlans.setCreateDate(rs.getDate("createDate"));//记录登记日期
				constructionPlans.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				constructionPlans.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
				constructionPlans.setAppSteffId(rs.getString("appSteffId"));//审批人id
				constructionPlans.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
				constructionPlans.setAppDate(rs.getDate("appDate"));//审批时间
				constructionPlans.setAppOpinion(rs.getString("appOpinion"));//审批意见
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				constructionPlans.setAppType(rs.getString("appType").trim());//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				constructionPlans.setProcessSteps(rs.getString("processSteps").trim());
				constructionPlans.setAppDept(rs.getString("appDept").trim());//审批单位id
				constructionPlans.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
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
	 * 质量监督
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
					quality.setQualityId(rs.getString("qualityId"));// 主键
					quality.setPrjNum(rs.getString("prjNum"));// 项目编号
					quality.setPrjName(rs.getString("prjName"));// 项目名称
					quality.setCreateDate(rs.getDate("createDate"));// 记录登记日期
					quality.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
					quality.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
					quality.setAppSteffId(rs.getString("appSteffId"));// 审批人id
					quality.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
					quality.setAppDate(rs.getDate("appDate"));// 审批时间
					quality.setAppOpinion(rs.getString("appOpinion"));// 审批意见
					/**
					 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					quality.setAppType(rs.getString("appType").trim());// 审批状态
					/**
					 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
					 * 6:竣工验收
					 */
					quality.setProcessSteps(rs.getString("processSteps").trim());
					quality.setAppDept(rs.getString("appDept").trim());// 审批单位id
					quality.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
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
	 * 质量监督
	 */
	public Quality queryQualityShareInfo(String qualityId)
	{
		Quality quality = new Quality();
		try {
			
			String qsql = "select * from TB_QUALITYSUPERVISION where qualityId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, qualityId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setQualityId(rs.getString("qualityId"));//主键
				quality.setPrjNum(rs.getString("prjNum"));//项目编号
				quality.setPrjName(rs.getString("prjName"));//项目名称
				quality.setCreateDate(rs.getDate("createDate"));//记录登记日期
				quality.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				quality.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
				quality.setAppSteffId(rs.getString("appSteffId"));//审批人id
				quality.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
				quality.setAppDate(rs.getDate("appDate"));//审批时间
				quality.setAppOpinion(rs.getString("appOpinion"));//审批意见
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				quality.setAppType(rs.getString("appType").trim());//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				quality.setProcessSteps(rs.getString("processSteps").trim());
				quality.setAppDept(rs.getString("appDept").trim());//审批单位id
				quality.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
				quality.setPrjId(rs.getString("prjId"));
				quality.setProjectName(rs.getString("projectName"));//工程名称
				quality.setConfiguration(rs.getString("configuration"));//结构/层数
				quality.setProjectAddress(rs.getString("projectAddress"));//工程地点
				quality.setContact(rs.getString("contact"));//联系人
				quality.setConstructionArea(rs.getString("constructionArea"));//建设面积(平方米)
				quality.setQuantities(rs.getString("quantities"));//安装工程量(万元)
				quality.setExpensive(rs.getString("expensive"));//工程总造价(万元)
				quality.setSuperviseCost(rs.getString("superviseCost"));//监督费(元)
				quality.setStartDate(rs.getDate("startDate"));//计划开工日期
				quality.setEndDate(rs.getDate("endDate"));//计划竣工日期
				quality.setDevelopmentOrganization(rs.getString("developmentOrganization"));//建设单位
				quality.setDevelopmentQualificationLevel(rs.getString("developmentQualificationLevel"));//建设单位资质等级
				quality.setDevelopmentCharge(rs.getString("developmentCharge"));//建设单位项目负责人
				quality.setDevelopmentPhone(rs.getString("developmentPhone"));//建设单位联系电话
				quality.setSurveyUnit(rs.getString("surveyUnit"));//勘察单位
				quality.setSurveyUnitQualificationLevel(rs.getString("surveyUnitQualificationLevel"));//勘察单位资质等级
				quality.setSurveyUnitCharge(rs.getString("surveyUnitCharge"));//勘察单位项目负责人
				quality.setSurveyUnitPhone(rs.getString("surveyUnitPhone"));//勘察单位联系电话
				quality.setDesignUnit(rs.getString("designUnit"));//设计单位
				quality.setDesignUnitQualificationLevel(rs.getString("designUnitQualificationLevel"));//设计单位资质等级
				quality.setDesignUnitCharge(rs.getString("designUnitCharge"));//设计单位项目负责人
				quality.setDesignUnitPhone(rs.getString("designUnitPhone"));//设计单位联系电话
				quality.setSupervisionUnit(rs.getString("supervisionUnit"));//监理单位
				quality.setSupervisionUnitQualLevel(rs.getString("supervisionUnitQualLevel"));//监理单位资质等级
				quality.setSupervisionUnitEngineer(rs.getString("supervisionUnitEngineer"));//总监理工程师
				quality.setSupervisionUnitPhone(rs.getString("supervisionUnitPhone"));//监理单位联系电话
				quality.setConstructionUnit(rs.getString("constructionUnit"));//施工单位
				quality.setConstructionUnitQualLevel(rs.getString("constructionUnitQualLevel"));//施工单位资质等级
				quality.setConstructionUnitProjectManager(rs.getString("constructionUnitProjectManager"));//施工单位项目经理
				quality.setConstructionUnitPhone(rs.getString("constructionUnitPhone"));//施工单位联系电话
				quality.setConstructionPlans(rs.getString("constructionPlans"));//施工图审查机构
				quality.setConstructionPlansType(rs.getString("constructionPlansType"));//施工图审查机构类别
				quality.setConstructionPlansCharge(rs.getString("constructionPlansCharge"));//施工图审查机构项目负责人
				quality.setConstructionPlansPhone(rs.getString("constructionPlansPhone"));//施工图审查机构联系电话
				quality.setConstructionContractFileNum(rs.getString("constructionContractFileNum"));//施工合同文件号
				quality.setConstructionOrganFileNum(rs.getString("constructionOrganFileNum"));//施工组织设计文件号
				quality.setConstructionPlansFileNum(rs.getString("constructionPlansFileNum"));//施工图审查报告和批准书文件号
				quality.setSupervisionContractFileNum(rs.getString("supervisionContractFileNum"));//监理合同文件号
				quality.setSupervisionPlanFileNum(rs.getString("supervisionPlanFileNum"));//监理规划文件号
				quality.setFireControlFileNum(rs.getString("FireControlFileNum"));//消防设计审查合格书面证明文件文件号
				quality.setDevelopmentOrganFileNum(rs.getString("DevelopmentOrganFileNum"));//建设单位项目负责人及项目机构组成文件号
				quality.setOnstructionUnitFileNum(rs.getString("OnstructionUnitFileNum"));//施工单位项目负责人及项目机构组成文件号
				quality.setSupervisionUnitFileNum(rs.getString("SupervisionUnitFileNum"));//监理单位项目负责人及项目机构组成文件号
				quality.setConstructionSiteFileNum(rs.getString("ConstructionSiteFileNum"));//施工现场项目负责人、技术人员资格证书文件号
				quality.setQualityTestingFileNum(rs.getString("QualityTestingFileNum"));//质量检查员岗位证书文件号
				quality.setFieldSupervisionFileNum(rs.getString("FieldSupervisionFileNum"));//现场监理人员注册执业证书文件号
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
	 * 安全监督
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
					safety.setSafetyId(rs.getString("SAFETYID"));// 主键
					safety.setPrjNum(rs.getString("prjNum"));// 项目编号
					safety.setPrjName(rs.getString("prjName"));// 项目名称
					safety.setCreateDate(rs.getDate("createDate"));// 记录登记日期
					safety.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
					safety.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
					safety.setAppSteffId(rs.getString("appSteffId"));// 审批人id
					safety.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
					safety.setAppDate(rs.getDate("appDate"));// 审批时间
					safety.setAppOpinion(rs.getString("appOpinion"));// 审批意见
					/**
					 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					safety.setAppType(rs.getString("appType").trim());// 审批状态
					/**
					 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
					 * 6:竣工验收
					 */
					safety.setProcessSteps(rs.getString("processSteps").trim());
					safety.setAppDept(rs.getString("appDept").trim());// 审批单位id
					safety.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
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
	 * 安全监督
	 */
	public Safety querySafetyInfo(String safetyId)
	{
		Safety quality = new Safety();
		try {
			
			String qsql = "select * from TB_SAFETYSUPERVISION where SAFETYID=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, safetyId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setPrjId(rs.getString("prjId"));
				quality.setSafetyId(rs.getString("SAFETYID"));//主键
				quality.setPrjNum(rs.getString("prjNum"));//项目编号
				quality.setPrjName(rs.getString("prjName"));//项目名称
				quality.setCreateDate(rs.getDate("createDate"));//记录登记日期
				quality.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				quality.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
				quality.setAppSteffId(rs.getString("appSteffId"));//审批人id
				quality.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
				quality.setAppDate(rs.getDate("appDate"));//审批时间
				quality.setAppOpinion(rs.getString("appOpinion"));//审批意见
				quality.setOversightNum(rs.getString("oversightNum"));
				
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				quality.setAppType(rs.getString("appType").trim());//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				quality.setProcessSteps(rs.getString("processSteps").trim());
				quality.setAppDept(rs.getString("appDept").trim());//审批单位id
				quality.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
				quality.setPrjId(rs.getString("prjId"));
				quality.setProjectName(rs.getString("projectName"));//工程名称
				quality.setProjectAddress(rs.getString("projectAddress"));//工程地点
				quality.setProStartDate(rs.getDate("proStartDate"));//合同开工日期
				quality.setProEndDate(rs.getDate("proEndDate"));//合同竣工日期
				quality.setProjectType(rs.getString("projectType"));//工程类型
				quality.setSafetyTarget(rs.getString("safetyTarget"));//安全生产标准化创建目标
				if(rs.getString("newlyBuild") != null)
				{
					quality.setNewlyBuild(rs.getString("newlyBuild").trim());//新建
				}else
				{
					quality.setNewlyBuild(rs.getString("newlyBuild"));//新建
				}
				if(rs.getString("extend") != null)
				{
					quality.setExtend(rs.getString("extend").trim());//改扩建
				}else
				{
					quality.setExtend(rs.getString("extend"));//改扩建
				}
				if(rs.getString("other") != null)
				{
					quality.setOther(rs.getString("other").trim());//其它
				}else
				{
					quality.setOther(rs.getString("other"));//其它
				}
				quality.setPolicingName(rs.getString("policingName"));//勘察单位全称
				quality.setPolicingStaff(rs.getString("policingStaff"));//勘察单位项目负责人
				quality.setDesignName(rs.getString("designName"));//设计单位全称
				quality.setDesignStaff(rs.getString("designStaff"));//设计单位项目负责人
				quality.setBuildingName(rs.getString("buildingName"));//建设单位全称
				quality.setBuildingStaff(rs.getString("buildingStaff"));//建设单位项目负责人
				quality.setBuildingPhone(rs.getString("buildingPhone"));//建设单位联系电话
				quality.setSupervisionName(rs.getString("supervisionName"));//监理单位全称
				quality.setSupervisionStaff(rs.getString("supervisionStaff"));//监理单位项目总监姓名
				quality.setSupervisionNum(rs.getString("supervisionNum"));//监理单位项目总监注册证书号
				quality.setSupervisionPhone(rs.getString("supervisionPhone"));//监理单位项目总监联系电话
				quality.setProbationStaff(rs.getString("probationStaff"));//监理单位安全监督姓名
				quality.setProbationPhone(rs.getString("probationPhone"));//监理单位安全监督联系电话
				quality.setProbationNum(rs.getString("probationNum"));//监理单位安全监督注册证书号
				quality.setProbationSafeNum(rs.getString("probationSafeNum"));//监理单位安全监督安全监理证号
				quality.setContractName(rs.getString("contractName"));//施工总承包单位全称
				quality.setContractAdmin(rs.getString("contractAdmin"));//施工总承包单位公司安全管理
				quality.setContractPhone(rs.getString("contractPhone"));//施工总承包单位联系电话
				quality.setContractStaff(rs.getString("contractStaff"));//施工总承包单位负责人
				quality.setContractSafeNum(rs.getString("contractSafeNum"));//施工总承包单位安全考核证号
				quality.setContractProStaff(rs.getString("contractProStaff"));//施工总承包单位项目负责人姓名
				quality.setContractProStaffPhone(rs.getString("contractProStaffPhone"));//施工总承包单位项目负责人联系电话
				quality.setContractStaffRegNum(rs.getString("contractStaffRegNum"));//施工总承包单位项目负责人注册证号
				quality.setContractStaffNum(rs.getString("contractStaffNum"));//施工总承包单位项目负责人安全考核证号
				//quality.setSingleNum(rs.getString("singleNum"));//单位工程编号
				quality.setUnitProject(rs.getString("unitProject"));//单位工程
				quality.setScale(rs.getString("scale"));//建筑规模
				quality.setCost(rs.getString("cost"));//工程造价
				quality.setStructure(rs.getString("structure"));//结构/层次
				quality.setHeight(rs.getString("height"));//建筑高度
				quality.setSafetyNum(rs.getString("safetyNum"));
				//施工总承包单位现场专职安全管理人员
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
				
				
				//专业分包单位
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
				
				
				//劳务分包单位
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
	 * 施工许可
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
					permit.setPermitId(rs.getString("permitId"));// 主键
					permit.setPrjNum(rs.getString("prjNum"));// 项目编号
					permit.setProjectName(rs.getString("projectName"));// 工程名称
					permit.setPrjName(rs.getString("prjName"));// 项目名称
					permit.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// 施工许可证编号
					permit.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
					permit.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
					permit.setCensorNum(rs.getString("censorNum"));// 施工图审查合格书便好
					permit.setContractMoney(rs.getString("contractMoney"));// 合同金额(万元)
					permit.setArea(rs.getString("area"));// 面积(平方米)
					permit.setPrjSize(rs.getString("prjSize"));// 建设规模
					permit.setIssueCertDate(rs.getDate("issueCertDate"));// 发证日期
					permit.setEconCorpName(rs.getString("econCorpName"));// 勘察单位名称
					permit.setEconCorpCode(rs.getString("econCorpCode"));// 勘察单位组织机构代码
					permit.setDesignCorpName(rs.getString("designCorpName"));// 设计单位名称
					permit.setDesignCorpCode(rs.getString("designCorpCode"));// 设计单位组织机构代码
					permit.setConsCorpname(rs.getString("consCorpname"));// 施工单位名称
					permit.setConsCorpCode(rs.getString("consCorpCode"));// 施工单位组织机构代码
					permit.setSafetyCerId(rs.getString("safetyCerId"));// 施工单位安全生产许可证编号
					permit.setSuperCorpName(rs.getString("superCorpName"));// 监理单位名称
					permit.setSuperCorpCode(rs.getString("superCorpCode"));// 监理单位组织机构代码
					permit.setConstructorName(rs.getString("constructorName"));// 项目经理姓名
					permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));// 项目经理证件类型(TBIDCARDTYPEDIC)
					permit.setConstructorIdCard(rs
							.getString("constructorIdCard"));// 项目经理证件号码
					permit.setSupervisionName(rs.getString("supervisionName"));// 总监理工程师姓名
					permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));// 总监理工程师证件类型(TBIDCARDTYPEDIC)
					permit.setSupervisionIdCard(rs
							.getString("supervisionIdCard"));// 总监理工程师号码
					permit.setUserName(rs.getString("userName"));// 安全生产管理人员姓名
					permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));// 安全生产管理证件类型(TBIDCARDTYPEDIC)
					permit.setIdCard(rs.getString("idCard"));// 安全生产管理人员证件号
					permit.setCertId(rs.getString("certId"));// 安全生产考核合格证书编号
					permit.setUserType(rs.getString("userType"));// 安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
					permit.setCreateDate(rs.getDate("createDate"));// 记录登记日期
					permit.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
					permit.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
					permit.setAppSteffId(rs.getString("appSteffId"));// 审批人id
					permit.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
					permit.setAppDate(rs.getDate("appDate"));// 审批时间
					permit.setAppOpinion(rs.getString("appOpinion"));// 审批意见
					/**
					 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					permit.setAppType(rs.getString("appType").trim());// 审批状态
					/**
					 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
					 * 6:竣工验收
					 */
					permit.setProcessSteps(rs.getString("processSteps").trim());
					permit.setAppDept(rs.getString("appDept").trim());// 审批单位id
					permit.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
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
	 * 施工许可
	 */
	public Permit queryPromiseShareInfo(String permitId)
	{
		Permit permit = new Permit();
		try {
			
			String qsql = "select * from tbbuilderlicencemanage where permitId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
			
				permit.setPrjId(rs.getString("prjId"));
				permit.setPermitId(rs.getString("permitId"));//主键
				permit.setPrjNum(rs.getString("prjNum"));//项目编号
				permit.setPrjName(rs.getString("prjName"));//项目名称
				permit.setProjectName(rs.getString("projectName"));//工程名称
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//施工许可证编号
				permit.setBuldPlanNum(rs.getString("buldPlanNum"));//建设用地规划许可证编号
				permit.setProjectPlanNum(rs.getString("projectPlanNum"));//建设工程规划许可证编号
				permit.setCensorNum(rs.getString("censorNum"));//施工图审查合格书便好
				permit.setContractMoney(rs.getString("contractMoney"));//合同金额(万元)
				permit.setArea(rs.getString("area"));//面积(平方米)
				permit.setPrjSize(rs.getString("prjSize"));//建设规模
				permit.setIssueCertDate(rs.getDate("issueCertDate"));//发证日期
				permit.setEconCorpName(rs.getString("econCorpName"));//勘察单位名称
				permit.setEconCorpCode(rs.getString("econCorpCode"));//勘察单位组织机构代码
				permit.setDesignCorpName(rs.getString("designCorpName"));//设计单位名称
				permit.setDesignCorpCode(rs.getString("designCorpCode"));//设计单位组织机构代码
				permit.setConsCorpname(rs.getString("consCorpname"));//施工单位名称
				permit.setConsCorpCode(rs.getString("consCorpCode"));//施工单位组织机构代码
				permit.setSafetyCerId(rs.getString("safetyCerId"));//施工单位安全生产许可证编号
				permit.setSuperCorpName(rs.getString("superCorpName"));//监理单位名称     
				permit.setSuperCorpCode(rs.getString("superCorpCode"));//监理单位组织机构代码
				permit.setConstructorName(rs.getString("constructorName"));//项目经理姓名
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));//项目经理证件类型(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));//项目经理证件号码
				permit.setSupervisionName(rs.getString("supervisionName"));//总监理工程师姓名
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));//总监理工程师证件类型(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));//总监理工程师号码
				permit.setUserName(rs.getString("userName"));//安全生产管理人员姓名
				permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));//安全生产管理证件类型(TBIDCARDTYPEDIC)
				permit.setIdCard(rs.getString("idCard"));//安全生产管理人员证件号
				permit.setCertId(rs.getString("certId"));//安全生产考核合格证书编号
				permit.setUserType(rs.getString("userType"));//安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
				permit.setCreateDate(rs.getDate("createDate"));//记录登记日期
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				permit.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
				permit.setAppSteffId(rs.getString("appSteffId"));//审批人id
				permit.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
				permit.setAppDate(rs.getDate("appDate"));//审批时间
				permit.setAppOpinion(rs.getString("appOpinion"));//审批意见
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				permit.setAppType(rs.getString("appType").trim());//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				permit.setProcessSteps(rs.getString("processSteps").trim());
				permit.setAppDept(rs.getString("appDept").trim());//审批单位id
				permit.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
				
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
	 * 竣工验收
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
					complete.setCompleteId(rs.getString("completeId"));// 主键
					complete.setPrjNum(rs.getString("prjNum"));// 项目编号
					complete.setPrjName(rs.getString("prjName"));// 项目名称
					complete.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// 施工许可证编号
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
					complete.setCreateDate(rs.getDate("createDate"));// 记录登记日期
					complete.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
					complete.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
					complete.setAppSteffId(rs.getString("appSteffId"));// 审批人id
					complete.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
					complete.setAppDate(rs.getDate("appDate"));// 审批时间
					complete.setAppOpinion(rs.getString("appOpinion"));// 审批意见
					/**
					 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					complete.setAppType(rs.getString("appType").trim());// 审批状态
					/**
					 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
					 * 6:竣工验收
					 */
					complete.setProcessSteps(rs.getString("processSteps")
							.trim());
					complete.setAppDept(rs.getString("appDept").trim());// 审批单位id
					complete.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
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
	 * 竣工验收
	 */
	public Complete queryReadyShareInfo(String completeId)
	{
		Complete complete = new Complete();
		try {
			
			String qsql = "select * from TBPROJECTFINISHMANAGE where completeId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, completeId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				complete.setPrjId(rs.getString("prjId"));
				complete.setCompleteId(rs.getString("completeId"));//主键
				complete.setPrjNum(rs.getString("prjNum"));//项目编号
				complete.setPrjName(rs.getString("prjName"));//项目名称
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//施工许可证编号
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
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				complete.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
				complete.setAppDept(rs.getString("appDept").trim());//审批单位id
				complete.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
				complete.setProjectName(rs.getString("projectName"));//工程名称
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
				corp.setCorpId(rs.getString("corpId")); // 主键
				corp.setCorpName(rs.getString("corpName")); // 企业名称
				corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码
				corp.setLicenseNum(rs.getString("licenseNum"));// 工商营业执照注册号
				corp.setProvinceNum(rs.getString("provinceNum"));// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum")); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countyNum")); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				corp.setAddress(rs.getString("address")); // 企业营业地址
				corp.setPostalCode(rs.getString("postalCode"));// 企业营业地址邮政编码
				corp.setLegalMan(rs.getString("legalMan")); // 法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));// 法定代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty"));// 法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));// 法定代表人职称
				corp.setEconomicNum(rs.getString("economicNum")); // 企业登记注册类型(字典表：TBECONTYPEDIC)
				corp.setRegPrin(rs.getString("regPrin")); // 注册资本(万元)
				corp.setFactRegPrin(rs.getString("factRegPrin")); // 实收资本(万元)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// 成立日期
				corp.setOfficePhone(rs.getString("officePhone"));// 办公电话
				corp.setFax(rs.getString("fax")); // 传真号码
				corp.setLinkMan(rs.getString("linkMan")); // 联系人姓名
				corp.setLinkTel(rs.getString("linkTel")); // 联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone")); // 联系人手机号码
				corp.setEmail(rs.getString("email")); // 联系邮箱
				corp.setUrl(rs.getString("url")); // 企业网址
				corp.setDescription(rs.getString("description")); // 备注
				corp.setAssets(rs.getString("assets")); // 净资产
				corp.setMachinery(rs.getString("machinery"));
				corp.setSpare1(rs.getString("spare1"));// 企业归属地
				corp.setForeignCorpName(rs.getString("foreignCorpName"));// 外商投资者名称
				corp.setNationNume(rs.getString("nationnum"));// 国籍或地区(字典表：TBNATIONALDIC)
				corp.setPercentTage(rs.getString("percentTage"));// 外商投资所占比例(%)
				corp.setForeignIvestor(rs.getString("foreignIvestor")); // 外商投资这类型
				corp.setCheckForeign(rs.getString("checkForeign"));// 是否外商投资
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
	
	//查询省
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

	//查询市
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

	//查询区
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
	
	//查询具有审批权的市
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
	
	//查询具有审批权的区/县
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
					//森工
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
					//农垦
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
