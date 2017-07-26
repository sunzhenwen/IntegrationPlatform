package com.tj.jst.base.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.tj.jst.base.connection.ConnectionFactory;

/**
 * 项目分项流水号
 * 
 * @author DarkFlameMaster
 *
 */
public class PrjCode {

	/**
	 * 查询流水
	 * 
	 * @param createDate
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String querySerNuma(Date createDate, int typeNum) {
		// 1.设计阶段
		// 2.勘察阶段
		// 3.合同备案
		// 4.施工图审查
		// 5.质量监督
		// 6.安全监督
		// 7.施工许可
		// 8.竣工验收
		int serNum = 0;
		Date checkDate = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select CHECKDATE from TBPROJECTSERIALNUM where TYPECODE = '"
					+ typeNum + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				checkDate = rs.getDate("CHECKDATE");
			} 
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			String newDate = simpleDateFormat.format(checkDate);
			String nowDate = simpleDateFormat.format(createDate);
			if (nowDate.equals(newDate)) {
				pstmt = conn
						.prepareStatement("select max(SERNUM) as SERNUM from TBPROJECTSERIALNUM where TYPECODE = '"
								+ typeNum + "' ");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					serNum = rs.getInt("SERNUM");
					int upNum = serNum;
					if (serNum < 1000) {
						// 更新
						pstmt = conn
								.prepareStatement("update TBPROJECTSERIALNUM set SERNUM=? where TYPECODE = '"
										+ typeNum + "' ");
						pstmt.setInt(1, ++upNum);
						pstmt.executeUpdate();
					}
				}
			} else {
				String upSql = "update TBPROJECTSERIALNUM set SERNUM=?,CHECKDATE=? where TYPECODE = '"
						+ typeNum + "'";
				pstmt = conn.prepareStatement(upSql);
				pstmt.setInt(1, 1);
				pstmt.setDate(2, createDate);
				pstmt.executeUpdate();

				pstmt = conn
						.prepareStatement("select max(SERNUM) as SERNUM from TBPROJECTSERIALNUM where TYPECODE = '"
								+ typeNum + "'");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					serNum = rs.getInt("SERNUM");
					int upNum = serNum;
					if (serNum < 1000) {
						// 更新
						pstmt = conn
								.prepareStatement("update TBPROJECTSERIALNUM set SERNUM=? where TYPECODE = '"
										+ typeNum + "'");
						pstmt.setInt(1, ++upNum);
						pstmt.executeUpdate();
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		if (serNum < 100) {
			return "00" + serNum;
		} else {
			return serNum + "";
		}
	}

}
