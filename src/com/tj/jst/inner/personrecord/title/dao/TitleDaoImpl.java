package com.tj.jst.inner.personrecord.title.dao;

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
import com.tj.jst.inner.personrecord.title.model.Title;

/**
 * 职称人员备案Dao类
 * 
 * @author DarkFlameMaster
 *
 */
public class TitleDaoImpl extends BaseDao implements ITitleDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Title title = new Title();
					title.setPersonId(rs.getString("personid")); // 主键
					title.setPersonName(rs.getString("personName")); // 人名
					title.setSexName(rs.getString("sexName")); // 性别(字典表：TBSEXDIC)
					title.setIdCardTypeName(rs.getString("idCardTypeName")); // 证件类型(字典表：TBIDCARDTYPEDIC)
					title.setIdCard(rs.getString("idCard")); // 身份证号(必须为18位)
					title.setMobile(rs.getString("mobile")); // 手机号码
					title.setTitleName(rs.getString("titleName")); // 职称
					title.setTitleMajor(rs.getString("titleMajor")); // 职称专业
					title.setTitleLevel(rs.getString("titleLevel")); // 职称等级
					title.setGraduatedSchool(rs.getString("graduatedSchool")); // 毕业学校
					title.setGraduatedDate(rs.getDate("graduatedDate")); // 毕业时间
					title.setStudyMajor(rs.getString("studyMajor")); // 所学专业
					title.setCorpName(rs.getString("corpName"));// 所在公司名称
					page.getData().add(title);
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
	 * 查找详细
	 */
	@Override
	public Title queryById(String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select t.*,"
				+ "(select s.sex from TBSEXDIC s where t.sexnum=s.code) as sexName,"
				+ "(select d.papertype from TBIDCARDTYPEDIC d where t.idCardTypeNum=d.code) as idCardTypeName"
				+ " from TBREGTITLEPERSON t where t.personId=?";
		Title title = new Title();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				title.setPersonId(rs.getString("personId"));
				title.setPersonName(rs.getString("personName"));
				title.setSexName(rs.getString("sexName")); // 性别(字典表：TBSEXDIC)
				title.setIdCardTypeName(rs.getString("idCardTypeName")); // 证件类型(字典表：TBIDCARDTYPEDIC)
				title.setIdCard(rs.getString("idCard")); // 身份证号(必须为18位)
				title.setMobile(rs.getString("mobile")); // 手机号码
				// 职称
				title.setTitleName(rs.getString("titleName"));
				// 职称专业
				title.setTitleMajor(rs.getString("titleMajor"));
				// 职称级别
				title.setTitleLevel(rs.getString("titleLevel"));
				// 毕业学校
				title.setGraduatedSchool(rs.getString("graduatedSchool"));
				// 所学专业
				title.setStudyMajor(rs.getString("studyMajor"));
				// 毕业时间
				title.setGraduatedDate(rs.getDate("graduatedDate"));
				// 所在公司
				title.setCorpName(rs.getString("corpName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return title;
	}

	/**
	 * 性别
	 */
	@Override
	public List<DictionaryClass> querySexNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSEXDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("sex"));
				dictionaryClass.setCode(rs.getString("code"));
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

	/**
	 * 证件类型
	 */
	@Override
	public List<DictionaryClass> queryIdCardTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("papertype"));
				dictionaryClass.setCode(rs.getString("code"));
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

}
