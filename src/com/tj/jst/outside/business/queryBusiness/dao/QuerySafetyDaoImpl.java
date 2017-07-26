package com.tj.jst.outside.business.queryBusiness.dao;

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
public class QuerySafetyDaoImpl extends BaseDao implements IQuerySafetyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
					quality.setAuCorpName(rs.getString("auCorpName"));
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
				quality.setOversightNum(rs.getString("oversightNum"));//编号
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
