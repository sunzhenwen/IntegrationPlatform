package com.tj.jst.inner.querycorpreport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * 企业统计报表数据库类
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryCorpReportDaoImpl extends BaseDao implements
		IQueryCorpReportDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页类
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					CorpReport corpReport = new CorpReport();

					corpReport.setId(rs.getString("id"));// 主键
					corpReport.setCorpCode(rs.getString("CorpCode"));// 企业组织机构代码
					corpReport.setCorpName(rs.getString("CorpName"));// 企业名称
					corpReport.setProvinceNum(rs.getString("ProvinceNum")); // 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					corpReport.setCityNum(rs.getString("CityNum")); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
					corpReport.setCountyNum(rs.getString("CountyNum")); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
					corpReport.setReportYear(rs.getString("ReportYear"));// 年
					corpReport.setQuarter(rs.getString("Quarter"));// 季度
					corpReport.setSignContract(rs.getString("SignContract"));// 签订合同额
					corpReport.setLastYearContract(rs
							.getString("LastYearContract"));// 上年结转合同额
					corpReport.setThisYearContract(rs
							.getString("ThisYearContract"));// 本年新签合同额
					corpReport.setTotalOutput(rs.getString("TotalOutput"));// 建筑业总产值
					corpReport.setProvinceOutside(rs
							.getString("ProvinceOutside"));// 省外
					corpReport.setAbroad(rs.getString("Abroad"));// 国外
					corpReport.setConstruction(rs.getString("Construction"));// 建筑工程
					corpReport.setErection(rs.getString("Erection"));// 安装工程
					corpReport.setDecorate(rs.getString("Decorate"));// 装饰装修工程
					corpReport.setSettlementIncome(rs
							.getString("SettlementIncome"));// 工程结算收入
					corpReport
							.setSettlementCost(rs.getString("SettlementCost"));// 工程结算成本
					corpReport.setAddedValue(rs.getString("AddedValue"));// 增加值
					corpReport.setReward(rs.getString("Reward"));// 从业人员劳动报酬
					corpReport.setTotalProfit(rs.getString("TotalProfit"));// 利税总额
					corpReport.setProfit(rs.getString("Profit"));// 利润总额
					corpReport.setEmployee(rs.getString("Employee"));// 从业人员
					corpReport.setRegistered(rs.getString("Registered"));// 注册建造师
					corpReport.setUltimate(rs.getString("Ultimate"));// 中级以上职称人员
					corpReport.setPost(rs.getString("Post"));// 持证岗位人员
					corpReport.setTechnology(rs.getString("Technology"));// 中级以上技术工人
					corpReport.setTechnicalEquipment(rs
							.getString("TechnicalEquipment"));// 技术装备率
					corpReport.setLaborProduction(rs
							.getString("LaborProduction"));// 劳动生产
					corpReport.setLegalMan(rs.getString("LegalMan")); // 单位负责人
					corpReport.setFillOut(rs.getString("FillOut"));// 填表人
					corpReport.setLinkPhone(rs.getString("LinkPhone"));// 联系电话
					corpReport.setCreateDate(rs.getDate("CreateDate")); // 添加日期
					page.getData().add(corpReport);
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

	/**
	 * 查看详细信息
	 */
	@Override
	public CorpReport queryInfo(String id) {
		// TODO Auto-generated method stub
		CorpReport corpReport = new CorpReport();
		try {

			String qsql = "select * from CORP_REPORT where id=?";
			// 获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// 如果基础数据库存在，返回不允许企业再次注册
			if (rs.next()) {
				corpReport.setId(rs.getString("id"));// 主键
				corpReport.setCorpCode(rs.getString("CorpCode"));// 企业组织机构代码
				corpReport.setCorpName(rs.getString("CorpName"));// 企业名称
				corpReport.setProvinceNum(rs.getString("ProvinceNum")); // 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				corpReport.setCityNum(rs.getString("CityNum")); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				corpReport.setCountyNum(rs.getString("CountyNum")); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				corpReport.setReportYear(rs.getString("ReportYear"));// 年
				corpReport.setQuarter(rs.getString("Quarter"));// 季度
				corpReport.setSignContract(rs.getString("SignContract"));// 签订合同额
				corpReport
						.setLastYearContract(rs.getString("LastYearContract"));// 上年结转合同额
				corpReport
						.setThisYearContract(rs.getString("ThisYearContract"));// 本年新签合同额
				corpReport.setTotalOutput(rs.getString("TotalOutput"));// 建筑业总产值
				corpReport.setProvinceOutside(rs.getString("ProvinceOutside"));// 省外
				corpReport.setAbroad(rs.getString("Abroad"));// 国外
				corpReport.setConstruction(rs.getString("Construction"));// 建筑工程
				corpReport.setErection(rs.getString("Erection"));// 安装工程
				corpReport.setDecorate(rs.getString("Decorate"));// 装饰装修工程
				corpReport
						.setSettlementIncome(rs.getString("SettlementIncome"));// 工程结算收入
				corpReport.setSettlementCost(rs.getString("SettlementCost"));// 工程结算成本
				corpReport.setAddedValue(rs.getString("AddedValue"));// 增加值
				corpReport.setReward(rs.getString("Reward"));// 从业人员劳动报酬
				corpReport.setTotalProfit(rs.getString("TotalProfit"));// 利税总额
				corpReport.setProfit(rs.getString("Profit"));// 利润总额
				corpReport.setEmployee(rs.getString("Employee"));// 从业人员
				corpReport.setRegistered(rs.getString("Registered"));// 注册建造师
				corpReport.setUltimate(rs.getString("Ultimate"));// 中级以上职称人员
				corpReport.setPost(rs.getString("Post"));// 持证岗位人员
				corpReport.setTechnology(rs.getString("Technology"));// 中级以上技术工人
				corpReport.setTechnicalEquipment(rs
						.getString("TechnicalEquipment"));// 技术装备率
				corpReport.setLaborProduction(rs.getString("LaborProduction"));// 劳动生产
				corpReport.setLegalMan(rs.getString("LegalMan")); // 单位负责人
				corpReport.setFillOut(rs.getString("FillOut"));// 填表人
				corpReport.setLinkPhone(rs.getString("LinkPhone"));// 联系电话
				corpReport.setCreateDate(rs.getDate("CreateDate")); // 添加日期
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corpReport;
	}

}
