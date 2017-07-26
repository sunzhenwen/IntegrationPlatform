package com.tj.jst.base.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ�����
 * @author hhc
 *
 */
public class ConnectionFactory {
	
	//�������ݿ�����Դ
	private static ComboPooledDataSource basicDataSource;
	//��λ��Ա����Դ
	private static ComboPooledDataSource staffPositionsDataSource;
	//����ϵͳ����Դ
	private static ComboPooledDataSource qualityDataSource;
	
	private ConnectionFactory() {
	}

	static {
		//����ϵͳ����Դ
		qualityDataSource = new ComboPooledDataSource("qualityDataSource");
		//�������ݿ�����Դ
		basicDataSource = new ComboPooledDataSource("basicDataSource");
		//��λ��Ա���ݿ�
		staffPositionsDataSource = new ComboPooledDataSource("staffPositionsDataSource");
	}
	
	/**
	 * ȡ������ϵͳ���ݿ�����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getQualityConnection() throws SQLException {
		return qualityDataSource.getConnection();
	}

	/**
	 * ȡ�û������ݿ�����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getBasicConnection() throws SQLException {
		return basicDataSource.getConnection();
	}
	/**
	 * ȡ�ø�λ��Ա���ݿ�����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getStaffPositionsConnection() throws SQLException {
		return staffPositionsDataSource.getConnection();
	}
	/**
	 * �ر����ݿ�����
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
