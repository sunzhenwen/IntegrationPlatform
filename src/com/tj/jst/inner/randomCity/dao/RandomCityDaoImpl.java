package com.tj.jst.inner.randomCity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomCity.model.RandomCity;

/**
 * 随机地市查询
 * 
 * @author Administrator
 *
 */
public class RandomCityDaoImpl extends BaseDao implements IRandomCityDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 查询城市列表
	 * 
	 * @return
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		String sql = "select * from TBXZQDMDIC_APP where code like '23%00' and code != 230000 or code = '400020' ";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
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
	 * 查询区县
	 * 
	 * @return
	 */
	public RandomCity queryArea(String cityCode,String nongkencode)
	{
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM "
				+ "(SELECT * FROM TBXZQDMDIC_APP "
				+ "where (code like '"+cityCode+"%' and code != '400021'"
				+ " and code != '400022' and code != '400023' and code != '400020')"
				+ " or (pid = '"+nongkencode+"') order by dbms_random.value) "
				+ "WHERE rownum =1";
		RandomCity randomCity = new RandomCity();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				randomCity.setName(rs.getString("name"));
				randomCity.setCode(rs.getString("code"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return randomCity;
	}
}
