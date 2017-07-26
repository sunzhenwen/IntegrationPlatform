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
 * 发布信息数据库类
 * 
 * @author DarkFlameMaster
 *
 */
public class AnnounceDaoImpl extends BaseDao implements IAnnounceDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页
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
					announce.setAnnounceId(rs.getString("announceId"));// 主键
					announce.setDate(rs.getDate("createDate"));// 发布时间
					announce.setIsPublish(rs.getString("isPublish"));// 是否发布
					announce.setMessage(rs.getString("message"));// 发布信息内容
					announce.setTitle(rs.getString("title"));// 发布信息标题
					announce.setType(rs.getString("announceType"));// 发布信息种类
					announce.setUrl(rs.getString("announceUrl"));// 发布信息网址
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
	 * 查询发布信息
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
				announce.setAnnounceId(rs.getString("announceId"));// 主键
				announce.setDate(rs.getDate("createDate"));// 发布时间
				announce.setIsPublish(rs.getString("isPublish"));// 是否发布
				// try {
				// announce.setMessage(ClobToString(rs.getClob("message")));
				// } catch (IOException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				announce.setMessage(rs.getString("message"));
				announce.setTitle(rs.getString("title"));// 发布信息标题
				announce.setType(rs.getString("announceType"));// 发布信息种类
				announce.setUrl(rs.getString("announceUrl"));// 发布信息网址
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
	 * 增加发布信息
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
			pstmt.setString(1, announceId);// 主键
			pstmt.setString(2, announce.getTitle());// 发布内容标题
			// pstmt.setCharacterStream(3, clobReader,
			// announce.getMessage().length());// 发布内容
			pstmt.setString(3, announce.getMessage());// 发布种类
			pstmt.setString(4, announce.getType());// 发布种类
			pstmt.setDate(5, new Date(new java.util.Date().getTime()));// 发布时间
			pstmt.setString(6, announce.getUrl());// 发布网址
			pstmt.setString(7, announce.getIsPublish());// 是否发布 0：未发布 1：已发布
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "添加成功!";
			} else {
				message = "添加失败!";
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
	 * 修改发布信息
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
				message = "修改成功！";
			} else {
				message = "修改失败！";
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
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}
}
