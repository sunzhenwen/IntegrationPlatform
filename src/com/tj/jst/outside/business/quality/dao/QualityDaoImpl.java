package com.tj.jst.outside.business.quality.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.model.ProjcetTenderInfo;
import com.tj.jst.outside.business.quality.model.Plans;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 质量监督
 * @author hhc
 *
 */
public class QualityDaoImpl extends BaseDao implements IQualityDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					Quality quality = new Quality();
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
					page.getData().add(quality);
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
	 * 查询施工图审
	 * @param condition
	 * @return
	 */
	public Page pagedQualityPlans(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					Plans plans = new Plans();
					plans.setCensorNum(rs.getString("CensorNum"));//审查合格书编号
					plans.setPrjName(rs.getString("PrjName"));//审查时的工程名称
					plans.setCensorCorpName(rs.getString("CensorCorpName"));//审查机构
					plans.setCensorId(rs.getString("CensorId"));//审查主键
					plans.setEconCorpName(rs.getString("EconCorpName"));//勘察单位
					plans.setDesignCorpName(rs.getString("DesignCorpName"));//设计单位名称
					page.getData().add(plans);
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
	 * 质量监督申请
	 * @return
	 */
	public String add(Quality quality)
	{
		String qualityId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TB_QUALITYSUPERVISION(qualityId,PRJNUM,PRJNAME,"
					+ "prjId,createDate,applyCorpCode,applyCorpName,appType,processSteps,appDept,"
					+ "appDeptName,projectName,configuration,projectAddress,contact,"
					+ "constructionArea,quantities,expensive,superviseCost,startDate,"
					+ "endDate,developmentOrganization,developmentQualificationLevel,"
					+ "developmentCharge,developmentPhone,surveyUnit,"
					+ "surveyUnitQualificationLevel,surveyUnitCharge,surveyUnitPhone,"
					+ "designUnit,designUnitQualificationLevel,designUnitCharge,"
					+ "designUnitPhone,supervisionUnit,supervisionUnitQualLevel,"
					+ "supervisionUnitEngineer,supervisionUnitPhone,constructionUnit,"
					+ "constructionUnitQualLevel,constructionUnitProjectManager,"
					+ "constructionUnitPhone,constructionPlans,constructionPlansType,"
					+ "constructionPlansCharge,constructionPlansPhone,"
					+ "constructionContractFileNum,constructionOrganFileNum,"
					+ "constructionPlansFileNum,supervisionContractFileNum,"
					+ "supervisionPlanFileNum,fireControlFileNum,developmentOrganFileNum,"
					+ "onstructionUnitFileNum,supervisionUnitFileNum,"
					+ "constructionSiteFileNum,qualityTestingFileNum,"
					+ "fieldSupervisionFileNum,qualityNum,sectionName,tenderNum,contractMoney,econCorpCode,designCorpCode,consCorpCode,superCorpCode) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,qualityId);//主键
			pstmt.setString(2,quality.getPrjNum());//项目编号
			pstmt.setString(3,quality.getPrjName());//项目名称
			pstmt.setString(4,quality.getPrjId());//项目报建主键
			pstmt.setDate(5,new Date(new java.util.Date().getTime())); //记录登记日期
			pstmt.setString(6,quality.getApplyCorpCode()); //申请企业组织机构代码
			pstmt.setString(7,quality.getApplyCorpName()); //申请企业名称
			/**
			 * 审批状态
			 * 0、申请，1、审批通过，2、审批未通过
			 */
			pstmt.setString(8,"0");//审批状态
			/**
			 * 流程步骤
			 * 1:项目报建
			 * 2:勘察阶段、设计阶段
			 * 3:合同备案、施工图审查备案
			 * 4:质量监督、安全监督
			 * 5:施工许可
			 * 6:竣工验收
			 */
			pstmt.setString(9,"4");
			pstmt.setString(10,quality.getAppDept());//审批单位id
			pstmt.setString(11,quality.getAppDeptName());//审批单位名称
			pstmt.setString(12,quality.getProjectName());//工程名称
			pstmt.setString(13,quality.getConfiguration());//结构/层数
			pstmt.setString(14,quality.getProjectAddress());//工程地点
			pstmt.setString(15,quality.getContact());//联系人
			pstmt.setString(16,quality.getConstructionArea());//建设面积(平方米)
			pstmt.setString(17,quality.getQuantities());//安装工程量(万元)
			pstmt.setString(18,quality.getExpensive());//工程总造价(万元)
			pstmt.setString(19,quality.getSuperviseCost());//监督费(元)
			pstmt.setDate(20,quality.getStartDate());//计划开工日期
			pstmt.setDate(21,quality.getEndDate());//计划竣工日期
			pstmt.setString(22,quality.getDevelopmentOrganization());//建设单位
			pstmt.setString(23,quality.getDevelopmentQualificationLevel());//建设单位资质等级
			pstmt.setString(24,quality.getDevelopmentCharge());//建设单位项目负责人
			pstmt.setString(25,quality.getDevelopmentPhone());//建设单位联系电话
			pstmt.setString(26,quality.getSurveyUnit());//勘察单位
			pstmt.setString(27,quality.getSurveyUnitQualificationLevel());//勘察单位资质等级
			pstmt.setString(28,quality.getSurveyUnitCharge());//勘察单位项目负责人
			pstmt.setString(29,quality.getSurveyUnitPhone());//勘察单位联系电话
			pstmt.setString(30,quality.getDesignUnit());//设计单位
			pstmt.setString(31,quality.getDesignUnitQualificationLevel());//设计单位资质等级
			pstmt.setString(32,quality.getDesignUnitCharge());//设计单位项目负责人
			pstmt.setString(33,quality.getDesignUnitPhone());//设计单位联系电话
			pstmt.setString(34,quality.getSupervisionUnit());//监理单位
			pstmt.setString(35,quality.getSupervisionUnitQualLevel());//监理单位资质等级
			pstmt.setString(36,quality.getSupervisionUnitEngineer());//总监理工程师
			pstmt.setString(37,quality.getSupervisionUnitPhone());//监理单位联系电话
			pstmt.setString(38,quality.getConstructionUnit());//施工单位
			pstmt.setString(39,quality.getConstructionUnitQualLevel());//施工单位资质等级
			pstmt.setString(40,quality.getConstructionUnitProjectManager());//施工单位项目经理
			pstmt.setString(41,quality.getConstructionUnitPhone());//施工单位联系电话
			pstmt.setString(42,quality.getConstructionPlans());//施工图审查机构
			pstmt.setString(43,quality.getConstructionPlansType());//施工图审查机构类别
			pstmt.setString(44,quality.getConstructionPlansCharge());//施工图审查机构项目负责人
			pstmt.setString(45,quality.getConstructionPlansPhone());//施工图审查机构联系电话
			pstmt.setString(46,quality.getConstructionContractFileNum());//施工合同文件号
			pstmt.setString(47,quality.getConstructionOrganFileNum());//施工组织设计文件号
			pstmt.setString(48,quality.getConstructionPlansFileNum());//施工图审查报告和批准书文件号
			pstmt.setString(49,quality.getSupervisionContractFileNum());//监理合同文件号
			pstmt.setString(50,quality.getSupervisionPlanFileNum());//监理规划文件号
			pstmt.setString(51,quality.getFireControlFileNum());//消防设计审查合格书面证明文件文件号
			pstmt.setString(52,quality.getDevelopmentOrganFileNum());//建设单位项目负责人及项目机构组成文件号
			pstmt.setString(53,quality.getOnstructionUnitFileNum());//施工单位项目负责人及项目机构组成文件号
			pstmt.setString(54,quality.getSupervisionUnitFileNum());//监理单位项目负责人及项目机构组成文件号
			pstmt.setString(55,quality.getConstructionSiteFileNum());//施工现场项目负责人、技术人员资格证书文件号
			pstmt.setString(56,quality.getQualityTestingFileNum());//质量检查员岗位证书文件号
			pstmt.setString(57,quality.getFieldSupervisionFileNum());//现场监理人员注册执业证书文件号
			pstmt.setString(58, quality.getQualityNum());
			pstmt.setString(59, quality.getSectionName());
			pstmt.setString(60, quality.getTenderNum());
			
			pstmt.setString(61, quality.getContractMoney());
			pstmt.setString(62, quality.getEconCorpCode());
			pstmt.setString(63, quality.getDesignCorpCode());
			pstmt.setString(64, quality.getConsCorpCode());
			pstmt.setString(65, quality.getSuperCorpCode());
			
			pstmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return qualityId;
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Quality queryById(String qualityId)
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
				quality.setSectionName(rs.getString("sectionName"));
				quality.setTenderNum(rs.getString("tenderNum"));
				
				quality.setContractMoney(rs.getString("contractMoney"));
				quality.setEconCorpCode(rs.getString("econCorpCode"));
				quality.setDesignCorpCode(rs.getString("designCorpCode"));
				quality.setConsCorpCode(rs.getString("consCorpCode"));
				quality.setSuperCorpCode(rs.getString("superCorpCode"));
			}
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=4 order by num");
			rs = pstmt.executeQuery();
			List<Accessory> accessoryList = new ArrayList<Accessory>();
			while(rs.next())
			{
				Accessory acc = new Accessory();
				acc.setId(rs.getString("id"));
				acc.setLinkNum(rs.getString("linkNum"));
				acc.setLinkName(rs.getString("linkName"));
				acc.setMessage(rs.getString("message"));
				
				
				pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=? and ACCESSOTYID=? ");
				pstmt.setString(1,qualityId);
				pstmt.setString(2, acc.getId());
				uploadRs = pstmt.executeQuery();
				List<Upload> list = new ArrayList<Upload>();
				while(uploadRs.next())
				{
					Upload upload = new Upload();
					upload.setUploadId(uploadRs.getString("uploadId"));
					upload.setRoot(uploadRs.getString("root"));
					upload.setNewName(uploadRs.getString("newName"));
					upload.setLinkName(uploadRs.getString("linkName"));
					upload.setIsUnits(uploadRs.getString("isUnits"));
					upload.setId(uploadRs.getString("id"));
					upload.setFileFileName(uploadRs.getString("fileFileName"));
					list.add(upload);
				}
				acc.setList(list);
				accessoryList.add(acc);
			}
			quality.setAccessoryList(accessoryList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if(uploadRs!=null)
			{
				try {
					uploadRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}
	
	/**
	 * 质量监督申请修改
	 * @return
	 */
	public void modify(Quality quality)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TB_QUALITYSUPERVISION set PRJNUM=?,PRJNAME=?,"
					+ "prjId=?,"
					+ "projectName=?,configuration=?,projectAddress=?,contact=?,"
					+ "constructionArea=?,quantities=?,expensive=?,superviseCost=?,"
					+ "startDate=?,"
					+ "endDate=?,developmentOrganization=?,developmentQualificationLevel=?,"
					+ "developmentCharge=?,developmentPhone=?,surveyUnit=?,"
					+ "surveyUnitQualificationLevel=?,surveyUnitCharge=?,surveyUnitPhone=?,"
					+ "designUnit=?,designUnitQualificationLevel=?,designUnitCharge=?,"
					+ "designUnitPhone=?,supervisionUnit=?,supervisionUnitQualLevel=?,"
					+ "supervisionUnitEngineer=?,supervisionUnitPhone=?,constructionUnit=?,"
					+ "constructionUnitQualLevel=?,constructionUnitProjectManager=?,"
					+ "constructionUnitPhone=?,constructionPlans=?,constructionPlansType=?,"
					+ "constructionPlansCharge=?,constructionPlansPhone=?,"
					+ "constructionContractFileNum=?,constructionOrganFileNum=?,"
					+ "constructionPlansFileNum=?,supervisionContractFileNum=?,"
					+ "supervisionPlanFileNum=?,fireControlFileNum=?,developmentOrganFileNum=?,"
					+ "onstructionUnitFileNum=?,supervisionUnitFileNum=?,"
					+ "constructionSiteFileNum=?,qualityTestingFileNum=?,"
					+ " fieldSupervisionFileNum=?,tenderNum=?,sectionName=?, "
					
					+ " contractMoney=?,econCorpCode=?,designCorpCode=?,consCorpCode=?,"
					+ "superCorpCode=? "
					
					+ " where qualityId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,quality.getPrjNum());//项目编号
			pstmt.setString(2,quality.getPrjName());//项目名称
			pstmt.setString(3,quality.getPrjId());//项目报建主键
			pstmt.setString(4,quality.getProjectName());//工程名称
			pstmt.setString(5,quality.getConfiguration());//结构/层数
			pstmt.setString(6,quality.getProjectAddress());//工程地点
			pstmt.setString(7,quality.getContact());//联系人
			pstmt.setString(8,quality.getConstructionArea());//建设面积(平方米)
			pstmt.setString(9,quality.getQuantities());//安装工程量(万元)
			pstmt.setString(10,quality.getExpensive());//工程总造价(万元)
			pstmt.setString(11,quality.getSuperviseCost());//监督费(元)
			pstmt.setDate(12,quality.getStartDate());//计划开工日期
			pstmt.setDate(13,quality.getEndDate());//计划竣工日期
			pstmt.setString(14,quality.getDevelopmentOrganization());//建设单位
			pstmt.setString(15,quality.getDevelopmentQualificationLevel());//建设单位资质等级
			pstmt.setString(16,quality.getDevelopmentCharge());//建设单位项目负责人
			pstmt.setString(17,quality.getDevelopmentPhone());//建设单位联系电话
			pstmt.setString(18,quality.getSurveyUnit());//勘察单位
			pstmt.setString(19,quality.getSurveyUnitQualificationLevel());//勘察单位资质等级
			pstmt.setString(20,quality.getSurveyUnitCharge());//勘察单位项目负责人
			pstmt.setString(21,quality.getSurveyUnitPhone());//勘察单位联系电话
			pstmt.setString(22,quality.getDesignUnit());//设计单位
			pstmt.setString(23,quality.getDesignUnitQualificationLevel());//设计单位资质等级
			pstmt.setString(24,quality.getDesignUnitCharge());//设计单位项目负责人
			pstmt.setString(25,quality.getDesignUnitPhone());//设计单位联系电话
			pstmt.setString(26,quality.getSupervisionUnit());//监理单位
			pstmt.setString(27,quality.getSupervisionUnitQualLevel());//监理单位资质等级
			pstmt.setString(28,quality.getSupervisionUnitEngineer());//总监理工程师
			pstmt.setString(29,quality.getSupervisionUnitPhone());//监理单位联系电话
			pstmt.setString(30,quality.getConstructionUnit());//施工单位
			pstmt.setString(31,quality.getConstructionUnitQualLevel());//施工单位资质等级
			pstmt.setString(32,quality.getConstructionUnitProjectManager());//施工单位项目经理
			pstmt.setString(33,quality.getConstructionUnitPhone());//施工单位联系电话
			pstmt.setString(34,quality.getConstructionPlans());//施工图审查机构
			pstmt.setString(35,quality.getConstructionPlansType());//施工图审查机构类别
			pstmt.setString(36,quality.getConstructionPlansCharge());//施工图审查机构项目负责人
			pstmt.setString(37,quality.getConstructionPlansPhone());//施工图审查机构联系电话
			pstmt.setString(38,quality.getConstructionContractFileNum());//施工合同文件号
			pstmt.setString(39,quality.getConstructionOrganFileNum());//施工组织设计文件号
			pstmt.setString(40,quality.getConstructionPlansFileNum());//施工图审查报告和批准书文件号
			pstmt.setString(41,quality.getSupervisionContractFileNum());//监理合同文件号
			pstmt.setString(42,quality.getSupervisionPlanFileNum());//监理规划文件号
			pstmt.setString(43,quality.getFireControlFileNum());//消防设计审查合格书面证明文件文件号
			pstmt.setString(44,quality.getDevelopmentOrganFileNum());//建设单位项目负责人及项目机构组成文件号
			pstmt.setString(45,quality.getOnstructionUnitFileNum());//施工单位项目负责人及项目机构组成文件号
			pstmt.setString(46,quality.getSupervisionUnitFileNum());//监理单位项目负责人及项目机构组成文件号
			pstmt.setString(47,quality.getConstructionSiteFileNum());//施工现场项目负责人、技术人员资格证书文件号
			pstmt.setString(48,quality.getQualityTestingFileNum());//质量检查员岗位证书文件号
			pstmt.setString(49,quality.getFieldSupervisionFileNum());//现场监理人员注册执业证书文件号
			pstmt.setString(50, quality.getTenderNum());
			pstmt.setString(51, quality.getSectionName());
			
			
			pstmt.setString(52, quality.getContractMoney());
			pstmt.setString(53, quality.getEconCorpCode());
			pstmt.setString(54, quality.getDesignCorpCode());
			pstmt.setString(55, quality.getConsCorpCode());
			pstmt.setString(56, quality.getSuperCorpCode());
			
			pstmt.setString(57,quality.getQualityId());//主键
			

			
			
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String qualityId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TB_QUALITYSUPERVISION where qualityId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qualityId);//主键
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,qualityId);	
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				try {
					File myDelFile = new File(rs.getString("root")+"\\"+rs.getString("newName"));
					if (myDelFile.exists())
						myDelFile.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			pstmt = conn.prepareStatement("delete from UPLOAD_FILE where id=?");
			pstmt.setString(1,qualityId);	
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		//查询黑龙江
		String sql = "select * from TBXZQDMDIC where name like '%黑龙江%'";
		List<Regional> list = new ArrayList<Regional>();
		//省Id
		String prId = "";
		//市Id
		List<String> citys = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Regional regional = new Regional();
				regional.setId(rs.getString("code"));
				regional.setpId("-1");
				regional.setName(rs.getString("name"));
				regional.setOpen("true");
				prId = regional.getId();
				list.add(regional);
			}
			//查询市
			pstmt = conn.prepareStatement("select * from TBXZQDMDIC where code like '23%00' and code !='230000'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Regional regional = new Regional();
				regional.setId(rs.getString("code"));
				regional.setpId(prId);
				regional.setName(rs.getString("name"));
				regional.setOpen("true");
				citys.add(regional.getId());
				list.add(regional);
			}
			//查询区县
			for(int i=0;i<citys.size();i++)
			{
				String star = citys.get(i).substring(0, 4);
				pstmt = conn.prepareStatement("select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+citys.get(i)+"'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Regional regional = new Regional();
					regional.setId(rs.getString("code"));
					regional.setpId(citys.get(i));
					regional.setName(rs.getString("name"));
					list.add(regional);
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
	/**
	 * 根据树形排序id查询区域编码
	 * @param appDept
	 * @return
	 */
	public String queryAppDeptId(String appDept)
	{
		String sql = "select code from TBXZQDMDIC_APP where sortnum=?";
		String code = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, appDept);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				code = rs.getString("code");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return code;
	}

	/**
	 * 查询招投标项目
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
	ProjcetTenderInfo construction = new ProjcetTenderInfo();
	construction.setPrjNum(rs.getString("prjNum"));
	construction.setPrjSize(rs.getString("prjSize"));
	construction.setSectionName(rs.getString("sectionName"));//标段名称
	construction.setTenderNum(rs.getString("tenderNum"));//中标通知书编号
	construction.setTenderCorpName(rs.getString("tenderCorpName"));//中标单位
	//------------------------------------------------------------------------------
//	construction.setProjectName(rs.getString("projectName"));// 工程名称(质量监督注册)
//	construction.setConfiguration(rs.getString("configuration"));// 结构/层数(质量监督注册)
//	construction.setProjectAddress(rs.getString("projectAddress"));// 工程地点(质量监督注册)
//	construction.setContact(rs.getString("contact"));// 联系人(质量监督注册)
//	construction.setConstructionArea(rs.getString("constructionArea"));// 建设面积(平方米)(质量监督注册)
//	construction.setQuantities(rs.getString("quantities"));// 安装工程量(万元)(质量监督注册)
//	construction.setExpensive(rs.getString("expensive"));// 工程总造价(万元)(质量监督注册)
//	construction.setSuperviseCost(rs.getString("superviseCost"));// 监督费(元)(质量监督注册)
//	construction.setStartDate(rs.getDate("startDate"));// 计划开工日期(质量监督注册)
//	construction.setEndDate(rs.getDate("endDate"));// 计划竣工日期(质量监督注册)
//	construction.setDevelopmentOrganization(rs.getString("developmentOrganization"));// 建设单位(质量监督注册)
//	construction.setDevelopmentQualificationLevel(rs.getString("developmentQualificationLevel"));// 建设单位资质等级(质量监督注册)
//	construction.setDevelopmentCharge(rs.getString("developmentCharge"));// 建设单位项目负责人(质量监督注册)
//	construction.setDevelopmentPhone(rs.getString("developmentPhone"));// 建设单位联系电话(质量监督注册)
//	construction.setSurveyUnit(rs.getString("surveyUnit"));// 勘察单位(质量监督注册)
//	construction.setSurveyUnitQualificationLevel(rs.getString("surveyUnitQualificationLevel"));// 勘察单位资质等级(质量监督注册)
//	construction.setSurveyUnitCharge(rs.getString("surveyUnitCharge"));// 勘察单位项目负责人(质量监督注册)
//	construction.setSurveyUnitPhone(rs.getString("surveyUnitPhone"));// 勘察单位联系电话(质量监督注册)
//	construction.setDesignUnit(rs.getString("designUnit"));// 设计单位(质量监督注册)
//	construction.setDesignUnitQualificationLevel(rs.getString("designUnitQualificationLevel"));// 设计单位资质等级(质量监督注册)
//	construction.setDesignUnitCharge(rs.getString("designUnitCharge"));// 设计单位项目负责人(质量监督注册)
//	construction.setDesignUnitPhone(rs.getString("designUnitPhone"));// 设计单位联系电话(质量监督注册)
//	construction.setSupervisionUnit(rs.getString("supervisionUnit"));// 监理单位(质量监督注册)
//	construction.setSupervisionUnitQualLevel(rs.getString("supervisionUnitQualLevel"));// 监理单位资质等级(质量监督注册)
//	construction.setSupervisionUnitEngineer(rs.getString("supervisionUnitEngineer"));// 总监理工程师(质量监督注册)
//	construction.setSupervisionUnitPhone(rs.getString("supervisionUnitPhone"));// 监理单位联系电话(质量监督注册)
//	construction.setConstructionUnit(rs.getString("constructionUnit"));// 施工单位(质量监督注册)
//	construction.setConstructionUnitQualLevel(rs.getString("constructionUnitQualLevel"));// 施工单位资质等级(质量监督注册)
//	construction.setConstructionUnitProjectManager(rs.getString("constructionUnitProjectManager"));// 施工单位项目经理(质量监督注册)
//	construction.setConstructionUnitPhone(rs.getString("constructionUnitPhone"));// 施工单位联系电话(质量监督注册)
//	construction.setConstructionPlans(rs.getString("constructionPlans"));// 施工图审查机构(质量监督注册)
//	construction.setConstructionPlansType(rs.getString("constructionPlansType"));// 施工图审查机构类别(质量监督注册)
//	construction.setConstructionPlansCharge(rs.getString("constructionPlansCharge"));// 施工图审查机构项目负责人(质量监督注册)
//	construction.setConstructionPlansPhone(rs.getString("constructionPlansPhone"));// 施工图审查机构联系电话(质量监督注册)
//	// ----------------------------------呈报资料---------------------------------
//	construction.setConstructionContractFileNum(rs.getString("constructionContractFileNum"));// 施工合同文件号(质量监督注册)
//	construction.setConstructionOrganFileNum(rs.getString("constructionOrganFileNum"));// 施工组织设计文件号(质量监督注册)
//	construction.setConstructionPlansFileNum(rs.getString("constructionPlansFileNum"));// 施工图审查报告和批准书文件号(质量监督注册)
//	construction.setSupervisionContractFileNum(rs.getString("supervisionContractFileNum"));// 监理合同文件号(质量监督注册)
//	construction.setSupervisionPlanFileNum(rs.getString("supervisionPlanFileNum"));// 监理规划文件号(质量监督注册)
//	construction.setFireControlFileNum(rs.getString("fireControlFileNum"));// 消防设计审查合格书面证明文件文件号(质量监督注册)
//	construction.setDevelopmentOrganFileNum(rs.getString("developmentOrganFileNum"));// 建设单位项目负责人及项目机构组成文件号(质量监督注册)
//	construction.setOnstructionUnitFileNum(rs.getString("onstructionUnitFileNum"));// 施工单位项目负责人及项目机构组成文件号(质量监督注册)
//	construction.setSupervisionUnitFileNum(rs.getString("supervisionUnitFileNum"));// 监理单位项目负责人及项目机构组成文件号(质量监督注册)
//	construction.setConstructionSiteFileNum(rs.getString("constructionSiteFileNum"));// 施工现场项目负责人、技术人员资格证书文件号(质量监督注册)
//	construction.setQualityTestingFileNum(rs.getString("qualityTestingFileNum"));// 质量检查员岗位证书文件号(质量监督注册)
//	construction.setFieldSupervisionFileNum(rs.getString("fieldSupervisionFileNum"));// 现场监理人员注册执业证书文件号(质量监督注册)
	
	
	construction.setCreatedate(rs.getDate("createdate"));
					page.getData().add(construction);
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
}
