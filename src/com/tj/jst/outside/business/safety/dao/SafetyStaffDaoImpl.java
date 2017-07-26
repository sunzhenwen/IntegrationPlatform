package com.tj.jst.outside.business.safety.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.safety.model.SafetyStaff;

/**
 * 施工安全从业人员
 * @author hhc
 *
 */
public class SafetyStaffDaoImpl extends BaseDao implements ISafetyStaffDao {

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
					SafetyStaff quality = new SafetyStaff();
					quality.setBuilderUserId(rs.getString("builderUserId"));//主键
					quality.setPrjNum(rs.getString("prjNum"));//项目编号
					quality.setPrjName(rs.getString("prjName"));//项目名称
					quality.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//施工许可证编号
					quality.setCorpName(rs.getString("corpName"));
					quality.setCorpCode(rs.getString("corpCode"));
					quality.setSafetyCerId(rs.getString("safetyCerId"));//安全生产许可证编号
					quality.setUserName(rs.getString("userName"));//人员姓名
					quality.setIdCardTypeNum(rs.getString("idCardTypeNum"));//证件类型
					quality.setIdCard(rs.getString("idCard"));//人员证件号码
					quality.setCertId(rs.getString("certId"));//安全生产合格证书编号
					quality.setUserType(rs.getString("userType"));//安全生产管理人员类型
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
	public void add(SafetyStaff quality)
	{
		String builderUserId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTBUILDERUSERINFO(builderUserId,PRJNUM,"
					+ "PRJNAME,builderLicenceNum,corpName,corpCode,safetyCerId,userName,"
					+ "idCardTypeNum,idCard,certId,userType,createDate) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,builderUserId);//主键
			pstmt.setString(2,quality.getPrjNum());//项目编号
			pstmt.setString(3,quality.getPrjName());//项目名称
			pstmt.setString(4, quality.getBuilderLicenceNum());
			pstmt.setString(5, quality.getCorpName());
			pstmt.setString(6, quality.getCorpCode());
			pstmt.setString(7, quality.getSafetyCerId());
			pstmt.setString(8, quality.getUserName());
			pstmt.setString(9, quality.getIdCardTypeNum());
			pstmt.setString(10, quality.getIdCard());
			pstmt.setString(11, quality.getCertId());
			pstmt.setString(12, quality.getUserType());
			pstmt.setDate(13,new Date(new java.util.Date().getTime())); //记录登记日期
			
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
	public SafetyStaff queryById(String builderUserId)
	{

		SafetyStaff quality = new SafetyStaff();
		try {
			
			String qsql = "select * from TBPROJECTBUILDERUSERINFO where builderUserId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, builderUserId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setBuilderUserId(rs.getString("builderUserId"));
				quality.setPrjNum(rs.getString("prjNum"));//项目编号
				quality.setPrjName(rs.getString("prjName"));//项目名称
				quality.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//施工许可证编号
				quality.setCorpName(rs.getString("corpName"));
				quality.setCorpCode(rs.getString("corpCode"));
				quality.setSafetyCerId(rs.getString("safetyCerId"));//安全生产许可证编号
				quality.setUserName(rs.getString("userName"));//人员姓名
				quality.setIdCardTypeNum(rs.getString("idCardTypeNum"));//证件类型
				quality.setIdCard(rs.getString("idCard"));//人员证件号码
				quality.setCertId(rs.getString("certId"));//安全生产合格证书编号
				quality.setUserType(rs.getString("userType"));//安全生产管理人员类型
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
	public void modify(SafetyStaff quality)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBPROJECTBUILDERUSERINFO set PRJNUM=?,"
					+ "PRJNAME=?,builderLicenceNum=?,corpName=?,corpCode=?,safetyCerId=?,"
					+ "userName=?,idCardTypeNum=?,idCard=?,certId=?,userType=? "
					+ "where builderUserId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,quality.getPrjNum());//项目编号
			pstmt.setString(2,quality.getPrjName());
			pstmt.setString(3,quality.getBuilderLicenceNum());
			pstmt.setString(4,quality.getCorpName());
			pstmt.setString(5,quality.getCorpCode());
			pstmt.setString(6,quality.getSafetyCerId());
			pstmt.setString(7,quality.getUserName());
			pstmt.setString(8,quality.getIdCardTypeNum());
			pstmt.setString(9,quality.getIdCard());
			pstmt.setString(10,quality.getCertId());
			pstmt.setString(11,quality.getUserType());
			pstmt.setString(12,quality.getBuilderUserId());
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
	public void delete(String builderUserId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTBUILDERUSERINFO where BUILDERUSERID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, builderUserId);//主键
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
	
}
