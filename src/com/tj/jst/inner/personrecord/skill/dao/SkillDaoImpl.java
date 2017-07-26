package com.tj.jst.inner.personrecord.skill.dao;

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
import com.tj.jst.inner.personrecord.skill.model.Skill;

/**
 * 技术人员备案Dao类
 * 
 * @author DarkFlameMaster
 *
 */
public class SkillDaoImpl extends BaseDao implements ISkillDao {

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
					Skill skilledworder = new Skill();
					skilledworder.setPersonId(rs.getString("personId")); // 主键
					skilledworder.setPersonName(rs.getString("personName")); // 人名
					skilledworder.setSexName(rs.getString("sexName")); // 性别(字典表：TBSEXDIC)
					skilledworder.setIdentityCard(rs.getString("identityCard")); // 身份证（必须18位）
					skilledworder.setSkilledType(rs.getString("typeName")); // 技术人员种类（字典表：TBSKILLEDWORkERTYPE）
					skilledworder.setSkilledLevel(rs.getString("levelName")); // 技术人员级别（字典表：TBSKILLEDWORKERLEVEL）
					skilledworder.setMobile(rs.getString("mobile")); // 手机号
					skilledworder.setCorpName(rs.getString("corpName"));// 人员所在公司名称
					skilledworder.setCertificateNum(rs.getString("certificateNum"));//证书编号
					page.getData().add(skilledworder);
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
	 * 技术工种类型
	 */
	@Override
	public List<DictionaryClass> skilledTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSKILLEDWORKERTYPE";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("id"));
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
	 * 技术工种级别
	 */
	@Override
	public List<DictionaryClass> skilledLevelNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSKILLEDWORKERLEVEL";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("id"));
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
	 * 技术工种性别
	 */
	@Override
	public List<DictionaryClass> sexNums() {
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
	 * 民族
	 */
	@Override
	public List<DictionaryClass> nationalNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBNATIONDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("nation"));
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
	 * 学历
	 */
	@Override
	public List<DictionaryClass> eduLevelNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBEDULEVELDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("diploma"));
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
	 * 学位
	 */
	@Override
	public List<DictionaryClass> degreeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBDEGREEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("degree"));
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
	public List<DictionaryClass> idCardTypeNums() {
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

	/**
	 * 通过Id寻找人员
	 */
	@Override
	public Skill queryById(String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select t.*,"
				+ "(select s.sex from TBSEXDIC s where t.sexnum=s.code) as sexName,"
				+ "(select l.name from TBSKILLEDWORKERLEVEL l where t.skilledLevelNum=l.id) as levelName,"
				+ "(select e.name from TBSKILLEDWORKERTYPE e where t.skilledTypeNum=e.id) as typeName,"
				+ "(select a.degree from TBDEGREEDIC a where  t.degreeNum=a.code) as degreeName,"
				+ "(select f.diploma from TBEDULEVELDIC f where t.skilledTypeNum=f.id) as eduLevelName,"
				+ "(select n.nation from TBNATIONDIC n where t.nationAlityNum=n.code) as papertypeName,"
				+ "(select d.papertype from TBIDCARDTYPEDIC d where t.idCardTypeNum=d.code) as idCardTypeName"
				+ " from TBSKILLEDWORKER t where t.personId=?";
		Skill skilledworker = new Skill();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				skilledworker.setBirthday(rs.getDate("birthday"));
				skilledworker.setDegreeNum(rs.getString("degreenum"));
				skilledworker.setDegreeName(rs.getString("degreeName"));
				skilledworker.setEduLevelName(rs.getString("edulevelName"));
				skilledworker.setIdCardTypeName(rs.getString("idcardtypeName"));
				skilledworker.setIdentityCard(rs.getString("identitycard"));
				skilledworker.setMobile(rs.getString("mobile"));
				skilledworker.setNationAlityName(rs.getString("papertypeName"));
				skilledworker.setPersonName(rs.getString("personname"));
				skilledworker.setSexName(rs.getString("sexName"));
				skilledworker.setSkilledLevel(rs.getString("levelName"));
				skilledworker.setSkilledType(rs.getString("typeName"));
				skilledworker.setCorpName(rs.getString("corpName"));
				skilledworker.setCertificateNum(rs.getString("certificateNum"));//证书编号
				skilledworker.setPersonId(personId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return skilledworker;
	}

}
