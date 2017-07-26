package com.tj.jst.outside.business.constructionFiling.fileWorld.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.util.UtilDecode;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;

/**
 * 施工合同word模板
 * @author hhc
 *
 */
public class FileWorldDaoImpl extends BaseDao implements IFileWorldDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 查询列表业务表
	 * @return
	 */
	public List<FileWorld> queryFileWorldBusiness(String recordId,String conType)
	{
		List<FileWorld> fwList = new ArrayList<FileWorld>();
		try {
			
			String qsql = "select * from TB_CONTRACTINFO_BUSINESS where recordId=? and conType=? ";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, recordId);
			pstmt.setString(2, conType);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				FileWorld fw = new FileWorld();
				fw.setConId(rs.getString("conId"));
				fw.setConName(rs.getString("conName"));
				fw.setConType(rs.getString("conType"));
				fw.setIsLocking(rs.getString("isLocking"));
				fw.setZhConName(UtilDecode.transformation(rs.getString("conName")));
				fw.setRecordId(rs.getString("recordId"));
				fw.setTemplateId(rs.getString("templateId"));
				fw.setPnumber(rs.getInt("pnumber"));
				fwList.add(fw);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return fwList;
	}
	
	/**
	 * 查询模板表
	 */
	public List<FileWorld> queryFileWorld(String recordId,String conType)
	{
		List<FileWorld> fwList = new ArrayList<FileWorld>();
		try {
			
			String qsql = "select * from TB_CONTRACTINFO where conType=? and inCommon=1";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, conType);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				FileWorld fw = new FileWorld();
				fw.setConId(rs.getString("conId"));
				fw.setConName(rs.getString("conName"));
				fw.setZhConName(UtilDecode.transformation(rs.getString("conName")));
				fw.setConType(rs.getString("conType"));
				fw.setIsLocking("0");
				fw.setRecordId(recordId);
				fw.setCheckType("0");
				fw.setPnumber(rs.getInt("pnumber"));
				fwList.add(fw);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return fwList;
	}
	
//	public String ClobToString(Clob clob) throws SQLException, IOException {
//
//		String reString = "";
//		Reader is = clob.getCharacterStream();// 得到流
//		BufferedReader br = new BufferedReader(is);
//		String s = br.readLine();
//		StringBuffer sb = new StringBuffer();
//		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
//			sb.append(s);
//			s = br.readLine();
//		}
//		reString = sb.toString();
//		return reString;
//	}
	
	/**
	 * 查询模板表详细
	 */
	public FileWorld queryFileWorldById(String conId)
	{
		FileWorld fw = new FileWorld();
		try {
			
			String qsql = "select * from TB_CONTRACTINFO where conId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, conId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				fw.setConId(rs.getString("conId"));
				fw.setConName(rs.getString("conName"));
				fw.setZhConName(UtilDecode.transformation(rs.getString("conName")));
				fw.setConType(rs.getString("conType"));
				fw.setLinkAddress(rs.getString("linkAddress"));
				fw.setCheckType("0");
				fw.setPnumber(rs.getInt("pnumber"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return fw;
	}
	
	/**
	 * 查询业务表详细
	 */
	public FileWorld queryFileWorldBusinessById(String conId)
	{
		FileWorld fw = new FileWorld();
		try {
			
			String qsql = "select * from TB_CONTRACTINFO_BUSINESS where conId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, conId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				fw.setConId(rs.getString("conId"));
				fw.setConName(rs.getString("conName"));
				fw.setZhConName(UtilDecode.transformation(rs.getString("conName")));
				fw.setConType(rs.getString("conType"));
				//保存业务表中新生成的文件名称
				fw.setConName(rs.getString("newConName"));
				fw.setLinkAddress(rs.getString("linkAddress"));
				fw.setCreateDate(rs.getDate("createDate"));
				fw.setCheckType("1");
				fw.setRecordId(rs.getString("recordId"));
				fw.setTemplateId(rs.getString("templateId"));
				fw.setPnumber(rs.getInt("pnumber"));
			}
			
			pstmt = conn.prepareStatement("select * from "
					+ "(select * from TB_CONTRACTINFO_RECORD order by "
					+ "createdate desc) where conid=? and rownum = 1");
			pstmt.setString(1, conId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				fw.setReason(rs.getString("reason"));
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return fw;
	}
	
	/**
	 * 如果未提交，在业务表中插入数据
	 * @param fileWorld
	 */
	public String save(FileWorld fileWorld)
	{
		String conId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TB_CONTRACTINFO_BUSINESS(CONID,CONNAME,CONTYPE,"
					+ "ISLOCKING,RECORDID,CREATEDATE,TEMPLATEID,PNUMBER,LINKADDRESS,"
					+ "NEWCONNAME) values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,conId);	//主键
			pstmt.setString(2,fileWorld.getConName()); //名称
			pstmt.setString(3,fileWorld.getConType()); //合同类别
			pstmt.setString(4,"0"); //是否锁定
			pstmt.setString(5,fileWorld.getRecordId()); //合同备案主键
			pstmt.setDate(6,new Date(new java.util.Date().getTime())); //创建时间
			pstmt.setString(7, fileWorld.getConId());//模板表主键Id
			pstmt.setInt(8, fileWorld.getPnumber());
			pstmt.setString(9, fileWorld.getSaveLink());
			pstmt.setString(10, fileWorld.getNewConName());
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
		return fileWorld.getRecordId();
	}

//	/**
//	 * 如果已提交修改业务表中的数据
//	 * @param fileWorld
//	 */
//	public String update(FileWorld fileWorld)
//	{
//		
//		String sql = "update TB_CONTRACTINFO_BUSINESS set CONMESSAGE=?,templateId=?"
//				+ " where CONID=?";
//		try {
//			conn = ConnectionFactory.getBasicConnection();
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(2, fileWorld.getTemplateId());
//			pstmt.setString(3, fileWorld.getConId());
//			pstmt.executeUpdate();
//		}catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			ConnectionFactory.closeConn(conn, pstmt, null);
//		}
//		return fileWorld.getRecordId();
//	}
	
	/**
	 * 删除业务表数据还原模板
	 * @return
	 */
	public void delete(String conId)
	{
		String querySql = "select linkAddress from TB_CONTRACTINFO_BUSINESS where CONID=?";
		String sql = "delete from TB_CONTRACTINFO_BUSINESS where CONID=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(querySql);
			pstmt.setString(1, conId);// 主键
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				String linkAddress = rs.getString("linkAddress");
				File file = new File(linkAddress);
				if(file.exists())
				{
					file.delete();
				}
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, conId);// 主键
			pstmt.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
	}
	
	/**
	 * 查看
	 * @return
	 */
	public FileWorld viewDetails(String conId)
	{
		FileWorld fw = new FileWorld();
		try {
			
			String qsql = "select * from TB_CONTRACTINFO_BUSINESS where conId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, conId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				fw.setConId(rs.getString("conId"));
				fw.setConName(rs.getString("conName"));
				fw.setZhConName(UtilDecode.transformation(rs.getString("conName")));
				fw.setConType(rs.getString("conType"));
				fw.setLinkAddress(rs.getString("linkAddress"));
				fw.setCreateDate(rs.getDate("createDate"));
				fw.setCheckType("1");
				fw.setRecordId(rs.getString("recordId"));
				fw.setTemplateId(rs.getString("templateId"));
				fw.setPnumber(rs.getInt("pnumber"));
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return fw;
	}
}
