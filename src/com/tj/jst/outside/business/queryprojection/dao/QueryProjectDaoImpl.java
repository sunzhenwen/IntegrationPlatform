package com.tj.jst.outside.business.queryprojection.dao;

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
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.queryprojection.model.Filing;
import com.tj.jst.outside.business.queryprojection.model.Permit;
import com.tj.jst.outside.business.queryprojection.model.Plan;
import com.tj.jst.outside.business.queryprojection.model.ProjectModel;
import com.tj.jst.outside.business.queryprojection.model.Ready;
import com.tj.jst.outside.business.queryprojection.model.Tender;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 业务查询
 * 
 * @author Administrator
 *
 */
public class QueryProjectDaoImpl extends BaseDao implements IQueryProjectDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Construction construction = new Construction();

					construction.setPrjId(rs.getString("prjId"));// 主键
					construction.setPrjNum(rs.getString("prjNum"));// 项目编号
					construction.setPrjName(rs.getString("prjName"));// 项目名称
					construction.setPrjTypeNum(rs.getString("prjTypeNum"));// 项目分类(字典表：TBPRJTYPEDIC)
					construction.setPrjTypeName(rs.getString("prjTypeName"));
					construction
							.setBuildCorpName(rs.getString("buildCorpName"));// 建设单位名称
					construction
							.setBuildCorpCode(rs.getString("buildCorpCode"));// 建设单位组织机构代码
					construction.setProvinceNum(rs.getString("provinceNum"));// 项目所在省(字典表：TBXZQDMDIC)
					construction.setProvinceName(rs.getString("provinceName"));
					construction.setCityNum(rs.getString("cityNum"));// 项目所在市(字典表：TBXZQDMDIC)
					construction.setCityName(rs.getString("cityName"));
					construction.setCountyNum(rs.getString("countyNum"));// 项目所在区县(字典表：TBXZQDMDIC)
					construction.setCountyName(rs.getString("countyName"));
					construction.setPrjApprovalNum(rs
							.getString("prjApprovalNum"));// 立项文号
					construction.setPrjApprovalLevelNum(rs
							.getString("prjApprovalLevelNum"));// 立项级别
					construction.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
					construction.setProjectPlanNum(rs
							.getString("projectPlanNum"));// 建设工程规划许可证编号
					construction.setAllInvest(rs.getString("allInvest"));// 总投资（万元）
					construction.setAllArea(rs.getString("allArea"));// 总面积（平方米）
					construction.setPrjSize(rs.getString("prjSize"));// 建设规模
					construction.setPrjPropertyNum(rs
							.getString("prjPropertyNum"));// 建设性质(字典表：TBPRJPORPERTYDIC)
					construction.setPrjFuncitonNum(rs
							.getString("PRJFUNCTIONNUM"));// 工程用途(字典表：TBPRJFUNCTIONDIC)
					construction.setBDate(rs.getDate("bDate"));// 实际开工日期；竣工备案环节为M
					construction.setEDate(rs.getDate("eDate"));// 实际竣工验收日期；竣工备案环节为M
					construction.setCreateDate(rs.getDate("createDate"));// 记录登记时间
