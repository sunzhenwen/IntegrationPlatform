package com.tj.jst.outside.business.complete.dao;

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
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 竣工验收
 * @author hhc
 *
 */
public class CompleteDaoImpl extends BaseDao implements ICompleteDao {

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
					Complete complete = new Complete();
					complete.setCompleteId(rs.getString("completeId"));//主键
					complete.setPrjNum(rs.getString("prjNum"));//项目编号
					complete.setPrjName(rs.getString("prjName"));//项目名称
					complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//施工许可证编号
					complete.setQcCorpName(rs.getString("qcCorpName"));
					complete.setQcCorpCode(rs.getString("qcCorpCode"));
					complete.setFactCost(rs.getString("factCost"));
					complete.setFactArea(rs.getString("factArea"));
					complete.setFactSize(rs.getString("factSize"));
					complete.setPrjStructureTypeNum(rs.getString("prjStructureTypeNum"));
					complete.setBDate(rs.getDate("bDate"));
					complete.setEDate(rs.getDate("eDate"));
					complete.setMark(rs.getString("mark"));
					complete.setCreateDate(rs.getDate("createDate"));//记录登记日期
					complete.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
					complete.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
					complete.setAppSteffId(rs.getString("appSteffId"));//审批人id
					complete.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
					complete.setAppDate(rs.getDate("appDate"));//审批时间
					complete.setAppOpinion(rs.getString("appOpinion"));//审批意见
					/**
					 * 审批状态
					 * 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					complete.setAppType(rs.getString("appType").trim());//审批状态
					/**
					 * 流程步骤
					 * 1:项目报建
					 * 2:勘察阶段、设计阶段
					 * 3:合同备案、施工图审查备案
					 * 4:质量监督、安全监督
					 * 5:施工许可
					 * 6:竣工验收
					 */
					complete.setProcessSteps(rs.getString("processSteps").trim());
					complete.setAppDept(rs.getString("appDept").trim());//审批单位id
					complete.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
					page.getData().add(complete);
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
	 * 竣工验收申请
	 * @return
	 */
	public String add(Complete complete)
	{
		String completeId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTFINISHMANAGE(completeId,PRJNUM,PRJNAME,"
					+ "builderLicenceNum,"
					+ "qcCorpName,qcCorpCode,factCost,factArea,"
					+ "factSize,prjStructureTypeNum,bDate,EDate,mark,"
					+ "prjId,createDate,applyCorpCode,applyCorpName,"
					+ "appType,processSteps,appDept,appDeptName,projectName,"
					+ "prjFinishNum,tenderNum,sectionName) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,completeId);//主键
			pstmt.setString(2,complete.getPrjNum());//项目编号
			pstmt.setString(3,complete.getPrjName());//项目名称
			pstmt.setString(4,complete.getBuilderLicenceNum());//施工许可证编号
			pstmt.setString(5,complete.getQcCorpName());
			pstmt.setString(6,complete.getQcCorpCode());
			pstmt.setString(7,complete.getFactCost());
			pstmt.setString(8,complete.getFactArea());
			pstmt.setString(9,complete.getFactSize());
			pstmt.setString(10,complete.getPrjStructureTypeNum());
			pstmt.setDate(11, complete.getBDate());
			pstmt.setDate(12,complete.getEDate());
			pstmt.setString(13,complete.getMark());
			pstmt.setString(14,complete.getPrjId());//项目报建主键
			pstmt.setDate(15,new Date(new java.util.Date().getTime())); //记录登记日期
			pstmt.setString(16,complete.getApplyCorpCode()); //申请企业组织机构代码
			pstmt.setString(17,complete.getApplyCorpName()); //申请企业名称
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
			pstmt.setString(19,"6");
			pstmt.setString(20,complete.getAppDept());//审批单位id
			pstmt.setString(21,complete.getAppDeptName());//审批单位名称
			pstmt.setString(22, complete.getProjectName());//工程名称
			pstmt.setString(23, complete.getPrjFinishNum());
			pstmt.setString(24, complete.getTenderNum());
			pstmt.setString(25, complete.getSectionName());
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
		return completeId;
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Complete queryById(String completeId)
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
				complete.setPrjId(rs.getString("prjId"));//主体项目主键
				complete.setPrjNum(rs.getString("prjNum"));//项目编号
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
				complete.setPrjId(rs.getString("prjId"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				complete.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
				complete.setAppDept(rs.getString("appDept").trim());//审批单位id
				complete.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
				complete.setProjectName(rs.getString("projectName"));//工程名称
				complete.setPrjFinishNum(rs.getString("prjFinishNum"));
				complete.setTenderNum(rs.getString("tenderNum"));
				complete.setSectionName(rs.getString("sectionName"));
			}
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=7 order by num");
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
				pstmt.setString(1,completeId);
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
			complete.setAccessoryList(accessoryList);
			
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
		return complete;
	}
	
	/**
	 * 竣工验收申请修改
	 * @return
	 */
	public void modify(Complete complete)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			String sql = "update TBPROJECTFINISHMANAGE set PRJNUM=?,PRJNAME=?,"
					+ "builderLicenceNum=?,"
					+ "qcCorpName=?,qcCorpCode=?,factCost=?,factArea=?,"
					+ "factSize=?,prjStructureTypeNum=?,bDate=?,EDate=?,mark=?,"
					+ "prjId=?,appDept=?,appDeptName=?,projectName=?,sectionName=?,"
					+ "tenderNum=? where completeId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,complete.getPrjNum());//项目编号
			pstmt.setString(2,complete.getPrjName());//项目名称
			pstmt.setString(3,complete.getBuilderLicenceNum());//施工许可证编号
			pstmt.setString(4,complete.getQcCorpName());
			pstmt.setString(5,complete.getQcCorpCode());
			pstmt.setString(6,complete.getFactCost());
			pstmt.setString(7,complete.getFactArea());
			pstmt.setString(8,complete.getFactSize());
			pstmt.setString(9,complete.getPrjStructureTypeNum());
			pstmt.setDate(10, complete.getBDate());
			pstmt.setDate(11,complete.getEDate());
			pstmt.setString(12,complete.getMark());
			pstmt.setString(13,complete.getPrjId());//项目报建主键
			pstmt.setString(14,complete.getAppDept());//审批单位id
			pstmt.setString(15,complete.getAppDeptName());//审批单位名称
			pstmt.setString(16, complete.getProjectName());//工程名称
			pstmt.setString(17, complete.getSectionName());
			pstmt.setString(18, complete.getTenderNum());
			pstmt.setString(19,complete.getCompleteId());//主键
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
	public void delete(String completeId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTFINISHMANAGE where completeId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, completeId);//主键
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,completeId);	
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
			pstmt.setString(1,completeId);	
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

	//结构体系
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from TBPRJSTRUCTURETYPEDIC ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("STRUCT"));
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
	 * 竣工验收,施工许可信息查询
	 * @author Administrator
	 *
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
				Permit pt = new Permit();
				pt.setPrjNum(rs.getString("prjNum"));//项目编号
				pt.setPrjName(rs.getString("prjName"));//项目名称
				pt.setPrjSize(rs.getString("prjSize"));//建设规模
				pt.setSectionName(rs.getString("sectionName"));//标段名称
				pt.setTenderNum(rs.getString("tenderNum"));//中标通知书编号
				pt.setProjectName(rs.getString("projectName"));//工程名称
				pt.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//施工许可证号
				pt.setCreateDate(rs.getDate("createDate"));
				page.getData().add(pt);
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
