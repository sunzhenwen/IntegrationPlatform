package com.tj.jst.outside.business.authorization.dao;

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
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.authorization.model.Authorization;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 授权
 * @author hhc
 *
 */
public class AuthorizationDaoImpl extends BaseDao implements IAuthorizationDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					Authorization au = new Authorization();
					au.setId(rs.getString("id"));
					au.setPrjId(rs.getString("prjId"));//主键
					au.setPrjNum(rs.getString("prjNum"));//项目编号
					au.setPrjName(rs.getString("prjName"));//项目名称
					au.setCorpCode(rs.getString("corpCode"));
					au.setCorpName(rs.getString("corpName"));
					au.setAppDept(rs.getString("appDept"));//审批单位id
					au.setAppDeptName(rs.getString("appDeptName"));//审批单位名称
					au.setAuCorpCode(rs.getString("auCorpCode"));
					au.setAuCorpName(rs.getString("auCorpName"));
					au.setEnterpriseType(rs.getString("enterpriseType"));//企业类型
					page.getData().add(au);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * 授权
	 * @param construction
	 * @return
	 */
	public void add(Authorization authorization)
	{
		String id = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TO_AUTHORIZATION(id,prjId,prjNum,prjName,"
					+ "appDept,appDeptName,corpName,corpCode,auCorpName,"
					+ "auCorpCode,enterpriseType,createDate) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);	//主键
			pstmt.setString(2, authorization.getPrjId());//项目报建主键
			pstmt.setString(3, authorization.getPrjNum());//项目编号
			pstmt.setString(4, authorization.getPrjName()); //项目名称
			pstmt.setString(5, authorization.getAppDept());//审批单位id
			pstmt.setString(6, authorization.getAppDeptName());//审批单位名称
			pstmt.setString(7, authorization.getCorpName());//企业名称
			pstmt.setString(8, authorization.getCorpCode());//企业组织机构代码
			pstmt.setString(9, authorization.getAuCorpName());
			pstmt.setString(10, authorization.getAuCorpCode());
			pstmt.setString(11, authorization.getEnterpriseType());
			pstmt.setDate(12, new Date(new java.util.Date().getTime()));
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
	
	/**
	 * 取消
	 * @return
	 */
	public void delete(String id)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TO_AUTHORIZATION where id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);//主键
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) 
		{
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
	}
	
	/**
	 * 查询被授权的项目
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					Construction construction = new Construction();
					construction.setPrjId(rs.getString("prjId"));//主键
					construction.setPrjNum(rs.getString("prjNum"));//项目编号
					construction.setPrjName(rs.getString("prjName"));//项目名称
					construction.setCreateDate(rs.getDate("createDate"));
					construction.setAppDept(rs.getString("appDept"));//审批单位
					construction.setAppDeptName(rs.getString("appDeptName"));//审批单位名称
					construction.setBuildCorpName(rs.getString("buildCorpName"));
					construction.setBuildCorpCode(rs.getString("buildCorpCode"));
					page.getData().add(construction);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}
	
	/**
	 * 查询企业
	 * @param condition
	 * @return
	 */
	public Page pagedCorpQuery(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					Corp construction = new Corp();
					construction.setCorpName(rs.getString("corpName"));
					construction.setCorpCode(rs.getString("corpCode"));
					page.getData().add(construction);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}
	
	public List<DictionaryClass>  queryEnterpriseTypes()
	{
		// TODO Auto-generated method stub
		String sql = "select * from ENTERPRISE_TYPE";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("id").trim());
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
}
