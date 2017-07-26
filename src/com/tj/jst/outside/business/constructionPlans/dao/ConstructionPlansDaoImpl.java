package com.tj.jst.outside.business.constructionPlans.dao;

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
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工图审查
 * @author hhc
 *
 */
public class ConstructionPlansDaoImpl extends BaseDao implements IConstructionPlansDao {

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
					ConstructionPlans constructionPlans = new ConstructionPlans();
					constructionPlans.setCensorId(rs.getInt("censorId"));//主键
					constructionPlans.setCensorNum(rs.getString("censorNum"));//施工图审查合格证书编号
					constructionPlans.setPrjNum(rs.getString("prjNum"));//项目编号
					constructionPlans.setPrjName(rs.getString("prjName"));//项目名称
					constructionPlans.setCensorCorpName(rs.getString("censorCorpName"));//施工图审查机构名称
					constructionPlans.setCensorCorpCode(rs.getString("censorCorpCode"));//施工图审查机构组织机构代码
					constructionPlans.setCensorEDate(rs.getDate("censorEDate"));//审查完成日期
					constructionPlans.setPrjSize(rs.getString("prjSize"));//建设规模
					constructionPlans.setEconCorpName(rs.getString("econCorpName"));//勘察单位名称
					constructionPlans.setEconCorpCode(rs.getString("econCorpCode"));//勘察单位组织机构代码
					constructionPlans.setEconCorpName2(rs.getString("econCorpName2"));//勘察单位名称2
					constructionPlans.setEconCorpCode2(rs.getString("econCorpCode2")); //勘察单位组织机构代码2
					constructionPlans.setEconCorpName3(rs.getString("econCorpName3"));//勘察单位名称3
					constructionPlans.setEconCorpCode3(rs.getString("econCorpCode3")); //勘察单位组织机构代码3
					constructionPlans.setDesignCorpName(rs.getString("designCorpName"));//设计单位名称
					constructionPlans.setDesignCorpCode(rs.getString("designCorpCode"));//设计单位组织机构代码
					constructionPlans.setDesignCorpName2(rs.getString("designCorpName2"));//设计单位名称2
					constructionPlans.setDesignCorpCode2(rs.getString("designCorpCode2"));//设计单位组织机构代码2
					constructionPlans.setDesignCorpName3(rs.getString("designCorpName3"));//设计单位名称3
					constructionPlans.setDesignCorpCode3(rs.getString("designCorpCode3"));//设计单位组织机构代码3
					constructionPlans.setOneCensorIsPass(rs.getString("oneCensorIsPass"));//一次审查是否通过 通过1、不通过0
					constructionPlans.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));//一次审查时违反强条数
					constructionPlans.setOneCensorWfqtContent(rs.getString("oneCensorWfqtContent"));//一次审查时违反的强条条目
					constructionPlans.setCreateDate(rs.getDate("createDate"));//记录登记日期
					constructionPlans.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
					constructionPlans.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
					constructionPlans.setAppSteffId(rs.getString("appSteffId"));//审批人id
					constructionPlans.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
					constructionPlans.setAppDate(rs.getDate("appDate"));//审批时间
					constructionPlans.setAppOpinion(rs.getString("appOpinion"));//审批意见
					/**
					 * 审批状态
					 * 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					constructionPlans.setAppType(rs.getString("appType").trim());//审批状态
					/**
					 * 流程步骤
					 * 1:项目报建
					 * 2:勘察阶段、设计阶段
					 * 3:合同备案、施工图审查备案
					 * 4:质量监督、安全监督
					 * 5:施工许可
					 * 6:竣工验收
					 */
					constructionPlans.setProcessSteps(rs.getString("processSteps").trim());
					constructionPlans.setAppDept(rs.getString("appDept").trim());//审批单位id
					constructionPlans.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
					page.getData().add(constructionPlans);
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
	 * 施工图审查申请
	 * @return
	 */
	public String add(ConstructionPlans constructionPlans)
	{
		String censorId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTCENSORINFO(censorId,PRJNUM,PRJNAME,"
					+ "prjId,censorCorpName,censorCorpCode,censorEDate,prjSize,"
					+ "econCorpName,econCorpCode,econCorpName2,econCorpCode2,"
					+ "econCorpName3,econCorpCode3,designCorpName,designCorpCode,designCorpName2,"
					+ "designCorpCode2,designCorpName3,designCorpCode3,oneCensorIsPass,"
					+ "oneCensorWfqtCount,oneCensorWfqtContent,createDate,applyCorpCode,"
					+ "applyCorpName,appType,processSteps,appDept,appDeptName,censorNum) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,censorId);//主键
			pstmt.setString(2,constructionPlans.getPrjNum());//项目编号
			pstmt.setString(3,constructionPlans.getPrjName());//项目名称
			pstmt.setString(4,constructionPlans.getPrjId());//项目报建主键
			pstmt.setString(5,constructionPlans.getCensorCorpName());//施工图审查机构名称
			pstmt.setString(6,constructionPlans.getCensorCorpCode());//施工图审查机构组织机构代码
			pstmt.setDate(7,constructionPlans.getCensorEDate());//审查完成日期
			pstmt.setString(8,constructionPlans.getPrjSize());//建设规模
			pstmt.setString(9,constructionPlans.getEconCorpName());//勘察单位名称
			pstmt.setString(10,constructionPlans.getEconCorpCode());//勘察单位组织机构代码
			pstmt.setString(11,constructionPlans.getEconCorpName2());//勘察单位名称2
			pstmt.setString(12,constructionPlans.getEconCorpCode2());//勘察单位组织机构代码2
			pstmt.setString(13,constructionPlans.getEconCorpName3());//勘察单位名称3
			pstmt.setString(14,constructionPlans.getEconCorpCode3());//勘察单位组织机构代码3
			pstmt.setString(15,constructionPlans.getDesignCorpName());//设计单位名称
			pstmt.setString(16,constructionPlans.getDesignCorpCode());//设计单位组织机构代码
			pstmt.setString(17,constructionPlans.getDesignCorpName2());//设计单位名称2
			pstmt.setString(18,constructionPlans.getDesignCorpCode2());//设计单位组织机构代码2
			pstmt.setString(19,constructionPlans.getDesignCorpName3());//设计单位名称3
			pstmt.setString(20,constructionPlans.getDesignCorpCode3());//设计单位组织机构代码3
			pstmt.setString(21,constructionPlans.getOneCensorIsPass());//一次审查是否通过 通过1、不通过0
			pstmt.setString(22,constructionPlans.getOneCensorWfqtCount());//一次审查时违反强条数
			pstmt.setString(23,constructionPlans.getOneCensorWfqtContent());//一次审查时违反的强条条目
			pstmt.setDate(24,new Date(new java.util.Date().getTime())); //记录登记日期
			pstmt.setString(25,constructionPlans.getApplyCorpCode()); //申请企业组织机构代码
			pstmt.setString(26,constructionPlans.getApplyCorpName()); //申请企业名称
			/**
			 * 审批状态
			 * 0、申请，1、审批通过，2、审批未通过
			 */
			pstmt.setString(27,"0");//审批状态
			/**
			 * 流程步骤
			 * 1:项目报建
			 * 2:勘察阶段、设计阶段
			 * 3:合同备案、施工图审查备案
			 * 4:质量监督、安全监督
			 * 5:施工许可
			 * 6:竣工验收
			 */
			pstmt.setString(28,"3");
			pstmt.setString(29,constructionPlans.getAppDept());//审批单位id
			pstmt.setString(30,constructionPlans.getAppDeptName());//审批单位名称
			pstmt.setString(31, constructionPlans.getCensorNum());//施工图审查合格证书编号
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
		return censorId;
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ConstructionPlans queryById(String censorId)
	{

		ConstructionPlans constructionPlans = new ConstructionPlans();
		try {
			
			String qsql = "select * from TBPROJECTCENSORINFO where censorId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, censorId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				constructionPlans.setCensorId(rs.getInt("censorId"));//主键
				constructionPlans.setCensorNum(rs.getString("censorNum"));//施工图审查合格证书编号
				constructionPlans.setPrjNum(rs.getString("prjNum"));//项目编号
				constructionPlans.setPrjName(rs.getString("prjName"));//项目名称
				constructionPlans.setCensorCorpName(rs.getString("censorCorpName"));//施工图审查机构名称
				constructionPlans.setCensorCorpCode(rs.getString("censorCorpCode"));//施工图审查机构组织机构代码
				constructionPlans.setCensorEDate(rs.getDate("censorEDate"));//审查完成日期
				constructionPlans.setPrjSize(rs.getString("prjSize"));//建设规模
				constructionPlans.setEconCorpName(rs.getString("econCorpName"));//勘察单位名称
				constructionPlans.setEconCorpCode(rs.getString("econCorpCode"));//勘察单位组织机构代码
				constructionPlans.setEconCorpName2(rs.getString("econCorpName2"));//勘察单位名称2
				constructionPlans.setEconCorpCode2(rs.getString("econCorpCode2")); //勘察单位组织机构代码2
				constructionPlans.setEconCorpName3(rs.getString("econCorpName3"));//勘察单位名称3
				constructionPlans.setEconCorpCode3(rs.getString("econCorpCode3")); //勘察单位组织机构代码3
				constructionPlans.setDesignCorpName(rs.getString("designCorpName"));//设计单位名称
				constructionPlans.setDesignCorpCode(rs.getString("designCorpCode"));//设计单位组织机构代码
				constructionPlans.setDesignCorpName2(rs.getString("designCorpName2"));//设计单位名称2
				constructionPlans.setDesignCorpCode2(rs.getString("designCorpCode2"));//设计单位组织机构代码2
				constructionPlans.setDesignCorpName3(rs.getString("designCorpName3"));//设计单位名称3
				constructionPlans.setDesignCorpCode3(rs.getString("designCorpCode3"));//设计单位组织机构代码3
				constructionPlans.setOneCensorIsPass(rs.getString("oneCensorIsPass"));//一次审查是否通过 通过1、不通过0
				constructionPlans.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));//一次审查时违反强条数
				constructionPlans.setOneCensorWfqtContent(rs.getString("oneCensorWfqtContent"));//一次审查时违反的强条条目
				constructionPlans.setCreateDate(rs.getDate("createDate"));//记录登记日期
				constructionPlans.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				constructionPlans.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
				constructionPlans.setAppSteffId(rs.getString("appSteffId"));//审批人id
				constructionPlans.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
				constructionPlans.setAppDate(rs.getDate("appDate"));//审批时间
				constructionPlans.setAppOpinion(rs.getString("appOpinion"));//审批意见
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				constructionPlans.setAppType(rs.getString("appType").trim());//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				constructionPlans.setProcessSteps(rs.getString("processSteps").trim());
				constructionPlans.setAppDept(rs.getString("appDept").trim());//审批单位id
				constructionPlans.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
				constructionPlans.setPrjId(rs.getString("prjId"));
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,censorId);
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
			constructionPlans.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return constructionPlans;
	}
	
	/**
	 * 合同备案申请修改
	 * @return
	 */
	public void modify(ConstructionPlans constructionPlans)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBPROJECTCENSORINFO set PRJNUM=?,PRJNAME=?,"
					+ "prjId=?,censorCorpName=?,censorCorpCode=?,censorEDate=?,prjSize=?,"
					+ "econCorpName=?,econCorpCode=?,econCorpName2=?,econCorpCode2=?,"
					+ "econCorpName3=?,econCorpCode3=?,designCorpName=?,designCorpCode=?,"
					+ "designCorpName2=?,designCorpCode2=?,designCorpName3=?,designCorpCode3=?,"
					+ "oneCensorIsPass=?,oneCensorWfqtCount=?,oneCensorWfqtContent=?,"
					+ "appDept=?,appDeptName=? where censorId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,constructionPlans.getPrjNum());//项目编号
			pstmt.setString(2,constructionPlans.getPrjName());//项目名称
			pstmt.setString(3,constructionPlans.getPrjId());//项目报建主键
			pstmt.setString(4,constructionPlans.getCensorCorpName());//施工图审查机构名称
			pstmt.setString(5,constructionPlans.getCensorCorpCode());//施工图审查机构组织机构代码
			pstmt.setDate(6,constructionPlans.getCensorEDate());//审查完成日期
			pstmt.setString(7,constructionPlans.getPrjSize());//建设规模
			pstmt.setString(8,constructionPlans.getEconCorpName());//勘察单位名称
			pstmt.setString(9,constructionPlans.getEconCorpCode());//勘察单位组织机构代码
			pstmt.setString(10,constructionPlans.getEconCorpName2());//勘察单位名称2
			pstmt.setString(11,constructionPlans.getEconCorpCode2());//勘察单位组织机构代码2
			pstmt.setString(12,constructionPlans.getEconCorpName3());//勘察单位名称3
			pstmt.setString(13,constructionPlans.getEconCorpCode3());//勘察单位组织机构代码3
			pstmt.setString(14,constructionPlans.getDesignCorpName());//设计单位名称
			pstmt.setString(15,constructionPlans.getDesignCorpCode());//设计单位组织机构代码
			pstmt.setString(16,constructionPlans.getDesignCorpName2());//设计单位名称2
			pstmt.setString(17,constructionPlans.getDesignCorpCode2());//设计单位组织机构代码2
			pstmt.setString(18,constructionPlans.getDesignCorpName3());//设计单位名称3
			pstmt.setString(19,constructionPlans.getDesignCorpCode3());//设计单位组织机构代码3
			pstmt.setString(20,constructionPlans.getOneCensorIsPass());//一次审查是否通过 通过1、不通过0
			pstmt.setString(21,constructionPlans.getOneCensorWfqtCount());//一次审查时违反强条数
			pstmt.setString(22,constructionPlans.getOneCensorWfqtContent());//一次审查时违反的强条条目
			pstmt.setString(23,constructionPlans.getAppDept());//审批单位id
			pstmt.setString(24,constructionPlans.getAppDeptName());//审批单位名称
			pstmt.setInt(25,constructionPlans.getCensorId());//主键
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
	public void delete(String censorId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTCENSORINFO where censorId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, censorId);//主键
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,censorId);	
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
			pstmt.setString(1,censorId);	
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

}
