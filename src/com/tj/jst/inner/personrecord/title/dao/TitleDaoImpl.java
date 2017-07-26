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
 * ְ����Ա����Dao��
 * 
 * @author DarkFlameMaster
 *
 */
public class TitleDaoImpl extends BaseDao implements ITitleDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
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
					title.setPersonId(rs.getString("personid")); // ����
					title.setPersonName(rs.getString("personName")); // ����
					title.setSexName(rs.getString("sexName")); // �Ա�(�ֵ��TBSEXDIC)
					title.setIdCardTypeName(rs.getString("idCardTypeName")); // ֤������(�ֵ��TBIDCARDTYPEDIC)
					title.setIdCard(rs.getString("idCard")); // ���֤��(����Ϊ18λ)
					title.setMobile(rs.getString("mobile")); // �ֻ�����
					title.setTitleName(rs.getString("titleName")); // ְ��
					title.setTitleMajor(rs.getString("titleMajor")); // ְ��רҵ
					title.setTitleLevel(rs.getString("titleLevel")); // ְ�Ƶȼ�
					title.setGraduatedSchool(rs.getString("graduatedSchool")); // ��ҵѧУ
					title.setGraduatedDate(rs.getDate("graduatedDate")); // ��ҵʱ��
					title.setStudyMajor(rs.getString("studyMajor")); // ��ѧרҵ
					title.setCorpName(rs.getString("corpName"));// ���ڹ�˾����
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
	 * ������ϸ
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
				title.setSexName(rs.getString("sexName")); // �Ա�(�ֵ��TBSEXDIC)
				title.setIdCardTypeName(rs.getString("idCardTypeName")); // ֤������(�ֵ��TBIDCARDTYPEDIC)
				title.setIdCard(rs.getString("idCard")); // ���֤��(����Ϊ18λ)
				title.setMobile(rs.getString("mobile")); // �ֻ�����
				// ְ��
				title.setTitleName(rs.getString("titleName"));
				// ְ��רҵ
				title.setTitleMajor(rs.getString("titleMajor"));
				// ְ�Ƽ���
				title.setTitleLevel(rs.getString("titleLevel"));
				// ��ҵѧУ
				title.setGraduatedSchool(rs.getString("graduatedSchool"));
				// ��ѧרҵ
				title.setStudyMajor(rs.getString("studyMajor"));
				// ��ҵʱ��
				title.setGraduatedDate(rs.getDate("graduatedDate"));
				// ���ڹ�˾
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
	 * �Ա�
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
	 * ֤������
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
