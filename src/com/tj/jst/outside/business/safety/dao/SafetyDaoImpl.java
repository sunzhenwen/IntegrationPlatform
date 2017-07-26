package com.tj.jst.outside.business.safety.dao;

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
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 安全监督
 * @author hhc
 *
 */
public class SafetyDaoImpl extends BaseDao implements ISafetyDao {

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
					Safety quality = new Safety();
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
	 * 安全监督申请
	 * @return
	 */
	public String add(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours)
	{
		String safetyId = UUID.randomUUID().toString();
		//System.out.println(quality.getContractorCorpCode());
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TB_SAFETYSUPERVISION(SAFETYID,PRJNUM,PRJNAME,"
					+ "prjId,createDate,applyCorpCode,applyCorpName,appType,processSteps,"
					+ "appDept,appDeptName,projectName,projectAddress,"
					+ "proStartDate,proEndDate,projectType,safetyTarget,newlyBuild,"
					+ "extend,other,policingName,policingStaff,designName,designStaff,"
					+ "buildingName,buildingStaff,buildingPhone,supervisionName,"
					+ "supervisionStaff,supervisionNum,supervisionPhone,probationStaff,"
					+ "probationPhone,probationNum,probationSafeNum,contractName,"
					+ "contractAdmin,contractPhone,contractStaff,contractSafeNum,"
					+ "contractProStaff,contractProStaffPhone,contractStaffRegNum,"
					+ "contractStaffNum,UNITPROJECT,SCALE,COST,STRUCTURE,"
					+ "HEIGHT,safetyNum,contractorCorpCode,expankj) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,safetyId);//主键
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
			//pstmt.setString(12, quality.getOversightNum());//安全监督登记编号
			pstmt.setString(12, quality.getProjectName());//工程名称
			pstmt.setString(13, quality.getProjectAddress());//工程地点
			pstmt.setDate(14, quality.getProStartDate());//合同开工日期
			pstmt.setDate(15, quality.getProEndDate());//合同竣工日期
			pstmt.setString(16, quality.getProjectType());//工程类型
			pstmt.setString(17,quality.getSafetyTarget());//安全生产标准化创建目标
			pstmt.setString(18,quality.getNewlyBuild());//新建
			pstmt.setString(19,quality.getExtend());//改扩建
			pstmt.setString(20,quality.getOther());//其它
			pstmt.setString(21,quality.getPolicingName());//勘察单位全称
			pstmt.setString(22,quality.getPolicingStaff());//勘察单位项目负责人
			pstmt.setString(23,quality.getDesignName());//设计单位全称
			pstmt.setString(24,quality.getDesignStaff());//设计单位项目负责人
			pstmt.setString(25,quality.getBuildingName());//建设单位全称
			pstmt.setString(26,quality.getBuildingStaff());//建设单位项目负责人
			pstmt.setString(27,quality.getBuildingPhone());//建设单位联系电话
			pstmt.setString(28,quality.getSupervisionName());//监理单位全称
			pstmt.setString(29,quality.getSupervisionStaff());//监理单位项目总监姓名
			pstmt.setString(30,quality.getSupervisionNum());//监理单位项目总监注册证书号
			pstmt.setString(31,quality.getSupervisionPhone());//监理单位项目总监联系电话
			pstmt.setString(32,quality.getProbationStaff());//监理单位安全监督姓名
			pstmt.setString(33,quality.getProbationPhone());//监理单位安全监督联系电话
			pstmt.setString(34,quality.getProbationNum());//监理单位安全监督注册证书号
			pstmt.setString(35,quality.getProbationSafeNum());//监理单位安全监督安全监理证号
			pstmt.setString(36,quality.getContractName());//施工总承包单位全称
			pstmt.setString(37,quality.getContractAdmin());//施工总承包单位公司安全管理
			pstmt.setString(38,quality.getContractPhone());//施工总承包单位联系电话
			pstmt.setString(39,quality.getContractStaff());//施工总承包单位负责人
			pstmt.setString(40,quality.getContractSafeNum());//施工总承包单位安全考核证号
			pstmt.setString(41,quality.getContractProStaff());//施工总承包单位项目负责人姓名
			pstmt.setString(42,quality.getContractProStaffPhone());//施工总承包单位项目负责人联系电话
			pstmt.setString(43,quality.getContractStaffRegNum());//施工总承包单位项目负责人注册证号
			pstmt.setString(44,quality.getContractStaffNum());//施工总承包单位项目负责人安全考核证号
			//pstmt.setString(46, quality.getSingleNum());//单位工程编号
			pstmt.setString(45, quality.getUnitProject());//单位工程
			pstmt.setString(46, quality.getScale());//建筑规模
			pstmt.setString(47, quality.getCost());//工程造价
			pstmt.setString(48, quality.getStructure());//结构/层次
			pstmt.setString(49, quality.getHeight());//建筑高度
			pstmt.setString(50, quality.getSafetyNum());
			pstmt.setString(51, quality.getContractorCorpCode());//监理组织机构代码 
			pstmt.setString(52, quality.getExpankj());//扩建
			pstmt.executeUpdate();
			
			//施工总承包单位现场专职安全管理人员
			for(int i=0;i<constructionSafety.size();i++)
			{
				if(!"".equals(constructionSafety.get(i).getSafetyManageName().trim()))
				{
					String id = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into CONSTRUCTION_SAFETY(CONSID,"
							+ "PRJID,safetyManageName,safetyManageNum,"
							+ "safetyManagecheckNum,createDate,safetyId) "
							+ "values(?,?,?,?,?,?,?)");
					pstmt.setString(1,id);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,constructionSafety.get(i).getSafetyManageName()); 
					pstmt.setString(4,constructionSafety.get(i).getSafetyManageNum()); 
					pstmt.setString(5,constructionSafety.get(i).getSafetyManagecheckNum());
					pstmt.setDate(6,new Date(new java.util.Date().getTime()));
					pstmt.setString(7, safetyId);
					pstmt.executeUpdate();
				}
			}
			
			//专业分包单位
			for(int i=0;i<majors.size();i++)
			{
				if(!"".equals(majors.get(i).getMajorName().trim()))
				{
					String majorId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into SAFETY_MAJOR(MAJORID,"
							+ "PRJID,safetyId,majorName,majorProject,majorLicenseDate,"
							+ "majorStaff,majorCardNum,majorPhone,createDate) "
							+ "values(?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1,majorId);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,safetyId); 
					pstmt.setString(4,majors.get(i).getMajorName()); 
					pstmt.setString(5,majors.get(i).getMajorProject());
					pstmt.setDate(6,majors.get(i).getMajorLicenseDate());
					pstmt.setString(7,majors.get(i).getMajorStaff());
					pstmt.setString(8,majors.get(i).getMajorCardNum());
					pstmt.setString(9,majors.get(i).getMajorPhone());
					pstmt.setDate(10,new Date(new java.util.Date().getTime()));
					pstmt.executeUpdate();
				}
			}
			
			//劳务分包单位
			for(int i=0;i<labours.size();i++)
			{
				if(!"".equals(labours.get(i).getLabourName().trim()))
				{
					String labourId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into SAFETY_LABOURS(labourId,"
							+ "prjId,safetyId,labourName,labourLicenseDate,labourStaff,"
							+ "labourPhone,createDate) values(?,?,?,?,?,?,?,?)");
					pstmt.setString(1,labourId);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,safetyId); 
					pstmt.setString(4,labours.get(i).getLabourName()); 
					pstmt.setDate(5,labours.get(i).getLabourLicenseDate());
					pstmt.setString(6,labours.get(i).getLabourStaff());
					pstmt.setString(7,labours.get(i).getLabourPhone());
					pstmt.setDate(8,new Date(new java.util.Date().getTime()));
					pstmt.executeUpdate();
				}
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
		return safetyId;
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Safety queryById(String safetyId)
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
				if(rs.getString("expankj") != null)
				{
					quality.setExpankj(rs.getString("expankj").trim());//其它
				}else
				{
					quality.setExpankj(rs.getString("expankj"));//其它
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
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=5 order by num");
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
				pstmt.setString(1,safetyId);
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
	 * 安全监督申请修改
	 * @return
	 */
	public void modify(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TB_SAFETYSUPERVISION set PRJNUM=?,PRJNAME=?,"
					+ "prjId=?,"
					+ "projectName=?,projectAddress=?,"
					+ "proStartDate=?,proEndDate=?,projectType=?,safetyTarget=?,newlyBuild=?,"
					+ "extend=?,other=?,policingName=?,policingStaff=?,designName=?,designStaff=?,"
					+ "buildingName=?,buildingStaff=?,buildingPhone=?,supervisionName=?,"
					+ "supervisionStaff=?,supervisionNum=?,supervisionPhone=?,probationStaff=?,"
					+ "probationPhone=?,probationNum=?,probationSafeNum=?,contractName=?,"
					+ "contractAdmin=?,contractPhone=?,contractStaff=?,contractSafeNum=?,"
					+ "contractProStaff=?,contractProStaffPhone=?,contractStaffRegNum=?,"
					+ "contractStaffNum=?,UNITPROJECT=?,SCALE=?,COST=?,STRUCTURE=?,"
					+ "HEIGHT=?,EXPANKJ=? where SAFETYID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,quality.getPrjNum());//项目编号
			pstmt.setString(2,quality.getPrjName());//项目名称
			pstmt.setString(3,quality.getPrjId());//项目报建主键
			//pstmt.setString(4, quality.getOversightNum());//安全监督登记编号
			pstmt.setString(4, quality.getProjectName());//工程名称
			pstmt.setString(5, quality.getProjectAddress());//工程地点
			pstmt.setDate(6, quality.getProStartDate());//合同开工日期
			pstmt.setDate(7, quality.getProEndDate());//合同竣工日期
			pstmt.setString(8, quality.getProjectType());//工程类型
			pstmt.setString(9,quality.getSafetyTarget());//安全生产标准化创建目标
			pstmt.setString(10,quality.getNewlyBuild());//新建
			pstmt.setString(11,quality.getExtend());//改建
			pstmt.setString(12,quality.getOther());//其它
			pstmt.setString(13,quality.getPolicingName());//勘察单位全称
			pstmt.setString(14,quality.getPolicingStaff());//勘察单位项目负责人
			pstmt.setString(15,quality.getDesignName());//设计单位全称
			pstmt.setString(16,quality.getDesignStaff());//设计单位项目负责人
			pstmt.setString(17,quality.getBuildingName());//建设单位全称
			pstmt.setString(18,quality.getBuildingStaff());//建设单位项目负责人
			pstmt.setString(19,quality.getBuildingPhone());//建设单位联系电话
			pstmt.setString(20,quality.getSupervisionName());//监理单位全称
			pstmt.setString(21,quality.getSupervisionStaff());//监理单位项目总监姓名
			pstmt.setString(22,quality.getSupervisionNum());//监理单位项目总监注册证书号
			pstmt.setString(23,quality.getSupervisionPhone());//监理单位项目总监联系电话
			pstmt.setString(24,quality.getProbationStaff());//监理单位安全监督姓名
			pstmt.setString(25,quality.getProbationPhone());//监理单位安全监督联系电话
			pstmt.setString(26,quality.getProbationNum());//监理单位安全监督注册证书号
			pstmt.setString(27,quality.getProbationSafeNum());//监理单位安全监督安全监理证号
			pstmt.setString(28,quality.getContractName());//施工总承包单位全称
			pstmt.setString(29,quality.getContractAdmin());//施工总承包单位公司安全管理
			pstmt.setString(30,quality.getContractPhone());//施工总承包单位联系电话
			pstmt.setString(31,quality.getContractStaff());//施工总承包单位负责人
			pstmt.setString(32,quality.getContractSafeNum());//施工总承包单位安全考核证号
			pstmt.setString(33,quality.getContractProStaff());//施工总承包单位项目负责人姓名
			pstmt.setString(34,quality.getContractProStaffPhone());//施工总承包单位项目负责人联系电话
			System.out.println(quality.getContractProStaffPhone());
			pstmt.setString(35,quality.getContractStaffRegNum());//施工总承包单位项目负责人注册证号
			pstmt.setString(36,quality.getContractStaffNum());//施工总承包单位项目负责人安全考核证号
			//pstmt.setString(38, quality.getSingleNum());//单位工程编号
			pstmt.setString(37, quality.getUnitProject());//单位工程
			pstmt.setString(38, quality.getScale());//建筑规模
			pstmt.setString(39, quality.getCost());//工程造价
			pstmt.setString(40, quality.getStructure());//结构/层次
			pstmt.setString(41, quality.getHeight());//建筑高度
			pstmt.setString(42,quality.getExpankj());//扩建 
			pstmt.setString(43,quality.getSafetyId());//主键

			pstmt.executeUpdate();
			
			//施工总承包单位现场专职安全管理人员
			pstmt = conn.prepareStatement("delete from CONSTRUCTION_SAFETY where safetyId=?");
			pstmt.setString(1,quality.getSafetyId()); 
			pstmt.executeUpdate();
			for(int i=0;i<constructionSafety.size();i++)
			{
				if(!constructionSafety.get(i).getSafetyManageName().trim().equals(""))
				{
					String id = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into CONSTRUCTION_SAFETY(CONSID,"
							+ "PRJID,safetyManageName,safetyManageNum,"
							+ "safetyManagecheckNum,createDate,safetyId) "
							+ "values(?,?,?,?,?,?,?)");
					pstmt.setString(1,id);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,constructionSafety.get(i).getSafetyManageName()); 
					pstmt.setString(4,constructionSafety.get(i).getSafetyManageNum()); 
					pstmt.setString(5,constructionSafety.get(i).getSafetyManagecheckNum());
					pstmt.setDate(6,new Date(new java.util.Date().getTime()));
					pstmt.setString(7, quality.getSafetyId());
					pstmt.executeUpdate();
				}
			}
			
			//专业分包单位
			pstmt = conn.prepareStatement("delete from SAFETY_MAJOR where safetyId=?");
			pstmt.setString(1,quality.getSafetyId()); 
			pstmt.executeUpdate();
			for(int i=0;i<majors.size();i++)
			{
				if(!"".equals(majors.get(i).getMajorName().trim()))
				{
					String majorId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into SAFETY_MAJOR(MAJORID,"
							+ "PRJID,safetyId,majorName,majorProject,majorLicenseDate,"
							+ "majorStaff,majorCardNum,majorPhone,createDate) "
							+ "values(?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1,majorId);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,quality.getSafetyId()); 
					pstmt.setString(4,majors.get(i).getMajorName()); 
					pstmt.setString(5,majors.get(i).getMajorProject());
					pstmt.setDate(6,majors.get(i).getMajorLicenseDate());
					pstmt.setString(7,majors.get(i).getMajorStaff());
					pstmt.setString(8,majors.get(i).getMajorCardNum());
					pstmt.setString(9,majors.get(i).getMajorPhone());
					pstmt.setDate(10,new Date(new java.util.Date().getTime()));
					pstmt.executeUpdate();
					
				}
			}
			
			//劳务分包单位
			pstmt = conn.prepareStatement("delete from SAFETY_LABOURS where safetyId=?");
			pstmt.setString(1,quality.getSafetyId()); 
			pstmt.executeUpdate();
			for(int i=0;i<labours.size();i++)
			{
				if(!labours.get(i).getLabourName().trim().equals(""))
				{
					String labourId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into SAFETY_LABOURS(labourId,"
							+ "prjId,safetyId,labourName,labourLicenseDate,labourStaff,"
							+ "labourPhone,createDate) values(?,?,?,?,?,?,?,?)");
					pstmt.setString(1,labourId);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,quality.getSafetyId()); 
					pstmt.setString(4,labours.get(i).getLabourName()); 
					pstmt.setDate(5,labours.get(i).getLabourLicenseDate());
					pstmt.setString(6,labours.get(i).getLabourStaff());
					pstmt.setString(7,labours.get(i).getLabourPhone());
					pstmt.setDate(8,new Date(new java.util.Date().getTime()));
					pstmt.executeUpdate();
				}
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
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String safetyId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TB_SAFETYSUPERVISION where SAFETYID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, safetyId);//主键
			pstmt.executeUpdate();
			
			//施工总承包单位现场专职安全管理人员
			pstmt = conn.prepareStatement("delete from CONSTRUCTION_SAFETY where safetyId=?");
			pstmt.setString(1, safetyId);
			pstmt.executeUpdate();
			
			//专业分包单位
			pstmt = conn.prepareStatement("delete from SAFETY_MAJOR where safetyId=?");
			pstmt.setString(1, safetyId);
			pstmt.executeUpdate();
			
			//劳务分包单位
			pstmt = conn.prepareStatement("delete from SAFETY_LABOURS where safetyId=?");
			pstmt.setString(1, safetyId);
			pstmt.executeUpdate();
			
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,safetyId);	
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
			pstmt.setString(1,safetyId);	
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

	//工程类型
	public List<DictionaryClass> queryProjectTypes()
	{
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
