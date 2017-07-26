package com.tj.jst.base.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接
 * @author hhc
 *
 */
public class ConnectionFactory {
	
	//基础数据库数据源
	private static ComboPooledDataSource basicDataSource;
	//岗位人员数据源
	private static ComboPooledDataSource staffPositionsDataSource;
	//资质系统数据源
	private static ComboPooledDataSource qualityDataSource;
	
	private ConnectionFactory() {
	}

	static {
		//资质系统数据源
		qualityDataSource = new ComboPooledDataSource("qualityDataSource");
		//基础数据库数据源
		basicDataSource = new ComboPooledDataSource("basicDataSource");
		//岗位人员数据库
		staffPositionsDataSource = new ComboPooledDataSource("staffPositionsDataSource");
	}
	
	/**
	 * 取得资质系统数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getQualityConnection() throws SQLException {
		return qualityDataSource.getConnection();
	}

	/**
	 * 取得基础数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getBasicConnection() throws SQLException {
		return basicDataSource.getConnection();
	}
	/**
	 * 取得岗位人员数据库链接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getStaffPositionsConnection() throws SQLException {
		return staffPositionsDataSource.getConnection();
	}
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @param pst
	 * @param rs
	 */
	public static void closeConn(Connection conn,Statement pst,ResultSet rs){  
		try{
			if(rs!=null){  
				rs.close();  
	        }  
	        if(pst!=null){  
	        	pst.close();  
	        }  
	        if(conn!=null){  
	        	conn.close();  
	        }  
		}catch (SQLException e) {
			e.printStackTrace();
		}
	} 
}
