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
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 竣工验收
 * @author hhc
 *
 */
public class QueryCompleteDaoImpl extends BaseDao implements IQueryCompleteDao {

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
					complete.setAuCorpName(rs.getString("auCorpName"));
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
				complete.setCreateDate(rs.getDate("createDate"));
				complete.setProjectName(rs.getString("projectName"));//工程名称
			}
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,completeId);
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
			complete.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return complete;
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
}
