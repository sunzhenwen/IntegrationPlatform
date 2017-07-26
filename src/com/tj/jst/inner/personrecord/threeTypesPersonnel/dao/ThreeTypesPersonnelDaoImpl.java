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
	 * ��ҳ��ѯ
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
	 * ��ѯ��ϸ
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
				threeTypesPersonnel.setCorpId(rs.getString("corpId")); //��ҵ����
				threeTypesPersonnel.setFCertNumber(rs.getString("fCertNumber"));//֤����
				threeTypesPersonnel.setFCertType(rs.getString("fCertType"));//֤�����
				threeTypesPersonnel.setFEntName(rs.getString("fEntName"));//���ڵ�λ
				threeTypesPersonnel.setFEntName1(rs.getString("fEntName1"));//��λ
				threeTypesPersonnel.setFIdCertNo(rs.getString("fIdCertNo"));//���֤��
				threeTypesPersonnel.setFName(rs.getString("fName"));//����
				threeTypesPersonnel.setFRegDate(rs.getDate("fRegDate"));//��֤����
				threeTypesPersonnel.setFRegEndDate(rs.getDate("fRegEndDate"));//��������
				threeTypesPersonnel.setFState(rs.getString("fState"));//״̬ 0:��Ч 1:��Ч
				threeTypesPersonnel.setThreeTypePersonId(rs.getString("threeTypePersonId"));//����
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
	 * ����corpId��ѯ��ҵ����
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
