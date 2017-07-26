package com.tj.jst.inner.personrecord.threeTypesPersonnel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.personrecord.threeTypesPersonnel.model.ThreeTypesPersonnel;

public class ThreeTypesPersonnelDaoImpl extends BaseDao implements IThreeTypesPersonnelDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override 
	public Page pagedQuery(Condition condition) {
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ThreeTypesPersonnel threeTypesPersonnel = new ThreeTypesPersonnel();
					threeTypesPersonnel.setFName(rs.getString("fName"));
					threeTypesPersonnel.setFIdCertNo(rs.getString("fIdCertNo"));
					threeTypesPersonnel.setFCertType(rs.getString("fCertType"));
					threeTypesPersonnel.setFCertNumber(rs.getString("fCertNumber"));
					threeTypesPersonnel.setFEntName(rs.getString("fEntName"));
					threeTypesPersonnel.setThreeTypePersonId(rs.getString("threeTypePersonId"));
					page.getData().add(threeTypesPersonnel);
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
	public ThreeTypesPersonnel queryById(String threeTypePersonId) {
		// TODO Auto-generated method stub
		String sql = "select * from THREETYPE_PERSON where threeTypePersonId = ?" ;
		ThreeTypesPersonnel threeTypesPersonnel = new ThreeTypesPersonnel();
		
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, threeTypePersonId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				threeTypesPersonnel.setCorpId(rs.getString("corpId")); //企业主键
				threeTypesPersonnel.setFCertNumber(rs.getString("fCertNumber"));//证书编号
				threeTypesPersonnel.setFCertType(rs.getString("fCertType"));//证书类别
				threeTypesPersonnel.setFEntName(rs.getString("fEntName"));//所在单位
				threeTypesPersonnel.setFEntName1(rs.getString("fEntName1"));//单位
				threeTypesPersonnel.setFIdCertNo(rs.getString("fIdCertNo"));//身份证号
				threeTypesPersonnel.setFName(rs.getString("fName"));//姓名
				threeTypesPersonnel.setFRegDate(rs.getDate("fRegDate"));//发证日期
				threeTypesPersonnel.setFRegEndDate(rs.getDate("fRegEndDate"));//结束日期
				threeTypesPersonnel.setFState(rs.getString("fState"));//状态 0:有效 1:无效
				threeTypesPersonnel.setThreeTypePersonId(rs.getString("threeTypePersonId"));//主键
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		
		return threeTypesPersonnel;
	}

	/**
	 * 根据corpId查询企业名称
	 */
	@Override
	public String queryCorpName(String corpId) {
		// TODO Auto-generated method stub
		String corpName = "" ;
		String sql = "select corpName from TBCORPBASICINFO where corpId = ?" ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				corpName = rs.getString("corpName");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return corpName ;
		
	}

}
