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
 * 合同备案统计(按合同类别)
 * @author hhc
 *
 */
public class FilingCategoryStatisticsDaoImpl extends BaseDao implements IFilingCategoryStatisticsDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 查询全部
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,String startDate,String endDate) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//勘察
		list.add(this.querySurvey(citys,startDate,endDate));
		//设计
		list.add(this.queryDesign(citys,startDate,endDate));
		//施工总包
		list.add(this.queryTheContractor(citys,startDate,endDate));
		//施工分包
		list.add(this.queryToSubcontract(citys,startDate,endDate));
		//施工劳务
		list.add(this.queryLabourServices(citys,startDate,endDate));
		//监理
		list.add(this.querySupervisor(citys,startDate,endDate));
		//一体化
		list.add(this.queryIntegrated(citys,startDate,endDate));
		//总承包
		list.add(this.queryGeneralContract(citys,startDate,endDate));
		//项目管理
		list.add(this.queryProjectManagement(citys,startDate,endDate));
		return list;
	}

	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public List<List<Integer>> queryPage(String checkNum,String check,String startDate,String endDate)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(this.querySurvey(checkNum,check,startDate,endDate));
		list.add(this.queryDesign(checkNum,check,startDate,endDate));
		list.add(this.queryTheContractor(checkNum,check,startDate,endDate));
		//施工分包
		list.add(this.queryToSubcontract(checkNum,check,startDate,endDate));
		//施工劳务
		list.add(this.queryLabourServices(checkNum,check,startDate,endDate));
		//监理
		list.add(this.querySupervisor(checkNum,check,startDate,endDate));
		//一体化
		list.add(this.queryIntegrated(checkNum,check,startDate,endDate));
		//总承包
		list.add(this.queryGeneralContract(checkNum,check,startDate,endDate));
		//项目管理
		list.add(this.queryProjectManagement(checkNum,check,startDate,endDate));
		
		return list;
	}
	
	/**
	 * 勘察(全部查询)
	 */
	public List<Integer> querySurvey(List<DictionaryClass> citys,String startDate,String endDate) {
		
		String sql = "";
		//房屋建筑工程
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
	 * 设计(全部查询)
	 */
	public List<Integer> queryDesign(List<DictionaryClass> citys,String startDate,String endDate) {
		
		String sql = "";
		//市政工程
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
	 * 施工总包(全部查询)
	 */
	public List<Integer> queryTheContractor(List<DictionaryClass> citys,String startDate,String endDate) {
		
		String sql = "";
		//其他
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
	
	//施工分包
	public List<Integer> queryToSubcontract(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//施工劳务
	public List<Integer> queryLabourServices(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//监理
	public List<Integer> querySupervisor(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//一体化
	public List<Integer> queryIntegrated(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//总承包
	public List<Integer> queryGeneralContract(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//项目管理
	public List<Integer> queryProjectManagement(List<DictionaryClass> citys,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	 * 勘察
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
	 * 设计
	 */
	public List<Integer> queryDesign(String checkNum,String check,String startDate,String endDate) {
		
		String sql = "";
		//市政工程
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
	 * 施工总包
	 */
	public List<Integer> queryTheContractor(String checkNum,String check,String startDate,String endDate) {
		
		String sql = "";
		//其他
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
	
	//施工分包
	public List<Integer> queryToSubcontract(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//施工劳务
	public List<Integer> queryLabourServices(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//监理
	public List<Integer> querySupervisor(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//一体化
	public List<Integer> queryIntegrated(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//总承包
	public List<Integer> queryGeneralContract(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	//项目管理
	public List<Integer> queryProjectManagement(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
	 * 查询地市
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
	 * 查询区
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
	 * 查询区域名称
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
	 * 查询地市名称
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
	 * 查询黑龙江省各地市的合同备案情况
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
	 * 地市合同备案查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryCityPie(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
			//分组查询房屋建筑工程、市政工程、其它
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
	 * 区县合同备案查询
	 * @param checkNum
	 * @param check
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ConstructionStatistics> queryAreaPie(String checkNum,String check,String startDate,String endDate)
	{
		String sql = "";
		//其他
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
			//分组查询房屋建筑工程、市政工程、其它
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
