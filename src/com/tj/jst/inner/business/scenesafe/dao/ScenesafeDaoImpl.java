package com.tj.jst.inner.business.scenesafe.dao;
 
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.inner.business.scenesafe.model.ConstruScenesafe;
import com.tj.jst.inner.business.scenesafe.model.SceneSafe;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工许可数据库类
 * 
 * @author DarkFlameMaster
 *
 */
public class ScenesafeDaoImpl extends BaseDao implements ScenesafeDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;

	/**
	 * 分页
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					SceneSafe scenesafe = new SceneSafe();
					scenesafe.setPrjnamee(rs.getString("PRJNAME"));// 项目名称
					scenesafe.setPrjnumm(rs.getString("PRJNUM"));// 项目编号
					scenesafe.setBuilderlicencenum(rs.getString("BUILDERLICENCENUM"));//施工许可
					page.getData().add(scenesafe);
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
	 * 查询详细
	 */
	@Override
	public Permit queryApproval(String permitId) {
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
				permit.setProjectName(rs.getString("projectName"));// 工程名称
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
				//permit.setIdCardTypeNum(rs.getString("IDCARDTYPENUM").trim());// 安全生产管理证件类型(TBIDCARDTYPEDIC)
				permit.setIdCard(rs.getString("idCard"));// 安全生产管理人员证件号
				permit.setCertId(rs.getString("certId"));// 安全生产考核合格证书编号
				//permit.setUserType(rs.getString("userType").trim());// 安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
				permit.setCreateDate(rs.getDate("createDate"));// 记录登记日期
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				permit.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				permit.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				permit.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				permit.setAppDate(rs.getDate("appDate"));// 审批时间
				permit.setAppOpinion(rs.getString("appOpinion"));// 审批意见
				permit.setProjectName(rs.getString("projectName"));
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
				permit.setStarDate(rs.getDate("starDate"));
				permit.setQualityNum(rs.getString("qualityNum"));
				permit.setSafetyNum(rs.getString("safetyNum"));
				permit.setEndDate(rs.getDate("endDate"));
				permit.setTimeLimit(rs.getString("timeLimit"));;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return permit;
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(Permit permit) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			// Calendar c = Calendar.getInstance();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyMMdd");
			// String fDate = simpleDateFormat.format(c.getTime());
			// String serNum = PrjCode.querySerNuma(permit.getCreateDate(), 7);
			// String permitNum = permit.getAppDept() + fDate
			// + permit.getPrjNum().substring(12, 16) + "-SX-" + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  tbbuilderlicencemanage set APPTYPE=1,PROCESSSTEPS=6,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where PERMITID=?");
			pstmt.setString(1, permit.getAppSteffId());
			pstmt.setString(2, permit.getAppSteffName());
			pstmt.setDate(3, permit.getAppDate());
			pstmt.setString(4, permit.getAppOpinion());
			pstmt.setString(5, permit.getPermitId());
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
	public String approvalFailed(Permit permit) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  tbbuilderlicencemanage set APPTYPE=2,PROCESSSTEPS=5,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where PERMITID=?");
			pstmt.setString(1, permit.getAppSteffId());
			pstmt.setString(2, permit.getAppSteffName());
			pstmt.setDate(3, permit.getAppDate());
			pstmt.setString(4, permit.getAppOpinion());
			pstmt.setString(5, permit.getPermitId());
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
	 * 完成后更改基本信息
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update  TBProjectInfo_S set PROCESSSTEPS=6 where PRJNUM='"
				+ prjNum + "' ";
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
	}

	/**
	 * 查看是否有上传的信息
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		String sql = "select * from UPLOAD_FILE where LINKNAME='施工许可' and ID = '"
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
		String sql = "update TO_AUTHORIZATION set PROCESSSTEPS=6 where prjNum='"
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

	@Override
	public String add(SceneSafe scenesafe,List<ConstruScenesafe> construscenesafe) {
		String permitid = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into tbscenesafe(PERMITID,PRJNAMEE,PRJNUMM,"
					+ "BUILDERLICENCENUM,JCPORSON,JCDATE,FZPORSON,DJPORSON,DJDATE,COMPANYJC,"
					+ "COMPANYKC,COMPANYSJ,COMPANYJL,COMPANYSG,NRDESCRIPTION,JCCONCLUSION,CLSUGGESTION,CLGIST,appDept) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,permitid);//主键
			pstmt.setString(2,scenesafe.getPrjnamee());//项目名称
			pstmt.setString(3,scenesafe.getPrjnumm());//项目编号
			pstmt.setString(4,scenesafe.getBuilderlicencenum());//施工许可
			pstmt.setString(5,scenesafe.getJcporson());//检查人
			pstmt.setDate(6,scenesafe.getJcdate());//检查时间
			pstmt.setString(7,scenesafe.getFzporson());//现场负责人
			pstmt.setString(8,scenesafe.getDjporson());//登记人
			pstmt.setDate(9,scenesafe.getDjdate());//登记时间
			pstmt.setString(10,scenesafe.getCompanyjc());//涉及建设单位
			pstmt.setString(11,scenesafe.getCompanykc());//涉及勘察单位
			pstmt.setString(12,scenesafe.getCompanyjl());//涉及监理单位
			pstmt.setString(13,scenesafe.getCompanysj());//涉及涉及单位
			pstmt.setString(14,scenesafe.getCompanysg());//涉及施工单位
			pstmt.setString(15,scenesafe.getNrdescription());//内容描述
			pstmt.setString(16,scenesafe.getJcconclusion());//检查结论
			pstmt.setString(17,scenesafe.getClsuggestion());//处理意见
			pstmt.setString(18,scenesafe.getClgist());//处理依据
			pstmt.setString(19,scenesafe.getAppDept());//审批部门
			pstmt.executeUpdate();	
			
			
			//现场安全监督审查列表
			for(int i=0;i<construscenesafe.size();i++)
			{
				
					String id = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into tbscenesafe_mz("
							+ "prjid,permitid,jcneirong,"
							+ "question,suggestion)"
							+ "values(?,?,?,?,?)");
					pstmt.setString(1,id);	
					pstmt.setString(2,permitid); 
					pstmt.setString(3,construscenesafe.get(i).getJcneirong()); 
					pstmt.setString(4,construscenesafe.get(i).getQuestion()); 
					pstmt.setString(5,construscenesafe.get(i).getSuggestion());
					pstmt.executeUpdate();	
			}
			
			
			
			
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
		return permitid;
	}

	@Override
	public Page pagedQuerypage(Condition condition) {
				Page page = super.basePagedQuery(condition);
				ResultSet rs = page.getRs();
				try {
					if (rs != null) {
						while (rs.next()) {
							SceneSafe scenesafe = new SceneSafe();
							scenesafe.setPermitid(rs.getString("permitid"));// 主键
							scenesafe.setPrjnamee(rs.getString("PRJNAMEE"));// 项目名称
							scenesafe.setPrjnumm(rs.getString("PRJNUMM"));// 项目编号
							scenesafe.setBuilderlicencenum(rs.getString("BUILDERLICENCENUM"));//施工许可
							scenesafe.setJcporson(rs.getString("jcporson"));// 检查人
							scenesafe.setJcdate(rs.getDate("jcdate"));// 检查时间
							scenesafe.setFzporson(rs.getString("fzporson"));// 现场负责人
							scenesafe.setDjporson(rs.getString("djporson"));// 登记人
							scenesafe.setDjdate(rs.getDate("djdate"));// 登记时间
							scenesafe.setCompanyjc(rs.getString("companyjc"));// 涉及建设单位
							scenesafe.setCompanyjl(rs.getString("companyjl"));// 涉及建设单位
							scenesafe.setCompanysg(rs.getString("companysg"));// 涉及建设单位
							scenesafe.setCompanykc(rs.getString("companykc"));// 涉及建设单位
							scenesafe.setCompanysj(rs.getString("companysj"));// 涉及建设单位
							scenesafe.setNrdescription(rs.getString("nrdescription"));// 检查内容描述
							scenesafe.setJcconclusion(rs.getString("jcconclusion"));//检查结论
							scenesafe.setClgist(rs.getString("clgist"));// 处理依据

							page.getData().add(scenesafe);
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
	public SceneSafe queryById(String permitid) {
		SceneSafe scenesafe = new SceneSafe();
		try {
			
			String qsql = "select * from tbscenesafe where PERMITID=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitid);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				scenesafe.setPermitid(rs.getString("permitid"));//主键
				scenesafe.setPrjnumm(rs.getString("prjnumm"));//项目编号
				scenesafe.setPrjnamee(rs.getString("prjnamee"));//项目名称
				scenesafe.setJcdate(rs.getDate("jcdate"));//检查日期
				scenesafe.setJcporson(rs.getString("jcporson"));//检查人
				scenesafe.setBuilderlicencenum(rs.getString("builderlicencenum"));//施工许可
				scenesafe.setFzporson(rs.getString("fzporson"));//现场负责人
				scenesafe.setDjporson(rs.getString("djporson"));//登记人
				scenesafe.setDjdate(rs.getDate("djdate"));//登记时间
				scenesafe.setCompanyjc(rs.getString("companyjc"));//涉及建设单位
				scenesafe.setCompanykc(rs.getString("companykc"));//涉及建设单位
				scenesafe.setCompanyjl(rs.getString("companyjl"));//涉及建设单位
				scenesafe.setCompanysg(rs.getString("companysg"));//涉及建设单位
				scenesafe.setCompanysj(rs.getString("companysj"));//涉及建设单位
				scenesafe.setNrdescription(rs.getString("nrdescription"));//检查内容描述
				scenesafe.setJcconclusion(rs.getString("jcconclusion"));//检查结论
				scenesafe.setClsuggestion(rs.getString("clsuggestion"));//处理意见
				scenesafe.setClgist(rs.getString("clgist"));//处理依据
				scenesafe.setAppDept(rs.getString("appDept"));//审批部门
				
				//施工总承包单位现场专职安全管理人员
				List<ConstruScenesafe> cs = new ArrayList<ConstruScenesafe>();
				pstmt = conn.prepareStatement("select * from tbscenesafe_mz "
								+ "where PERMITID=?");
				pstmt.setString(1,permitid);	
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					ConstruScenesafe construscenesafe = new ConstruScenesafe();
					construscenesafe.setPrjid(rs.getString("prjid"));
					construscenesafe.setPermitid(permitid); 
					construscenesafe.setJcneirong(rs.getString("jcneirong"));
					construscenesafe.setQuestion(rs.getString("question"));
					construscenesafe.setSuggestion(rs.getString("suggestion"));
					cs.add(construscenesafe);
				}
				
				pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=? ");
				pstmt.setString(1,permitid);				
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
				
				
				scenesafe.setList(list);
				scenesafe.setConstruscenesafe(cs); 
				
			}
			
		}catch (SQLException e) {
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
		return scenesafe;
	}

	@Override
	public void delete(String permitid) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from tbscenesafe where PERMITID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, permitid);//主键
			pstmt.executeUpdate();
			
			//现场质量安全监督明细
			pstmt = conn.prepareStatement("delete from tbscenesafe_mz where PERMITID=?");
			pstmt.setString(1, permitid);
			pstmt.executeUpdate();
		
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,permitid);	
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
			pstmt.setString(1,permitid);	
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

	@Override
	public void modify(SceneSafe scenesafe,List<ConstruScenesafe> construscenesafe) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update tbscenesafe set prjnamee=?,"
					+ "prjnumm=?,"
					+ "builderlicencenum=?,jcporson=?,"
					+ "jcdate=?,fzporson=?,djporson=?,djdate=?,companyjc=?,"
					+ "companykc=?,companysj=?,companyjl=?,companysg=?,nrdescription=?,jcconclusion=?,"
					+ "clsuggestion=?,clgist=?,appDept=? where permitid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,scenesafe.getPrjnamee());//项目名称
			pstmt.setString(2,scenesafe.getPrjnumm());//项目编号
			pstmt.setString(3,scenesafe.getBuilderlicencenum());//使用许可
			pstmt.setString(4,scenesafe.getJcporson());//检查人
			pstmt.setDate(5,scenesafe.getJcdate());//检查时间
			pstmt.setString(6,scenesafe.getFzporson());//现场负责人
			pstmt.setString(7,scenesafe.getDjporson());//登记人
			pstmt.setDate(8,scenesafe.getDjdate());//登记时间
			pstmt.setString(9,scenesafe.getCompanyjc());//项目编号
			pstmt.setString(10,scenesafe.getCompanykc());//项目编号
			pstmt.setString(11,scenesafe.getCompanysj());//项目编号
			pstmt.setString(12,scenesafe.getCompanyjl());//项目编号
			pstmt.setString(13,scenesafe.getCompanysg());//项目编号
			pstmt.setString(14,scenesafe.getNrdescription());//检查内容描述
			pstmt.setString(15,scenesafe.getJcconclusion());//检查结论
			pstmt.setString(16,scenesafe.getClsuggestion());//处理意见
			pstmt.setString(17,scenesafe.getClgist());//处理依据
			pstmt.setString(18,scenesafe.getAppDept());//审批部门
			pstmt.setString(19,scenesafe.getPermitid());//主键
			pstmt.executeUpdate();
			//明细
			pstmt = conn.prepareStatement("delete from tbscenesafe_mz where PERMITID=?");
			pstmt.setString(1,scenesafe.getPermitid()); 
			pstmt.executeUpdate();
			for(int i=1;i<construscenesafe.size();i++)
			{
			
				 
					String labourId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into tbscenesafe_mz("
							+ "prjid,permitid,jcneirong,"
							+ "question,suggestion)"
							+ "values(?,?,?,?,?)");
					pstmt.setString(1,labourId);	
					pstmt.setString(2,scenesafe.getPermitid()); 
					pstmt.setString(3,construscenesafe.get(i).getJcneirong()); 
					pstmt.setString(4,construscenesafe.get(i).getQuestion()); 
					pstmt.setString(5,construscenesafe.get(i).getSuggestion());
					pstmt.executeUpdate();	
				
			}
			
			
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

}
