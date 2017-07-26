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
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工许可
 * @author hhc
 *
 */
public class QueryPermitDaoImpl extends BaseDao implements IQueryPermitDao {

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
					permit.setProjectName(rs.getString("projectName"));
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
					permit.setAuCorpName(rs.getString("auCorpName"));
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
				permit.setPrjId(rs.getString("prjId"));
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
				permit.setProjectName(rs.getString("projectName"));
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
}
