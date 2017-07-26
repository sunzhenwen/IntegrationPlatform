package com.tj.jst.outside.business.contractFiling.dao;

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
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.model.Certdetail;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.contractFiling.model.ProjcetTenderInfo;
import com.tj.jst.outside.business.credibility.model.CrediBillity;
import com.tj.jst.outside.business.credibility.model.CrediBillityGood;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 合同备案
 * @author hhc
 *
 */
public class ContractFilingDaoImpl extends BaseDao implements IContractFilingDao {

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
					contractFiling.setTenderNum(rs.getString("tenderNum"));
					contractFiling.setSectionName(rs.getString("sectionName"));
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
	 * 合同备案申请
	 * @return
	 */
	public String add(ContractFiling contractFiling)
	{
		String recordId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into tbcontractrecordmanage(RECORDID,PRJNUM,PRJNAME,"
					+ "CONTRACTNUM,CONTRACTTYPENUM,CONTRACTMONEY,PRJSIZE,CONTRACTDATE,"
					+ "PROPIETORCORPNAME,PROPIETORCORPCODE,CONTRACTORCORPNAME,CONTRACTORCORPCODE,"
					+ "UNIONCORPNAME,UNIONCORPCODE,CREATEDATE,APPLYCORPCODE,APPLYCORPNAME,APPTYPE,"
					+ "PROCESSSTEPS,APPDEPT,APPDEPTNAME,recordNum,tenderNum,sectionName,"
					+ "projectAddress,projectCost,area,constructorName,titleLeve,phone,"
					+ "qualificationsType,qualificationsTypeName,specialtyType,"
					+ "specialtyTypeName,rating,ratingName,"
					+ "technicalName,"
					+ "technicalIdCardTypeNum,"
					+ "technicalIdCard,"
					+ "technicalCertNum,"
					+ "qualityName,"
					+ "qualityIdCardTypeNum,"
					+ "qualityIdCard,"
					+ "qualityCertNum,"
					+ "securityName,"
					+ "securityIdCardTypeNum,"
					+ "securityIdCard,"
					+ "seCurityCertNum,"
					+ "constructionName,"
					+ "constructionIdCardTypeNum,"
					+ "constructionIdCard,"
					+ "constructionCertNum,"
					+ "directorName,"
					+ "directorIdCardTypeNum,"
					+ "directorIdCard,"
					+ "directorCertNum,"
					+ "represEntativeName,"
					+ "represEntativeIdCardTypeNum,"
					+ "represEntativeIdCard,"
					+ "represEntativeCertNum,"
					+ "safetyName,"
					+ "safetyIdCardTypeNum,"
					+ "safetyIdCard) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,recordId);	//主键
			pstmt.setString(2,contractFiling.getPrjNum()); //项目编号
			pstmt.setString(3,contractFiling.getPrjName());//项目名称
			pstmt.setString(4,contractFiling.getContractNum()); //合同编号
			pstmt.setString(5,contractFiling.getContractTypeNum()); //合同类别(TBCONTRACTTYPEDIC)
			pstmt.setString(6,contractFiling.getContractMoney()); //合同金额(万元)
			pstmt.setString(7,contractFiling.getPrjSize()); //建设规模
			pstmt.setDate(8, contractFiling.getContractDate());; //合同签订日期
			pstmt.setString(9,contractFiling.getPropietorCorpName()); //发包单位名称
			pstmt.setString(10,contractFiling.getPropietorCorpCode()); //发包单位住组织代码
			pstmt.setString(11,contractFiling.getContractorCorpName()); //承包单位名称
			pstmt.setString(12,contractFiling.getContractorCorpCode()); //承包单位组织代码
			pstmt.setString(13,contractFiling.getUnionCorpName()); //联合体承包单位名称
			pstmt.setString(14,contractFiling.getUnionCorpCode()); //联合体承包单位组织代码
			pstmt.setDate(15, new Date(new java.util.Date().getTime()));//记录登记时间
			pstmt.setString(16,contractFiling.getApplyCorpCode());//申请企业组织机构代码
			pstmt.setString(17,contractFiling.getApplyCorpName());//申请企业名称
			/**
			 * 审批状态
			 * 0、申请，1、审批通过，2、审批未通过
			 */
			pstmt.setString(18,"0");//审批状态
			/**
			 * 流程步骤
			 * 1:项目报建
			 * 2:勘察阶段、设计阶段
			 * 3:合同备案、施工图审查备案
			 * 4:质量监督、安全监督
			 * 5:施工许可
			 * 6:竣工验收
			 */
			pstmt.setString(19,"3");
			pstmt.setString(20,contractFiling.getAppDept());//审批单位id
			pstmt.setString(21,contractFiling.getAppDeptName());//审批单位名称
			pstmt.setString(22, contractFiling.getRecordNum());//合同备案编号
			pstmt.setString(23, contractFiling.getTenderNum());//中标通知书编号
			pstmt.setString(24, contractFiling.getSectionName());//标段名称
			pstmt.setString(25, contractFiling.getProjectAddress());//工程地址
			pstmt.setString(26, contractFiling.getProjectCost());//工程造价
			pstmt.setString(27, contractFiling.getArea());//面积
			pstmt.setString(28, contractFiling.getConstructorName());//项目经理姓名
			pstmt.setString(29, contractFiling.getTitleLeve());//资质等级
			pstmt.setString(30, contractFiling.getPhone());//联系电话
			pstmt.setString(31, contractFiling.getQualificationsType());
			pstmt.setString(32, contractFiling.getQualificationsTypeName());
			pstmt.setString(33, contractFiling.getSpecialtyType());
			pstmt.setString(34, contractFiling.getSpecialtyTypeName());
			pstmt.setString(35, contractFiling.getRating());
			pstmt.setString(36, contractFiling.getRatingName());
			
			
			
			pstmt.setString(37, contractFiling.getTechnicalName());//技术负责人姓名
			pstmt.setString(38, contractFiling.getTechnicalIdCardTypeNum());//技术负责人证件类型
			pstmt.setString(39, contractFiling.getTechnicalIdCard());//技术负责人证件号码
			pstmt.setString(40, contractFiling.getTechnicalCertNum());//技术负责人证书号
			pstmt.setString(41, contractFiling.getQualityName());//质量检查员姓名
			pstmt.setString(42, contractFiling.getQualityIdCardTypeNum());//质量检查员证件类型
			pstmt.setString(43, contractFiling.getQualityIdCard());//质量检查员证件号码
			pstmt.setString(44, contractFiling.getQualityCertNum());//质量检查员证书号
			pstmt.setString(45, contractFiling.getSecurityName());//安全员姓名
			pstmt.setString(46, contractFiling.getSecurityIdCardTypeNum());//安全员证件类型
			pstmt.setString(47, contractFiling.getSecurityIdCard());//安全员证件号码
			pstmt.setString(48, contractFiling.getSecurityCertNum());//安全员证书号
			pstmt.setString(49, contractFiling.getConstructionName());//施工员（工长）姓名
			pstmt.setString(50, contractFiling.getConstructionIdCardTypeNum());//施工员（工长）证件类型
			pstmt.setString(51, contractFiling.getConstructionIdCard());//施工员（工长）证件号码
			pstmt.setString(52, contractFiling.getConstructionCertNum());//施工员（工长）证书号
			pstmt.setString(53, contractFiling.getDirectorName());//（监理人员）总监姓名
			pstmt.setString(54, contractFiling.getDirectorIdCardTypeNum());//（监理人员）总监证件类型
			pstmt.setString(55, contractFiling.getDirectorIdCard());//（监理人员）总监证件号码
			pstmt.setString(56, contractFiling.getDirectorCertNum());//（监理人员）总监证书号
			pstmt.setString(57, contractFiling.getRepresEntativeName());//总监代表姓名
			pstmt.setString(58, contractFiling.getRepresEntativeIdCardTypeNum());//总监代表证件类型
			pstmt.setString(59, contractFiling.getRepresEntativeIdCard());//总监代表证件号码
			pstmt.setString(60, contractFiling.getRepresEntativeCertNum());//总监代表证书号
			pstmt.setString(61, contractFiling.getSafetyName());//安全监理姓名
			pstmt.setString(62, contractFiling.getSafetyIdCardTypeNum());//安全监理证件类型
			pstmt.setString(63, contractFiling.getSafetyIdCard());//安全监理证件号码
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
		return recordId;
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId)
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
			
			String linkNum = "";
			
			if("100".equals(contractFiling.getContractTypeNum().trim()))
			{
				linkNum = "2";
			}
			if("200".equals(contractFiling.getContractTypeNum().trim()))
			{
				linkNum = "8";
			}
			if("400".equals(contractFiling.getContractTypeNum().trim()))
			{
				linkNum = "9";
			}
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=? order by num");
			pstmt.setString(1, linkNum);
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
				pstmt.setString(1,recordId);
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
			contractFiling.setAccessoryList(accessoryList);
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
		return contractFiling;
	}
	
