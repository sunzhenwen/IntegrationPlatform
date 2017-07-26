package com.tj.jst.inner.business.innerSingleProject.dao;

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
import com.tj.jst.inner.business.innerSingleProject.model.InnerSingleProject;

/**
 * 单体工程
 * @author hhc
 *
 */
public class InnerSingleProjectDaoImpl extends BaseDao implements IInnerSingleProjectDao {

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
					InnerSingleProject sp = new InnerSingleProject();
					
					sp.setSpId(rs.getInt("unitid"));//主键
					sp.setPrjId(rs.getString("prjid"));//主体主键
					sp.setSpNum(rs.getString("unitcode"));//单位编码
					sp.setBuildingName(rs.getString("subprjname"));//单位建(构)筑物名称
					sp.setBuildingArea(rs.getString("buildarea"));//建筑面积(平方米)
					sp.setInvestAmount(rs.getString("invest"));//投资额(万元)
					sp.setOvergroundArea(rs.getString("floorbuildarea"));//地上建筑面积(平方米)
					sp.setUndergroundArea(rs.getString("bottomfloorbuildarea"));//地下建筑面积(平方米)
					sp.setOvergroundNum(rs.getInt("floorcount"));//地上层数
					sp.setUndergroundNum(rs.getInt("bottomfloorcount"));//地下层数
					sp.setBuildingHeight(rs.getString("buildheight"));//建筑高度(米)
					sp.setEngineeringGrade(rs.getString("prjlevelnum"));//工程等级   0:大型 1:中型  2:小型 
					sp.setLengthKm(rs.getString("subprojectlength"));//长度(公里)
					sp.setSpanM(rs.getString("subprojectspan"));//跨度(米)
					sp.setPrjStructureTypeNum(rs.getString("structuretypenum"));//结构体系(TBPRJSTRUCTURETYPEDIC)
					sp.setProjectSize(rs.getString("pjrsize"));//工程规模
					sp.setOther(rs.getString("memo"));//其它
					sp.setLinkName(rs.getString("createtype"));//产生单体的项目环节编号：3、施工图审查 4、安全监督 5、施工许可 6、竣工验收备案
					page.getData().add(sp);
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
	 * 添加
	 * @param construction
	 * @return
	 */
	public void add(InnerSingleProject sp)
	{
		String spId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTUNITINFO(unitid,prjid,unitcode,"
					+ "subprjname,buildarea,invest,floorbuildarea,bottomfloorbuildarea,"
					+ "floorcount,bottomfloorcount,buildheight,prjlevelnum,"
					+ "subprojectlength,subprojectspan,structuretypenum,pjrsize,memo,"
					+ "createtype) values(SINGLE_SEQ.Nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sp.getPrjId());//主体项目主键
			pstmt.setString(2,sp.getSpNum());//单位编码
			pstmt.setString(3,sp.getBuildingName());//单位建(构)筑物名称
			pstmt.setString(4,sp.getBuildingArea());//建筑面积(平方米)
			pstmt.setString(5,sp.getInvestAmount());//投资额(万元)
			pstmt.setString(6,sp.getOvergroundArea());//地上建筑面积(平方米)
			pstmt.setString(7,sp.getUndergroundArea());//地下建筑面积(平方米)
			pstmt.setInt(8, sp.getOvergroundNum());//地上层数
			pstmt.setInt(9, sp.getUndergroundNum());//地下层数
			pstmt.setString(10,sp.getBuildingHeight());//建筑高度(米)
			pstmt.setString(11,sp.getEngineeringGrade());//工程等级   0:大型 1:中型  2:小型 
			pstmt.setString(12,sp.getLengthKm());//长度(公里)
			pstmt.setString(13,sp.getSpanM());//跨度(米)
			pstmt.setString(14,sp.getPrjStructureTypeNum());//结构体系(TBPRJSTRUCTURETYPEDIC)
			pstmt.setString(15,sp.getProjectSize());//工程规模
			pstmt.setString(16,sp.getOther());//其它
			pstmt.setString(17,sp.getLinkName());//环节名称
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
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public InnerSingleProject queryById(Long spId)
	{

		InnerSingleProject sp = new InnerSingleProject();
		try {
			
			String qsql = "select * from TBPROJECTUNITINFO where unitid=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setLong(1, spId);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				sp.setSpId(rs.getInt("unitid"));//主键
				sp.setPrjId(rs.getString("prjid"));//主体项目主键
				sp.setSpNum(rs.getString("unitcode"));//单位编码
				sp.setBuildingName(rs.getString("subprjname"));//单位建(构)筑物名称
				sp.setBuildingArea(rs.getString("buildarea"));//建筑面积(平方米)
				sp.setInvestAmount(rs.getString("invest"));//投资额(万元)
				sp.setOvergroundArea(rs.getString("floorbuildarea"));//地上建筑面积(平方米)
				sp.setUndergroundArea(rs.getString("bottomfloorbuildarea"));//地下建筑面积(平方米)
				sp.setOvergroundNum(rs.getInt("floorcount"));//地上层数
				sp.setUndergroundNum(rs.getInt("bottomfloorcount"));//地下层数
				sp.setBuildingHeight(rs.getString("buildheight"));//建筑高度(米)
				sp.setEngineeringGrade(rs.getString("prjlevelnum"));//工程等级   0:大型 1:中型  2:小型 
				sp.setLengthKm(rs.getString("subprojectlength"));//长度(公里)
				sp.setSpanM(rs.getString("subprojectspan"));//跨度(米)
				sp.setPrjStructureTypeNum(rs.getString("structuretypenum"));//结构体系(TBPRJSTRUCTURETYPEDIC)
				sp.setProjectSize(rs.getString("pjrsize"));//工程规模
				sp.setOther(rs.getString("memo"));//其它
				sp.setLinkName(rs.getString("createtype"));//产生单体的项目环节编号：3、施工图审查 4、安全监督 5、施工许可 6、竣工验收备案
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return sp;
	}
	
	/**
	 * 修改
	 * @param construction
	 * @return
	 */
	public void modify(InnerSingleProject sp)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBPROJECTUNITINFO set subprjname=?,buildarea=?,"
					+ "invest=?,floorbuildarea=?,bottomfloorbuildarea=?,floorcount=?,"
					+ "bottomfloorcount=?,buildheight=?,prjlevelnum=?,"
					+ "subprojectlength=?,subprojectspan=?,structuretypenum=?,"
					+ "pjrsize=?,memo=? where unitid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sp.getBuildingName());//单位建(构)筑物名称
			pstmt.setString(2,sp.getBuildingArea());//建筑面积(平方米)
			pstmt.setString(3,sp.getInvestAmount());//投资额(万元)
			pstmt.setString(4,sp.getOvergroundArea());//地上建筑面积(平方米)
			pstmt.setString(5,sp.getUndergroundArea());//地下建筑面积(平方米)
			pstmt.setInt(6, sp.getOvergroundNum());//地上层数
			pstmt.setInt(7, sp.getUndergroundNum());//地下层数
			pstmt.setString(8,sp.getBuildingHeight());//建筑高度(米)
			pstmt.setString(9,sp.getEngineeringGrade());//工程等级   0:大型 1:中型  2:小型 
			pstmt.setString(10,sp.getLengthKm());//长度(公里)
			pstmt.setString(11,sp.getSpanM());//跨度(米)
			pstmt.setString(12,sp.getPrjStructureTypeNum());//结构体系(TBPRJSTRUCTURETYPEDIC)
			pstmt.setString(13,sp.getProjectSize());//工程规模
			pstmt.setString(14,sp.getOther());//其它
			pstmt.setLong(15, sp.getSpId());
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
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(Long id)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTUNITINFO where unitid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);//主键
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
	
	//结构体系(字典表：TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		String sql = "select * from TBPRJSTRUCTURETYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("struct"));
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

}
