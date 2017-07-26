package com.tj.jst.inner.randomProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomProject.model.RandomProject;

/**
 * 随机项目
 * 
 * @author Administrator
 *
 */
public class RandomProjectDaoImpl extends BaseDao implements IRandomProjectDao {

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
		String sql = "select * from TBXZQDMDIC_APP where code like '23%00' "
				+ "and code != 230000 or code = '400021'"
				+ " or code = '400020' or code = '400022' or code ='400023' ";
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
	public List<DictionaryClass> queryArea(String subCityCode,String cityCode)
	{
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM TBXZQDMDIC_APP "
				+ "where (code like '"+subCityCode+"%' and code != '"+cityCode+"'"
						+ " and code != '400021' and code != '400020' and code != '400022'"
						+ " and code != '400023') or (pid = '"+cityCode+"')";
		
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass randomCity = new DictionaryClass();
				randomCity.setName(rs.getString("name"));
				randomCity.setCode(rs.getString("code"));
				list.add(randomCity);
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
	 * 根据地市查询项目
	 * 
	 * @return
	 */
	public List<RandomProject> queryProject(String code)
	{
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM "
				+ "(SELECT * FROM TBPROJECTINFO_S "
				+ "where APPDEPT = '"+code+"' and APPTYPE=1 order by dbms_random.value) "
				+ "WHERE rownum <=4";
		List<RandomProject> list = new ArrayList<RandomProject>();
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RandomProject randomProject = new RandomProject();
				randomProject.setId(rs.getString("prjId"));
				randomProject.setPrjNum(rs.getString("prjNum"));
				randomProject.setPrjName(rs.getString("prjName"));
				randomProject.setAppDeptName(rs.getString("appDeptName"));
				list.add(randomProject);
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