	/**
	 * 合同备案申请修改
	 * @return
	 */
	public void modify(ContractFiling contractFiling)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update tbcontractrecordmanage set PRJNUM=?,PRJNAME=?,"
					+ "CONTRACTNUM=?,CONTRACTTYPENUM=?,CONTRACTMONEY=?,PRJSIZE=?,CONTRACTDATE=?,"
					+ "PROPIETORCORPNAME=?,PROPIETORCORPCODE=?,CONTRACTORCORPNAME=?,"
					+ "CONTRACTORCORPCODE=?,UNIONCORPNAME=?,UNIONCORPCODE=?,APPDEPT=?,"
					+ "APPDEPTNAME=?,tenderNum=?,sectionName=?,projectAddress=?,"
					+ "projectCost=?,area=?,constructorName=?,titleLeve=?,phone=?,"
					+ "qualificationsType=?,specialtyType=?,rating=?,"
					+ "qualificationsTypeName=?,specialtyTypeName=?,ratingName=?,"
					+ "technicalName=?,"
					+ "technicalIdCardTypeNum=?,"
					+ "technicalIdCard=?,"
					+ "technicalCertNum=?,"
					+ "qualityName=?,"
					+ "qualityIdCardTypeNum=?,"
					+ "qualityIdCard=?,"
					+ "qualityCertNum=?,"
					+ "securityName=?,"
					+ "securityIdCardTypeNum=?,"
					+ "securityIdCard=?,"
					+ "seCurityCertNum=?,"
					+ "constructionName=?,"
					+ "constructionIdCardTypeNum=?,"
					+ "constructionIdCard=?,"
					+ "constructionCertNum=?,"
					+ "directorName=?,"
					+ "directorIdCardTypeNum=?,"
					+ "directorIdCard=?,"
					+ "directorCertNum=?,"
					+ "represEntativeName=?,"
					+ "represEntativeIdCardTypeNum=?,"
					+ "represEntativeIdCard=?,"
					+ "represEntativeCertNum=?,"
					+ "safetyName=?,"
					+ "safetyIdCardTypeNum=?,"
					+ "safetyIdCard=?  "
					+ "where RECORDID=? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,contractFiling.getPrjNum()); //项目编号
			pstmt.setString(2,contractFiling.getPrjName());//项目名称
			pstmt.setString(3,contractFiling.getContractNum()); //合同编号
			pstmt.setString(4,contractFiling.getContractTypeNum()); //合同类别(TBCONTRACTTYPEDIC)
			pstmt.setString(5,contractFiling.getContractMoney()); //合同金额(万元)
			pstmt.setString(6,contractFiling.getPrjSize()); //建设规模
			pstmt.setDate(7, contractFiling.getContractDate());; //合同签订日期
			pstmt.setString(8,contractFiling.getPropietorCorpName()); //发包单位名称
			pstmt.setString(9,contractFiling.getPropietorCorpCode()); //发包单位住组织代码
			pstmt.setString(10,contractFiling.getContractorCorpName()); //承包单位名称
			pstmt.setString(11,contractFiling.getContractorCorpCode()); //承包单位组织代码
			pstmt.setString(12,contractFiling.getUnionCorpName()); //联合体承包单位名称
			pstmt.setString(13,contractFiling.getUnionCorpCode()); //联合体承包单位组织代码
			pstmt.setString(14,contractFiling.getAppDept());//审批单位id
			pstmt.setString(15,contractFiling.getAppDeptName());//审批单位名称
			pstmt.setString(16, contractFiling.getTenderNum());
			pstmt.setString(17, contractFiling.getSectionName());
			pstmt.setString(18, contractFiling.getProjectAddress());
			pstmt.setString(19, contractFiling.getProjectCost());
			pstmt.setString(20, contractFiling.getArea());//面积
			pstmt.setString(21, contractFiling.getConstructorName());//项目经理姓名
			pstmt.setString(22, contractFiling.getTitleLeve());//资质等级
			pstmt.setString(23, contractFiling.getPhone());//姓名
			pstmt.setString(24, contractFiling.getQualificationsType());
			pstmt.setString(25, contractFiling.getSpecialtyType());
			pstmt.setString(26, contractFiling.getRating());
			pstmt.setString(27, contractFiling.getQualificationsTypeName());
			pstmt.setString(28, contractFiling.getSpecialtyTypeName());
			pstmt.setString(29, contractFiling.getRatingName());
			
