package com.tj.jst.inner.statistics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.statistics.model.ConstructionStatistics;

/**
 * ��ͬ����ͳ��(����ͬ���)
 * @author hhc
 *
 */
public class FilingCategoryStatisticsDaoImpl extends BaseDao implements IFilingCategoryStatisticsDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * ��ѯȫ��
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,String startDate,String endDate) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//����
		list.add(this.querySurvey(citys,startDate,endDate));
		//���
		list.add(this.queryDesign(citys,startDate,endDate));
		//ʩ���ܰ�
		list.add(this.queryTheContractor(citys,startDate,endDate));
		//ʩ���ְ�
		list.add(this.queryToSubcontract(citys,startDate,endDate));
		//ʩ������
		list.add(this.queryLabourServices(citys,startDate,endDate));
		//����
		list.add(this.querySupervisor(citys,startDate,endDate));
		//һ�廯
		list.add(this.queryIntegrated(citys,startDate,endDate));
		//�ܳа�
		list.add(this.queryGeneralContract(citys,startDate,endDate));
		//��Ŀ����
		list.add(this.queryProjectManagement(citys,startDate,endDate));
		return list;
	}

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(String checkNum,String check,String startDate,String endDate)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(this.querySurvey(checkNum,check,startDate,endDate));
		list.add(this.queryDesign(checkNum,check,startDate,endDate));
		list.add(this.queryTheContractor(checkNum,check,startDate,endDate));
		//ʩ���ְ�
		list.add(this.queryToSubcontract(checkNum,check,startDate,endDate));
		//ʩ������
		list.add(this.queryLabourServices(checkNum,check,startDate,endDate));
		//����
		list.add(this.querySupervisor(checkNum,check,startDate,endDate));
		//һ�廯
		list.add(this.queryIntegrated(checkNum,check,startDate,endDate));
		//�ܳа�
		list.add(this.queryGeneralContract(checkNum,check,startDate,endDate));
		//��Ŀ����
		list.add(this.queryProjectManagement(checkNum,check,startDate,endDate));
		
		return list;
	}
	
	/**
	 * ����(ȫ����ѯ)
	 */
	public List<Integer> querySurvey(List<DictionaryClass> citys,String startDate,String endDate) {
		
		String sql = "";
		//���ݽ�������
		List<Integer> houses = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			
			for(int i=0;i<citys.size();i++)
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+citys.get(i).getCode().trim()+"' and contracttypenum='100' and apptype=1 "+sb.toString();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					houses.add(rs.getInt("cityCount"));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return houses;
	}
	
	/**
	 * ���(ȫ����ѯ)
	 */
	public List<Integer> queryDesign(List<DictionaryClass> citys,String startDate,String endDate) {
		
		String sql = "";
		//��������
		List<Integer> municipals = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			for(int i=0;i<citys.size();i++)
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+citys.get(i).getCode().trim()+"' and contracttypenum='200' and apptype=1"+sb.toString();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					municipals.add(rs.getInt("cityCount"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return municipals;
	}
	
	/**
	 * ʩ���ܰ�(ȫ����ѯ)
	 */
	public List<Integer> queryTheContractor(List<DictionaryClass> citys,String startDate,String endDate) {
		
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			for(int i=0;i<citys.size();i++)
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+citys.get(i).getCode().trim()+"' and contracttypenum='301' and apptype=1"+sb.toString();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					others.add(rs.getInt("cityCount"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	
	//ʩ���ְ�
	public List<Integer> queryToSubcontract(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			for(int i=0;i<citys.size();i++)
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+citys.get(i).getCode().trim()+"' and contracttypenum='302' and apptype=1"+sb.toString();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					others.add(rs.getInt("cityCount"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//ʩ������
	public List<Integer> queryLabourServices(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			for(int i=0;i<citys.size();i++)
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+citys.get(i).getCode().trim()+"' and contracttypenum='303' and apptype=1"+sb.toString();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					others.add(rs.getInt("cityCount"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//����
	public List<Integer> querySupervisor(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			for(int i=0;i<citys.size();i++)
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+citys.get(i).getCode().trim()+"' and contracttypenum='400' and apptype=1"+sb.toString();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					others.add(rs.getInt("cityCount"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//һ�廯
	public List<Integer> queryIntegrated(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			for(int i=0;i<citys.size();i++)
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+citys.get(i).getCode().trim()+"' and contracttypenum='500' and apptype=1"+sb.toString();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					others.add(rs.getInt("cityCount"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//�ܳа�
	public List<Integer> queryGeneralContract(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			for(int i=0;i<citys.size();i++)
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+citys.get(i).getCode().trim()+"' and contracttypenum='600' and apptype=1"+sb.toString();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					others.add(rs.getInt("cityCount"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//��Ŀ����
	public List<Integer> queryProjectManagement(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			for(int i=0;i<citys.size();i++)
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+citys.get(i).getCode().trim()+"' and contracttypenum='700' and apptype=1"+sb.toString();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					others.add(rs.getInt("cityCount"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ����
	 */
	public List<Integer> querySurvey(String checkNum,String check,String startDate,String endDate) {
		
		String sql = "";
		List<Integer> houses = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+checkNum.trim()+"' and contracttypenum='100' and apptype=1"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where countynum ='"+checkNum.trim()+"' and contracttypenum='100' and apptype=1"+sb.toString();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				houses.add(rs.getInt("cityCount"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return houses;
	}
	
	/**
	 * ���
	 */
	public List<Integer> queryDesign(String checkNum,String check,String startDate,String endDate) {
		
		String sql = "";
		//��������
		List<Integer> municipals = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+checkNum.trim()+"' and contracttypenum='200' and apptype=1"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where countynum ='"+checkNum.trim()+"' and contracttypenum='200' and apptype=1"+sb.toString();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				municipals.add(rs.getInt("cityCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return municipals;
	}
	
	/**
	 * ʩ���ܰ�
	 */
	public List<Integer> queryTheContractor(String checkNum,String check,String startDate,String endDate) {
		
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+checkNum.trim()+"' and contracttypenum='301' and apptype=1"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where countynum ='"+checkNum.trim()+"' and contracttypenum='301' and apptype=1"+sb.toString();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				others.add(rs.getInt("cityCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	
	//ʩ���ְ�
	public List<Integer> queryToSubcontract(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+checkNum.trim()+"' and contracttypenum='302' and apptype=1"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where countynum ='"+checkNum.trim()+"' and contracttypenum='302' and apptype=1"+sb.toString();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				others.add(rs.getInt("cityCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//ʩ������
	public List<Integer> queryLabourServices(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+checkNum.trim()+"' and contracttypenum='303' and apptype=1"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where countynum ='"+checkNum.trim()+"' and contracttypenum='303' and apptype=1"+sb.toString();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				others.add(rs.getInt("cityCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//����
	public List<Integer> querySupervisor(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+checkNum.trim()+"' and contracttypenum='400' and apptype=1"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where countynum ='"+checkNum.trim()+"' and contracttypenum='400' and apptype=1"+sb.toString();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				others.add(rs.getInt("cityCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//һ�廯
	public List<Integer> queryIntegrated(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+checkNum.trim()+"' and contracttypenum='500' and apptype=1"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where countynum ='"+checkNum.trim()+"' and contracttypenum='500' and apptype=1"+sb.toString();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				others.add(rs.getInt("cityCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//�ܳа�
	public List<Integer> queryGeneralContract(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+checkNum.trim()+"' and contracttypenum='600' and apptype=1"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where countynum ='"+checkNum.trim()+"' and contracttypenum='600' and apptype=1"+sb.toString();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				others.add(rs.getInt("cityCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	//��Ŀ����
	public List<Integer> queryProjectManagement(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<Integer> others = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where citynum ='"+checkNum.trim()+"' and contracttypenum='700' and apptype=1"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from v_tbcontractrecordmanage where countynum ='"+checkNum.trim()+"' and contracttypenum='700' and apptype=1"+sb.toString();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				others.add(rs.getInt("cityCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return others;
	}
	
	
	
	/**
	 * ��ѯ����
	 * @param construction
	 * @return
	 */
	public List<DictionaryClass> queryCitys()
	{
		String sql = "select * from TBXZQDMDIC where code like '23%00' and code != '230000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
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
	 * ��ѯ��
	 */
	public List<DictionaryClass> queryArea(String cityId) {
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		if(!cityId.equals(""))
		{
			String star = cityId.substring(0, 4);
			String sql = "select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+cityId+"'";
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DictionaryClass dictionaryClass = new DictionaryClass();
					dictionaryClass.setCode(rs.getString("code"));
					dictionaryClass.setName(rs.getString("name"));
					list.add(dictionaryClass);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}
		}
		return list;
	}
	
	/**
	 * ��ѯ��������
	 * @param areaNum
	 * @return
	 */
	public List<String> queryAreaName(String areaNum)
	{
		String sql = "select name from TBXZQDMDIC where code = '"+areaNum+"'";
		String areaName = "";
		List<String> list = new ArrayList<String>();
		try { 
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				areaName = rs.getString("name");
				list.add(areaName);
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
	 * ��ѯ��������
	 * @param areaNum
	 * @return
	 */
	public List<String> queryCityName(String cityNum)
	{
		String sql = "select name from TBXZQDMDIC where code = '"+cityNum+"'";
		String cityName = "";
		List<String> list = new ArrayList<String>();
		try { 
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				cityName = rs.getString("name");
				list.add(cityName);
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
	 * ��ѯ������ʡ�����еĺ�ͬ�������
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryPie(String startDate,String endDate)
	{
		String sql = "";
		List<ConstructionStatistics> csList = new ArrayList<ConstructionStatistics>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			sql = "select count(*) as cityCount,cityName from v_tbcontractrecordmanage t where apptype=1 and provinceNum='230000' group by cityName "+sb.toString();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				ConstructionStatistics cs = new ConstructionStatistics();
				cs.setName(rs.getString("cityName"));
				cs.setY(rs.getInt("cityCount"));
				csList.add(cs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return csList;
	}
	

	/**
	 * ���к�ͬ������ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<ConstructionStatistics> csList = new ArrayList<ConstructionStatistics>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			//�����ѯ���ݽ������̡��������̡�����
			sql = "select count(*) as cityCount,contractTypeName from v_tbcontractrecordmanage t where apptype=1 and citynum='"+checkNum.trim()+"' group by contractTypeName "+sb.toString();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				ConstructionStatistics cs = new ConstructionStatistics();
				cs.setName(rs.getString("contractTypeName"));
				cs.setY(rs.getInt("cityCount"));
				csList.add(cs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return csList;
	}
	
	/**
	 * ���غ�ͬ������ѯ
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//����
		List<ConstructionStatistics> csList = new ArrayList<ConstructionStatistics>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			StringBuffer sb = new StringBuffer("");
			if(startDate!= null && !"".equals(startDate)){
				sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
			}
			if(endDate != null && !"".equals(endDate)){
				sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
			}
			//�����ѯ���ݽ������̡��������̡�����
			sql = "select count(*) as cityCount,contractTypeName from v_tbcontractrecordmanage t where apptype=1 and countynum='"+checkNum.trim()+"' group by contractTypeName "+sb.toString();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				ConstructionStatistics cs = new ConstructionStatistics();
				cs.setName(rs.getString("contractTypeName"));
				cs.setY(rs.getInt("cityCount"));
				csList.add(cs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return csList;
	}
}
