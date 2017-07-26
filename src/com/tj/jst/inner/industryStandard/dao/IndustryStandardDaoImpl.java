package com.tj.jst.inner.industryStandard.dao;

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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.industryStandard.model.IndustryStandard;

/**
 * 行业标准
 * 
 * @author DarkFlameMaster
 *
 */
public class IndustryStandardDaoImpl extends BaseDao implements
		IIndustryStandardDao {

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
					IndustryStandard is = new IndustryStandard();
					is.setIsId(rs.getString("isId"));
					is.setTitle(rs.getString("title"));
					is.setCreateDate(rs.getDate("createDate"));
					is.setIsPublish(rs.getString("isPublish"));
					is.setIsType(rs.getString("isType"));
					page.getData().add(is);
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
	public IndustryStandard queryById(String isId) {
		// TODO Auto-generated method stub
		String sql = "select * from INDUSTRY_STANDARD where isId=?";
		IndustryStandard industryStandard = new IndustryStandard();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isId);// 主键
			rs = pstmt.executeQuery();
			if (rs.next()) {
				industryStandard.setIsId(rs.getString("isId"));
				industryStandard.setTitle(rs.getString("title"));
				industryStandard.setIsType(rs.getString("isType"));
				industryStandard.setIsPublish(rs.getString("isPublish"));
				// try {
				// industryStandard.setMessage(ClobToString(rs.getClob("message")));
				// } catch (IOException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				industryStandard.setMessage(rs.getString("message"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return industryStandard;
	}

	/**
	 * 增加发布信息
	 */
	@Override
	public void add(IndustryStandard industryStandard) {
		// TODO Auto-generated method stub
		String isId = UUID.randomUUID().toString();
		Reader clobReader = new StringReader(industryStandard.getMessage());
		if (industryStandard.getIsPublish().trim().equals("1")) {
			String sql = "insert into INDUSTRY_STANDARD(ISID,TITLE,MESSAGE,ISTYPE,ISPUBLISH"
					+ ",CREATEDATE,PUBLISHSTAFF,INPUTSTAFF) values (?,?,?,?,?,?,?,?)";
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, isId);// 主键
				pstmt.setString(2, industryStandard.getTitle());// 发布内容标题
				// pstmt.setCharacterStream(3, clobReader,
				// industryStandard.getMessage().length());// 发布内容
				pstmt.setString(3, industryStandard.getMessage());// 发布种类
				pstmt.setString(4, industryStandard.getIsType());// 发布种类
				pstmt.setString(5, industryStandard.getIsPublish());// 是否发布 0是
																	// 1否
				pstmt.setDate(6, new Date(new java.util.Date().getTime()));
				pstmt.setString(7, industryStandard.getPublishStaff());
				pstmt.setString(8, industryStandard.getInputStaff());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		} else {
			String sql = "insert into INDUSTRY_STANDARD(ISID,TITLE,MESSAGE,ISTYPE,ISPUBLISH"
					+ ",CREATEDATE,PUBLISHSTAFF,RELEASEDATE,INPUTSTAFF) values (?,?,?,?,?,?,?,?,?)";

			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, isId);// 主键
				pstmt.setString(2, industryStandard.getTitle());// 发布内容标题
				pstmt.setString(3, industryStandard.getMessage());// 发布内容标题
				// pstmt.setCharacterStream(3, clobReader,
				// industryStandard.getMessage().length());// 发布内容
				pstmt.setString(4, industryStandard.getIsType());// 发布种类
				pstmt.setString(5, industryStandard.getIsPublish());// 是否发布 0是
																	// 1否
				pstmt.setDate(6, new Date(new java.util.Date().getTime()));
				pstmt.setString(7, industryStandard.getPublishStaff());
				pstmt.setDate(8, new Date(new java.util.Date().getTime()));
				pstmt.setString(9, industryStandard.getInputStaff());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}

	}

	/**
	 * 修改发布信息
	 */
	@Override
	public void modify(IndustryStandard industryStandard) {
		// TODO Auto-generated method stub
		Reader clobReader = new StringReader(industryStandard.getMessage());
		if (industryStandard.getIsPublish().trim().equals("1")) {
			String sql = "update INDUSTRY_STANDARD set TITLE=?,MESSAGE=?,ISTYPE=?,ISPUBLISH=?,"
					+ "MODIFYSTAFF=?,MODIFYDATE=? where ISID=?";
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, industryStandard.getTitle());
				pstmt.setString(2, industryStandard.getMessage());
				// pstmt.setCharacterStream(2, clobReader,
				// industryStandard.getMessage().length());// 发布内容
				pstmt.setString(3, industryStandard.getIsType());
				pstmt.setString(4, industryStandard.getIsPublish());
				pstmt.setString(5, industryStandard.getModifyStaff());
				pstmt.setDate(6, new Date(new java.util.Date().getTime()));
				pstmt.setString(7, industryStandard.getIsId());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		} else {
			String sql = "update INDUSTRY_STANDARD set TITLE=?,MESSAGE=?,ISTYPE=?,ISPUBLISH=?,"
					+ "PUBLISHSTAFF=?,RELEASEDATE=?,MODIFYSTAFF=?,MODIFYDATE=? where ISID=?";
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, industryStandard.getTitle());
				pstmt.setString(2, industryStandard.getMessage());
				// pstmt.setCharacterStream(2, clobReader,
				// industryStandard.getMessage().length());// 发布内容
				pstmt.setString(3, industryStandard.getIsType());
				pstmt.setString(4, industryStandard.getIsPublish());
				pstmt.setString(5, industryStandard.getPublishStaff());
				pstmt.setDate(6, new Date(new java.util.Date().getTime()));
				pstmt.setString(7, industryStandard.getModifyStaff());
				pstmt.setDate(8, new Date(new java.util.Date().getTime()));
				pstmt.setString(9, industryStandard.getIsId());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}

	}

	/**
	 * 删除
	 * 
	 * @param announceId
	 * @return
	 */
	public void delete(String isId) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from INDUSTRY_STANDARD where isId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isId);// 主键
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
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	public List<DictionaryClass> queryIsTypes() {
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from INDUSTRY_STANDARD_CODE where type='1'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	public List<DictionaryClass> queryIsPublishs() {
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from INDUSTRY_STANDARD_CODE where type='2'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
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