			pstmt.setString(30, contractFiling.getTechnicalName());//技术负责人姓名
			pstmt.setString(31, contractFiling.getTechnicalIdCardTypeNum());//技术负责人证件类型
			pstmt.setString(32, contractFiling.getTechnicalIdCard());//技术负责人证件号码
			pstmt.setString(33, contractFiling.getTechnicalCertNum());//技术负责人证书号
			pstmt.setString(34, contractFiling.getQualityName());//质量检查员姓名
			pstmt.setString(35, contractFiling.getQualityIdCardTypeNum());//质量检查员证件类型
			pstmt.setString(36, contractFiling.getQualityIdCard());//质量检查员证件号码
			pstmt.setString(37, contractFiling.getQualityCertNum());//质量检查员证书号
			pstmt.setString(38, contractFiling.getSecurityName());//安全员姓名
			pstmt.setString(39, contractFiling.getSecurityIdCardTypeNum());//安全员证件类型
			pstmt.setString(40, contractFiling.getSecurityIdCard());//安全员证件号码
			pstmt.setString(41, contractFiling.getSecurityCertNum());//安全员证书号
			pstmt.setString(42, contractFiling.getConstructionName());//施工员（工长）姓名
			pstmt.setString(43, contractFiling.getConstructionIdCardTypeNum());//施工员（工长）证件类型
			pstmt.setString(44, contractFiling.getConstructionIdCard());//施工员（工长）证件号码
			pstmt.setString(45, contractFiling.getConstructionCertNum());//施工员（工长）证书号
			pstmt.setString(46, contractFiling.getDirectorName());//（监理人员）总监姓名
			pstmt.setString(47, contractFiling.getDirectorIdCardTypeNum());//（监理人员）总监证件类型
			pstmt.setString(48, contractFiling.getDirectorIdCard());//（监理人员）总监证件号码
			pstmt.setString(49, contractFiling.getDirectorCertNum());//（监理人员）总监证书号
			pstmt.setString(50, contractFiling.getRepresEntativeName());//总监代表姓名
			pstmt.setString(51, contractFiling.getRepresEntativeIdCardTypeNum());//总监代表证件类型
			pstmt.setString(52, contractFiling.getRepresEntativeIdCard());//总监代表证件号码
			pstmt.setString(53, contractFiling.getRepresEntativeCertNum());//总监代表证书号
			pstmt.setString(54, contractFiling.getSafetyName());//安全监理姓名
			pstmt.setString(55, contractFiling.getSafetyIdCardTypeNum());//安全监理证件类型
			pstmt.setString(56, contractFiling.getSafetyIdCard());//安全监理证件号码
			
