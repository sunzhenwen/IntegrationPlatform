package com.tj.jst.outside.business.upload.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 附件上传
 * @author hhc
 *
 */
public class UploadDaoImpl extends BaseDao implements IUploadDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void add(String root,String newName,String linkName,String isUnits,String fileFileName,String id,String accessotyId)
	{
		String uploadId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into UPLOAD_FILE(uploadId,root,newName,linkName,"
					+ "isUnits,fileFileName,id,accessotyId) "
					+ "values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,uploadId);	//主键
			pstmt.setString(2, root);
			pstmt.setString(3, newName);
			pstmt.setString(4, linkName);
			pstmt.setString(5, isUnits);
			pstmt.setString(6, fileFileName);
			pstmt.setString(7, id);
			pstmt.setString(8, accessotyId);
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
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	public String[] delete(String id)
	{
		String[] uploads = new String[2];
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where uploadId=?");
			pstmt.setString(1,id);	//主键
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				uploads[0] = rs.getString("id");
				uploads[1] = rs.getString("root")+"\\"+rs.getString("newName");
			}
			
			
			String sql = "delete from UPLOAD_FILE where uploadId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);	//主键
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
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return uploads;
	}
	
	public Upload queryFile(String id)
	{
		Upload upload = new Upload();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where uploadId=?");
			pstmt.setString(1,id);	//主键
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				
				upload.setUploadId(rs.getString("uploadId"));
				upload.setFileFileName(rs.getString("fileFileName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setNewName(rs.getString("newName"));
				upload.setRoot(rs.getString("root"));
				upload.setId(rs.getString("id"));
			}
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
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return upload;
	}
}
