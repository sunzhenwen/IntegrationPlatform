package com.tj.jst.inner.accessory.dao;

import java.sql.Connection;
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

public class AccessoryDaoImpl extends BaseDao implements IAccessoryDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Accessory accessory = new Accessory();
					accessory.setDepartmentId(rs.getString("departmentId"));
					accessory.setId(rs.getString("id"));
					accessory.setMessage(rs.getString("message"));
					accessory.setNum(rs.getString("num"));
					accessory.setLinkNum(rs.getString("linkNum"));
					accessory.setLinkName(rs.getString("linkName"));
					page.getData().add(accessory);
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
	 * ���ӷ���
	 */
	@Override
	public String addPage(Accessory accessory) {
		// TODO Auto-generated method stub
		String sql = "insert into TB_ACCESSORY(ID,NUM,MESSAGE,DEPARTMENTID,linkNum) "
				+ "values(?,?,?,?,?)";
		String message = "";
		int check = 0;
		String id = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, accessory.getNum());
			pstmt.setString(3, accessory.getMessage());
			pstmt.setString(4, accessory.getDepartmentId());
			pstmt.setString(5, accessory.getLinkNum());
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "��ӳɹ�!";
			} else {
				message = "���ʧ��!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * �޸ķ���
	 */
	@Override
	public String modifyPage(Accessory accessory) {
		// TODO Auto-generated method stub
		int check = 0;
		String message = "";
		String sql = "update TB_ACCESSORY set NUM=? , MESSAGE=? ,linkNum=? where ID=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accessory.getNum());
			pstmt.setString(2, accessory.getMessage());
			pstmt.setString(3, accessory.getLinkNum());
			pstmt.setString(4, accessory.getId());
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "�޸ĳɹ���";
			} else {
				message = "�޸�ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ɾ������
	 */
	@Override
	public String deletePage(String id) {
		// TODO Auto-generated method stub
		int check = 0;
		String message = "";
		String sql = "delete TB_ACCESSORY  where ID=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "�޸ĳɹ���";
			} else {
				message = "�޸�ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ��ѯ��ϸ
	 */
	@Override
	public Accessory queryById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_ACCESSORY  where ID='"+id+"'";
		Accessory accessory = new Accessory();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				accessory.setDepartmentId(rs.getString("departmentId"));
				accessory.setId(rs.getString("id"));
				accessory.setMessage(rs.getString("message"));
				accessory.setNum(rs.getString("num"));
				accessory.setLinkNum(rs.getString("linkNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return accessory;
	}
	
	/**
	 * ��ѯ�����ֵ��
	 * 
	 * @param id
	 * @return
	 */
	public List<DictionaryClass> queryLinkName()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from LINK_NAME ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("id"));
				dictionaryClass.setName(rs.getString("name"));
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
