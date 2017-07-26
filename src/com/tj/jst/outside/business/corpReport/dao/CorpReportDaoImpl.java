package com.tj.jst.outside.business.corpReport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * 建筑企业统计报表
 * @author hhc
 *
 */
public class CorpReportDaoImpl extends BaseDao implements ICorpReportDao {

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
					CorpReport corpReport = new CorpReport();
					
					corpReport.setId(rs.getString("id"));//主键
					corpReport.setCorpCode(rs.getString("CorpCode"));//企业组织机构代码
					corpReport.setCorpName(rs.getString("CorpName"));//企业名称
					corpReport.setProvinceNum(rs.getString("ProvinceNum")); //注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					corpReport.setCityNum(rs.getString("CityNum")); 		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
					corpReport.setCountyNum(rs.getString("CountyNum")); 		//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
					corpReport.setReportYear(rs.getString("ReportYear"));//年
					corpReport.setQuarter(rs.getString("Quarter"));//季度
					corpReport.setSignContract(rs.getString("SignContract"));//签订合同额
					corpReport.setLastYearContract(rs.getString("LastYearContract"));//上年结转合同额
					corpReport.setThisYearContract(rs.getString("ThisYearContract"));//本年新签合同额
					corpReport.setTotalOutput(rs.getString("TotalOutput"));//建筑业总产值
					corpReport.setProvinceOutside(rs.getString("ProvinceOutside"));//省外
					corpReport.setAbroad(rs.getString("Abroad"));//国外
					corpReport.setConstruction(rs.getString("Construction"));//建筑工程
					corpReport.setErection(rs.getString("Erection"));//安装工程
					corpReport.setDecorate(rs.getString("Decorate"));//装饰装修工程
					corpReport.setSettlementIncome(rs.getString("SettlementIncome"));//工程结算收入
					corpReport.setSettlementCost(rs.getString("SettlementCost"));//工程结算成本
					corpReport.setAddedValue(rs.getString("AddedValue"));//增加值
					corpReport.setReward(rs.getString("Reward"));//从业人员劳动报酬
					corpReport.setTotalProfit(rs.getString("TotalProfit"));//利税总额
					corpReport.setProfit(rs.getString("Profit"));//利润总额
					corpReport.setEmployee(rs.getString("Employee"));//从业人员
					corpReport.setRegistered(rs.getString("Registered"));//注册建造师
					corpReport.setUltimate(rs.getString("Ultimate"));//中级以上职称人员
					corpReport.setPost(rs.getString("Post"));//持证岗位人员
					corpReport.setTechnology(rs.getString("Technology"));//中级以上技术工人
					corpReport.setTechnicalEquipment(rs.getString("TechnicalEquipment"));//技术装备率
					corpReport.setLaborProduction(rs.getString("LaborProduction"));//劳动生产
					corpReport.setLegalMan(rs.getString("LegalMan")); 		//单位负责人
					corpReport.setFillOut(rs.getString("FillOut"));//填表人
					corpReport.setLinkPhone(rs.getString("LinkPhone"));//联系电话
					corpReport.setCreateDate(rs.getDate("CreateDate")); 		//添加日期
					page.getData().add(corpReport);
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
	 * @param corpReport
	 * @return
	 */
	public void add(CorpReport corpReport)
	{
		String id = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into CORP_REPORT(id,corpCode,corpName,provinceNum,"
					+ "cityNum,"
					+ "countyNum,reportYear,quarter,signContract,lastYearContract,"
					+ "thisYearContract,"
					+ "totalOutput,provinceOutside,abroad,construction,erection,"
					+ "decorate,"
					+ "settlementIncome,settlementCost,addedValue,reward,totalProfit,"
					+ "profit,employee,registered,"
					+ "ultimate,post,technology,technicalEquipment,laborProduction,"
					+ "legalMan,fillOut,linkPhone,createDate) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);	//主键
			pstmt.setString(2,corpReport.getCorpCode());//企业组织机构代码
			pstmt.setString(3,corpReport.getCorpName());//企业名称
			pstmt.setString(4,corpReport.getProvinceNum()); //注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5,corpReport.getCityNum()); 		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6,corpReport.getCountyNum()); 		//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7,corpReport.getReportYear());//年
			pstmt.setString(8,corpReport.getQuarter());//季度
			pstmt.setString(9,corpReport.getSignContract());//签订合同额
			pstmt.setString(10,corpReport.getLastYearContract());//上年结转合同额
			pstmt.setString(11,corpReport.getThisYearContract());//本年新签合同额
			pstmt.setString(12,corpReport.getTotalOutput());//建筑业总产值
			pstmt.setString(13,corpReport.getProvinceOutside());//省外
			pstmt.setString(14,corpReport.getAbroad());//国外
			pstmt.setString(15,corpReport.getConstruction());//建筑工程
			pstmt.setString(16,corpReport.getErection());//安装工程
			pstmt.setString(17,corpReport.getDecorate());//装饰装修工程
			pstmt.setString(18,corpReport.getSettlementIncome());//工程结算收入
			pstmt.setString(19,corpReport.getSettlementCost());//工程结算成本
			pstmt.setString(20,corpReport.getAddedValue());//增加值
			pstmt.setString(21,corpReport.getReward());//从业人员劳动报酬
			pstmt.setString(22,corpReport.getTotalProfit());//利税总额
			pstmt.setString(23,corpReport.getProfit());//利润总额
			pstmt.setString(24,corpReport.getEmployee());//从业人员
			pstmt.setString(25,corpReport.getRegistered());//注册建造师
			pstmt.setString(26,corpReport.getUltimate());//中级以上职称人员
			pstmt.setString(27,corpReport.getPost());//持证岗位人员
			pstmt.setString(28,corpReport.getTechnology());//中级以上技术工人
			pstmt.setString(29,corpReport.getTechnicalEquipment());//技术装备率
			pstmt.setString(30,corpReport.getLaborProduction());//劳动生产
			pstmt.setString(31,corpReport.getLegalMan()); 		//单位负责人
			pstmt.setString(32,corpReport.getFillOut());//填表人
			pstmt.setString(33,corpReport.getLinkPhone());//联系电话
			pstmt.setDate(34, new Date(new java.util.Date().getTime()));//记录登记时间
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
	 * @param corpReport
	 * @return
	 */
	public CorpReport queryById(String id)
	{

		CorpReport corpReport = new CorpReport();
		try {
			
			String qsql = "select * from CORP_REPORT where id=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				corpReport.setId(rs.getString("id"));//主键
				corpReport.setCorpCode(rs.getString("CorpCode"));//企业组织机构代码
				corpReport.setCorpName(rs.getString("CorpName"));//企业名称
				corpReport.setProvinceNum(rs.getString("ProvinceNum")); //注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				corpReport.setCityNum(rs.getString("CityNum")); 		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				corpReport.setCountyNum(rs.getString("CountyNum")); 		//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				corpReport.setReportYear(rs.getString("ReportYear"));//年
				corpReport.setQuarter(rs.getString("Quarter"));//季度
				corpReport.setSignContract(rs.getString("SignContract"));//签订合同额
				corpReport.setLastYearContract(rs.getString("LastYearContract"));//上年结转合同额
				corpReport.setThisYearContract(rs.getString("ThisYearContract"));//本年新签合同额
				corpReport.setTotalOutput(rs.getString("TotalOutput"));//建筑业总产值
				corpReport.setProvinceOutside(rs.getString("ProvinceOutside"));//省外
				corpReport.setAbroad(rs.getString("Abroad"));//国外
				corpReport.setConstruction(rs.getString("Construction"));//建筑工程
				corpReport.setErection(rs.getString("Erection"));//安装工程
				corpReport.setDecorate(rs.getString("Decorate"));//装饰装修工程
				corpReport.setSettlementIncome(rs.getString("SettlementIncome"));//工程结算收入
				corpReport.setSettlementCost(rs.getString("SettlementCost"));//工程结算成本
				corpReport.setAddedValue(rs.getString("AddedValue"));//增加值
				corpReport.setReward(rs.getString("Reward"));//从业人员劳动报酬
				corpReport.setTotalProfit(rs.getString("TotalProfit"));//利税总额
				corpReport.setProfit(rs.getString("Profit"));//利润总额
				corpReport.setEmployee(rs.getString("Employee"));//从业人员
				corpReport.setRegistered(rs.getString("Registered"));//注册建造师
				corpReport.setUltimate(rs.getString("Ultimate"));//中级以上职称人员
				corpReport.setPost(rs.getString("Post"));//持证岗位人员
				corpReport.setTechnology(rs.getString("Technology"));//中级以上技术工人
				corpReport.setTechnicalEquipment(rs.getString("TechnicalEquipment"));//技术装备率
				corpReport.setLaborProduction(rs.getString("LaborProduction"));//劳动生产
				corpReport.setLegalMan(rs.getString("LegalMan")); 		//单位负责人
				corpReport.setFillOut(rs.getString("FillOut"));//填表人
				corpReport.setLinkPhone(rs.getString("LinkPhone"));//联系电话
				corpReport.setCreateDate(rs.getDate("CreateDate")); 		//添加日期
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corpReport;
	}
	
	/**
	 * 修改
	 * @param corpReport
	 * @return
	 */
	public void modify(CorpReport corpReport)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update CORP_REPORT set corpCode=?,corpName=?,provinceNum=?,"
					+ "cityNum=?,"
					+ "countyNum=?,reportYear=?,quarter=?,signContract=?,lastYearContract=?,"
					+ "thisYearContract=?,"
					+ "totalOutput=?,provinceOutside=?,abroad=?,construction=?,erection=?,"
					+ "decorate=?,"
					+ "settlementIncome=?,settlementCost=?,addedValue=?,reward=?,totalProfit=?,"
					+ "profit=?,employee=?,registered=?,"
					+ "ultimate=?,post=?,technology=?,technicalEquipment=?,laborProduction=?,"
					+ "legalMan=?,fillOut=?,linkPhone=? where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,corpReport.getCorpCode());//企业组织机构代码
			pstmt.setString(2,corpReport.getCorpName());//企业名称
			pstmt.setString(3,corpReport.getProvinceNum()); //注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(4,corpReport.getCityNum()); 		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(5,corpReport.getCountyNum()); 		//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(6,corpReport.getReportYear());//年
			pstmt.setString(7,corpReport.getQuarter());//季度
			pstmt.setString(8,corpReport.getSignContract());//签订合同额
			pstmt.setString(9,corpReport.getLastYearContract());//上年结转合同额
			pstmt.setString(10,corpReport.getThisYearContract());//本年新签合同额
			pstmt.setString(11,corpReport.getTotalOutput());//建筑业总产值
			pstmt.setString(12,corpReport.getProvinceOutside());//省外
			pstmt.setString(13,corpReport.getAbroad());//国外
			pstmt.setString(14,corpReport.getConstruction());//建筑工程
			pstmt.setString(15,corpReport.getErection());//安装工程
			pstmt.setString(16,corpReport.getDecorate());//装饰装修工程
			pstmt.setString(17,corpReport.getSettlementIncome());//工程结算收入
			pstmt.setString(18,corpReport.getSettlementCost());//工程结算成本
			pstmt.setString(19,corpReport.getAddedValue());//增加值
			pstmt.setString(20,corpReport.getReward());//从业人员劳动报酬
			pstmt.setString(21,corpReport.getTotalProfit());//利税总额
			pstmt.setString(22,corpReport.getProfit());//利润总额
			pstmt.setString(23,corpReport.getEmployee());//从业人员
			pstmt.setString(24,corpReport.getRegistered());//注册建造师
			pstmt.setString(25,corpReport.getUltimate());//中级以上职称人员
			pstmt.setString(26,corpReport.getPost());//持证岗位人员
			pstmt.setString(27,corpReport.getTechnology());//中级以上技术工人
			pstmt.setString(28,corpReport.getTechnicalEquipment());//技术装备率
			pstmt.setString(29,corpReport.getLaborProduction());//劳动生产
			pstmt.setString(30,corpReport.getLegalMan()); 		//单位负责人
			pstmt.setString(31,corpReport.getFillOut());//填表人
			pstmt.setString(32,corpReport.getLinkPhone());//联系电话
			pstmt.setString(33,corpReport.getId());	//主键
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
	public void delete(String id)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from CORP_REPORT where id=? ";
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
	
}
