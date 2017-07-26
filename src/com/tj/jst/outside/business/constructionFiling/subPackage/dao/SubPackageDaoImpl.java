package com.tj.jst.outside.business.constructionFiling.subPackage.dao;

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
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 分包合同备案
 * @author hhc
 *
 */
public class SubPackageDaoImpl extends BaseDao implements ISubPackageDao {

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
					+ "specialtyTypeName,rating,ratingName,contrType,mainRecordNum) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			 * 3、保存，0、申请，1、审批通过，2、审批未通过
			 */
			pstmt.setString(18,"3");//审批状态
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
			pstmt.setString(37, contractFiling.getContrType());
			pstmt.setString(38, contractFiling.getMainRecordNum());
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
				contractFiling.setContrType(rs.getString("contrType"));
				contractFiling.setMainRecordNum(rs.getString("mainRecordNum"));//总包合同备案编号
			}
			
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=12 order by num");
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
					+ "contrType=?,mainRecordNum=?  "
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
			pstmt.setString(30, contractFiling.getContrType());
			pstmt.setString(31, contractFiling.getMainRecordNum());
			pstmt.setString(32, contractFiling.getRecordId());//主键
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
			
			String sqlCb = "delete from TB_CONTRACTINFO_BUSINESS where recordId=? ";
			pstmt = conn.prepareStatement(sqlCb);
			pstmt.setString(1, recordId);//主键
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
	 * 查询施工总包合同
	 * @author Administrator
	 *
	 */
	public Page pagedMainContractor(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					ContractFiling cf = new ContractFiling();

					cf.setRecordNum(rs.getString("recordNum"));//合同备案编号
					cf.setPrjNum(rs.getString("prjNum")); //项目编号
					cf.setPrjName(rs.getString("prjName"));//项目名称
					cf.setProjectAddress(rs.getString("projectAddress"));//项目地址
					cf.setProjectCost(rs.getString("projectCost"));//工程造价
					cf.setConstructorName(rs.getString("constructorName"));//项目经理姓名
					cf.setTitleLeve(rs.getString("titleLeve"));//资质等级
					cf.setPhone(rs.getString("phone"));//联系电话
					cf.setArea(rs.getString("area"));//建筑面积
					cf.setTenderNum(rs.getString("tenderNum"));//中标通知书编号
					cf.setSectionName(rs.getString("sectionName"));//标段名称
					cf.setContractNum(rs.getString("contractNum")); //合同编号
					cf.setContractMoney(rs.getString("contractMoney")); //合同金额(万元)
					cf.setPrjSize(rs.getString("prjSize")); //建设规模
					cf.setContractDate(rs.getDate("contractDate")); //合同签订日期
					cf.setPropietorCorpName(rs.getString("propietorCorpName")); //发包单位名称
					cf.setPropietorCorpCode(rs.getString("propietorCorpCode")); //发包单位住组织代码
					cf.setContractorCorpName(rs.getString("contractorCorpName")); //承包单位名称
					cf.setContractorCorpCode(rs.getString("contractorCorpCode")); //承包单位组织代码
					cf.setUnionCorpName(rs.getString("unionCorpName")); //联合体承包单位名称
					cf.setUnionCorpCode(rs.getString("unionCorpCode")); //联合体承包单位组织代码
					cf.setCreateDate(rs.getDate("createDate"));
					cf.setAppDept(rs.getString("appDept"));
					cf.setAppDeptName(rs.getString("appDeptName"));
					//					
//					//-------------------------------人员-----------------------------------	
//					cf.setTechnicalName(rs.getString("technicalName"));//技术负责人姓名
//					cf.setTechnicalIdCardTypeNum(rs.getString("technicalIdCardTypeNum"));//技术负责人证件类型
//					cf.setTechnicalIdCard(rs.getString("technicalIdCard"));//技术负责人证件号码
//					cf.setTechnicalCertNum(rs.getString("technicalCertNum"));//技术负责人证书号
//					cf.setQualityName(rs.getString("qualityName"));//质量检查员姓名
//					cf.setQualityIdCardTypeNum(rs.getString("qualityIdCardTypeNum"));//质量检查员证件类型
//					cf.setQualityIdCard(rs.getString("qualityIdCard"));//质量检查员证件号码
//					cf.setQualityCertNum(rs.getString("qualityCertNum"));//质量检查员证书号
//					cf.setSecurityName(rs.getString("securityName"));//安全员姓名
//					cf.setSecurityIdCardTypeNum(rs.getString("securityIdCardTypeNum"));//安全员证件类型
//					cf.setSecurityIdCard(rs.getString("securityIdCard"));//安全员证件号码
//					cf.setSecurityCertNum(rs.getString("securityCertNum"));//安全员证书号
//					cf.setConstructionName(rs.getString("constructionName"));//施工员（工长）姓名
//					cf.setConstructionIdCardTypeNum(rs.getString("constructionIdCardTypeNum"));//施工员（工长）证件类型
//					cf.setConstructionIdCard(rs.getString("constructionIdCard"));//施工员（工长）证件号码
//					cf.setConstructionCertNum(rs.getString("constructionCertNum"));//施工员（工长）证书号
//					cf.setDirectorName(rs.getString("directorName"));//（监理人员）总监姓名
//					cf.setDirectorIdCardTypeNum(rs.getString("directorIdCardTypeNum"));//（监理人员）总监证件类型
//					cf.setDirectorIdCard(rs.getString("directorIdCard"));//（监理人员）总监证件号码
//					cf.setDirectorCertNum(rs.getString("directorCertNum"));//（监理人员）总监证书号
//					cf.setRepresEntativeName(rs.getString("represEntativeName"));//总监代表姓名
//					cf.setRepresEntativeIdCardTypeNum(rs.getString("represEntativeIdCardTypeNum"));//总监代表证件类型
//					cf.setRepresEntativeIdCard(rs.getString("represEntativeIdCard"));//总监代表证件号码
//					cf.setRepresEntativeCertNum(rs.getString("represEntativeCertNum"));//总监代表证书号
//					cf.setSafetyName(rs.getString("safetyName"));//安全监理姓名
//					cf.setSafetyIdCardTypeNum(rs.getString("safetyIdCardTypeNum"));//安全监理证件类型
//					cf.setSafetyIdCard(rs.getString("safetyIdCard"));//安全监理证件号码
					
					
					
					cf.setContrType(rs.getString("contrType"));//0:施工分包或者施工劳务 1:市建  2:发改法规
					page.getData().add(cf);
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
	 * 提交
	 * @return
	 */
	public void sub(String recordId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update tbcontractrecordmanage set apptype=?  "
					+ "where RECORDID=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "0");//改为提交状态
			pstmt.setString(2,recordId); //主键
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
}
