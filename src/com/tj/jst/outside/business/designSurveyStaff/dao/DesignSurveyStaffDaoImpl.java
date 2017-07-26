package com.tj.jst.outside.business.designSurveyStaff.dao;

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
import com.tj.jst.outside.business.designSurveyStaff.model.DesignSurveyStaff;

/**
 * 勘察设计审图人员
 * @author hhc
 *
 */
public class DesignSurveyStaffDaoImpl extends BaseDao implements IDesignSurveyStaffDao {

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
					DesignSurveyStaff quality = new DesignSurveyStaff();
					quality.setDsId(rs.getString("ECONUSERID"));//主键
					quality.setPrjNum(rs.getString("prjNum"));//项目编号
					quality.setPrjName(rs.getString("prjName"));//项目名称
					quality.setCensorNum(rs.getString("censorNum"));//施工图审查合格证书编号
					quality.setCorpName(rs.getString("corpName"));
					quality.setCorpCode(rs.getString("corpCode"));
					quality.setUserName(rs.getString("userName"));//人员姓名
					quality.setIdCardTypeNum(rs.getString("idCardTypeNum"));//证件类型
					quality.setIdCard(rs.getString("idCard"));//人员证件号码
					quality.setSpecialtyTypNum(rs.getString("specialtyTypNum"));//注册类型及等级
					quality.setPrjDuty(rs.getString("prjDuty"));//承担角色
					quality.setConCorpCode(rs.getString("conCorpCode"));
					quality.setConCorpName(rs.getString("conCorpName"));
					quality.setCreateDate(rs.getDate("createDate"));
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
	public void add(DesignSurveyStaff quality)
	{
		String dsId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTDESIGNECONUSERINFO(ECONUSERID,PRJNUM,"
					+ "PRJNAME,censorNum,corpName,corpCode,userName,"
					+ "idCardTypeNum,idCard,specialtyTypNum,prjDuty,conCorpName,"
					+ "conCorpCode,createDate) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dsId);//主键
			pstmt.setString(2,quality.getPrjNum());//项目编号
			pstmt.setString(3,quality.getPrjName());//项目名称
			pstmt.setString(4, quality.getCensorNum());
			pstmt.setString(5, quality.getCorpName());
			pstmt.setString(6, quality.getCorpCode());
			pstmt.setString(7, quality.getUserName());
			pstmt.setString(8, quality.getIdCardTypeNum());
			pstmt.setString(9, quality.getIdCard());
			pstmt.setString(10, quality.getSpecialtyTypNum());
			pstmt.setString(11, quality.getPrjDuty());
			pstmt.setString(12, quality.getConCorpName());
			pstmt.setString(13, quality.getConCorpCode());
			pstmt.setDate(14,new Date(new java.util.Date().getTime())); //记录登记日期
			
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
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public DesignSurveyStaff queryById(String dsId)
	{

		DesignSurveyStaff quality = new DesignSurveyStaff();
		try {
			
			String qsql = "select * from TBPROJECTDESIGNECONUSERINFO where ECONUSERID=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, dsId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setDsId(rs.getString("ECONUSERID"));//主键
				quality.setPrjNum(rs.getString("prjNum"));//项目编号
				quality.setPrjName(rs.getString("prjName"));//项目名称
				quality.setCensorNum(rs.getString("censorNum"));//施工图审查合格证书编号
				quality.setCorpName(rs.getString("corpName"));
				quality.setCorpCode(rs.getString("corpCode"));
				quality.setUserName(rs.getString("userName"));//人员姓名
				quality.setIdCardTypeNum(rs.getString("idCardTypeNum"));//证件类型
				quality.setIdCard(rs.getString("idCard"));//人员证件号码
				quality.setSpecialtyTypNum(rs.getString("specialtyTypNum"));//注册类型及等级
				quality.setPrjDuty(rs.getString("prjDuty"));//承担角色
				quality.setConCorpCode(rs.getString("conCorpCode"));
				quality.setConCorpName(rs.getString("conCorpName"));
				quality.setCreateDate(rs.getDate("createDate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}
	
	/**
	 * 安全监督申请修改
	 * @return
	 */
	public void modify(DesignSurveyStaff quality)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBPROJECTDESIGNECONUSERINFO set PRJNUM=?,"
					+ "PRJNAME=?,censorNum=?,corpName=?,corpCode=?,userName=?,"
					+ "idCardTypeNum=?,idCard=?,specialtyTypNum=?,prjDuty=? "
					+ "where ECONUSERID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,quality.getPrjNum());//项目编号
			pstmt.setString(2,quality.getPrjName());//项目名称
			pstmt.setString(3, quality.getCensorNum());
			pstmt.setString(4, quality.getCorpName());
			pstmt.setString(5, quality.getCorpCode());
			pstmt.setString(6, quality.getUserName());
			pstmt.setString(7, quality.getIdCardTypeNum());
			pstmt.setString(8, quality.getIdCard());
			pstmt.setString(9, quality.getSpecialtyTypNum());
			pstmt.setString(10, quality.getPrjDuty());
			pstmt.setString(11,quality.getDsId());//主键
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
	public void delete(String id)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTDESIGNECONUSERINFO where ECONUSERID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);//主键
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
	
	//注册类型及等级
	public List<DictionaryClass> querySpecialtyTypNums()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from TBSPECIALTYTYPEDIC ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("TYPELEVEL"));
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
	
	//承担角色
	public List<DictionaryClass> queryPrjDutys()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from TBWORKDUTYDIC ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("ROLE"));
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
