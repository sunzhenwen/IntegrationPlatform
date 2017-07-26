package com.tj.jst.inner.announce.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Clob;
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
import com.tj.jst.inner.announce.model.Announce;

/**
 * ������Ϣ���ݿ���
 * 
 * @author DarkFlameMaster
 *
 */
public class AnnounceDaoImpl extends BaseDao implements IAnnounceDao {

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
					Announce announce = new Announce();
					announce.setAnnounceId(rs.getString("announceId"));// ����
					announce.setDate(rs.getDate("createDate"));// ����ʱ��
					announce.setIsPublish(rs.getString("isPublish"));// �Ƿ񷢲�
					announce.setMessage(rs.getString("message"));// ������Ϣ����
					announce.setTitle(rs.getString("title"));// ������Ϣ����
					announce.setType(rs.getString("announceType"));// ������Ϣ����
					announce.setUrl(rs.getString("announceUrl"));// ������Ϣ��ַ
					page.getData().add(announce);
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
	 * ��ѯ������Ϣ
	 */
	@Override
	public Announce queryById(String announceId) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_ANNOUNCE where ANNOUNCEID = '"
				+ announceId + "'";
		Announce announce = new Announce();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				announce.setAnnounceId(rs.getString("announceId"));// ����
				announce.setDate(rs.getDate("createDate"));// ����ʱ��
				announce.setIsPublish(rs.getString("isPublish"));// �Ƿ񷢲�
				// try {
				// announce.setMessage(ClobToString(rs.getClob("message")));
				// } catch (IOException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				announce.setMessage(rs.getString("message"));
				announce.setTitle(rs.getString("title"));// ������Ϣ����
				announce.setType(rs.getString("announceType"));// ������Ϣ����
				announce.setUrl(rs.getString("announceUrl"));// ������Ϣ��ַ
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return announce;
	}

	/**
	 * ���ӷ�����Ϣ
	 */
	@Override
	public String addAnnounce(Announce announce) {
		// TODO Auto-generated method stub
		String message = "";
		int check = 0;
		String sql = "insert into TB_ANNOUNCE(ANNOUNCEID,TITLE,MESSAGE,ANNOUNCETYPE,CREATEDATE,ANNOUNCEURL,ISPUBLISH) values (?,?,?,?,?,?,?)";
		String announceId = UUID.randomUUID().toString();
		Reader clobReader = new StringReader(announce.getMessage());
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, announceId);// ����
			pstmt.setString(2, announce.getTitle());// �������ݱ���
			// pstmt.setCharacterStream(3, clobReader,
			// announce.getMessage().length());// ��������
			pstmt.setString(3, announce.getMessage());// ��������
			pstmt.setString(4, announce.getType());// ��������
			pstmt.setDate(5, new Date(new java.util.Date().getTime()));// ����ʱ��
			pstmt.setString(6, announce.getUrl());// ������ַ
			pstmt.setString(7, announce.getIsPublish());// �Ƿ񷢲� 0��δ���� 1���ѷ���
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
	 * �޸ķ�����Ϣ
	 */
	@Override
	public String modifyAnnounce(Announce announce) {
		String s = null;
		Reader clobReader = new StringReader(announce.getMessage());
		int check = 0;
		String message = "";
		String sql = "update TB_ANNOUNCE set TITLE=?,MESSAGE=?,ANNOUNCETYPE=?,ANNOUNCEURL=?,ISPUBLISH=? where ANNOUNCEID=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, announce.getTitle());
			// pstmt.setCharacterStream(2, clobReader,
			// announce.getMessage().length());
			pstmt.setString(2, announce.getMessage());
			pstmt.setString(3, announce.getType());
			pstmt.setString(4, announce.getUrl());
			pstmt.setString(5, announce.getIsPublish());
			pstmt.setString(6, announce.getAnnounceId());
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

	public String ClobToString(Clob clob) throws SQLException, IOException {

		String reString = "";
		Reader is = clob.getCharacterStream();// �õ���
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// ִ��ѭ�����ַ���ȫ��ȡ����ֵ��StringBuffer��StringBufferת��STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}
}
