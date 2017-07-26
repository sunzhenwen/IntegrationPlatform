package com.tj.jst.base.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tj.jst.base.connection.ConnectionFactory;

public class PrjNum {
	
	/**
	 * 根据项目编号查询流水号
	 */
	public static int querySerNum(String prjNum)
	{
		int serNum = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select max(SERIALNUM) as SERIALNUM from SINGLE_SERIALNUM "
					+ "where prjNum=? ";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prjNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				serNum = rs.getInt("SERIALNUM");
				int upNum = serNum;
				if(serNum<1000)
				{
					//更新
					String upSql = "update SINGLE_SERIALNUM set SERIALNUM=? "
							+ "where prjNum=? ";
					pstmt = conn.prepareStatement(upSql);
					pstmt.setInt(1, ++upNum);
					pstmt.setString(2, prjNum);
					pstmt.executeUpdate();
				}else
				{
					serNum = -1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return serNum;
	}
	
	/**
	 * 查询流水
	 * @param createDate
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String querySerNuma(Date createDate)
	{
		int serNum = 0;
		Date checkDate=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select CHECKDATE from TBSERIALNUM";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				checkDate = rs.getDate("CHECKDATE");
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String newDate = simpleDateFormat.format(checkDate);
	        String nowDate = simpleDateFormat.format(createDate);
	        if(nowDate.equals(newDate))
	        {
	        	pstmt = conn.prepareStatement("select max(SERIALNUM) as SERIALNUM from TBSERIALNUM");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					serNum = rs.getInt("SERIALNUM");
					int upNum = serNum;
					if(serNum<100)
					{
						//更新
						pstmt = conn.prepareStatement("update TBSERIALNUM set SERIALNUM=?");
						pstmt.setInt(1, ++upNum);
						pstmt.executeUpdate();
					}
				}
	        }else
	        {
	        	String upSql = "update TBSERIALNUM set SERIALNUM=?,CHECKDATE=?";
				pstmt = conn.prepareStatement(upSql);
				pstmt.setInt(1, 1);
				pstmt.setDate(2, createDate);
				pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement("select max(SERIALNUM) as SERIALNUM from TBSERIALNUM");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					serNum = rs.getInt("SERIALNUM");
					int upNum = serNum;
					if(serNum<100)
					{
						//更新
						pstmt = conn.prepareStatement("update TBSERIALNUM set SERIALNUM=?");
						pstmt.setInt(1, ++upNum);
						pstmt.executeUpdate();
					}
				}
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		if(serNum<10)
		{
			return "0"+serNum;
		}else
		{
			return serNum+"";
		}
	}
	
}