			pstmt.setString(57, contractFiling.getRecordId());//主键
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
	public void delete(String recordId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from tbcontractrecordmanage where recordId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recordId);//主键
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,recordId);	
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
			pstmt.setString(1,recordId);	
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
			ConnectionFactory.closeConn(conn, pstmt, rs);
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
	
	//合同类别
	public List<DictionaryClass> queryContractTypeNums()
	{
		String sql = "select * from TBCONTRACTTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("CONTRACTTYPE"));
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
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					Construction construction = new Construction();
					construction.setPrjId(rs.getString("prjId"));//主键
					construction.setPrjNum(rs.getString("prjNum"));//项目编号
					construction.setPrjName(rs.getString("prjName"));//项目名称
					construction.setCreateDate(rs.getDate("createDate"));
					construction.setAppDept(rs.getString("appDept"));//审批单位
					construction.setAppDeptName(rs.getString("appDeptName"));//审批单位名称
					construction.setPrjPropertyNum(rs.getString("prjPropertyNum"));//建设性质
					construction.setProjectManager(rs.getString("projectManager"));//建设单位负责人
					construction.setUnitPhone(rs.getString("unitPhone"));//建设单位联系电话
					construction.setBuildCorpName(rs.getString("buildCorpName"));//建设单位名称
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
	/**
	 * 查询勘察单位
	 * @param Condition
	 * @return
	 */
	public Page pagedkcQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					ContractFiling contractfiling = new ContractFiling();
					contractfiling.setRecordId(rs.getString("recordId"));//主键
					contractfiling.setContractorCorpName(rs.getString("contractorCorpName"));//勘察单位名称
					contractfiling.setConstructorName(rs.getString("constructorName"));//勘察单位项目负责人
					page.getData().add(contractfiling);
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
					construction.setTenderCorpCode(rs.getString("tenderCorpCode"));//承包单位组织代码
					construction.setTenderCorpName(rs.getString("tenderCorpName"));//承包单位名称
					construction.setTenderMoney(rs.getString("tenderMoney"));//中标金额
					construction.setUnionCorpName(rs.getString("unionCorpName")); //联合体承包单位名称(合同备案)
					construction.setUnionCorpCode(rs.getString("unionCorpCode")); //联合体承包单位组织代码(合同备案)
					construction.setCreatedate(rs.getDate("createdate"));
					construction.setProjectAddress(rs.getString("projectAddress"));//工程地址
					construction.setProjectCost(rs.getString("projectCost"));//工程造价
					construction.setArea(rs.getString("area"));//面积
					construction.setPropietorCorpName(rs.getString("propietorCorpName"));//发包单位名称
					construction.setPropietorCorpCode(rs.getString("propietorCorpCode")); //发包单位住组织代码
					construction.setConstructorName(rs.getString("constructorName"));//项目经理姓名
					//-------------------------------人员-----------------------------------	
					construction.setTechnicalName(rs.getString("technicalName"));//技术负责人姓名
					construction.setTechnicalIdCardTypeNum(rs.getString("technicalIdCardTypeNum"));//技术负责人证件类型
					construction.setTechnicalIdCard(rs.getString("technicalIdCard"));//技术负责人证件号码
					construction.setTechnicalCertNum(rs.getString("technicalCertNum"));//技术负责人证书号
					construction.setQualityName(rs.getString("qualityName"));//质量检查员姓名
					construction.setQualityIdCardTypeNum(rs.getString("qualityIdCardTypeNum"));//质量检查员证件类型
					construction.setQualityIdCard(rs.getString("qualityIdCard"));//质量检查员证件号码
					construction.setQualityCertNum(rs.getString("qualityCertNum"));//质量检查员证书号
					construction.setSecurityName(rs.getString("securityName"));//安全员姓名
					construction.setSecurityIdCardTypeNum(rs.getString("securityIdCardTypeNum"));//安全员证件类型
					construction.setSecurityIdCard(rs.getString("securityIdCard"));//安全员证件号码
					construction.setSecurityCertNum(rs.getString("securityCertNum"));//安全员证书号
					construction.setConstructionName(rs.getString("constructionName"));//施工员（工长）姓名
					construction.setConstructionIdCardTypeNum(rs.getString("constructionIdCardTypeNum"));//施工员（工长）证件类型
					construction.setConstructionIdCard(rs.getString("constructionIdCard"));//施工员（工长）证件号码
					construction.setConstructionCertNum(rs.getString("constructionCertNum"));//施工员（工长）证书号
					construction.setDirectorName(rs.getString("directorName"));//（监理人员）总监姓名
					construction.setDirectorIdCardTypeNum(rs.getString("directorIdCardTypeNum"));//（监理人员）总监证件类型
					construction.setDirectorIdCard(rs.getString("directorIdCard"));//（监理人员）总监证件号码
					construction.setDirectorCertNum(rs.getString("directorCertNum"));//（监理人员）总监证书号
					construction.setRepresEntativeName(rs.getString("represEntativeName"));//总监代表姓名
					construction.setRepresEntativeIdCardTypeNum(rs.getString("represEntativeIdCardTypeNum"));//总监代表证件类型
					construction.setRepresEntativeIdCard(rs.getString("represEntativeIdCard"));//总监代表证件号码
					construction.setRepresEntativeCertNum(rs.getString("represEntativeCertNum"));//总监代表证书号
					construction.setSafetyName(rs.getString("safetyName"));//安全监理姓名
					construction.setSafetyIdCardTypeNum(rs.getString("safetyIdCardTypeNum"));//安全监理证件类型
					construction.setSafetyIdCard(rs.getString("safetyIdCard"));//安全监理证件号码
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
	
	/**
	 * 查询企业资质
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuery(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					Certdetail cd = new Certdetail();
					cd.setCorpName(rs.getString("corpName"));
					cd.setCorpCode(rs.getString("corpCode"));
					cd.setQualificationsType(rs.getString("qualificationsType"));
					cd.setSpecialtyType(rs.getString("specialtyType"));
					cd.setRating(rs.getString("rating"));
					cd.setQualificationsTypeName(rs.getString("qualificationsTypeName"));//资质资格类型名称
					cd.setSpecialtyTypeName(rs.getString("specialtyTypeName"));//专业类别名称
					cd.setRatingName(rs.getString("ratingName"));//资质资格等级名称
					page.getData().add(cd);
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
	 * 查询企业备案信息
	 * @param ContractFiling
	 * @return List
	 */
	@Override
	public List<ContractFiling> queryByPrNum(String prjnum) {
		String sql = "select * from TBCONTRACTRECORDMANAGE WHERE prjnum=?";
		List<ContractFiling> list = new ArrayList<ContractFiling>();
		ContractFiling contractfiling = new ContractFiling();
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,prjnum);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				
				String rr=rs.getString("contractTypeNum").trim();	
				//勘察
				if(rr.equals("100")){
					//勘察
					contractfiling.setContractorCorpNameKC(rs.getString("contractorCorpName"));//勘察单位全称
					contractfiling.setConstructorNameKC(rs.getString("constructorName"));//勘察单位项目负责人
					contractfiling.setProjectAddress(rs.getString("projectAddress"));//工程地点
				}else if(rr.equals("200")){
					//设计
					contractfiling.setContractorCorpName(rs.getString("contractorCorpName"));//设计单位全称
					contractfiling.setConstructorName(rs.getString("constructorName"));//设计单位项目负责人
					//contractfiling.setPhone(rs.getString("phone"));

				}else if(rr.equals("400")){
					//监理
					contractfiling.setContractorCorpNameJL(rs.getString("contractorCorpName"));//单位全称
				     contractfiling.setDirectorName(rs.getString("directorName"));//项目总监姓名
				     contractfiling.setDirectorIdCard(rs.getString("directorIdCard"));//项目总监注册证书号
				     contractfiling.setPhoneJL(rs.getString("phone"));//项目总监联系电话
				     contractfiling.setSafetyName(rs.getString("safetyName"));//安全监理姓名
				     contractfiling.setSafetyIdCard(rs.getString("safetyIdCard"));//安全监理注册证书号
				     contractfiling.setSecurityName(rs.getString("securityName"));//安全员
				}else if(rr.equals("301")){
					//总承包
					contractfiling.setContractorCorpNameZCB(rs.getString("contractorCorpName"));//单位全称
					contractfiling.setConstructorNameZCB(rs.getString("constructorName"));//项目负责人姓名
					contractfiling.setPhoneZCB(rs.getString("phone"));//联系电话
				}else if(rr.equals("302")){
					//专业分包
					contractfiling.setContractorCorpNameFB(rs.getString("contractorCorpName"));//专业分包单位全称
					contractfiling.setConstructorNameFB(rs.getString("constructorName"));//专业分包项目负责人姓名
					contractfiling.setPhoneZFB(rs.getString("phone"));//专业分包联系电话
				}else if(rr.equals("302")){
					//施工劳务
					contractfiling.setContractorCorpNameLW(rs.getString("contractorCorpName"));//施工劳务单位全称
					contractfiling.setConstructorNameLW(rs.getString("constructorName"));//施工劳务项目负责人姓名
					contractfiling.setPhoneZLW(rs.getString("phone"));//施工劳务联系电话
					
				}
				

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			list.add(contractfiling);
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	/**
	 * 查询监理单位
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQueryjl(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					ContractFiling contractfiling = new ContractFiling();
					//监理
					 contractfiling.setContractorCorpName(rs.getString("contractorCorpName"));//单位全称
				     contractfiling.setDirectorName(rs.getString("directorName"));//项目总监姓名
				     contractfiling.setDirectorIdCard(rs.getString("directorIdCard"));//项目总监注册证书号
				     contractfiling.setPhoneJL(rs.getString("phone"));//项目总监联系电话
				     contractfiling.setSafetyName(rs.getString("safetyName"));//安全监理姓名
				     contractfiling.setSafetyIdCard(rs.getString("safetyIdCard"));//安全监理注册证书号
				     contractfiling.setSecurityName(rs.getString("securityName"));//安全员
				     contractfiling.setContractorCorpCode(rs.getString("contractorCorpCode"));//监理单位组织代码
					 page.getData().add(contractfiling);
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

	@Override
	public Page pagedTitleLeveQueryzb(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					ContractFiling contractfiling = new ContractFiling();
					//总承包
					contractfiling.setSectionName(rs.getString("sectionName"));//标段名称
					contractfiling.setProjectAddress(rs.getString("projectAddress"));//项目地址
					contractfiling.setContractorCorpNameZCB(rs.getString("contractorCorpName"));//单位全称
					contractfiling.setRecordNum(rs.getString("recordNum"));//合同备案编号 
					contractfiling.setContractStart(rs.getDate("contractStart"));//合同开工日期 
					contractfiling.setContractEnd(rs.getDate("contractEnd"));//合同竣工日期
					page.getData().add(contractfiling); 
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

	@Override
	public Page pagedTitleLeveQueryfb(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					ContractFiling contractfiling = new ContractFiling();
					//总承包
					contractfiling.setContractorCorpNameFB(rs.getString("contractorCorpName"));//单位全称
					contractfiling.setConstructorNameFB(rs.getString("constructorName"));//项目负责人姓名
					contractfiling.setPhoneZFB(rs.getString("phone"));//联系电话
					page.getData().add(contractfiling);
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

	@Override
	public Page pagedTitleLeveQuerylw(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					ContractFiling contractfiling = new ContractFiling();
					//总承包
					contractfiling.setContractorCorpNameLW(rs.getString("contractorCorpName"));//单位全称
					contractfiling.setConstructorNameLW(rs.getString("constructorName"));//项目负责人姓名
					contractfiling.setPhoneZLW(rs.getString("phone"));//联系电话
					page.getData().add(contractfiling);
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

	@Override
	public Page pagedTitleLeveQueryxmfz(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					ContractFiling contractfiling = new ContractFiling();
					//项目负责人信息
					contractfiling.setConstructorNameXMFZ(rs.getString("PERSONNAME"));//姓名
					contractfiling.setConstructorNameZSBH(rs.getString("CERTNUM"));//项目负责人证书编号
					contractfiling.setConstructorNameSFZ(rs.getString("IDCARD18"));//身份证号
					page.getData().add(contractfiling);
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

	@Override
	public Page pagedTitleLeveQueryzzry(Condition condition) {
		//Page page = super.basePagedQuery(condition);
		Page page = super.positionsPagedQuery(condition);//岗位人员
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
				
					ContractFiling contractfiling = new ContractFiling();
					//项目专职人员信息
					contractfiling.setConstructorNamezzry(rs.getString("FName"));//姓名
					contractfiling.setConstructorNamezzrygw(rs.getString("FCertNumber"));//专职安全人员岗位编号
					contractfiling.setConstructorNamezzrysf(rs.getString("FCardID"));//专职人员安全身份证号
					page.getData().add(contractfiling);
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
    //企业诚信查询
	@Override
	public Page pagedTitleLeveQueryQycred(Condition condition) {
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					CrediBillity credibillity = new CrediBillity();
					//总承包
					credibillity.setCorpbadcreditid(rs.getString("corpbadcreditid"));//主键
					credibillity.setCorpname(rs.getString("corpname"));//企业名称
					credibillity.setCorpcode(rs.getString("corpcode"));//组织机构代码
					credibillity.setCredittype(rs.getString("credittype"));//不良行为类别
					credibillity.setHappendate(rs.getDate("happendate"));//不良行为发生日期
					credibillity.setPrjnum(rs.getString("prjnum"));//项目编号
					credibillity.setPunishevidence(rs.getString("punishevidence"));//处罚依据
					credibillity.setPunishcontent(rs.getString("punishcontent"));//处罚决定内容
					credibillity.setPunishnumber(rs.getString("punishnumber"));//处罚决定文号
					credibillity.setPunishdate(rs.getDate("punishdate"));//处罚日期    
					credibillity.setPunishedate(rs.getDate("punishedate"));//处罚截止日期
					credibillity.setCerttypenum(rs.getString("certtypenum"));//企业类型
					credibillity.setPrjname(rs.getString("prjname"));//工程名称
					credibillity.setAddress(rs.getString("address"));//工程地址
					credibillity.setBuildcorpname(rs.getString("buildcorpname"));//建设单位
					credibillity.setBuildcorpcode(rs.getString("buildcorpcode"));//建设单位组织机构代码
					credibillity.setProvincenum(rs.getString("provincenum"));//不良行为发生所在省
					credibillity.setCitynum(rs.getString("citynum"));//不良行为发生所在地市
					credibillity.setCountynum(rs.getString("countynum"));//不良行为发生所在区县
					credibillity.setCreditclassnum(rs.getString("creditclassnum"));//不良行为分类
					credibillity.setContent(rs.getString("content"));//不良行为内容
					credibillity.setPunishdepartname(rs.getString("punishdepartname"));//处罚部门
					credibillity.setAuditdate(rs.getDate("auditdate"));//省审核时间（发布时须填写）
					credibillity.setAuditusername(rs.getString("auditusername"));//审核领导（发布时须填写）
					credibillity.setPublicedate(rs.getDate("publicedate"));//发布结束时间（发布时须填写）
					credibillity.setPublicbdate(rs.getDate("publicbdate"));//发布开始时间（发布时须填写）
					credibillity.setIspublic(rs.getString("ispublic"));//是否发布；0：未发布，1：已发布
					credibillity.setCREATEDATE(rs.getDate("cREATEDATE"));//登记日期
					credibillity.setUsername(rs.getString("username"));//登记人姓名
					credibillity.setPunishmoney(rs.getString("punishmoney"));//处罚金额
					credibillity.setPunishdeparttype(rs.getString("punishdeparttype"));//处罚部门级别；0：部级，1：省市，2：地市，3：区县
					credibillity.setDepartid(rs.getString("departid"));//登记部门id  
					credibillity.setDeltype(rs.getString("deltype"));//删除状态 0：未删除、1：已删除	
					credibillity.setDepartname(rs.getString("departname"));//登记部门
					page.getData().add(credibillity);
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

	@Override
	public Page pagedTitleLeveQueryQycredgood(Condition condition) {
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					CrediBillityGood crediBillitygood = new CrediBillityGood();
					//总承包
					crediBillitygood.setGoodcreditid(rs.getString("goodcreditid"));//主键
					crediBillitygood.setCorpname(rs.getString("corpname"));//企业名称
					crediBillitygood.setCorpcode(rs.getString("corpcode"));//组织机构代码
					crediBillitygood.setDepartname(rs.getString("departname"));//登记部门
					crediBillitygood.setUsername(rs.getString("username"));//登记人
					crediBillitygood.setCreatedate(rs.getDate("createdate"));//登记日期
					crediBillitygood.setProvincenum(rs.getString("provincenum"));//良好行为发生所在省(字典表：tbxzqdmdic)
					crediBillitygood.setPrjnum(rs.getString("prjnum"));//项目编号
					crediBillitygood.setAwarddepartname(rs.getString("awarddepartname"));//奖励部门
					crediBillitygood.setAwarddeparttype(rs.getString("awarddeparttype"));//奖励部门级别；0：部级，1：省市，2：地市，3：区县
					crediBillitygood.setAwardcontent(rs.getString("awardcontent"));//奖励决定内容--
					crediBillitygood.setAwardnumber(rs.getString("awardnumber"));//奖励决定文号
					crediBillitygood.setAwarddate(rs.getDate("awarddate"));//奖励日期
					crediBillitygood.setCitynum(rs.getString("citynum"));//良好行为发生所在地市(字典表：tbxzqdmdic)
					crediBillitygood.setCountynum(rs.getString("countynum"));//良好行为发生所在区县(字典表：tbxzqdmdic)
					crediBillitygood.setCerttypenum(rs.getString("certtypenum"));//企业类型
					crediBillitygood.setPrjname(rs.getString("prjname"));//工程名称
					crediBillitygood.setAddress(rs.getString("address"));//工程地址
					crediBillitygood.setBuildcorpname(rs.getString("buildcorpname"));//建设单位			
					crediBillitygood.setBuildcorpcode(rs.getString("buildcorpcode"));//	建设单位组织机构代码）
					crediBillitygood.setIspublic(rs.getString("ispublic"));//是否发布；0：未发布，1：已发布
					crediBillitygood.setPublicedate(rs.getDate("publicedate"));//发布结束时间（发布时须填写）
					crediBillitygood.setPublicbdate(rs.getDate("publicbdate"));//发布开始时间（发布时须填写）
					crediBillitygood.setAuditdate(rs.getDate("auditdate"));//审核时间（发布时须填写）
					crediBillitygood.setDepartid(rs.getString("departid"));//登记部门id
					crediBillitygood.setStatus(rs.getString("status"));//状态 0：可用 1：删除

					page.getData().add(crediBillitygood);
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

	
	
	@Override
	public CrediBillity querycred(String corpbadcreditid) {
		CrediBillity credibillity = new CrediBillity();
		try {
			
			String qsql = "select * from v_CrediBillity_qiye where corpbadcreditid=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, corpbadcreditid);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				//总承包
				    
				credibillity.setCorpbadcreditid(rs.getString("corpbadcreditid"));//主键
				credibillity.setCorpname(rs.getString("corpname"));//企业名称
				credibillity.setCorpcode(rs.getString("corpcode"));//组织机构代码
				credibillity.setCredittype(rs.getString("credittype"));//不良行为类别
				credibillity.setHappendate(rs.getDate("happendate"));//不良行为发生日期
				credibillity.setPrjnum(rs.getString("prjnum"));//项目编号
				credibillity.setPunishevidence(rs.getString("punishevidence"));//处罚依据
				credibillity.setPunishcontent(rs.getString("punishcontent"));//处罚决定内容
				credibillity.setPunishnumber(rs.getString("punishnumber"));//处罚决定文号
				credibillity.setPunishdate(rs.getDate("punishdate"));//处罚日期
				credibillity.setPunishedate(rs.getDate("punishedate"));//处罚截止日期
				credibillity.setCerttypenum(rs.getString("certtypenum"));//企业类型
				credibillity.setPrjname(rs.getString("prjname"));//工程名称
				credibillity.setAddress(rs.getString("address"));//工程地址
				credibillity.setBuildcorpname(rs.getString("buildcorpname"));//建设单位
				credibillity.setBuildcorpcode(rs.getString("buildcorpcode"));//建设单位组织机构代码
				credibillity.setProvincenum(rs.getString("provincenum"));//不良行为发生所在省
				credibillity.setCitynum(rs.getString("citynum"));//不良行为发生所在地市
				credibillity.setCountynum(rs.getString("countynum"));//不良行为发生所在区县
				credibillity.setCreditclassnum(rs.getString("creditclassnum"));//不良行为分类
				credibillity.setContent(rs.getString("content"));//不良行为内容
				credibillity.setPunishdepartname(rs.getString("punishdepartname"));//处罚部门
				credibillity.setAuditdate(rs.getDate("auditdate"));//省审核时间（发布时须填写）
				credibillity.setAuditusername(rs.getString("auditusername"));//审核领导（发布时须填写）
				credibillity.setPublicedate(rs.getDate("publicedate"));//发布结束时间（发布时须填写） 
				credibillity.setPublicbdate(rs.getDate("publicbdate"));//发布开始时间（发布时须填写）
				credibillity.setIspublic(rs.getString("ispublic"));//是否发布；0：未发布，1：已发布
				credibillity.setCREATEDATE(rs.getDate("cREATEDATE"));//登记日期
				credibillity.setUsername(rs.getString("username"));//登记人姓名
				credibillity.setPunishmoney(rs.getString("punishmoney"));//处罚金额
				credibillity.setPunishdeparttype(rs.getString("punishdeparttype"));//处罚部门级别；0：部级，1：省市，2：地市，3：区县
				credibillity.setDepartid(rs.getString("departid"));//登记部门id
				credibillity.setDeltype(rs.getString("deltype"));//删除状态 0：未删除、1：已删除	
				credibillity.setDepartname(rs.getString("departname"));//登记部门 

			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return credibillity;
	}

	@Override
	public CrediBillityGood querycredgood(String goodcreditid) {
		CrediBillityGood crediBillitygood = new CrediBillityGood();
		try {
			
			String qsql = "select * from v_CrediBillitygood_qiye where goodcreditid=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, goodcreditid);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				
				//总承包
				crediBillitygood.setGoodcreditid(rs.getString("goodcreditid"));//主键
				crediBillitygood.setCorpname(rs.getString("corpname"));//企业名称
				crediBillitygood.setCorpcode(rs.getString("corpcode"));//组织机构代码
				crediBillitygood.setDepartname(rs.getString("departname"));//登记部门
				crediBillitygood.setUsername(rs.getString("username"));//登记人
				crediBillitygood.setCreatedate(rs.getDate("createdate"));//登记日期
				crediBillitygood.setProvincenum(rs.getString("provincenum"));//良好行为发生所在省(字典表：tbxzqdmdic)
				crediBillitygood.setPrjnum(rs.getString("prjnum"));//项目编号
				crediBillitygood.setAwarddepartname(rs.getString("awarddepartname"));//奖励部门
				crediBillitygood.setAwarddeparttype(rs.getString("awarddeparttype"));//奖励部门级别；0：部级，1：省市，2：地市，3：区县
				crediBillitygood.setAwardcontent(rs.getString("awardcontent"));//奖励决定内容--
				crediBillitygood.setAwardnumber(rs.getString("awardnumber"));//奖励决定文号
				crediBillitygood.setAwarddate(rs.getDate("awarddate"));//奖励日期
				crediBillitygood.setCitynum(rs.getString("citynum"));//良好行为发生所在地市(字典表：tbxzqdmdic)
				crediBillitygood.setCountynum(rs.getString("countynum"));//良好行为发生所在区县(字典表：tbxzqdmdic)
				crediBillitygood.setCerttypenum(rs.getString("certtypenum"));//企业类型
				crediBillitygood.setPrjname(rs.getString("prjname"));//工程名称
				crediBillitygood.setAddress(rs.getString("address"));//工程地址
				crediBillitygood.setBuildcorpname(rs.getString("buildcorpname"));//建设单位			
				crediBillitygood.setBuildcorpcode(rs.getString("buildcorpcode"));//	建设单位组织机构代码）
				crediBillitygood.setIspublic(rs.getString("ispublic"));//是否发布；0：未发布，1：已发布
				crediBillitygood.setPublicedate(rs.getDate("publicedate"));//发布结束时间（发布时须填写）
				crediBillitygood.setPublicbdate(rs.getDate("publicbdate"));//发布开始时间（发布时须填写）
				crediBillitygood.setAuditdate(rs.getDate("auditdate"));//审核时间（发布时须填写）
				crediBillitygood.setDepartid(rs.getString("departid"));//登记部门id
				crediBillitygood.setStatus(rs.getString("status"));//状态 0：可用 1：删除
				crediBillitygood.setAuditusername(rs.getString("auditusername"));//审核领导
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return crediBillitygood;
	}	
	
}
