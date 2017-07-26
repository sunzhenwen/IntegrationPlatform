package com.tj.jst.base.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;

/**
 * ����daoʵ����
 * @author Administrator
 *
 */
public class BaseDao {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int count;
	
	/**
	 * �������ݿ��ҳ
	 * @param p_condition
	 * @return
	 */
	public Page basePagedQuery(Condition p_condition) {
		//��ȡ��ǰҳ
		int _pageNo = p_condition.getPageNo();
		//ÿҳ�����ļ�¼��
		int _pageSize = p_condition.getPageSize();
		//��ѯ�ܼ�¼��
		long _totalCount = this.count(p_condition);
		if (_totalCount < 1)
		{
			return new Page();
		}
		
		//��ȡ��ȡ�±�
		int _startIndex = Page.getStartOfPage(_pageNo, _pageSize);

		// if startIndex >= totalCount then go to the last page
		if (_startIndex >= _totalCount) {
			return this.lastOfPagedQuery(p_condition);
		}
		
		String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM ("+p_condition.getCompleteSql()+") A WHERE ROWNUM <= '"+Page.getEndOfPage(_startIndex,_pageSize)+"')WHERE RN > '"+_startIndex+"'";
		
		List list = new ArrayList();
		try { 
        	conn = ConnectionFactory.getBasicConnection();
        	pstmt = conn.prepareStatement(sql);
        	rs = pstmt.executeQuery(sql);
        } catch (SQLException e) {
        	ConnectionFactory.closeConn(conn, pstmt, rs);
			e.printStackTrace();
		}
		return new Page(_startIndex, _totalCount, _pageSize, p_condition.getOrderByItem(), conn,pstmt,rs,list);
	}
