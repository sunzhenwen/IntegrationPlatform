package com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.dao;

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
import com.tj.jst.outside.business.contractFiling.model.Certdetail;

/**
 * 查询外省备案企业拥有资质
 * 
 * @author Administrator
 *
 */
public class QueryOtherCorpCertDaoImpl extends BaseDao implements IQueryOtherCorpCertDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Certdetail cert = new Certdetail();
					cert.setId(rs.getString("certdetailid"));
					cert.setCorpCode(rs.getString("corpCode"));
					cert.setCorpName(rs.getString("corpName"));
					cert.setCertNum(rs.getString("certId"));
					cert.setCertName(rs.getString("certTypeName"));
					cert.setTradeTypeName(rs.getString("tradeTypeName"));
					cert.setTradeBoundName(rs.getString("tradeBoundName"));
					cert.setTitleLevel(rs.getString("titleLevel"));
					cert.setDataSource(rs.getString("dataSource"));
					page.getData().add(cert);
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

	//资质资格类型(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> qualificationsTypes()
	{
		String sql = "select * from TBAPTITUDEKINDDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("qualificationstype"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//资质资格序列
	public List<DictionaryClass> queryTradeTypeNum(String requirement)
	{
		String sql = "select * from TBTRADETYPEDIC where code like '"+requirement+"%'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("CODENAME"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//资质资格等级(TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryRating(String requirement)
	{
		String sql = "select * from TBCERTTITLELEVELDIC where qualificationstype='"+requirement+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("rating"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	/**
	 * 专业类别(TBTRADETYPEBOUNDDIC)
	 * @return
	 */
	public List<DictionaryClass> specialtyType(String specialtyType)
	{
		String sql = "select * from TBTRADETYPEBOUNDDIC where code like '"+specialtyType+"%'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("specialtytype"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//添加
	public void add(Certdetail certdetail)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			// 取消自动提交
            conn.setAutoCommit(false);
            
            String sql = "insert into TBCorpCertdetailinfo "
            		+ "(CertID,CorpCode,corpname,corpId,CertTypeNum,TradeTypeNum,"
            		+ "TradeBoundNum,TitleLevelNum,IsMaster,NoteNumber,"
            		+ "NoteDate,addtypenum,oldornew,datasource,certdetailid) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERT_SEQ.nextval)";
            
            String sql1 = "insert into TBCorpCertinfo "
					+ "(CertID,CertTypeNum,TitleLevelNum,CorpId,CorpName,CorpCode,"
					+ "OrganName,OrganDate,EndDate,"
					+ "IsValid,oldornew,datasource,corpCertid) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql,new String[]{"certdetailid"});
            pstmt.setString(1,certdetail.getCertId());//证书编号
            pstmt.setString(2,certdetail.getCorpCode()); //企业组织机构代码
            pstmt.setString(3,certdetail.getCorpName());//企业名称
            pstmt.setString(4, certdetail.getCorpId());//企业主键
            pstmt.setInt(5,Integer.parseInt(certdetail.getQualificationsType()));//资质资格类型
            pstmt.setInt(6,Integer.parseInt(certdetail.getTradeTypeNum()));//资质资格序列
            pstmt.setInt(7,Integer.parseInt(certdetail.getSpecialtyType()));//专业类别
            pstmt.setInt(8,Integer.parseInt(certdetail.getTitleLevelNum()));//资质资格等级
            if("".equals(certdetail.getIsMaster()))
            {
            	pstmt.setInt(9,-1); //是否主项资质
            }else
            {
            	pstmt.setInt(9,Integer.parseInt(certdetail.getIsMaster())); //是否主项资质
            }
            pstmt.setString(10, certdetail.getNoteNumber()); //首次批准资质资格文号
            pstmt.setDate(11,certdetail.getNoteDate()); //首次批准资质资格日期
            pstmt.setString(12,"001"); //资质取得方式
            pstmt.setString(13,"1"); //新老数据
            pstmt.setString(14,"09"); //数据来源 09：外省企业手动添加
            pstmt.executeUpdate();
            rs=pstmt.getGeneratedKeys();  
            rs.next();  
            int id=rs.getInt(1);  
            
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,certdetail.getCertId());//证书编号
			pstmt.setInt(2,Integer.parseInt(certdetail.getQualificationsType()));//资质资格类型
			pstmt.setInt(3,Integer.parseInt(certdetail.getTitleLevelNum()));//资质资格等级
			pstmt.setString(4,certdetail.getCertId());//证书编号
			pstmt.setString(5,certdetail.getCorpName());//企业名称
            pstmt.setString(6,certdetail.getCorpCode()); //企业组织机构代码
            pstmt.setString(7,certdetail.getOrganName()); //发证机关
            pstmt.setDate(8,certdetail.getOrganDate()); //发证日期
            pstmt.setDate(9,certdetail.getEndDate()); //证书有效期截止日期
            pstmt.setInt(10,1); //证书状态
            pstmt.setString(11, "1");//新老数据
            pstmt.setString(12, "09");//数据 09：外省企业手动添加
            pstmt.setInt(13, id);//主键
            pstmt.executeUpdate();
			
            conn.commit();
		}catch (SQLException e) {
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
	}
	
	//删除
	public void deleteCer(String id)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			// 取消自动提交
            conn.setAutoCommit(false);
            
            String sql = "delete from TBCorpCertdetailinfo where certdetailid=? ";
            String sql1 = "delete from TBCorpCertinfo where corpCertid=? ";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(id));
            pstmt.executeUpdate();
           
            
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1,Integer.parseInt(id));
			pstmt.executeUpdate();
			
            conn.commit();
		}catch (SQLException e) {
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
}
