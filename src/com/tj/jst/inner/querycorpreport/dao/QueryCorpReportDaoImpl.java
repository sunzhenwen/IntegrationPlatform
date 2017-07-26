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
 * ��ҵͳ�Ʊ������ݿ���
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
	 * ��ҳ��
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

					corpReport.setId(rs.getString("id"));// ����
					corpReport.setCorpCode(rs.getString("CorpCode"));// ��ҵ��֯��������
					corpReport.setCorpName(rs.getString("CorpName"));// ��ҵ����
					corpReport.setProvinceNum(rs.getString("ProvinceNum")); // ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
					corpReport.setCityNum(rs.getString("CityNum")); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
					corpReport.setCountyNum(rs.getString("CountyNum")); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
					corpReport.setReportYear(rs.getString("ReportYear"));// ��
					corpReport.setQuarter(rs.getString("Quarter"));// ����
					corpReport.setSignContract(rs.getString("SignContract"));// ǩ����ͬ��
					corpReport.setLastYearContract(rs
							.getString("LastYearContract"));// �����ת��ͬ��
					corpReport.setThisYearContract(rs
							.getString("ThisYearContract"));// ������ǩ��ͬ��
					corpReport.setTotalOutput(rs.getString("TotalOutput"));// ����ҵ�ܲ�ֵ
					corpReport.setProvinceOutside(rs
							.getString("ProvinceOutside"));// ʡ��
					corpReport.setAbroad(rs.getString("Abroad"));// ����
					corpReport.setConstruction(rs.getString("Construction"));// ��������
					corpReport.setErection(rs.getString("Erection"));// ��װ����
					corpReport.setDecorate(rs.getString("Decorate"));// װ��װ�޹���
					corpReport.setSettlementIncome(rs
							.getString("SettlementIncome"));// ���̽�������
					corpReport
							.setSettlementCost(rs.getString("SettlementCost"));// ���̽���ɱ�
					corpReport.setAddedValue(rs.getString("AddedValue"));// ����ֵ
					corpReport.setReward(rs.getString("Reward"));// ��ҵ��Ա�Ͷ�����
					corpReport.setTotalProfit(rs.getString("TotalProfit"));// ��˰�ܶ�
					corpReport.setProfit(rs.getString("Profit"));// �����ܶ�
					corpReport.setEmployee(rs.getString("Employee"));// ��ҵ��Ա
					corpReport.setRegistered(rs.getString("Registered"));// ע�Ὠ��ʦ
					corpReport.setUltimate(rs.getString("Ultimate"));// �м�����ְ����Ա
					corpReport.setPost(rs.getString("Post"));// ��֤��λ��Ա
					corpReport.setTechnology(rs.getString("Technology"));// �м����ϼ�������
					corpReport.setTechnicalEquipment(rs
							.getString("TechnicalEquipment"));// ����װ����
					corpReport.setLaborProduction(rs
							.getString("LaborProduction"));// �Ͷ�����
					corpReport.setLegalMan(rs.getString("LegalMan")); // ��λ������
					corpReport.setFillOut(rs.getString("FillOut"));// �����
					corpReport.setLinkPhone(rs.getString("LinkPhone"));// ��ϵ�绰
					corpReport.setCreateDate(rs.getDate("CreateDate")); // �������
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
	 * �鿴��ϸ��Ϣ
	 */
	@Override
	public CorpReport queryInfo(String id) {
		// TODO Auto-generated method stub
		CorpReport corpReport = new CorpReport();
		try {

			String qsql = "select * from CORP_REPORT where id=?";
			// ��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// ����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if (rs.next()) {
				corpReport.setId(rs.getString("id"));// ����
				corpReport.setCorpCode(rs.getString("CorpCode"));// ��ҵ��֯��������
				corpReport.setCorpName(rs.getString("CorpName"));// ��ҵ����
				corpReport.setProvinceNum(rs.getString("ProvinceNum")); // ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				corpReport.setCityNum(rs.getString("CityNum")); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				corpReport.setCountyNum(rs.getString("CountyNum")); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
				corpReport.setReportYear(rs.getString("ReportYear"));// ��
				corpReport.setQuarter(rs.getString("Quarter"));// ����
				corpReport.setSignContract(rs.getString("SignContract"));// ǩ����ͬ��
				corpReport
						.setLastYearContract(rs.getString("LastYearContract"));// �����ת��ͬ��
				corpReport
						.setThisYearContract(rs.getString("ThisYearContract"));// ������ǩ��ͬ��
				corpReport.setTotalOutput(rs.getString("TotalOutput"));// ����ҵ�ܲ�ֵ
				corpReport.setProvinceOutside(rs.getString("ProvinceOutside"));// ʡ��
				corpReport.setAbroad(rs.getString("Abroad"));// ����
				corpReport.setConstruction(rs.getString("Construction"));// ��������
				corpReport.setErection(rs.getString("Erection"));// ��װ����
				corpReport.setDecorate(rs.getString("Decorate"));// װ��װ�޹���
				corpReport
						.setSettlementIncome(rs.getString("SettlementIncome"));// ���̽�������
				corpReport.setSettlementCost(rs.getString("SettlementCost"));// ���̽���ɱ�
				corpReport.setAddedValue(rs.getString("AddedValue"));// ����ֵ
				corpReport.setReward(rs.getString("Reward"));// ��ҵ��Ա�Ͷ�����
				corpReport.setTotalProfit(rs.getString("TotalProfit"));// ��˰�ܶ�
				corpReport.setProfit(rs.getString("Profit"));// �����ܶ�
				corpReport.setEmployee(rs.getString("Employee"));// ��ҵ��Ա
				corpReport.setRegistered(rs.getString("Registered"));// ע�Ὠ��ʦ
				corpReport.setUltimate(rs.getString("Ultimate"));// �м�����ְ����Ա
				corpReport.setPost(rs.getString("Post"));// ��֤��λ��Ա
				corpReport.setTechnology(rs.getString("Technology"));// �м����ϼ�������
				corpReport.setTechnicalEquipment(rs
						.getString("TechnicalEquipment"));// ����װ����
				corpReport.setLaborProduction(rs.getString("LaborProduction"));// �Ͷ�����
				corpReport.setLegalMan(rs.getString("LegalMan")); // ��λ������
				corpReport.setFillOut(rs.getString("FillOut"));// �����
				corpReport.setLinkPhone(rs.getString("LinkPhone"));// ��ϵ�绰
				corpReport.setCreateDate(rs.getDate("CreateDate")); // �������
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corpReport;
	}

}