//	
//	/**
//	 * һ�廯ƽ̨���ݿ��ҳ
//	 * @param p_condition
//	 * @return
//	 */
//	public Page qualityPagedQuery(Condition p_condition) {
//		//��ȡ��ǰҳ
//		int _pageNo = p_condition.getPageNo();
//		//ÿҳ�����ļ�¼��
//		int _pageSize = p_condition.getPageSize();
//		//��ѯ�ܼ�¼��
//		long _totalCount = this.qualityCount(p_condition);
//		if (_totalCount < 1)
//		{
//			return new Page();
//		}
//		
//		//��ȡ��ȡ�±�
//		int _startIndex = Page.getStartOfPage(_pageNo, _pageSize);
//
//		// if startIndex >= totalCount then go to the last page
//		if (_startIndex >= _totalCount) {
//			return this.lastQualityOfPagedQuery(p_condition);
//		}
//		
//		String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM ("+p_condition.getCompleteSql()+") A WHERE ROWNUM <= '"+Page.getEndOfPage(_startIndex,_pageSize)+"')WHERE RN > '"+_startIndex+"'";
//		List list = new ArrayList();
//		try { 
//        	conn = ConnectionFactory.getQualityConnection();
//        	pstmt = conn.prepareStatement(sql);
//        	rs = pstmt.executeQuery(sql);
//        } catch (SQLException e) {
//        	ConnectionFactory.closeConn(conn, pstmt, rs);
//			e.printStackTrace();
//		}
//		return new Page(_startIndex, _totalCount, _pageSize, p_condition.getOrderByItem(), conn,pstmt,rs,list);
//	}
//	
//	/**  ͳ�Ʋ�ѯҳ�� **/
//	private long qualityCount(Condition p_condition) {
//		String countsql = p_condition.getCompleteCountSql();
//		try {
//			conn = ConnectionFactory.getQualityConnection();
//			pstmt = conn.prepareStatement(countsql);
//			rs = pstmt.executeQuery();
//			if(rs.next())
//			{
//				count = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally
//		{
//			ConnectionFactory.closeConn(conn, pstmt, rs);
//		}
//		return count;
//	}
//	
	/**  ͳ�Ʋ�ѯҳ�� **/
	private long count(Condition p_condition) {
		String countsql = p_condition.getCompleteCountSql();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(countsql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return count;
	}
	
	public Page lastOfPagedQuery(Condition condition) {
		long totalCount = this.count(condition);
		int pageNo;
		if (totalCount % condition.getPageSize() == 0)
		{
			pageNo = new Long(totalCount / condition.getPageSize()).intValue();
		}else{
			pageNo = new Long(totalCount / condition.getPageSize() + 1).intValue();
		}
		condition.setPageNo(pageNo);
		return basePagedQuery(condition);
		
	}
//	
//	public Page lastQualityOfPagedQuery(Condition condition) {
//		long totalCount = this.qualityCount(condition);
//		int pageNo;
//		if (totalCount % condition.getPageSize() == 0)
//		{
//			pageNo = new Long(totalCount / condition.getPageSize()).intValue();
//		}else{
//			pageNo = new Long(totalCount / condition.getPageSize() + 1).intValue();
//		}
//		condition.setPageNo(pageNo);
//		return qualityPagedQuery(condition);
//		
//	}


//	/**
//	 * ��λ��Ա���ݿ��ҳ(sql2005��ҳ)
//	 * @param p_condition
//	 * @return
//	 */
//	public Page positionsPagedQuery(Condition p_condition) {
//		//��ȡ��ǰҳ
//		int _pageNo = p_condition.getPageNo();
//		//ÿҳ�����ļ�¼��
//		int _pageSize = p_condition.getPageSize();
//		//��ѯ�ܼ�¼��
//		long _totalCount = this.positionsCount(p_condition);
//		if (_totalCount < 1)
//		{
//			return new Page();
//		}
//		
//		//��ȡ��ȡ�±�
//		int _startIndex = Page.getStartOfPage(_pageNo, _pageSize);
//
//		// if startIndex >= totalCount then go to the last page
//		if (_startIndex >= _totalCount) {
//			return this.lastOfPositionsPagedQuery(p_condition);
//		}
//		
//		String sql = "select * from ("+p_condition.getCompleteSql()+") a where rownumber<='"+Page.getEndOfPage(_startIndex,_pageSize)+"' and rownumber>'"+_startIndex+"'";
//		List list = new ArrayList();
//		try { 
//        	conn = ConnectionFactory.getStaffPositionsConnection();
//        	pstmt = conn.prepareStatement(sql);
//        	rs = pstmt.executeQuery();
//        } catch (SQLException e) {
//        	ConnectionFactory.closeConn(conn, pstmt, rs);
//			e.printStackTrace();
//		}
//		return new Page(_startIndex, _totalCount, _pageSize, p_condition.getOrderByItem(), conn,pstmt,rs,list);
//	}
	
//	/**  ͳ�Ʋ�ѯҳ�� **/
//	private long positionsCount(Condition p_condition) {
//		String countsql = p_condition.getCompleteCountSql();
//		try {
//			conn = ConnectionFactory.getStaffPositionsConnection();
//			pstmt = conn.prepareStatement(countsql);
//			rs = pstmt.executeQuery();
//			if(rs.next())
//			{
//				count = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally
//		{
//			ConnectionFactory.closeConn(conn, pstmt, rs);
//		}
//		return count;
//	}
	
//	public Page lastOfPositionsPagedQuery(Condition condition) {
//		long totalCount = this.positionsCount(condition);
//		int pageNo;
//		if (totalCount % condition.getPageSize() == 0)
//		{
//			pageNo = new Long(totalCount / condition.getPageSize()).intValue();
//		}else{
//			pageNo = new Long(totalCount / condition.getPageSize() + 1).intValue();
//		}
//		condition.setPageNo(pageNo);
//		return positionsPagedQuery(condition);
//		
//	}
	
	//֤������
	public List<DictionaryClass> queryIdCardType() {
		String sql = "select code,papertype from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
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

	//��ҵ�Ǽ�ע������
	public List<DictionaryClass> queryEconomicNum() {
		String sql = "select code,corpregtype from TBECONTYPEDIC where code not like '%00'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
				dictionaryClass.setCode(rs.getString("code"));
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

	//ע���ʱ�����
	public List<DictionaryClass> queryPrincipalUnit() {
		String sql = "select code,currency from TBPRINCIPALUNITDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("currency"));
				dictionaryClass.setCode(rs.getString("code"));
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
	
	//��ѯ���������
	public List<DictionaryClass> queryNation() {
		// TODO Auto-generated method stub
		String sql = "select * from TBNATIONALDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("country"));
				dictionaryClass.setCode(rs.getString("code"));
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
	
	//����Ͷ��������
	public List<DictionaryClass> queryIvestor() {
		// TODO Auto-generated method stub
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		DictionaryClass dictionaryClass = new DictionaryClass();
		dictionaryClass.setName("������ҵ");
		dictionaryClass.setCode("0");
		list.add(dictionaryClass);
		DictionaryClass dictionaryClass1 = new DictionaryClass();
		dictionaryClass1.setName("������Ȼ��");
		dictionaryClass1.setCode("1");
		list.add(dictionaryClass1);
		return list;
	}
	
	//��ҵ����
	public List<DictionaryClass> queryEnterpriseTypes() {
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
	
	/**
	 * ��λ��Ա���ݿ��ҳ(sql2005��ҳ)
	 * @param p_condition
	 * @return
	 */
	public Page positionsPagedQuery(Condition p_condition) {
		//��ȡ��ǰҳ
		int _pageNo = p_condition.getPageNo();
		//ÿҳ�����ļ�¼��
		int _pageSize = p_condition.getPageSize();
		//��ѯ�ܼ�¼��
		long _totalCount = this.positionsCount(p_condition);
		if (_totalCount < 1)
		{
			return new Page();
		}
		
		//��ȡ��ȡ�±�
		int _startIndex = Page.getStartOfPage(_pageNo, _pageSize);

		// if startIndex >= totalCount then go to the last page
		if (_startIndex >= _totalCount) {
			return this.lastOfPositionsPagedQuery(p_condition);
		}
		
		String sql = "select * from ("+p_condition.getCompleteSql()+") a where rownumber<='"+Page.getEndOfPage(_startIndex,_pageSize)+"' and rownumber>'"+_startIndex+"'";
		List list = new ArrayList();
		try { 
        	conn = ConnectionFactory.getStaffPositionsConnection();
        	pstmt = conn.prepareStatement(sql);
        	rs = pstmt.executeQuery();
        } catch (SQLException e) {
        	ConnectionFactory.closeConn(conn, pstmt, rs);
			e.printStackTrace();
		}
		return new Page(_startIndex, _totalCount, _pageSize, p_condition.getOrderByItem(), conn,pstmt,rs,list);
	}
	
	/**  ͳ�Ʋ�ѯҳ�� **/
	private long positionsCount(Condition p_condition) {
		String countsql = p_condition.getCompleteCountSql();
		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(countsql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return count;
	}
	
	public Page lastOfPositionsPagedQuery(Condition condition) {
		long totalCount = this.positionsCount(condition);
		int pageNo;
		if (totalCount % condition.getPageSize() == 0)
		{
			pageNo = new Long(totalCount / condition.getPageSize()).intValue();
		}else{
			pageNo = new Long(totalCount / condition.getPageSize() + 1).intValue();
		}
		condition.setPageNo(pageNo);
		return positionsPagedQuery(condition);
		
	}
}