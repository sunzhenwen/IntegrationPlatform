package com.tj.jst.inner.count.permit.dao;

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
 * 施工许可数据库类
 * 
 * @author Administrator
 *
 */
public class PermitCountDaoImpl extends BaseDao implements IPermitCountDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(List<DictionaryClass> citys,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(this.queryHouses(citys,startDate,endDate));
		list.add(this.queryMunicipals(citys,startDate,endDate));
		list.add(this.queryOthers(citys,startDate,endDate));
		return list;
	}

	/**
	 * 查询
	 */
	@Override
	public List<List<Integer>> queryPage(String checkNum, String check,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(this.queryHouses(checkNum,check,startDate,endDate));
		list.add(this.queryMunicipals(checkNum,check,startDate,endDate));
		list.add(this.queryOthers(checkNum,check,startDate,endDate));
		return list;
	}

	/**
	 * 查询区域名称
	 */
	@Override
	public List<String> queryAreaName(String areaNum) {
		// TODO Auto-generated method stub
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
	 * 查询市名称
	 */
	@Override
	public List<String> queryCityName(String cityNum) {
		// TODO Auto-generated method stub
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
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
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
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
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
	 * 其他
	 */
	public List<Integer> queryOthers(String checkNum,String check,String startDate,String endDate) {
		
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
				sql = "select count(*) as cityCount from TBBUILDERLICENCEMANAGE where apptype=1 and  prjNum in (select distinct prjNum from TBPROJECTINFO_S where citynum ='"+checkNum.trim()+"' and prjTypeNum='99')"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from TBBUILDERLICENCEMANAGE where apptype=1 and prjNum in (select distinct prjNum from TBPROJECTINFO_S where countynum ='"+checkNum.trim()+"' and prjTypeNum='99')"+sb.toString();
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
	 * 市政工程
	 */
	public List<Integer> queryMunicipals(String checkNum,String check,String startDate,String endDate) {
		
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
				sql = "select count(*) as cityCount from TBBUILDERLICENCEMANAGE where apptype=1 and prjNum in (select distinct prjNum from TBPROJECTINFO_S where citynum ='"+checkNum.trim()+"' and prjTypeNum='02')"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from TBBUILDERLICENCEMANAGE where apptype=1 and prjNum in (select distinct prjNum from TBPROJECTINFO_S where countynum ='"+checkNum.trim()+"' and prjTypeNum='02')"+sb.toString();
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
	 * 查询房屋建筑工程
	 */
	public List<Integer> queryHouses(String checkNum,String check,String startDate,String endDate) {
		
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
			if(check.equals("2"))
			{
				sql = "select count(*) as cityCount from TBBUILDERLICENCEMANAGE where apptype=1 and prjNum in (select distinct prjNum from TBPROJECTINFO_S where citynum ='"+checkNum.trim()+"' and prjTypeNum='01')"+sb.toString();
				
			}else
			{
				sql = "select count(*) as cityCount from TBBUILDERLICENCEMANAGE where apptype=1 and prjNum in (select distinct prjNum from TBPROJECTINFO_S where countynum ='"+checkNum.trim()+"' and prjTypeNum='01')"+sb.toString();
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
	 * 其他
	 */
	public List<Integer> queryOthers(List<DictionaryClass> citys,String startDate,String endDate) {
		
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
				sql = "select count(*) as cityCount from TBBUILDERLICENCEMANAGE where apptype=1 and prjNum in (select distinct prjNum from TBPROJECTINFO_S where citynum ='"+citys.get(i).getCode().trim()+"' and prjTypeNum='99')"+sb.toString();
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
	 * 市政工程
	 */
	public List<Integer> queryMunicipals(List<DictionaryClass> citys,String startDate,String endDate) {
		
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
				sql = "select count(*) as cityCount from TBBUILDERLICENCEMANAGE where apptype=1 and prjNum in (select distinct prjNum from TBPROJECTINFO_S where citynum ='"+citys.get(i).getCode().trim()+"' and prjTypeNum='02')"+sb.toString();
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
	 * 查询房屋建筑工程
	 */
	public List<Integer> queryHouses(List<DictionaryClass> citys,String startDate,String endDate) {
		
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
				sql = "select count(*) as cityCount from TBBUILDERLICENCEMANAGE where apptype=1 and prjNum in (select distinct prjNum from TBPROJECTINFO_S where citynum ='"+citys.get(i).getCode().trim()+"' and prjTypeNum='01') "+sb.toString();
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
	 * 查询黑龙江省各地市的施工许可情况
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
			sql = "select count(*) as cityCount,cityName from v_tb_bu t where apptype=1 and provinceNum='230000' group by cityName "+sb.toString();
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
	 * 地市施工许可查询
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
			sql = "select count(*) as cityCount,prjTypeNum from v_tb_bu t where apptype=1 and citynum='"+checkNum.trim()+"' group by prjTypeNum "+sb.toString();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				ConstructionStatistics cs = new ConstructionStatistics();
				String prjTypeNum = rs.getString("prjTypeNum");
				if(prjTypeNum.equals("01"))
				{
					cs.setName("房屋建筑工程");
					cs.setY(rs.getInt("cityCount"));
				}else if(prjTypeNum.equals("02"))
				{
					cs.setName("市政工程");
					cs.setY(rs.getInt("cityCount"));
				}else
				{
					cs.setName("其它");
					cs.setY(rs.getInt("cityCount"));
				}
				
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
	 * 区县施工许可查询
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
			sql = "select count(*) as cityCount,prjTypeNum from v_tb_bu t where apptype=1 and countynum='"+checkNum.trim()+"' group by prjTypeNum "+sb.toString();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				ConstructionStatistics cs = new ConstructionStatistics();
				String prjTypeNum = rs.getString("prjTypeNum");
				if(prjTypeNum.equals("01"))
				{
					cs.setName("房屋建筑工程");
					cs.setY(rs.getInt("cityCount"));
				}else if(prjTypeNum.equals("02"))
				{
					cs.setName("市政工程");
					cs.setY(rs.getInt("cityCount"));
				}else
				{
					cs.setName("其它");
					cs.setY(rs.getInt("cityCount"));
				}
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