//					/**
//					 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
//					 */
//					construction.setAppType(rs.getString("appType").trim());// 审批状态
//					/**
//					 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
//					 * 6:竣工验收
//					 */
//					construction.setProcessSteps(rs.getString("processSteps"));
//					construction.setAppDept(rs.getString("appDept"));// 审批单位id
//					construction.setAppDeptName(rs.getString("appDeptName"));// 审批单位名称
					page.getData().add(construction);
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

	@Override
	public ProjectModel queryProjectInfo(String prjName) {
		// TODO Auto-generated method stub
		String sql = "select t.*, "
				+ "(select a.PROCLASSIFICATION from TBPRJTYPEDIC a where t.prjTypeNum=a.code) as prjTypeName,"
				+ "(select b.name from TBXZQDMDIC b where t.provinceNum=b.code) as provinceName,"
				+ "(select c.name from TBXZQDMDIC c where t.cityNum=c.code) as cityName,"
				+ "(select d.name from TBXZQDMDIC d where t.countyNum=d.code) as countyName,"
				+ "(select e.PROLEVEL from TBLXJBDIC e where t.prjApprovalLevelNum=e.code) as prjApprovalLevelName,"
				+ "(select f.NATURE from TBPRJPROPERTYDIC f where t.prjPropertyNum=f.code) as prjPropertyName,"
				+ "(select g.ENGINEERUSE from TBPRJFUNCTIONDIC g where t.prjFunctionNum=g.code) as prjFunctionName"
				+ " from TBProjectInfo_S t where t.PRJNUM = '" + prjName + "'";
		ProjectModel project = new ProjectModel();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				project.setPrjId(rs.getString("prjId"));// 主键
				project.setPrjNum(rs.getString("prjNum"));// 项目编号
				project.setPrjName(rs.getString("prjName"));// 项目名称
				project.setPrjTypeName(rs.getString("prjTypeName"));// 项目分类
				project.setPrjTypeNum(rs.getString("prjTypeNum"));// 项目分类
				project.setBuildCorpName(rs.getString("buildCorpName"));// 建设单位名称
				project.setBuildCorpCode(rs.getString("buildCorpCode"));// 建设单位组织机构代码证
				project.setProvinceName(rs.getString("provinceName"));// 项目所在省
				project.setProvinceNum(rs.getString("provinceNum"));// 项目所在省
				project.setCityName(rs.getString("cityName"));// 项目所在市
				project.setCityNum(rs.getString("cityNum"));// 项目所在市
				project.setCountyName(rs.getString("countyName"));// 项目所在区
				project.setCountyNum(rs.getString("countyNum"));// 项目所在区
				project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// 立项文号
				project.setPrjApprovalLevelName(rs// 立项级别
						.getString("prjApprovalLevelName"));
				project.setPrjApprovalLevelNum(rs// 立项级别
						.getString("prjApprovalLevelNum"));
				project.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
				project.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
				project.setAllInvest(rs.getString("allInvest"));// 总投资
				project.setAllArea(rs.getString("allArea"));// 总面积
				project.setPrjSize(rs.getString("prjSize"));// 建设规模
				project.setPrjPropertyName(rs.getString("prjPropertyName"));// 建设性质
				project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// 建设性质
				project.setPrjFunctionName(rs.getString("prjFunctionName"));// 工程用途
				project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// 工程用途
				project.setBeginDate(rs.getDate("bDate"));// 开始时间
				project.setEndDate(rs.getDate("eDate"));// 结束时间
				project.setCreateDate(rs.getDate("createDate"));// 记录登记时间
				project.setAppDept(rs.getString("appDept"));// 获取计算PrjNum的值
				project.setBuldPlanNum(rs.getString("BULDPLANNUM"));//建设用地规划许可证编号
				project.setProjectPlanNum(rs.getString("PROJECTPLANNUM"));//建设工程规划许可证编号
				project.setBeginDate(rs.getDate("BDATE"));//实际开工日期；竣工备案环节为M
				project.setEndDate(rs.getDate("EDATE"));//实际竣工验收日期；竣工备案环节为M
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return project;
	}

	@Override
	public Page queryPlanInfo(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Plan plan = new Plan();
					plan.setCensorId(rs.getString("censorId"));// 主键
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

	@Override
	public Page queryFilingInfo(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Filing filing = new Filing();
					filing.setRecordId(rs.getString("recordId"));// 主键
					filing.setRecordNum(rs.getString("recordNum"));// 合同备案编号
					filing.setPrjNum(rs.getString("prjNum"));// 项目编号
					filing.setPrjName(rs.getString("prjName"));// 项目名称
					filing.setContractNum(rs.getString("contractNum"));// 合同编号
					filing.setContractTypeNum(rs.getString("contractTypeNum"));// 合同类别(TBCONTRACTTYPEDIC)
					filing.setContractTypeName(rs.getString("contractTypeName"));// 合同类别名称
					filing.setContractMoney(rs.getString("contractMoney"));// 合同金额(万元)
					filing.setPrjSize(rs.getString("prjSize"));// 建设规模
					filing.setContractDate(rs.getDate("contractDate"));// 合同签订日期
					filing.setPropietorCorpName(rs
							.getString("propietorCorpName"));// 发包单位名称
					filing.setPropietorCorpCode(rs
							.getString("propietorCorpCode"));// 发包单位住组织代码
					filing.setContractorCorpName(rs
							.getString("contractorCorpName"));// 承包单位名称
					filing.setContractorCorpCode(rs
							.getString("contractorCorpCode"));// 承包单位组织代码
					filing.setUnionCorpName(rs.getString("unionCorpName"));// 联合体承包单位名称
					filing.setUnionCorpCode(rs.getString("unionCorpCode"));// 联合体承包单位组织代码
					filing.setCreateDate(rs.getDate("createDate"));// 记录登记时间
					filing.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
					filing.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
					filing.setAppSteffId(rs.getString("appSteffId"));// 审批人id
					filing.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
					filing.setAppDate(rs.getDate("appDate"));// 审批时间
					filing.setAppOpinion(rs.getString("appOpinion"));// 审批意见
					page.getData().add(filing);
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

	@Override
	public Page queryPermitInfo(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Permit permit = new Permit();
					permit.setPermitId(rs.getString("permitId"));// 主键
					permit.setPrjNum(rs.getString("prjNum"));// 项目编号
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

	@Override
	public Page queryReadyInfo(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Ready complete = new Ready();
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

	@Override
	public List<Filing> queryFilingList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from v_tbcontractrecordmanage where prjNum='"
				+ prjNum + "'";
		List<Filing> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Filing filing = new Filing();
				filing.setRecordId(rs.getString("recordId"));// 主键
				filing.setRecordNum(rs.getString("recordNum"));// 合同备案编号
				filing.setPrjNum(rs.getString("prjNum"));// 项目编号
				filing.setPrjName(rs.getString("prjName"));// 项目名称
				filing.setContractNum(rs.getString("contractNum"));// 合同编号
				filing.setContractTypeNum(rs.getString("contractTypeNum"));// 合同类别(TBCONTRACTTYPEDIC)
				filing.setContractTypeName(rs.getString("contractTypeName"));// 合同类别名称
				filing.setContractMoney(rs.getString("contractMoney"));// 合同金额(万元)
				filing.setPrjSize(rs.getString("prjSize"));// 建设规模
				filing.setContractDate(rs.getDate("contractDate"));// 合同签订日期
				filing.setPropietorCorpName(rs.getString("propietorCorpName"));// 发包单位名称
				filing.setPropietorCorpCode(rs.getString("propietorCorpCode"));// 发包单位住组织代码
				filing.setContractorCorpName(rs.getString("contractorCorpName"));// 承包单位名称
				filing.setContractorCorpCode(rs.getString("contractorCorpCode"));// 承包单位组织代码
				filing.setUnionCorpName(rs.getString("unionCorpName"));// 联合体承包单位名称
				filing.setUnionCorpCode(rs.getString("unionCorpCode"));// 联合体承包单位组织代码
				filing.setCreateDate(rs.getDate("createDate"));// 记录登记时间
				filing.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				filing.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				filing.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				filing.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				filing.setAppDate(rs.getDate("appDate"));// 审批时间
				filing.setAppOpinion(rs.getString("appOpinion"));// 审批意见
				list.add(filing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Permit> queryPermitList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from tbbuilderlicencemanage where prjNum='"
				+ prjNum + "'";
		List<Permit> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Permit permit = new Permit();
				permit.setPermitId(rs.getString("permitId"));// 主键
				permit.setPrjNum(rs.getString("prjNum"));// 项目编号
				permit.setPrjId(rs.getString("prjId"));
				permit.setPrjName(rs.getString("prjName"));// 项目名称
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// 施工许可证编号
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
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum").trim());// 项目经理证件类型(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));// 项目经理证件号码
				permit.setSupervisionName(rs.getString("supervisionName"));// 总监理工程师姓名
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum").trim());// 总监理工程师证件类型(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));// 总监理工程师号码
//				permit.setUserName(rs.getString("userName"));// 安全生产管理人员姓名
//				permit.setIdCardTypeNum(rs.getString("IDCARDTYPENUM").trim());// 安全生产管理证件类型(TBIDCARDTYPEDIC)
//				permit.setIdCard(rs.getString("idCard"));// 安全生产管理人员证件号
//				permit.setCertId(rs.getString("certId"));// 安全生产考核合格证书编号
//				permit.setUserType(rs.getString("userType").trim());// 安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
				permit.setCreateDate(rs.getDate("createDate"));// 记录登记日期
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				permit.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				permit.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				permit.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				permit.setAppDate(rs.getDate("appDate"));// 审批时间
				permit.setAppOpinion(rs.getString("appOpinion"));// 审批意见
				list.add(permit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Plan> queryPlanList(String prjID) {
		// TODO Auto-generated method stub
		String sql = "select * from TBPROJECTCENSORINFO where prjID = '"
				+ prjID + "'";
		List<Plan> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Plan plan = new Plan();
				plan.setCensorId(rs.getString("censorId"));// 主键
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
				plan.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));// 一次审查时违反强条数
				plan.setOneCensorWfqtContent(rs
						.getString("oneCensorWfqtContent"));// 一次审查时违反的强条条目
//				plan.setCreateDate(rs.getDate("createDate"));// 记录登记日期
//				plan.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
//				plan.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
//				plan.setAppSteffId(rs.getString("appSteffId"));// 审批人id
//				plan.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
//				plan.setAppDate(rs.getDate("appDate"));// 审批时间
//				plan.setAppOpinion(rs.getString("appOpinion"));// 审批意见
				list.add(plan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Ready> queryReadyList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TBPROJECTFINISHMANAGE where prjNum='"
				+ prjNum + "'";
		List<Ready> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Ready complete = new Ready();
				complete.setCompleteId(rs.getString("completeId"));// 主键
				complete.setPrjNum(rs.getString("prjNum"));// 项目编号
				complete.setPrjId(rs.getString("prjId"));
				complete.setPrjName(rs.getString("prjName"));// 项目名称
				complete.setPrjFinishNum(rs.getString("PRJFINISHNUM"));
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// 施工许可证编号
				complete.setQcCorpName(rs.getString("qcCorpName"));
				complete.setQcCorpCode(rs.getString("qcCorpCode"));
				complete.setFactCost(rs.getString("factCost"));
				complete.setFactArea(rs.getString("factArea"));
				complete.setFactSize(rs.getString("factSize"));
				complete.setPrjStructureTypeNum(rs
						.getString("prjStructureTypeNum"));
				complete.setBDate(rs.getDate("bDate"));
				complete.setEDate(rs.getDate("eDate"));
				complete.setCreateDate(rs.getDate("createDate"));// 记录登记日期
				complete.setMark(rs.getString("mark"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				complete.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				complete.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				complete.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				complete.setAppDate(rs.getDate("appDate"));// 审批时间
				complete.setAppOpinion(rs.getString("appOpinion"));
				list.add(complete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Tender> queryTenderList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from V_TBTENDERINFO where prjNum = '" + prjNum
				+ "'";
		List<Tender> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Tender tenderInfo = new Tender();
				tenderInfo.setTenderNum(rs.getString("tenderNum"));// 中标通知书编号
				tenderInfo.setPrjNum(rs.getString("prjNum"));// 项目编号
				tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));// 招标类型(TBTENDERCLASSDIC)
				tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
				tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));// 招标方式(TBTENDERTYPEDIC)
				tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
				tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));// 中标日期
				tenderInfo.setTenderMoney(rs.getString("tenderMoney"));// 中标金额
				tenderInfo.setPrjSize(rs.getString("prjSize"));// 建设规模
				tenderInfo.setArea(rs.getString("area"));// 面积(平方米)
				tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));// 招标代理单位名称
				tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));// 招标代理单位组织机构代码
				tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));// 中标单位名称
				tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));// 中标单位组织机构代码
				tenderInfo.setConstructorName(rs.getString("constructorName"));// 项目经理/总监理工程师姓名
				tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));// 项目经理/总监理工程师证件类型
				tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
				tenderInfo.setConstructorIdCard(rs
						.getString("constructorIdCard"));// 项目经理/总监理工程师证件号码
				tenderInfo.setCreateDate(rs.getDate("createDate"));
				list.add(tenderInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Filing queryFilingInfo(String filingId) {
		// TODO Auto-generated method stub
		Filing filing = new Filing();
		String sql = "select * from v_tbcontractrecordmanage where recordId = '"
				+ filingId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				filing.setRecordId(rs.getString("recordId"));// 主键
				filing.setRecordNum(rs.getString("recordNum"));// 合同备案编号
				filing.setPrjNum(rs.getString("prjNum"));// 项目编号
				filing.setPrjName(rs.getString("prjName"));// 项目名称
				filing.setContractNum(rs.getString("contractNum"));// 合同编号
				filing.setContractTypeNum(rs.getString("contractTypeNum"));// 合同类别(TBCONTRACTTYPEDIC)
				filing.setContractTypeName(rs.getString("contractTypeName"));// 合同类别名称
				filing.setContractMoney(rs.getString("contractMoney"));// 合同金额(万元)
				filing.setPrjSize(rs.getString("prjSize"));// 建设规模
				filing.setContractDate(rs.getDate("contractDate"));// 合同签订日期
				filing.setPropietorCorpName(rs.getString("propietorCorpName"));// 发包单位名称
				filing.setPropietorCorpCode(rs.getString("propietorCorpCode"));// 发包单位住组织代码
				filing.setContractorCorpName(rs.getString("contractorCorpName"));// 承包单位名称
				filing.setContractorCorpCode(rs.getString("contractorCorpCode"));// 承包单位组织代码
				filing.setUnionCorpName(rs.getString("unionCorpName"));// 联合体承包单位名称
				filing.setUnionCorpCode(rs.getString("unionCorpCode"));// 联合体承包单位组织代码
				filing.setCreateDate(rs.getDate("createDate"));// 记录登记时间
				filing.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				filing.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				filing.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				filing.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				filing.setAppDate(rs.getDate("appDate"));// 审批时间
				filing.setAppOpinion(rs.getString("appOpinion"));// 审批意见
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return filing;
	}

	@Override
	public Permit queryPermitInfo(String permitId) {
		// TODO Auto-generated method stub
		Permit permit = new Permit();
		try {

			String qsql = "select * from tbbuilderlicencemanage where permitId=?";
			// 获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitId);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				permit.setPermitId(rs.getString("permitId"));// 主键
				permit.setPrjNum(rs.getString("prjNum"));// 项目编号
				permit.setPrjName(rs.getString("prjName"));// 项目名称
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// 施工许可证编号
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
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum").trim());// 项目经理证件类型(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));// 项目经理证件号码
				permit.setSupervisionName(rs.getString("supervisionName"));// 总监理工程师姓名
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum").trim());// 总监理工程师证件类型(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));// 总监理工程师号码
				permit.setUserName(rs.getString("userName"));// 安全生产管理人员姓名
				permit.setIdCardTypeNum(rs.getString("idCardTypeNum").trim());// 安全生产管理证件类型(TBIDCARDTYPEDIC)
				permit.setIdCard(rs.getString("idCard"));// 安全生产管理人员证件号
				permit.setCertId(rs.getString("certId"));// 安全生产考核合格证书编号
				permit.setUserType(rs.getString("userType").trim());// 安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
				permit.setCreateDate(rs.getDate("createDate"));// 记录登记日期
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				permit.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				permit.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				permit.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				permit.setAppDate(rs.getDate("appDate"));// 审批时间
				permit.setAppOpinion(rs.getString("appOpinion"));// 审批意见
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return permit;
	}

	@Override
	public Plan queryPlanInfo(String planId) {
		// TODO Auto-generated method stub
		Plan plan = new Plan();
		String sql = "select * from TBPROJECTCENSORINFO where censorId = '"
				+ planId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				plan.setCensorId(rs.getString("censorId"));// 主键
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
				plan.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));// 一次审查时违反强条数
				plan.setOneCensorWfqtContent(rs
						.getString("oneCensorWfqtContent"));// 一次审查时违反的强条条目
				plan.setCreateDate(rs.getDate("createDate"));// 记录登记日期
				plan.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				plan.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				plan.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				plan.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				plan.setAppDate(rs.getDate("appDate"));// 审批时间
				plan.setAppOpinion(rs.getString("appOpinion"));// 审批意见
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return plan;
	}

	@Override
	public Ready queryReadyInfo(String readyId) {
		// TODO Auto-generated method stub
		Ready complete = new Ready();
		try {
			String qsql = "select * from TBPROJECTFINISHMANAGE where completeId=?";
			// 获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, readyId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				complete.setCompleteId(rs.getString("completeId"));// 主键
				complete.setPrjNum(rs.getString("prjNum"));// 项目编号
				complete.setPrjName(rs.getString("prjName"));// 项目名称
				complete.setPrjFinishNum(rs.getString("PRJFINISHNUM"));
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// 施工许可证编号
				complete.setQcCorpName(rs.getString("qcCorpName"));
				complete.setQcCorpCode(rs.getString("qcCorpCode"));
				complete.setFactCost(rs.getString("factCost"));
				complete.setFactArea(rs.getString("factArea"));
				complete.setFactSize(rs.getString("factSize"));
				complete.setPrjStructureTypeNum(rs
						.getString("prjStructureTypeNum"));
				complete.setBDate(rs.getDate("bDate"));
				complete.setEDate(rs.getDate("eDate"));
				complete.setCreateDate(rs.getDate("createDate"));// 记录登记日期
				complete.setMark(rs.getString("mark"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				complete.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				complete.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				complete.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				complete.setAppDate(rs.getDate("appDate"));// 审批时间
				complete.setAppOpinion(rs.getString("appOpinion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return complete;
	}

	@Override
	public Tender queryTenderInfo(String tenderId) {
		// TODO Auto-generated method stub
		Tender tenderInfo = new Tender();
		try {

			String qsql = "select * from V_TBTENDERINFO where tenderId=?";
			// 获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, tenderId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				tenderInfo.setTenderId(rs.getString("tenderId"));// 主键
				tenderInfo.setTenderNum(rs.getString("tenderNum"));// 中标通知书编号
				tenderInfo.setPrjNum(rs.getString("prjNum"));// 项目编号
				tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));// 招标类型(TBTENDERCLASSDIC)
				tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
				tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));// 招标方式(TBTENDERTYPEDIC)
				tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
				tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));// 中标日期
				tenderInfo.setTenderMoney(rs.getString("tenderMoney"));// 中标金额
				tenderInfo.setPrjSize(rs.getString("prjSize"));// 建设规模
				tenderInfo.setArea(rs.getString("area"));// 面积(平方米)
				tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));// 招标代理单位名称
				tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));// 招标代理单位组织机构代码
				tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));// 中标单位名称
				tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));// 中标单位组织机构代码
				tenderInfo.setConstructorName(rs.getString("constructorName"));// 项目经理/总监理工程师姓名
				tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));// 项目经理/总监理工程师证件类型
				tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
				tenderInfo.setConstructorIdCard(rs
						.getString("constructorIdCard"));// 项目经理/总监理工程师证件号码
				tenderInfo.setCreateDate(rs.getDate("createDate"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return tenderInfo;
	}

	@Override
	public List<Quality> queryQualityList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_QUALITYSUPERVISION where prjNum = '"
				+ prjNum + "'";
		List<Quality> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
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
				quality.setQualityNum(rs.getString("qualityNum"));
				quality.setSectionName(rs.getString("sectionName"));
				quality.setTenderNum(rs.getString("tenderNum"));
				list.add(quality);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Quality queryQualityInfo(String qualityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Safety> querySafetyList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_SAFETYSUPERVISION where prjNum = '"
				+ prjNum + "'";
		List<Safety> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Safety quality = new Safety();
				quality.setSafetyId(rs.getString("SAFETYID"));// 主键
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
				// quality.setOversightNum(rs.getString("oversightNum"));//安全监督登记编号
				quality.setProjectName(rs.getString("projectName"));// 工程名称
				quality.setProjectAddress(rs.getString("projectAddress"));// 工程地点
				quality.setProStartDate(rs.getDate("proStartDate"));// 合同开工日期
				quality.setProEndDate(rs.getDate("proEndDate"));// 合同竣工日期
				quality.setProjectType(rs.getString("projectType"));// 工程类型
				quality.setSafetyTarget(rs.getString("safetyTarget"));// 安全生产标准化创建目标
				if (rs.getString("newlyBuild") != null) {
					quality.setNewlyBuild(rs.getString("newlyBuild").trim());// 新建
				} else {
					quality.setNewlyBuild(rs.getString("newlyBuild"));// 新建
				}
				if (rs.getString("extend") != null) {
					quality.setExtend(rs.getString("extend").trim());// 改扩建
				} else {
					quality.setExtend(rs.getString("extend"));// 改扩建
				}
				if (rs.getString("other") != null) {
					quality.setOther(rs.getString("other").trim());// 其它
				} else {
					quality.setOther(rs.getString("other"));// 其它
				}
				quality.setPolicingName(rs.getString("policingName"));// 勘察单位全称
				quality.setPolicingStaff(rs.getString("policingStaff"));// 勘察单位项目负责人
				quality.setDesignName(rs.getString("designName"));// 设计单位全称
				quality.setDesignStaff(rs.getString("designStaff"));// 设计单位项目负责人
				quality.setBuildingName(rs.getString("buildingName"));// 建设单位全称
				quality.setBuildingStaff(rs.getString("buildingStaff"));// 建设单位项目负责人
				quality.setBuildingPhone(rs.getString("buildingPhone"));// 建设单位联系电话
				quality.setSupervisionName(rs.getString("supervisionName"));// 监理单位全称
				quality.setSupervisionStaff(rs.getString("supervisionStaff"));// 监理单位项目总监姓名
				quality.setSupervisionNum(rs.getString("supervisionNum"));// 监理单位项目总监注册证书号
				quality.setSupervisionPhone(rs.getString("supervisionPhone"));// 监理单位项目总监联系电话
				quality.setProbationStaff(rs.getString("probationStaff"));// 监理单位安全监督姓名
				quality.setProbationPhone(rs.getString("probationPhone"));// 监理单位安全监督联系电话
				quality.setProbationNum(rs.getString("probationNum"));// 监理单位安全监督注册证书号
				quality.setProbationSafeNum(rs.getString("probationSafeNum"));// 监理单位安全监督安全监理证号
				quality.setContractName(rs.getString("contractName"));// 施工总承包单位全称
				quality.setContractAdmin(rs.getString("contractAdmin"));// 施工总承包单位公司安全管理
				quality.setContractPhone(rs.getString("contractPhone"));// 施工总承包单位联系电话
				quality.setContractStaff(rs.getString("contractStaff"));// 施工总承包单位负责人
				quality.setContractSafeNum(rs.getString("contractSafeNum"));// 施工总承包单位安全考核证号
				quality.setContractProStaff(rs.getString("contractProStaff"));// 施工总承包单位项目负责人姓名
				quality.setContractProStaffPhone(rs
						.getString("contractProStaffPhone"));// 施工总承包单位项目负责人联系电话
				quality.setContractStaffRegNum(rs
						.getString("contractStaffRegNum"));// 施工总承包单位项目负责人注册证号
				quality.setContractStaffNum(rs.getString("contractStaffNum"));// 施工总承包单位项目负责人安全考核证号
				// quality.setSingleNum(rs.getString("singleNum"));//单位工程编号
				quality.setUnitProject(rs.getString("unitProject"));// 单位工程
				quality.setScale(rs.getString("scale"));// 建筑规模
				quality.setCost(rs.getString("cost"));// 工程造价
				quality.setStructure(rs.getString("structure"));// 结构/层次
				quality.setHeight(rs.getString("height"));// 建筑高度
				quality.setSafetyNum(rs.getString("safetyNum"));
				list.add(quality);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Safety querySafetyInfo(String safetyId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 招投标详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public TenderInfo queryTenderById(String tenderNum)
	{
		TenderInfo tenderInfo = new TenderInfo();
		try {
			
			String qsql = "select * from V_TBTENDERINFO where tenderNum=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, tenderNum);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				tenderInfo.setTenderNum(rs.getString("tenderNum"));//中标通知书编号
				tenderInfo.setPrjNum(rs.getString("prjNum"));//项目编号
				tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));//招标类型(TBTENDERCLASSDIC)
				tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
				tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));//招标方式(TBTENDERTYPEDIC)
				tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
				tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));//中标日期
				tenderInfo.setTenderMoney(rs.getString("tenderMoney"));//中标金额
				tenderInfo.setPrjSize(rs.getString("prjSize"));//建设规模
				tenderInfo.setArea(rs.getString("area"));//面积(平方米)
				tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));//招标代理单位名称
				tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));//招标代理单位组织机构代码
				tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));//中标单位名称
				tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));//中标单位组织机构代码
				tenderInfo.setConstructorName(rs.getString("constructorName"));//项目经理/总监理工程师姓名
				tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));//项目经理/总监理工程师证件类型
				tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
				tenderInfo.setConstructorIdCard(rs.getString("constructorIdCard"));//项目经理/总监理工程师证件号码
				tenderInfo.setCreateDate(rs.getDate("createDate"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return tenderInfo;
	}
	
	/**
	 *合同备案详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public ContractFiling queryFilingById(String recordId)
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
				contractFiling.setSectionName(rs.getString("sectionName"));
				contractFiling.setTenderNum(rs.getString("tenderNum"));
				contractFiling.setProjectAddress(rs.getString("projectAddress"));
				contractFiling.setProjectCost(rs.getString("projectCost"));
				contractFiling.setArea(rs.getString("area"));
				contractFiling.setConstructorName(rs.getString("constructorName"));//项目经理姓名
				contractFiling.setTitleLeve(rs.getString("titleLeve"));//资质等级
				contractFiling.setPhone(rs.getString("phone"));//联系电话
				contractFiling.setQualificationsType(rs.getString("qualificationsType"));
				contractFiling.setQualificationsTypeName(rs.getString("qualificationsTypeName"));
				contractFiling.setSpecialtyType(rs.getString("specialtyType"));
				contractFiling.setSpecialtyTypeName(rs.getString("specialtyTypeName"));
				contractFiling.setRating(rs.getString("rating"));
				contractFiling.setRatingName(rs.getString("ratingName"));
				contractFiling.setContrType(rs.getString("contrType"));
				
				//-------------------------------人员-----------------------------------	
				contractFiling.setTechnicalName(rs.getString("technicalName"));//技术负责人姓名
				contractFiling.setTechnicalIdCardTypeNum(rs.getString("technicalIdCardTypeNum"));//技术负责人证件类型
				contractFiling.setTechnicalIdCard(rs.getString("technicalIdCard"));//技术负责人证件号码
				contractFiling.setTechnicalCertNum(rs.getString("technicalCertNum"));//技术负责人证书号
				contractFiling.setQualityName(rs.getString("qualityName"));//质量检查员姓名
				contractFiling.setQualityIdCardTypeNum(rs.getString("qualityIdCardTypeNum"));//质量检查员证件类型
				contractFiling.setQualityIdCard(rs.getString("qualityIdCard"));//质量检查员证件号码
				contractFiling.setQualityCertNum(rs.getString("qualityCertNum"));//质量检查员证书号
				contractFiling.setSecurityName(rs.getString("securityName"));//安全员姓名
				contractFiling.setSecurityIdCardTypeNum(rs.getString("securityIdCardTypeNum"));//安全员证件类型
				contractFiling.setSecurityIdCard(rs.getString("securityIdCard"));//安全员证件号码
				contractFiling.setSecurityCertNum(rs.getString("securityCertNum"));//安全员证书号
				contractFiling.setConstructionName(rs.getString("constructionName"));//施工员（工长）姓名
				contractFiling.setConstructionIdCardTypeNum(rs.getString("constructionIdCardTypeNum"));//施工员（工长）证件类型
				contractFiling.setConstructionIdCard(rs.getString("constructionIdCard"));//施工员（工长）证件号码
				contractFiling.setConstructionCertNum(rs.getString("constructionCertNum"));//施工员（工长）证书号
				contractFiling.setDirectorName(rs.getString("directorName"));//（监理人员）总监姓名
				contractFiling.setDirectorIdCardTypeNum(rs.getString("directorIdCardTypeNum"));//（监理人员）总监证件类型
				contractFiling.setDirectorIdCard(rs.getString("directorIdCard"));//（监理人员）总监证件号码
				contractFiling.setDirectorCertNum(rs.getString("directorCertNum"));//（监理人员）总监证书号
				contractFiling.setRepresEntativeName(rs.getString("represEntativeName"));//总监代表姓名
				contractFiling.setRepresEntativeIdCardTypeNum(rs.getString("represEntativeIdCardTypeNum"));//总监代表证件类型
				contractFiling.setRepresEntativeIdCard(rs.getString("represEntativeIdCard"));//总监代表证件号码
				contractFiling.setRepresEntativeCertNum(rs.getString("represEntativeCertNum"));//总监代表证书号
				contractFiling.setSafetyName(rs.getString("safetyName"));//安全监理姓名
				contractFiling.setSafetyIdCardTypeNum(rs.getString("safetyIdCardTypeNum"));//安全监理证件类型
				contractFiling.setSafetyIdCard(rs.getString("safetyIdCard"));//安全监理证件号码
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return contractFiling;
	}
	
	/**
	 *质量详细
	 * 
	 * @param tenderId
	 * @return
	 */
	public Quality queryQualityById(String qualityId)
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}
	
	/**
	 * 查询安全详细页面
	 * @return
	 */
	public Safety querySafetyById(String safetyId)
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
				//quality.setOversightNum(rs.getString("oversightNum"));//安全监督登记编号
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
	
	/**
	 * 查询施工许可详细页面
	 * @return
	 */
	public Permit queryPermitById(String permitId)
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
				
				permit.setPermitId(rs.getString("permitId"));//主键
				permit.setPrjNum(rs.getString("prjNum"));//项目编号
				permit.setPrjId(rs.getString("prjId"));
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
				permit.setTenderNum(rs.getString("tenderNum"));
				permit.setSectionName(rs.getString("sectionName"));
				permit.setQualityNum(rs.getString("qualityNum"));
				permit.setSafetyNum(rs.getString("safetyNum"));
				permit.setStarDate(rs.getDate("starDate"));
				permit.setEndDate(rs.getDate("endDate"));
				permit.setTimeLimit(rs.getString("timeLimit"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return permit;
	}
	
	/**
	 * 查询竣工验收详细页面
	 * @return
	 */
	public Complete queryCompleteById(String completeId)
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
				complete.setCompleteId(rs.getString("completeId"));//主键
				complete.setPrjNum(rs.getString("prjNum"));//项目编号
				complete.setPrjId(rs.getString("prjId"));
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
				complete.setMark(rs.getString("mark"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				complete.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
				complete.setAppDept(rs.getString("appDept").trim());//审批单位id
				complete.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
				complete.setProjectName(rs.getString("projectName"));//工程名称
				complete.setPrjFinishNum(rs.getString("prjFinishNum"));
				complete.setTenderNum(rs.getString("tenderNum"));
				complete.setSectionName(rs.getString("sectionName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return complete;
	}

	
	/**
	 * 查询工程类型
	 */
	@Override
	public List<DictionaryClass> queryProjectTypes() {
		String sql = "select * from PROJECT_TYPE";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code").trim());
				dictionaryClass.setName(rs.getString("NAMES"));
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
}
