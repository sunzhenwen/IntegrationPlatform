package com.tj.jst.inner.business.qualityapply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 质量勘察数据库操作类
 * 
 * @author DarkFlameMaster
 *
 */
public class QualityApplyDaoImpl extends BaseDao implements IQualityApplyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
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
	 * 审批条目查询表
	 */
	@Override
	public Quality queryApproval(String qualityId) {
		// TODO Auto-generated method stub
		Quality quality = new Quality();
		try {

			String qsql = "select * from TB_QUALITYSUPERVISION where qualityId=?";
			// 获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, qualityId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				quality.setJianduzhuceNum(rs.getString("jianDuZhuCeNum"));
				quality.setQualityNum(rs.getString("QUALITYNUM"));
				quality.setWenjianNum(rs.getString("wenjianNum"));
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
				quality.setPrjId(rs.getString("prjId"));
				quality.setProjectName(rs.getString("projectName"));// 工程名称
				quality.setConfiguration(rs.getString("configuration"));// 结构/层数
				quality.setProjectAddress(rs.getString("projectAddress"));// 工程地点
				quality.setContact(rs.getString("contact"));// 联系人
				quality.setConstructionArea(rs.getString("constructionArea"));// 建设面积(平方米)
				quality.setQuantities(rs.getString("quantities"));// 安装工程量(万元)
				quality.setExpensive(rs.getString("expensive"));// 工程总造价(万元)
				quality.setSuperviseCost(rs.getString("superviseCost"));// 监督费(元)
				quality.setStartDate(rs.getDate("startDate"));// 计划开工日期
				quality.setEndDate(rs.getDate("endDate"));// 计划竣工日期
				quality.setDevelopmentOrganization(rs
						.getString("developmentOrganization"));// 建设单位
				quality.setDevelopmentQualificationLevel(rs
						.getString("developmentQualificationLevel"));// 建设单位资质等级
				quality.setDevelopmentCharge(rs.getString("developmentCharge"));// 建设单位项目负责人
				quality.setDevelopmentPhone(rs.getString("developmentPhone"));// 建设单位联系电话
				quality.setSurveyUnit(rs.getString("surveyUnit"));// 勘察单位
				quality.setSurveyUnitQualificationLevel(rs
						.getString("surveyUnitQualificationLevel"));// 勘察单位资质等级
				quality.setSurveyUnitCharge(rs.getString("surveyUnitCharge"));// 勘察单位项目负责人
				quality.setSurveyUnitPhone(rs.getString("surveyUnitPhone"));// 勘察单位联系电话
				quality.setDesignUnit(rs.getString("designUnit"));// 设计单位
				quality.setDesignUnitQualificationLevel(rs
						.getString("designUnitQualificationLevel"));// 设计单位资质等级
				quality.setDesignUnitCharge(rs.getString("designUnitCharge"));// 设计单位项目负责人
				quality.setDesignUnitPhone(rs.getString("designUnitPhone"));// 设计单位联系电话
				quality.setSupervisionUnit(rs.getString("supervisionUnit"));// 监理单位
				quality.setSupervisionUnitQualLevel(rs
						.getString("supervisionUnitQualLevel"));// 监理单位资质等级
				quality.setSupervisionUnitEngineer(rs
						.getString("supervisionUnitEngineer"));// 总监理工程师
				quality.setSupervisionUnitPhone(rs
						.getString("supervisionUnitPhone"));// 监理单位联系电话
				quality.setConstructionUnit(rs.getString("constructionUnit"));// 施工单位
				quality.setConstructionUnitQualLevel(rs
						.getString("constructionUnitQualLevel"));// 施工单位资质等级
				quality.setConstructionUnitProjectManager(rs
						.getString("constructionUnitProjectManager"));// 施工单位项目经理
				quality.setConstructionUnitPhone(rs
						.getString("constructionUnitPhone"));// 施工单位联系电话
				quality.setConstructionPlans(rs.getString("constructionPlans"));// 施工图审查机构
				quality.setConstructionPlansType(rs
						.getString("constructionPlansType"));// 施工图审查机构类别
				quality.setConstructionPlansCharge(rs
						.getString("constructionPlansCharge"));// 施工图审查机构项目负责人
				quality.setConstructionPlansPhone(rs
						.getString("constructionPlansPhone"));// 施工图审查机构联系电话
				quality.setConstructionContractFileNum(rs
						.getString("constructionContractFileNum"));// 施工合同文件号
				quality.setConstructionOrganFileNum(rs
						.getString("constructionOrganFileNum"));// 施工组织设计文件号
				quality.setConstructionPlansFileNum(rs
						.getString("constructionPlansFileNum"));// 施工图审查报告和批准书文件号
				quality.setSupervisionContractFileNum(rs
						.getString("supervisionContractFileNum"));// 监理合同文件号
				quality.setSupervisionPlanFileNum(rs
						.getString("supervisionPlanFileNum"));// 监理规划文件号
				quality.setFireControlFileNum(rs
						.getString("FireControlFileNum"));// 消防设计审查合格书面证明文件文件号
				quality.setDevelopmentOrganFileNum(rs
						.getString("DevelopmentOrganFileNum"));// 建设单位项目负责人及项目机构组成文件号
				quality.setOnstructionUnitFileNum(rs
						.getString("OnstructionUnitFileNum"));// 施工单位项目负责人及项目机构组成文件号
				quality.setSupervisionUnitFileNum(rs
						.getString("SupervisionUnitFileNum"));// 监理单位项目负责人及项目机构组成文件号
				quality.setConstructionSiteFileNum(rs
						.getString("ConstructionSiteFileNum"));// 施工现场项目负责人、技术人员资格证书文件号
				quality.setQualityTestingFileNum(rs
						.getString("QualityTestingFileNum"));// 质量检查员岗位证书文件号
				quality.setFieldSupervisionFileNum(rs
						.getString("FieldSupervisionFileNum"));// 现场监理人员注册执业证书文件号
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}

	/**
	 * 审批通过
	 */
	@Override
	public String applySuccess(Quality qu) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			// Calendar c = Calendar.getInstance();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyMMdd");
			// String fDate = simpleDateFormat.format(c.getTime());
			// String serNum = PrjCode.querySerNuma(qu.getCreateDate(), 5);
			// String quNum = qu.getAppDept() + fDate
			// + qu.getPrjNum().substring(12, 16) + "-QU-" + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE TB_QUALITYSUPERVISION set APPTYPE = 1 , PROCESSSTEPS = 5 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? , JIANDUZHUCENUM = ? , WENJIANNUM = ? where QUALITYID = ?");
			pstmt.setString(1, qu.getAppSteffId());
			pstmt.setString(2, qu.getAppSteffName());
			pstmt.setDate(3, qu.getAppDate());
			pstmt.setString(4, qu.getAppOpinion());
			pstmt.setString(5, qu.getJianduzhuceNum());
			pstmt.setString(6, qu.getWenjianNum());
			pstmt.setString(7, qu.getQualityId());
			pstmt.executeUpdate();
			conn.commit();
			message = "成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String applyFaile(Quality qu) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE TB_QUALITYSUPERVISION set APPTYPE = 2 , PROCESSSTEPS = 4 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? where QUALITYID = ?");
			pstmt.setString(1, qu.getAppSteffId());
			pstmt.setString(2, qu.getAppSteffName());
			pstmt.setDate(3, qu.getAppDate());
			pstmt.setString(4, qu.getAppOpinion());
			pstmt.setString(5, qu.getQualityId());
			pstmt.executeUpdate();
			conn.commit();
			message = "成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 查询安全是否完成
	 */
	@Override
	public String querySafety(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_SAFETYSUPERVISION  where PRJNUM='"
				+ prjNum + "' and PROCESSSTEPS = 5 and APPTYPE = 1";
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = "成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * 完成则更改基本信息
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "update  TBProjectInfo_S set PROCESSSTEPS=5 where PRJNUM='"
				+ prjNum + "' ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String message = "成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

	}

	/**
	 * 查看是否有上传的信息
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		String sql = "select * from UPLOAD_FILE where LINKNAME='质量监督注册' and ID = '"
				+ prjId + "'";
		List<Upload> list = new ArrayList<Upload>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setFileFileName(rs.getString("fileFileName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setNewName(rs.getString("newName"));
				upload.setRoot(rs.getString("root"));
				upload.setId(rs.getString("id"));
				list.add(upload);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 更改授权状态
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TO_AUTHORIZATION set PROCESSSTEPS=5 where prjNum='"
				+ prjId + "' ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = "成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

}
