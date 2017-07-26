package com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.model.ThreeTypePerson;

/**
 * ��ʡ������Ա
 * @author Administrator
 *
 */
public class ThreeTypePersonDaoImpl extends BaseDao implements IThreeTypePersonDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * ��ҳ��ѯ
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					ThreeTypePerson tp = new ThreeTypePerson();
					tp.setThreeTypePersonId(rs.getString("threeTypePersonId"));
					tp.setCorpId(rs.getString("corpId"));
					tp.setFCertNumber(rs.getString("fCertNumber"));
					tp.setFCertType(rs.getString("fCertType"));
					tp.setFEntName(rs.getString("fEntName"));
					tp.setFEntName1(rs.getString("fEntName1"));
					tp.setFIdCertNo(rs.getString("fIdCertNo"));
					tp.setFName(rs.getString("fName"));
					tp.setFRegDate(rs.getDate("fRegDate"));
					tp.setFRegEndDate(rs.getDate("fRegEndDate"));
					tp.setFState(rs.getString("fState"));
				    page.getData().add(tp);
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
	 * ����ְ����Ա��Ϣ
	 */
	@Override
	public String add(ThreeTypePerson threeTypePerson) {
		String message = "";
		String sql = "insert into THREETYPE_PERSON(threeTypePersonId,FName,FIdCertNo,"
				+ "FEntName,FCertType,FEntName1,FCertNumber,FRegDate,FRegEndDate,FState,"
				+ "corpId) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		String threeTypePersonId = UUID.randomUUID().toString();
		try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,threeTypePersonId);
				pstmt.setString(2, threeTypePerson.getFName());
				pstmt.setString(3, threeTypePerson.getFIdCertNo());
				pstmt.setString(4, threeTypePerson.getFEntName());
				pstmt.setString(5, threeTypePerson.getFCertType());
				pstmt.setString(6, threeTypePerson.getFEntName1());
				pstmt.setString(7, threeTypePerson.getFCertNumber());
				pstmt.setDate(8, threeTypePerson.getFRegDate());
				pstmt.setDate(9, threeTypePerson.getFRegEndDate());
				pstmt.setString(10, "0");
				pstmt.setString(11, threeTypePerson.getCorpId());
				
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "��ӳɹ���";
				}else
				{
					message = "���ʧ�ܣ�";
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ͨ��perosnId��Ѱ��Ҫ����ɾ�������޸Ĳ�������Ա
	 */
	@Override
	public ThreeTypePerson queryById(String threeTypePersonId) {
		String message = "";
		String sql = "select * from THREETYPE_PERSON where threeTypePersonId=?";
		ThreeTypePerson tp = new ThreeTypePerson();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,threeTypePersonId);	
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				tp.setThreeTypePersonId(rs.getString("threeTypePersonId"));
				tp.setCorpId(rs.getString("corpId"));
				tp.setFCertNumber(rs.getString("fCertNumber"));
				tp.setFCertType(rs.getString("fCertType"));
				tp.setFEntName(rs.getString("fEntName"));
				tp.setFEntName1(rs.getString("fEntName1"));
				tp.setFIdCertNo(rs.getString("fIdCertNo"));
				tp.setFName(rs.getString("fName"));
				tp.setFRegDate(rs.getDate("fRegDate"));
				tp.setFRegEndDate(rs.getDate("fRegEndDate"));
				tp.setFState(rs.getString("fState"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return tp;
	}
	
	/**
	 * ְ����Ա��Ϣ�޸�
	 */
	@Override
	public String modify(ThreeTypePerson threeTypePerson) {
		String message = "";
		String sql = "update THREETYPE_PERSON set FName=?,FIdCertNo=?,FCertType=?,"
				+ "FCertNumber=?,FRegDate=?,FRegEndDate=? where threeTypePersonId=?";
		try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, threeTypePerson.getFName());
				pstmt.setString(2, threeTypePerson.getFIdCertNo());
				pstmt.setString(3, threeTypePerson.getFCertType());
				pstmt.setString(4, threeTypePerson.getFCertNumber());
				pstmt.setDate(5, threeTypePerson.getFRegDate());
				pstmt.setDate(6, threeTypePerson.getFRegEndDate());
				pstmt.setString(7, threeTypePerson.getThreeTypePersonId());
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "�޸ĳɹ���";
				}else
				{
					message = "�޸�ʧ�ܣ�";
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ����personId��ֵ��Ѱ�ұ�ɾ������Ա��Ϣ������ɾ��
	 */
	@Override
	public String delete(String threeTypePersonId) {
		String message = "";
		String sql = "delete from THREETYPE_PERSON where threeTypePersonId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,threeTypePersonId);	
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "ɾ���ɹ���";
			}else
			{
				message = "ɾ��ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}


}
