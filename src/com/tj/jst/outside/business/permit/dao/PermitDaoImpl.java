package com.tj.jst.outside.business.permit.dao;

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
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工许可
 * @author hhc
 *
 */
public class PermitDaoImpl extends BaseDao implements IPermitDao {

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
					Permit permit = new Permit();
					permit.setPermitId(rs.getString("permitId"));//主键
					permit.setPrjNum(rs.getString("prjNum"));//项目编号
					permit.setPrjName(rs.getString("prjName"));//项目名称
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
					if(rs.getString("appDept")!=null)
					{
						permit.setAppDept(rs.getString("appDept").trim());//审批单位id
					}else
					{
						permit.setAppDept(rs.getString("appDept"));//审批单位id
					}
					
					permit.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
					page.getData().add(permit);
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
	 * 施工许可申请
	 * @return
	 */
	public String add(Permit permit)
	{
		String permitId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into tbbuilderlicencemanage(permitId,PRJNUM,PRJNAME,"
					+ "buldPlanNum,projectPlanNum,censorNum,contractMoney,"
					+ "area,prjSize,issueCertDate,econCorpName,econCorpCode,designCorpName,"
					+ "designCorpCode,consCorpName,"
					+ "consCorpCode,safetyCerId,superCorpName,superCorpCode,"
					+ "constructorName,cidCardTypeNum,constructorIdCard,supervisionName,"
					+ "sidCardTypeNum,supervisionIdCard,userName,idCardTypeNum,idCard,"
					+ "certId,userType,prjId,createDate,applyCorpCode,applyCorpName,"
					+ "appType,processSteps,appDept,appDeptName,projectName,"
					+ "builderLicenceNum,tenderNum,sectionName,qualityNum,safetyNum,"
					+ "starDate,endDate,timeLimit) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,permitId);//主键
			pstmt.setString(2,permit.getPrjNum());//项目编号
			pstmt.setString(3,permit.getPrjName());//项目名称
			pstmt.setString(4,permit.getBuldPlanNum());//建设用地规划许可证编号
			pstmt.setString(5,permit.getProjectPlanNum());//建设工程规划许可证编号
			pstmt.setString(6,permit.getCensorNum());//施工图审查合格书编号
			pstmt.setString(7,permit.getContractMoney());//合同金额(万元)
			pstmt.setString(8,permit.getArea());//面积(平方米)
			pstmt.setString(9,permit.getPrjSize());//建设规模
			pstmt.setDate(10, permit.getIssueCertDate());//发证日期
			pstmt.setString(11,permit.getEconCorpName());//勘察单位名称
			pstmt.setString(12,permit.getEconCorpCode());//勘察单位组织机构代码
			pstmt.setString(13,permit.getDesignCorpName());//设计单位名称
			pstmt.setString(14,permit.getDesignCorpCode());//设计单位组织机构代码
			pstmt.setString(15,permit.getConsCorpname());//施工单位名称
			pstmt.setString(16,permit.getConsCorpCode());//施工单位组织机构代码
			pstmt.setString(17,permit.getSafetyCerId());//施工单位安全生产许可证编号
			pstmt.setString(18,permit.getSuperCorpName());//监理单位名称
			pstmt.setString(19,permit.getSuperCorpCode());//监理单位组织机构代码
			pstmt.setString(20,permit.getConstructorName());//项目经理姓名
			pstmt.setString(21,permit.getCidCardTypeNum());//项目经理证件类型(TBIDCARDTYPEDIC)
			pstmt.setString(22,permit.getConstructorIdCard());//项目经理证件号码
			pstmt.setString(23,permit.getSupervisionName());//总监理工程师姓名
			pstmt.setString(24,permit.getSidCardTypeNum());//总监理工程师证件类型(TBIDCARDTYPEDIC)
			pstmt.setString(25,permit.getSupervisionIdCard());//总监理工程师号码
			pstmt.setString(26,permit.getUserName());//安全生产管理人员姓名
			pstmt.setString(27,permit.getIdCardTypeNum());//安全生产管理证件类型(TBIDCARDTYPEDIC)
			pstmt.setString(28,permit.getIdCard());//安全生产管理人员证件号
			pstmt.setString(29,permit.getCertId());//安全生产考核合格证书编号
			pstmt.setString(30,permit.getUserType());//安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
			pstmt.setString(31,permit.getPrjId());//项目报建主键
			pstmt.setDate(32,new Date(new java.util.Date().getTime())); //记录登记日期
			pstmt.setString(33,permit.getApplyCorpCode()); //申请企业组织机构代码
			pstmt.setString(34,permit.getApplyCorpName()); //申请企业名称
			/**
			 * 审批状态
			 * 0、申请，1、审批通过，2、审批未通过
			 */
			pstmt.setString(35,"0");//审批状态
			/**
			 * 流程步骤
			 * 1:项目报建
			 * 2:勘察阶段、设计阶段
			 * 3:合同备案、施工图审查备案
			 * 4:质量监督、安全监督
			 * 5:施工许可
			 * 6:竣工验收
			 */
			pstmt.setString(36,"5");
			pstmt.setString(37,permit.getAppDept());//审批单位id
			pstmt.setString(38,permit.getAppDeptName());//审批单位名称
			pstmt.setString(39, permit.getProjectName());//工程名称
			pstmt.setString(40, permit.getBuilderLicenceNum());
			pstmt.setString(41, permit.getTenderNum());
			pstmt.setString(42, permit.getSectionName());
			pstmt.setString(43, permit.getQualityNum());
			pstmt.setString(44, permit.getSafetyNum());
			pstmt.setDate(45, permit.getStarDate());
			pstmt.setDate(46, permit.getEndDate());
			pstmt.setString(47, permit.getTimeLimit());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBPROJECTINFO_S set buldPlanNum=?,"
					+ "projectPlanNum=? where prjNum=?");
			pstmt.setString(1, permit.getBuldPlanNum());
			pstmt.setString(2, permit.getProjectPlanNum());
			pstmt.setString(3, permit.getPrjNum());
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
		return permitId;
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId)
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
				permit.setPrjId(rs.getString("prjId"));//主体项目主键
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
				if(rs.getString("appDept")!=null)
				{
					permit.setAppDept(rs.getString("appDept").trim());//审批单位id
				}else
				{
					permit.setAppDept(rs.getString("appDept"));//审批单位id
				}
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
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=6 order by num");
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
				pstmt.setString(1,permitId);
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
			permit.setAccessoryList(accessoryList);
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
		return permit;
	}
	
	/**
	 * 施工许可申请修改
	 * @return
	 */
	public void modify(Permit permit)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update tbbuilderlicencemanage set PRJNUM=?,PRJNAME=?,"
					+ "buldPlanNum=?,projectPlanNum=?,censorNum=?,contractMoney=?,"
					+ "area=?,prjSize=?,econCorpName=?,econCorpCode=?,designCorpName=?,"
					+ "designCorpCode=?,consCorpName=?,"
					+ "consCorpCode=?,safetyCerId=?,superCorpName=?,superCorpCode=?,"
					+ "constructorName=?,cidCardTypeNum=?,constructorIdCard=?,"
					+ "supervisionName=?,sidCardTypeNum=?,supervisionIdCard=?,"
					+ "userName=?,idCardTypeNum=?,idCard=?,certId=?,userType=?,"
					+ "projectName=?,tenderNum=?,sectionName=?,STARDATE=?,ENDDATE=?, "
					+ " TIMELIMIT=? where permitId=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,permit.getPrjNum());//项目编号
			pstmt.setString(2,permit.getPrjName());//项目名称
			pstmt.setString(3,permit.getBuldPlanNum());//建设用地规划许可证编号
			pstmt.setString(4,permit.getProjectPlanNum());//建设工程规划许可证编号
			pstmt.setString(5,permit.getCensorNum());//施工图审查合格书编号
			pstmt.setString(6,permit.getContractMoney());//合同金额(万元)
			pstmt.setString(7,permit.getArea());//面积(平方米)
			pstmt.setString(8,permit.getPrjSize());//建设规模
			pstmt.setString(9,permit.getEconCorpName());//勘察单位名称
			pstmt.setString(10,permit.getEconCorpCode());//勘察单位组织机构代码
			pstmt.setString(11,permit.getDesignCorpName());//设计单位名称
			pstmt.setString(12,permit.getDesignCorpCode());//设计单位组织机构代码
			pstmt.setString(13,permit.getConsCorpname());//施工单位名称
			pstmt.setString(14,permit.getConsCorpCode());//施工单位组织机构代码
			pstmt.setString(15,permit.getSafetyCerId());//施工单位安全生产许可证编号
			pstmt.setString(16,permit.getSuperCorpName());//监理单位名称
			pstmt.setString(17,permit.getSuperCorpCode());//监理单位组织机构代码
			pstmt.setString(18,permit.getConstructorName());//项目经理姓名
			pstmt.setString(19,permit.getCidCardTypeNum());//项目经理证件类型(TBIDCARDTYPEDIC)
			pstmt.setString(20,permit.getConstructorIdCard());//项目经理证件号码
			pstmt.setString(21,permit.getSupervisionName());//总监理工程师姓名
			pstmt.setString(22,permit.getSidCardTypeNum());//总监理工程师证件类型(TBIDCARDTYPEDIC)
			pstmt.setString(23,permit.getSupervisionIdCard());//总监理工程师号码
			pstmt.setString(24,permit.getUserName());//安全生产管理人员姓名
			pstmt.setString(25,permit.getIdCardTypeNum());//安全生产管理证件类型(TBIDCARDTYPEDIC)
			pstmt.setString(26,permit.getIdCard());//安全生产管理人员证件号
			pstmt.setString(27,permit.getCertId());//安全生产考核合格证书编号
			pstmt.setString(28,permit.getUserType());//安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
			pstmt.setString(29, permit.getProjectName());//工程名称
			pstmt.setString(30, permit.getTenderNum());
			pstmt.setString(31, permit.getSectionName());
			pstmt.setDate(32, permit.getStarDate());
			pstmt.setDate(33, permit.getEndDate());
			pstmt.setString(34, permit.getTimeLimit());
			pstmt.setString(35,permit.getPermitId());//主键
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBPROJECTINFO_S set buldPlanNum=?,"
					+ "projectPlanNum=? where prjNum=?");
			pstmt.setString(1, permit.getBuldPlanNum());
			pstmt.setString(2, permit.getProjectPlanNum());
			pstmt.setString(3, permit.getPrjNum());
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
	public void delete(String permitId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from tbbuilderlicencemanage where permitId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, permitId);//主键
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,permitId);	
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
			pstmt.setString(1,permitId);	
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

	//证件类型
	public List<DictionaryClass> queryCardTypeNums()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from TBIDCARDTYPEDIC ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("PAPERTYPE"));
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
	 * 施工许可,质量信息查询
	 * @author Administrator
	 *
	 */
	public Page pagedQueryQuality(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
				Quality qu = new Quality();
				qu.setPrjName(rs.getString("prjName"));//项目名称
				qu.setPrjNum(rs.getString("prjNum"));//项目编号
				qu.setQualityNum(rs.getString("qualityNum"));//质量编码
				qu.setTenderNum(rs.getString("tenderNum"));//中标通知书编号
				qu.setSectionName(rs.getString("sectionName"));//标段名称
				qu.setProjectName(rs.getString("projectName"));//工程名称
				qu.setConstructionArea(rs.getString("constructionArea"));//面积
				qu.setSurveyUnit(rs.getString("SURVEYUNIT"));//勘察单位全称
				qu.setSurveyCode(rs.getString("econcorpcode"));//勘察单位组织机构代码
				qu.setDesignUnit(rs.getString("DESIGNUNIT"));//设计单位全称
				qu.setDesignCode(rs.getString("designcorpcode"));//设计单位组织机构代码
				qu.setConstructionUnit(rs.getString("CONSTRUCTIONUNIT"));//施工总承包单位全称
				qu.setConstructionCode(rs.getString("conscorpcode"));//施工总承包单位组织机构代码
				qu.setContractMoney(rs.getString("contractmoney"));//合同金额
				qu.setPrjId(rs.getString("prjId"));
				qu.setCreateDate(rs.getDate("createDate"));
				page.getData().add(qu);
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
	 * 施工许可,安全信息查询
	 * @author Administrator
	 *
	 */
	public Page pagedQueryPermSafety(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
				Safety sf = new Safety();
				sf.setPrjNum(rs.getString("prjNum"));
				sf.setPrjName(rs.getString("prjName"));
				sf.setSafetyNum(rs.getString("safetyNum"));//安全监督编码
				sf.setSupervisionName(rs.getString("supervisionName"));//监理单位全称
				sf.setContractorCorpCode(rs.getString("contractorCorpCode"));//监理单位组织机构代码
				sf.setSupervisionStaff(rs.getString("supervisionStaff"));//监理单位项目总监姓名
				sf.setSupervisionNum(rs.getString("supervisionNum"));//监理单位项目总监注册证书号
				sf.setProbationStaff(rs.getString("probationStaff"));//监理单位安全监督姓名
				sf.setProbationSafeNum(rs.getString("probationSafeNum"));//监理单位安全监督安全监理证号
				sf.setContractstart(rs.getDate("PROSTARTDATE"));//合同开工日期
				sf.setContractend(rs.getDate("PROENDDATE"));//合同竣工日期
				sf.setCreateDate(rs.getDate("createDate"));
				page.getData().add(sf);
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
	 * 施工许可,施工图审查合格书编号
	 * @param condition
	 * @return
	 */
	public Page pagedQueryPlanNum(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs != null)
			{
				while (rs.next()) {
					ConstructionPlans plans = new ConstructionPlans();
					//施工图审查机构名称
					plans.setCensorCorpName(rs.getString("censorCorpName"));
					//项目名称
					plans.setPrjName(rs.getString("prjName"));
					//证书编号
					plans.setCensorNum(rs.getString("censorNum"));
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
}
